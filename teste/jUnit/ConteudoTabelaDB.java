package teste.jUnit;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import anotacoes.AnotacaoTabela;
import anotacoes.TabelaInexistente;
import util.Real;

public class ConteudoTabelaDB<E> {

	private List<E> registros;
	private Class<E> classeModelo;

	public ConteudoTabelaDB(Class<E> clazz, List<E> registros) {
		this.classeModelo = clazz;
		this.registros = registros;
	}

	public List<E> getRegistros() {
		return registros;
	}

	public Class<E> getClasseModelo() {
		return classeModelo;
	}

	public boolean temIdnessaClasse(Class classe) {
		Field atributos[] = classe.getDeclaredFields();

		for (Field atributo : atributos) {
			if (atributo.getName().equals("id")) {
				return true;
			}
		}
		return false;
	}

	private Field getAtributoIdNaClasse(Class classe) {
		Field atributos[] = classe.getDeclaredFields();

		for (Field atributo : atributos) {

			if (atributo.getName().equals("id")) {

				return atributo;
			}
		}
		return null;
	}

	private Field getIdNasClasseaAncestrais(Class classe) {
		List<Class> listaDeClassesAncestrais = getClassesAncestrais(classe);

		for (Class classeAncestral : listaDeClassesAncestrais) {
			Field atributoId = getAtributoIdNaClasse(classeAncestral);
			if (atributoId != null) {
				return atributoId;
			}
		}
		return null;
	}

	public String gerarComandosDeInsert() {
		StringBuilder sb = new StringBuilder();
		// gerar inserts da superclasse
		List<Class> tabelasAncestrais = getTabelasAncestrais(classeModelo);

		for (Class classeAncestral : tabelasAncestrais) {
			sb.append(gerarComandosDeInsert(this.registros, classeAncestral));

		}
		sb.append(gerarComandosDeInsert(registros, classeModelo));
		return sb.toString();
	}

	private static List<Class> getClassesAncestrais(Class classe) {
		List<Class> listaDeClassesAncestrais = new ArrayList<>();

		Class calsseAncestral = classe.getSuperclass();

		while (!Object.class.equals(calsseAncestral)) {

			listaDeClassesAncestrais.add(calsseAncestral);
			calsseAncestral = calsseAncestral.getSuperclass();
		}
		return listaDeClassesAncestrais;
	}

	private String gerarComandosDeInsert(List registros, Class classe) {
		List<Class> listaDeTiposAceitos = Arrays.asList(byte.class, short.class, int.class, long.class, float.class,
				double.class, boolean.class, char.class, String.class, Real.class);

		StringBuilder sb = new StringBuilder();

		List<Field> atributos = getAtributosDaTabela(classe);

		String nomeDaTabela = nomeDaTabela(classe);

		for (Object registro : this.registros) {
			sb.append("INSERT INTO ");
			sb.append(nomeDaTabela);
			sb.append(" ( ");

			if (!temIdnessaClasse(classe)) {

				Field atributoId = getIdNasClasseaAncestrais(classe);

				if (atributoId != null && listaDeTiposAceitos.contains(atributoId.getType())) {
					sb.append("id, ");

				} else {

					throw new UnsupportedOperationException();
				}
			}

			for (Field field : atributos) {
				Class classeDoAtributo = field.getType();
				if (listaDeTiposAceitos.contains(classeDoAtributo)) {
					sb.append(field.getName());
					sb.append(", ");
				}

			}

			sb.deleteCharAt(sb.length() - 2);
			sb.append(" ) VALUES ( ");

			if (!temIdnessaClasse(classe)) {
				try {
					Field atributoId = getIdNasClasseaAncestrais(classe);
					
					atributoId.setAccessible(true);
	
					if (atributoId != null && listaDeTiposAceitos.contains(atributoId.getType())) {
						if (atributoId.getType() == char.class || atributoId.getType() == String.class) {
							sb.append('\'');
							sb.append(atributoId.get(registro));
							sb.append("', ");
	
						}else if(atributoId.getType()== boolean.class){
							if(atributoId.getBoolean(registro)) {
								sb.append("1, ");
							}else {
								sb.append("0, ");
							}
						}else {
							sb.append(atributoId.get(registro));
							sb.append(", ");
						}
	
					}else {
						throw new UnsupportedOperationException();
					}
				}catch (IllegalArgumentException | IllegalAccessException e) {

					throw new RuntimeException("Dificuldade em ler atributos com reflexão");
				}

			}

			for (Field field : atributos) {
				try {
					Class classeDoAtributo = field.getType();
					field.setAccessible(true);

					if (listaDeTiposAceitos.contains(classeDoAtributo)) {
						if (classeDoAtributo == char.class || classeDoAtributo == String.class) {
							sb.append('\'');
							sb.append(field.get(registro));
							sb.append('\'');
							sb.append(", ");
						} else if(classeDoAtributo == Real.class){
							sb.append(((Real)field.get(registro)).getCentavos());
							sb.append(", ");
						}else {
							sb.append(field.get(registro));
							sb.append(", ");
						}
					}

				} catch (IllegalArgumentException | IllegalAccessException e) {

					throw new RuntimeException("Dificuldade em ler atributos com reflexão");
				}
			}
			sb.deleteCharAt(sb.length() - 2);
			sb.append(" );\n");

		}

		return sb.toString();

	}
	private static String nomeDaTabela(Class classe) {
		AnotacaoTabela anotacaoTabela = (AnotacaoTabela) classe.getAnnotation(AnotacaoTabela.class);
		if(anotacaoTabela==null) {
			return classe.getSimpleName();
		}else {
			return anotacaoTabela.getNome();
		}
	}
	
	private static List<Field> getAtributosDaTabela(Class classe){
		List<Field> atributosDaTabela = new ArrayList<>();
		atributosDaTabela.addAll(Arrays.asList(classe.getDeclaredFields()));
		List<Class> listaDeClassesAncestrais = getClassesAncestrais(classe);
		int i=0;
		
		while(i<listaDeClassesAncestrais.size()&&listaDeClassesAncestrais.get(i).getAnnotation(TabelaInexistente.class)!=null) {
			atributosDaTabela.addAll(Arrays.asList(listaDeClassesAncestrais.get(i).getDeclaredFields()));
			i++;
		}
		return atributosDaTabela;
	}
	
	private static List<Class> getTabelasAncestrais(Class classe) {
		List<Class> tabelasAncestrais = new ArrayList<>();
		List<Class> classesAncestrais = getClassesAncestrais(classe);
		
		for(Class classeAncestral : classesAncestrais) {
			if(classeAncestral.getAnnotation(TabelaInexistente.class)==null) {
				tabelasAncestrais.add(classeAncestral);
			}
		}
		return tabelasAncestrais;
	}
}
