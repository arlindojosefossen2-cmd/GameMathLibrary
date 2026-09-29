package br.com.ajf.game.math.library.tuples;

import java.util.Arrays;
import java.util.Objects;

public abstract class Tuple3<X> implements ITuple3<X>
{
    @SuppressWarnings("unchecked")
    private final X[] data = (X[]) new Object[3];
    
    public Tuple3()
    {
    
    }
    
    public Tuple3(X r,X g,X b)
    {
        setX(r);
        setY(g);
        setZ(b);
    }
    
    public Tuple3(ITuple3<X> t)
    {
        set(t);
    }
    
    public Tuple3(X[] array)
    {
        set(array);
    }
    
    @Override
    public void get(X[] array)
    {
        if(array.length < 3)
        {
            return;
        }
        
        array[0] = x();
        array[1] = y();
        array[2] = z();
    }
    
    @Override
    public void get(ITuple3<X> t)
    {
        t.set(this);
    }
    
    @Override
    public void set(X[] array)
    {
        if(array.length < 3)
        {
            return;
        }
        
        data[0] = array[0];
        data[1] = array[1];
        data[2] = array[2];
    }
    
    @Override
    public void set(ITuple3<X> t)
    {
        if(t == null)
        {
            return;
        }
        
        data[0] = t.x();
        data[1] = t.y();
        data[2] = t.z();
    }
    
    @Override
    public boolean equals(ITuple3<X> t)
    {
        if(t == null)
        {
            return false;
        }
        
        return t.x() == x() && t.y() == y() && t.z() == z();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }
        
        if (!(o instanceof Tuple3<?> tuple3))
        {
            return false;
        }
        return Objects.deepEquals(data, tuple3.data);
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
        return split[split.length-1]+ "( x= " + data[0] + ", y= "+data[1]+", z= "+data[2]+" )";
    }
    
    @SuppressWarnings("unchecked")
    public ITuple3<X> clone()
    {
        try
        {
            return (ITuple3<X>) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
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
}