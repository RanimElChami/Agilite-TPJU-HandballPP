package electronics_classes;

import java.util.ArrayList;

public class Ordinateur {
	public String type;
	public String brand;
	public ArrayList<Peripherique> peripheriques;

	// Constructeur
	public Ordinateur(String type, String brand){
		this.type = type;
		this.brand = brand;
		this.peripheriques = new ArrayList<Peripherique>();
	}

	// Getters and setters
	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getBrand(){
		return this.brand;
	}
	public void setBrand(String brand){
		this.brand = brand;
	}
	public ArrayList<Peripherique> getPeripheriques() {
		return peripheriques;
	}
	public void setPeripheriques(ArrayList<Peripherique> peripheriques) {
		this.peripheriques = peripheriques;
	}

	// Méthodes
	public String sampleMethod(){
		String peripheriques = "\nPeripheriques : \n";
		for(Peripherique p : this.peripheriques) {
			peripheriques = peripheriques+p.getType()+"\n";
		}
		return type + " " + brand + peripheriques;
	}

	public void addPeripherique(Peripherique p) {
		p.setOrdi(this);
		this.peripheriques.add(p);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ordinateur) {
			Ordinateur ordi= (Ordinateur)obj;
			return ordi.getType().equals(this.type) && ordi.getBrand().equals(this.brand) 
					&& ordi.getPeripheriques().equals(this.peripheriques);
		}
		return false;
	}

}