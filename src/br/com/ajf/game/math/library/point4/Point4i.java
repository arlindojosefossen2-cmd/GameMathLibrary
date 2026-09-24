package br.com.ajf.game.math.library.point4;

public class Point4i extends Point4<Integer,Integer,Integer,Integer>
{
    public Point4i()
    {
        this(0,0,0,0);
    }
    
    public Point4i(int x, int y, int z, int w)
    {
        super(x,y,z,w);
    }
    
    public Point4i(Integer x, Integer y, Integer z, Integer w)
    {
        super(x, y, z, w);
    }
    
    public Point4i(Point4<Integer, Integer, Integer, Integer> p)
    {
        super(p);
    }
}
