package br.com.ajf.game.math.library.vector3;

import br.com.ajf.game.math.library.point3.IPoint3;

import java.util.Objects;

public abstract class Vector3<X,Y,Z> implements IVector3<X,Y,Z>
{
    private X x;
    private Y y;
    private Z z;
    
    public Vector3()
    {
    }
    
    public Vector3(X x, Y y, Z z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector3(IPoint3<X,Y,Z> p)
    {
        this.x = p.x();
        this.y = p.y();
        this.z = p.z();
    }
    
    public boolean equals(IVector3<X,Y,Z> p)
    {
        return p.x() == x() && p.y() == y() && p.z() == z();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof IVector3<?, ?, ?> vec3))
            return false;
        return Objects.equals(x, vec3.x()) && Objects.equals(y, vec3.y()) && Objects.equals(z, vec3.z());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(x, y, z);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public IVector3<X, Y, Z> clone()
    {
        try
        {
            return (IVector3<X, Y, Z>) super.clone();
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
        return split[split.length-1]+"( " + "x= " + x + ", y= " + y + ", z= " + z + " )";
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