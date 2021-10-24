package teste.jUnit;

import java.util.Map;

public interface RegistrosBD {

	public <T> Map <Class<T>, ConteudoTabelaDB<T>> obterRegistros();
}
