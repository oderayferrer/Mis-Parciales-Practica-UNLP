package ParcialesArboles;

import java.util.List;

public class Recurso {
	List<Integer> lista;
	int cantidadImpares;
	
	public Recurso(List<Integer> lista, int cantidadImpares) {
		this.lista = lista;
		this.cantidadImpares = cantidadImpares;
	}

	public List<Integer> getLista() {
		return lista;
	}

	public void setLista(List<Integer> lista) {
		this.lista = lista;
	}

	public int getCantidadImpares() {
		return cantidadImpares;
	}

	public void setCantidadImpares(int cantidadImpares) {
		this.cantidadImpares = cantidadImpares;
	}
	
	
}
