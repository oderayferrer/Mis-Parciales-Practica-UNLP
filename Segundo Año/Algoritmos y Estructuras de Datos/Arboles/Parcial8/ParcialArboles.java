package ParcialesArboles;

public class ParcialArboles {
	BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol=arbol;
	}
	
	public BinaryTree<Integer> nuevoTree(){
		BinaryTree<Integer> nuevoArbol = new BinaryTree<Integer>();
		if(this.arbol != null && !this.arbol.isEmpty()) {
			helper(this.arbol, nuevoArbol, 0);
		}
		return nuevoArbol;
	}
	
	
	private void helper(BinaryTree<Integer> arbol, BinaryTree<Integer> nuevoArbol, int num){
		int dato = arbol.getData();
		nuevoArbol.setData(arbol.getData() + num);
		
		if(arbol.hasLeftChild()) {
			nuevoArbol.addLeftChild(new BinaryTree<Integer>());
			helper(arbol.getLeftChild(), nuevoArbol.getLeftChild(),dato);
		}
		if(arbol.hasRightChild()) {
			nuevoArbol.addRightChild(new BinaryTree<Integer>());
			helper(arbol.getRightChild(), nuevoArbol.getRightChild(),0);
		}
	}
	
		
	public static void imprimirPreOrder(BinaryTree<Integer> ab) {
	    if (ab != null && !ab.isEmpty()) {
	        // 1. Imprimimos el nodo actual
	        System.out.println("Nodo: " + ab.getData());

	        // 2. Si tiene hijo izquierdo, lo visitamos
	        if (ab.hasLeftChild()) {
	            System.out.print("  Hijo Izq de " + ab.getData() + " -> ");
	            imprimirPreOrder(ab.getLeftChild());
	        }

	        // 3. Si tiene hijo derecho, lo visitamos
	        if (ab.hasRightChild()) {
	            System.out.print("  Hijo Der de " + ab.getData() + " -> ");
	            imprimirPreOrder(ab.getRightChild());
	        }
	    }
	}
	
	public static void main(String[] args) {
		
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(1);
		arbol.addLeftChild(new BinaryTree<Integer>(2));
		arbol.getLeftChild().addLeftChild(new BinaryTree<Integer>(4));
		arbol.addRightChild(new BinaryTree<Integer>(3));
		arbol.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
		arbol.getRightChild().addRightChild(new BinaryTree<Integer>(6));
		arbol.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
		
		ParcialArboles4 parcial = new ParcialArboles(arbol);
		BinaryTree<Integer> resultado = parcial.nuevoTree();
		System.out.println("--- RESULTADOS ESPERADOS ---");
	    System.out.println("Raíz: 1");
	    System.out.println("Hijo Izq (2): 3");
	    System.out.println("Hijo Der (3): 3");
	    System.out.println("Nieto Izq (4): 6");
	    System.out.println("Nieto Izq (5): 8  <-- (5+3)");
	    System.out.println("Bisnieto Izq (7): 12 <-- (7+5)");
	    
	    System.out.println("\n--- EJECUCIÓN ---");
	    imprimirPreOrder(resultado);
	}
	
}
