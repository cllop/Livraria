package modelo;

public class Funcionario extends Usuario{
	private boolean ativo;

	
	public Funcionario(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro, int cep, int numeroDaResidencia, boolean ativo) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
		this.ativo = ativo;
	}

	public Funcionario(long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro, int cep, int numeroDaResidencia) {
		super(cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia);
	}

	public boolean isAtivo() {
		return ativo;
	}
	
}
