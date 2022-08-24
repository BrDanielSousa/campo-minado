package student.project.campominado.visao;

import java.util.Scanner;

import student.project.campominado.excecao.ExplosaoException;
import student.project.campominado.excecao.SairException;
import student.project.campominado.modelo.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);

	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			
			while (continuar) {
				cicloDoJogo();
				
				System.out.println("Outra partidar? (S/n) ");
				String resposta = entrada.nextLine();
				
				if ("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reniciar();
				}
			}
			
		} catch (SairException e) {
			System.out.println("Tchau!!!");
		}finally {
			entrada.close();
		}
		
	}

	private void cicloDoJogo() {
		try {
			
			while (!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado = capturaValorDigitado("Digite (x, y): ");
				
				String[] dados = digitado.split(",");
				int x = Integer.parseInt(dados[0]);
				int y = Integer.parseInt(dados[1]);
				
				digitado = capturaValorDigitado("1_abrir ou 2_(des)marcar");
				
				if ("1".equals(digitado)) {
					tabuleiro.abrir(x, y);
				} else if ("2".equals(digitado)){
					tabuleiro.alternarmMarcacao(x, y);
				}
			}
			
			System.out.println("Voce ganhou!!!");
		} catch (ExplosaoException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private String capturaValorDigitado(String texto) {
		System.out.println(texto);
		String digitado = entrada.nextLine();
		
		if ("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		} 
		
		return digitado;
	}
}
