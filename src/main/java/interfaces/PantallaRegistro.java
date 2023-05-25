package interfaces;

import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Cita;
import clases.Cliente;
import clases.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.TreeMap;

import javax.swing.JTextArea;

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField phoneField;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/*private JTextField textField;
	private JTextField surnameField;
	private JTextField textField_1;
	private JTextField passwordField;*/
	public PantallaRegistro(Ventana v) {
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		add(textArea, gbc_textArea);
		setBackground(new Color(255, 255, 255));
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{130, 195, 160, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 49, 43, 44, 42, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel nameLabel = new JLabel("Nombre");
		nameLabel.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.gridwidth = 2;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 1;
		gbc_nameLabel.gridy = 1;
		add(nameLabel, gbc_nameLabel);
		
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.gridwidth = 2;
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 2;
		add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		JLabel surnameLabel = new JLabel("Apellido");
		surnameLabel.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_surnameLabel = new GridBagConstraints();
		gbc_surnameLabel.gridwidth = 2;
		gbc_surnameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_surnameLabel.gridx = 1;
		gbc_surnameLabel.gridy = 3;
		add(surnameLabel, gbc_surnameLabel);
		
		surnameField = new JTextField();
		GridBagConstraints gbc_surnameField = new GridBagConstraints();
		gbc_surnameField.gridwidth = 2;
		gbc_surnameField.insets = new Insets(0, 0, 5, 5);
		gbc_surnameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_surnameField.gridx = 1;
		gbc_surnameField.gridy = 4;
		add(surnameField, gbc_surnameField);
		surnameField.setColumns(10);
		
		JLabel phoneLabel = new JLabel("Teléfono");
		phoneLabel.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
		gbc_phoneLabel.gridwidth = 2;
		gbc_phoneLabel.insets = new Insets(0, 0, 5, 5);
		gbc_phoneLabel.gridx = 1;
		gbc_phoneLabel.gridy = 5;
		add(phoneLabel, gbc_phoneLabel);
		
		phoneField = new JTextField();
		GridBagConstraints gbc_phoneField = new GridBagConstraints();
		gbc_phoneField.gridwidth = 2;
		gbc_phoneField.insets = new Insets(0, 0, 5, 5);
		gbc_phoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneField.gridx = 1;
		gbc_phoneField.gridy = 6;
		add(phoneField, gbc_phoneField);
		phoneField.setColumns(10);
		
		JLabel passwordLabel_3 = new JLabel("Contraseña");
		passwordLabel_3.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_passwordLabel_3 = new GridBagConstraints();
		gbc_passwordLabel_3.gridwidth = 2;
		gbc_passwordLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel_3.gridx = 1;
		gbc_passwordLabel_3.gridy = 7;
		add(passwordLabel_3, gbc_passwordLabel_3);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 8;
		add(passwordField, gbc_passwordField);
		
		JButton registryButton = new JButton("Registrar");
		registryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					String nombre=nameField.getText().toString();
					String apellidos=surnameField.getText().toString();
					int telefono = Integer.parseInt(phoneField.getText());
					String contraseña = new String(passwordField.getPassword());
					TreeMap<LocalDateTime, Cita> citasCogidas = new TreeMap<LocalDateTime, Cita>();
					new Cliente(nombre, apellidos, telefono, contraseña, citasCogidas );
					JOptionPane.showMessageDialog(ventana, "Registrado Correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla(PantallaLogin.class);
				}/* catch (SQLIntegrityConstraintViolationException e3) {
					JOptionPane.showMessageDialog(ventana,  "El nombre de usuario ya existe", "No se pudo registar", JOptionPane.ERROR_MESSAGE);
					Esta condición que de que no se repita el nombre siempre salta
				}*/ catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana,  e1.getMessage(), "No se puede conectar a la Base de datos", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(ventana, "Tienes que poner un número de teléfono correcto", "Número de teléfono incorrecto", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_registryButton = new GridBagConstraints();
		gbc_registryButton.fill = GridBagConstraints.BOTH;
		gbc_registryButton.gridwidth = 2;
		gbc_registryButton.insets = new Insets(0, 0, 5, 5);
		gbc_registryButton.gridx = 1;
		gbc_registryButton.gridy = 11;
		add(registryButton, gbc_registryButton);
		
		JButton gobackButton = new JButton("Volver");
		gobackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
		});
		GridBagConstraints gbc_gobackButton = new GridBagConstraints();
		gbc_gobackButton.insets = new Insets(0, 0, 0, 5);
		gbc_gobackButton.gridx = 0;
		gbc_gobackButton.gridy = 13;
		add(gobackButton, gbc_gobackButton);
		
		/*JLabel nameLabel = new JLabel("Nombre");
		nameLabel.setBounds(84, 37, 46, 14);
		add(nameLabel);
		
		textField = new JTextField();
		textField.setBounds(79, 62, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel surnameLabel = new JLabel("Apellido");
		surnameLabel.setBounds(84, 123, 46, 14);
		add(surnameLabel);
		
		surnameField = new JTextField();
		surnameField.setBounds(79, 148, 86, 20);
		add(surnameField);
		surnameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Telefono");
		lblNewLabel.setBounds(84, 209, 46, 14);
		add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(84, 234, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Contraseña");
		passwordLabel.setBounds(84, 287, 86, 14);
		add(passwordLabel);
		
		passwordField = new JTextField();
		passwordField.setBounds(84, 312, 86, 20);
		add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar datos");
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(236, 421, 108, 23);
		add(btnNewButton);*/
	}

}
