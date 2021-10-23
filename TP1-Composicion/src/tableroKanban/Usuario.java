package tableroKanban;

public class Usuario {

	private String nombre;
	private Tarea tarea;
	private Boolean tieneTarea;

	public Usuario(String nombre) {
		// TODO Auto-generated constructor stub
		this.setNombre(nombre);
		tieneTarea = false;
	}

	public Tarea getTarea() {
		// TODO Auto-generated method stub
		return tarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getTieneTarea() {
		return tieneTarea;
	}

	public void setTieneTarea(Boolean tieneTarea) {
		this.tieneTarea = tieneTarea;
	}

	public void setTarea(Tarea tarea) {
		if(!tieneTarea) {
			tieneTarea = true;
			this.tarea = tarea;
		}
		
	}

}
