package br.com.ajf.game.math.library.point2;

public class Main
{
    public static void main(String[] args)
    {
        Point2<?,?> pi = new Point2i(2,0);
        
        System.out.println(pi);
        
        pi = new Point2f(2.340f,0.67f);
        
        System.out.println(pi);
        
        pi = new Point2d(Double.valueOf(37749949.494949),Double.valueOf(Math.PI/6));
        
        System.out.println(pi);
        
    }
}