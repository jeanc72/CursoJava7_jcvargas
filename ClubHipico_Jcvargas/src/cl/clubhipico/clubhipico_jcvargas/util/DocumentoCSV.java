package cl.clubhipico.clubhipico_jcvargas.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DocumentoCSV {

	
	public static String imputStreamToString(InputStreamReader is) throws IOException {
		final int bufferSize = 1024;
		final char[] buffer = new char[bufferSize];
		final StringBuilder out = new StringBuilder();
		Reader in = is;
		for (; ; ) {
		    int rsz = in.read(buffer, 0, buffer.length);
		    if (rsz < 0)
		        break;
		    out.append(buffer, 0, rsz);
		}
		return out.toString();
	}
	
	
	public static List<HashMap<String,Object>> readFile(String pathFile, String[] nombreColumnas, boolean poseeTitulo) throws IOException{
		String csvFile = pathFile;
		String line = "";
		String cvsSplitBy = ";";
		List<HashMap<String,Object>> listaArchivo = new ArrayList<HashMap<String,Object>> ();

			BufferedReader br = new BufferedReader(new FileReader(csvFile)); 
			int i=0;
			while ((line = br.readLine()) != null) {
				// use comma como separador
				String[] values = line.split(cvsSplitBy);

				//se debe obtener registro para dejarlo en lista de hashMap
				HashMap<String,Object> hm = new HashMap<String,Object>();

				for (int j=0; j< nombreColumnas.length && j<values.length; j++){
			
					if (ValidateType.isNumber(values[j])){
						values[j] = values[j].replaceAll("\"", "");
						hm.put(nombreColumnas[j], Integer.valueOf(values[j]));
					}else{
						values[j] = values[j].replaceAll("\"", "");
						hm.put(nombreColumnas[j], String.valueOf(values[j]));
					}
						
				}
				if ((!poseeTitulo && i==0) || i>0)
				    listaArchivo.add(hm);	
				
				i++;
			}

		return listaArchivo;
	}
	
	public static List<HashMap<String,Object>> readFile(String pathFile, String[] nombreColumnas) throws IOException{
		return readFile(pathFile, nombreColumnas, false);
	}
	
	public static void writteFile (String pathFile, List<HashMap<String,Object>> lista, boolean poseeTitulo) throws IOException{
		String csvFile = pathFile;
		String line = "";
		String cvsSplitBy = ";";
		List<HashMap<String,Object>> listaArchivo = new ArrayList<HashMap<String,Object>> ();

		BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile)); 
	
		bw.write("Hola");
		bw.newLine();
		bw.write("Hola");
		bw.write("Hola");
		bw.write("Hola");
		bw.write("Hola");
		bw.write("Hola");
		bw.close();
	}
	
}
