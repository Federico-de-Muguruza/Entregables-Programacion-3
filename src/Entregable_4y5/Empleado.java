package Entregable_4y5;

public class Empleado {

	private String nombre;
	private String apellido;
	private Integer edad;
	private Integer puntaje;
	
	public Empleado(String nombre, String apellido, Integer edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	public void setPuntaje(Integer puntaje) {
		if (puntaje >= 0 && puntaje <= 100)
			this.puntaje = puntaje;
		else
			this.puntaje = 50;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public Integer getEdad() {
		return this.edad;
	}
	
	public Integer getPuntaje() {
		return this.puntaje;
	}
}
