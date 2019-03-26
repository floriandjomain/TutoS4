/**
 *
 */
package Sujet0;

import java.awt.image.BufferedImage;
import java.awt.*;

import java.awt.event.*;

/**
 * @author Rémi
 *
 */
public class Controleur {
	private IHM ihmgui;
	private DetectionContour metier;
	private ClavierEcoute    evtClavier;

	public Controleur() {
		this.metier = new DetectionContour();
		this.evtClavier = new ClavierEcoute(this);
		this.ihmgui = new IHM(this);
		this.ihmgui.addKeyListener(evtClavier);
	}

	public int getXMoy() {
		return metier.getXMoy();
	}

	public int getYMoy() {
		return metier.getYMoy();
	}

	public void augmenter() {
		int ang = ihmgui.getAng();
		ang += 5;
		ihmgui.setAng(ang);
	}

	public void diminuer() {
		int ang = ihmgui.getAng();
		ang -= 5;
		ihmgui.setAng(ang);
	}

	public void majIHM() {
		ihmgui.majIHM();
	}

	public static void main(String[] args) {
		new Controleur();
	}
}
