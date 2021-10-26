package view.Venda;

import javax.swing.JButton;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import modelo.ItemDeVenda;
import modelo.Produto;
import modelo.Venda;

public class ModeloDeTabelaVenda implements TableModel{
	
	Venda venda;

	public ModeloDeTabelaVenda(Venda venda) {
		super();
		this.venda = venda;
	}

	@Override
	public int getRowCount() {
		return venda.getItensDeVenda().size();
	}

	@Override
	public int getColumnCount() {	
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex){
		case 0:
			return "ID Produto ";
		case 1:
			return "Nome ";
		***
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 5) {
			return JButton.class;
		}else { 
			return String.class;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ItemDeVenda itemDeVenda = venda.getItensDeVenda().get(rowIndex); 
		switch(columnIndex) {
		case 0:
			return itemDeVenda.getProduto().getId();
		case 1:
			return itemDeVenda.getProduto().getNome();
		case 2:
			return itemDeVenda.getQuantidade();
		case 3:
			return itemDeVenda.getProduto().getPreco().toString();
		case 4:
			return itemDeVenda.getProduto().getPreco().multiplicar(itemDeVenda.getQuantidade()).toString();
		default:
			return new JButton();
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	
	public void setarQuantidadeDoItemDeVenda(ItemDeVenda itemDeVenda, int quantidade) {
		
	}
	
	public void adicionarItemDeVenda(ItemDeVenda itemDeVenda) {
		
	}
	
	public void removerItemDeVenda(ItemDeVenda itemDeVenda) {
		
	}
	
}
