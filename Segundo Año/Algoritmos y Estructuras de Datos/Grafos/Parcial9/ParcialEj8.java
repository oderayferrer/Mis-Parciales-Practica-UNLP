package PracticaFlotante;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Queue;
import tp5.ejercicio1.Vertex;

/*Ejercicio 8
Un grupo de investigadores desea modelar una red simplificada de neuronas para estudiar la
propagación de impulsos eléctricos. La red está compuesta por un conjunto de neuronas
conectadas entre sí mediante sinapsis. Cada sinapsis tiene una dirección y una "fuerza sináptica"
de la conexión, si esta fuerza es menor a un impulso recibido no permitirá la propagación.
Una vez que una neurona envía un impulso, a medida que se propaga hacia el resto de las
neuronas pierde un 10% de su intensidad.
Se quiere determinar cuántas neuronas pueden activarse (directa o indirectamente) a partir de
una neurona en particular y un impulso eléctrico.
Implemente el método:
public int neuronasActivadas(Graph<String> grafo, String inicio, int impulso){...}
Nota: Si al llegar a una neurona no puede continuar la propagación, no debe continuar la
evaluación sobre esa neurona.
Ejemplo: Con la siguiente configuración el algoritmo debería devolver el valor 4*/
public class ParcialEj8 {

	public int neuronasActivadas(Graph<String> grafo, String inicio, int impulso) {
		Vertex<String> origen = grafo.search(inicio);
		int activadas = 0;
		if (origen != null) {
			boolean[] visitado = new boolean[grafo.getSize()];
			Queue<Vertex<String>> cola = new Queue<>();
			//inicializo el origen
			cola.enqueue(origen);
			visitado[origen.getPosition()]= true;
			//para el calculo del 10% usamos double
			double impulsoActual = (double) impulso;
			//mientras haya nodos y el impulso siga vivo
			while(!cola.isEmpty() && impulsoActual >0) {
				
				int nodosEnNivel = cola.size();
				//procesamos el nivel
				for(int i=0; i< nodosEnNivel; i++) {
					Vertex<String> actual = cola.dequeue();
					//la neurona que salio de la cola se activo, sumamos
					activadas++;
					//buscamos a sus vecinos, sinapsis saliente
					for(Edge<String> e: grafo.getEdges(actual)) {
						Vertex<String> vecino = e.getTarget();
						int pos = e.getTarget().getPosition();
						double fuerzaSinaptica = (double) e.getWeight();
					//filtro, si no fue visitada y la fuerza sinaptica soporta el impulso actial
						if(!visitado[pos] && fuerzaSinaptica >= impulsoActual) {
							visitado[pos]= true;
							cola.enqueue(vecino);
						}
					}
				}
				// fin del nivel actual, el impulso pierde un 10% de su intensidad para el siguiente nivel
                // (pierde 10% significa que nos quedamos con el 90%, o sea multiplicar por 0.9)
				impulsoActual = impulsoActual * 0.9;
			}
		}
		return activadas;
	}
}
