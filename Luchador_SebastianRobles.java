
/** 
 * @S. Robles
 * @v0.000001
 */
import java.util.Random;
import java.util.Scanner;
public class Luchador_SebastianRobles
{
  private String[] generadorNombre(){
    String[] nombres = {"Igor Spopovich","Egg King","God","Dylantero","Messi","Chefcito","Jeff","King Dragon","Satanael","Caligula","Papa Franku","Pink Guy","Dross","Roerto","Ethan"};
    return nombres;
  }
  private String[] generadorFaccion(){
    String[] facciones = {"Fuego","Agua","Tierra"};
    return facciones;
  }
  private int aleatorizarArreglo(int first, int last){
    Random azar = new Random();
    int variado = last-first;
    int pick = azar.nextInt(variado+1)+first;
    return pick;
  }  
  private String obtenerNombre(String[] nombre){  
    int i = aleatorizarArreglo(0,nombre.length-1);
    String name = nombre[i];
    return name;
  }
  private int generarHP(int hdp){
    Random azar = new Random();
    hdp = 200 + azar.nextInt(300); 
    return hdp;
  }  
  private int generarAtaque(int attac){
    Random azar = new Random();
    attac = 20 + azar.nextInt(50);    
    return attac;
  }  
  private int generarDefensa(int protec){
    Random azar = new Random();    
    protec = 5 + azar.nextInt(20); 
    return protec;
  }  
  private int generarAgi(int speed){
    Random azar = new Random();
    speed = 10 + azar.nextInt(90);   
    return speed;
  }    
  private int generarEstrella(int star){      
    double azar = Math.random();
    if(azar < 0.4){
      star = 1;
    }else if(azar < 0.7){
      star = 2;    
    }else if(azar < 0.85){
      star = 3;    
    }else if(azar < 0.95){
      star = 4;    
    }else{
      star = 5;    
    }
    return star;    
  }
  private int multiplicarStat(int stat,int estrellitas){
    stat = stat*estrellitas;
    return stat;
  }
  private void mostrarDatos(String name,String fac,int stars,int hp,int atk,int def,int agi){
    System.out.println("Nombre del luchador: "+name);
    System.out.println("N° Estrellas: "+stars+" Facción: "+fac);   
    System.out.print("HP: "+hp+" ");    
    System.out.print("Ataque: "+atk+" ");    
    System.out.print("Defensa: "+def+" ");   
    System.out.println("Agilidad: "+agi);    
  }
}

