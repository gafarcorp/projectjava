package acteurs;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import acteurs.Enseignant;
import mysql.Database;

public class Administrateur {
	
	private List<Etudiant> etudiant;
	private List<Enseignant> enseignant;
	private List<Ue> ue ;
	
	public Administrateur() {
		
	}

	public List<Etudiant> getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(List<Etudiant> etudiant) {
		this.etudiant = etudiant;
	}

	public List<Enseignant> getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(List<Enseignant> enseignant) {
		this.enseignant = enseignant;
	}
	
	
	public List<Ue> getUe() {
		return ue;
	}

	public void setUe(List<Ue> ue) {
		this.ue = ue;
	}

	public boolean enregistrer (Ue u) {
		Database con= new Database("jdbc:mysql://localhost:3306/notes", "root", "", "con.mysql.jdbc.Driver");
		Connection connection = con.connexion();
		if(connection!=null) {
			try {
			Statement st = connection.createStatement();
				st.executeUpdate("insert into ue(codeUe, nomUe, credit)"+"values('"+u.getCodeUe()+"','"+u.getNomUe()+"','"+u.getCredit()+"')");
				return true;
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		return false;
		
	}
	
	public void EnseignantUE(Enseignant es) {
		System.out.println("nom de l'enseignant: "+es.getNom()+"\nue enseigner: "+es.getUeEnseigner());
		
	}
	
	public boolean enregistrer (Enseignant es) {
			Database con= new Database("jdbc:mysql://localhost:3306/notes", "root", "", "con.mysql.jdbc.Driver");
			Connection connection = con.connexion();
			if(connection!=null) {
				try {
				Statement st = connection.createStatement();
					st.executeUpdate("insert into enseignant(nom, prenom, ueEnseigner, motpass)"+"values('"+es.getNom()+"','"+es.getPrenom()+"','"+es.getUeEnseigner()+"','"+es.getMotpass()+"')");
					return true;
				}catch(Exception e) {
					e.printStackTrace();
					
				}
			}
			return false;
		}

	
	public boolean enregistrer (Etudiant et) {
		Database con= new Database("jdbc:mysql://localhost:3306/notes", "root", "", "con.mysql.jdbc.Driver");
		Connection connection = con.connexion();
		if(connection!=null) {
			try {
			Statement st = connection.createStatement();
				st.executeUpdate("insert into etudiant(nom, prenom, ueEtudier, motpass)"+"values('"+et.getNom()+"','"+et.getPrenom()+"','"+et.getUeEtudier()+"','"+et.getMotpass()+"')");
				return true;
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		return false;
		
	}

}
