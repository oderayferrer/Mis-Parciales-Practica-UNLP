package PracticaFlotante;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.*;

/*Se cuenta con información del precio de los peajes para transitar por las rutas que unen las distintas ciudades. 
 * Se quiere obtener un camino cualquiera que comience en una ciudad origen y permita llegar a otra ciudad destino sin sumar más de X pesos en el total a pagar en peajes.
 *  En caso de no existir camino deberá retornar una lista vacía.
 *  Para el grafo del ejemplo, considerando que el origen es Lincoln, el destino Berisso y el monto máximo es 200, un camino posible es:
Lincoln > Cañuelas > Verónica > Berisso, ya que el costo de los peajes suman 195 (50+85+60).
Implemente en la clase BuscadorDeCamino el método:
ListaGenerica<String> caminoConPresupuesto(Grafo<String> ciudades, String origen, String destino, int montoMaximo)*/
public class Parcial {
	public List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino, int montoMaximo){
		List<String> resultado= new ArrayList<>();
		Vertex<String> o = ciudades.search(origen);
		Vertex<String> d = ciudades.search(destino);
		if(o != null && d != null) {
			boolean[] visitado = new boolean[ciudades.getSize()];
			List<String> caminoActual = new ArrayList<>();
			buscar(ciudades,o,d,resultado,caminoActual,visitado,montoMaximo,0);
		}
		
		return resultado;
	}
	
	private boolean buscar(Graph<String> ciudades, Vertex<String> actual, Vertex<String> destino,List<String>resultado, List<String> camino,boolean[] visitado,int montoMaximo, int montoActual) {
		boolean encontre= false;
		visitado[actual.getPosition()] = true;
		camino.add(actual.getData());
		
		if(actual.getData().equals(destino.getData()) && montoActual < montoMaximo) {
			encontre = true;
			resultado.clear();
			resultado.addAll(camino);
		}else {
			for(Edge<String> e : ciudades.getEdges(actual)) {
				Vertex<String> vecino = e.getTarget();
				int pos = vecino.getPosition();
				if(!visitado[pos] && !encontre && montoActual + e.getWeight() < montoMaximo) {
					encontre = buscar(ciudades,vecino,destino,resultado,camino,visitado,montoMaximo,montoActual + e.getWeight());
				}
			}
		}
		if(!encontre) {
			visitado[actual.getPosition()]=false;
			camino.remove(camino.size()-1);
		}
		return encontre;
	}
}
