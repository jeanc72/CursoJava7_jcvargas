package cl.clubhipico.clubhipico_jcvargas;

import java.util.Date;

public class ClubHipicoThread implements Runnable /*extends Thread NO RECOMENDADO POR ORACLE, se recomienda implements Runnable*/{

	public String accion;
	public String nombre;
	
	public ClubHipicoThread(String nombre, String accion) {
		this.accion = accion;
		this.nombre = nombre;
	}
	
	public void log(String text) {
		System.out.println("[" + this.nombre + "] " + text);
	}
	
	@Override
	public void run() {
		double random = Math.random();
		log("Hola Thread..." + random);
		
		try {
			long segundos = Math.round(1000*20*random);
			log("Segundos detenidos " + segundos + "...");
			log("Realizando accion " + accion);
			Thread.sleep(segundos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log("Adios Thread..." + random);
	}

}
