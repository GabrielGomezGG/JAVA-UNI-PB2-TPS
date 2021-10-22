package callCenter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class TestCallcenter {

Callcenter callcenter = new Callcenter("Oeste Cable Color");
	
	String[] nombres = new String[]{"Matias", "Lorenzo","Jorge","Luis","Fede"};
	String[] apellidos = new String[]{"Lopez","Perez","Diaz","Gomez", "Dominges"};
	String[] numerosCelular = new String[]{"+5412332112", "+5443232311","+5432112332","+5465445665","+5487667867",};
	String[] emails = new String[]{"Matias", "Lorenzo","Jorge","Luis","Fede"};
	String[] direcciones = new String[]{"Calle falsa", "Puerredon","Manaos","Tutui","Poleo"};
	Integer[] codigosPostales =  new Integer[]{1234, 9324,7554,5433,1321};
	String[] localidades =  new String[]{"La Matanza", "Quilmes","Capital","3 De Febrero","Monte Negro"};
	Provincias[] provincias =  new Provincias[]{Provincias.BUENOS_AIRES, Provincias.CORDOBA,Provincias.MISICIONES,Provincias.SANTIAGO_DEL_ESTERO, Provincias.CHUBUT};
	
	//numero aleatorio para elegir los datos de los arrays "aleatoriamente".
	Random ran = new Random();
	
	
	
	@Test
	void queSePuedaCargarUnContactoExitosamente() {
		callcenter.setContacto(new Contacto("titi","EAD","1133306569","emal","catan",1233,"mata",Provincias.BUENOS_AIRES));
		assertEquals(1, callcenter.getContactos().size());
	}
	
	@Test
	void queExistanContactosQueCumplanLosRequisitos() {
		
		ran.setSeed(1);
		
		callcenter.setContacto(new Contacto(nombres[ran.nextInt(5)],apellidos[ran.nextInt(5)],numerosCelular[ran.nextInt(5)],emails[ran.nextInt(5)],direcciones[ran.nextInt(5)],codigosPostales[ran.nextInt(5)],localidades[ran.nextInt(5)],provincias[ran.nextInt(5)],false,true));
		
		assertTrue(callcenter.buscarAlCandidato());
	}
	
	@Test
	void queExistan10ContactosQueNoCumplanLosRequisitos() {
		
		ran.setSeed(2);
		
		for(int i = 0; i < 10; i++) {
			callcenter.setContacto(new Contacto(nombres[ran.nextInt(5)],apellidos[ran.nextInt(5)],numerosCelular[ran.nextInt(5)],emails[ran.nextInt(5)],direcciones[ran.nextInt(5)],codigosPostales[ran.nextInt(5)],localidades[ran.nextInt(5)],provincias[ran.nextInt(5)],true,true));
		}
		
		//si se ingresaron 10 contactos correctamente
		assertEquals(10, callcenter.getContactos().size());
		//si estos contactos no cumplen las condiciones
		assertFalse(callcenter.buscarAlCandidato());
	}
	
	//PD: Este test es aleatorio 
	@Test
	void queExistan10ContactosQueNoCumplanLosRequisitosPeroPuedeQueQuieraSerLlamadoDeNuevo() {
		
		ran.setSeed(3);
		
		for(int i = 0; i < 10; i++) {
			callcenter.setContacto(new Contacto(nombres[ran.nextInt(5)],apellidos[ran.nextInt(5)],numerosCelular[ran.nextInt(5)],emails[ran.nextInt(5)],direcciones[ran.nextInt(5)],codigosPostales[ran.nextInt(5)],localidades[ran.nextInt(5)],provincias[ran.nextInt(5)],false,false));
		}
		
		callcenter.buscarAlCandidato();
		callcenter.buscarAlCandidato();
		callcenter.buscarAlCandidato();
		callcenter.buscarAlCandidato();
		callcenter.buscarAlCandidato();
		
		assertTrue(callcenter.buscarAlCandidato());
	}
	
	//PD: otro test aleatorio. 
	@Test
	void queLaLlamadaSeaExitosaYCargeAlContactoEnLaListaDeClientes() {
		
		ran.setSeed(4);
		
		//Es Aleatorio si cumplen las condiciones o no
		for(int i = 0; i < 10; i++) {
			callcenter.setContacto(new Contacto(nombres[ran.nextInt(5)],apellidos[ran.nextInt(5)],numerosCelular[ran.nextInt(5)],emails[ran.nextInt(5)],direcciones[ran.nextInt(5)],codigosPostales[ran.nextInt(5)],localidades[ran.nextInt(5)],provincias[ran.nextInt(5)],false,true));
		}
		
		
		
		assertTrue(callcenter.realizarNuevaLlamada());
		assertFalse(callcenter.getClientes().isEmpty());
	}

}
