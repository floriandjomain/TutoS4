package Sujet1;

public class Monde
{
  private int   xCentre;
  private int   yCentre;
  private float diametre;

  public Monde()
  {
    this((int)(Math.random()*900+20), (int)(Math.random()*900+20), (float)(Math.random()*500+5));
  }

  public Monde(int xCentre, int yCentre, float diametre)
  {
    this.xCentre  = xCentre;
    this.yCentre  = yCentre;
    this.diametre = diametre;
  }

  public int[] getPosCentre()
  {
    int[] posCentre = new int[2];

    posCentre[0] = xCentre;
    posCentre[1] = yCentre;

    return posCentre;
  }

  public float getDiametre()
  {
    return diametre;
  }
}
