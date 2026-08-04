package practicaExamen;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Queue;
import tp5.ejercicio1.Vertex;

// examen ayed  grafos 29-6-2024
public class Parcial {

	public List<Invitado> invitacionMasterClass(Graph<String> red, String usuario, int distancia, int limite){
		List<Invitado> resultado = new ArrayList<Invitado>();
		if(!red.isEmpty()) {
			Vertex<String> origen = red.search(usuario);
			if(origen == null) {
				return resultado;
			}
			boolean[] visitado = new boolean[red.getSize()];
			int[] dist = new int[red.getSize()];
			Queue<Vertex<String>> cola = new Queue<>();
			cola.enqueue(origen);
			visitado[origen.getPosition()] = true;
			while(!cola.isEmpty()) {
				Vertex<String> actual = cola.dequeue();
				int distActual = dist[actual.getPosition()];
				for(Edge<String> e: red.getEdges(actual)) {
					Vertex<String> vecino = e.getTarget();
					int pos = vecino.getPosition();
					if(!visitado[pos]) {
						visitado[pos]= true;
						dist[pos]= distActual +1;
						if(dist[pos] <= distancia) {
							resultado.add(new Invitado(vecino.getData(),dist[pos]));
						}
						if(resultado.size() == limite) {
							return resultado;
						}
						if(dist[pos] < distancia) {
							cola.enqueue(vecino);
						}
					}
				}
			}
		}
		
		return null;
	}
}
