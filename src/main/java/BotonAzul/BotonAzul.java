package BotonAzul;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;

import excepciones.ClienteNoExisteException;
import interfaces.PantallaRegistro;

public class BotonAzul extends JButton {
	public BotonAzul(String text){
		super(text);
		this.setForeground(new Color(255,255,255));
		this.setFont(new Font("Arial",Font.BOLD,18));
		this.setBackground(new Color(0,64,128));
		
		this.addMouseListener(new MouseAdapter() {
		
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(0,0,50));
				setBackground(new Color(200,200,240));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setForeground(new Color(255,255,255));
				setBackground(new Color(0,64,128));
				setCursor(new Cursor(java.awt.Cursor.DEFAULT_CURSOR));
				
			}
		});
	}
}
