package ayudantia;

import java.util.ArrayList;
import java.util.Scanner;
public class inventarioLuchadores {
	
	private ArrayList<Luchador> inventario;
	private Scanner teclado;
	
	inventarioLuchadores(){
		this.teclado = new Scanner(System.in);
		this.inventario = new ArrayList<Luchador>();
		agregarLuchador();
	}
	
	public ArrayList<Luchador> getInventario(){
		return this.inventario;
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
		System.out.println(mensaje);
		String entrada = this.teclado.nextLine();
		if(numeroEntero(entrada,ingreso) == true) {
			return entrada;
		}else {
			return ingresoEntero(mensaje,ingreso);
		}
	}
	
	private void cantidadLuchadores() {
		System.out.println("La cantidad actual es de"+this.inventario.size()+" luchadores");
	}
	
	public void agregarLuchador() {
		if(this.inventario.size() < 25) {
			this.inventario.add(new Luchador());
		}else {
			System.out.println("El inventario de luchadores está lleno...");
			
		}
	}
	
	private void borrarLuchador() {
		if(this.inventario.size() > 0) {
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
	
	public void mostrarTodos() {
		for(int i=0;i<this.inventario.size();i++) {
			System.out.println("Luchador N°"+(i+1));
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
		case 3: a = "Planta";
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
		if(temporal.size() == 0) {
			System.out.println("No hay ningún luchador en esa facción...");
		}else {
			mostrarLuchadores(temporal);				
		}
	}
	
	private void imprimirRango(int rank) {
		ArrayList<Luchador> temporal = new ArrayList<Luchador>();			
		for(int i=0;i<inventario.size();i++) {
			if(rank == inventario.get(i).getRank()) {
				temporal.add(inventario.get(i));
			}
		}
		if(temporal.size() == 0) {
			System.out.println("No hay ningún luchador con ese rango...");
		}else {
			mostrarLuchadores(temporal);				
		}
	
	}
	
	public void filtrarFaccion() {
		String mensaje = "Ingresa la facción que deseas filtrar:\n(1) Fuego\n(2) Agua\n(3) Planta";
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
	
	public void equiparLuchador(objetoEquipable objeto) {
		String mensaje = "Ingresa el n° del luchador al que quieres equipar...";
		int ingreso = this.inventario.size();
		int opcion = Integer.parseInt(ingresoEntero(mensaje,ingreso));		
		this.inventario.get(opcion).equiparObjeto(objeto);
	}

}