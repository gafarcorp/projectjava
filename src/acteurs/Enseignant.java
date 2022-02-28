package acteurs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import acteurs.Administrateur;
import acteurs.Enseignant;
import mysql.Database;

public class Enseignant {
	private String nom;
	private String prenom;
	private String motpass;
	private String ueEnseigner;
	private List<Etudiant> etudiant;
	private Administrateur admin;
	
	public Enseignant() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	public String getMotpass() {
		return motpass;
	}

	public void setMotpass(String motpass) {
		this.motpass = motpass;
	}

	public String getUeEnseigner() {
		return ueEnseigner;
	}

	public void setUeEnseigner(String ueEnseigner) {
		this.ueEnseigner = ueEnseigner;
	}

	public List<Etudiant> getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(List<Etudiant> etudiant) {
		this.etudiant = etudiant;
	}
	
	
	
	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}

	public void seconnecter(String nom, String motpass) {
		Database con= new Database("jdbc:mysql://localhost:3306/notes", "root", "", "con.mysql.jdbc.Driver");
		Connection connection = con.connexion();
		if(connection!=null) {
			try {
			Statement st = connection.createStatement();
				ResultSet resultat = st.executeQuery("select * from enseignant where nom='"+nom+"'and motpass='"+motpass+"'");
				List<Enseignant> enseignant = new ArrayList<Enseignant>();
				while(resultat.next()) {
					Enseignant es = new Enseignant();
					es.setNom(resultat.getString("nom"));
					es.setNom(resultat.getString("motpass"));
					enseignant.add(es);
				}
				if(!enseignant.isEmpty()) {
					Enseignant es = new Enseignant();
					System.out.println("vous ete connecter\nque voulez vous faire monsieur??");
					System.out.println("1-enregistrer les note des etudiant\n2-modifier les note de reclamation\n");
					Scanner cs = new Scanner(System.in);
					int nbr;
					do {
						System.out.println("entrez un nombre comprise entre 1 et 2:");
						nbr= cs.nextInt();
					}while(nbr<1 || nbr>2);
					switch(nbr) {
					case 1:
						String val, val1, val2;
						int note;
						System.out.println("enregistrement de note");
						val2= cs.nextLine();
						System.out.println("nom etudiant:");
						val= cs.nextLine();
						System.out.println("nom de l'unite d'enseignement:");
						val1= cs.nextLine();
						System.out.println("la note definitif:");
						note= cs.nextInt();
						Etudiant et = new Etudiant();
						
						et.setNom(val);
						et.setUeEtudier(val1);
						et.setNoteUe(note);
						
						es.enregistrerNote(val,et);
						break;
					case 2:
						System.out.println("modification des note");
						es.modifierNote();
					}
				}else {
					System.out.println("identifiant ou mots de pass incorrect");
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
	}
	
	public void enregistrerNote(String nom, Etudiant et) {
		Database con= new Database("jdbc:mysql://localhost:3306/notes", "root", "", "con.mysql.jdbc.Driver");
		Connection connection = con.connexion();
		if(connection!=null) {
			try {
				Statement st = connection.createStatement();
				ResultSet resultat = st.executeQuery("select * from etudiant where nom='"+nom+"'");
				List<Etudiant> etudiant = new ArrayList<>();
				while(resultat.next()) {
					
					et.setNom(resultat.getString("nom"));
					etudiant.add(et);
				}
			
			if(!etudiant.isEmpty()) {
				
				st.executeUpdate("insert into note(nom, ue, noteue)"+"values('"+et.getNom()+"','"+et.getUeEtudier()+"','"+et.getNoteUe()+"')");
			}else {
				System.out.println("etudiant non enregistrer!!!");
			}
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
	}
	
	public void modifierNote() {
		/*
		 * auteur Gafar BADANA
		 **/
		Scanner cs = new Scanner(System.in);
		Enseignant es = new Enseignant();
		Etudiant et = new Etudiant();
		String ue, val;
		int note;
		Database con= new Database("jdbc:mysql://localhost:3306/notes", "root", "", "con.mysql.jdbc.Driver");
		Connection connection = con.connexion();
		if(connection!=null) {
			try {
				
				System.out.println("nom de l'etudiant:");
				val = cs.nextLine();
				System.out.println("nom de l'unite d'enseignement:");
				ue = cs.nextLine();
				System.out.println("la nouvelle note:");
				note = cs.nextInt();
				Statement st = connection.createStatement();
				ResultSet resultat = st.executeQuery("select * from note where nom='"+val+"' and ue='"+ue+"'");
				List<Etudiant> etudiant = new ArrayList<>();
				while(resultat.next()) {
					et.setNom(resultat.getString("nom"));
					et.setUeEtudier(resultat.getString("nom"));
					etudiant.add(et);
				}
				if(!etudiant.isEmpty()) {
					
					String query= ("update note set noteue='"+note+"' where ue='"+ue+"' and nom='"+val+"'");
					st.executeUpdate(query);
				}else {
					System.out.println("etudiant ou unite d'enseignement inconnus");
				}
				
		
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
	}

}
