package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import Model.Data;
import Model.Element;
import Model.Model;

/**
 * The Class Fenetre.
 */
public class Fenetre extends JFrame {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6521378809519608384L;
	
	/** The title. */
	private JLabel title = new JLabel();
	
	/** The view. */
	private View view;
	
	/** The model. */
	final Model model;

	/**
	 * Instantiates a new fenetre.
	 */
	public Fenetre() {
		this.setTitle("mon stock");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Dessine le graphe représentant le stock
		List<Element> elements = new ArrayList<Element>();
		elements.add(new Element("livre", 40));
		elements.add(new Element("banane", 10));
		elements.add(new Element("chocolat", 50));
		elements.add(new Element("soda", 70));
		
		title.setText(" ");
		this.getContentPane().add(title, BorderLayout.SOUTH);
		model = new Model(elements);

		view = new View();
		view.setModel(model);

		this.getContentPane().add(view);

		DefaultTableModel m = new DefaultTableModel();

		final Data table = new Data(m, model);

		table.setModel(m);

		this.getContentPane().add(new JScrollPane(table), BorderLayout.EAST);
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public View getView() {
		return view;
	}
	
	
	/**
	 * Handle mouse click.
	 *
	 * @param p the p
	 */
	public void handleMouseClick(Point2D p) {
		int index = view.getArcPointClicked(p);
		if (index != -1) {
			title.setText("produit : " + model.getElements().get(index).getName()
					+ " - " + " nombre en stock : " + model.getElements().get(index).getValue());
			revalidate();
		}
	}


}
