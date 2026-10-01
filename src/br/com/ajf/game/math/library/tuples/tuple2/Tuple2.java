package br.com.ajf.game.math.library.tuples.tuple2;

import java.util.Objects;

public abstract class Tuple2<X> implements ITuple2<X>
{
    private X x;
    private X y;
    
    public Tuple2()
    {
    }
    
    public Tuple2(X x, X y)
    {
        set(x,y);
    }
    
    public Tuple2(ITuple2<X> t)
    {
        set(t);
    }
    
    public Tuple2(X[] array)
    {
        set(array);
    }
    
    public void set(X x, X y)
    {
        if(x == null || y == null)
        {
            return;
        }
        
        setX(x);
        setY(y);
    }
    
    @Override
    public void set(X[] array)
    {
       setX(array[0]);
       setY(array[1]);
    }
    
    @Override
    public void set(ITuple2<X> t)
    {
        setX(t.x());
        setY(t.y());
    }
    
    @Override
    public void get(X[] array)
    {
        array[0] = x();
        array[1] = y();
    }
    
    @Override
    public void get(ITuple2<X> t)
    {
        t.setX(x());
        t.setY(y());
    }
    
    @Override
    public boolean equals(ITuple2<X> t)
    {
        if(t == null)
        {
            return false;
        }
        
        return x() == t.x() && y() == t.y();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }
        
        if (!(o instanceof Tuple2<?> tuple2))
        {
            return false;
        }
        return x() == tuple2.x() && y() == tuple2.y();
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
        return Objects.hash(x(),y());
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        return split[split.length-1]+ "( x= " + x() + ", y= "+y()+" )";
    }
    
    @Override
    public X x()
    {
        return x;
    }
    
    @Override
    public void setX(X x)
    {
        this.x = x;
    }
    
    @Override
    public X y()
    {
        return y;
    }
    
    @Override
    public void setY(X y)
    {
        this.y = y;
    }
}