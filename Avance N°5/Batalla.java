package luchones;

import java.util.Random;

public class Batalla {
	private Monstruo enemigo;
	private inventarioLuchadores aliados;
	private Luchador[] escuadron;
	private int[] damage;
	private int damageEnemigo;
	private int damageBase;
	private int hpEnemigo;
	
	Batalla(){
		this.aliados = new inventarioLuchadores();
		llenarLista();
		this.escuadron = new Luchador[6];
		this.damage = new int[6];
		llenarEscuadron();
		ordenarAgi(this.escuadron);
		ataqueAuxiliar();
		this.enemigo = new Monstruo();
		this.damageEnemigo = this.enemigo.getATK();
		this.damageBase = this.damageEnemigo;
		this.hpEnemigo = this.enemigo.getHP();
	}
	
	private boolean victoriaAliada() {
		if(hpEnemigo > 0) {
			return false;
		}else {
			return true;
		}
	}
	
	private void llenarLista() { 
		// llena un inventario de luchadores. metodo temporal para probar la batalla...
		for(int i=0; i<24; i++) {
			this.aliados.agregarLuchador();
		}
	}
	
	private void llenarEscuadron() {
		Random azar = new Random();
		// llena al azar un escuadron de 6 luchadores a partir de 25 luchadores. metodo temporal...
		for(int i = 0; i<this.escuadron.length; i++) {
			int a = 1+azar.nextInt(24);
			this.escuadron[i] = this.aliados.getInventario().get(a);
		}
	}
	
	private void ordenarAgi(Luchador[] arreglo) {
		// ordena el arreglo de 6 luchadores por su velocidad
		for(int i=0; i<arreglo.length;i++) {
			for(int j=i+1; j<arreglo.length;j++) {
				if(arreglo[i].getAGI() < arreglo[j].getAGI()) {
					Luchador aux = new Luchador();
					aux = arreglo[j];
					arreglo[j] = arreglo[i];
					arreglo[i] = aux;
				}
			}
		}
	}
	
	private void ataqueAuxiliar() {
		for(int i=0; i<this.escuadron.length;i++) {
			this.damage[i] = this.escuadron[i].getATK();
		}
	}
	
	
	private int diferenciaDados() {
		int seis = (int) Math.random()+6+1;
		int ocho = (int) Math.random()*8+1;
		return ocho-seis;
	}
	
	private void buffDados() {
		int dados = diferenciaDados();
		if(dados > 1) {
			System.out.println("¡BUEN PRESAGIO!");			
			System.out.println("La fuerza del escuadrón ha aumentado...\n");			
			for(int i=0; i<this.escuadron.length;i++){
				this.damage[i] = this.damage[i]*dados;
			}
		}else if(dados < 0){
			System.out.println("¡MALA SUERTE!");
			System.out.println("La fuerza del enemigo ha aumentado...\n");
			dados = dados*-1;
			this.damageEnemigo = this.damageEnemigo*dados;
			
		}else {
			System.out.println("El combate se llevará a cabo normalmente...\n");
		}
	}
	
	private int restarHP(int vida, int ataque, int defensa) {
		if(ataque - defensa < 0) {
			return vida;
		}else {
			return vida - (ataque - defensa);			
		}
	}
	
	private void compararFaccion(Luchador gladiador, int ataque) {
		if(gladiador.getGuild().equals("Fuego") && this.enemigo.getGuild().equals("Agua")) {
			ataque = (int) (ataque*0.75);
			this.damageEnemigo = (int) (this.damageBase*1.5);
		}else if(gladiador.getGuild().equals("Fuego") && this.enemigo.getGuild().equals("Planta")) {	
			ataque = (int) (ataque*1.5);	
			this.damageEnemigo = (int) (this.damageBase*0.75);			
		}else if(gladiador.getGuild().equals("Agua") && this.enemigo.getGuild().equals("Fuego")) {	
			ataque = (int) (ataque*1.5);
			this.damageEnemigo = (int) (this.damageBase*0.75);			
		}else if(gladiador.getGuild().equals("Agua") && this.enemigo.getGuild().equals("Planta")) {	
			ataque = (int) (ataque*0.75);
			this.damageEnemigo = (int) (this.damageBase*1.5);			
		}else if(gladiador.getGuild().equals("Planta") && this.enemigo.getGuild().equals("Agua")) {		
			ataque = (int) (ataque*1.5);
			this.damageEnemigo = (int) (this.damageBase*0.75);			
		}else if(gladiador.getGuild().equals("Planta") && this.enemigo.getGuild().equals("Fuego")) {		
			ataque = (int) (ataque*0.75);	
			this.damageEnemigo = (int) (this.damageBase*1.5);			
		}
	}
	
	private void pvm(Luchador gladiador, int vida, String nombre, int ataque) {
		// batalla 1 vs 1 
		compararFaccion(gladiador,ataque);		
		while(victoriaAliada() != true && vida > 0) {
			if(gladiador.getAGI() > this.enemigo.getAGI()) {
				System.out.println(nombre+" ataca primero al monstruo\n");
				this.hpEnemigo = restarHP(this.hpEnemigo,ataque, this.enemigo.getDEF());
				System.out.println(nombre+" le ha dejado "+this.hpEnemigo+" de vida al monstruo...");
				System.out.println("El monstruo va a contraatacar...");
				vida = restarHP(vida,this.damageEnemigo,gladiador.getDEF());				
				if(vida <= 0) {
					System.out.println(nombre+" ha muerto honorablemente en combate...\n");					
				}else {
					System.out.println("Salud de "+nombre+" : "+vida+"\n");						
				}
			}else {
				System.out.println("El monstruo atacará primero...\n");
				vida = restarHP(vida,this.damageEnemigo,gladiador.getDEF());				
				if(vida < 0) {
					System.out.println(nombre+" ha muerto honorablemente en combate...\n");
				}else {
					System.out.println("El monstruo le ha dejado "+vida+" de vida a "+nombre+"...");					
					System.out.println(nombre+" va a contraatacar...");
					this.hpEnemigo = restarHP(this.hpEnemigo,ataque, this.enemigo.getDEF());				
					System.out.println("Salud del monstruo :"+this.hpEnemigo+"\n");						
				}

			}
			
		}		
	}
	
	private String mensaje() {
		if(!victoriaAliada()) {
			return "El monstruo se ha comido a todos los luchadores...";
		}else {
			return "Los luchadores han derrotado al monstruo...";
		}
	}
	
	public void pelear() {
		// para testear la pelea con un escuadron completo...
		buffDados();
		for(int i=0; i<this.escuadron.length;i++) {
			int vida = this.escuadron[i].getHP();
			int ataque = damage[i];
			String nombre = this.escuadron[i].getName();
			pvm(this.escuadron[i],vida,nombre,ataque);
		}
		System.out.println(mensaje());
	}
	
	public static void main(String[] args) {
		// para testear la batalla...
		Batalla m = new Batalla();
		m.pelear();
	}

}
