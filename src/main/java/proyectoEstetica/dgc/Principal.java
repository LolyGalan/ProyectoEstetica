package proyectoEstetica.dgc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import clases.Centro;
import clases.Cita;
import clases.Empleado;
import clases.Servicio;
import enums.Especialidad;
import interfaces.Ventana;
import util.DAO;

public class Principal {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		Ventana v=new Ventana();
		/*File carpeta = new File("./");
		if(carpeta.isDirectory()) {
			File[] hijos= carpeta.listFiles();
			for(short i=0; i<hijos.length;i++) {
				System.out.println(hijos[i]);
			}
		}
		
		public static void recorridoRecursivo(File carpeta) {
			if(carpeta.isdirectory()) {
				File[] hijos= carpeta.listFiles();
				for(short i=0; i<hijos.length;i++) {
					File
				} 
			}
		}*/
		
		
		/*File archivo= new File("./noExisto.txt");
		System.out.println("Exite el archivo: "+archivo.exists());
		try {
			System.out.println("Puede crear el archivo"+ archivo.createNewFile());
			System.out.println("Ruta absoluta"+ archivo.getAbsolutePath());
			System.out.println("Nombre: "+ archivo.getName());
			System.out.println("carpeta madre:" + archivo.getParent());
			System.out.println("¿Es un directorio?"+ archivo.isDirectory());
			System.out.println("tamaño total del disco duro" + archivo.getTotalSpace());
			System.out.println("tamaño libre del disco duro: "+archivo.getFreeSpace());
			System.out.println("¿Pude borrarlo?"+ archivo.delete());
			System.out.println("tamaño del archivo(bytes)"+ archivo.length());
			System.out.println("fecha de modificación"+archivo.lastModified());
			LocalDateTime ultimaMod=LocalDateTime.now();
			LocalDateTime ultimaMod2= LocalDateTime.ofEpochSecond(archivo.lastModified()/1000, 0, ZoneOffset.systemDefault().getRules().getOffset(Instant.now()));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		*/
		
		
		
	/*	
		
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Ha empezado");
			LinkedHashSet columnasSacar = new LinkedHashSet<String>();
			columnasSacar.add("nombre");
			columnasSacar.add("apellidos");
			columnasSacar.add("telefono");
			columnasSacar.add("contraseña");
			HashMap<String, Object> resctricciones = new HashMap<String, Object>();
			ArrayList<Object> cliente = DAO.consultar("cliente", columnasSacar, resctricciones);
			for(byte i = 0; i<cliente.size(); i++) {
				if(i%4 == 0) {
					System.out.println();
				}
				System.out.print(cliente.get(i) + " : ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/*
		System.out.println("Dime tu nombre");
		String nombre = sc.nextLine();
		System.out.println("Dime tu apellido");
		String apellido = sc.nextLine();
		System.out.println("Dime tu telefono");
		int telefono = Integer.parseInt(sc.nextLine());
		System.out.println("Dime tu contraseña");
		String contraseña = sc.nextLine();
		TreeMap<String, Cita> citasCogidas= new TreeMap<String, Cita>();
		Empleado empleado1 = new Empleado("Miguel", "Sánchez", 859403946,Especialidad.PELU_MUJER );
		Empleado empleado2 = new Empleado("Migue2", "Sánchez2", 859803946,Especialidad.PELU_HOMBRE );
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(empleado1);
		empleados.add(empleado2);
		ArrayList<Cita> citas = new ArrayList<Cita>();
		Centro centro1 = new Centro("Soho", empleados, citas, "9:00", "20:00" );
		Servicio servicio1= new Servicio("Corte", (byte) 30, centro1, "foto20" );
		Servicio servicio2= new Servicio("Peinado", (byte) 40, centro1, "foto40" );
		Cita cita1 = new Cita(10,"02/01/2024","02/01/2024", servicio1, empleado1 );
		Cita cita2 = new Cita(11,"02/01/2024","02/01/2024", servicio2, empleado2 );
		citas.add(cita1);
		citas.add(cita2);
		citasCogidas.put("01/01/2024", new Cita(10,"02/01/2024","02/01/2024", servicio1, empleado1));
		int citaCogida = cita1.getNumeroDeCita();
		try {
			HashMap<String, Object> cols = new HashMap<String, Object>();
			
			cols.put("nombre", nombre);
			cols.put("apellidos", apellido);
			cols.put("telefono", telefono);
			cols.put("contraseña", contraseña);
			cols.put("citasCogidas",citaCogida );
			DAO.insertar("cliente", cols);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	*/
	}

}
