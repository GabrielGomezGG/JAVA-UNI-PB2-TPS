package tableroKanban;

import java.util.ArrayList;

public class tableroKanban {
	
	

	private ArrayList<Usuario> usuarios;
	private ArrayList<Tarea> tareas;

	public tableroKanban() {
		// TODO Auto-generated constructor stub
		usuarios = new ArrayList<Usuario>();
		tareas = new ArrayList<Tarea>();
	}

	public Boolean setTareas() {
		// TODO Auto-generated method stub
		
		if(!usuarios.isEmpty()) {
			for(int i = 0; i < usuarios.size(); i++) {
				if(usuarios.get(i).getTieneTarea()) {
					tareas.add(usuarios.get(i).getTarea());
				}
			}
			return true;
		}
		
		return false;
		
	}

	public void setUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarios.add(usuario);
		
	}

	public ArrayList<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return usuarios;
	}

	public ArrayList<Tarea> getTareas() {
		// TODO Auto-generated method stub
		return tareas;
	}
	
	
	public void mostrarTareas() {
		
		for(int i = 0; i < tareas.size();i++) {
			System.out.println("id de tarea: " + i);
			System.out.println("Estado de la tarea: " + tareas.get(i).getNombreCreador());
			System.out.println("Nombre del creador: " +tareas.get(i).getEstado());
		}
		
	}

}
