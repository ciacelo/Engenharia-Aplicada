package casiaplication.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnderecoTest {
	Endereco end;
	
	@BeforeEach
	void setUp() throws Exception {
		 end = new Endereco("Rua martins da vila", "616", "Rio Tinto", "Paraiba");
	}

	@Test
	void testEndereco() {
		assertEquals("Rua martins da vila", end.getLogradouro());
		assertEquals("616", end.getNumero());
		assertEquals("Rio Tinto", end.getCidade());
		assertEquals("Paraiba", end.getEstado());
		
	}

	@Test
	void testGetLogradouro() {
		end.setLogradouro("Rio do norte");
		assertEquals("Rio do norte", end.getLogradouro());
	}

	@Test
	void testGetNumero() {
		end.setNumero("161");
		assertEquals("161", end.getNumero());
	}

	@Test
	void testGetCidade() {
		end.setCidade("Jurucutu");
		assertEquals("Jurucutu", end.getCidade());
	}

	@Test
	void testGetEstado() {
		end.setEstado("RN");
		assertEquals("RN", end.getEstado());
	}

}
