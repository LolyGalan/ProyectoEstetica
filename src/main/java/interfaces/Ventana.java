package interfaces;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import clases.Cliente;

public class Ventana extends JFrame {
	protected Cliente clienteLogado;
	public Ventana() {
		this.setSize(600, 500);
		this.setTitle("Peluquería y estetica");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new PantallaLogin(this));
		//this.setIconImage(new ImageIcon("./IMG_2699.jpg").getImage());
		this.setVisible(true);
		
	}
	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if(clase.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		}
		if(clase.equals(PantallaRegistro.class)) {
			this.setContentPane(new PantallaRegistro(this));
		}
		if (clase.equals(PantallaCliente.class)) {
			this.setContentPane(new PantallaCliente(this));
		}
		this.getContentPane().setVisible(true);
	}
}
