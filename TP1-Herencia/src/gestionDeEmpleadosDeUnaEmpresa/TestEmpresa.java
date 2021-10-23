package gestionDeEmpleadosDeUnaEmpresa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class TestEmpresa {

	@Test
	void quePuedaAgregarUnEmpleadoALaEmpresa() {
		
		Empresa empresa = new Empresa();
		empresa.setEmpleado(new Empleado("Nombre","Apellido",
				20000,new Date(1997,8,1)));
		
		fail("Not yet implemented");
	}

}
