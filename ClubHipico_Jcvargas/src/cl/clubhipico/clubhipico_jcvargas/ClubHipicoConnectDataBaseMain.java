package cl.clubhipico.clubhipico_jcvargas;

import java.sql.ResultSet;
import java.sql.SQLException;

import cl.clubhipico.clubhipico_jcvargas.object.CaballoObject;
import cl.clubhipico.clubhipico_jcvargas.util.ConnectDataBaseUtil;

public class ClubHipicoConnectDataBaseMain {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException { //En realidad no es recomendable, por que no se esta controlando la excepcion
		
		
		CaballoObject caballo = new CaballoObject();
		caballo.setRut(1);
		caballo.setDv('9');
		caballo.setNombre("Juanito");
		caballo.setPeso(400);
		
		
		/*Insert*/
        String insert = "INSERT INTO CABALLO (RUT,DV,NOMBRE,PESO) "
        		+ "VALUES ("+caballo.getRut()+Math.round((Math.random()*1000000))+","
        		+ "'"+caballo.getDv()+"',"
        		+ "'"+caballo.getNombre()+"',"
        		+ caballo.getPeso()+")";
        
        ConnectDataBaseUtil db = new ConnectDataBaseUtil();
        db.executarQuery(insert);
               
        /*Update*/
        String update = "update caballo set nombre = 'PEPITO' where rut = 1191885" ;
        db.executarQuery(update);
        
        /*Select*/
        String query = "SELECT * FROM CABALLO"; //No recomendado con *, escribir columnas. 
        ResultSet resultset = db.select(query);
        
        while (resultset.next()) {
        	System.out.println("RUT: " + resultset.getString("RUT") + " Nombre caballo: "+ resultset.getString("NOMBRE"));
        }
        
        System.out.println("Fin");
        
        
		
	}

}