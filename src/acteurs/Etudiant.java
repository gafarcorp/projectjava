package acteurs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mysql.Database;

public class Etudiant {
	private int id;
	private String nom;
	private String prenom;
	private String motpass;
	private String ueEtudier;
	private int noteUe;
	private Enseignant enseignant;
	private Administrateur admin;
	
	public Etudiant() {
		
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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

	public String getUeEtudier() {
		return ueEtudier;
	}

	public void setUeEtudier(String ueEtudier) {
		this.ueEtudier = ueEtudier;
	}
	
	

	public int getNoteUe() {
		return noteUe;
	}

	public void setNoteUe(int noteUe) {
		this.noteUe = noteUe;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
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
				ResultSet resultat = st.executeQuery("select * from etudiant where nom='"+nom+"'and motpass='"+motpass+"'");
				List<Etudiant> etudiant = new ArrayList<>();
				while(resultat.next()) {
					Etudiant et = new Etudiant();
					et.setNom(resultat.getString("nom"));
					et.setNom(resultat.getString("motpass"));
					etudiant.add(et);
				}
				if(!etudiant.isEmpty()) {
					Etudiant et = new Etudiant();
					System.out.println("vous ete connecter\nque voulez vous faire monsieur??");
					System.out.println("1-consulter les notes\n2-reclamer une note\n");
					Scanner cs = new Scanner(System.in);
					int nbr;
					String value;
					do {
						System.out.println("entrez un nombre comprise entre 1 et 2:");
						nbr= cs.nextInt();
					}while(nbr<1 || nbr>2);
					
					switch(nbr) {
					case 1:
						
						et.consulter();
						break;
					case 2:
						et.reclamer();
						break;
					}
				}else {
					System.out.println("idenfiant ou mot de pass incorrect");
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
		}
				
		
	}
	
	public void consulter() {
		Scanner cs = new Scanner(System.in);
		Etudiant et = new Etudiant();
		String value;
		Database con= new Database("jdbc:mysql://localhost:3306/notes", "root", "", "con.mysql.jdbc.Driver");
		Connection connection = con.connexion();
		if(connection!=null) {
			try {
				System.out.println("votre nom svp:");
				value= cs.nextLine();
				et.setNom(value);
			    Statement st = connection.createStatement();
				ResultSet resultat = st.executeQuery("select * from note where nom='"+value+"'");
				
				while(resultat.next()) {
					System.out.println("unite d'enseignement        : "+resultat.getString("ue"));
					System.out.print("note de l'unite d'enseignement: "+resultat.getInt("noteue"));
					if(resultat.getInt("noteue")>=10) {
						System.out.println("       unite d'enseignement valider");
					}else {
						System.out.println("       unite d'enseignement nonvalider");
					}
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
	}
	
	public void reclamer() {
		Scanner cs = new Scanner(System.in);
		Etudiant et = new Etudiant();
		String value, value1;
		System.out.println("svp monsieur je compt faire une reclamation");
		System.out.println("nom de l'etudiant:");
		value = cs.nextLine();
		System.out.println("nom de l'unite d'enseignement:");
		value1 = cs.nextLine();
		System.out.println("nom etudiant: "+value+"\nuniter d'enseignement de reclamation: "+value1);
		System.out.println("message envoyer au correcteur votre reclamation sera prise en compt");
		
	}
	

}
