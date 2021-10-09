package modelo;

public class Gerente extends Funcionario {
	private boolean superGerente;
	
	public Gerente(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro, int cep, int numeroDaResidencia, boolean ativo, boolean superGerente) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ativo);
		this.superGerente = superGerente;
	}

	public Gerente(long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro, int cep, int numeroDaResidencia) {
		super(cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
	}

	public boolean isSuperGerente() {
		return superGerente;
	}
	
}
