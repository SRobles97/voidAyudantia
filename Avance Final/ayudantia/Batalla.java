package ayudantia;

import java.util.Random;

import javax.swing.JTextArea;
public class Batalla {
	private Monstruo enemigo;
	private Random azar;
	private inventarioLuchadores aliados;
	private inventarioObjetos inventario;
	private Luchador[] escuadron;
	private int[] damage;
	private int[] hp;
	private int damageEnemigo;
	private int hpEnemigo;
	
	public Batalla(){
		this.azar = new Random();
		this.aliados = new inventarioLuchadores();
		this.inventario = new inventarioObjetos();
		llenarLista();
		this.escuadron = new Luchador[6];
		this.damage = new int[escuadron.length];
		this.hp = new int[damage.length];
		llenarEscuadron();
		this.enemigo = new Monstruo();
		this.damageEnemigo = this.enemigo.getATK();		
		this.hpEnemigo = this.enemigo.getHP();
	}
	
	public Luchador getEscuadron(int a) {
		return this.escuadron[a];
	}
	
	public Monstruo getEnemigo() {
		return this.enemigo;
	}
	
	public void setEscuadron() {
		llenarEscuadron();
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
		ordenarAgi(this.escuadron);
		statAux();
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
		int seis = 1+this.azar.nextInt(6);
		int ocho = 1+this.azar.nextInt(8);
		return ocho-seis;
	}
	
	private void buffDados(JTextArea caja) {
		caja.append("�SE LANZAN LOS DADOS!\n");
		int dados = diferenciaDados();
		if(dados > 1) {
			caja.append("�BUEN PRESAGIO!\\n");			
			caja.append("La fuerza del escuadr�n ha aumentado por "+dados+"\n");			
			for(int i=0; i<this.escuadron.length;i++){
				this.damage[i] = this.damage[i]*dados;
			}
		}else if(dados < 0){
			dados = dados*-1;
			caja.append("�MALA SUERTE!\\n");
			caja.append("La fuerza del enemigo ha aumentado por"+dados+"\n");
			this.damageEnemigo = this.damageEnemigo*dados;
			
		}else if(dados == 0){
			caja.append("El combate se llevar� a cabo normalmente...\n");
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
	
	private void batalla(Luchador[] gladiador, int[] vida, int[] ataque, JTextArea caja) {
		// batalla varios vs 1 
		for(int i=0;i<gladiador.length;i++) {
			compararFaccion(gladiador[i],ataque[i]);			
		}
		while(!victoriaAliada() && !victoriaEnemiga()) {
			caja.append("INICIO DEL COMBATE\n");
			
			for(int i = 0; i<gladiador.length;i++) {
				if(gladiador[i].getAGI() > this.enemigo.getAGI() && vida[i] > 0 && this.hpEnemigo > 0) {
					caja.append(gladiador[i].getName()+" ataca antes al monstruo.\n");
					this.hpEnemigo = restarHP(this.hpEnemigo,ataque[i], this.enemigo.getDEF());
					caja.append(gladiador[i].getName()+" le ha dejado "+this.hpEnemigo+" de vida al monstruo...\n");
				}
			}		
			
			for(int i=0;i<gladiador.length;i++) {
				if(vida[i] > 0 && this.hpEnemigo > 0) {
					caja.append("TURNO DEL MONSTRUO\n");	
					caja.append("El monstruo ataca a "+gladiador[i].getName()+"\n");
					vida[i] = restarHP(vida[i],this.damageEnemigo,gladiador[i].getDEF());
					if(vida[i] < 0) {
						caja.append(gladiador[i].getName()+" ha muerto honorablemente en combate...\n");						
					}else {
						caja.append("El monstruo le ha dejado "+vida[i]+" de vida a "+gladiador[i].getName()+"...\n");										
					}
					caja.append("FIN TURNO DEL MONSTRUO\n");	
					break;
				}
			}

			for(int i = 0; i<gladiador.length;i++) {
				if(gladiador[i].getAGI()  < this.enemigo.getAGI() && vida[i] > 0 && this.hpEnemigo > 0) {
					caja.append(gladiador[i].getName()+" ataca al monstruo.\n");
					this.hpEnemigo = restarHP(this.hpEnemigo,ataque[i], this.enemigo.getDEF());
					caja.append(gladiador[i].getName()+" le ha dejado "+this.hpEnemigo+" de vida al monstruo...\n");
				}
			}	
			
			if(!victoriaAliada() && !victoriaEnemiga()) {
				caja.append("EL COMBATE SE REANUDA\n\n");
			}else {
				caja.append("FIN DEL COMBATE.\n\n");				
			}

		}
	}
	
	private void aftermath(JTextArea caja) {
		if(victoriaAliada() == true) {
			caja.append("Como recompensa por derrotar al monstruo se ha obtenido el siguiente drop:");
			this.enemigo.getDrop().mostrarObjeto();
			this.inventario.agregarDrop(this.enemigo.getDrop());
			this.inventario.mostrarTodo();
		}else {
			caja.append("EL MONSTRUO HA GANADO");
		}
	}	
	
	public void enfrentamiento(JTextArea caja) {
		// pelea 6 vs 1
	 buffDados(caja);
	 batalla(this.escuadron, this.hp, this.damage, caja);
		
	}

}