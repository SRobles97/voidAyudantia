import java.util.Random;
public class objetoEquipable
{
  private int rarity, objetoI, objetoF;
  
  public objetoEquipable(){
    this.rarity = generarEstrella(this.rarity);
    this.objetoI = crearStats(this.objetoI);
    this.objetoF = multiplicarStat(this.objetoI,this.rarity);
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
    System.out.println("Valor: "+this.objetoF);
    System.out.println("Rareza: "+this.rarity+" estrellas.");
  }
}
