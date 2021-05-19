package windowbuilder;

public class Osoba {

	private String jmeno;
	private String prijmeni;
	
	@Override
	public String toString() {
		return  jmeno + " "+ prijmeni ;
	}

	public Osoba(String jmeno, String prijmeni) {
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
	}
	
	
	
}
