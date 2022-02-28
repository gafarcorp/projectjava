package acteurs;

public class Ue {
	private String codeUe;
	private String nomUe;
	private int credit;
	private Enseignant enseignant;
	private Administrateur admin;
	
	public Ue() {
		
	}

	public String getCodeUe() {
		return codeUe;
	}

	public void setCodeUe(String codeUe) {
		this.codeUe = codeUe;
	}

	public String getNomUe() {
		return nomUe;
	}

	public void setNomUe(String nomUe) {
		this.nomUe = nomUe;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
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
	
	
	

}
