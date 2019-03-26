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
	
	public void majIHM() {
		this.panel.majIHM();
	}
	
	public void initComposants() {
		setTitle("Sujet 0");
		setLocation(500,500);
		setSize(750, 750);
		this.panel = new PanelMetier(ctrl);
		add(this.panel);
		
		setVisible(true);
	}
	
}
