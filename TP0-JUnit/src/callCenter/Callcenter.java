package callCenter;

import java.util.ArrayList;
import java.util.Random;

public class Callcenter {
	
	private String nombreEmpresa;
	private Random numAleatirio;
	private ArrayList<Contacto> contactos;
	private ArrayList<Contacto> clientes;
	
	public Callcenter(String nombreEmpresa) {
		this.setNombreEmpresa(nombreEmpresa);
		numAleatirio = new Random();
		contactos = new ArrayList<Contacto>();
		clientes = new ArrayList<Contacto>();
	}
	
	public Boolean realizarNuevaLlamada() {
		
		//si la busqueda fue exitosa
		if(buscarAlCandidato()) {
			return true;
		}
		return false;
	}
	
	public Boolean buscarAlCandidato() {
		
		//si la lista de contactos NO esta vacia
		if(!contactos.isEmpty()) {
			//crea un numero aleatorio entre 0 y el tamaño de la lista.
			//EJ: si la lista tiene 10 elementos(Cliente), se creara
			//un numero aleatorio entre 0 y 9;
			Integer idContacto = numAleatirio.nextInt(contactos.size());
			
			
			
			//1 - 2 - 3
			//SI el contacto seleccionado no es cliente Y desea ser llamado
			//PD: me falta preguntar sobre el codigo postal, pero no lo entendi.
			if(!getContacto(idContacto).getEsCliente() &&
				getContacto(idContacto).getDeseaSerLlamadoNuevamente()) {
				
				//muestra los datos del contacto que se selecciono aleatoriamente en la lista
				mostrarDatosContacto(idContacto);
				
				//a
				getContacto(idContacto).setDeseaSerLlamadoNuevamente(false);
				getContacto(idContacto).setEsCliente(true);
				setCliente(getContacto(idContacto));
				return true;
			}
			//b
			//SI el contacto no cumple las condiciones, PUEDE que 
			//desee ser llamado de nuevo o como puede que no (es aleatorio)
			if(!getContacto(idContacto).getEsCliente() &&
					!getContacto(idContacto).getDeseaSerLlamadoNuevamente()) {
				getContacto(idContacto).setDeseaSerLlamadoNuevamente(numAleatirio.nextBoolean());
			}
			
		}
		
		return false;
	}
	
	public void mostrarDatosContacto(Integer id) {
		System.out.println("ID: " + id);
		System.out.println("nombre: " + contactos.get(id).getNombre());
		System.out.println("apellido: " + contactos.get(id).getApellido());
		System.out.println("celular: " + contactos.get(id).getCelular());
		System.out.println("email: " + contactos.get(id).getEmail());
		System.out.println("direccion: " + contactos.get(id).getDireccion());
		System.out.println("codigo postal: " + contactos.get(id).getCodigoPostal());
		System.out.println("localidad: " + contactos.get(id).getLocalidad());
		//System.out.println("Es cliente: " + contactos.get(id).getEsCliente());
		//System.out.println("Desea ser llamado de nuevo: " + contactos.get(id).getDeseaSerLlamadoNuevamente());
		
	}
	
	public void setContacto(Contacto contacto) {
		contactos.add(contacto);
	}
	
	public void setCliente(Contacto contacto) {
		clientes.add(contacto);
	}
	
	public Contacto getCliente(Integer id) {
		return contactos.get(id);
	}
	
	public Contacto getContacto(Integer id) {

		return contactos.get(id);
	}
	

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public ArrayList<Contacto> getClientes() {
		return clientes;
	}
}
