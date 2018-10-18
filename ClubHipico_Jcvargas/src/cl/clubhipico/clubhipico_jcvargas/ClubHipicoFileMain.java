package cl.clubhipico.clubhipico_jcvargas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import cl.clubhipico.clubhipico_jcvargas.util.DocumentoCSV;

public class ClubHipicoFileMain {
	
	public static void main (String[] args) {
		
		String path = "C://tmp//caballos.csv";
		String path2 = "C://tmp//caballossalida.csv";
		String[] columnas = {"RUT", "DV", "NOMBRE", "SEXO", "PESO"};
		
		List<HashMap<String, Object>> caballoList;
		
		try {
			caballoList = DocumentoCSV.readFile(path, columnas, true);
			System.out.println("Contenido archivo");
			System.out.println(caballoList);
			//DocumentoCSV.writteFile(path2, null, true);
			BufferedWriter bw = new BufferedWriter(new FileWriter(path2));
			for (HashMap<String, Object> caballo: caballoList) {
				bw.write(caballo.get("RUT").toString() + ";");
				bw.write(caballo.get("DV").toString() + ";");
				bw.write(caballo.get("NOMBRE").toString() + ";");
				bw.write(caballo.get("SEXO").toString() + ";");
				bw.write(caballo.get("PESO").toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
