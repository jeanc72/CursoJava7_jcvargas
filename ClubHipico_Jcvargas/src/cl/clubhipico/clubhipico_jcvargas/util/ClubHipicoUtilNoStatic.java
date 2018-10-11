package cl.clubhipico.clubhipico_jcvargas.util;

import cl.clubhipico.clubhipico_jcvargas.enums.SexoEnum;
import cl.clubhipico.clubhipico_jcvargas.object.JineteObject;
import cl.clubhipico.clubhipico_jcvargas.object.CaballoObject;
import cl.clubhipico.clubhipico_jcvargas.object.PersonaObject;

/* clase utilitario sin metodos static */
public class ClubHipicoUtilNoStatic {
	
	private String tipoMontar = "Clasico";
	public static String tipoMJinete = "Jinete Clasico";
	
	public static void montar(JineteObject jinete, CaballoObject caballo) {
		jinete.setCaballo(caballo);
		System.out.println("Jinete " + jinete.getNombre() + " se monta en " + caballo.getNombre());

		// tipoMontar = "" ;  NO PERMITIDO
		tipoMJinete = "FSDFD"; // Cambia a todas las clases el valor
	}

	/* Existe una sobrecarga de metodo con respecto al montar caballo */
	public void montar(PersonaObject persona, CaballoObject caballo) {
		/*persona.setCaballo(caballo);*/
		System.out.println("Persona " + persona.getNombre() + " no se puede montar en caballo " + caballo.getNombre());
		
		tipoMontar = "" ; // PERMITIDO ya que llama a una variable global
		tipoMJinete = "FSDFD"; // Cambia a todas las clases el valor  
	}

	/* Existe una sobrecarga del metodo montar, recibiendo arreglos de jinetes y caballos */
	public void montar(JineteObject[] jinetes, CaballoObject[] caballos) {
		
		tipoMJinete = "FSDFD"; // Cambia a todas las clases el valor 
		
		//Validacion
		//Condicional if
		if (jinetes.length==caballos.length) {
			System.out.println("Se han recibido " + jinetes.length + " jinetes y " + caballos.length + " caballos");
			
			// Se evalua el arreglo, no un jinete
			if (jinetes.length==0) {
				System.out.println("Se requiere por lo menos un jinete y un caballo");
			}
			// Accedemos al primer jinete y evaluamos que sea sexo masculino
			if (jinetes[0].getSexo()!=SexoEnum.Masculino) {
				System.out.println("El primer jinete tiene que ser de sexo masculino...");
			}
		} else {
			System.out.println("La cantidad de jinetes y caballos no coincide ...");
		}

	}
	
}
