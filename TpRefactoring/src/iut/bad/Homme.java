package iut.bad;

class Homme extends Humain {
    public Homme(String nom, String prenom, int age) {
        super(nom, prenom, age);
    }

	@Override
	public String toString() {
		return "Homme [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
    
}
