package clases;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;

import enums.Especialidad;
import excepciones.ClienteNoExisteException;
import util.DAO;

public class Centro extends ElementoConNombre{
	private ArrayList<Empleado> empleados;
	private String direccion;
	private BufferedImage foto;
	private BufferedImage logo;
	public Centro(String nombre, ArrayList<Empleado> empleados, String direccion, BufferedImage foto,
			BufferedImage logo) throws SQLException {
		super(nombre);
		HashMap<String,Object>columnas=new HashMap<String,Object>();
		columnas.put("nombre", nombre);
		columnas.put("empleados", empleados);
		columnas.put("direccion", direccion);
        columnas.put("foto", foto);
        columnas.put("logo", logo);
        DAO.insertar("centro", columnas);
	}
	public Centro(String nombre) throws SQLException, ClienteNoExisteException{
    	super(nombre);
        HashMap<String,Object>restricciones=new HashMap<String,Object>();
        restricciones.put("nombre", nombre);
        LinkedHashSet<String>columnasSelect=new LinkedHashSet<String>();
        columnasSelect.add("nombre");
        columnasSelect.add("empleados");
        columnasSelect.add("direccion");
        columnasSelect.add("foto");
        columnasSelect.add("logo");
        ArrayList<Object>ret=new ArrayList<Object>();
        ret=DAO.consultar("centro", columnasSelect, restricciones);
        if(ret.isEmpty()) {
            throw new ClienteNoExisteException("SIN DATOS");
        }
        
    }
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(ArrayList<Empleado> empleados) throws SQLException {
		HashMap<String,Object>datosMod=new HashMap<String,Object>();
        datosMod.put("empleados", empleados);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("nombre", this.getNombre());
        DAO.actualizar("centro", datosMod, restriccion);
		this.empleados = empleados;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) throws SQLException {
		HashMap<String,Object>datosMod=new HashMap<String,Object>();
        datosMod.put("direccion", direccion);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("nombre", this.getNombre());
        DAO.actualizar("centro", datosMod, restriccion);
		this.direccion = direccion;
	}
	public BufferedImage getFoto() {
		return foto;
	}
	public void setFoto(BufferedImage foto) throws SQLException {
		HashMap<String,Object>datosMod=new HashMap<String,Object>();
        datosMod.put("foto", foto);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("nombre", this.getNombre());
        DAO.actualizar("centro", datosMod, restriccion);
		this.foto = foto;
	}
	public BufferedImage getLogo() {
		return logo;
	}
	public void setLogo(BufferedImage logo) throws SQLException {
		HashMap<String,Object>datosMod=new HashMap<String,Object>();
        datosMod.put("logo", logo);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("nombre", this.getNombre());
        DAO.actualizar("centro", datosMod, restriccion);
		this.logo = logo;
	}
	
	public static ArrayList<Centro> getTodos() throws SQLException, ClienteNoExisteException{
		   LinkedHashSet<String> columnasSacar = new LinkedHashSet<>();
		   columnasSacar.add("nombre");
		   HashMap<String,Object> restricciones = new HashMap<>();
		   ArrayList<Centro> centros = new ArrayList<>();
		   ArrayList<Object> listaCentros= new ArrayList<>();
		   listaCentros=DAO.consultar("centro", columnasSacar, restricciones);
		   for(byte i =0;i<listaCentros.size();i+=3) {
			   Centro centro = new Centro(
					   (String)listaCentros.get(i));
		   centros.add(centro);
		   }
		   return centros;
	   }

	@Override
	public String toString() {
		return "Centro [empleados=" + empleados + ", direccion=" + direccion + ", foto=" + foto + ", logo=" + logo
				+ "]";
	}
	
	
	
	
	
	
	
	
	
}
