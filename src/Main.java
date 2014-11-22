import view.Fenetre;
import Controller.Controller;


public class Main {
	/*
	 * Lance l'application, génère le graphe
	 */
	public static void main(String[] args) {
		Fenetre fenetre = new Fenetre();
		Controller controller = new Controller(fenetre);
		fenetre.setVisible(true);

	}

}
