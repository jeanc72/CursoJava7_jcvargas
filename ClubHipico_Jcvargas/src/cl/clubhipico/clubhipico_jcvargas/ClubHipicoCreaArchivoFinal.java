package cl.clubhipico.clubhipico_jcvargas;

import java.sql.SQLException;

import cl.clubhipico.clubhipico_jcvargas.util.ConnectDataBaseUtil;

public class ClubHipicoCreaArchivoFinal {

	
	public void creaArchivo() throws ClassNotFoundException, SQLException {
		
		ConnectDataBaseUtil db = new ConnectDataBaseUtil();
		/* Uso de Thread */ 
        Thread personaThread = new Thread(new ClubHipicoThreadCJ7Persona(db));
        personaThread.start();
        
		Thread caballoThread = new Thread(new ClubHipicoThreadCJ7Caballo(db));
        caballoThread.start();
	}

}
