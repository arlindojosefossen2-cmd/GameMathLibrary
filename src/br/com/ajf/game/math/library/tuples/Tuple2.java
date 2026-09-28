package br.com.ajf.game.math.library.tuples;

import java.util.Arrays;
import java.util.Objects;

public abstract class Tuple2<X> implements ITuple2<X>
{
    @SuppressWarnings("unchecked")
    private final X[] data = (X[]) new Object[2];
    
    @Override
    public void set(X x, X y)
    {
        data[0] = x;
        data[1] = y;
    }
    
    @Override
    public void set(X[] array)
    {
        data[0] = array[0];
        data[1] = array[1];
    }
    
    @Override
    public void set(ITuple2<X> t)
    {
        data[0] = t.x();
        data[1] = t.y();
    }
    
    @Override
    public void get(X[] array)
    {
        array[0] = data[0];
        array[1] = data[1];
    }
    
    @Override
    public void get(ITuple2<X> t)
    {
        t.set(data[0],data[1]);
    }
    
    @Override
    public boolean equals(ITuple2<X> t)
    {
        return x() == t.x() && y() == t.y();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Tuple2<?> tuple2))
            return false;
        return Objects.deepEquals(data, tuple2.data);
    }
    
    @SuppressWarnings("unchecked")
    public ITuple2<X> clone()
    {
        try
        {
            return (ITuple2<X>) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public int hashCode()
    {
        return Arrays.hashCode(data);
    }
    
    @Override
    public String toString()
    {
        return "Tuple2{" + "data=" + Arrays.toString(data) + '}';
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
}