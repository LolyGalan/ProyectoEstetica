package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import clases.Cliente;
import excepciones.ClienteNoExisteException;
import excepciones.ContraseñaInvalidaException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaLogin extends JPanel {
	private JTextField userField;
	private JTextField textField;
	private JPasswordField passwordField;
	private Ventana ventana;
	public PantallaLogin(Ventana v) {
		this.ventana = v;
		setLayout(null);
		
		JLabel userLabel = new JLabel("Usuario");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		userLabel.setBackground(new Color(240, 240, 240));
		userLabel.setBounds(212, 45, 157, 53);
		add(userLabel);
		
		userField = new JTextField();
		userField.setBounds(212, 92, 157, 46);
		add(userField);
		userField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Contraseña");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		passwordLabel.setBounds(212, 169, 129, 46);
		add(passwordLabel);
		
		
		
		JButton loginButton = new JButton("Iniciar sesión");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre= userField.getText();
				String contraseña=new String (passwordField.getPassword());
				System.out.println(nombre+ " : "+ contraseña);
				try {
					ventana.clienteLogado = new Cliente(nombre, contraseña);
					JOptionPane.showMessageDialog(ventana, "Bienvenido, "+ ventana.clienteLogado.getNombre(), "Inicio de sesión exitoso", JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla(PantallaCliente.class);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Login Fallido", JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				} catch (ClienteNoExisteException e1) {
					JOptionPane.showMessageDialog(ventana, "El cliente no existe", "Login fallido", JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				} catch (ContraseñaInvalidaException e1) {
					JOptionPane.showMessageDialog(ventana, "La contraseña no es correcta", "Login fallido", JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				}
			}
		});
		loginButton.setForeground(new Color(245, 255, 250));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.setBackground(new Color(65, 105, 225));
		loginButton.setBounds(212, 304, 157, 46);
		add(loginButton);
		
		JButton registryButton = new JButton("Regístrate");
		registryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaRegistro.class);
			}
		});
		registryButton.setForeground(new Color(248, 248, 255));
		registryButton.setBackground(new Color(220, 20, 60));
		registryButton.setBounds(212, 398, 167, 23);
		add(registryButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 213, 157, 46);
		add(passwordField);
	}
	 
		
		
		
		


		
	
		
		
		
	
}
