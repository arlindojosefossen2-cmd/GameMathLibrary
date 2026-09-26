package br.com.ajf.game.math.library.point4;

import java.util.Objects;

public abstract class Point4<X> implements IPoint4<X>
{
    @SuppressWarnings("unchecked")
    private X[] x = (X[]) new Object[4];
    
    public Point4()
    {
    }
    
    public Point4(X x, X y, X z, X w)
    {
        this.x[0] = x;
        this.x[1] = y;
        this.x[2] = z;
        this.x[3] = w;
    }
    
    public Point4(IPoint4<X> p)
    {
       this(p.x(),p.y(),p.z(),p.w());
    }
    
    @Override
    public boolean equals(IPoint4<X> p)
    {
        return x() == p.x() && y() == p.y() && z() == p.z() && w() == p.w();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof IPoint4<?> point4))
            return false;
        return Objects.equals(x(), point4.x()) && Objects.equals(y(), point4.y()) && Objects.equals(z(), point4.z()) && Objects.equals(w(), point4.w());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(x(), y(), z(), w());
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public IPoint4<X> clone()
    {
        try
        {
            return (IPoint4<X>) super.clone();
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
        return split[split.length-1]+"( " + "x= " + x[0] + ", y= " + x[1] + ", z= " + x[2] + ", w= " + x[3] + " )";
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
    
    public X w()
    {
        return x[3];
    }
    
    public void setW(X w)
    {
        this.x[3] = w;
    }
}