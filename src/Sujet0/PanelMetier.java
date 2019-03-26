/**
 *
 */
package Sujet0;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

/**
 * @author Rémi
 *
 */
public class PanelMetier extends JPanel implements ActionListener {

	private Controleur  ctrl;
	private BufferedImage bi;
	private ImageIcon     img;
	private JLabel        lblImg;

	private JPanel        panelBtn;

	private JButton     btnPl;
	private JButton     btnMi;


	public PanelMetier(Controleur ctrl) {
		this.ctrl = ctrl;
		initComposants();

	}

	@Override
    public void paintComponent(Graphics g){
		try {
			bi = ImageIO.read(new File ("Images/BaryCentre.png"));
		} catch(Exception e){System.out.println("Image mal lue");}

		AffineTransform at = new AffineTransform();

		// 300 a remplacer par positions x du vaisseaux

		at.translate(375-ctrl.getXMoy(), 375-ctrl.getYMoy());
		at.translate(ctrl.getXMoy(), ctrl.getYMoy());
		at.rotate(Math.toRadians(5));
		at.translate(-ctrl.getXMoy(), -ctrl.getYMoy());

		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(bi, at, null);
    }

	public void initComposants() {
		setLayout(new BorderLayout());

		try {
			bi = ImageIO.read(new File ("Images/BaryCentre.png"));
		} catch(Exception e){System.out.println("Image mal lue");}

		this.panelBtn = new JPanel(new GridLayout(2,1));

		this.btnPl = new JButton("+");
		this.btnMi = new JButton("-");

		// Activation des évènements
		this.btnPl.addActionListener   ( this );
		this.btnMi.addActionListener   ( this );


		//Ajout composants
		this.panelBtn.add(btnPl);
		this.panelBtn.add(btnMi);

		add(this.panelBtn, BorderLayout.EAST);
	}

	public void majIHM() {
		this.repaint();
	}

	public void actionPerformed ( ActionEvent e )
	{
		if ( e.getSource() == this.btnPl   ) revalidate();
		if ( e.getSource() == this.btnMi   ) repaint();
	}
}
