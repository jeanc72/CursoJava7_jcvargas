package cl.clubhipico.clubhipico_jcvargas.object;

public class CarreraObject {
	/* propiedades globales de la clase, visibles en toda al clase.
	 * Para acceder se antepone this. */
    private String nombre;
    private int distancia;
	private PistaObject pista;
    private CaballoObject caballo1;
    private CaballoObject caballo2;
    private CaballoObject caballo3;
    private TipoApuestaObject tipoapuesta;
    private ApostadorObject apostador;
    
    // permite definir un valor string nombre
    public void setNombre (String nombre) {
    	this.nombre = nombre;
    }
    
    public String getNombre() {
    	return this.nombre;  // al no poner this, asume variable global por defecto si no existe propiedad local
    }
    
    public void setDistancia (int distancia) {
    	this.distancia = distancia;
    }
    
    public int getDistancia() {
    	return this.distancia; 
    }

    public void setPista (PistaObject pista) {
    	this.pista = pista;
    }
    
    public PistaObject getPista() {
    	return this.pista; 
    }
    
    public void setCaballo1 (CaballoObject caballo1) {
    	this.caballo1 = caballo1;
    }
    
    public CaballoObject getCaballo1() {
    	return this.caballo1; 
    }

    public void setCaballo2 (CaballoObject caballo2) {
    	this.caballo2 = caballo2;
    }
    
    public CaballoObject getCaballo2() {
    	return this.caballo2; 
    }

    public void setCaballo3 (CaballoObject caballo3) {
    	this.caballo3 = caballo3;
    }
    
    public CaballoObject getCaballo3() {
    	return this.caballo3; 
    }
    
    public void setTipoapuesta (TipoApuestaObject tipoapuesta) {
    	this.tipoapuesta = tipoapuesta;
    }
    
    public TipoApuestaObject getTipoapuesta() {
    	return this.tipoapuesta; 
    }

    public void setApostador (ApostadorObject apostador) {
    	this.apostador = apostador;
    }
    
    public ApostadorObject getApostador() {
    	return this.apostador; 
    }

    @Override
	public String toString() {
		return "CarreraObject [nombre=" + nombre + ", distancia=" + distancia
				+ ", pista=" + pista + ", caballo1=" + caballo1 + ", caballo2="
				+ caballo2 + ", caballo3=" + caballo3 + ", tipoapuesta="
				+ tipoapuesta + ", apostador=" + apostador + "]";
	}
    
}
