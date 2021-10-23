package tableroKanban;

public class Tarea {
	
	private Estados estado;
	private String nombreCreador;
	private Integer idTarea;

	public Tarea(Estados estado, String nombreCreador) {
		// TODO Auto-generated constructor stub
		this.setEstado(estado);
		this.setNombreCreador(nombreCreador);
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public String getNombreCreador() {
		return nombreCreador;
	}

	public void setNombreCreador(String nombreCreador) {
		this.nombreCreador = nombreCreador;
	}

	public Integer getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}

}
