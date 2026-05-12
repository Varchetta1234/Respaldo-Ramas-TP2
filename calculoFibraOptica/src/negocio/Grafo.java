package negocio;

import java.util.ArrayList;

public class Grafo {
	private double [][] A;	
	
	public Grafo(int cantidadVertices) {
		A = new double [cantidadVertices][cantidadVertices];
		
		for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                A[i][j] = -1;
            }
        }
	}
	
	public ArrayList<Arista> obtenerAristas() {
	    ArrayList<Arista> aristas = new ArrayList<>();
	    for (int i = 0; i < A.length; i++) {
	        for (int j = i + 1; j < A.length; j++) {
	            if (A[i][j] != -1) {
	                aristas.add(new Arista(i, j, A[i][j]));
	            }
	        }
	    }
	    return aristas;
	}
	
	public void agregarArista(int i, int j, double costo) {
		A[i][j] = costo;
		A[j][i] = costo;
	}
	
	
	public boolean existeArista(int i, int j) {
		return A[i][j] != -1; // no existe conexio va a ser igual a -1
	}
	
	public double obtenerCosto(int i, int j) {
        return A[i][j];
    }
	
	public int cantidadVertices() {
        return A.length;
    }
}
