package cl.clubhipico.clubhipico_jcvargas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import cl.clubhipico.clubhipico_jcvargas.util.ConnectDataBaseUtil;
import cl.clubhipico.clubhipico_jcvargas.util.DocumentoCSV;

public class ClubHipicoControlJava7 {

	public static void main (String[] args) throws ClassNotFoundException, SQLException, IOException {
		

		String path = "C://tmp//caballospropietarios.csv";
		//String path2 = "C://tmp//caballos.csv";
		//String path3 = "C://tmp//propietarios.csv";
		String[] columnas = {"RUT_FS","DV_FS","NOMBRE_FS","SEXO","PESO","RUT_PROP","DV_PROP","NOMBRE_PROP","CORREO"};
		
		//BufferedWriter bwc = new BufferedWriter(new FileWriter(path2));
		//BufferedWriter bwp = new BufferedWriter(new FileWriter(path3));
		
		List<HashMap<String, Object>> cabpropList;
		
		try {
			/* Lee archivo */
			cabpropList = DocumentoCSV.readFile(path, columnas, true);
			System.out.println("Control Curso Java 7");
			
			ConnectDataBaseUtil db = new ConnectDataBaseUtil();
			String deletec = "delete FROM CABALLO";
			db.executarQuery(deletec);
			String deletep = "delete FROM PERSONA";
			db.executarQuery(deletep);
	        		
			/* Grabamos en BD */
			//ConnectDataBaseUtil db = new ConnectDataBaseUtil();
			System.out.println("Insertando datos en tabla 'caballo' y 'persona'...");
			System.out.println("");
			for (HashMap<String, Object> caballo: cabpropList) {
				String insertc = "INSERT INTO CABALLO (RUT,DV,NOMBRE,SEXO,PESO) "
		        		+ "VALUES ("+caballo.get("RUT_FS").toString()+","
		        		+ "'"+caballo.get("DV_FS").toString()+"',"
		        		+ "'"+caballo.get("NOMBRE_FS").toString()+"',"
		        		+ "'"+caballo.get("SEXO").toString()+"',"
		        		+ caballo.get("PESO").toString()+")";
				db.executarQuery(insertc);
				String insertp = "INSERT INTO PERSONA (RUT,DV,NOMBRE,CORREO,RUT_fs) "
		        		+ "VALUES ("+caballo.get("RUT_PROP").toString()+","
		        		+ "'"+caballo.get("DV_PROP").toString()+"',"
		        		+ "'"+caballo.get("NOMBRE_PROP").toString()+"',"
		        		+ "'"+caballo.get("CORREO").toString()+"',"
		        		+ caballo.get("RUT_FS").toString()+")";
				db.executarQuery(insertp);

			}
			System.out.println("Tablas ya insertadas...");
			
			System.out.println("");
			
			/* Uso de Thread */

	        
	        Thread personaThread = new Thread(new ClubHipicoThreadCJ7Persona(db));
	        personaThread.start();
	        
			Thread caballoThread = new Thread(new ClubHipicoThreadCJ7Caballo(db));
	        caballoThread.start();
	        
			/*
	        String queryc = "SELECT rut, dv, nombre, sexo, peso FROM CABALLO";
	        ResultSet resultsetc = db.select(queryc);
	        System.out.println("Creando archivo caballos.csv");
	        while (resultsetc.next()) {
		        bwc.write(resultsetc.getString("RUT") + ";");
		        bwc.write(resultsetc.getString("DV") + ";");
		        bwc.write(resultsetc.getString("NOMBRE") + ";");
		        bwc.write(resultsetc.getString("SEXO") + ";");
		        bwc.write(resultsetc.getString("PESO") );
		        bwc.newLine();
	        }
	        bwc.close();
	        */
			/*
	        String queryp = "SELECT rut, dv, nombre, correo, rut_fs FROM PERSONA";
	        ResultSet resultsetp = db.select(queryp);
	        System.out.println("Creando archivo personas.csv");
	        while (resultsetp.next()) {
		        bwp.write(resultsetp.getString("RUT") + ";");
		        bwp.write(resultsetp.getString("DV") + ";");
		        bwp.write(resultsetp.getString("NOMBRE") + ";");
		        bwp.write(resultsetp.getString("CORREO") + ";");
		        bwp.write(resultsetp.getString("RUT_FS") );
		        bwp.newLine();
	        }
	        bwp.close();
	        */
	        
	        //System.out.println("Termino de Control Curso Java 7");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	}
}
