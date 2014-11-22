package Model;

import java.util.List;
import java.util.Observable;

import javax.swing.table.DefaultTableModel;

public class Model extends Observable {

	DefaultTableModel model;
	List<Element> elements;
	int nbElements;

	public Model(List<Element> elements) {
		this.elements = elements;
		this.nbElements = elements.size();
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public List<Element> getElements() {
		return elements;
	}

	public int getNbElements() {
		return nbElements;
	}

	public int getTotal() {
		int result = 0;
		for (int i = 0; i < nbElements; i++) {
			result += elements.get(i).getValue();
		}
		return result;
	}

	public float getPourcentage(int pos) { 
		return ((float) elements.get(pos).getValue() / (float) getTotal()) * 100;
	}

}
