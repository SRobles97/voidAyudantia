package ayudantia;

import java.util.Random;
public class Luchador {
	private int rank;
	private int hp;
	private int atk;
	private int def;
	private int agi;
	private String name;
	private String guild;	
	private objetoEquipable[] equipo;
	
	Luchador(){
		this.name = getNombre(nombresLuchadores());
		this.rank = generarEstrella(this.rank);
		this.hp = random(200,500)*this.rank;
		this.atk = random(20,70)*this.rank;
		this.def = random(5,25)*this.rank;		
		this.agi = random(10,100)*this.rank;	
		this.guild = getNombre(nombresFacciones());
		this.equipo = new objetoEquipable[4];
	}
	
	private int generarEstrella(int ranking) {
		double azar = Math.random();
		if(azar < 0.4) {
			ranking = 1;			
		}else if(azar < 0.7) {
			ranking = 2;
		}else if(azar < 0.85) {		
			ranking = 3;
		}else if(azar < 0.95) {
			ranking = 4;			
		}else {
			ranking = 5;
		}
		return ranking;	
	} 
	
	public void equiparObjeto(objetoEquipable objeto) { 
		if(objeto.getTipo().equals("Armadura")) {
			this.hp += objeto.getMejora();
			this.equipo[0] = objeto;
		}else if(objeto.getTipo().equals("Espada")){
			this.atk += objeto.getMejora();			
			this.equipo[1] = objeto;			
		}else if(objeto.getTipo().equals("Escudo")){
			this.def += objeto.getMejora();		
			this.equipo[2] = objeto;			
		}else {
			this.agi += objeto.getMejora();		
			this.equipo[3] = objeto;			
		}
	}
	
	private int random(int a, int b) { 
		Random azar = new Random();
		int rango = b-a;
		int aleatorio = azar.nextInt(rango+1)+a;
		return aleatorio;
	}
	
    private String[] nombresLuchadores() {
    	String[] nombres = {"Igor Spopovich","Huevito Rey","God","Dylantero","Messi","Chefcito","Jeff","King Dragon","Satanael","Caligula","Papa Franku","Pink Guy","Dross","Roerto","H3H3","Tarro","Zatman","J","Le Tongue"};
    	return nombres;
    }
    
    private String[] nombresFacciones() {
    	String[] nombres = {"Fuego","Agua","Planta"};
    	return nombres;
    }
    
    private String getNombre(String[] list) {
      int a = random(0,list.length-1);
      String nombre = list[a];
      return nombre;
    }
    
    public int getHP() {
    	return this.hp;
    }
    
    public int getATK() {
    	return this.atk;
    }
    
    public int getDEF() {
    	return this.def;
    }
    
    public int getAGI() {
    	return this.agi;
    }  
    
    public String getName() {
    	return this.name;
    }
    
    public String getGuild() {
    	return this.guild;
    }
    
    public int getRank() {
    	return this.rank;
    }
    
    public void mostrarStats() { 
    	System.out.println("Nombre: "+this.name);
    	System.out.println("Faccion: "+this.guild+"\t\t\t Estrellas: "+this.rank);   
    	System.out.println("HP: "+this.hp+"\nAtaque: "+this.atk+"\nDefensa: "+this.def+"\nVelocidad: "+this.agi);
    }
    
    public void mostrarDatos() { 
    	System.out.println("Nombre: "+this.name);
    	System.out.println("Faccion: "+this.guild+"\t\t\t Estrellas: "+this.rank);    	    	
    }
    
}
    

