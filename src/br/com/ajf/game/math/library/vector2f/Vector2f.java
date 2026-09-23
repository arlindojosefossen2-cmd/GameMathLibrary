package br.com.ajf.game.math.library.vector2f;

import br.com.ajf.game.math.library.point2f.Point2f;

import java.io.Serializable;
import java.util.Objects;

public final class Vector2f implements Serializable , Cloneable
{
    private Point2f point2f;
    
    public Vector2f()
    {
        this(0,0);
    }
    
    public Vector2f(Point2f p)
    {
        this.point2f = p;
    }
    
    public Vector2f(Vector2f v)
    {
        this(v.point2f);
    }
    
    public Vector2f(float x, float y)
    {
        this.point2f = new Point2f(x,y);
    }
    
    public Vector2f(float[] point2dArray)
    {
        this.point2f = new Point2f((point2dArray));
    }
    
    public Vector2f set(float x,float y)
    {
        point2f.set(x,y);
        return this;
    }
    
    public  Vector2f set(float[] arrayPoint)
    {
        this.point2f.set(arrayPoint);
        return this;
    }
    
    public float getX()
    {
        return point2f.X();
    }
    
    public float getY()
    {
        return point2f.Y();
    }
    
    public Vector2f setX(float x)
    {
        point2f.setX(x);
        return this;
    }
    
    public Vector2f setY(float y)
    {
        point2f.setY(y);
        return this;
    }
    
    public Vector2f getVector2f()
    {
        return new Vector2f(point2f);
    }
    
    public Point2f getPoint2f()
    {
        return point2f;
    }
    
    public void set(Vector2f v)
    {
        this.point2f = v.point2f;
    }
    
    public void set(Point2f point2f)
    {
        this.point2f = point2f;
    }
    
    @Override
    public Vector2f clone() throws CloneNotSupportedException
    {
        try
        {
            return (Vector2f) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        }
    }
    
    public boolean equals(Vector2f v)
    {
        return v.point2f.equals(this.point2f);
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Vector2f))
            return false;
        Vector2f vector2f = (Vector2f) o;
        return Objects.equals(point2f, vector2f.point2f);
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hashCode(point2f);
    }
    
    @Override
    public String toString()
    {
        return "Vector2f( "+point2f.X()+" , "+point2f.Y()+" )";
    }
}