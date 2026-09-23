package br.com.ajf.game.math.library.point2f;

import java.io.Serializable;
import java.util.Objects;

public final class Point2f implements Serializable , Cloneable
{
    private float x;
    private float y;
    
    public Point2f()
    {
        this(0,0);
    }
    
    public Point2f(Point2f p)
    {
        this(p.x,p.y);
    }
    
    public Point2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Point2f(float[] point2dArray)
    {
        this(0,0);
        
        if(point2dArray.length != 2)
        {
            return;
        }
        
        this.x = point2dArray[0];
        this.y = point2dArray[1];
    }
    
    public Point2f set(Point2f p)
    {
       return setX(p.x).setY(p.y);
    }
    
    public Point2f set(float x, float y)
    {
       return setX(x).setY(y);
    }
    
    public Point2f set(float[] point2dArray)
    {
       return setY(point2dArray[0]).setY(point2dArray[1]);
    }
    
    public float[] get()
    {
        return new float[]{x,y};
    }
    
    public Point2f get(float[] array)
    {
        array[0] = x;
        array[1] = y;
        return this;
    }
    
    public float X()
    {
        return x;
    }
    
    public Point2f setX(float x)
    {
        this.x = x;
        return this;
    }
    
    public float Y()
    {
        return y;
    }
    
    public Point2f setY(float y)
    {
        this.y = y;
        return this;
    }
    
    @Override
    public Point2f clone()
    {
        try
        {
            return (Point2f) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        }
    }
    
    public boolean equals(Point2f p)
    {
        return this.x == p.x && this.y == p.y;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Point2f))
            return false;
        Point2f point2f = (Point2f) o;
        return Float.compare(x, point2f.x) == 0 && Float.compare(y, point2f.y) == 0;
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }
    
    @Override
    public String toString()
    {
        return "Point2f( x = "+x+" , y = "+y+" )";
    }
}