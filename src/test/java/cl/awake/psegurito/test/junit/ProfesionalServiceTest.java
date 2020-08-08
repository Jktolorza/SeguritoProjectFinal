package cl.awake.psegurito.test.junit;


import static org.junit.Assert.*;

import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cl.awake.psegurito.model.Profesional;
import cl.awake.psegurito.model.Usuario;
import cl.awake.psegurito.services.ProfesionalService;
import cl.awake.psegurito.services.UsuarioService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:root-context.xml")
@Transactional
//@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Forzar a hacer las pruebas unitarias en orden según el nombre de los test
public class ProfesionalServiceTest {

	@Autowired
	private ProfesionalService profesionalService;
	
	@Autowired
	private UsuarioService usuarioService;
	
//	@Mock
//	private ProfesionalServiceImpl profesionalServiceImpl;
	
//	@Before
//	public void setUp() throws Exception {
//	}
	
	/**
	 * Cantidad de profesionales en la lista, en el inicio de esta lista tenemos 7 profesionales creados
	 */
	@Test
	public void TestProfesionalGetAll() {
		List<Profesional> listaProfesionales = profesionalService.getAll();
		int cantidad = 7;
		assertEquals(cantidad, listaProfesionales.size());
	}
	
	@Test
	public void TestProfesionalGetById() {
		Profesional profesional = profesionalService.getById(1);
		String nombre = "Jose";
		assertEquals(nombre, profesional.getNombre());
	}
	
	@Test
	public void TestProfesionalAdd() {
		Usuario usuario = usuarioService.getByNickname("profesional");
		Profesional profesional = new Profesional("manuel", "lillo", "mlillo@mlillo", "111111", "profesional", usuario);
		profesionalService.add(profesional);
		List<Profesional> listaProfesionales = profesionalService.getAll();
		int cantidad = 8;
		assertEquals(cantidad, listaProfesionales.size());

	}
	
	@Test
	public void TestProfesionalEdit() {
		Profesional profesional = profesionalService.getById(1);
		profesional.setCargo("limpiabotas");
		profesionalService.edit(profesional);
		String cargo = "limpiabotas";
		assertEquals(cargo, profesional.getCargo());

	}
	
	@Test(expected=DataIntegrityViolationException.class)
	public void TestProfesionalDelete() {
		//dado que todos los profesionales tienen campos hijos asociados esta prueba da error de integridad controlada con @Test(expected=DataIntegrityViolationException.class)
		Profesional profesional = profesionalService.getById(7);
		profesionalService.delete(profesional.getId_profesional());
		List<Profesional> listaProfesionales = profesionalService.getAll();
		int cantidad = 7;
		assertEquals(cantidad, listaProfesionales.size());

	}
	
}
