package luchones;

import java.util.ArrayList;
import java.util.Scanner;
public class inventarioObjetos {
	
	private ArrayList<objetoEquipable> inventory;
	
	inventarioObjetos(){
		this.inventory = new ArrayList<objetoEquipable>();
	}
	
	private boolean inventarioLleno(ArrayList<objetoEquipable> lista) {
		if(lista.size() == 10) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean inventarioVacio(ArrayList<objetoEquipable> lista) {
		if(lista.size() == 0) {
			return true;
		}else {
			return false;
		}
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
		if(!inventarioLleno(this.inventory)) {
			this.inventory.add(new objetoEquipable());
		}else {
			System.out.println("Inventario lleno");
		}
	}
	
	private void quitarObjeto() {
		if(!inventarioVacio(this.inventory)) {
			String mensaje = "Ingresa el N° del objeto que quieres botar.";
			int ingreso = this.inventory.size();
			int i = Integer.parseInt(ingresoEntero(mensaje,ingreso))-1;
			this.inventory.remove(i);
		}else {
			System.out.println("No hay ningún objeto en el inventario...");			
		}
		
	}
	
	public void mostrarInventario(ArrayList<objetoEquipable> lista) {
		if(!inventarioVacio(lista)) {
			System.out.println("INVENTARIO");
			for(int i=0;i<lista.size();i++) {
				lista.get(i).mostrarObjeto();
				System.out.println();
			}
		}else {
			System.out.println("El inventario está vacío...");
		}	
	}
	
	public void mostrarTodo() {
		if(!inventarioVacio(this.inventory)) {
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
		if(!inventarioVacio(tem)) {
			mostrarInventario(tem);			
		}else {
			System.out.println("No hay objetos con ese rango");
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
	
	public void filtrar() {
		String mensaje = "Ingresa el N° de rango";
		int ingreso = 10;
		int opcion = Integer.parseInt(ingresoEntero(mensaje,ingreso));
		filtroObjetos(opcion);
	}

}
