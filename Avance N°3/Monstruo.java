package luchones;

import java.util.Random;

public class Monstruo {
	
	private int hp;
	private int atk;
	private int def;
	private int agi;
	private objetoEquipable drop;
	private String guild;
	
	Monstruo(){
		this.guild = getNombre(nombresFacciones());		
		this.hp = aleatorio(3500,4000);
		this.atk = aleatorio(1000,1500);		
		this.def = aleatorio(5,25);
		this.agi = aleatorio(10,100);
		this.drop = getDrop();
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
	
	private objetoEquipable getDrop() {
		return new objetoEquipable();
	}

	public void mostrarDrop() {
		System.out.println("Drop del monstruo: ");
		this.drop.mostrarObjeto();
	}

}
