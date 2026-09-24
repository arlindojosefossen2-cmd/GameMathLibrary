package br.com.ajf.game.math.library.point2;

public final class Point2i extends Point2<Integer,Integer>
{
    public Point2i()
    {
        this(0,0);
    }
    
    public Point2i(int x,int y)
    {
       super(x,y);
    }
    
    public Point2i(Integer x, Integer y)
    {
        super(x, y);
    }
    
    public Point2i(Point2<Integer, Integer> p)
    {
        super(p);
    }
    
    @Override
    public void clamp(Integer n1, Integer n2)
    {
        if(this.x() > n2)
        {
            setX(n2);
        }
        else if(x() < n1)
        {
            setX(n1);
        }
        
        if(y() > n2)
        {
            setY(n2);
        }
        else if(y() < n1)
        {
            setY(n1);
        }
    }
    
    @Override
    public void negate()
    {
       setX(-x());
       setY(-y());
    }
    
    @Override
    public void negate(Point2<Integer, Integer> p)
    {
        setX(-p.x());
        setY(-p.y());
    }
    
    @Override
    public void add(Point2<Integer, Integer> p)
    {
        setX(x()+p.x());
        setY(y()+p.y());
    }
    
    @Override
    public void sub(Point2<Integer, Integer> p)
    {
        setX(x()-p.x());
        setY(y()-p.y());
    }
    
    @Override
    public void multiply(Point2<Integer, Integer> p)
    {
        setX(x()*p.x());
        setY(y()*p.y());
    }
    
    @Override
    public void divide(Point2<Integer, Integer> p)
    {
        if(p.x() == 0 || p.y() == 0)
        {
            return;
        }
        
        setX(x()/p.x());
        setY(y()/p.y());
    }
}