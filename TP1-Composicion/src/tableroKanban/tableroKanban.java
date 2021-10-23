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
			System.out.println();
		}
		
	}
	
	public String mostrarTarea(Integer index) {
		
			/*
			System.out.println("id de tarea: " + index);
			System.out.println("Estado de la tarea: " + tareas.get(index).getNombreCreador());
			System.out.println("Nombre del creador: " +tareas.get(index).getEstado());
			System.out.println();
			*/
			if(index >= 0 && index < tareas.size()) {
			return  index + 
					"\nEstado de la tarea: " + tareas.get(index).getEstado() +
					"\nNombre del creador: " + tareas.get(index).getNombreCreador();
			}
			return null;
		
		
	}

	public Boolean cambiarEstadoDeTarea(Usuario usuario, Integer idTarea, Estados estados) {
		
		//textos que agrego para ver si funciona bien.
		String[] condiciones = new String[3];
		//si la tarea esta en curso y es el mismo usuario el que la creo
		condiciones[0] = "La tarea " + mostrarTarea(idTarea) + "\ncambio de estado a " + estados.name()+ "\n";
		//si la tarea esta pendiente o finalizada
		condiciones[1] = "La tarea " + mostrarTarea(idTarea) + "\ncambio de estado a " + estados.name() + "\n";
		//si la tarea no existe en la lista
		condiciones[2] = "No existe esa tarea en la lista.";
		
		//si la tarea que elegiste (por medio de idTarea) existe en la lista de tareas
		if((idTarea >= 0)  && (idTarea < tareas.size())) {
			//si la tarea esta en curso y es del mismo creador
			if(tareas.get(idTarea).getEstado() == Estados.EN_CURSO &&
			   tareas.get(idTarea).getNombreCreador() == usuario.getNombre()) {
				
					tareas.get(idTarea).setEstado(estados);
					System.out.println(condiciones[0]);
					return true;
			}
			//si es el estado no esta en curso
			if(tareas.get(idTarea).getEstado() != Estados.EN_CURSO) {	
					tareas.get(idTarea).setEstado(estados);
					tareas.get(idTarea).setNombreCreador(usuario.getNombre());
					System.out.println(condiciones[1]);	
					return true;
			}
		}
		System.out.println(condiciones[2]);	
		return false;
		
	}

}
