package dal.asdc.persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import dal.asdc.persistence.interfaces.IJdbc_connection;

/**
 * @author Reshma Unnikrishnan
 * */

public class Jdbc_connection implements IJdbc_connection{
	
	public Map<String,String> read_db_property_file() {
		Properties properties = new Properties();
		String property_file_name = "src/main/java/config.properties";
		Map<String, String> db_config = new HashMap<String,String>();
		
		try {
			FileReader prop_reader = new FileReader(property_file_name);
			properties.load(prop_reader);
			db_config.put("db_url",properties.getProperty("DB_URL"));
			db_config.put("db_uname",properties.getProperty("DB_Username"));
			db_config.put("db_password",properties.getProperty("DB_Password"));
			db_config.put("db_name",properties.getProperty("DB_Database_name"));
			db_config.put("db_driver",properties.getProperty("DB_Driver"));
			}
		catch(FileNotFoundException fnf){
			fnf.printStackTrace();
			}
		catch(IOException ioe) {
			ioe.printStackTrace();
			}
			return db_config;
	}
	
	public Connection createDBConnection() {
		Map<String, String> db_config = new HashMap<String,String>();
		db_config = read_db_property_file();
		Connection conn = null;
		try{  
			Class.forName(db_config.get("db_driver"));
			conn = DriverManager.getConnection(db_config.get("db_url"),db_config.get("db_uname"),db_config.get("db_password"));
		}catch(Exception e){ System.out.println(e);}  
			return conn;
			}
}
