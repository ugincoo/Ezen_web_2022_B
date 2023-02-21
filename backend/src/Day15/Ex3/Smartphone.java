package Day15.Ex3;

public class Smartphone {

	private String company;
	private String os;
	
	public Smartphone(String company, String os) {
		super();
		this.company = company;
		this.os = os;
	}
	@Override
	public String toString() {
	
		return company+"-"+os;
	}
	
	
	
}
