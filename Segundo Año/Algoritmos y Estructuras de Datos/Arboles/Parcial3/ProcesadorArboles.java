package ParcialesArboles;

import java.util.LinkedList;
import java.util.List;

public class ProcesadorArboles {
	BinaryTree<Integer> arbol;
	
	public ProcesadorArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public Recurso procesar(BinaryTree<Integer> arbol) {
		int cant=0;
		List<BinaryTree<Integer>> lista = new LinkedList<>();
		if(arbol != null && !arbol.isEmpty()) {
			cant = helperProcesar(arbol,lista);
		}
		return new Recurso(lista,cant);
	}
	
	private int helperProcesar(BinaryTree<Integer> arbol, List<BinaryTree<Integer>> lista) {
		int contador = 0;
		if(arbol != null && !arbol.isEmpty()) {
			if(arbol.getData() % 2 ==0) {
				contador++;
			}
			if(arbol.hasLeftChild() && arbol.hasRightChild()) {
				lista.add(arbol);
			}
			if(arbol.hasLeftChild()) {
				contador+= helperProcesar(arbol.getLeftChild(),lista);
			}
			if(arbol.hasRightChild()) {
				contador+= helperProcesar(arbol.getRightChild(),lista);
			}
		}
		
		return contador;
	}
}
