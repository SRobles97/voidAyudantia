package luchones;

import java.util.ArrayList;
import java.util.Scanner;
public class inventarioObjetos {
	
	private ArrayList<objetoEquipable> inventory;
	private Scanner teclado;
	
	inventarioObjetos(){
		this.teclado = new Scanner(System.in);
		this.inventory = new ArrayList<objetoEquipable>();
	}
	
	private boolean numeroEntero(String cadena, int rango) {
		int numero;
		try {
			numero = Integer.parseInt(cadena);
			if(numero < 1 || numero > rango) {
				return false;
			}else {
				return true;
			}
		}catch(Exception e) {
				return false;
		}
	}
	
	private void agregarObjeto() {
		if(this.inventory.size() < 10) {
			this.inventory.add(new objetoEquipable());
		}else {
			System.out.println("Inventario lleno");
		}
	}
	
	private void quitarObjeto() {
		if(this.inventory.size() > 0) {
			String mensaje = "Ingresa el N° del objeto que quieres botar.";
			int ingreso = this.inventory.size();
			int i = Integer.parseInt(ingresoEntero(mensaje,ingreso))-1;
			this.inventory.remove(i);
		}else {
			System.out.println("No hay ningún objeto en el inventario...");			
		}
		
	}
	
	private void mostrarInventario(ArrayList<objetoEquipable> lista) {
		// mostrar filtro
		if(lista.size() > 0) {
			System.out.println("INVENTARIO");
			for(int i=0;i<lista.size();i++) {
				lista.get(i).mostrarObjeto();
				System.out.println();
			}
		}else {
			System.out.println("No se encontraron resultados...");
		}	
	}
	
	public void mostrarTodo() {
		if(this.inventory.size() > 0) {
			System.out.println("INVENTARIO");
			for(int i=0;i<this.inventory.size();i++) {
				this.inventory.get(i).mostrarObjeto();
				System.out.println();				
			}
		}else {
			System.out.println("El inventario está vacío...");
		}	
	}			
	
	private void filtroObjetos(int rango) {
		ArrayList<objetoEquipable> tem = new ArrayList<objetoEquipable>();
		for(int i=0; i<this.inventory.size();i++) {
			if(rango == this.inventory.get(i).getRarity()) {
				tem.add(this.inventory.get(i));
			}
		}
			mostrarInventario(tem);	

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
	
	public void filtrar() {
		String mensaje = "Ingresa el N° de rango";
		int ingreso = 10;
		int opcion = Integer.parseInt(ingresoEntero(mensaje,ingreso));
		filtroObjetos(opcion);
	}

}
