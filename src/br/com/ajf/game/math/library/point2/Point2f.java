package br.com.ajf.game.math.library.point2;

public final class Point2f extends Point2<Float,Float>
{
    public Point2f()
    {
        this(0.0f,0.0f);
    }
    
    public Point2f(float x,float y)
    {
        super(x,y);
    }
    
    public Point2f(Float x, Float y)
    {
        super(x,y);
    }
    
    public Point2f(Point2<Float,Float> p)
    {
        super(p);
    }
    
    @Override
    public void clamp(Float n1, Float n2)
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
    public void negate(Point2<Float, Float> p)
    {
        setX(-p.x());
        setY(-p.y());
    }
    
    @Override
    public void add(Point2<Float, Float> p)
    {
        setX(x()+p.x());
        setY(y()+p.y());
    }
    
    @Override
    public void sub(Point2<Float, Float> p)
    {
        setX(x()-p.x());
        setY(y()-p.y());
    }
    
    @Override
    public void multiply(Point2<Float, Float> p)
    {
        setX(x()*p.x());
        setY(y()*p.y());
    }
    
    @Override
    public void divide(Point2<Float, Float> p)
    {
        if(p.x() == 0.0 || p.y() == 0.0)
        {
            return;
        }
        
        setX(x()/p.x());
        setY(y()/p.y());
    }
}