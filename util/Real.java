package util;



public class Real {
	
	private int centavos;
	
	
	public Real(int valorEmCentavos) {
		this.centavos = valorEmCentavos;
	}
	
	public Real(String strValor) {
		
		int posicaoDaVirgula=strValor.indexOf(",");
		
		if (posicaoDaVirgula<0) {
			this.centavos=( Integer.parseInt(strValor) )*100;
		}else {
			if(strValor.length()>(posicaoDaVirgula+3)) {
				
				throw new IllegalArgumentException("O maximo que conseguimos armazernar em valor de Reais é a unidade de centavos");
			}
			 
			String strAntesDaVirgula=strValor.substring(0, posicaoDaVirgula);
			String strDepoisDaVirgula=strValor.substring(posicaoDaVirgula+1);
			
			int reais=Integer.parseInt(strAntesDaVirgula);
			int centavos=Integer.parseInt(strDepoisDaVirgula);
			
			this.centavos=centavos+(reais*100);
			
		}
		
	}
	
	
	public Real adicionar(Real valor) {
		int centavosTotais = this.centavos+valor.centavos;
		return new Real(centavosTotais);
	}
	
	
	public Real subtrair(Real valor) {
		int centavosTotais = this.centavos-valor.centavos;
		return new Real(centavosTotais);
	}

	
	public boolean ehMaiorQue(Real valor) { // tipo if-else mais leve.
		return (this.centavos>valor.centavos);
	}
	
	
	public boolean ehMaiorOuIgualQue(Real valor) { 
		return (this.centavos>=valor.centavos);
	}

	
	public boolean ehMenorQue(Real valor) {
		return (this.centavos<valor.centavos);
	}
	
	
	public boolean ehMenorOuIgualQue(Real valor) {
		return (this.centavos<=valor.centavos);
	}
	
	
	public String toString() {
		String rSifrao="R$ ";
		int reais=centavos/100;
		char virgula=',';
		int centavosRestantes=centavos%100;
		
		return rSifrao+reais+virgula+centavosRestantes;
	}
	
	
	public Real dividir(int quantidade) {
		int quocienteEmCentavos = this.centavos/quantidade;
		
		return new Real (quocienteEmCentavos);	
	}
	
	
	public Real porcentagem(int porcentagem) {
		int centavosTotais = this.centavos / 100;
		return new Real (centavosTotais);
	}
	
	public int getCentavos() {
		int centavos = this.centavos /100;
		return centavos;
	}
	
}