package iut.bad;

class Femme extends Humain {
    public Femme(String nom, String prenom, int age) {
        super(nom, prenom, age);
    }

	@Override
	public String toString() {
		return "Femme [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
    
	  public static void main(String[] args) {
	        Homme homme = new Homme("Jean", "Jacques", 32);
	        Femme femme = new Femme("Marie", "Claire", 28);
	        
	        
	        homme.ami(femme, 100);
	       
	    }
}
