import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

	public static void main(String[] args) {
		try {
		      //Nous appelons quatre fois la méthode getInstance()
		      PreparedStatement prepare = MainConnection.getInstance().prepareStatement("SELECT * FROM classe WHERE cls_nom = ?");

		      Statement state = MainConnection.getInstance().createStatement();

		      MainConnection.getInstance().setAutoCommit(false);

		      DatabaseMetaData meta = MainConnection.getInstance().getMetaData();
		         
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
	}

}
