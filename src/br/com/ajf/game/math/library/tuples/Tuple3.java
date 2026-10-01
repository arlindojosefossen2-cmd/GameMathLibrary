package br.com.ajf.game.math.library.tuples;

import java.util.Objects;

public abstract class Tuple3<X> extends Tuple2<X> implements ITuple3<X>
{
    private X z;
    
    public Tuple3()
    {
    
    }
    
    public Tuple3(X x,X y,X z)
    {
        set(x,y,z);
    }
    
    public Tuple3(ITuple3<X> t)
    {
        set(t);
    }
    
    public Tuple3(X[] array)
    {
        set(array);
    }
    
    public void set(X x, X y, X z)
    {
        if(x == null || y == null || z == null)
        {
            return;
        }
        
        setX(x);
        setY(y);
        setZ(z);
    }
    
    @Override
    public void get(X[] array)
    {
        if(array == null || array.length < 3)
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
        if(t == null)
        {
            return;
        }
        
        t.set(this);
    }
    
    @Override
    public void set(X[] array)
    {
        if(array.length < 3)
        {
            return;
        }
        setX(array[0]);
        setY(array[1]);
        setZ(array[2]);
    }
    
    @Override
    public void set(ITuple3<X> t)
    {
        if(t == null)
        {
            return;
        }
        
        setX(t.x());
        setY(t.y());
        setZ(t.z());
    }
    
    @Override
    public boolean equals(ITuple3<X> t)
    {
        if(t == null)
        {
            return false;
        }
        
        if(!super.equals(t))
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
        if (!super.equals(o))
        {
            return false;
        }
        return x() == tuple3.x() || y() == tuple3.y() || z() == tuple3.z();
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), z());
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        return split[split.length-1]+ "( x= " + x() + ", y= "+y()+", z= "+z()+" )";
    }
    
    public ITuple3<X> clone()
    {
        return (ITuple3<X>) super.clone();
    }
    
    @Override
    public X z()
    {
        return z;
    }
    
    @Override
    public void setZ(X z)
    {
        this.z = z;
    }
}