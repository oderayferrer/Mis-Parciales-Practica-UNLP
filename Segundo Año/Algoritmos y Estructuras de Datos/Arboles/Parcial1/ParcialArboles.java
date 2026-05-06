package ParcialesArboles;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {
	public static List<Integer> caminoSignoAlternante(GeneralTree<Integer> arbol){
		List<Integer> caminoMayorCosto = new LinkedList<>();
		
		if(arbol != null && !arbol.isEmpty()) {
			List<Integer> caminoActual = new LinkedList<>();
			helper(arbol,caminoMayorCosto,caminoActual,0);
		}
		return caminoMayorCosto;
	}
	
	private static void helper(GeneralTree<Integer> arbol, List<Integer> caminoMayorCosto, List<Integer> actual, int costoActual) {
		boolean puedoEntrar = false;
		if(actual.isEmpty()) {
			puedoEntrar = true;
		}else {
			int anterior = actual.get(actual.size()-1);
			int act = arbol.getData();
			if(anterior >= 0 && act < 0 || anterior < 0 && act >= 0) {
				puedoEntrar = true;
				}
		}
		if(puedoEntrar) {
			actual.add(arbol.getData());
			costoActual += arbol.getData();
			
			if(arbol.isLeaf()) {
				if(caminoMayorCosto.isEmpty() || costoActual > sumarCosto(caminoMayorCosto)) {
					caminoMayorCosto.clear();
					caminoMayorCosto.addAll(actual);
				}
			}
			for(GeneralTree<Integer> child : arbol.getChildren()) {
				helper(child,caminoMayorCosto,actual,costoActual);
			}
			actual.remove(actual.size() -1);
		}
	}
	
	private static int sumarCosto(List<Integer> lista) {
		int suma = 0;
		for(int num: lista) {
			suma+= num;
		}
		return suma;
	}
}
