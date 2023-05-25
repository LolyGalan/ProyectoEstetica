package clases;

import java.sql.SQLException;
import java.util.HashMap;

import util.DAO;

public class Persona extends ElementoConNombre {
	private String apellidos;
	private int telefono;
	private String contraseña;
	
	/*public Persona(String nombre, String apellidos, int telefono) {
		super(nombre);
		this.apellidos = apellidos;
		this.telefono = telefono;
	}
	public Persona(String nombre) {
		super(nombre);
		
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public int getTelefono() {
		return telefono;
	}*/
	
	 public Persona(String nombre, String apellidos, int telefono, String contraseña)throws SQLException {
		super(nombre);
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.contraseña = contraseña;
	}
	 public Persona(String nombre, String contraseña) {
			super(nombre);


			
			this.contraseña = contraseña;
		}
	

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setApellidos(String apellidos) throws SQLException {
	        HashMap<String,Object>datosMod=new HashMap<String,Object>();
	        datosMod.put("apellidos", apellidos);
	        HashMap<String,Object>restriccion=new HashMap<String,Object>();
	        restriccion.put("nombre", this.getNombre());
	        DAO.actualizar("cliente", datosMod, restriccion);
	        this.apellidos = apellidos;
	    }
	    public void setTelefono(int telefono) throws SQLException {
	        HashMap<String,Object>datosMod=new HashMap<String,Object>();
	        datosMod.put("telefono", telefono);
	        HashMap<String,Object>restriccion=new HashMap<String,Object>();
	        restriccion.put("nombre", this.getNombre());
	        DAO.actualizar("cliente", datosMod, restriccion);
	        this.telefono = telefono;
	    }

		@Override
		public String toString() {
			return "Persona [apellidos=" + apellidos + ", telefono=" + telefono + ", contraseña=" + contraseña + "]";
		}
	
	
}
