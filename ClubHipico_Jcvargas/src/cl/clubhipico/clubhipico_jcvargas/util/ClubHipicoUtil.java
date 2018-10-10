package cl.clubhipico.clubhipico_jcvargas.util;

import cl.clubhipico.clubhipico_jcvargas.enums.SexoEnum;
import cl.clubhipico.clubhipico_jcvargas.object.JineteObject;
import cl.clubhipico.clubhipico_jcvargas.object.CaballoObject;
import cl.clubhipico.clubhipico_jcvargas.object.PersonaObject;

/* clase utilitario con metodos static */
public class ClubHipicoUtil {
	
	public static void montar(JineteObject jinete, CaballoObject caballo) {
		jinete.setCaballo(caballo);
		System.out.println("Jinete " + jinete.getNombre() + " se monta en " + caballo.getNombre());
	}

	/* Existe una sobrecarga de metodo con respecto al montar caballo */
	public static void montar(PersonaObject persona, CaballoObject caballo) {
		/*persona.setCaballo(caballo);*/
		System.out.println("Persona " + persona.getNombre() + " no se puede montar en caballo " + caballo.getNombre());
	}

	/* Existe una sobrecarga del metodo montar, recibiendo arreglos de jinetes y caballos */
	public static void montar(JineteObject[] jinetes, CaballoObject[] caballos) {
		
		//Validacion
		//Condicional if
		if (jinetes.length==caballos.length) {
			System.out.println("Se han recibido " + jinetes.length + " jinetes y " + caballos.length + " caballos");
			
			// Se evalua el arreglo, no un jinete
			if (jinetes.length==0) {
				System.out.println("Se requiere por lo menos un jinete y un caballo");
			}
			// Accedemos al primer jinete y evaluamos que sea sexo masculino
			if (jinetes[0].getSexo()!=SexoEnum.Macho) {
				System.out.println("El primer jinete tiene que ser de sexo masculino...");
			}
		} else {
			System.out.println("La cantidad de jinetes y caballos no coincide ...");
		}

	}
	
}
