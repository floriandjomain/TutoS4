/**
 *
 */
package Sujet0;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Rémi
 *
 */

public class ClavierEcoute implements KeyListener {

	Controleur ctrl;
	private static final String KEY_RELEASED = "keyReleased";
	private static final String KEY_PRESSED  = "keyPressed";

	public ClavierEcoute(Controleur c) {
		this.ctrl = c;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		myKeyEvent(e, ClavierEcoute.KEY_PRESSED);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		myKeyEvent(e, ClavierEcoute.KEY_RELEASED);
	}

	private void myKeyEvent(KeyEvent e, String action) {
		int currentKey = e.getKeyCode();
		if(currentKey == KeyEvent.VK_KP_LEFT || currentKey == KeyEvent.VK_LEFT) {
			ctrl.diminuer();
			ctrl.majIHM();
			System.out.println("toto");
		}
		else if (currentKey == KeyEvent.VK_KP_RIGHT || currentKey == KeyEvent.VK_RIGHT) {
			ctrl.augmenter();
			ctrl.majIHM();
			System.out.println("toto");
		}
	}
}
