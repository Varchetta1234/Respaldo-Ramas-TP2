package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import negocio.Grafo;
import negocio.Kruskal;

class TestKruskal {

	@Test
	public void testKruskal() {

	    Grafo g = new Grafo(4);

	    g.agregarArista(0, 1, 10);
	    g.agregarArista(0, 2, 6);
	    g.agregarArista(0, 3, 5);
	    g.agregarArista(1, 3, 15);
	    g.agregarArista(2, 3, 4);

	    Kruskal k = new Kruskal();

	    Grafo arbol = k.obtenerAGM(g);

	    assertTrue(arbol.existeArista(2, 3));
	    assertTrue(arbol.existeArista(0, 3));
	    assertTrue(arbol.existeArista(0, 1));
	}

}
