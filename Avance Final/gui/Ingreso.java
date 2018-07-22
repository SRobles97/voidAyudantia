package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ayudantia.*;

@SuppressWarnings("serial")
public class Ingreso extends JFrame implements ActionListener {
	private Batalla testing;
    private JButton crearEscuadron;
	private JButton inicioBatalla;
	private JTextArea alianza;
	private JTextArea enemigos;
	private JLabel squad;
	private JLabel enemy;
    private Container contenido;
	
	public Ingreso() {
		super();
    	this.contenido = this.getContentPane();
    	this.contenido.setBackground(Color.LIGHT_GRAY);
    	this.testing = new Batalla();
    	configuracionVentana();
		inicioComponentes();
		accionBotones();
		this.setVisible(true);
	}
	
	private void configuracionVentana() {
        this.setTitle("testing");               
        this.setBounds(100, 100, 788, 525);                         
        this.setLocationRelativeTo(null);                     
        this.setLayout(null);                                
        this.setResizable(false);          
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

	}
	
	private void inicioComponentes() {
		crearEscuadron = new JButton("Crear Escuadron");
        crearEscuadron.setBounds(63, 376, 135, 25);
        inicioBatalla = new JButton("BATALLA");
        inicioBatalla.setBounds(301, 163, 179, 109);   
        alianza = new JTextArea();
        alianza.setBackground(Color.WHITE);
		alianza.setEditable(false);
		alianza.setBounds(22, 110, 231, 239);
		enemigos = new JTextArea();
        enemigos.setBackground(Color.WHITE);
        enemigos.setEditable(false);
        enemigos.setBounds(536, 110, 207, 239);	
		squad = new JLabel("Escuadrón Humano");
		squad.setBounds(82, 81, 116, 16);
		enemy = new JLabel("Monstruo Enemigo");
		enemy.setBounds(582, 81, 116, 16);;
        this.add(crearEscuadron);
        this.add(inicioBatalla);
        this.add(alianza);
        this.add(enemigos);
        this.add(squad);
        this.add(enemy);
		
	}
	
	private void accionBotones() {
        inicioBatalla.addActionListener(this);  
        crearEscuadron.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				testing.setEscuadron();
				alianza.setText("           Datos de los luchadores:\n"
				+"1. Nombre: "+testing.getEscuadron(0).getName()+"\n Facción: "+testing.getEscuadron(0).getGuild()+"\n"
				+"2. Nombre: "+testing.getEscuadron(1).getName()+"\n Facción: "+testing.getEscuadron(1).getGuild()+"\n"
				+"3. Nombre: "+testing.getEscuadron(2).getName()+"\n Facción: "+testing.getEscuadron(2).getGuild()+"\n"
				+"4. Nombre: "+testing.getEscuadron(3).getName()+"\n Facción: "+testing.getEscuadron(3).getGuild()+"\n"
				+"5. Nombre: "+testing.getEscuadron(4).getName()+"\n Facción: "+testing.getEscuadron(4).getGuild()+"\n"
				+"6. Nombre: "+testing.getEscuadron(5).getName()+"\n Facción: "+testing.getEscuadron(5).getGuild());	
				enemigos.setText("  Estadisticas del Enemigo: \n Facción: "+testing.getEnemigo().getGuild()+"\n HP: "+testing.getEnemigo().getHP()+"\n ATK: "+testing.getEnemigo().getATK()+"\n DEF: "+testing.getEnemigo().getDEF()+"\n AGI: "+testing.getEnemigo().getAGI());
			}
        });    
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(alianza.getText().equals("")) {
			JOptionPane.showMessageDialog(this,
				    "Debes crear al escuadrón antes de iniciar la batalla.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);			
		}else {
			Observacion prueba = new Observacion();
			prueba.setVisible(true);
			testing.enfrentamiento(prueba.miTexto);
		}
	}
	
	public static void main(String[] args) {
		Ingreso m = new Ingreso();
	}

}
