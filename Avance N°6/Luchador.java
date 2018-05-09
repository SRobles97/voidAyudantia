package progra;

public class Luchador extends Personaje {
	private String name;
	private int rank;
	
	Luchador(){
		this.name = getLista(nombresLuchadores());
		this.rank = getRank(this.rank);
		this.hp = random(200,500)*this.rank;
		this.atk = random(20,70)*this.rank;
		this.def = random(5,25)*this.rank;		
		this.spd = random(10,100)*this.rank;		
	}
	
	public String getName() {
		return this.name;
	}
	
	public int rank() {
		return this.rank;
	}
	
	private int getRank(int ranking) {
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
	
    private String[] nombresLuchadores() {
    	String[] nombres = {"Igor Spopovich","Egg King","God","Dylantero","Messi","Chefcito","Jeff","King Dragon","Satanael","Caligula","Papa Franku","Pink Guy","Dross","Freetanga","Kast"};
    	return nombres;
    }	
    
    public void mostrarDatos() {
    	System.out.println("Nombre: "+this.name+"\nFaccion: "+this.guild+"\tRango: "+this.rank+"\n");       	
    }
    
    public void mostrarStats() { 
    	System.out.println("Nombre: "+this.name+"\nFaccion: "+this.guild+"\t\t\t Estrellas: "+this.rank+"\nHP: "+this.hp+"\nAtaque: "+this.atk+"\nDefensa: "+this.def+"\nVelocidad: "+this.spd);
    }
	
}
	


