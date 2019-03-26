/**
 *
 */
package Sujet1;

import java.awt.image.BufferedImage;

/**
 * @author Rémi
 *
 */
public class Controleur {
	private IHM ihmgui;
	private DetectionContour metier;

	public Controleur() {
		this.metier = new DetectionContour();
		this.ihmgui = new IHM(this);
	}

	public void rotation(BufferedImage bi, char sens) {
		metier.rotation(bi, sens);
		ihmgui.majIHM();
	}

	public int getXMoy() {
		return metier.getXMoy();
	}

	public int getYMoy() {
		return metier.getYMoy();
	}

	public static void main(String[] args) {
		new Controleur();
	}
}
