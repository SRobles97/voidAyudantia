
/** 
 * @S. Robles
 * @v0.000001
 */
import java.util.Random;
import java.util.Scanner;
public class Luchador_SebastianRobles
{
  private void generadorNombres(String[] aleatorio){
    aleatorio[0] = "Igor";
    aleatorio[1] = "Egg King";   
    aleatorio[2] = "God";  
    aleatorio[3] = "Dylantero";  
    aleatorio[4] = "Messi";   
    aleatorio[5] = "Chefcito";  
    aleatorio[6] = "El Macho";  
    aleatorio[7] = "King Dragon";   
    aleatorio[8] = "Satanael";   
    aleatorio[9] = "Caligula"; 
    aleatorio[10] = "Jojo el Bizarro";  
    aleatorio[11] = "Pink Guy";   
    aleatorio[12] = "Dross";   
    aleatorio[13] = "Roerto";  
    aleatorio[14] = "Jeff";      
  }    
  private String obtenerNombre(String[] nombre)
  {
    Random azar = new Random();      
    String name = nombre[azar.nextInt(15)];
    return name;
  }
  private String elegirFaccion(){
    Random azar = new Random();       
    String faction = "";
    int numero = azar.nextInt(3);
    if(numero == 0){
        faction = "Fuego";    
    }else if(numero == 1){
        faction = "Agua";        
    }else{
        faction = "Tierra";        
    }
    return faction;
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
    System.out.println("Velocidad: "+agi);    
  }
}

