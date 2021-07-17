package Entregable_3;

import java.util.HashMap;
import java.util.Iterator;

public class DFS {
	
	private HashMap<Integer, String> colores;
	private Mapa mapa;
//	private int probarPoda = 0;

	public DFS(Mapa mapa) {
		this.mapa = mapa;
		this.colores = new HashMap<>();
	}
	
	public Camino dfs(int verticeOrigen, int verticeDestino) {
		
		Iterator<Integer> it = this.mapa.getCiudades();
		
		while (it.hasNext()) {
			Integer vertice = it.next();
			colores.put(vertice, "Blanco");
		}
		
		int cantidadKm = 0;
		int cantidadBalanzas = 0;
		int menorCantidadKm = 0;
		
		return dfs_visit(verticeOrigen, verticeDestino, cantidadKm, cantidadBalanzas, menorCantidadKm);
//		System.out.println(this.probarPoda);
//		return camino;
	}
	
	private Camino dfs_visit(int verticeActual, int verticeDestino, int cantidadKm, int cantidadBalanzas, int menorCantidadKm) {
		
//		probarPoda++;
		Ciudad ciudad = this.mapa.getCiudad(verticeActual);
		
		if (ciudad.isTieneBalanza() && cantidadKm != 0) 
			cantidadBalanzas++;
				
		Camino caminoMasCorto = new Camino();
		
		if (verticeActual == verticeDestino && cantidadBalanzas <= 1) {
			caminoMasCorto.addCiudad(cantidadKm, ciudad.getNombreCiudad(), true);
		} else {
			this.colores.put(verticeActual, "Amarillo");
		
			Iterator<Integer> it = this.mapa.getAdyacentesCiudad(verticeActual);
			
			while (it.hasNext() && cantidadBalanzas <= 1) {
				Integer adyacente = it.next();

				if (this.colores.get(adyacente).equals("Blanco")) {

					int kmAdyacente = this.mapa.obtenerKm(verticeActual, adyacente);
					cantidadKm += kmAdyacente;
					
					if (poda(cantidadKm, menorCantidadKm)) {
						Camino camino = dfs_visit(adyacente, verticeDestino, cantidadKm, cantidadBalanzas, menorCantidadKm);	

						camino.addCiudadActual(ciudad.getNombreCiudad());
						
						if (camino.getLlegoDestino() && camino.getCantidadKm() < caminoMasCorto.getCantidadKm()
								|| caminoMasCorto.getCantidadKm() == 0) {
							caminoMasCorto = camino;
							menorCantidadKm = camino.getCantidadKm();
						}													
					}
					cantidadKm -= kmAdyacente;
					if (ciudad.isTieneBalanza() && cantidadKm == 0) 
						cantidadBalanzas = 0;
					
				}
			}
			this.colores.put(verticeActual, "Blanco");
		}
		
		 if ( ! caminoMasCorto.getLlegoDestino())
	            caminoMasCorto = new Camino();
		return caminoMasCorto;
	}
	
	private boolean poda(int cantidadKm, int menorCantidadKm) {
		return cantidadKm < menorCantidadKm || menorCantidadKm == 0;
	}
}