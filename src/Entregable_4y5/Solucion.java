package Entregable_4y5;

public class Solucion {
	
	private Integer cantIteraciones;
	private Grupo grupoA;
	private Grupo grupoB;
	
	public Solucion() {
		this.grupoA = new Grupo("A");
		this.grupoB = new Grupo("B");
		this.cantIteraciones = 0;
	}
	
	public void setGrupoA(Grupo grupoA) {
		this.grupoA = grupoA;
	}
	
	public void setGrupoB(Grupo grupoB) {
		this.grupoB = grupoB;
	}
	
	public Grupo getCopiaGrupoA() {
		Grupo copiaGrupo = new Grupo(this.grupoA.getNombre(), this.grupoA.getEmpleados(), this.grupoA.getPuntajeGrupal());
		return copiaGrupo;
	}
	
	public Grupo getCopiaGrupoB() {
		Grupo copiaGrupo = new Grupo(this.grupoB.getNombre(), this.grupoB.getEmpleados(), this.grupoB.getPuntajeGrupal());
		return copiaGrupo;
	}
	
	public Grupo getGrupoA() {
		return this.grupoA;
	}
	
	public Grupo getGrupoB() {
		return this.grupoB;
	}
	
	public void setIteraciones(Integer iteraciones) {
		this.cantIteraciones = iteraciones;
	}
	
	public Integer getIteraciones() {
		return this.cantIteraciones;
	}
	
	public Integer calcularDiferencia() {
		return Math.abs(this.grupoA.getPuntajeGrupal() - this.grupoB.getPuntajeGrupal());
	}
	
	public String toString() {
		return "Grupo A: " + this.getGrupoA() + " | Grupo B: " + this.getGrupoB() + " | Iteraciones: " + this.getIteraciones();
	}
}


