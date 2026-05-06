package ParcialesArboles;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {
	
	public static List<Integer> caminoParidadAlternante(GeneralTree<Integer> arbol){
		List<Integer> caminoMaximo = new LinkedList<>();
		
		if(arbol != null && !arbol.isEmpty()) {
			List<Integer> caminoActual = new LinkedList<>();
			helper(arbol, caminoMaximo, caminoActual);
		}
		return caminoMaximo;
	}
	
	private static void helper(GeneralTree<Integer> arbol, List<Integer> caminoMaximo, List<Integer>actual) {
		boolean puedoEntrar = false;
		if(actual.isEmpty()) {
			puedoEntrar = true;
		}else {
			if(actual != null) {
				int anterior = actual.get(actual.size()-1);
				int act = arbol.getData();
				if(anterior % 2 == 0 && act  % 2 != 0 || anterior % 2 != 0 && act % 2 == 0) {
					puedoEntrar = true;
				}
			}
		}
		if(puedoEntrar) {
			actual.add(arbol.getData());
			if(arbol.isLeaf() && actual.size() > caminoMaximo.size()) {
				caminoMaximo.clear();
				caminoMaximo.addAll(actual);
			}
			for(GeneralTree<Integer> child : arbol.getChildren()) {
				helper(child,caminoMaximo,actual);
			}

			actual.remove(actual.size()-1);
		}
	}
}
