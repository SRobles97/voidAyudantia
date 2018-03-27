/** 
 * @S. Robles
 * @v0.000014
 */
import java.util.Random;
public class Luchador_SebastianRobles
{
  private String name, guild;
  private int rank,hp,atk,def,spd
  
  private Luchador(){
   this.name = obtenerNombre(generadorNombre());
   this.guild = obtenerNombre(generadorFaccion());
   this.rank = generarEstrella(this.rank);
   this.hp = multiplicarStat(generarHP(this.hp),this.rank);
   this.atk = multiplicarStat(generarAtaque(this.atk),this.rank);   
   this.def = multiplicarStat(generarDefensa(this.def),this.rank);   
   this.spd = multiplicarStat(generarAgi(this.spd),this.rank);      
  }
  
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
  
  private void mostrarDatos(){
    System.out.println("Nombre del luchador: "+this.name);
    System.out.println("N° Estrellas: "+this.rank+" Facción: "+this.guild);   
    System.out.print("HP: "+this.hp+" ");    
    System.out.print("Ataque: "+this.atk+" ");    
    System.out.print("Defensa: "+this.def+" ");   
    System.out.println("Velocidad: "+this.spd);    
  }
  
  public static void main(String[] args){
   Luchador testing = new Luchador();
    testing.mostrarDatos();
  }
}
