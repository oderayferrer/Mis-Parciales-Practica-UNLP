package PracticaFlotante;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class ParcialTactica {
	
	public List<String> tactica(Graph<String> jugadores,String arquero,String delantero,double potencia){
		List<String> resultado = new ArrayList<>();
		
		Vertex<String> origen = jugadores.search(arquero);
		Vertex<String> destino = jugadores.search(delantero);
		
		if(origen != null && destino != null) {
			List<String> caminoActual = new ArrayList<>();
			boolean[] visitado = new boolean[jugadores.getSize()];
			
			buscar(jugadores,origen,destino,resultado,caminoActual,visitado,potencia,0);
		}
		return resultado;
	}
	
	private boolean buscar(Graph<String> grafo, Vertex<String> actual, Vertex<String> destino, List<String> resultado,List<String> camino,boolean[] visitado,double potencia, double sumaPotencia) {
		boolean encontre = false;
		visitado[actual.getPosition()]= true;
		camino.add(actual.getData());
		
		if(actual.getData().equals(destino.getData())) {
			double promedioActual = (double) sumaPotencia / camino.size();
			if(promedioActual>= potencia) {
				resultado.addAll(camino);
				encontre = true;
			}
		}else {
			for(Edge<String> e : grafo.getEdges(actual)) {
				Vertex<String> vecino = e.getTarget();
				if(!visitado[vecino.getPosition()] && !encontre) {
					encontre = buscar(grafo,vecino,destino,resultado,camino,visitado,potencia,sumaPotencia+ e.getWeight());
				}
			}
		}
		if(!encontre) {
			visitado[actual.getPosition()] = false;
			camino.remove(camino.size()-1);
		}
		return encontre;
	}
}
