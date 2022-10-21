import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connecttodb {
    // get database connection
	public Connection getConnect() throws SQLException, ClassNotFoundException {
		mainapp conn_o = new mainapp();
		Connection conn = conn_o.dbc();
		return conn;
	}

	// get ResultSet from database with query
	public ResultSet getResultSet(String inputquery) throws SQLException, ClassNotFoundException {
		Statement stmt = getConnect().createStatement();
		ResultSet rs = stmt.executeQuery(inputquery);
		return rs; //get different queries based on input
	}
}
