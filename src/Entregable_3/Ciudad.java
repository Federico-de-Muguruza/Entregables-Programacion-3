package Entregable_3;

public class Ciudad {

	private Integer idCiudad;
	private String nombreCiudad;
	private boolean tieneBalanza;
	private boolean tieneRadares;
	private Integer estacionesDeServicio;
	private Integer talleresMecanicos;
	
	public Ciudad(Integer idCiudad, String nombreCiudad, boolean tieneBalanza,
			boolean tieneRadares, Integer estacionesDeServicio, Integer talleresMecanicos) {
		this.idCiudad = idCiudad;
		this.nombreCiudad = nombreCiudad;
		this.tieneBalanza = tieneBalanza;
		this.tieneRadares = tieneRadares;
		this.estacionesDeServicio = estacionesDeServicio;
		this.talleresMecanicos = talleresMecanicos;
	}

	// Complejidad: O(1)
	public Integer getIdCiudad() {
		return idCiudad;
	}

	// Complejidad: O(1)
	public String getNombreCiudad() {
		return nombreCiudad;
	}

	// Complejidad: O(1)
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	// Complejidad: O(1)
	public boolean isTieneBalanza() {
		return tieneBalanza;
	}

	// Complejidad: O(1)
	public void setTieneBalanza(boolean tieneBalanza) {
		this.tieneBalanza = tieneBalanza;
	}	
	
	// Complejidad: O(1)
	public String toString() {
		return this.getNombreCiudad();
	}
}
