package ParcialesArboles;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles1 {
	GeneralTree<Integer> arbol;
	
	public ParcialArboles1(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public static List<Integer> caminoParidadAlternante(GeneralTree<Integer> arbol){
		List<Integer> caminoMaximo = new LinkedList<>();
		
		if(arbol != null && !arbol.isEmpty()) {
			List<Integer> caminoActual = new LinkedList<>();
			helper(arbol, caminoMaximo, caminoActual);
		}
		return caminoMaximo;
	}
	
	private static void helper(GeneralTree<Integer> arbol, List<Integer> caminoMaximo, List<Integer>actual) {
			actual.add(arbol.getData());
			if(arbol.isLeaf() && actual.size() > caminoMaximo.size()) {
				caminoMaximo.clear();
				caminoMaximo.addAll(actual);
			}
			for(GeneralTree<Integer> child : arbol.getChildren()) {
				if(arbol.getData() % 2 == 0 && child.getData()  % 2 != 0 || arbol.getData() % 2 != 0 && child.getData() % 2 == 0) {
					helper(child,caminoMaximo,actual);
				}
			}
			actual.remove(actual.size()-1);
		}
	
}
