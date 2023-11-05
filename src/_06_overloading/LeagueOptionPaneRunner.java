package _06_overloading;

public class LeagueOptionPaneRunner {
	public static void main(String[] args) {
		LeagueOptionPane lop = new LeagueOptionPane();

		lop.showMessageDialog("hello");

		lop.showMessageDialog("hola", "LeagueOptionPane");

		lop.showMessageDialog("bonjour", "cool title", "leagueDark.png");


	}
}
