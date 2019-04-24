package ConexionBBDD;

import java.sql.*;

import javax.swing.*;

public class Conectar {
		
		static String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		static String dbName = "progamacionfinalbatalla";
		static String url = "jdbc:mysql://localhost:3306/" + dbName + timeZone;
		static String user = "root";
		static String pass = "manolo";
		static String driver = "com.mysql.cj.jdbc.Driver";
	    
	    static Connection conexion;
	    static Statement consulta;
	    static ResultSet resultado;
	    
	    public static void Conectar(){
	    	try {
	           Class.forName(driver) ;
	           conexion = DriverManager.getConnection(url, user, pass);
	           consulta = conexion.createStatement();
	        }catch(Exception e){
	            JOptionPane.showMessageDialog(null, e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    
	    public static String[] EjecutarSentencia(String Sentencia, String tabla){
	    	int cont = saberLongitud(Sentencia, tabla);
	    	String[] devolver = new String[cont];
	        try {
	        	resultado = consulta.executeQuery(Sentencia);
	        	for (int i = 0; resultado.next(); i++) {
	        		devolver[i] = resultado.getString(tabla);
				}
	        }catch(Exception e){
	        }
	        return devolver;
	    }
	      
	    public static void EjecutarUpdate(String Sentencia) throws SQLException{
	    	try{
	    		consulta.executeUpdate(Sentencia);
	    	}catch(SQLException e){
	    		e.printStackTrace();
 
	    	} 
	    }
	    
	    public static void CerrarConexion(){
	        try{
	        	consulta.close();
	        }catch(Exception e){}
	    }
	    
	    public static int saberLongitud(String Sentencia, String tabla) {
	    	int num = 0;
	    	try {
	        	resultado = consulta.executeQuery(Sentencia);
	        	while (resultado.next()) {
	        		num++;
				}
	        }catch(Exception e){
	        }
	    	return num;
	    }

}
