package cl.clubhipico.clubhipico_jcvargas;

import cl.clubhipico.clubhipico_jcvargas.enums.SexoEnum;
import cl.clubhipico.clubhipico_jcvargas.object.CarreraObject;
import cl.clubhipico.clubhipico_jcvargas.object.CaballoObject;
import cl.clubhipico.clubhipico_jcvargas.object.JineteObject;
import cl.clubhipico.clubhipico_jcvargas.object.PersonaObject;

public class ClubHipicoMain {
	
	public void compararCaballo (CaballoObject caballo1, CaballoObject caballo2) {
		
	}
	
	public static void main (String[] args) {
		
		ClubHipicoMain chmain = new ClubHipicoMain();
		chmain.compararCaballo(new CaballoObject(), new CaballoObject());
		
		/* Declarando e inicializando CarreraObjet */
		CarreraObject carrera = new CarreraObject();
		
		/* Imprimiendo por pantalla el objeto CarreraObject */
		System.out.println("Carrera Objet : " + carrera);
		/* Imprime siguienet informacion:
		 * "Carrera Objet : cl.clubhipico.clubhipico_jcvargas.object.CarreraObject@260fa385"
		 */
		
		CaballoObject caballo = new CaballoObject();
		System.out.println("Caballo Objet : " + caballo);
		/* Caballo Objet : CaballoObject [nombre=null, rut=0, peso=0, sexo=null] 
		 * Se implemento el metodo toString en CaballoObject, pero no se asigno valores
		 * Si es un object / String, el valor por defecto es null
		 * Si es una vairable primitiva numerica es 0*/
		
		CaballoObject caballo2 = new CaballoObject();
		caballo2.setNombre("Caballo Juanito Perez");
		caballo2.setPeso(500);
		caballo2.setRut(123456789);
		caballo2.setSexo(SexoEnum.Macho);
		
		System.out.println("Caballo2 Object : " + caballo2);
		/* Caballo2 Object : AnimalObject [nombre=Caballo Juanito Perez, peso=500, rut=123456789, sexo=Macho] */
		
		JineteObject jinete = new JineteObject();
		jinete.setNombre("Pedrito");
		jinete.setCaballo(caballo2);
		System.out.println("Jinete Object : " + jinete);
		
		PersonaObject persona = jinete;
		PersonaObject persona2 = new JineteObject();
		/*JineteObject jinete8 = new PersonaObjetc();*/ // Error por jerarquia herencia
		
		System.out.println("Persona Object : " + persona);

	}

}
