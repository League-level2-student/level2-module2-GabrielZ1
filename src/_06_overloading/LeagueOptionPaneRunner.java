package _06_overloading;

import java.awt.Color;

public class LeagueOptionPaneRunner {
	public static void main(String[] args) {
		LeagueOptionPane lop = new LeagueOptionPane();

		//comment out the methods I don't want to run currently
		
		//lop.showMessageDialog("hello");

		//lop.showMessageDialog("hola", "LeagueOptionPane");

		//lop.showMessageDialog("bonjour", "cool title", "leagueDark.png");

		lop.showMessageDialog("greetings", "cooler title", "leagueDark.png", Color.BLUE);

	}
}
