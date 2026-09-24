package br.com.ajf.game.math.library.point3;

import java.io.Serializable;
import java.util.Objects;

public class Point3<X,Y,Z> implements Serializable , Cloneable
{
    private X x;
    private Y y;
    private Z z;
    
    public Point3()
    {
    }
    
    public Point3(X x, Y y, Z z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Point3(Point3<X,Y,Z> p)
    {
        this.x = p.x;
        this.y = p.y;
        this.z = p.z;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Point3))
            return false;
        Point3<?, ?, ?> point3 = (Point3<?, ?, ?>) o;
        return Objects.equals(x, point3.x) && Objects.equals(y, point3.y) && Objects.equals(z, point3.z);
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(x, y, z);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Point3<X, Y, Z> clone()
    {
        try
        {
            return (Point3<X, Y, Z>) super.clone();
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
        return split[split.length-1]+"( " + "x = " + x + " , y = " + y + " , z = " + z + " )";
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
}