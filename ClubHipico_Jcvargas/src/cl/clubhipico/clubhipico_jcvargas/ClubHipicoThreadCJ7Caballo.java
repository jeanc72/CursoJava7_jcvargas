package cl.clubhipico.clubhipico_jcvargas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.clubhipico.clubhipico_jcvargas.util.ConnectDataBaseUtil;

public class ClubHipicoThreadCJ7Caballo implements Runnable {

	public ConnectDataBaseUtil db;
	
	public ClubHipicoThreadCJ7Caballo (ConnectDataBaseUtil dbparam) {
		this.db = dbparam;
	}
	
	public void run() {
		try {
			String path = "C://tmp//caballos.csv";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			
			//ConnectDataBaseUtil db = new ConnectDataBaseUtil();
	        String queryc = "SELECT rut, dv, nombre, sexo, peso FROM CABALLO";
	        ResultSet resultsetc = db.select(queryc);
	        
	        //System.out.println("Creando archivo caballos.csv desde tabla caballo");
	        while (resultsetc.next()) {
		        bw.write(resultsetc.getString("RUT") + ";");
		        bw.write(resultsetc.getString("DV") + ";");
		        bw.write(resultsetc.getString("NOMBRE") + ";");
		        bw.write(resultsetc.getString("SEXO") + ";");
		        bw.write(resultsetc.getString("PESO") );
		        bw.newLine();
	        }
	        bw.close();
	        //System.out.println("Archivo de caballos ya creado...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
