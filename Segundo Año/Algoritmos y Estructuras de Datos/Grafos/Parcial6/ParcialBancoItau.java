package PracticaFlotante;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Queue;
import tp5.ejercicio1.Vertex;

/* El Banco Itaú se suma a las campañas “Quedate en casa” lanzando un programa para acercarle a los
jubilados el sueldo hasta sus domicilios. Para ello el banco cuenta con información que permite definir
un grafo de personas donde las personas puede ser un jubilado o un empleado del banco que llevará
el dinero. Se necesita armar la cartera de jubilados para que cada empleado repartidor del banco,
incluyendo en cada lista los jubilados que vivan un radio cercano a su casa y no hayan percibido la
jubilación del mes.
Para ello, implemente un algoritmo que dado un
Grafo<Persona> retorne una listas de jubilados que se
encuentran a una distancia menor a un valor dado del
empleado Itaú.
El método recibirá un Grafo<Persona>, un empleado y un
grafo de separación/ distancia y debe retornar una lista de
hasta 40 jubilados que no hayan percibido la jubilación del
mes y se encuentren a una distancia menor al recibido como
parámetro.
En este grafo simple, donde los empleados del banco están
en color rojo y se desea retornar los jubilados hasta
distancia 2, se debería retornar los jubilados color negro.
La Persona conoce si es empleado o jubilado, el nombre y
domicilio*/
public class ParcialBancoItau {
	public class Persona{
		private String nombre;
		private boolean Jubilado;
		private String domicilio;
		private boolean percibioJubilacion;
		public Persona(String nombre, boolean esJubilado, String domicilio, boolean percibioJubilacion, boolean Jubilado) {
			super();
			this.nombre = nombre;
			this.Jubilado = Jubilado;
			this.domicilio = domicilio;
			this.percibioJubilacion = percibioJubilacion;
		}
		public String getNombre() {
			return nombre;
		}
		public boolean isJubilado() {
			return Jubilado;
		}
		public String getDomicilio() {
			return domicilio;
		}
		public boolean isPercibioJubilacion() {
			return percibioJubilacion;
		}
		
	}
	
	public List<Persona> carteraJubilados(Graph<Persona> grafo, Vertex<Persona> empleado, int distanciaMax) {
		List<Persona> resultado = new ArrayList<>();//creo la lista donde devolvere el resultado
		if(grafo.isEmpty() || empleado == null) {//si el grafo  esta vacio o el empleado no existe devuelvo la lista vacia
			return resultado;
		}
		boolean[] visitado = new boolean[grafo.getSize()];//creo la marca de visitado
		Queue<Vertex<Persona>> cola = new Queue<>();//creo la cola
		cola.enqueue(empleado);//encolo el empleado que me enviaron por parametro
		int distanciaActual = 0;//la distancia actual
		//mientras la cola no se vacie, la distancia actual no supere la maxima y no tengamos 40 personas en nuestra lista
		while(!cola.isEmpty() && distanciaActual < distanciaMax && resultado.size()<40) {
			int nodosEnNivel = cola.size();//guardo cuantos nodos tenemos en este nivel
			for(int i = 0 ; i < nodosEnNivel; i++) {//para cada nodo de este nivel
				Vertex<Persona> p = cola.dequeue();//desencolo en una variable vertex
				// si la persona que desencole es jubilado y no percibio jubilacion lo agrego a la lista del resultado
				if(p.getData().isJubilado() && !p.getData().isPercibioJubilacion()) {
					if(resultado.size()<40) {//si no superamos las 40 personas
						resultado.add(p.getData());
					
				}
				for(Edge<Persona> e : grafo.getEdges(p)) {//miramos los vecinos 
					Vertex<Persona> vecino = e.getTarget();
					int pos = vecino.getPosition();
					if(!visitado[pos]) {//si no visite al vecino lo marco como visitado y lo encolo
						visitado[pos] = true;
						cola.enqueue(vecino);	
					}
				}
			}

			distanciaActual++;//aumento la distancia actual
		}	
		return resultado;
	}
}
