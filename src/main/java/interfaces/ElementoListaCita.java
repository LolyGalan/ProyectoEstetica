package interfaces;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clases.Cita;
import excepciones.ClienteNoExisteException;

public class ElementoListaCita extends JPanel {
	Ventana ventana;
	Cita citaActual;
	public ElementoListaCita( Ventana v, Cita c) {
		this.ventana=v;
		this.citaActual=c;
		setBackground(new Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{82, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel servicioLabel = new JLabel(""+ citaActual.getServicio());
		GridBagConstraints gbc_servicioLabel = new GridBagConstraints();
		gbc_servicioLabel.insets = new Insets(0, 0, 5, 5);
		gbc_servicioLabel.gridx = 1;
		gbc_servicioLabel.gridy = 1;
		add(servicioLabel, gbc_servicioLabel);
		
		JButton serviveButton = new JButton("Elegir servicio");
		serviveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ventana.cambiarAPantalla(getClass());
				} catch (SQLException e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
				} catch (ClienteNoExisteException e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_serviveButton = new GridBagConstraints();
		gbc_serviveButton.insets = new Insets(0, 0, 5, 5);
		gbc_serviveButton.gridx = 3;
		gbc_serviveButton.gridy = 1;
		add(serviveButton, gbc_serviveButton);
		
		
		
		
	}
}
