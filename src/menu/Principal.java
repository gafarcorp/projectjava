package menu;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import acteurs.Administrateur;
import acteurs.DetailAchatUe;
import acteurs.Enseignant;
import acteurs.Etudiant;
import acteurs.Ue;
import mysql.Database;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cs = new Scanner(System.in);
		String URL = "jdbc:mysql://localhost:3306/notes";
		String className = "con.mysql.jdbc.Driver";
		Database con = new Database(URL, "root", "", className);
		
		Connection conn = con.connexion();
		if(conn==null) {
			System.out.println("la connection n'est pas passer");
		}else {
			System.out.println("connexion Etablie");
		}
		
		Administrateur ad = new Administrateur();
		DetailAchatUe dt = new DetailAchatUe();
		int nbr, nbr1 , menu , menu1;
		String value, value1, value2, value3, dao;
		
		System.out.println("********************Gestion des notes Etudiants***********************");
		System.out.println("********************quel est votre identite??***********************");
		System.out.println("1- je suis administrateur\n 2-je suis Enseignant\n 3- je suis Etudiant");
		
		do {
			System.out.println("entrer un nombre comprise entre 1 et 3: ");
			menu = cs.nextInt();
		}while(menu<1 || menu>3);
		
		switch(menu) {
		case 1:
			System.out.println("bienvenu adminstrateur que voulez-vous faire??");
			System.out.println("1- enregistre les UE\n2- enregistrer les enseignant\n3-enregistrer un etudiant\n");
			do {
				System.out.println("entrer un nombre comprise entre 1 et 3: ");
				menu1 = cs.nextInt();
			}while(menu1 < 1 || menu1 >3);
			
			switch(menu1) {
			case 1:
				System.out.println("enregistrement des UE");
				dao = cs.nextLine();
				System.out.println("le code de UE: ");
				value = cs.nextLine();
				System.out.println("le nom de UE: ");
				value1 = cs.nextLine();
				
				System.out.println("le nbr de credit de UE: ");
				nbr = cs.nextInt();
				
				Ue u = new Ue();
				u.setCodeUe(value);
				u.setNomUe(value1);
				u.setCredit(nbr);
				
				ad.enregistrer(u);
				break;
			case 2:
				System.out.println("enregistrement du nom de l'enseignant");
				dao = cs.nextLine();
				System.out.println("le nom de l'enseignant: ");
				value = cs.nextLine();
				System.out.println("le prenom de l'enseignant: ");
				value1 = cs.nextLine();
				System.out.println("le ue intervenant: ");
				value2 = cs.nextLine();
				System.out.println("le mots de pass: ");
				value3 = cs.nextLine();
				
				Enseignant es = new Enseignant();
				es.setNom(value);
				es.setPrenom(value1);
				es.setUeEnseigner(value2);
				es.setMotpass(value3);
				
				ad.enregistrer(es);
				
				ad.EnseignantUE(es);
				break;
			case 3:
				System.out.println("enregistrement du nom de l'etudiant");
				dao = cs.nextLine();
				System.out.println("le nom de l'etudiant: ");
				value = cs.nextLine();
				System.out.println("le prenom de l'etudiant: ");
				value1 = cs.nextLine();
				System.out.println("le ue etudier par etudiant: ");
				value2 = cs.nextLine();
				System.out.println("le mots de pass: ");
				value3 = cs.nextLine();
				
				Etudiant et = new Etudiant();
				et.setNom(value);
				et.setPrenom(value1);
				et.setUeEtudier(value2);
				et.setMotpass(value3);
				
				ad.enregistrer(et);
				
			}
			break;
		case 2:
			System.out.println("svp veiller vous connecter a votre a votre page de profile");
			dao= cs.nextLine();
			System.out.println("votre nom enregistrer par votre administrateur:");
			value= cs.nextLine();
			System.out.println("votre mots de pass");
			value1 = cs.nextLine();
			Enseignant es = new Enseignant();
			es.seconnecter(value, value1);
			break;
		case 3:
			System.out.println("svp veiller vous connecter a votre a votre page de profile");
			dao= cs.nextLine();
			System.out.println("votre nom enregistrer par votre administrateur:");
			value= cs.nextLine();
			System.out.println("votre mots de pass");
			value1 = cs.nextLine();
			Etudiant et = new Etudiant();
			et.seconnecter(value, value1);
			break;
		}

	}

}
