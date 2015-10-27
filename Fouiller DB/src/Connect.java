import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Connect {

	public static void main(String[] args) {
		try {
		      Class.forName("org.postgresql.Driver");
		         
		      String url = "jdbc:postgresql://localhost:5432/Ecole";
		      String user = "postgres";
		      String passwd = "Passw0rd";
		         
		      /*Connection conn = DriverManager.getConnection(url, user, passwd);
		         
		      //Création d'un objet Statement
		      Statement state = conn.createStatement();
		      //L'objet ResultSet contient le résultat de la requête SQL
		      ResultSet result = state.executeQuery("SELECT * FROM classe");
		      //On récupère les MetaData
		      ResultSetMetaData resultMeta = result.getMetaData();
		         
		      System.out.println("\n**********************************");
		      //On affiche le nom des colonnes
		      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
		         
		      System.out.println("\n**********************************");
		         
		      while(result.next()){         
		        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		          System.out.print("\t" + result.getObject(i).toString() + "\t |");
		            
		        System.out.println("\n---------------------------------");

		      }

		      result.close();
		      state.close();*/
		      
		      /*Connection conn = DriverManager.getConnection(url, user, passwd);
		      Statement state = conn.createStatement();
		         
		      ResultSet result = state.executeQuery("SELECT * FROM professeur");
		      ResultSetMetaData resultMeta = result.getMetaData();

		      System.out.println("- Il y a " + resultMeta.getColumnCount() + " colonnes dans cette table");
		      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		        System.out.println("\t *" + resultMeta.getColumnName(i));        

		      System.out.println("Voici les noms et prénoms : ");
		      System.out.println("\n---------------------------------");

		      while(result.next()){
		        System.out.print("\t" + result.getString("prof_nom") + "\t |");
		        System.out.print("\t" + result.getString("prof_prenom") + "\t |");
		        System.out.println("\n---------------------------------");
		      }

		      result.close();
		      state.close();*/
		         
		      /*Connection conn = DriverManager.getConnection(url, user, passwd);
		      Statement state = conn.createStatement();

		      String query = "SELECT prof_nom, prof_prenom, mat_nom FROM professeur";
		      query += " INNER JOIN j_mat_prof ON jmp_prof_k = prof_id";
		      query += " INNER JOIN matiere ON jmp_mat_k = mat_id ORDER BY prof_nom";

		      ResultSet result = state.executeQuery(query);
		      String nom = "";

		      while(result.next()){            
		        if(!nom.equals(result.getString("prof_nom"))){
		          nom = result.getString("prof_nom");
		          System.out.println(nom + " " + result.getString("prof_prenom") + " enseigne : ");
		        }
		        System.out.println("\t\t\t - " +  result.getString("mat_nom"));
		      }

		      result.close();
		      state.close();*/
		      
		      /*Connection conn = DriverManager.getConnection(url, user, passwd);
		      Statement state = conn.createStatement();
		         
		      String query = "SELECT prof_nom, prof_prenom, mat_nom, cls_nom FROM professeur";
		      query += " INNER JOIN j_mat_prof ON jmp_prof_k = prof_id";
		      query += " INNER JOIN matiere ON jmp_mat_k = mat_id";
		      query += " INNER JOIN j_cls_jmp ON jcm_jmp_k = jmp_id";
		      query += " INNER JOIN classe ON jcm_cls_k = cls_id AND cls_id IN(1, 7)";
		      query += " ORDER BY cls_nom DESC, prof_nom";
		         
		      ResultSet result = state.executeQuery(query);
		      String nom = "";
		      String nomClass = "";
		         
		      while(result.next()){            
		        if(!nomClass.equals(result.getString("cls_nom"))){
		          nomClass = result.getString("cls_nom");
		          System.out.println("Classe de " + nomClass + " :");               
		        }

		        if(!nom.equals(result.getString("prof_nom"))){
		          nom = result.getString("prof_nom");
		          System.out.println("\t * " + nom + " " + result.getString("prof_prenom") + " enseigne : ");
		        }
		        System.out.println("\t\t\t - " +  result.getString("mat_nom"));
		      }

		      result.close();
		      state.close();*/
		      
		      /*Connection conn = DriverManager.getConnection(url, user, passwd);
		      Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		         
		      //On crée la requête
		      String query = "SELECT prof_nom, prof_prenom FROM professeur";
		      //Premier trou pour le nom du professeur
		      query += " WHERE prof_nom = ?";
		      //Deuxième trou pour l'identifiant du professeur
		      query += " OR prof_id = ?";
		         
		      //On crée l'objet avec la requête en paramètre
		      PreparedStatement prepare = conn.prepareStatement(query);
		      //On remplace le premier trou par le nom du professeur
		      prepare.setString(1, "MAMOU");
		      //On remplace le deuxième trou par l'identifiant du professeur
		      prepare.setInt(2, 2);
		      //On affiche la requête exécutée
		      System.out.println(prepare.toString());
		      //On modifie le premier trou
		      prepare.setString(1, "TOTO");
		      //On affiche à nouveau la requête exécutée
		      System.out.println(prepare.toString());
		      //On modifie le deuxième trou
		      prepare.setInt(2, 159753);
		      //On affiche une nouvelle fois la requête exécutée
		      System.out.println(prepare.toString());
		         
		      prepare.close();
		      state.close();*/
		      
		      /*Connection conn = DriverManager.getConnection(url, user, passwd);
		      Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		         
		      String query = "SELECT prof_nom, prof_prenom FROM professeur";         
		      ResultSet res = state.executeQuery(query);
		      int i = 1;         
		         
		      System.out.println("\n\t---------------------------------------");
		      System.out.println("\tLECTURE STANDARD.");
		      System.out.println("\t---------------------------------------");
		         
		      while(res.next()){
		        System.out.println("\tNom : "+res.getString("prof_nom") +" \t prénom : "+res.getString("prof_prenom"));
		        //On regarde si on se trouve sur la dernière ligne du résultat
		        if(res.isLast())
		          System.out.println("\t\t* DERNIER RESULTAT !\n");
		        i++;
		      }
		         
		      //Une fois la lecture terminée, on contrôle si on se trouve bien à l'extérieur des lignes de résultat
		      if(res.isAfterLast())
		        System.out.println("\tNous venons de terminer !\n");
		         
		      System.out.println("\t---------------------------------------");
		      System.out.println("\tLecture en sens contraire.");
		      System.out.println("\t---------------------------------------");
		         
		      //On se trouve alors à la fin
		      //On peut parcourir le résultat en sens contraire
		      while(res.previous()){
		        System.out.println("\tNom : "+res.getString("prof_nom") +" \t prénom : "+res.getString("prof_prenom"));

		        //On regarde si on se trouve sur la première ligne du résultat
		        if(res.isFirst())
		          System.out.println("\t\t* RETOUR AU DEBUT !\n");
		      }
		         
		      //On regarde si on se trouve avant la première ligne du résultat
		      if(res.isBeforeFirst())
		        System.out.println("\tNous venons de revenir au début !\n");
		         
		      System.out.println("\t---------------------------------------");
		      System.out.println("\tAprès positionnement absolu du curseur à la place N° "+ i/2 + ".");
		      System.out.println("\t---------------------------------------");
		      //On positionne le curseur sur la ligne i/2
		      //Peu importe où on se trouve
		      res.absolute(i/2);
		      while(res.next())
		        System.out.println("\tNom : "+res.getString("prof_nom") +" \t prénom : "+ res.getString("prof_prenom"));
		         
		      System.out.println("\t---------------------------------------");
		      System.out.println("\tAprès positionnement relatif du curseur à la place N° "+(i-(i-2)) + ".");
		      System.out.println("\t---------------------------------------");
		      //On place le curseur à la ligne actuelle moins i-2
		      //Si on n'avait pas mis de signe moins, on aurait avancé de i-2 lignes 
		      res.relative(-(i-2));
		      while(res.next())
		        System.out.println("\tNom : "+res.getString("prof_nom") +" \t prénom : "+res.getString("prof_prenom"));
		         
		      res.close();
		      state.close();*/
		      
		      /*Connection conn = DriverManager.getConnection(url, user, passwd);
		      //On autorise la mise à jour des données 
		      //Et la mise à jour de l'affichage
		      Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		      //On va chercher une ligne dans la base de données
		      String query = "SELECT prof_id, prof_nom, prof_prenom FROM professeur " + "WHERE prof_nom = 'MAMOU'";         
		      ResultSet res = state.executeQuery(query);
		      res.first();

		      //On affiche ce que l'on trouve
		      System.out.println("NOM : " + res.getString("prof_nom") + " - PRENOM : " + res.getString("prof_prenom"));

		      //On met à jour les champs
		      res.updateString("prof_nom", "COURTEL");
		      res.updateString("prof_prenom", "Angelo");
		      //On valide
		      res.updateRow();

		      //On affiche les modifications
		      System.out.println("*********************************");
		      System.out.println("APRES MODIFICATION : ");
		      System.out.println("\tNOM : " + res.getString("prof_nom") + " - PRENOM : " + res.getString("prof_prenom") + "\n");

		      //On remet les informations de départ
		      res.updateString("prof_nom", "MAMOU");
		      res.updateString("prof_prenom", "Daniel");
		      //On valide à nouveau
		      res.updateRow();

		      //Et voilà !
		      System.out.println("*********************************");
		      System.out.println("APRES REMODIFICATION : ");
		      System.out.println("\tNOM : " + res.getString("prof_nom") + " - PRENOM : " + res.getString("prof_prenom") + "\n");

		      res.close();
		      state.close();*/
		      
		      /*Connection conn = DriverManager.getConnection(url, user, passwd);
		      //On autorise la mise à jour des données 
		      //Et la mise à jour de l'affichage
		      Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		      PreparedStatement prepare = conn.prepareStatement("UPDATE professeur set prof_prenom = ? "+"WHERE prof_nom = 'MAMOU'");

		      //On va chercher une ligne dans la base de données
		      String query = "SELECT prof_nom, prof_prenom FROM professeur "+"WHERE prof_nom ='MAMOU'";         

		      //On exécute la requête
		      ResultSet res = state.executeQuery(query);
		      res.first();
		      //On affiche
		      System.out.println("\n\tDONNEES D'ORIGINE : ");
		      System.out.println("\t-------------------");
		      System.out.println("\tNOM : " + res.getString("prof_nom") + " - PRENOM : " +  res.getString("prof_prenom"));

		      //On paramètre notre requête préparée
		      prepare.setString(1, "Gérard");
		      //On exécute
		      prepare.executeUpdate();

		      res = state.executeQuery(query);
		      res.first();
		      //On affiche à nouveau
		      System.out.println("\n\t\t APRES MAJ : ");
		      System.out.println("\t\t * NOM : " + res.getString("prof_nom") + " - PRENOM :" + res.getString("prof_prenom"));
		                  
		      //On effectue une mise à jour
		      prepare.setString(1, "Daniel");
		      prepare.executeUpdate();
		         
		      res = state.executeQuery(query);
		      res.first();
		      //On affiche une nouvelle fois
		      System.out.println("\n\t\t REMISE A ZERO : ");
		      System.out.println("\t\t * NOM : " + res.getString("prof_nom") + " - PRENOM :" + res.getString("prof_prenom"));

		      prepare.close();
		      res.close();
		      state.close();*/
		      
		      Connection conn = DriverManager.getConnection(url, user, passwd);
		      conn.setAutoCommit(false);
		      Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		      String query = "UPDATE professeur SET prof_prenom = 'Cyrille' "+"WHERE prof_nom = 'MAMOU'";
		         
		      ResultSet result = state.executeQuery("SELECT * FROM professeur"+" WHERE prof_nom = 'MAMOU'");
		      result.first();
		      System.out.println("NOM : " + result.getString("prof_nom") + " - PRENOM : " + result.getString("prof_prenom"));
		         
		      state.executeUpdate(query);
		         
		      result = state.executeQuery("SELECT * FROM professeur WHERE prof_nom = 'MAMOU'");
		      result.first();
		      System.out.println("NOM : " + result.getString("prof_nom") + " - PRENOM : " + result.getString("prof_prenom"));
		         
		      result.close();
		      state.close();
		      
		    } catch (Exception e) {
		      e.printStackTrace();
		    } 
	}

}
