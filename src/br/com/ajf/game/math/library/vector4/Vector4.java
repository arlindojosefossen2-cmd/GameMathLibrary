package br.com.ajf.game.math.library.vector4;

import br.com.ajf.game.math.library.point4.IPoint4;

import java.util.Objects;

public abstract class Vector4<X,Y,Z,W> implements IVector4<X,Y,Z,W>
{
    private X x;
    private Y y;
    private Z z;
    private W w;
    
    public Vector4()
    {
    }
    
    public Vector4(X x, Y y, Z z, W w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
    public Vector4(IPoint4<X,Y,Z,W> p)
    {
        this.x = p.x();
        this.y = p.y();
        this.z = p.z();
        this.w = p.w();
    }
    
    @Override
    public boolean equals(IPoint4<X, Y, Z, W> p)
    {
        return x() == p.x() && y() == p.y() && z() == p.z() && w() == p.w();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof IPoint4<?, ?, ?, ?> point4))
            return false;
        return Objects.equals(x, point4.x()) && Objects.equals(y, point4.y()) && Objects.equals(z, point4.z()) && Objects.equals(w, point4.w());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(x, y, z, w);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public IPoint4<X, Y, Z, W> clone()
    {
        try
        {
            return (IPoint4<X,Y,Z,W>) super.clone();
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