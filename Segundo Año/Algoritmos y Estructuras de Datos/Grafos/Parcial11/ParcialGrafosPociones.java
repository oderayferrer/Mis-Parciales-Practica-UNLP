package PracticaFlotante;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class ParcialGrafosPociones {
	
	public List<String> rutaOptimaDistribucion(Graph<String> reino, String castillo,String aldea,int maxPociones){
		List<String> resultado = new ArrayList<>();
		
		Vertex<String> origen = reino.search(castillo);
		Vertex<String> destino = reino.search(aldea);
		
		if(origen != null && destino != null) {
			boolean[] visitado = new boolean[reino.getSize()];
			List<String> caminoActual = new ArrayList<>();
			buscar(reino,origen,destino,resultado,caminoActual,visitado,maxPociones,0);
		}
		
		return resultado;
	}
	private void buscar(Graph<String> grafo, Vertex<String> actual,Vertex<String> destino,List<String> resultado,List<String> camino,boolean[] visitado,int maxPociones, int pocionesActual) {
		
		visitado[actual.getPosition()] = true;
		camino.add(actual.getData());
		
		if(actual.getData().equals(destino.getData())) {
			if(camino.size()> resultado.size()) {
				resultado.clear();
				resultado.addAll(camino);	
			}
			
		}else {
			for(Edge<String> e : grafo.getEdges(actual)) {
				Vertex<String> vecino = e.getTarget();
				if(!visitado[vecino.getPosition()] && pocionesActual + e.getWeight() < maxPociones) {
					buscar(grafo,vecino,destino,resultado,camino,visitado,maxPociones,pocionesActual+e.getWeight());
				}
			}
		}
		visitado[actual.getPosition()]= false;
		camino.remove(camino.size()-1);

	}
}
