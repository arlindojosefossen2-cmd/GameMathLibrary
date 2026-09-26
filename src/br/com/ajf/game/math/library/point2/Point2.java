package br.com.ajf.game.math.library.point2;

import java.util.Objects;

public abstract class Point2<X> implements IPoint2<X>
{
    @SuppressWarnings("unchecked")
    private X[] x = (X[])new Object[2];
    
    public Point2()
    {
    
    }
    
    public Point2(X x, X y)
    {
        this.x[0] = x;
        this.x[1] = y;
    }
    
    public Point2(IPoint2<X> p)
    {
       this(p.x(),p.y());
    }
    
    public X x()
    {
        return x[0];
    }
    
    public void setX(X x)
    {
        this.x[0] = x;
    }
    
    public X y()
    {
        return x[1];
    }
    
    public void setY(X y)
    {
        this.x[1] = y;
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        return split[split.length-1]+"( " + "x= " + x[0] + ", y= " + x[1] + " )";
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Point2<?> pointer))
            return false;
        return Objects.equals(x(), pointer.x()) && Objects.equals(y(), pointer.y());
    }
    
    @Override
    public boolean equals(IPoint2<X> p)
    {
        return Objects.equals(x(), p.x()) && Objects.equals(y(), p.y());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(x(), y());
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public IPoint2<X> clone()
    {
        try
        {
            return (IPoint2<X>) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        }
    }
}