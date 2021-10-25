package teste.jUnit;

import java.lang.reflect.Field;
import java.util.List;



public class ConteudoTabelaDB <E> {
	
	private List<E> registros;
	private Class <E> classeModelo;
	
	public ConteudoTabelaDB(Class <E> clazz, List<E> registros){
		this.classeModelo = clazz;
		this.registros = registros;
	}
	
	public List<E> getRegistros(){
		return registros;
	}
	
	public Class<E> getClasseModelo() {
		return classeModelo;
	}
	
	public String gerarComandosDeInsert() {
		
		StringBuilder sb= new StringBuilder();
		
		Field atributos[] = classeModelo.getDeclaredFields();
		
		String nomeDaTabela = classeModelo.getName(); 
		
		for (Object registro : this.registros) {
			sb.append("INSERT INTO ");
			sb.append(nomeDaTabela);
			sb.append(" ( ");
			
			for (Field field : atributos) {
				sb.append(field.getName());
				sb.append(", ");
			}
			
			sb.deleteCharAt(sb.length()-1);
			sb.append(" ) VALUES ( ");
			
			for (Field field : atributos) {		
				try {
					sb.append(field.get(registro));
					sb.append(", ");
				} catch (IllegalArgumentException | IllegalAccessException e) {
					
					throw new RuntimeException("Dificuldade em ler atributos com reflexão");
				}
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append(" );\n");
			
			
		}
			
			
			
			
			
		return sb.toString();
	}

	
	
}
