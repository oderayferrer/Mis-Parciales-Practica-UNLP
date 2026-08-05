package PracticaFlotante;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class ParcialMendoza {

	public List<String> recorrido(Graph<String> grafo, int cantLocalidades, int cantNafta, List<String> localidadesExceptuadas){
		List<String> resultado = new ArrayList<>();
		
		Vertex<String> origen = grafo.search("Mendoza");
		
		if(origen != null) {
			boolean[] visitado = new boolean[grafo.getSize()];
			for(String prohibido : localidadesExceptuadas) {
				Vertex<String> vProhibido = grafo.search(prohibido);
				if(vProhibido != null) {
					visitado[vProhibido.getPosition()]= true;
				}
			}
			List<String> caminoActual = new ArrayList<>();
			buscar(grafo,resultado,caminoActual,origen,visitado,cantLocalidades,cantNafta,0);
		}
		
		return resultado;
	}
	
	private boolean buscar(Graph<String> grafo,List<String> resultado, List<String> camino,Vertex<String> actual,boolean[] visitado, int cantLocalidades, int cantNafta, int cantActual ) {
		boolean encontre = false;
		visitado[actual.getPosition()]= true;
		camino.add(actual.getData());
		int cActual = camino.size();
		if(cActual >= cantLocalidades) {
			resultado.clear();
			resultado.addAll(camino);
			encontre = true;
		}else {
			for(Edge<String> e : grafo.getEdges(actual)) {
				if(!visitado[e.getTarget().getPosition()] && !encontre && cantActual + e.getWeight() < cantNafta) {
					encontre =buscar(grafo,resultado,camino,e.getTarget(),visitado,cantLocalidades,cantNafta,cantActual +e.getWeight());
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
