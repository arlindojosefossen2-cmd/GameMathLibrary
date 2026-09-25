package br.com.ajf.game.math.library.vector2;

import br.com.ajf.game.math.library.point2.Point2;
import br.com.ajf.game.math.library.point2.Point2f;

import java.lang.invoke.VolatileCallSite;

public final class Vector2f extends Point2f
{
    public Vector2f()
    {
    }
    
    public Vector2f(float x, float y)
    {
        super(x, y);
    }
    
    public Vector2f(Float x, Float y)
    {
        super(x, y);
    }
    
    public Vector2f(Point2<Float, Float> p)
    {
        super(p);
    }
    
    public Vector2f(float[] arrayPoints)
    {
        if(arrayPoints.length < 2)
        {
            return;
        }
        
        set(arrayPoints[0],arrayPoints[1]);
    }
    
    public Vector2f(Vector2f v)
    {
        this(v.x(),v.y());
    }
    
    public float lengthSquared()
    {
        return (x() * x() + y() * y());
    }
    
    public void normalize()
    {
        float f = (float) (1.0/length());
        set(x()*f,y()*f);
    }
    
    public float angle(Vector2f v)
    {
        double d = dot(v)/(length()*v.length());
        
        if(d < -1.0)
        {
            d = -1.0;
        }
        
        if(d > 1.0)
        {
            d = 1.0;
        }
        return (float) Math.acos(d);
    }
    
    public void normalize(Vector2f v)
    {
        float f = (float) (1.0/Math.sqrt(v.x()*v.x()+y()*y()));
        set(v.x()*f,v.y()*f);
    }
    
    public float dot(Vector2f v)
    {
        return this.x()*v.x()+this.y()*v.y();
    }
    
    public float length()
    {
        return (float) Math.sqrt(x() * x() + y() * y());
    }
}