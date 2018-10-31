package cl.clubhipico.clubhipico_jcvargas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.clubhipico.clubhipico_jcvargas.util.ConnectDataBaseUtil;

public class ClubHipicoThreadCJ7Persona implements Runnable {

	public ConnectDataBaseUtil db;
	
	public ClubHipicoThreadCJ7Persona (ConnectDataBaseUtil dbparam) {
		this.db = dbparam;
	}
	
	public void run() {
		try {
			String path = "C://tmp//propietarios.csv";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			
			//ConnectDataBaseUtil db = new ConnectDataBaseUtil();
	        String queryc = "SELECT rut, dv, nombre, correo, rut_fs FROM persona";
	        ResultSet resultsetc = db.select(queryc);
	        
	        //System.out.println("Creando archivo propietarios.csv desde tabla persona");
	        while (resultsetc.next()) {
		        bw.write(resultsetc.getString("RUT") + ";");
		        bw.write(resultsetc.getString("DV") + ";");
		        bw.write(resultsetc.getString("NOMBRE") + ";");
		        bw.write(resultsetc.getString("CORREO") + ";");
		        bw.write(resultsetc.getString("RUT_FS") );
		        bw.newLine();
	        }
	        bw.close();
	        //System.out.println("Archivo de propietarios ya creado...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
		
}
