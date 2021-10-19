package modelo;

public class Gerente extends Funcionario {
	private boolean superGerente;
	
	

	public Gerente(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro,
			int cep, int numeroDaResidencia, byte ddi, byte ddd, int telefone) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone);
		
	}



	public Gerente(long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro, int cep,
			int numeroDaResidencia, byte ddi, byte ddd, int telefone) {
		super(cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone);
		
	}



	public boolean isSuperGerente() {
		return superGerente;
	}
	
}
