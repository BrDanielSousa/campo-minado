package student.project.campominado.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CampoTest {
	
	Campo campo = new Campo(3,3);
	
	@Test
	void testeVizinhoDistancia1() {
		Campo vizinho = new Campo(3,2);
		boolean result = campo.adicionarVizinho(vizinho);
		assertTrue(result);
	}
	
	@Test
	void testeVizinhoDistancia2() {
		Campo vizinho = new Campo(4,2);
		boolean result = campo.adicionarVizinho(vizinho);
		assertTrue(result);
	}
	
	@Test
	void testeVizinho() {
		Campo vizinho = new Campo(5,2);
		boolean result = campo.adicionarVizinho(vizinho);
		assertFalse(result);
	}
}
