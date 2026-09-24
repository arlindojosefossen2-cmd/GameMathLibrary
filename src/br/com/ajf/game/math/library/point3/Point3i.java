package br.com.ajf.game.math.library.point3;

public class Point3i extends Point3<Integer,Integer,Integer>
{
    public Point3i()
    {
        this(0,0,0);
    }
    
    public Point3i(int x, int y, int z)
    {
       super(x,y,z);
    }
    
    public Point3i(Integer x, Integer y, Integer z)
    {
        super(x, y, z);
    }
    
    public Point3i(Point3<Integer, Integer, Integer> p)
    {
        super(p);
    }
}