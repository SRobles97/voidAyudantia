package luchones;

import java.util.Random;

public class Monstruo {
	
	private int hp,atk,def,agi;
	private objetoEquipable drop;
	
	Monstruo(){
		this.hp = aleatorio(3500,4000);
		this.atk = aleatorio(1000,1500);		
		this.def = aleatorio(5,25);
		this.agi = aleatorio(10,100);
		this.drop = getDrop();
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
