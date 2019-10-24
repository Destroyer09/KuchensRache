
public class Teilaufgabe {
	
	protected String name;
	protected int bearbeitungszeit;
	protected Teilaufgabe[] unteraufgaben;
	
	public static void main(String[] args){
		
		Teilaufgabe v1 = new Teilaufgabe("v1", 10);		
		Teilaufgabe v2 = new Teilaufgabe("v2", 25, new Teilaufgabe[] {v1});		
		Teilaufgabe v3 = new Teilaufgabe("v3", 15, new Teilaufgabe[] {v1});
		Teilaufgabe v4 = new Teilaufgabe("v4", 15, new Teilaufgabe[] {v3});		
		Teilaufgabe v5 = new Teilaufgabe("v5", 24, new Teilaufgabe[] {v2});		
		Teilaufgabe v6 = new Teilaufgabe("v6", 42, new Teilaufgabe[] {v2});
		Teilaufgabe v7 = new Teilaufgabe("v7", 89, new Teilaufgabe[] {v6});
		Teilaufgabe v8 = new Teilaufgabe("v8", 1337, new Teilaufgabe[] {v4, v5});
		Teilaufgabe v9 = new Teilaufgabe("v9", 1, new Teilaufgabe[] {v7, v8});

		
		System.out.println("Projektdauer v1: " + v1.projektdauer());
		System.out.println("Projektdauer v2: " + v2.projektdauer());
		System.out.println("Projektdauer v3: " + v3.projektdauer());
		System.out.println("Projektdauer v4: " + v4.projektdauer());
		System.out.println("Projektdauer v5: " + v5.projektdauer());
		System.out.println("Projektdauer v6: " + v6.projektdauer());
		System.out.println("Projektdauer v7: " + v7.projektdauer());
		System.out.println("Projektdauer v8: " + v8.projektdauer());
		System.out.println("Projektdauer v9: " + v9.projektdauer());

	}
	
	//Konstruktor falls die Teilaufgabe von Unteraufgaben abhängig ist
	public Teilaufgabe(String n, int b, Teilaufgabe[] u){
		name = n;
		bearbeitungszeit = b;
		unteraufgaben = u;
	}
	
	//Konstruktor falls die Teilaufgabe nicht von Unteraufgaben abhängig ist
	public Teilaufgabe(String n, int b){
		name = n;
		bearbeitungszeit = b;
		unteraufgaben = new Teilaufgabe[0];
	}
	
	
	protected int projektdauer(){
		
		Teilaufgabe[] unteraufgaben = getUnteraufgaben();
		int unteraufgabenDauer = 0;
		
		for(int i = 0; i< unteraufgaben.length; i++){
			
			if(unteraufgaben[i].projektdauer() > unteraufgabenDauer){
				
				unteraufgabenDauer = unteraufgaben[i].projektdauer();
				
			}
			
		}
		
		return unteraufgabenDauer + getBearbeitungszeit();
	}
	
	//getter
	
	protected String getName(){
		return name;
	}
	
	protected int getBearbeitungszeit(){
		return bearbeitungszeit;
	}
	
	protected Teilaufgabe[] getUnteraufgaben(){
		
		return unteraufgaben;
	
	}
	
	//setter
	
	protected void setName(String n){
		name = n;
	}
	
	protected void setBearbeitungszeit(int b){
		bearbeitungszeit = b;
	}
	
	protected void setUnteraufgaben(Teilaufgabe[] u){
		unteraufgaben = u;
	}
}
