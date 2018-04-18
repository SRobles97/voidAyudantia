package luchones;

import java.util.ArrayList;
import java.util.Scanner;
public class inventarioLuchadores {
	
	private ArrayList<Luchador> inventario;
	
	inventarioLuchadores(){
		this.inventario = new ArrayList<Luchador>();
		agregarLuchador();
	}
	
	private boolean listaLlena(ArrayList<Luchador> lista) {	
		if(lista.size()>25) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean listaVacia(ArrayList<Luchador> lista) {
		if(lista.size() == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	private int ingresoLuchador() {
		try(Scanner teclado = new Scanner(System.in);) {	
	     System.out.println("Ingresa el N° del luchador");
	     int entry = teclado.nextInt();
	     if(entry < 1 || entry > this.inventario.size()) {
	    	 return ingresoLuchador();
	     }else {
	    	 return entry-1;
	     }
		}catch(Exception e) {
			return ingresoLuchador();	
		}		
	}
	
	private boolean numeroEntero(String cadena, int rango) {
		int numero;
		try {
			numero = Integer.parseInt(cadena);
			if(numero<1 || numero >rango) {
				return false;				
			}else {
				return true;
			}
		}catch(Exception e) {
			return false;
		}
	}
	
	private String ingresoEntero(String mensaje, int ingreso) {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println(mensaje);
		String entrada = teclado.nextLine();
		if(numeroEntero(entrada,ingreso) == true) {
			return entrada;
		}else {
			return ingresoEntero(mensaje,ingreso);
		}
	}	
	
	private void cantidadLuchadores() {
		System.out.println("La cantidad actual es de"+this.inventario.size()+" luchadores");
	}
	
	private void agregarLuchador() {	
		if(!listaLlena(this.inventario)) {
			this.inventario.add(new Luchador());
		}else {
			System.out.println("El inventario de luchadores está lleno...");
			
		}
	}
	
	private void borrarLuchador() {
		if(!listaVacia(this.inventario)) {
			String mensaje = "Ingresa el N° del luchador que quieres eliminar";
			int rango = this.inventario.size();
			int posicion = Integer.parseInt(ingresoEntero(mensaje,rango))-1;
			this.inventario.remove(posicion);				
		}else {
			System.out.println("No se pueden eliminar más luchadores...");
		}
	}
	
	private void mostrarLuchador() {
	   String mensaje = "Ingresa el N° del luchador que quieres mostrar";
	   int rango = this.inventario.size();
	   int posicion = Integer.parseInt(ingresoEntero(mensaje,rango))-1;
	   this.inventario.get(posicion).mostrarStats();
	}
	
	private void mostrarTodos() {
		for(int i=0;i<this.inventario.size();i++) {
			 this.inventario.get(i).mostrarDatos();
		         System.out.println();
		}
	}	
	
	private void mostrarLuchadores(ArrayList<Luchador> lista) {
		for(int i=0;i<lista.size();i++) {
			 lista.get(i).mostrarDatos();
		}
	}
	
	private String selecFaccion(int picker) {
		String a = "";
		switch(picker) {
		case 1: a = "Fuego";
		break;
		case 2: a = "Agua";
		break;
		case 3: a = "Tierra";
		break;
		}
		return a;
	}
	
	private void imprimirFaccion(String gremio) {
		ArrayList<Luchador> temporal = new ArrayList<Luchador>();		
		for(int i=0;i<this.inventario.size();i++) {
			if(gremio.equals(this.inventario.get(i).getGuild())) {
				temporal.add(this.inventario.get(i));
			}
		}
		if(!listaVacia(temporal)) {
			mostrarLuchadores(temporal);			
		}else {
			System.out.println("No hay luchadores en la facción...");
		}
	}
	
	private void imprimirRango(int rank) {
		ArrayList<Luchador> temporal = new ArrayList<Luchador>();			
		for(int i=0;i<inventario.size();i++) {
			if(rank == inventario.get(i).getRank()) {
				temporal.add(inventario.get(i));
			}
		}
		if(!listaVacia(temporal)) {
			mostrarLuchadores(temporal);				
		}else {
			System.out.println("No hay luchadores con ese rango...");			
		}
		
	}
	
	public void filtrarFaccion() {
		String mensaje = "(1) Fuego, (2) Agua, (3) Tierra.";
		int ingreso = 3;
		int opcion = Integer.parseInt(ingresoEntero(mensaje,ingreso));
		String guild = selecFaccion(opcion);
		imprimirFaccion(guild);
	}	
	
	public void filtrarRango() {
		String mensaje = "Selecciona el rango [1-5]";
		int ingreso = 5;
		int opcion = Integer.parseInt(ingresoEntero(mensaje,ingreso));
		imprimirRango(opcion);
	}		
	
}
