package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import excepciones.ClienteNoExisteException;
import excepciones.ContraseñaInvalidaException;
import util.DAO;

public class Cita {
	private int numeroDeCita;
	private String fechaInicio;
	private String fechaFin;
	private Servicio servicio;
	private Empleado empleado;
	public Cita(int numeroDeCita, String fechaInicio, String fechaFin, Servicio servicio, Empleado empleado) throws SQLException {
		super();
		HashMap<String,Object>columnas=new HashMap<String,Object>();
		columnas.put("numeroDeCita", numeroDeCita);
		columnas.put("fechaInicio", fechaInicio);
        columnas.put("fechaFin", fechaFin);
        columnas.put("servicio", servicio);
        columnas.put("empleado", empleado); //Preguntar a Miguel cómo puedo poner aquí un entero correcto
       
        DAO.insertar("cita", columnas);
	}
	public Cita() throws SQLException{
    	super();
       /* HashMap<String,Object>restricciones=new HashMap<String,Object>();
        restricciones.put("nombre", nombre);*/
        LinkedHashSet<String>columnasSelect=new LinkedHashSet<String>();
        columnasSelect.add("numeroDeCita");
        columnasSelect.add("fechaInicio");
        columnasSelect.add("fechaFin");
        columnasSelect.add("servicio");
        columnasSelect.add("empleado");
        ArrayList<Object>ret=new ArrayList<Object>();
        ret=DAO.consultar("cliente", columnasSelect, null);
        
       
    }
	public int getNumeroDeCita() {
		return numeroDeCita;
	}
	public void setNumeroDeCita(int numeroDeCita) {
		this.numeroDeCita = numeroDeCita;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	@Override
	public String toString() {
		return "Cita [numeroDeCita=" + numeroDeCita + ", fechaInicio=" + fechaInicio + ", FechaFin=" + fechaFin
				+ ", servicio=" + servicio + ", empleado=" + empleado + "]";
	}
	
	
	
}
