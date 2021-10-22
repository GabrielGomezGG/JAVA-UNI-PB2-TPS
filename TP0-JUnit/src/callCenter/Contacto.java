package callCenter;

public class Contacto {
	
	private String nombre;
	private String apellido;
	private String celular;
	private String email;
	private String direccion;
	private Integer codigoPostal;
	private String localidad;
	private Provincias provincia;
	private Boolean esCliente;
	private Boolean deseaSerLlamadoNuevamente;
	
	public Contacto(String nombre, String apellido, String celular, String email, String direccion,
			Integer codigoPostal, String localidad, Provincias provincia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.email = email;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.setProvincia(provincia);
		
		esCliente = false;
		deseaSerLlamadoNuevamente = true;
	}
	
	public Contacto(String nombre, String apellido, String celular, String email, String direccion,
			Integer codigoPostal, String localidad, Provincias provincia, Boolean esCliente, Boolean desea) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.email = email;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.setProvincia(provincia);
		
		this.esCliente = esCliente;
		deseaSerLlamadoNuevamente = desea;
	}

	public Boolean getEsCliente() {
		return esCliente;
	}

	public void setEsCliente(Boolean esCliente) {
		this.esCliente = esCliente;
	}

	public Boolean getDeseaSerLlamadoNuevamente() {
		return deseaSerLlamadoNuevamente;
	}

	public void setDeseaSerLlamadoNuevamente(Boolean deseaSerLlamadoNuevamente) {
		this.deseaSerLlamadoNuevamente = deseaSerLlamadoNuevamente;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCelular() {
		return celular;
	}

	public String getEmail() {
		return email;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public Provincias getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincias provincia) {
		this.provincia = provincia;
	}
}
