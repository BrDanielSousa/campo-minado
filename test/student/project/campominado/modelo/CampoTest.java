package student.project.campominado.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import student.project.campominado.excecao.ExplosaoException;

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
	
	@Test
	void testeValorPadraoAtributoMarcacao() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeIsMarcacao() {
		campo.alternarmMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeIsMarcacaoDuasChamadas() {
		campo.alternarmMarcacao();
		campo.alternarmMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirMinado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}
	
	@Test
	void testeAbrirMarcado() {
		campo.alternarmMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirComVizinhos1() {
		Campo campo11 = new Campo(1,1);
		Campo campo22 = new Campo(2,2);
		
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
		
	}
	
	@Test
	void testeAbrirComVizinhos2() {
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,2);
		campo12.minar();
		
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());

	}
}
