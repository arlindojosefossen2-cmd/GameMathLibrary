package br.com.ajf.game.math.library.point2d;

import java.io.Serializable;
import java.util.Objects;

public final class Point2d implements Serializable , Cloneable
{
    private double x;
    private double y;
    
    public Point2d()
    {
        this(0,0);
    }
    
    public Point2d(Point2d p)
    {
        this(p.x,p.y);
    }
    
    public Point2d(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Point2d(double[] point2dArray)
    {
        this(0,0);
        
        if(point2dArray.length != 2)
        {
            return;
        }
        
        this.x = point2dArray[0];
        this.y = point2dArray[1];
    }
    
    public Point2d set(Point2d p)
    {
       return setX(p.x).setY(p.y);
    }
    
    public Point2d set(double x, double y)
    {
       return setX(x).setY(y);
    }
    
    public Point2d set(double[] point2dArray)
    {
       return setY(point2dArray[0]).setY(point2dArray[1]);
    }
    
    public double[] get()
    {
        return new double[]{x,y};
    }
    
    public Point2d get(double[] array)
    {
        array[0] = x;
        array[1] = y;
        return this;
    }
    
    public double X()
    {
        return x;
    }
    
    public Point2d setX(double x)
    {
        this.x = x;
        return this;
    }
    
    public double Y()
    {
        return y;
    }
    
    public Point2d setY(double y)
    {
        this.y = y;
        return this;
    }
    
    @Override
    public Point2d clone()
    {
        try
        {
            return (Point2d) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        }
    }
    
    public boolean equals(Point2d p)
    {
        return this.x == p.x && this.y == p.y;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Point2d))
            return false;
        Point2d point2f = (Point2d) o;
        return Double.compare(x, point2f.x) == 0 && Double.compare(y, point2f.y) == 0;
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }
    
    @Override
    public String toString()
    {
        return "Point2f("+x+","+y+")";
    }
}