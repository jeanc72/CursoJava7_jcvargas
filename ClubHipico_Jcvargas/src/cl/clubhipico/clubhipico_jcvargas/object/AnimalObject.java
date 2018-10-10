package cl.clubhipico.clubhipico_jcvargas.object;

import cl.clubhipico.clubhipico_jcvargas.enums.SexoEnum;

/* public class AnimalObject {  
* Si colocamos el modificador final, no podra ser heredada */
public class AnimalObject {  

	private String nombre;
	private int peso;
	private int rut;
	private SexoEnum sexo;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public int getRut() {
		return rut;
	}
	
	public void setRut(int rut) {
		this.rut = rut;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "AnimalObject [nombre=" + nombre + ", peso=" + peso + ", rut="
				+ rut + ", sexo=" + sexo + "]";
	}

	
}
