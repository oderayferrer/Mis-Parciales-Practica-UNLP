package ParcialesArboles;

public class ParcialArboles {
	BinaryTree<Integer> arbol;
	

	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public boolean isTwoTree(int num) {
		boolean res = false;
		BinaryTree<Integer> ab = null;
		if(this.arbol != null && !this.arbol.isEmpty()) {
			ab = buscar(num,this.arbol);
		}
		if(ab != null) {
			int ramaIzquierda = -1;
			int ramaDerecha = -1;
			
			if(ab.hasLeftChild()) {
				ramaIzquierda = contar(ab.getLeftChild());
			}
			if(ab.hasRightChild()) {
				ramaDerecha = contar(ab.getRightChild());
			}
			res = (ramaIzquierda == ramaDerecha);
		}
		return res;
		
	}
	
	private BinaryTree<Integer> buscar(int num, BinaryTree<Integer> arbol) {
		BinaryTree<Integer> res = null;
		if(arbol != null && !arbol.isEmpty()) {
			if(arbol.getData() == num) {
				res = arbol;	
			}
			else {
				if(arbol.hasLeftChild()) {
					res =buscar(num, arbol.getLeftChild());
				}
				if(res == null && arbol.hasRightChild()) {
					res =buscar(num, arbol.getRightChild());
				}
			}
			
		}
		return res;
	}
	
	private int contar(BinaryTree<Integer> arbol) {
		int total = 0;
		if(arbol != null && !arbol.isLeaf()) {
			int cantIzq = 0;
			int cantDer = 0;
			
			if(arbol.hasLeftChild()) {
				cantIzq+= contar(arbol.getLeftChild());
			}
			if(arbol.hasRightChild()) {
				cantDer+= contar(arbol.getRightChild());
			}
			int soyDoble= 0;
			if(arbol.hasLeftChild() && arbol.hasRightChild()) {
				soyDoble =1;
			}
			total = cantIzq + cantDer + soyDoble;
		}
		return total;
	}
	
	public class MainTest {
	    public static void main(String[] args) {
	        //  Construimos el árbol del ejemplo de la imagen
	        BinaryTree<Integer> a2 = new BinaryTree<>(2);
	        BinaryTree<Integer> a7 = new BinaryTree<>(7);
	        BinaryTree<Integer> a_5 = new BinaryTree<>(-5);
	        BinaryTree<Integer> a23 = new BinaryTree<>(23);
	        BinaryTree<Integer> a6 = new BinaryTree<>(6);
	        BinaryTree<Integer> a19 = new BinaryTree<>(19);
	        BinaryTree<Integer> a4 = new BinaryTree<>(4);
	        BinaryTree<Integer> a_3 = new BinaryTree<>(-3);
	        BinaryTree<Integer> a55 = new BinaryTree<>(55);
	        BinaryTree<Integer> a18 = new BinaryTree<>(18);
	        BinaryTree<Integer> a9 = new BinaryTree<>(9);
	        BinaryTree<Integer> a16 = new BinaryTree<>(16);
	        BinaryTree<Integer> a8 = new BinaryTree<>(8);
	        BinaryTree<Integer> a24 = new BinaryTree<>(24);

	        // Armamos la estructura de niveles
	        a2.addLeftChild(a7);
	        a2.addRightChild(a_5);

	        a7.addLeftChild(a23);
	        a7.addRightChild(a6);

	        a_5.addLeftChild(a19);
	        a_5.addRightChild(a4);

	        a23.addLeftChild(a_3);
	        
	        a6.addLeftChild(a55);
	        
	        a4.addRightChild(a18);
	        
	        a55.addLeftChild(a9);
	        a55.addRightChild(a16);
	        
	        a18.addLeftChild(a8);
	        a18.addRightChild(a24);

	        ParcialArboles5 parcial = new ParcialArboles5(a2);

	        // 3. Ejecutamos las pruebas del enunciado
	        System.out.println("--- Pruebas de isTwoTree ---");
	        System.out.println("¿isTwoTree(2)? Esperado: true  | Resultado: " + parcial.isTwoTree(2));
	        System.out.println("¿isTwoTree(7)? Esperado: false | Resultado: " + parcial.isTwoTree(7));
	        System.out.println("¿isTwoTree(-3)? Esperado: true | Resultado: " + parcial.isTwoTree(-3));
	        System.out.println("¿isTwoTree(4)? Esperado: false | Resultado: " + parcial.isTwoTree(4));
	        System.out.println("¿isTwoTree(55)? Esperado: true | Resultado: " + parcial.isTwoTree(55));
	        System.out.println("¿isTwoTree(100)? Esperado: false | Resultado: " + parcial.isTwoTree(100)); // Caso no existe
	    }
	}
}


