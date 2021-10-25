package modelo;

import java.util.Date;
import java.util.List;

public class Venda {		
	private int id;
	private Date data;
	private Vendedor vendedor; 
	private Cliente cliente;
	private Caixa caixa;
	private ItemDeVenda itemDeVenda;
	private List<Pagamento> pagamentos;
    
	public Venda(int id, Date data, Vendedor vendedor, Cliente cliente, Caixa caixa, ItemDeVenda itemDeVenda, List<Pagamento> Pagamentos) {
    	this.id = id;
    	this.data = data;
    	this.vendedor = vendedor;
    	this.cliente = cliente;
    	this.caixa = caixa;
    	this.itemDeVenda = itemDeVenda;
    	this.pagamentos = pagamentos;
    }
    
    public Venda(Caixa caixa) {
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
    
    public ItemDeVenda getItemDeVenda() {
    	return itemDeVenda;
    }
    
    public List<Pagamento> getPagamento() {
    	return pagamentos;
    }

    public void setId (int id) {
    	
    }

    public void setData (Date data) {
    	
    }

    public void setVendedor (Vendedor vendedor) {
    	
    }

    public void setCliente (Cliente cliente) {
    	
    }
    
    public void setCaixa (Caixa caixa) {
    	
    }
    
    public void setItemDeVenda (ItemDeVenda itemDeVenda) {
    	
    	
    }

    public void setPagamentos (List<Pagamento> pagamentos){ 
    	
    }
}

