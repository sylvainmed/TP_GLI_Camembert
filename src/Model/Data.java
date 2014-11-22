package Model;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Data extends JTable implements Observer {

	private static final long serialVersionUID = -2198333850389791614L;

	private int nb;
	private Element elements[];
	private Model model;

	public Data() {
		super();
		this.elements = null;
		this.nb = 0;
	}

	/**
	 * Instantiates a new data.
	 *
	 * @param m the m
	 * @param model the model
	 */
	public Data(DefaultTableModel m, Model model) {
		super(m);
		this.model = model;
		m.addColumn("Produits");
		m.addColumn("Nombre");
		for (int i = 0; i < model.getNbElements(); i++) {
			m.addRow(new Object[] { model.getElements().get(i).getName(),
					model.getElements().get(i).getValue() });
		}
	}

	public void setModel(DefaultTableModel m) {
		model.setModel(m);
	}

	public int getNb() {
		return nb;
	}

	public Element[] getElements() {
		return elements;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

}
