package br.com.ajf.game.math.library.axisangle4;

import br.com.ajf.game.math.library.matrix3.Matrix3d;
import br.com.ajf.game.math.library.matrix3.Matrix3f;
import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.quat4.Quat4d;
import br.com.ajf.game.math.library.quat4.Quat4f;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;


public abstract class AxisAngle4<X> implements Serializable,Cloneable
{
    @SuppressWarnings("unchecked")
    private X[] data = (X[])new Object[4];
    
    public AxisAngle4()
    {
    
    }
    
    public AxisAngle4(X x,X y,X z,X angle)
    {
        this.data[0] = x;
        this.data[1] = y;
        this.data[2] = z;
        this.data[3] = angle;
    }
    
    public AxisAngle4(X[] data)
    {
        this.data = data;
    }
    
    public AxisAngle4(AxisAngle4<X> aa)
    {
        this(aa.data);
    }
    
    public AxisAngle4(IPoint3<X> p, X angle)
    {
        this(p.x(),p.y(),p.z(),angle);
    }
    
    public abstract void set(X x,X y,X z,X angle);
    public abstract void set(X[] array);
    public abstract void set(AxisAngle4<X> aa);
    public abstract void set(IPoint3<X> v,X x);
    public abstract void get(X[] x);
    public abstract void set(Quat4f q);
    public abstract void set(Quat4d q);
    public abstract void set(Matrix3f m);
    public abstract void set(Matrix3d m);
    public abstract boolean epsilonEquals(AxisAngle4<X> aa,X x);
    
    public X x()
    {
        return data[0];
    }
    
    public void setX(X x)
    {
        this.data[0] = x;
    }
    
    public X y()
    {
        return data[1];
    }
    
    public void setY(X x)
    {
        this.data[1] = x;
    }
    
    public X z()
    {
        return data[2];
    }
    
    public void setZ(X x)
    {
        this.data[2] = x;
    }
    
    public X angle()
    {
        return data[3];
    }
    
    public void setAngle(X angle)
    {
        this.data[3] = angle;
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        return split[split.length-1]+"( " + "x= " + data[0] + " ,y= "+data[1]+" ,z= "+data[2]+" ,angle= "+data[3]+" )";
    }
    
    public boolean equals(AxisAngle4<X> o)
    {
        if(o == null)
        {
            return false;
        }
        
        return this.equals(o);
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof AxisAngle4<?> that))
            return false;
        return Objects.deepEquals(data, that.data);
    }
    
    @Override
    public int hashCode()
    {
        return Arrays.hashCode(data);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public AxisAngle4<X> clone()
    {
        try
        {
            return (AxisAngle4<X>) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        }
    }
}