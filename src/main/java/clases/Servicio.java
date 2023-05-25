package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import enums.Especialidad;
import excepciones.ClienteNoExisteException;
import util.DAO;

public class Servicio extends ElementoConNombre {
	private byte tiempoEnMinutos;
	private Centro centro;
	private Especialidad especialidad;
	
	
	public Servicio(String nombre, byte tiempoEnMinutos, Centro centro, Especialidad especialidad) throws SQLException {
		super(nombre);
		HashMap<String,Object>columnas=new HashMap<String,Object>();
		columnas.put("tiempo", tiempoEnMinutos);
		columnas.put("centro", centro);
		columnas.put("especialidad", especialidad);
       
        DAO.insertar("servicio", columnas);
	}
	public Servicio(String nombre) throws SQLException{
    	super(nombre);
       
        LinkedHashSet<String>columnasSelect=new LinkedHashSet<String>();
        columnasSelect.add("nombre");
        columnasSelect.add("tiempo");
        columnasSelect.add("centro");
        columnasSelect.add("especialidad");
        ArrayList<Object>ret=new ArrayList<Object>();
        ret=DAO.consultar("servicio", columnasSelect, null);
        
        
    }
	public byte getTiempoEnMinutos() {
		return tiempoEnMinutos;
	}
	public void setTiempoEnMinutos(byte tiempoEnMinutos) {
		this.tiempoEnMinutos = tiempoEnMinutos;
	}
	public Centro getCentro() {
		return centro;
	}
	public void setCentro(Centro centro) {
		this.centro = centro;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	@Override
	public String toString() {
		return "Servicio [tiempoEnMinutos=" + tiempoEnMinutos + ", centro=" + centro + ", especialidad=" + especialidad
				+ "]";
	}
	
	
	
}
