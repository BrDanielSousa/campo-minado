package student.project.campominado.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import student.project.campominado.excecao.ExplosaoException;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	private int minas;
	
	private final List<Campo> campos = new ArrayList<>();

	public Tabuleiro(int linhas, int colunas, int minas) { 
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
		
		 gerarCampos();
		 associarOsVizinhos();
		 sortearMinas();
	}
	
	public void abrir(int linha, int coluna) {
		try {
			campos.parallelStream()
			  .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
			  .findFirst()
			  .ifPresent(c -> c.abrir());
		} catch (ExplosaoException e) {
			campos.forEach(c -> c.setAberto(true));
			throw e;
		}
	}
	
	public void alternarmMarcacao(int linha, int coluna) {
		campos.parallelStream()
			  .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
			  .findFirst()
			  .ifPresent(c -> c.alternarmMarcacao());
	}
	
	private void sortearMinas() {
		for (Campo c1 : campos) {
			for (Campo c2 : campos) {
				c1.adicionarVizinho(c2);
			}
		}
	}

	private void associarOsVizinhos() {
		long minasArmadas = 0;
		Predicate<Campo> minado = c -> c.isMinado();
		do {
			int aleatorio = (int) Math.random() * campos.size();
			campos.get(aleatorio).minar();
			minasArmadas = campos.stream().filter(minado).count();
		} while (minasArmadas > minas);
		
	}

	private void gerarCampos() {
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				campos.add(new Campo(i, j));
			}
		}
	}
	
	public boolean objetivoAlcancado() {
		return campos.stream().allMatch(c -> c.objetivoAlcancado());
	}
	
	public void reniciar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearMinas();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int c = 0;
		
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				sb.append(" ");
				sb.append(campos.get(c));
				sb.append(" ");
				c++;
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
