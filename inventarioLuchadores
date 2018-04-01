import java.util.*;
public class inventarioLuchadores
{
  private ArrayList<Luchador> inventario = new ArrayList<Luchador>();
  private int auxiliar, aux;
  private String mensaje;
  
  public static void main(String[] args){ // para testear
    inventarioLuchadores m = new inventarioLuchadores();
    while(m.aux != 8){
       m.menuTesting();
    }
  }
    
  private boolean listaVacia(ArrayList<Luchador> faccion){
    if(inventario.size() == 0){
        return true;
    }else{
        return false;
    }
  }
  
  private boolean listaLlena(){ // valor temporal(5)
    if(inventario.size() < 5){
      return false;
    }else{
      return true;
    }
  }
  
  private void agregarLuchador(){
    inventario.add(new Luchador());          
  }
  
  private void cantidadLuchadores(){
     System.out.println("La cantidad actual es de "+inventario.size()+" luchadores.");
  }
  
  private int entradaLuchador(){
    try{
      Scanner entrada = new Scanner(System.in);     
      int test = 0;        
      System.out.println("Ingresa el N° del luchador");
      test = entrada.nextInt();
      if(test>inventario.size() || test < 1){
         System.out.println("El luchador que ingresaste no existe");          
         return entradaLuchador();
        }else{
         return test-1;
        }
      }catch(Exception e){
          System.out.println("El luchador que ingresaste no existe");             
          return entradaLuchador();
    } 
  }
  
  private void borrarLuchador(){
    int a = entradaLuchador();
    inventario.remove(a);  
  }
  
  private void mostrarLuchador(){
    int a = entradaLuchador();
    inventario.get(a).mostrarDatos();
  }
  
  private void mostrarLuchadores(ArrayList<Luchador> lista){
    for(int a=0;a<inventario.size();a++){
      lista.get(a).mostrar();
    }
  }
  
  private String seleccionFaccion(int numero){
    String command = "";
    switch(numero){
      case 1:
           command = "Fuego";
           break;
      case 2:
           command = "Agua";
           break;
      case 3:
           command = "Tierra";
           break; 
    }
    return command;
  }  
  
  private void filtroFaccion(ArrayList<Luchador> faccion,String gremio){
    for(int i=0;i<inventario.size();i++){
       if(gremio.equals(inventario.get(i).guild)){
         faccion.add(inventario.get(i));
       }
    }
    }
    
  private void filtroRank(ArrayList<Luchador> ranking,int estrella){
    for(int i=0;i<inventario.size();i++){
       if(inventario.get(i).rank == estrella){
         ranking.add(inventario.get(i));   
       }
    }
  }
  
  private int entradaEntero(){
    try{
      Scanner entrada = new Scanner(System.in);     
      int test = 0;        
      System.out.println("Elige la opción");
      System.out.println(mensaje);
      test = entrada.nextInt();
      if(test<0 || test > auxiliar){
         System.out.println("Valor no válido");          
         return entradaEntero();
        }else{
         return test;
        }
      }catch(Exception e){
          System.out.println("Valor no válido");             
          return entradaEntero();
    } 
  }
  
  public void menuTesting(){
    try{
      Scanner teclado = new Scanner(System.in);
      System.out.println("(1) Agregar luchador");
      System.out.println("(2) Borrar luchador");   
      System.out.println("(3) Mostrar cantidad de luchadores");         
      System.out.println("(4) Mostrar estadisticas de un luchador");    
      System.out.println("(5) Mostrar todos los luchadores");   
      System.out.println("(6) Filtrar luchadores por facción");    
      System.out.println("(7) Filtrar luchadores por N° de estrellas");       
      System.out.println("(8) Salir");
      int opcion = teclado.nextInt();
      if(opcion < 1 || opcion > 8){
          menuTesting();          
        }else{
          aux = opcion;
          tester(opcion);        
        }
    }catch(Exception e){
        menuTesting();
    }
  }
  
  public void tester(int option){ // para probar los filtros
    switch(option){
       case 1:
       if(!listaLlena()){
            agregarLuchador();
           }else{
            System.out.println("No se pueden agregar más luchadores...");
        }
            break;
       case 2:
       if(!listaVacia(inventario)){
            borrarLuchador();
           }else{
            System.out.println("No hay ningún luchador para borrar...");
        }       
            break;
       case 3:
            cantidadLuchadores();     
            break;
       case 4:
       if(!listaVacia(inventario)){
                mostrarLuchador();
           }else{
                System.out.println("No hay ningún luchador para mostrar...");
            }             
            break;
       case 5:
       if(!listaVacia(inventario)){
                System.out.println("Lista completa de luchadores: ");
                mostrarLuchadores(inventario);
           }else{
                System.out.println("No hay ningún luchador para mostrar...");
            }        
            break;
       case 6:
       if(!listaVacia(inventario)){
                    ArrayList<Luchador> lista = new ArrayList<Luchador>();
                    mensaje = "(1) Fuego, (2) Agua, (3) Tierra.";
                    auxiliar = 3;
                    int a = entradaEntero();
                    mensaje = seleccionFaccion(a);
                    filtroFaccion(lista,mensaje);
                    System.out.println("Luchadores de la facción "+mensaje+" :");
                    mostrarLuchadores(lista);
           }else{
                System.out.println("No hay ningún luchador para filtrar...");
            }          
            break;
       case 7:
       if(!listaVacia(inventario)){
                    ArrayList<Luchador> lista = new ArrayList<Luchador>();
                    mensaje = "Indica la cantidad de estrellas (1-5)";
                    auxiliar = 5;
                    int b = entradaEntero();
                    filtroRank(lista,b);
                    System.out.println("Luchadores con "+b+" estrellas: ");
                    mostrarLuchadores(lista);
           }else{
                System.out.println("No hay ningún luchador para filtrar...");
            }         
            break;
    }
  }  
  
}
