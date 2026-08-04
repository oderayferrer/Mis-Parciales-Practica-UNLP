package practicaExamen;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class ParcialTemaiken {

	public static class Sitio{
		private String nombre;
		private int tiempo;
		
		public Sitio(String nombre, int tiempo) {
			this.nombre = nombre;
			this.tiempo = tiempo;
		}

		public String getNombre() {
			return nombre;
		}

		public int getTiempo() {
			return tiempo;
		}

		
	}
	public int resolver(Graph<Sitio> sitios, int tiempo) {
		Vertex<Sitio> entrada = null;
		for(Vertex<Sitio> v : sitios.getVertices()){
			if(v.getData().getNombre().equals("Entrada")) {
				entrada = v;
			}
		}
		if(entrada == null) {
			return 0;
		}
		
		boolean[] visitado = new boolean[sitios.getSize()];
		return resolver(sitios,entrada,tiempo,visitado);
		
		
	}
	
	public int resolver(Graph<Sitio> sitios, Vertex<Sitio> actual, int tiempoRestante, boolean[] visitado) {
		int tiempoSitio = actual.getData().getTiempo();
		if(tiempoSitio > tiempoRestante) {
			return 0;
		}
		
		visitado[actual.getPosition()] = true;
		int tiempoLuegoDeVisitar = tiempoRestante - tiempoSitio;
		int mejorCantidad = 1;
		for(Edge<Sitio> e : sitios.getEdges(actual)) {
			Vertex<Sitio> vecino = e.getTarget();
			int pos = vecino.getPosition();
			
			if(!visitado[pos]) {
				if(tiempoLuegoDeVisitar - e.getWeight() >=0) {
					int cantidad = 1 + resolver(sitios,vecino,tiempoLuegoDeVisitar - e.getWeight(),visitado);
					if(cantidad>mejorCantidad) {
						mejorCantidad = cantidad;
					}
				}
			}
		}
		visitado[actual.getPosition()]=false;
		return mejorCantidad;
	}
}
