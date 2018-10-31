package cl.clubhipico.clubhipico_jcvargas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import cl.clubhipico.clubhipico_jcvargas.util.ConnectDataBaseUtil;
import cl.clubhipico.clubhipico_jcvargas.util.DocumentoCSV;

public class ClubHipicoCargaArchivoFinal {


	public String CargaArchivo(String path) throws ClassNotFoundException, SQLException, IOException {
	//String path = "C://tmp//caballospropietarios.csv";
	String[] columnas = {"RUT_FS","DV_FS","NOMBRE_FS","SEXO","PESO","RUT_PROP","DV_PROP","NOMBRE_PROP","CORREO"};
	
	
	List<HashMap<String, Object>> cabpropList;
	
	try {
		/* Lee archivo */
		cabpropList = DocumentoCSV.readFile(path, columnas, true);
		//System.out.println("Control Curso Java 7");
		
		ConnectDataBaseUtil db = new ConnectDataBaseUtil();
		String deletec = "delete FROM CABALLO";
		db.executarQuery(deletec);
		String deletep = "delete FROM PERSONA";
		db.executarQuery(deletep);
        		
		/* Grabamos en BD */
		//ConnectDataBaseUtil db = new ConnectDataBaseUtil();
		//System.out.println("Insertando datos en tabla 'caballo' y 'persona'...");
		//System.out.println("");
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
		//System.out.println("Tablas ya insertadas...");
		
		//System.out.println("");
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return("Tablas ya insertadas");
	}
}
