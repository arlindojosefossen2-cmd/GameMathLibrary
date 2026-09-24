package br.com.ajf.game.math.library.point2;

import java.util.Objects;

public abstract class Point2<X,Y> implements IPoint2<X,Y>
{
    private X x;
    private Y y;
    
    public Point2()
    {
    
    }
    
    public Point2(X x, Y y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Point2(IPoint2<X,Y> p)
    {
        this.x = p.x();
        this.y = p.y();
    }
    
    public X x()
    {
        return x;
    }
    
    public void setX(X x)
    {
        this.x = x;
    }
    
    public Y y()
    {
        return y;
    }
    
    public void setY(Y y)
    {
        this.y = y;
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        return split[split.length-1]+"( " + "x= " + x + ", y= " + y + " )";
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Point2<?, ?> pointer))
            return false;
        return Objects.equals(x, pointer.x) && Objects.equals(y, pointer.y);
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public IPoint2<X, Y> clone()
    {
        try
        {
            return (IPoint2<X, Y>) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        }
    }
}