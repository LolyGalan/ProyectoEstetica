package interfaces;

import javax.swing.JPanel;

import clases.Centro;
import excepciones.ClienteNoExisteException;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ElementoListaCentro extends JPanel{
	Ventana ventana;
	Centro centroActual;
	public ElementoListaCentro( Ventana v, Centro c) {
		this.ventana=v;
		this.centroActual=c;
		setBackground(new Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{82, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel nameLabel = new JLabel(centroActual.getNombre());
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 1;
		gbc_nameLabel.gridy = 0;
		add(nameLabel, gbc_nameLabel);
		
		JButton btnNewButton = new JButton("Elegir centro");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ventana.cambiarAPantalla(PantallaCita.class);
				} catch (SQLException e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
				} catch (ClienteNoExisteException e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel directionLabel = new JLabel(centroActual.getDireccion());
		GridBagConstraints gbc_directionLabel = new GridBagConstraints();
		gbc_directionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_directionLabel.gridx = 1;
		gbc_directionLabel.gridy = 1;
		add(directionLabel, gbc_directionLabel);
		
		
	}
	
}
