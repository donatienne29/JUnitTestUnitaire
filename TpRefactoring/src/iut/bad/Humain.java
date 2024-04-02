package iut.bad;

public class Humain {
	protected String nom;
    protected String prenom;
    protected int age;

    public Humain(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    
    public void details() {
        System.out.println("Nom: " + nom + ", Prénom: " + prenom + ", Âge: " + age);
    }
    
    public String toString() {
    return "Nom: " + nom + ", Prénom: " + prenom + ", Âge: " + age;
    }
    
    public void manger() {
       
    }

    public void boire() {
       
    }
    
    public void ami(Humain humain, int duree) {
        System.out.println(this.prenom + " est ami avec " + humain.prenom + " depuis " + duree + " jours.");
    }
    
    


  

}
