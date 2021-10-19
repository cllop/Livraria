package modelo;

public class Funcionario extends Usuario{
	private boolean ativo;

	
	
	public Funcionario(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro,
			int cep, int numeroDaResidencia, byte ddi, byte ddd, int telefone) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone);
		ativo = true;
	}



	public Funcionario(long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro,
			int cep, int numeroDaResidencia, byte ddi, byte ddd, int telefone) {
		super(cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone);
		ativo = true;
	}



	public boolean isAtivo() {
		return ativo;
	}
	
}
