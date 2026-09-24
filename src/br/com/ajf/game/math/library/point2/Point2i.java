package br.com.ajf.game.math.library.point2;

public final class Point2i extends Point2<Integer,Integer>
{
    public Point2i()
    {
        this(0,0);
    }
    
    public Point2i(int x,int y)
    {
        this.setX(x);
        this.setY(y);
    }
    
    public Point2i(Integer x, Integer y)
    {
        super(x, y);
    }
    
    public Point2i(Point2<Integer, Integer> p)
    {
        super(p);
    }
}