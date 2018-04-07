package luchones;

import java.util.ArrayList;
import java.util.Scanner;
public class inventarioLuchadores {
	
	private ArrayList<Luchador> inventario;
	
	inventarioLuchadores(){
		this.inventario = new ArrayList<Luchador>();
	}
	
	private boolean listaLlena(ArrayList<Luchador> lista) {	
		if(lista.size()>10) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean listaVacia(ArrayList<Luchador> lista) {
		if(lista.size() == 0) {
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
	
	public int ingresoEntero(String mensaje, int ingreso) {
		try(Scanner teclado = new Scanner(System.in);) {		
			System.out.println(mensaje);
			int entry = teclado.nextInt();
			if(entry<1||entry>ingreso) {
				return ingresoEntero(mensaje,ingreso);
			}else {
				return entry;
			}
		}catch(Exception e) {
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
			int posicion = ingresoLuchador();
			this.inventario.remove(posicion);			
		}else {
			System.out.println("El inventario no tiene luchadores para eliminar...");
		}
	}
	
	private void mostrarLuchador() {
		if(!listaVacia(this.inventario)) {
			int posicion = ingresoLuchador();
			this.inventario.get(posicion).mostrarStats();
		}else {
			System.out.println("El inventario no tiene luchadores para mostrar...");				
		}
	}
	
	private void mostrarTodos() {
		for(int i=0;i<this.inventario.size();i++) {
			 this.inventario.get(i).mostrarDatos();
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
		mostrarLuchadores(temporal);
	}
	
	private void imprimirRango(int rank) {
		ArrayList<Luchador> temporal = new ArrayList<Luchador>();			
		for(int i=0;i<inventario.size();i++) {
			if(rank == inventario.get(i).getRank()) {
				temporal.add(inventario.get(i));
			}
		}
		mostrarLuchadores(temporal);		
	}
	
	public void filtrarFaccion() {
		String mensaje = "(1) Fuego, (2) Agua, (3) Tierra.";
		int ingreso = 3;
		int opcion = ingresoEntero(mensaje,ingreso);
		String guild = selecFaccion(opcion);
		imprimirFaccion(guild);
	}	
	
	public void filtrarRango() {
		String mensaje = "Selecciona el rango [1-5]";
		int ingreso = 5;
		int opcion = ingresoEntero(mensaje,ingreso);
		imprimirRango(opcion);
	}		
	
}
