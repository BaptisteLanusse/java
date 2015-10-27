import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MainConnection {
	private String url = "jdbc:postgresql://localhost:5432/Ecole";
	//Nom du user
	private String user = "postgres";
	//Mot de passe de l'utilisateur
	private String passwd = "Passw0rd";
	//Objet Connection
	private static Connection connect;

	//Constructeur privé
	private MainConnection(){
		try {
			connect = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
	public static Connection getInstance(){
		if(connect == null){
			new MainConnection();
			System.out.println("INSTANCIATION DE LA CONNEXION SQL ! ");
		} else {
			System.out.println("CONNEXION SQL EXISTANTE !");
		}
		return connect;   
	}
}
