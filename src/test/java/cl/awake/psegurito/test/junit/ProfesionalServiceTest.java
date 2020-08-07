package cl.awake.psegurito.test.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.services.ProfesionalService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:root-context.xml")
//@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Forzar a hacer las pruebas unitarias en orden según el nombre de los test
public class ProfesionalServiceTest {

	@Autowired
	private ProfesionalService profesionalService;
	
//	@Before
//	public void setUp() throws Exception {
//	}
	
	/**
	 * Cantidad de profesionales en la lista, en el inicio de esta lista tenemos 7 profesionales creados
	 */
	@Test
	public void TestListar() {
		List<Profesional> listaProfesionales = profesionalService.getAll();
		int cantidad = 7;
		assertEquals(cantidad, listaProfesionales.size());
	}


}
