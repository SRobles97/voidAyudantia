package ayudantia;

import java.util.Random;

public class Monstruo {
	
	private int hp;
	private int atk;
	private int def;
	private int agi;
	private objetoEquipable[] objetos;
	private objetoEquipable drop;
	private String guild;
	
	Monstruo(){
		this.guild = getNombre(nombresFacciones());		
		this.hp = aleatorio(3500,4000);
		this.atk = aleatorio(1000,1500);		
		this.def = aleatorio(5,25);
		this.agi = aleatorio(10,100);
		this.objetos = new objetoEquipable[3];
		this.drop = obtenerDrop();
	}
	
    private String[] nombresFacciones() {
    	String[] nombres = {"Fuego","Agua","Planta"};
    	return nombres;
    }	
	
    private String getNombre(String[] list) {
        int a = aleatorio(0,list.length-1);
        String nombre = list[a];
        return nombre;
      }	
	
	private int aleatorio(int a, int b) { 
		Random azar = new Random();
		int rango = b-a;
		int aleatorio = azar.nextInt(rango+1)+a;
		return aleatorio;
	}
	
	private objetoEquipable obtenerRango(objetoEquipable objeto, int rango) {
		objeto = new objetoEquipable();
		if(objeto.getRarity() == rango) {
			return objeto;
		}else {
			return obtenerRango(objeto,rango);
		}
	}
	
	private void generarObjetos() {
		this.objetos[0] = obtenerRango(this.objetos[0] , 5);
		this.objetos[1] = obtenerRango(this.objetos[1] , 3);		
		this.objetos[2] = obtenerRango(this.objetos[2] , 1);		
		
	}
	
	private objetoEquipable obtenerDrop() {
		generarObjetos();
		double prob = Math.random();
		if(prob < 0.6) {
			return this.objetos[2];
		}else if(prob < 0.9) {
			return this.objetos[1];
		}else {
			return this.objetos[0];
		}
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
	
	public String getGuild() {
		return this.guild;
	}

	public void mostrarDrop() {
		System.out.println("Drop del monstruo: ");
		this.drop.mostrarObjeto();
	}

}
