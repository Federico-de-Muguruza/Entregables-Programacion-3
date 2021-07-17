package Entregable_3;

import java.util.Iterator;

public class Main {

	public static <T> void main(String[] args) {
		
		Ciudad pehuajo = new Ciudad(1, "Pehuajo", true, true, 3, 5);
		Ciudad ayacucho = new Ciudad(2, "Ayacucho", false, false, 1, 2);
		Ciudad olavarria = new Ciudad(3, "Olavarría", true, false, 9, 17);
		Ciudad rauch = new Ciudad(4, "Rauch", false, true, 1, 0);
		Ciudad bolivar = new Ciudad(5, "Bolívar", false, false, 7, 4);
		Ciudad tandil = new Ciudad(6, "Tandil", true, true, 6, 4);
		Ciudad azul = new Ciudad(7, "Azul", false, true, 4, 4);
		Ciudad mardel = new Ciudad(8, "Mar del plata", true, false, 15, 12);
	
		Mapa mapa = new Mapa();
		
		mapa.addCiudad(pehuajo);
		mapa.addCiudad(ayacucho);
		mapa.addCiudad(olavarria);
		mapa.addCiudad(rauch);
		mapa.addCiudad(bolivar);
		mapa.addCiudad(tandil);
		mapa.addCiudad(azul);
		mapa.addCiudad(mardel);
		
		mapa.addRuta(pehuajo, ayacucho, 540);
		mapa.addRuta(pehuajo, bolivar, 70);
		mapa.addRuta(ayacucho, rauch, 50);
		mapa.addRuta(ayacucho, tandil, 70);
		mapa.addRuta(olavarria, rauch, 210);
		mapa.addRuta(olavarria, bolivar, 140);
		mapa.addRuta(olavarria, tandil, 130);
		mapa.addRuta(rauch, tandil, 60);
		mapa.addRuta(bolivar, azul, 100);
		mapa.addRuta(tandil, mardel, 200);
		
		System.out.println(mapa.getCaminoMasCorto(7, 2));		
		System.out.println(mapa.getCaminoMasCorto(4, 8));	
		System.out.println(mapa.getCaminoMasCorto(8, 1));	
		mapa.deleteCiudad(ayacucho);
		mapa.deleteRuta(tandil, rauch);
		System.out.println(mapa.getCaminoMasCorto(8, 1));	
		
		// Corección:
		
		Grafo<Float> grafo = new GrafoDirigido<>();
		
		grafo.agregarVertice(8);
		grafo.agregarVertice(9);
		grafo.agregarVertice(10);
		
		grafo.agregarArco(8, 9, 89F);
		grafo.agregarArco(8, 10, 810F);
		grafo.agregarArco(8, 10, 810F);

		Iterator<Integer> ady = grafo.obtenerAdyacentes(8);

		System.out.println("Adyacentes del 8: ");

		while (ady.hasNext()) {

		    System.out.print(" | " + ady.next() + " | ");

		}
	}
}
