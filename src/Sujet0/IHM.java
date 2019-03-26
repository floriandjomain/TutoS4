/**
 * 
 */
package Sujet0;

import javax.swing.JFrame;

/**
 * @author Rémi
 *
 */
public class IHM extends JFrame {
	private Controleur   ctrl;
	private PanelMetier panel;
	
	public IHM(Controleur ctrl) {
		this.ctrl = ctrl;
		initComposants();
	}
	
	public void initComposants() {
		setTitle("Sujet 0");
		setLocation(500,250);
		setSize(750, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new PanelMetier(ctrl);
		add(this.panel);
		
		setVisible(true);
	}
	
	public void setAng(int a) {
		panel.setAng(a);
	}
	
	public int getAng() {
		return panel.getAng();
	}
	
	public void majIHM() {
		panel.majIHM();
	}
	
}
