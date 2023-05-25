package clases;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;

import excepciones.ClienteNoExisteException;
import excepciones.ContraseñaInvalidaException;
import util.DAO;

public class Cliente extends Persona {
	private TreeMap<LocalDateTime, Cita >citasCogidas= new TreeMap<LocalDateTime, Cita>() ;

	/*public Cliente(String nombre, String apellidos, int telefono, Cita citasCogidas) {
		super(nombre, apellidos, telefono);
		this.citasCogidas = citasCogidas;
	}

	public Cita getCitasCogidas() {
		return citasCogidas;
	}

	public void setCitasCogidas(Cita citasCogidas) {
		this.citasCogidas = citasCogidas;
	}

	@Override
	public String toString() {
		return "Cliente [citasCogidas=" + citasCogidas + "]";
	}
	public Cliente(String nombre, String apellidos, int telefono, TreeMap<LocalDateTime, Cita > citasCogidas) throws SQLException {
        super(nombre, apellidos, telefono, contraseña);
        HashMap<String,Object>columnas=new HashMap<String,Object>();
        columnas.put("apellidos", apellidos);
        columnas.put("nombre", nombre);
        columnas.put("telefono", telefono);
        columnas.put("password", contraseña);
        columnas.put("cita", citasCogidas);
       
        DAO.insertar("cliente", columnas);
       
        
    }*/
	public Cliente(String nombre, String apellidos, int telefono, String contraseña,
			TreeMap<LocalDateTime, Cita> citasCogidas)throws SQLException {
		super(nombre, apellidos, telefono, contraseña);
		HashMap<String,Object>columnas=new HashMap<String,Object>();
		columnas.put("nombre", nombre);
		columnas.put("apellidos", apellidos);
        columnas.put("telefono", telefono);
        columnas.put("contraseña", contraseña);
        columnas.put("citasCogidas", citasCogidas.size()); //Preguntar a Miguel cómo puedo poner aquí un entero correcto
       
        DAO.insertar("cliente", columnas);//quitar unique de citasCogidas
	}
	
   

	public Cliente(String nombre,String contraseña) throws SQLException, ClienteNoExisteException, ContraseñaInvalidaException {
    	super(nombre, contraseña);
        HashMap<String,Object>restricciones=new HashMap<String,Object>();
        restricciones.put("nombre", nombre);
        LinkedHashSet<String>columnasSelect=new LinkedHashSet<String>();
        columnasSelect.add("nombre");
        columnasSelect.add("apellidos");
        columnasSelect.add("telefono");
        columnasSelect.add("contraseña");
        columnasSelect.add("citasCogidas");
        ArrayList<Object>ret=new ArrayList<Object>();
        ret=DAO.consultar("cliente", columnasSelect, restricciones);
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
	 public TreeMap<LocalDateTime, Cita> getCitasCogidas() {
		return citasCogidas;
	}

	public void setCitasCogidas(TreeMap<LocalDateTime, Cita> citasCogidas) throws SQLException {
		HashMap<String,Object>datosMod=new HashMap<String,Object>();
		datosMod.put("citasCogidas", citasCogidas);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("nombre", this.getNombre());
        DAO.actualizar("empleado", datosMod, restriccion);
		this.citasCogidas = citasCogidas;
	}
	/*public static ArrayList<Cliente> getTodos() throws SQLException{
		   LinkedHashSet<String> columnasSacar = new LinkedHashSet<>();
		   columnasSacar.add("email");
		   columnasSacar.add("telefono");
		   columnasSacar.add("nombre");
		   HashMap<String,Object> restricciones = new HashMap<>();
		   ArrayList<Cliente> clientes = new ArrayList<>();
		   ArrayList<Object> listaClientes= new ArrayList<>();
		   listaClientes=DAO.consultar("cliente", columnasSacar, restricciones);
		   for(byte i =0;i<listaClientes.size();i+=3) {
			   Cliente cliente = new Cliente((String)listaClientes.get(i),(String)listaClientes.get(i+2),(int)listaClientes.get(i+1));
		   clientes.add(cliente);
		   }
		   return clientes;
	   }*/
   

@Override
	public String toString() {
		return "Cliente [citasCogidas=" + citasCogidas + "]";
	}
 
	
	
}
