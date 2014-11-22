package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Fenetre;

public class Controller {

	public Controller(Fenetre fenetre) {
		fenetre.getView().addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fenetre.handleMouseClick(e.getPoint());
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			
		});
	}
}
