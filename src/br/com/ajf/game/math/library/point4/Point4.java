package br.com.ajf.game.math.library.point4;

import java.io.Serializable;
import java.util.Objects;

public abstract class Point4<X,Y,Z,W> implements Serializable, Cloneable
{
    private X x;
    private Y y;
    private Z z;
    private W w;
    
    public Point4()
    {
    }
    
    public Point4(X x, Y y, Z z, W w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
    public Point4(Point4<X,Y,Z,W> p)
    {
        this.x = p.x;
        this.y = p.y;
        this.z = p.z;
        this.w = p.w;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Point4))
            return false;
        Point4<?, ?, ?, ?> point4 = (Point4<?, ?, ?, ?>) o;
        return Objects.equals(x, point4.x) && Objects.equals(y, point4.y) && Objects.equals(z, point4.z) && Objects.equals(w, point4.w);
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(x, y, z, w);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Point4<X, Y, Z, W> clone()
    {
        try
        {
            return (Point4<X,Y,Z,W>) super.clone();
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
        return split[split.length-1]+"( " + "x= " + x + ", y= " + y + ", z= " + z + ", w= " + w + " )";
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
    
    public Z z()
    {
        return z;
    }
    
    public void setZ(Z z)
    {
        this.z = z;
    }
    
    public W w()
    {
        return w;
    }
    
    public void setW(W w)
    {
        this.w = w;
    }
}