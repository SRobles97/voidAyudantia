package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
@SuppressWarnings("serial")
public class Observacion extends JFrame {
	public JTextArea miTexto;
	private JScrollPane miBarra;
    private Container contenido;
	
	public Observacion() {
		miTexto = new JTextArea(30,50);
		miTexto.setEditable(false);
		miBarra = new JScrollPane(miTexto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setTitle("Batalla");  
		this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.add(miBarra);
        this.setSize(700,700);
        this.setLocationRelativeTo(null);       
	}

}
