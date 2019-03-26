package Sujet1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class DetectionContour {

	private Color noir;
	private Color blanc;
	private BufferedImage robot; //etape 1
	private int noirRGB;
	private int blancRGB;
	private int xMoy, yMoy;
	private BufferedImage robotMasque, robotContour; //etape 2
	private ArrayList<Point> ensCoord;

	public DetectionContour()
	{
		xMoy = 0;
		yMoy = 0;

		/*Etape 1*/


		ensCoord = new ArrayList<Point>();

		noir    = new Color(0,0,0);
		noirRGB = noir.getRGB();

		blanc    = new Color(255,255,255);
		blancRGB = blanc.getRGB();

		this.creerMasque();

		/*Etape 2*/

		this.creerContour();

		/*Etape 3*/

		this.baryCentre();

		/*Etape 4*/

	}

	public void rotation(BufferedImage bi, char sens) {
		Graphics2D g2d = bi.createGraphics();
		if(sens == '-') {
			g2d.rotate(Math.toRadians(-5), xMoy, yMoy);
		}
		else {
			g2d.rotate(Math.toRadians(5), xMoy, yMoy);
		}

	}

	public void creerMasque() {
		try {
			robot = ImageIO.read(new File ("Images/robot1.png"));
		} catch(Exception e){System.out.println("Image mal lue");}

		int width = robot.getWidth();
		int height = robot.getHeight();


		for( int i = 1; i < width; i++ )
		    for( int j = 1; j < height; j++ ) {
		        int p = robot.getRGB(i,j); // Recuperation du pixel

		        int a = (p>>24) & 0xff; // Permet de trouver les bits correspondant a la couche alpha de l'image
                if(a!=0) {
                	robot.setRGB(i,j, noirRGB);
                	ensCoord.add(new Point(i,j));
                }
		}

		try{
			ImageIO.write(robot, "png", new File("Images/robotMasque.png"));
		}
		catch (Exception e){System.out.println("image mal ecrite");}
	}



	public void creerContour() {
		try {
			robotMasque = ImageIO.read(new File ("Images/robotMasque.png"));
		} catch(Exception e){System.out.println("Image mal lue");}

		int width  = robotMasque.getWidth();
		int height = robotMasque.getHeight();


		for( int i = 1; i < width; i++ )
		    for( int j = 1; j < height; j++ ) {
		    	int p = robotMasque.getRGB(i,j);
		    	int a = (p>>24) & 0xff; // Permet de trouver les bits correspondant a la couche alpha de l'image

		    	if(a != 0) {
		    		if(estContour(i,j))
		    		{
		    			ensCoord.add(new Point(i,j));
		    			robotMasque.setRGB(i, j, noirRGB);
		    			//System.out.println(i + " " + j);
		    		}
		    		else {
		    			robotMasque.setRGB(i, j, blancRGB);
		    		}
		    	}
		    }

		try{
			ImageIO.write(robotMasque, "png", new File("Images/robotContour.png"));
		}
		catch (Exception e){System.out.println("image mal ecrite");}
	}

	public void baryCentre() {
		int x;
		int y;

		try {
			robotContour = ImageIO.read(new File ("Images/robotContour.png"));
		} catch(Exception e){System.out.println("Image mal lue");}

		x = 0;
		y = 0;

		for(Point p : ensCoord) {
			x+= p.getX();
			y+= p.getY();
		}

		xMoy = x/ensCoord.size();
		yMoy = y/ensCoord.size();

		robotContour.setRGB(xMoy, yMoy, Color.RED.getRGB());

		try{
			ImageIO.write(robotContour, "png", new File("Images/BaryCentre.png"));
		}
		catch (Exception e){System.out.println("image mal ecrite");}
	}

	public int getXMoy() {
		return xMoy;
	}

	public int getYMoy() {
		return yMoy;
	}

	private boolean estContour(int x, int y) {
		if(x > 0 && x < robotMasque.getWidth() && y > 0 && y < robotMasque.getHeight()) {
			return robotMasque.getRGB(x - 1, y + 1) ==  0    || robotMasque.getRGB(x, y + 1) == 0 || robotMasque.getRGB(x + 1, y + 1) == 0
					   ||  robotMasque.getRGB(x - 1, y) == 0 || robotMasque.getRGB(x + 1, y) == 0 || robotMasque.getRGB(x - 1, y - 1) == 0
					   ||  robotMasque.getRGB(x, y - 1) == 0 || robotMasque.getRGB(x + 1, y - 1) == 0;
		}
		return false;
	}

}
