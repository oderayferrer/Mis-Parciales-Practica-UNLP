package PracticaFlotante;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class ParcialGrafosPrimerFecha {

	public List<String> rutaConCifrado(Graph<String> red, String origen, String destino){
		List<String> resultado = new ArrayList<>();
		
		Vertex<String> o = red.search(origen);
		Vertex<String> d =  red.search(destino);
		
		if(o != null && d != null) {
			boolean[] visitado = new boolean[red.getSize()];
			List<String> caminoActual = new ArrayList<>();
			buscar(red,resultado,caminoActual,true,o,d,visitado);
		}
		
		return resultado;
	}
	private boolean buscar(Graph<String> grafo, List<String> resultado,List<String> camino,boolean modoPar,Vertex<String> actual, Vertex<String> destino,boolean[] visitado ) {
		boolean encontre = false;
		visitado[actual.getPosition()]= true;
		camino.add(actual.getData());
		if(actual.getData().equals(destino.getData())) {
			encontre = true;
			resultado.clear();
			resultado.addAll(camino);
		}else {
			for(Edge<String> e : grafo.getEdges(actual)) {
				Vertex<String> vecino = e.getTarget();
				int peso = e.getWeight();
				if(!visitado[vecino.getPosition()] && !encontre) {
					boolean conexionPar = (peso % 2 ==0);
					if(modoPar == conexionPar){
						encontre = buscar(grafo,resultado,camino,!modoPar,vecino,destino,visitado);
					}
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
