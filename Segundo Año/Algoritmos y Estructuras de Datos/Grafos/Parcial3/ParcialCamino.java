package PracticaFlotante;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class ParcialCamino {
//2022-07-02 - 1er Fecha
	
	public List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino, int montoMaximo){
		List<String> resultado = new ArrayList<>();
		
		Vertex<String> o = ciudades.search(origen);
		Vertex<String> d = ciudades.search(destino);
		
		if( o!= null && d != null) {
			boolean[] visitado = new boolean[ciudades.getSize()];
			buscar(ciudades,o,d,resultado,visitado,montoMaximo,0);
		}
		return resultado;
	}
	
	private boolean buscar(Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, List<String> resultado, boolean[] visitado,int montoMaximo, int montoActual) {
		visitado[origen.getPosition()]=true;
		resultado.add(origen.getData());
		boolean encontre = false;
		if(origen.getData().equals(destino.getData())) {
			encontre = true;
		}else {
			for(Edge<String> e : grafo.getEdges(origen)) {
				int j = e.getTarget().getPosition();
				if(!visitado[j] && !encontre && montoActual + e.getWeight() <= montoMaximo) {
					encontre = buscar(grafo,e.getTarget(),destino,resultado,visitado,montoMaximo, montoActual + e.getWeight());
				}
			}
		}
		if(!encontre) {
			resultado.remove(resultado.size()-1);
			visitado[origen.getPosition()] = false;
		}
		return encontre;
	}
}
