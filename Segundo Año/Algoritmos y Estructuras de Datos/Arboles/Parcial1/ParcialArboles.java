package ParcialesArboles;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {
	public static List<Integer> caminoSignoAlternante(GeneralTree<Integer> arbol){
		List<Integer> caminoMayorCosto = new LinkedList<>();
		
		if(arbol != null && !arbol.isEmpty()) {
			List<Integer> caminoActual = new LinkedList<>();
			int valorMax=-1;
			helper(arbol,caminoMayorCosto,caminoActual,0,valorMax);
		}
		return caminoMayorCosto;
	}
	
	private static int helper(GeneralTree<Integer> arbol, List<Integer> caminoMayorCosto, List<Integer> actual, int costoActual,int valorMax) {

			actual.add(arbol.getData());
			costoActual += arbol.getData();
			
			if(arbol.isLeaf()) {
				if(costoActual > valorMax) {
					caminoMayorCosto.clear();
					caminoMayorCosto.addAll(actual);
					valorMax = costoActual;
				}
			}
			for(GeneralTree<Integer> child : arbol.getChildren()) {
				if(arbol.getData() >= 0 && child.getData() < 0 || arbol.getData() < 0 && child.getData() >= 0) {
					valorMax = helper(child,caminoMayorCosto,actual,costoActual,valorMax);
				}	
			}
			actual.remove(actual.size() -1);
			return valorMax;
	}
	
}
