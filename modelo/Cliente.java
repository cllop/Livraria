package modelo;

public class Cliente extends Usuario{
	
	private int idCliente;
	
	public Cliente(int id, int idCliente, long cpf, String nome, String sobrenome, String nomeDeUsuario, String pais, String estado,
			String cidade, String rua, String bairro, int cep, int numeroDaResidencia, byte ddi, byte ddd,
			int telefone) {
		super(id, cpf, nome, sobrenome, nomeDeUsuario, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi, ddd,
				telefone);
		this.idCliente = idCliente;
	}

	public Cliente(long cpf, String nome, String sobrenome, String nomeDeUsuario, String pais, String estado,
			String cidade, String rua, String bairro, int cep, int numeroDaResidencia, byte ddi, byte ddd,
			int telefone) {
		super(cpf, nome, sobrenome, nomeDeUsuario, pais, estado, cidade, rua, bairro, cep, numeroDaResidencia, ddi, ddd,
				telefone);
	}	
}