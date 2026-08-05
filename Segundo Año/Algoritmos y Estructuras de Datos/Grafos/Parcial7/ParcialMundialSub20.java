package PracticaFlotante;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

/*Implemente la clase Parcial, y el método:
public ??? resolver(Grafo<???> sitios, String origen, String destino, ListaGenerica<???>
evitarPasarPor)
Los hinchas de las distintas selecciones que participan del mundial Sub-20 están visitando la ciudad
de La Plata. Se quiere encontrar todos los caminos desde un sitio origen a un sitio destino evitando
pasar por algunos sitios. Además, se quiere saber la distancia total recorrida para visitar todos los
sitios de cada camino.
Cada vértice contiene el nombre del sitio y en las aristas se cuenta con la cantidad de cuadras que
separan un sitio de otro.
Por ejemplo para este grafo, siendo el origen el Estadio Unico “Diego Armando Maradona”, el
destino el Palacio Campodónico y los sitios a evitar son la Legislatura y MACLA la información
a devolver sería:
●
●
Estadio Unico “Diego Armando Maradona” - Coliseo Podestá - Palacio Campodónico.
Distancia total = 30 cuadras.
Estadio Unico “Diego Armando Maradona” - Catedral La Plata - Rectorado UNLP -
Palacio Campodónico. Distancia total = 75 cuadras.*/
public class ParcialMundialSub20 {
	public class Camino{
		List<String> ciudades;
		int distancia;
		
		public Camino(List<String> ciudades, int distancia) {
			super();
			this.ciudades = ciudades;
			this.distancia = distancia;
		}
		public List<String> getCiudades(){
			return this.ciudades;
		}
		public int getDistancia() {
			return this.distancia;
		}
	}
	
	public List<Camino> resolver(Graph<String> sitios, String origen, String destino,List<String> evitarPasarPor){
		List<Camino> resultado = new ArrayList<>();
		
		Vertex<String> o = sitios.search(origen);
		Vertex<String> d = sitios.search(destino);
		
		if(o!= null && d!= null) {
			boolean[] visitado = new boolean[sitios.getSize()];
			List<String> caminoActual = new ArrayList<>();
			for(String prohibido : evitarPasarPor) {
				Vertex<String> vProhibido = sitios.search(prohibido);
				if(vProhibido != null) {
					visitado[vProhibido.getPosition()]= true;
				}
			}
			buscar(sitios,o,d,resultado,caminoActual,visitado,0);
		}
		
		return resultado;
		
	}
	
	private void buscar(Graph<String> sitios, Vertex<String> actual, Vertex<String> destino, List<Camino> resultado, List<String> camino,boolean[] visitado,int distancia) {
		visitado[actual.getPosition()]=true;
		camino.add(actual.getData());
		
		if(actual.getData().equals(destino.getData())) {
			List<String> copia = new ArrayList<>();
			copia.addAll(camino);
			resultado.add(new Camino(copia,distancia));
		}else {
			for(Edge<String> e : sitios.getEdges(actual)) {
				int pos = e.getTarget().getPosition();
				if(!visitado[pos]) {
					buscar(sitios,e.getTarget(),destino,resultado,camino,visitado,distancia + e.getWeight());
				}
			}
		}
		visitado[actual.getPosition()]= false;
		camino.remove(camino.size()-1);
	}
}
