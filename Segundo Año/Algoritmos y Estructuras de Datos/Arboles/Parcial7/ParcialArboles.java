package ParcialesArboles;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles3 {
	
	public List<Integer> caminoMasLargo(GeneralTree<Integer> arbol){
		List<Integer> lista = new LinkedList<>();
		if(arbol != null && !arbol.isEmpty()) {
			List<Integer> caminoActual = new LinkedList<>();
			helper(arbol,lista,caminoActual);
		}
		return lista;
	}
	
	private void helper(GeneralTree<Integer> arbol, List<Integer>lista, List<Integer> actual) {
		if(arbol != null && !arbol.isEmpty()) {
			actual.add(arbol.getData());
			if(arbol.isLeaf()) {
				if(actual.size() > lista.size()) {
					lista.clear();
					lista.addAll(actual);
				}
			}
			if(arbol.hasChildren()) {
				for(GeneralTree<Integer> child : arbol.getChildren()) {
					helper(child,lista,actual);
					}
				}
			actual.remove(actual.size()-1);
		}
		
	}
	
	public class MainCaminoLargo {
	    public static void main(String[] args) {
	        // 1. Creamos los nodos del árbol general
	        GeneralTree<Integer> a8 = new GeneralTree<>(8);
	        GeneralTree<Integer> a3 = new GeneralTree<>(3);
	        GeneralTree<Integer> a5 = new GeneralTree<>(5);
	        GeneralTree<Integer> a4 = new GeneralTree<>(4);
	        GeneralTree<Integer> a7 = new GeneralTree<>(7);
	        GeneralTree<Integer> a6 = new GeneralTree<>(6);
	        GeneralTree<Integer> a1 = new GeneralTree<>(1);
	        GeneralTree<Integer> a9 = new GeneralTree<>(9);
	        GeneralTree<Integer> a10 = new GeneralTree<>(10);
	        GeneralTree<Integer> a2 = new GeneralTree<>(2);

	        // 2. Armamos la estructura de la imagen
	        // Hijos de 8
	        a8.addChild(a3);
	        a8.addChild(a5);

	        // Hijos de 3
	        a3.addChild(a4);
	        a3.addChild(a7);
	        a3.addChild(a6);

	        // Hijos de 5
	        a5.addChild(a1);
	        a5.addChild(a9);
	        a5.addChild(a10);

	        // Hijo de 7
	        a7.addChild(a2);

	        // 3. Ejecutamos el método
	        ParcialArboles3 parcial = new ParcialArboles3();
	        List<Integer> resultado = parcial.caminoMasLargo(a8);

	        // 4. Verificación
	        System.out.println("--- Prueba Camino a la Hoja más Lejana ---");
	        System.out.println("Camino encontrado: " + resultado);
	        System.out.println("Esperado: [8, 3, 7, 2]");
	        
	        if (resultado.toString().equals("[8, 3, 7, 2]")) {
	            System.out.println("✅ ¡Correcto! Es el camino más largo.");
	        } else {
	            System.out.println("❌ El camino no es el esperado.");
	        }
	    }
	}
}
