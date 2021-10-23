package tableroKanban;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;


class TestKanban {
	
	tableroKanban kanban = new tableroKanban();
	
	String[] nombres = new String[]{"Matias", "Lorenzo","Jorge","Luis","Fede"};
	Estados[] estados =  new Estados[]{Estados.PENDIENTE,Estados.EN_CURSO,Estados.FINALIZADA};
	
	//numero aleatorio
	Random ran = new Random();
	//eligiendo una "semilla" podras tener siempre los mismos numeros aleatorios en cada test
	int semilla = 1;
	

	@Test
	void queSeAgregen10UsuariosExitosamente() {
		System.out.println("TestAgregar10Usuarios"+ "\n");
		ran.setSeed(semilla);
		for(int i = 0; i < 10; i++) {
			kanban.setUsuario(new Usuario(nombres[ran.nextInt(5)]));
		}
		
		assertEquals(10,kanban.getUsuarios().size());
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	@Test
	void queSePuedaAgregarLasTareasAlTablero() {
		System.out.println("TestSetTareas"+ "\n");
		ran.setSeed(semilla);
		for(int i = 0; i < 10; i++) {
			kanban.setUsuario(new Usuario(nombres[ran.nextInt(5)]));
			//le asigna una tarea al usuario creado
			kanban.getUsuarios().get(i).setTarea(new Tarea(estados[ran.nextInt(3)], kanban.getUsuarios().get(i).getNombre() ));
		}
		
		
		kanban.setTareas();
		kanban.mostrarTareas();
		
		assertFalse(kanban.getTareas().isEmpty());
		
		System.out.println("---------------------------------------------------------");
	}
	
	
	@Test
	void queUnUsuarioPuedaCambiarDeEstadoUnaTarea() {
		
		System.out.println("TestCambiarEstadoDeTarea"+ "\n");
		
		ran.setSeed(semilla);
		int idTarea = 1;
		
		
		for(int i = 0; i < 10; i++) {
			kanban.setUsuario(new Usuario(nombres[ran.nextInt(5)]));
			//le asigna una tarea al usuario creado
			kanban.getUsuarios().get(i).setTarea(new Tarea(estados[ran.nextInt(3)], kanban.getUsuarios().get(i).getNombre() ));
		}
		
		kanban.setTareas();
		
		//elegimos una tarea que este pendiente o terminada para cambiar de estado															 
		
		assertTrue(kanban.cambiarEstadoDeTarea(kanban.getUsuarios().get(0), idTarea, estados[ran.nextInt(3)]));
		
		kanban.mostrarTareas();
		System.out.println("**********************************************************");
		
	}
	
	@Test
	void queElCreadorDeUnaTareaEnCursoPuedaCambiarDeEstadoSuTarea() {
		
		System.out.println("TestCambiarEstadoDeTareaEnCurso\n");
		
		ran.setSeed(semilla);
		int idTarea = 4;
		
		
		for(int i = 0; i < 10; i++) {
			kanban.setUsuario(new Usuario(nombres[ran.nextInt(5)]));
			//le asigna una tarea al usuario creado
			kanban.getUsuarios().get(i).setTarea(new Tarea(estados[ran.nextInt(3)], kanban.getUsuarios().get(i).getNombre() ));
		}
		
		kanban.setTareas();
		
		//elegimos una tarea que este en curso y que sea el mismo creador															 
		
		assertTrue(kanban.cambiarEstadoDeTarea(kanban.getUsuarios().get(4), idTarea, estados[ran.nextInt(3)]));
		
		kanban.mostrarTareas();
		System.out.println("**********************************************************");
		
	}
	
	@Test
	void queLaTareaSeleccionadaNoExistaEnLaLista() {
		
		System.out.println("TestqueNoExistirTareaSelecionadaEnLaLista\n");
		
		ran.setSeed(semilla);
		Integer idTarea = 14; 
		//Integer idTarea = 0;
		
		
		for(int i = 0; i < 10; i++) {
			kanban.setUsuario(new Usuario(nombres[ran.nextInt(5)]));
			//le asigna una tarea al usuario creado
			kanban.getUsuarios().get(i).setTarea(new Tarea(estados[ran.nextInt(3)], kanban.getUsuarios().get(i).getNombre() ));
		}
		
		kanban.setTareas();
		
		//elegimos un id de Tarea que no exista en la lista de tareas															 
		
		System.out.println("Tarea seleccionada: " + idTarea);
		System.out.println("Tamaño de tareas: 0/" + (kanban.getTareas().size()-1));
		
		//Por alguna razon que desconosco, si el idTarea es 0, la funcion cambiarEstadoDeTarea se me cumple, osea, return false.
		assertFalse(kanban.cambiarEstadoDeTarea(kanban.getUsuarios().get(1), idTarea, estados[ran.nextInt(3)]));
		
		//kanban.mostrarTareas();
		System.out.println("**********************************************************");
		
	}

}
