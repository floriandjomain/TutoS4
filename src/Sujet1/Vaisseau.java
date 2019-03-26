public class Vaisseau
{
  private final double VITESSE_MIN = 0.0001;
  private final double VITESSE_MAX = 0.100;

  private int   posX;
  private int   posY;
  private int   angleRotation; // en degrés
  private double acceleration;
  private double deceleration;

  private double[] vitesse;
  private Decelerateur dec;

  public Vaisseau(int x, int y)
  {
    this.posX = x;
    this.posY = y;

    this.angleRotation = 0;
    this.acceleration  = 0;;
    this.deceleration  = 0;

    this.majVitesse();
    dec = new Decelerateur();

    dec.start();
  }

  public int getX() { return posX; }
  public int getY() { return posY; }

  public double getAngle() { return Math.toRadians(angleRotation); }

  public void accelerer()
  {
    acceleration+=0.001;
    majVitesse();
  }
  public void arret()
  {
    acceleration = 0;
    majVitesse();
  }

  private synchronized void majVitesse()
  {
    this.vitesse[0]+= this.acceleration * Math.cos(this.getAngle());
    this.vitesse[1]+= this.acceleration * Math.cos(this.getAngle());
  }

  public double getAcceleration() { return acceleration; }

  private class Decelerateur extends Thread
  {
    public Decelerateur()
    {
      
    }
  }
}
