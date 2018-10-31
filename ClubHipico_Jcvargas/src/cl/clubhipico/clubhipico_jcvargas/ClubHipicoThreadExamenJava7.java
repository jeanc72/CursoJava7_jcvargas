package cl.clubhipico.clubhipico_jcvargas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.clubhipico.clubhipico_jcvargas.util.ConnectDataBaseUtil;

public class ClubHipicoThreadExamenJava7 implements Runnable {

		public ConnectDataBaseUtil db;
		
		public ClubHipicoThreadExamenJava7 (ConnectDataBaseUtil dbparam) {
			this.db = dbparam;
		}
		
		public void run() {
			try {
				String path = "C://tmp//caballosjinetes.csv";
				BufferedWriter bw = new BufferedWriter(new FileWriter(path));
				
		        String querycj = "SELECT j.rut rutjin, j.nombre nombrejin, c.rut rutcab, c.nombre nombrecab FROM CABALLO C, JINETE J where j.rut_caballo = c.rut";
		        ResultSet resultsetcj = db.select(querycj);
		        
		        System.out.println("Creando archivo caballosjinetes.csv desde BD...");
		        while (resultsetcj.next()) {
			        bw.write(resultsetcj.getString("rutjin") + ";");
			        bw.write(resultsetcj.getString("nombrejin") + ";");
			        bw.write(resultsetcj.getString("rutcab") + ";");
			        bw.write(resultsetcj.getString("nombrecab") );
			        bw.newLine();
		        }
		        bw.close();
		        System.out.println("Archivo CSV ya creado...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
}
