package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.JComponent;

import Model.Element;
import Model.Model;

/**
 * The Class View.
 */
public class View extends JComponent implements Observer {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2118299654730994785L;
	
	/** The angle. */
	private float angle = 0;
	
	/** The model. */
	Model model;
	
	/** The list arcs. */
	private List<Arc2D> listArcs;

	/**
	 * Instantiates a new view.
	 */
	public View() {
		listArcs = new ArrayList<Arc2D>();
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		Model model = this.getModel();
		List<Element> elements = model.getElements();
		
		// Calcul la taille des arcs et les ajoute à la view
		for (int i = 0; i < elements.size(); i++) {
			float pourcentage = model.getPourcentage(i) * 3.6f;
			Arc2D.Double arc = new Arc2D.Double(20, 20, 300, 300, angle,
					pourcentage, Arc2D.PIE);

			g2.setColor(new Color(new Random().nextInt()));
			g2.fill(arc);

			angle += pourcentage;
			listArcs.add(arc);
		}
	}

	/**
	 * Gets the arc point clicked.
	 *
	 * @param p the p
	 * @return the arc point clicked
	 */
	public int getArcPointClicked(Point2D p) {
		for (int i = 0; i < listArcs.size(); i++) {
			if (listArcs.get(i).contains(p.getX(), p.getY())) {
				return i;
			}
		}
		return -1;
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

}
