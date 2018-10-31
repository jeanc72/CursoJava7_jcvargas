package cl.clubhipico.clubhipico_jcvargas;

import java.util.HashMap;
import java.util.Scanner;

import cl.clubhipico.clubhipico_jcvargas.controller.CarreraController;
import cl.clubhipico.clubhipico_jcvargas.enums.PistaEnum;
import cl.clubhipico.clubhipico_jcvargas.object.CaballoObject;
import cl.clubhipico.clubhipico_jcvargas.object.CarreraObject;
import cl.clubhipico.clubhipico_jcvargas.object.PistaObject;

public class ClubHipicoDataBaseMain {

	public static void main(String[] args) {
		
		/*PARA RECIBIR DESDE TECLADO*/
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		CarreraController cc = new CarreraController(); //controlador con logica
		
		/*Pedimos los parametros de entrada de la carrera*/
		System.out.println ("CLUB HIPICO");
		System.out.println ("===========");
        System.out.print ("Nombre carrera: " );

        String nombreCarrera = entradaEscaner.nextLine ();
        
        System.out.print ("Distancia carrera: " );
        int distanciaCarrera = Integer.parseInt(entradaEscaner.nextLine ());
        
        /*Instanciamos el objeto con los datos obtenidos desde el teclado*/
        CarreraObject c = new CarreraObject();
        PistaObject p = new PistaObject();
        CaballoObject c1 = new CaballoObject();
        CaballoObject c2 = new CaballoObject();
        
        
        
        c.setNombre(nombreCarrera);
        c.setDistancia(distanciaCarrera);
        
        // Agregamos el valor para variable Pista
        p.setPista(PistaEnum.Arena);     
        //c.setPista(p);
        
        // Agregamos valor para caballo1
        c1.setNombre("PEL");
        c2.setNombre("PEPITO");
        // Usamos lista
        //c.getCaballo().add(c1);
        //c.getCaballo().add(c2);
        
        /*Usamos el controlador*/
        //accion de insertar, actualizar
        cc.insert(c);
        cc.update(c);
        
        System.out.println("Carrera recibida " + c);
        
        System.out.println("Nombre Carrera: "+ c.getNombre());
        System.out.println("Distancia: "+ c.getDistancia());
        
        System.out.println("Pista: "+ p.getPista());
        System.out.println("Pista: "+ c.getPista());

        System.out.println("Caballo1 con c1: "+ c1.getNombre());
        System.out.println("Caballo2 con c2: "+ c2.getNombre());
        
        // Recorrer lista
        //for (CaballoObject cab: c.getCaballo()) {
        //	System.out.println("Nombre caballo: " +  cab.getNombre());
        //}
        
		HashMap<String, CaballoObject> map = new HashMap<String,CaballoObject>();
		map.put("pista1", c1);
		map.put("pista2", c2);
		
		System.out.println("Nombre caballo 1:"+map.get("pista1").getNombre());
		System.out.println("Nombre caballo 2:"+map.get("pista2").getNombre());
        
		entradaEscaner.close();
	}

}
