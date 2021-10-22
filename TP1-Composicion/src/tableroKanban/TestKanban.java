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
		ran.setSeed(semilla);
		for(int i = 0; i < 10; i++) {
			kanban.setUsuario(new Usuario(nombres[ran.nextInt(5)]));
		}
		
		assertEquals(10,kanban.getUsuarios().size());
	}
	
	@Test
	void queSePuedaAgregarLasTareasAlTablero() {
		
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
	
	//no terminado
	/*
	@Test
	void queUnUsuarioPuedaCambiarDeEstadoUnaTarea() {
		
		ran.setSeed(semilla);
		for(int i = 0; i < 10; i++) {
			kanban.setUsuario(new Usuario(nombres[ran.nextInt(5)]));
			//le asigna una tarea al usuario creado
			kanban.getUsuarios().get(i).setTarea(new Tarea(estados[ran.nextInt(3)], kanban.getUsuarios().get(i).getNombre() ));
		}
		
		kanban.setTareas();
		kanban.mostrarTareas();
		
		System.out.println("**********************************************************");
		
		assertFalse(kanban.getTareas().isEmpty());
	}
	*/

}
