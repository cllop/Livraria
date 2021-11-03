package modelo;

import java.util.Date;
import java.util.List;

import util.Real;

public class Venda {		
	private int id;
	private Date data;
	private Vendedor vendedor; 
	private Cliente cliente;
	private Caixa caixa;
	private List<ItemDeVenda> itensDeVenda;
	private List<Pagamento> pagamentos;
    
	public Venda(int id, Date data, Vendedor vendedor, Cliente cliente, Caixa caixa, List<ItemDeVenda> itensDeVenda, List<Pagamento> pagamentos) {
    	this.id = id;
    	this.data = data;
    	this.vendedor = vendedor;
    	this.cliente = cliente;
    	this.caixa = caixa;
    	this.itensDeVenda = itensDeVenda;
    	this.pagamentos = pagamentos;
    }
    
    
    
    public Venda(Vendedor vendedor, Cliente cliente, Caixa caixa) {
		super();
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.caixa = caixa;
	}



	public int getId() {
    	return id;
    } 
    
    public Date getData() {
    	return data;
    }

    public Vendedor getVendedor() {
    	return vendedor;
    }

    public Cliente getCliente() {
    	return cliente;
    	
    }
    
    public Caixa getCaixa() {
    	return caixa;
    	
    }
    
    public List<ItemDeVenda> getItensDeVenda() {
    	return itensDeVenda;
    }
    
    public List<Pagamento> getPagamento() {
    	return pagamentos;
    }
    
    public Real getValorASerPago() {
    	Real totalASerPago = new Real(0);
    	for(ItemDeVenda itemDeVenda : itensDeVenda) {
    		totalASerPago = totalASerPago.adicionar(itemDeVenda.getTotal());
    	}
    	return totalASerPago;
    }
    
    public Real getValorPago() {
    	Real valorPago = new Real(0);
    	for(Pagamento pagamento : pagamentos) {
    		valorPago = valorPago.adicionar(pagamento.getValor());
    	}
    	return valorPago;
    }
    
    
    
    public boolean estaCompletamentePaga() {
    	return getValorASerPago().equals(getValorPago());
    }

}

