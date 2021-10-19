package modelo;

public class Cliente extends Usuario{

	public Cliente(int id, long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro,
			int cep, int numeroDaResidencia, byte ddi, byte ddd, int telefone) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone);
		// TODO Auto-generated constructor stub
	}

	public Cliente(long cpf, String nome, String sobrenome, String nomeDeUsuario, String rua, String bairro, int cep,
			int numeroDaResidencia, byte ddi, byte ddd, int telefone) {
		super(cpf, nome, sobrenome, nomeDeUsuario, rua, bairro, cep, numeroDaResidencia, ddi, ddd, telefone);
		// TODO Auto-generated constructor stub
	}

	
	
}


