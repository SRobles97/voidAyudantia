package progra;

public class Monstruo extends Personaje {
	private ObjetoEquipable[] objetos;
	private ObjetoEquipable drop;
	
	Monstruo(){
		this.hp = random(3500,4000);
		this.atk = random(1000,1500);		
		this.def = random(5,25);
		this.spd = random(10,100);
		this.objetos = new ObjetoEquipable[3];
		generarObjetos();
		this.drop = obtenerDrop();
	}
	
	public ObjetoEquipable getDrop() {
		return this.drop;
	}	
	
	private ObjetoEquipable obtenerRango(ObjetoEquipable objeto, int rango) {
		objeto = new ObjetoEquipable();
		if(objeto.getRarity() == rango) {
			return objeto;
		}else {
			return obtenerRango(objeto,rango);
		}
	}
	
	private void generarObjetos() {
		this.objetos[0] = obtenerRango(this.objetos[0] , 5);
		this.objetos[1] = obtenerRango(this.objetos[1] , 3);		
		this.objetos[2] = obtenerRango(this.objetos[2] , 1);		
		
	}
	
	private ObjetoEquipable obtenerDrop() {
		generarObjetos();
		double prob = Math.random();
		if(prob < 0.6) {
			return this.objetos[2];
		}else if(prob < 0.9) {
			return this.objetos[1];
		}else {
			return this.objetos[0];
		}
	}	
	
	public void mostrarDrop() {
		System.out.println("Drop del monstruo: ");
		this.drop.mostrarObjeto();
	}	

}
