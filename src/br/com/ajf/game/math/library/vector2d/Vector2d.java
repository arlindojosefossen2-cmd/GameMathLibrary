package br.com.ajf.game.math.library.vector2d;

import br.com.ajf.game.math.library.point2d.Point2d;

import java.io.Serializable;
import java.util.Objects;

public final class Vector2d implements Serializable  , Cloneable
{
    private Point2d point2d;
    
    public Vector2d()
    {
        this(0,0);
    }
    
    public Vector2d(Point2d p)
    {
        this.point2d = p;
    }
    
    public Vector2d(Vector2d v)
    {
        this(v.point2d);
    }
    
    public Vector2d(double x, double y)
    {
        this.point2d = new Point2d(x,y);
    }
    
    public Vector2d(double[] point2dArray)
    {
        this.point2d = new Point2d((point2dArray));
    }
    
    public Vector2d set(double x, double y)
    {
        point2d.set(x,y);
        return this;
    }
    
    public Vector2d set(double[] arrayPoint)
    {
        this.point2d.set(arrayPoint);
        return this;
    }
    
    public double getX()
    {
        return point2d.X();
    }
    
    public double getY()
    {
        return point2d.Y();
    }
    
    public Vector2d setX(double x)
    {
        point2d.setX(x);
        return this;
    }
    
    public Vector2d setY(double y)
    {
        point2d.setY(y);
        return this;
    }
    
    public Vector2d getVector2f()
    {
        return new Vector2d(point2d);
    }
    
    public Point2d getPoint2d()
    {
        return point2d;
    }
    
    public void set(Vector2d v)
    {
        this.point2d = v.point2d;
    }
    
    public void set(Point2d point2f)
    {
        this.point2d = point2f;
    }
    
    @Override
    public Vector2d clone() throws CloneNotSupportedException
    {
        try
        {
            return (Vector2d) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        }
    }
    
    public boolean equals(Vector2d v)
    {
        return v.point2d.equals(this.point2d);
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Vector2d))
            return false;
        Vector2d vector2f = (Vector2d) o;
        return Objects.equals(point2d, vector2f.point2d);
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hashCode(point2d);
    }
    
    @Override
    public String toString()
    {
        return "Vector2d( " + point2d.X() + " , " + point2d.Y() + " )";
    }
}