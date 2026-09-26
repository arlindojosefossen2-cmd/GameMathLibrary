package br.com.ajf.game.math.library.vector2;

import br.com.ajf.game.math.library.point2.IPoint2;
import br.com.ajf.game.math.library.point2.Point2f;

public final class Vector2f extends Point2f
{
    public Vector2f()
    {
        this(0f,0f);
    }
    
    public Vector2f(float x, float y)
    {
        super(x, y);
    }
    
    public Vector2f(IPoint2<Float> p)
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
    
    public Float lengthSquared()
    {
        return (x() * x() + y() * y());
    }
    
    public void normalize()
    {
        float f = (float) (1.0/length());
        set(x()*f,y()*f);
    }
    
    public Float angle(Vector2f v)
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
    
    public Float dot(Vector2f v)
    {
        return this.x()*v.x()+this.y()*v.y();
    }
    
    public Float length()
    {
        return (float) Math.sqrt(x() * x() + y() * y());
    }
}