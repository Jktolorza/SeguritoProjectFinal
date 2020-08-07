package cl.awake.psegurito.test.junit;


import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cl.awake.psegurito.model.Cliente;
import cl.awake.psegurito.model.Usuario;
import cl.awake.psegurito.services.ClienteService;
import cl.awake.psegurito.services.UsuarioService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:root-context.xml")
@Transactional
//@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Forzar a hacer las pruebas unitarias en orden según el nombre de los test
public class ClienteServiceTest {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
//	@Mock
//	private ProfesionalServiceImpl profesionalServiceImpl;
	
//	@Before
//	public void setUp() throws Exception {
//	}
	
	/**
	 * Cantidad de clientes en la lista, en el inicio de esta lista tenemos 7 clientes creados
	 */
	@Test
	public void TestClienteGetAll() {
		List<Cliente> listaClientes = clienteService.getAll();
		int cantidad = 10;
		assertEquals(cantidad, listaClientes.size());
	}
	
	@Test
	public void TestClienteGetById() {
		Cliente cliente = clienteService.getById(1);
		String nombre = "Transportes S.A";
		assertEquals(nombre, cliente.getNombreEmpresa());
	}
	
	@Test
	public void TestClienteAdd() throws ParseException {
		Usuario usuario = usuarioService.getByNickname("cliente");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date myDate = sdf.parse("2020-07-26");
		Cliente cliente = new Cliente("Colo Colo", "111111-1", myDate, usuario);
		clienteService.add(cliente);
		List<Cliente> listaClientes = clienteService.getAll();
		int cantidad = 11;
		assertEquals(cantidad, listaClientes.size());

	}
	
	@Test
	public void TestClienteEdit() {
		Cliente cliente = clienteService.getById(1);
		cliente.setNombreEmpresa("OwO");
		clienteService.edit(cliente);
		String cargo = "OwO";
		assertEquals(cargo, cliente.getNombreEmpresa());

	}
	
	@Test(expected=DataIntegrityViolationException.class)
	public void TestClienteDelete() {
		//dado que todos los clientes tienen campos hijos asociados esta prueba da error de integridad controlada con @Test(expected=DataIntegrityViolationException.class)
		Cliente cliente = clienteService.getById(1);
		clienteService.delete(cliente.getId_cliente());
		List<Cliente> listaClientes = clienteService.getAll();
		int cantidad = 10;
		assertEquals(cantidad, listaClientes.size());

	}
	
}