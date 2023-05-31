package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clases.Centro;
import clases.Cita;
import excepciones.ClienteNoExisteException;

public class PantallaCita extends JPanel{
	private Ventana ventana;
	public PantallaCita(Ventana v) throws SQLException, ClienteNoExisteException {
		setBackground(new Color(255, 255, 255));
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel welcomeLabel = new JLabel("Hola, "+ ventana.clienteLogado.getNombre()+ " aquí puedes coger cita " );
		add(welcomeLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		/*JButton registryCitaButton = new JButton("Elegir centro");
		panel.add(registryCitaButton);*/
		
		JScrollPane lista = new JScrollPane();
		add(lista, BorderLayout.CENTER);
		
		JPanel contenedorElementos = new JPanel();
		lista.setViewportView(contenedorElementos);
		contenedorElementos.setLayout(new BoxLayout(contenedorElementos, BoxLayout.Y_AXIS));
		ArrayList<Cita> todos= Cita.getTodos();
		for(byte i=0;i<todos.size();i++) {
			contenedorElementos.add(new ElementoListaCita(ventana, todos.get(i)));
		}
		System.out.println(todos.size());
	}
	
}
