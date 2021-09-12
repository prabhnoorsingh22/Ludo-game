package dal.asdc.persistence.interfaces;

import java.sql.Connection;
import java.util.Map;

/**
 * @author Reshma Unnikrishnan**/

public interface IJdbc_connection {
	
	public Map<String,String> read_db_property_file();
	public Connection createDBConnection();
}
