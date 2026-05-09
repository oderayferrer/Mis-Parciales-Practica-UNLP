package ParcialesArboles;

public class Examen {
	public static int diferenciaHojasInternos(BinaryTree<Integer> arbol) {
		int res = 0;
		if(arbol!= null && !arbol.isEmpty()) {
			res = helper(arbol);
		}
		return res;
	}
	
	private static int helper(BinaryTree<Integer> arbol) {
		int miDato = arbol.getData();
		int suma = 0;
		
		if(arbol.isLeaf() && miDato % 2 ==0) {
			suma += miDato;
		}
		if(miDato % 2 != 0) {
			if(arbol.hasLeftChild() && arbol.hasRightChild()) {
				suma -= miDato;
			}
		}
		if(arbol.hasLeftChild()) {
			suma+= helper(arbol.getLeftChild());
		}
		if(arbol.hasRightChild()) {
			suma+= helper(arbol.getRightChild());
		}
		return suma;
	}
}
