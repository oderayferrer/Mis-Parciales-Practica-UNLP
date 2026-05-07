package ParcialesArboles;

public class Parcial {
	
	public int sumaImparesPostOrdenMayorA(BinaryTree<Integer> arbol, int limite){
		int suma = helperSuma(arbol,limite);
		return suma;
		
	}
	
	private int helperSuma(BinaryTree<Integer> arbol, int limite) {
		int suma = 0;
		if(arbol != null && !arbol.isEmpty()) {
			if(arbol.hasLeftChild()) {
				suma+= helperSuma(arbol.getLeftChild(),limite);
			}
			if(arbol.hasRightChild()) {
				suma+= helperSuma(arbol.getRightChild(), limite);
			}
			int miDato = arbol.getData();
			if(miDato % 2 != 0 && miDato > limite) {
				suma+= miDato;
			}
		}
		return suma;
	}
	public class MainParcial {
	    public static void main(String[] args) {
	        // 1. Creación de todos los nodos según la imagen
	        BinaryTree<Integer> a7 = new BinaryTree<>(7);
	        BinaryTree<Integer> a56 = new BinaryTree<>(56);
	        BinaryTree<Integer> a25 = new BinaryTree<>(25);
	        BinaryTree<Integer> a38 = new BinaryTree<>(38);
	        BinaryTree<Integer> a31 = new BinaryTree<>(31);
	        BinaryTree<Integer> a5 = new BinaryTree<>(5);
	        BinaryTree<Integer> a6 = new BinaryTree<>(6);
	        BinaryTree<Integer> a87 = new BinaryTree<>(87);
	        BinaryTree<Integer> a77 = new BinaryTree<>(77);
	        BinaryTree<Integer> a94 = new BinaryTree<>(94);
	        BinaryTree<Integer> a16 = new BinaryTree<>(16);
	        BinaryTree<Integer> a2 = new BinaryTree<>(2);
	        BinaryTree<Integer> a43 = new BinaryTree<>(43);
	        BinaryTree<Integer> a1 = new BinaryTree<>(1);
	        BinaryTree<Integer> a9 = new BinaryTree<>(9);
	        BinaryTree<Integer> a10 = new BinaryTree<>(10);

	        // 2. Armado de la estructura por niveles
	        // Nivel 0 -> 1
	        a7.addLeftChild(a56);
	        a7.addRightChild(a25);

	        // Nivel 1 -> 2
	        a56.addLeftChild(a38);
	        a56.addRightChild(a31);
	        
	        a25.addLeftChild(a5);
	        a25.addRightChild(a6);

	        // Nivel 2 -> 3
	        a38.addLeftChild(a87);
	        a38.addRightChild(a77);
	        
	        a31.addRightChild(a94); // El 31 solo tiene hijo derecho

	        // Nivel 3 -> 4
	        a77.addLeftChild(a16);
	        
	        a94.addRightChild(a2); // El 94 solo tiene hijo derecho

	        // Nivel 4 -> 5
	        a16.addRightChild(a43); // El 16 solo tiene hijo derecho
	        
	        a2.addLeftChild(a1); // El 2 solo tiene hijo izquierdo

	        // Nivel 5 -> 6
	        a43.addLeftChild(a9);
	        a43.addRightChild(a10);

	        // 3. Instancia y Prueba
	        Parcial parcial = new Parcial();
	        int limite = 30;
	        int resultado = parcial.sumaImparesPostOrdenMayorA(a7, limite);

	        // 4. Verificación de resultados según el enunciado
	        System.out.println("--- Prueba Parcial Modulo 1 - 2022 ---");
	        System.out.println("Límite: " + limite);
	        System.out.println("Resultado: " + resultado);
	        System.out.println("Esperado: 238 (87 + 43 + 77 + 31)");
	        
	        if (resultado == 238) {
	            System.out.println("✅ ¡Excelente! La lógica PostOrden funciona correctamente.");
	        } else {
	            System.out.println("❌ Hay una diferencia en la suma. Revisa las condiciones.");
	        }
	    }
	}
}
