package ParcialesArboles;

import java.util.LinkedList;
import java.util.List;

public class ProcesadorArbol {
	BinaryTree<Integer> arbol;
	
	public ProcesadorArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public Recurso1 procesar(BinaryTree<Integer> arbol) {
		int cant =0;
		List<Integer> lista = new LinkedList<>();
		if(arbol != null && !arbol.isEmpty()) {
			cant = helperProcesar(arbol,lista);
		}
		return new Recurso(lista,cant);
	}
	
	private int helperProcesar(BinaryTree<Integer> arbol, List<Integer> lista) {
		int contador =0;
		if(arbol!= null && !arbol.isEmpty()) {
			if(arbol.hasLeftChild()) {
				contador+= helperProcesar(arbol.getLeftChild(),lista);
			}
			if(arbol.hasRightChild()) {
				contador+= helperProcesar(arbol.getRightChild(),lista);
			}
			if(arbol.getData() % 2 != 0) {
				lista.add(arbol.getData());
			}
		}
		
		return contador;
	}
}
