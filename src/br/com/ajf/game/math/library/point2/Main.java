package br.com.ajf.game.math.library.point2;

public class Main
{
    public static void main(String[] args)
    {
        Point2<?,?> pi = new Point2i(2,0);
        
        System.out.println(pi);
        
        IPoint2<Float,Float> pf = new Point2f(6.0f,0.34f);
        pf.clamp(1.2f,4.5f);
        System.out.println(pf);
        
        pi = new Point2d(Double.valueOf(37749949.494949),Double.valueOf(Math.PI/6));
        
        System.out.println(pi);
    }
}