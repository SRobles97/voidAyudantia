package ayudantia;

import java.util.Random;
public class Batalla {
	private Monstruo enemigo;
	private inventarioLuchadores aliados;
	private inventarioObjetos inventario;
	private Luchador[] escuadron;
	private int[] damage;
	private int[] hp;
	private int damageEnemigo;
	private int hpEnemigo;
	
	Batalla(){
		this.aliados = new inventarioLuchadores();
		this.inventario = new inventarioObjetos();
		llenarLista();
		this.escuadron = new Luchador[6];
		this.damage = new int[escuadron.length];
		this.hp = new int[damage.length];
		llenarEscuadron();
		ordenarAgi(this.escuadron);
		statAux();
		this.enemigo = new Monstruo();
		this.damageEnemigo = this.enemigo.getATK();		
		this.hpEnemigo = this.enemigo.getHP();
	}
	
	private boolean victoriaAliada() {
		if(hpEnemigo > 0) {
			return false;
		}else {
			return true;
		}
	}
	
	private boolean victoriaEnemiga() {
		boolean boo = false;
		for(int i = 0; i<this.hp.length;i++) {
			if(this.hp[i] < 0) {
				boo = true;
			}else {
				boo = false;
			}
		}
		return boo;
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
	
	private void statAux() {
		for(int i=0; i<this.escuadron.length;i++) {
			this.damage[i] = this.escuadron[i].getATK();
			this.hp[i] = this.escuadron[i].getHP();
		}
	}
	
	private int diferenciaDados() {
		int seis = (int) Math.random()*6+1;
		int ocho = (int) Math.random()*8+1;
		return ocho-seis;
	}
	
	private void buffDados() {
		System.out.println("¡SE LANZAN LOS DADOS!");
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
			this.damageEnemigo = (int) (this.enemigo.getATK()*1.5);
		}else if(gladiador.getGuild().equals("Fuego") && this.enemigo.getGuild().equals("Planta")) {	
			ataque = (int) (ataque*1.5);	
			this.damageEnemigo = (int) (this.enemigo.getATK()*0.75);			
		}else if(gladiador.getGuild().equals("Agua") && this.enemigo.getGuild().equals("Fuego")) {	
			ataque = (int) (ataque*1.5);
			this.damageEnemigo = (int) (this.enemigo.getATK()*0.75);			
		}else if(gladiador.getGuild().equals("Agua") && this.enemigo.getGuild().equals("Planta")) {	
			ataque = (int) (ataque*0.75);
			this.damageEnemigo = (int) (this.enemigo.getATK()*1.5);			
		}else if(gladiador.getGuild().equals("Planta") && this.enemigo.getGuild().equals("Agua")) {		
			ataque = (int) (ataque*1.5);
			this.damageEnemigo = (int) (this.enemigo.getATK()*0.75);			
		}else if(gladiador.getGuild().equals("Planta") && this.enemigo.getGuild().equals("Fuego")) {		
			ataque = (int) (ataque*0.75);	
			this.damageEnemigo = (int) (this.enemigo.getATK()*1.5);			
		}
	}

	private void aftermath() {
		if(victoriaAliada() == true) {
			System.out.println("Como recompensa por derrotar al monstruo se ha obtenido el siguiente drop:");
			this.enemigo.getDrop().mostrarObjeto();
			this.inventario.agregarDrop(this.enemigo.getDrop());
		}else {
			System.out.println("El monstruo se ha comido a todos los luchadores...");
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
		aftermath();
	}
	
	private void batalla(Luchador[] gladiador, int[] vida, int[] ataque) {
		// batalla varios vs 1 
		for(int i=0;i<gladiador.length;i++) {
			compararFaccion(gladiador[i],ataque[i]);			
		}
		while(!victoriaAliada() && !victoriaEnemiga()) {
			for(int i = 0; i<gladiador.length;i++) {
				if(gladiador[i].getAGI() > this.enemigo.getAGI() && vida[i] > 0 && this.hpEnemigo > 0) {
					System.out.println(gladiador[i].getName()+" es más rápido asi que ataca primero al monstruo");
					this.hpEnemigo = restarHP(this.hpEnemigo,ataque[i], this.enemigo.getDEF());
					System.out.println(gladiador[i].getName()+" le ha dejado "+this.hpEnemigo+" de vida al monstruo...\n");
				}
			}		
			for(int i=0;i<gladiador.length;i++) {
				if(vida[i] > 0 && this.hpEnemigo > 0) {
					System.out.println("El monstruo va a atacar...\n");	
					vida[i] = restarHP(vida[i],this.damageEnemigo,gladiador[i].getDEF());
					if(vida[i] < 0) {
						System.out.println(gladiador[i].getName()+" ha muerto honorablemente en combate...\n");						
					}else {
						System.out.println("El monstruo le ha dejado "+vida[i]+" de vida a "+gladiador[i].getName()+"...\n");										
					}
					break;
				}
			}
			for(int i = 0; i<gladiador.length;i++) {
				if(gladiador[i].getAGI()  < this.enemigo.getAGI() && vida[i] > 0 && this.hpEnemigo > 0) {
					System.out.println(gladiador[i].getName()+" atacará al monstruo");
					this.hpEnemigo = restarHP(this.hpEnemigo,ataque[i], this.enemigo.getDEF());
					System.out.println(gladiador[i].getName()+" le ha dejado "+this.hpEnemigo+" de vida al monstruo...\n");
				}
			}	
			if(!victoriaAliada() && !victoriaEnemiga()) {
				System.out.println("El combate continúa...\n\n");
			}

		}
	}
	
	private void mostrarSquad() {
		for(int i=0;i<this.escuadron.length;i++) {
			System.out.print("Luchador N°"+(i+1)+" ");
			escuadron[i].mostrarDatos();
			System.out.println();
		}
	}

	
	private void enfrentamiento() {
		// pelea 6 vs 1
     System.out.println("Los siguientes luchadores van a pelear:");
     mostrarSquad();
	 buffDados();
	 batalla(this.escuadron, this.hp, this.damage);
	 aftermath();
		
	}
	
	public static void main(String[] args) {
		// para testear la batalla...
		Batalla m = new Batalla();
		m.enfrentamiento();
	}

}
