package br.com.ajf.game.math.library.point3;

import java.util.Objects;

public abstract class Point3<X> implements IPoint3<X>
{
    @SuppressWarnings("unchecked")
    private X[] x = (X[]) new Object[3];
    
    public Point3()
    {
    }
    
    public Point3(X x, X y, X z)
    {
        this.x[0] = x;
        this.x[1] = y;
        this.x[2] = z;
    }
    
    public Point3(IPoint3<X> p)
    {
        this(p.x(),p.y(),p.z());
    }
    
    public boolean equals(IPoint3<X> p)
    {
        return p.x() == x() && p.y() == y() && p.z() == z();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof IPoint3<?> point3))
            return false;
        return Objects.equals(x(), point3.x()) && Objects.equals(y(), point3.y()) && Objects.equals(z(), point3.z());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(x(), y(), z());
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public IPoint3<X> clone()
    {
        try
        {
            return (IPoint3<X>) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        }
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        return split[split.length-1]+"( " + "x= " + x[0] + ", y= " + x[1] + ", z= " + x[2] + " )";
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
    
    public X z()
    {
        return x[2];
    }
    
    public void setZ(X z)
    {
        this.x[2] = z;
    }
}