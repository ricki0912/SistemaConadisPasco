package funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	public static String URL_INICIO ="jdbc:mysql://";
	public static String HOST_NAME=getIpServidor();
	public static String BASE_DATOS="conadis_prueba_V12";
	public static final String UNICODE="?useUnicode=yes&characterEncoding=UTF-8";
	public static String SERVIDOR=URL_INICIO+HOST_NAME+"/"+BASE_DATOS + UNICODE;
	public static final String USER="CONADIS";
	public static final String PASS="C0NAD1S2O18";
	
	//public static final String USER="root";
	//public static final String PASS="";

	
	
	public static Connection CONN=null;
	


	public static String getIpServidor(){
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	         String texto="";


	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File ("servidor/ip"); //"C:\\archivo.txt"
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         //texto
	         String linea;
	         while((linea=br.readLine())!=null){
	        	 texto=texto+linea;
	         }
	         
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
		
	      return texto;
	}

	
	public static void conectarDB(){
		
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	        	//System.out.println(URL_BASE_DATOS);

	        	CONN = DriverManager.getConnection(URL_INICIO+HOST_NAME+"/"+BASE_DATOS + UNICODE, USER, PASS);
	            
	        } catch (ClassNotFoundException | SQLException ex) {
	          System.out.println("Problemas al realizar la conexi�n");
	        	ex.printStackTrace();
	        }
	      
	    }
	
	
public static Connection getConexion(){
	
	return CONN;
}


public static void close(){
	try {
		if(CONN!=null){
		CONN.close();
		}
	} catch (SQLException e) {
		System.out.println("Problemas al cerrar la conexion :(");
		e.printStackTrace();
	}
}
}
