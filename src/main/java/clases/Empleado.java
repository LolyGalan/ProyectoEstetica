package clases;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;

import enums.Especialidad;
import excepciones.ClienteNoExisteException;
import excepciones.ContraseñaInvalidaException;
import util.DAO;

public class Empleado extends Persona {
	private Especialidad especialidad;
	private Centro centro;
	private String horaEntrada;
	private String horaSalida;
	private TreeMap<LocalDateTime, Cita> citas;
	
		/*super(nombre, apellidos, telefono, contraseña);
		this.especialidad = especialidad;
		this.centro = centro;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.citas = citas;
	}*/

	public Empleado(String nombre, String apellidos, int telefono, String contraseña, Especialidad especialidad,
			Centro centro, String horaEntrada, String horaSalida, TreeMap<LocalDateTime, Cita> citas)
			throws SQLException {
		super(nombre, apellidos, telefono, contraseña);
		HashMap<String,Object>columnas=new HashMap<String,Object>();
		columnas.put("nombre", nombre);
		columnas.put("apellidos", apellidos);
        columnas.put("telefono", telefono);
        columnas.put("contraseña", contraseña);
        columnas.put("centro", centro);
        columnas.put("especialidades", especialidad);
        columnas.put("horaEntrada", horaEntrada);
        columnas.put("horaSalida", horaSalida);
        columnas.put("citas", citas);
       
        DAO.insertar("empleado", columnas);
	}
	
	
    public Empleado(String nombre,String contraseña) throws SQLException, ClienteNoExisteException, ContraseñaInvalidaException {
    	super(nombre, contraseña);
        HashMap<String,Object>restricciones=new HashMap<String,Object>();
        restricciones.put("nombre", nombre);
        LinkedHashSet<String>columnasSelect=new LinkedHashSet<String>();
        columnasSelect.add("nombre");
        columnasSelect.add("apellidos");
        columnasSelect.add("telefono");
        columnasSelect.add("contraseña");
        columnasSelect.add("centro");
        columnasSelect.add("especialidades");
        columnasSelect.add("horaEntrada");
        columnasSelect.add("horaSalida");
        columnasSelect.add("citas");
        ArrayList<Object>ret=new ArrayList<Object>();
        ret=DAO.consultar("empleado", columnasSelect, restricciones);
        if(ret.isEmpty()) {
            throw new ClienteNoExisteException("SIN DATOS");
        }else {
            String contraseñaAlmacenada=String.valueOf(ret.get(3));
            if(contraseñaAlmacenada.equals(contraseña)) {
                nombre=(String)(ret.get(0));
            }else {
                throw new ContraseñaInvalidaException("CONTRASEÑA INVALIDA");
            }
        }
       
    }


	public Especialidad getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(Especialidad especialidad) throws SQLException {
		HashMap<String,Object>datosMod=new HashMap<String,Object>();
        datosMod.put("especialidad", especialidad);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("nombre", this.getNombre());
        DAO.actualizar("empleado", datosMod, restriccion);
        this.especialidad = especialidad;
	}


	public Centro getCentro() {
		return centro;
	}


	public void setCentro(Centro centro)throws SQLException {
		HashMap<String,Object>datosMod=new HashMap<String,Object>();
		datosMod.put("centro", centro);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("nombre", this.getNombre());
        DAO.actualizar("empleado", datosMod, restriccion);
		this.centro = centro;
	}


	public String getHoraEntrada() {
		return horaEntrada;
	}


	public void setHoraEntrada(String horaEntrada) throws SQLException {
		HashMap<String,Object>datosMod=new HashMap<String,Object>();
		datosMod.put("horaEntrada", horaEntrada);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("nombre", this.getNombre());
        DAO.actualizar("empleado", datosMod, restriccion);
		this.horaEntrada = horaEntrada;
	}


	public String getHoraSalida() {
		return horaSalida;
	}


	public void setHoraSalida(String horaSalida) throws SQLException {
		HashMap<String,Object>datosMod=new HashMap<String,Object>();
		datosMod.put("horaSalida", horaSalida);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("nombre", this.getNombre());
        DAO.actualizar("empleado", datosMod, restriccion);
		this.horaSalida = horaSalida;
	}


	public TreeMap<LocalDateTime, Cita> getCitas() {
		return citas;
	}


	public void setCitas(TreeMap<LocalDateTime, Cita> citas) throws SQLException {
		HashMap<String,Object>datosMod=new HashMap<String,Object>();
		datosMod.put("citas", citas);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("nombre", this.getNombre());
        DAO.actualizar("empleado", datosMod, restriccion);
		this.citas = citas;
	}


	@Override
	public String toString() {
		return "Empleado [especialidad=" + especialidad + ", centro=" + centro + ", horaEntrada=" + horaEntrada
				+ ", horaSalida=" + horaSalida + ", citas=" + citas + "]";
	}

	
	
}
