package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class PantallaCliente extends JPanel{
	private Ventana ventana;
	public PantallaCliente(Ventana v) {
		setBackground(new Color(255, 255, 255));
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel welcomeLabel = new JLabel("Hola, "+ ventana.clienteLogado.getNombre() );
		add(welcomeLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JButton registryCitaButton = new JButton("Registrar cita");
		panel.add(registryCitaButton);
		
		JScrollPane lista = new JScrollPane();
		add(lista, BorderLayout.CENTER);
		
		JPanel contenedorElementos = new JPanel();
		lista.setViewportView(contenedorElementos);
		contenedorElementos.setLayout(new BoxLayout(contenedorElementos, BoxLayout.Y_AXIS));
		for(byte i=0;i<100;i++) {
			contenedorElementos.add(new ElementoListaCliente(ventana, ventana.clienteLogado));
		}
	}

}
