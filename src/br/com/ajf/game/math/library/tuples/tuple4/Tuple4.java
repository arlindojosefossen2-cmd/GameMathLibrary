package br.com.ajf.game.math.library.tuples.tuple4;

import br.com.ajf.game.math.library.tuples.tuple3.Tuple3;

import java.util.Objects;

public class Tuple4<X> extends Tuple3<X> implements ITuple4<X>
{
    private X w;
    
    public Tuple4()
    {
    
    }
    
    public Tuple4(X x,X y,X z,X w)
    {
        set(x, y, z, w);
    }
    
    public Tuple4(X[] array)
    {
        set(array);
    }
    
    public Tuple4(ITuple4<X> t)
    {
        set(t);
    }
    
    public void set(X x, X y, X z, X w)
    {
        if(x == null || y == null || z == null || w == null)
        {
            return;
        }
        
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }
    
    @Override
    public void get(X[] array)
    {
        if(array == null || array.length < 4)
        {
            return;
        }
        
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
        if(t == null)
        {
            return;
        }
        
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
        
        if(!super.equals(t))
        {
            return false;
        }
        
        return t.x() == x() && t.y() == y() && t.z() == z() && t.w() == w();
    }
  
    public ITuple4<X> clone()
    {
        return (ITuple4<X>) super.clone();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }
        
        if (!(o instanceof Tuple4<?> tuple4))
        {
            return false;
        }
        
        if(!super.equals(o))
        {
            return false;
        }
        
        return x() == tuple4.x() && y() == tuple4.y() && z() == tuple4.z() && w() == tuple4.w();
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(),w());
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        return split[split.length-1]+ "( x= " + x() + ", y= "+y()+", z= "+z()+", w= "+w()+" )";
    }
    
    @Override
    public X w()
    {
        return w;
    }
    
    @Override
    public void setW(X w)
    {
        this.w = w;
    }
}