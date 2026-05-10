package calculoFibraOptica;

import java.util.ArrayList;

public class Prim {

	public Grafo obtenerAGM(Grafo grafo) {
		int n = grafo.cantidadVertices();
		
		// T = (V, ET) -> Nuestro árbol resultante
		Grafo arbol = new Grafo(n);
		
		// Si el grafo está vacío, devolvemos el árbol vacío
		if (n == 0) return arbol;

		// Arreglo para llevar registro de los vértices que ya están en nuestro AGM
		boolean[] visitados = new boolean[n];
		
		// 1. Elegimos un vértice arbitrario para empezar (el 0)
		visitados[0] = true;

		ArrayList<Arista> aristas = grafo.obtenerAristas();
		int aristasAgregadas = 0;

		// 2. Un AGM siempre tiene exactamente (n - 1) aristas
		while (aristasAgregadas < n - 1) {
			Arista menorArista = null;

			// 3. Buscamos la arista más barata en la "frontera"
			for (Arista a : aristas) {
				int origen = a.getOrigen();
				int destino = a.getDestino();

				boolean origenVisitado = visitados[origen];
				boolean destinoVisitado = visitados[destino];

				// CONDICIÓN CLAVE DE PRIM: 
				// Solo miramos aristas donde exactamente UN extremo ya esté en el árbol (visitado) 
				// y el otro extremo esté afuera (no visitado). Esto evita ciclos matemáticamente.
				if (origenVisitado != destinoVisitado) { // Actúa como un XOR
					
					// Si es la primera que encontramos, o es más barata que la anterior, la guardamos
					if (menorArista == null || a.getCosto() < menorArista.getCosto()) {
						menorArista = a;
					}
				}
			}

			// 4. Agregamos la mejor arista encontrada al árbol definitivo
			if (menorArista != null) {
				arbol.agregarArista(menorArista.getOrigen(), menorArista.getDestino(), menorArista.getCosto());
				
				// Al marcar ambos como true, el que estaba en false ahora pasa a estar visitado
				visitados[menorArista.getOrigen()] = true;
				visitados[menorArista.getDestino()] = true;
				
				aristasAgregadas++;
			} else {
				// Si no encontramos ninguna arista y no llegamos a n-1, el grafo es inconexo
				break;
			}
		}

		return arbol;
	}
}
