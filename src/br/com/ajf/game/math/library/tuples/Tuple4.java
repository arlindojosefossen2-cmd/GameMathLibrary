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
    
    public Tuple4(X r,X g,X b,X a)
    {
        setR(r);
        setG(g);
        setB(b);
        setA(a);
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
        array[0] = r();
        array[1] = g();
        array[2] = b();
        array[3] = a();
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
        
        setR(array[0]);
        setG(array[1]);
        setB(array[2]);
        setA(array[3]);
    }
    
    @Override
    public void set(ITuple4<X> t)
    {
        setR(t.r());
        setG(t.g());
        setB(t.b());
        setA(t.a());
    }
    
    @Override
    public boolean equals(ITuple4<X> t)
    {
        if(t == null)
        {
            return false;
        }
        
        return t.r() == r() && t.g() == g() && t.b() == b() && t.a() == a();
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
        return "Tuple4{" + "data=" + Arrays.toString(data) + '}';
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
    
    @Override
    public X a()
    {
        return data[3];
    }
    
    @Override
    public void setA(X a)
    {
        data[3] = a;
    }
}