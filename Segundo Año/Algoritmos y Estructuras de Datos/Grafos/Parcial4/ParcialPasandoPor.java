package PracticaFlotante;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

/*Implemente la clase parcial y el método ??? resolver(Grafo <???> ciudades, String origen, String
destino, Lista <???> pasandoPor). Se quiere encontrar un camio desde una ciudad origen hasta una
ciudad destino, teniendo en cuenta que debido a la pandemia queremos pasar si o si por ciertas
ciudades específicas pasadas en una lista como parámetro. Para cada ciudad se conoce el nombre.
En este ejemplo, para llegar desde La Plata a Suipacha, pasando por Quilmes y Carlos Keen, el camino
a devolver es el resaltado ya que pasa por ambas ciudades
3)Nota:
•
 Complete en la firma del método los tipos de datos indicados con signos de interrogación
•
 Debe verificar la existencia de la ciudad de origen y la ciudad destino
•
 No se debe pasar 2 veces por el mismo lugar
•
 En caso de no existir un camino posible, debe devolver el valor más adecuado que se ajusta a
lo solicitado
• Use los métodos de Grafo y Listas vistos en clase*/



public class ParcialPasandoPor {
	public List<String> resolver(Graph<String> ciudades,String origen, String destino, List<String> pasandoPor){
		List<String> resultado = new ArrayList<>();
		
		Vertex<String> o = ciudades.search(origen);
		Vertex<String> d = ciudades.search(destino);
		
		if(o != null && d != null) {
			boolean[] visitado = new boolean[ciudades.getSize()];
			buscar(ciudades,o,d,resultado,pasandoPor,visitado,0);
		}
		return resultado;
	}
	
private boolean buscar(Graph<String> ciudades, Vertex<String> origen, Vertex<String> destino, List<String> resultado, List<String> pasandoPor,boolean[] visitado, int obligatoriasVisitadas) {
	boolean encontre = false;
	visitado[origen.getPosition()]=true;
	resultado.add(origen.getData());
	int contadorActual = obligatoriasVisitadas;
	if(pasandoPor.contains(origen.getData())) {
		contadorActual++;
	}
	if(origen.equals(destino)) {
		if(contadorActual == pasandoPor.size()) {
			encontre = true;
		}
	}else {
		for(Edge<String> e : ciudades.getEdges(origen)) {
			Vertex<String> vecino = e.getTarget();
			if(!visitado[vecino.getPosition()] && !encontre) {
				encontre = buscar(ciudades,vecino,destino,resultado,pasandoPor,visitado, contadorActual);
			}
		}
	}
	if(!encontre) {
		visitado[origen.getPosition()]=false;
		resultado.remove(resultado.size()-1);
	}
	return encontre;
	}
}
