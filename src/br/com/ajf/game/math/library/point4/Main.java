package br.com.ajf.game.math.library.point4;

public class Main
{
    public static void main(String[] args)
    {
        Point4<?,?,?,?> pi = new Point4i();
        
        System.out.println(pi);
        
        pi = new Point4f(2.340f,0.67f,57.08f,456f);
        
        System.out.println(pi);
        
        pi = new Point4d(Double.valueOf(37749949.494949),Double.valueOf(Math.PI / 6),Double.valueOf(57.34887),Double.valueOf(0098.9));
        
        System.out.println(pi);
        
    }
}