package electronics_classes;

public class Peripherique {
	// Variables
	private String type; 
	private Ordinateur ordi;

	// Constructeur
	public Peripherique(String type){
		this.type = type;
	}

	// Getters and Setters
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Ordinateur getOrdi() {
		return ordi;
	}
	public void setOrdi(Ordinateur ordi) {
		this.ordi = ordi;
	}

	// Méthodes
	public String sampleMethod(){
		return this.type +" de "+this.ordi.sampleMethod();
	}

	public static void main(String[] args) {
		Ordinateur mac = new Ordinateur("Desktop", "Apple");
		Peripherique epson = new Peripherique("Imprimante");
		Peripherique logitec = new Peripherique("Souris");

		mac.addPeripherique(epson);
		mac.addPeripherique(logitec);

		System.out.println(mac.sampleMethod());
		System.out.println(epson.sampleMethod());
		System.out.println(logitec.sampleMethod());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Peripherique) {
			Peripherique p= (Peripherique)obj;
			return p.getType().equals(this.type);
		}
		return false; 
	}
}
