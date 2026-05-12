package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import negocio.Arista;
import negocio.Grafo;

public class GrafoTest {

	@Test
	public void testInicializacion() {
		Grafo g = new Grafo(5);
		assertEquals(5, g.cantidadVertices());
		
		assertFalse(g.existeArista(0, 1));
	}

	@Test
	public void testAgregarYObtenerArista() {
		Grafo g = new Grafo(3);
		g.agregarArista(0, 1, 150.5); // Conectamos Nodo 0 y 1
		
		assertTrue(g.existeArista(0, 1));
		assertTrue(g.existeArista(1, 0)); // Grafo no dirigido (ida y vuelta)
		
		assertEquals(150.5, g.obtenerCosto(0, 1), 0.001);
	}

	@Test
	public void testObtenerTotalDeAristas() {
		Grafo g = new Grafo(3);
		g.agregarArista(0, 1, 10);
		g.agregarArista(1, 2, 20);
		
		ArrayList<Arista> aristas = g.obtenerAristas();
		
		assertEquals(2, aristas.size());
	}
}
