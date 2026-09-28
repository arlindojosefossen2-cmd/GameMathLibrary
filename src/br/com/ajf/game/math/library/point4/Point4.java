package br.com.ajf.game.math.library.point4;

import java.util.Objects;

public abstract class Point4<X> implements IPoint4<X>
{
    @SuppressWarnings("unchecked")
    private final X[] data = (X[]) new Object[4];
    
    public Point4()
    {
    }
    
    public Point4(X x, X y, X z, X w)
    {
        this.data[0] = x;
        this.data[1] = y;
        this.data[2] = z;
        this.data[3] = w;
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
        return split[split.length-1] + "( " + "x= " + data[0] + ", y= " + data[1] + ", z= " + data[2] + ", w= " + data[3] + " )";
    }
    
    public X x()
    {
        return data[0];
    }
    
    public void setData(X data)
    {
        this.data[0] = data;
    }
    
    public X y()
    {
        return data[1];
    }
    
    public void setY(X y)
    {
        this.data[1] = y;
    }
    
    public X z()
    {
        return data[2];
    }
    
    public void setZ(X z)
    {
        this.data[2] = z;
    }
    
    public X w()
    {
        return data[3];
    }
    
    public void setW(X w)
    {
        this.data[3] = w;
    }
}