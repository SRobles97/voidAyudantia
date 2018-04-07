package luchones;

import java.util.ArrayList;
import java.util.Scanner;
public class inventarioObjetos {
	
	private ArrayList<objetoEquipable> inventory;
	
	inventarioObjetos(){
		this.inventory = new ArrayList<objetoEquipable>();
	}
	
	private boolean inventarioLleno(ArrayList<objetoEquipable> lista) {
		if(lista.size() == 20) {
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
	
	private void agregarObjeto() {
		if(!inventarioLleno(this.inventory)) {
			this.inventory.add(new objetoEquipable());
		}else {
			System.out.println("Inventario lleno");
		}
	}
	
	private void quitarObjeto() {
		if(!inventarioVacio(this.inventory)) {
			int a = ingresoObjeto(this.inventory);
			this.inventory.remove(a);
		}else {
			System.out.println("No hay ningún objeto en el inventario...");			
		}
		
	}
	
	private int ingresoObjeto(ArrayList<objetoEquipable> lista) {
		try (Scanner teclado = new Scanner(System.in);){	
	     System.out.println("Ingresa el N° del objeto");
	     int entry = teclado.nextInt();
	     if(entry < 1 || entry > lista.size()) {
	    	 return ingresoObjeto(lista);
	     }else {
	    	 return entry-1;
	     }
		}catch(Exception e) {
			return ingresoObjeto(lista);	
		}		
	}	
	
	public void mostrarInventario(ArrayList<objetoEquipable> lista) {
		if(!inventarioVacio(lista)) {
			System.out.println("INVENTARIO");
			for(int i=0;i<lista.size();i++) {
				lista.get(i).mostrarObjeto();
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
	
	private int ingresoEntero(String mensaje, int ingreso) {
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
	
	public void filtrar() {
		String mensaje = "Ingresa el N° de rango";
		int ingreso = 10;
		int opcion = ingresoEntero(mensaje,ingreso);
		filtroObjetos(opcion);
	}

}
