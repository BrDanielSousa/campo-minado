package student.project.campominado.application;

import student.project.campominado.modelo.Tabuleiro;
import student.project.campominado.visao.TabuleiroConsole;

public class Program {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
	}
}
