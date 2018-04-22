package luchones;

import java.util.Random;
public class objetoEquipable
{
  private int rarity;
  private int objetoI;
  private int objetoF;
  private String stat;
  private String tipo;
  
  objetoEquipable(){
    this.rarity = generarEstrella(this.rarity);
    this.objetoI = crearStats(this.objetoI);
    this.objetoF = multiplicarStat(this.objetoI,this.rarity);
    this.stat = getStat(nombreStat());
    this.tipo = obtenerTipo(this.stat);
  }
  
  private int generarEstrella(int star){      
    double azar = Math.random();
    if(azar < 0.2){
      star = 1;
    }else if(azar < 0.4){
      star = 2;    
    }else if(azar < 0.6){
      star = 3;    
    }else if(azar < 0.75){
      star = 4;    
    }else if(azar < 0.85){
      star = 5;      
    }else if(azar < 0.9){
      star = 6;      
    }else if(azar < 0.94){
      star = 7;      
    }else if(azar < 0.97){
      star = 8;      
    }else if(azar < 0.99){
      star = 9;      
    }else{
      star = 10;       
    }
    return star;    
  }
  
  private String obtenerTipo(String objeto) {
	  if(objeto.equals("HP")) {
		  return "Armadura";
	  }else if(objeto.equals("ATK")) {
		  return "Espada";
	  }else if(objeto.equals("DEF")) {
		  return "Escudo";		  
	  }else {
		  return "Botas";				  
	  }
  }
  
  private String getStat(String[] list) {
      int a = random(0,list.length-1);
      String nombre = list[a];
      return nombre;
    }  
  
  private String[] nombreStat() {
  	String[] nombres = {"HP","ATK","DEF","SPD"};
  	return nombres;
  }
  
  private int random(int a, int b) { 
	Random azar = new Random();
	int rango = b-a;
	int aleatorio = azar.nextInt(rango+1)+a;
	return aleatorio;
  }  
 
  public String getTipo() {
	  return this.tipo;
  }  
  
  public int getRarity() {
	  return this.rarity;
  } 
  
  public int getMejora() {
	  return this.objetoF;
  }
  
  private int crearStats(int objeto){
    Random azar = new Random();
    objeto = 1+azar.nextInt(9);
    return objeto;
  }
  
  private int multiplicarStat(int stat,int estrellitas){
    stat = stat*estrellitas;
    return stat;
  }
  
  public void mostrarObjeto(){
	System.out.println("Tipo de objeto: "+this.tipo);
    System.out.println(this.stat+"+"+this.objetoF);
    System.out.println("Rareza: "+this.rarity+" estrellas");
  }
  	
}

  