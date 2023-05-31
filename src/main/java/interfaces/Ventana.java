package interfaces;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import clases.Cliente;
import excepciones.ClienteNoExisteException;

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
	public void cambiarAPantalla(Class<?> clase) throws SQLException, ClienteNoExisteException {
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
		if (clase.equals(PantallaCentros.class)) {
			this.setContentPane(new PantallaCentros(this));
		}
		this.getContentPane().setVisible(true);
	}
}
