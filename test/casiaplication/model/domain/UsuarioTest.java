package casiaplication.model.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	Usuario user;
	
	@BeforeEach
	void setUp() throws Exception {
		user = new Usuario("Fernando", "Fernando.nando@gmail.com", "pacoca");
	}

	@Test
	void testUsuario() {
		assertEquals("Fernando", user.getNome());
		assertEquals("Fernando.nando@gmail.com", user.getEmail());
		assertEquals("pacoca", user.getSenha());
	}

	@Test
	void testGetNome() {
		user.setNome("Tomas");
		assertEquals("Tomas", user.getNome());
	}

	@Test
	void testGetEmail() {
		user.setEmail("Tomas.toma@gmail.com");
		assertEquals("Tomas.toma@gmail.com", user.getEmail());
		
	}

	@Test
	void testGetSenha() {
		user.setSenha("criatura");
		assertEquals("criatura", user.getSenha());
	}

}
