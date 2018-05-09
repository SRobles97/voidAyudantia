package progra;

import java.util.Random;

public class Personaje {
	protected String guild;
	protected int hp;
	protected int atk;
	protected int def;
	protected int spd;
		
	Personaje(){
		this.guild = getLista(nombresFacciones());					
	}
	
	public String getGuild() {
		return this.guild;
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
	
	public int getSPD() {
		return this.spd;
	}	
	
	protected int random(int a, int b) { 
		Random azar = new Random();
		int rango = b-a;
		int aleatorio = azar.nextInt(rango+1)+a;
		return aleatorio;
	}	
	
    private String[] nombresFacciones() {
    	String[] nombres = {"Fuego","Agua","Planta"};
    	return nombres;
    }	
    
    protected String getLista(String[] list) {
        int a = random(0,list.length-1);
        String nombre = list[a];
        return nombre;
      }
	
}