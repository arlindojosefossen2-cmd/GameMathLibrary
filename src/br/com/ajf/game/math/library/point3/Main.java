package br.com.ajf.game.math.library.point3;


public class Main
{
    public static void main(String[] args)
    {
        Point3<?,?,?> pi = new Point3i(2,0,34);
        
        System.out.println(pi);
        
        pi = new Point3f(2.340f,0.67f,57.08f);
        
        System.out.println(pi);
        
        pi = new Point3d(Double.valueOf(37749949.494949),Double.valueOf(Math.PI / 6),Double.valueOf(57.34887));
        
        System.out.println(pi);
        
    }
}