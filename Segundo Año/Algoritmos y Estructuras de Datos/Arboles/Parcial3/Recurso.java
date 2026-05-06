package ParcialesArboles;

import java.util.List;

public class Recurso {
	List<BinaryTree<Integer>> lista;
	int cantidad;
	public Recurso(List<BinaryTree<Integer>> lista, int cantidad) {
		this.lista = lista;
		this.cantidad = cantidad;
	}
	public List<BinaryTree<Integer>> getLista() {
		return lista;
	}
	public void setLista(List<BinaryTree<Integer>> lista) {
		this.lista = lista;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
