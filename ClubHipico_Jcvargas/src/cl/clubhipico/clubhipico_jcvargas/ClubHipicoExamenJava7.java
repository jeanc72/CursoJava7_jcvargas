package cl.clubhipico.clubhipico_jcvargas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import cl.clubhipico.clubhipico_jcvargas.util.ConnectDataBaseUtil;
import cl.clubhipico.clubhipico_jcvargas.util.DocumentoCSV;

public class ClubHipicoExamenJava7 {

	public static void main (String[] args) throws ClassNotFoundException, SQLException, IOException {
		

		String path = "C://tmp//caballos.csv";
		String path2 = "C://tmp//jinetes.csv";

		String[] columnasCab = {"RUT","DV","NOMBRE","SEXO","PESO"};
		String[] columnasJin = {"RUT","DV","NOMBRE","RUT_CAB"};
		
		//BufferedWriter bwc = new BufferedWriter(new FileWriter(path2));
		//BufferedWriter bwp = new BufferedWriter(new FileWriter(path3));
		
		List<HashMap<String, Object>> cabList;
		List<HashMap<String, Object>> jinList;
		
		try {
			/* Lee archivo */
			cabList = DocumentoCSV.readFile(path, columnasCab, true);
			jinList = DocumentoCSV.readFile(path2, columnasJin, true);
			
			System.out.println("Examen Curso Java 7");
			
			ConnectDataBaseUtil db = new ConnectDataBaseUtil();
			String deletec = "delete FROM CABALLO";
			db.executarQuery(deletec);
			String deletep = "delete FROM JINETE";
			db.executarQuery(deletep);
	        		
			/* Grabamos en BD */
			System.out.println("Insertando datos en tabla 'caballo' y 'jinete'...");
			System.out.println("");
			for (HashMap<String, Object> caballo: cabList) {
				String insertc = "INSERT INTO CABALLO (RUT,DV,NOMBRE,SEXO,PESO) "
		        		+ "VALUES ("+caballo.get("RUT").toString()+","
		        		+ "'"+caballo.get("DV").toString()+"',"
		        		+ "'"+caballo.get("NOMBRE").toString()+"',"
		        		+ "'"+caballo.get("SEXO").toString()+"',"
		        		+ caballo.get("PESO").toString()+")";
				db.executarQuery(insertc);
			}
			for (HashMap<String, Object> jinete: jinList) {
				String insertp = "INSERT INTO JINETE (RUT,DV,NOMBRE,RUT_CABALLO) "
		        		+ "VALUES ("+jinete.get("RUT").toString()+","
		        		+ "'"+jinete.get("DV").toString()+"',"
		        		+ "'"+jinete.get("NOMBRE").toString()+"',"
		        		+ jinete.get("RUT_CAB").toString()+")";
				db.executarQuery(insertp);
			}			
			System.out.println("Tablas ya insertadas...");
			
			System.out.println("");
			
			// Uso de Thread para crear archivo de salida
	        Thread cabjinThread = new Thread(new ClubHipicoThreadExamenJava7(db));
	        cabjinThread.start();
	        	        			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	}

}
