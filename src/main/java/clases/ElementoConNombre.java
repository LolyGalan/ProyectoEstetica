package clases;

import java.sql.SQLException;
import java.util.HashMap;

import util.DAO;

public abstract class ElementoConNombre {
	private String nombre;

	public ElementoConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) throws SQLException {
        HashMap<String,Object>datosMod=new HashMap<String,Object>();
        datosMod.put("nombre", nombre);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("nombre", this.nombre);
        DAO.actualizar("cliente", datosMod, restriccion);
        this.nombre = nombre;
    }

	@Override
	public String toString() {
		return "ElementoConNombre [nombre=" + nombre + "]";
	}
	
}
