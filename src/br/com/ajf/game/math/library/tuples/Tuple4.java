package br.com.ajf.game.math.library.tuples;

import java.util.Arrays;
import java.util.Objects;

public class Tuple4<X> implements ITuple4<X>
{
    @SuppressWarnings("unchecked")
    private final X[] data = (X[]) new Object[4];
    
    public Tuple4()
    {
    
    }
    
    public Tuple4(X x,X y,X z,X w)
    {
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }
    
    public Tuple4(X[] array)
    {
        set(array);
    }
    
    public Tuple4(ITuple4<X> t)
    {
        set(t);
    }
    
    @Override
    public void get(X[] array)
    {
        array[0] = x();
        array[1] = y();
        array[2] = z();
        array[3] = w();
    }
    
    @Override
    public void get(ITuple4<X> t)
    {
        if (t == null)
        {
            return;
        }
        
        t.set(this);
    }
    
    @Override
    public void set(X[] array)
    {
        if(array == null || array.length < 4)
        {
            return;
        }
        
        setX(array[0]);
        setY(array[1]);
        setZ(array[2]);
        setW(array[3]);
    }
    
    @Override
    public void set(ITuple4<X> t)
    {
        setX(t.x());
        setY(t.y());
        setZ(t.z());
        setW(t.w());
    }
    
    @Override
    public boolean equals(ITuple4<X> t)
    {
        if(t == null)
        {
            return false;
        }
        
        return t.x() == x() && t.y() == y() && t.z() == z() && t.w() == w();
    }
    @Override
    @SuppressWarnings("unchecked")
    public ITuple4<X> clone()
    {
        try
        {
            return (ITuple4<X>) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }
        
        if (!(o instanceof Tuple4<?> tuple4))
            return false;
        return Objects.deepEquals(data, tuple4.data);
    }
    
    @Override
    public int hashCode()
    {
        return Arrays.hashCode(data);
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        return split[split.length-1]+ "( x= " + data[0] + ", y= "+data[1]+", z= "+data[2]+", w= "+data[3]+" )";
    }
    
    @Override
    public X x()
    {
        return data[0];
    }
    
    @Override
    public void setX(X x)
    {
        data[0] = x;
    }
    
    @Override
    public X y()
    {
        return data[1];
    }
    
    @Override
    public void setY(X y)
    {
        data[1] = y;
    }
    
    @Override
    public X z()
    {
        return data[2];
    }
    
    @Override
    public void setZ(X z)
    {
        data[2] = z;
    }
    
    @Override
    public X w()
    {
        return data[3];
    }
    
    @Override
    public void setW(X w)
    {
        data[3] = w;
    }
}