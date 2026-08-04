package PracticaFlotante;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.*;
public class Parcial {
//AyED 2023 - Grafos - 24-06-2023 - TEMA 1
	
	public class Camino{
		private List<String> nombre;
		private int distancia;
		public Camino(List<String> nombre, int distancia) {
			super();
			this.nombre = nombre;
			this.distancia = distancia;
		}
		public List<String> getNombre() {
			return nombre;
		}
		public int getDistancia() {
			return distancia;
		}

		
		
	}

	public List<Camino> resolver(Graph<String> sitios, String origen, String destino, List<String>
	evitarPasarPor){
		List<Camino> resultado = new ArrayList<>();// esto es lo que se va a devolver, el resultado
		
		Vertex<String> ori = sitios.search(origen);//creo los vertices buscandolos en el grafo por el nombre
		Vertex<String> dest= sitios.search(destino);//creo los vertices buscandolos en el grafo por el nombre
		
		if(ori != null && dest != null) {//si origen y destino no son null, es decir no estan vacios, seguimos
			boolean[] marca = new boolean[sitios.getSize()];//creamos la marca de visitados
			List<String> caminoActual = new ArrayList<>();//esta sera nuestra lista auxiliar con la que recorreremos todo buscando el camino
			buscar(sitios, ori, dest, marca, resultado, caminoActual,evitarPasarPor, 0);//metodo privado auxiliar
		}
		return resultado;
	}
	
	private void buscar(Graph<String> sitios, Vertex<String> origen, Vertex<String> destino, boolean[] marca,List<Camino> resultado, List<String> actual, List<String> evitar, int distancia) {
		marca[origen.getPosition()] = true;//donde entramos lo marcamos como visitado
		actual.add(origen.getData());//agregamos a nuestra lista de caminoactual
		
		if(origen.getData().equals(destino.getData())) {//si terminamos, es decir donde estamos parados y el destino son iguales
			List<String> copia = new ArrayList<>();//creo una lista copia independiente en el preciso instante en que encontramos el destino
			copia.addAll(actual);//agregamos todo lo que tenemos en nuestro actual a la copia
			resultado.add(new Camino(copia,distancia));//agregamos un nuevo camino a nuestro resultado
		}else {//si no es el final
			for(Edge<String> e : sitios.getEdges(origen)) {//para cada uno de los edges de los de origen
				Vertex<String> vecino = e.getTarget();//solo representa a la ciudad o al sitio en sí
				if(!marca[vecino.getPosition()] && !evitar.contains(vecino.getData())) {//si no lo visitamos y no esta dentro de las que no debemos visitar
					buscar(sitios,vecino,destino,marca,resultado,actual,evitar,distancia + e.getWeight());//recursion, mandandole el "vecino" que es donde estamos parados en este momento y agregando el peso del edge
				}
			}
		}
		marca[origen.getPosition()]=false;
		actual.remove(actual.size()-1);
	}
}
