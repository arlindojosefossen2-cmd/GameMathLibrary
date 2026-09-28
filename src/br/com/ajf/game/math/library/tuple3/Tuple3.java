package br.com.ajf.game.math.library.tuple3;

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
        setR(r);
        setG(g);
        setB(b);
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
        
        array[0] = r();
        array[1] = g();
        array[2] = b();
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
        
        data[0] = t.r();
        data[1] = t.g();
        data[2] = t.b();
    }
    
    @Override
    public boolean equals(ITuple3<X> t)
    {
        if(t == null)
        {
            return false;
        }
        
        return t.r() == r() && t.g() == g() && t.b() == b();
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
        return "Tuple3{" + "data=" + Arrays.toString(data) + '}';
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
    public X r()
    {
        return data[0];
    }
    
    @Override
    public void setR(X r)
    {
        data[0] = r;
    }
    
    @Override
    public X g()
    {
        return data[1];
    }
    
    @Override
    public void setG(X g)
    {
        data[1] = g;
    }
    
    @Override
    public X b()
    {
        return data[2];
    }
    
    @Override
    public void setB(X b)
    {
        data[2] = b;
    }
}