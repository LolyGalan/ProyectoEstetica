package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import clases.Centro;
import excepciones.ClienteNoExisteException;

import javax.swing.BoxLayout;

public class PantallaCentros extends JPanel{
	private Ventana ventana;
	public PantallaCentros(Ventana v) throws SQLException, ClienteNoExisteException {
		setBackground(new Color(255, 255, 255));
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel welcomeLabel = new JLabel("Hola, "+ ventana.clienteLogado.getNombre()+ " aquí puedes elegir centro " );
		add(welcomeLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JScrollPane lista = new JScrollPane();
		add(lista, BorderLayout.CENTER);
		
		JPanel contenedorElementos = new JPanel();
		lista.setViewportView(contenedorElementos);
		contenedorElementos.setLayout(new BoxLayout(contenedorElementos, BoxLayout.Y_AXIS));
		ArrayList<Centro> todos= Centro.getTodos();
		for(byte i=0;i<todos.size();i++) {
			contenedorElementos.add(new ElementoListaCentro(ventana, todos.get(i)));
		}
		System.out.println(todos.size());
	}

}
