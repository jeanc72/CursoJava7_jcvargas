package cl.clubhipico.clubhipico_jcvargas;

import java.util.Scanner;
import cl.clubhipico.clubhipico_jcvargas.controller.CarreraController;
import cl.clubhipico.clubhipico_jcvargas.object.CarreraObject;

public class ClubHipicoDataBaseMain {

	public static void main(String[] args) {
		
		/*PARA RECIBIR DESDE TECLADO*/
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		CarreraController carreraController = new CarreraController(); //controlador con logica
		
		/*Pedimos los parametros de entrada de la carrera*/
		System.out.println ("CLUB HIPICO");
		System.out.println ("===========");
        System.out.print ("Nombre carrera: " );

        String nombreCarrera = entradaEscaner.nextLine ();
        
        System.out.print ("Distancia carrera: " );
        int distanciaCarrera = Integer.parseInt(entradaEscaner.nextLine ());
        
        /*Instanciamos el objeto con los datos obtenidos desde el teclado*/
        CarreraObject carrera = new CarreraObject();
        carrera.setNombre(nombreCarrera);
        carrera.setDistancia(distanciaCarrera);
        
        /*Usamos el controlador*/
        //accion de insertar
        carreraController.insert(carrera);
        carreraController.update(carrera);
        
        System.out.println("Carrera recibida "+carrera);
        System.out.println("Distancia "+ carrera.getDistancia());
        
	}

}
