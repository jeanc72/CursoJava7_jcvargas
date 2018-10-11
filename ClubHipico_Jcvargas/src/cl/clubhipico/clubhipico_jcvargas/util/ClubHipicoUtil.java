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
			if (jinetes[0].getSexo()!=SexoEnum.Masculino) {
				System.out.println("El primer jinete tiene que ser de sexo masculino...");
			}
			
			System.out.println("");
			System.out.println("Opcion 1: FOR - Contador incremental");
			for (int i=0; i<jinetes.length; i++){
				System.out.println("Sexo Jinete " + (i+1) + " : " + jinetes[i].getSexo());
				if (jinetes[i].getSexo()==SexoEnum.Femenino) {
					System.out.println("Esta carrera es para jinetes masculino");
				}
			}
			
			System.out.println("");
			System.out.println("Opcion 2: FOR - Foreach");
			int i = 0;
			//FOR ([Objeto Nuevo] : [ARREGLO])
			for (JineteObject jinete: jinetes){
				System.out.println("Sexo Jinete " + (i+1) + " : " + jinete.getSexo());
				if (jinete.getSexo()==SexoEnum.Femenino) {
					System.out.println("Esta carrera es para jinetes masculino");
				}
				i++;
			}
			
			System.out.println("");
			System.out.println("Opcion 3: WHILE");
			i = 0; //Ya existe y lo volvemos a utilizar
			// SIEMPRE se tiene ue cumplir la condicion
			while (i<jinetes.length){
				System.out.println("Sexo Jinete " + (i+1) + " : " + jinetes[i].getSexo());
				if (jinetes[i].getSexo()==SexoEnum.Femenino) {
					System.out.println("Esta carrera es para jinetes masculino");
				}
				i++;
			}

			System.out.println("");
			System.out.println("Opcion 4: DO WHILE");
			i = 0; //Ya existe y lo volvemos a utilizar
			// AL MENOS se ejecuta una vez
			do {
				System.out.println("Sexo Jinete " + (i+1) + " : " + jinetes[i].getSexo());
				if (jinetes[i].getSexo()==SexoEnum.Femenino) {
					System.out.println("Esta carrera es para jinetes masculino");
				}
				i++;
			} while (i<jinetes.length) ;
			
		} else {
			System.out.println("La cantidad de jinetes y caballos no coincide ...");
		}

	}
	
}
