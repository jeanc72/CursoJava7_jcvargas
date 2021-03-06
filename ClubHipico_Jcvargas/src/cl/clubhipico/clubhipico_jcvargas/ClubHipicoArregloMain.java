package cl.clubhipico.clubhipico_jcvargas;

import cl.clubhipico.clubhipico_jcvargas.enums.SexoEnum;
import cl.clubhipico.clubhipico_jcvargas.object.CaballoObject;
import cl.clubhipico.clubhipico_jcvargas.object.JineteObject;
import cl.clubhipico.clubhipico_jcvargas.object.PersonaObject;
import cl.clubhipico.clubhipico_jcvargas.util.ClubHipicoUtil;
import cl.clubhipico.clubhipico_jcvargas.util.ClubHipicoUtilNoStatic;

public class ClubHipicoArregloMain {

	public static void main(String[] args) {
		
		JineteObject jinete =  new JineteObject();
		jinete.setNombre("Claudio");
		
		CaballoObject caballo = new CaballoObject();
		caballo.setNombre("Juanito");
		
		PersonaObject persona = new PersonaObject();
		persona.setNombre("Andres");
		
		ClubHipicoUtil.montar(jinete, caballo);
		ClubHipicoUtil.montar(persona, caballo);
		
		//Arreglo Jinetes
		// 1- Delarar el arreglo con un tipo de tamano
		JineteObject[] jinetesArray = new JineteObject[3];
		// 2 - Instancias cada uno de las posiciones
		jinetesArray[0] = new JineteObject();
		jinetesArray[1] = new JineteObject();
		jinetesArray[2] = new JineteObject();
		// 3- Manipulas, llenas con informacion o usas funciones / metodos
		jinetesArray[0].setNombre("Pepito");
		jinetesArray[1].setNombre("Juanito");
		jinetesArray[2].setNombre("Pedrito");
		jinetesArray[0].setSexo(SexoEnum.Femenino);
		jinetesArray[1].setSexo(SexoEnum.Femenino);
		jinetesArray[2].setSexo(SexoEnum.Femenino);
		
		System.out.println("");
		
		//Arreglo Caballos
		// 1- Otra forma de instanciar el arreglo
		CaballoObject[] caballosArray = {caballo, caballo, caballo };

		ClubHipicoUtil.montar(jinetesArray, caballosArray);
		
		System.out.println("");
		System.out.println("Utilitario No Static");
		ClubHipicoUtilNoStatic util = new ClubHipicoUtilNoStatic();
		util.montar(jinetesArray, caballosArray);
		System.out.println("");
		util.montar(jinete, caballo);
     
	}

}
