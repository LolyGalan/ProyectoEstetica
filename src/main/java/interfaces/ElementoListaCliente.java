package interfaces;

import javax.swing.JPanel;

import clases.Cliente;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;

public class ElementoListaCliente extends JPanel{
	Ventana ventana;
	Cliente clienteActual;
	public ElementoListaCliente( Ventana v, Cliente c) {
		this.ventana=v;
		this.clienteActual=c;
		setBackground(new Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{82, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel nameLabel = new JLabel(clienteActual.getNombre());
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 0;
		add(nameLabel, gbc_nameLabel);
		
		JButton btnNewButton = new JButton("Elegir");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel phoneLabel = new JLabel(""+clienteActual.getTelefono());
		GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
		gbc_phoneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_phoneLabel.gridx = 0;
		gbc_phoneLabel.gridy = 1;
		add(phoneLabel, gbc_phoneLabel);
		
		JLabel surnameLabel = new JLabel(""+clienteActual.getApellidos());
		GridBagConstraints gbc_surnameLabel = new GridBagConstraints();
		gbc_surnameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_surnameLabel.gridx = 0;
		gbc_surnameLabel.gridy = 2;
		add(surnameLabel, gbc_surnameLabel);
		
		JLabel citasLabel = new JLabel(""+clienteActual.getCitasCogidas());
		GridBagConstraints gbc_citasLabel = new GridBagConstraints();
		gbc_citasLabel.insets = new Insets(0, 0, 0, 5);
		gbc_citasLabel.gridx = 0;
		gbc_citasLabel.gridy = 3;
		add(citasLabel, gbc_citasLabel);
	}
	
}
