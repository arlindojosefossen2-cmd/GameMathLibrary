package br.com.ajf.game.math.library.point2;

import java.util.Objects;

public final class Point2f extends Point2<Float,Float>
{
    public Point2f()
    {
        this(0.0f,0.0f);
    }
    
    public Point2f(float x,float y)
    {
        super(x,y);
    }
    
    public Point2f(Float x, Float y)
    {
        super(x,y);
    }
    
    public Point2f(Point2<Float,Float> p)
    {
        super(p);
    }
    
    public float distanceSquared(IPoint2<Float,Float> p)
    {
        float f = x()-p.x();
        float f2 = y()-p.y();
        return f*f+f2*f2;
    }
    
    public float distance(IPoint2<Float,Float> p)
    {
        return (float) Math.sqrt(distanceSquared(p));
    }
    
    public float distanceL1(IPoint2<Float,Float> p)
    {
        return Math.abs(x()-p.x())+Math.abs(y()-p.y());
    }
    
    public float distanceLinF(IPoint2<Float,Float> p)
    {
        return Math.max(Math.abs(x()-p.x()),Math.abs(y()-p.y()));
    }
    
    @Override
    public void set(Float x, Float y)
    {
        setX(x);
        setY(y);
    }
    
    @Override
    public void set(IPoint2<Float, Float> p)
    {
        set(p.x(),p.y());
    }
    
    @Override
    public void clampMin(Float n)
    {
        if(x() < n)
        {
            setX(n);
        }
        
        if(y() < n)
        {
            setY(n);
        }
    }
    
    @Override
    public void clampMax(Float n)
    {
        if(x() > n)
        {
            setX(n);
        }
        
        if(y() > n)
        {
            setY(n);
        }
    }
    
    @Override
    public void clamp(Float n1, Float n2)
    {
        if(this.x() > n2)
        {
            setX(n2);
        }
        else if(x() < n1)
        {
            setX(n1);
        }
        
        if(y() > n2)
        {
            setY(n2);
        }
        else if(y() < n1)
        {
            setY(n1);
        }
    }
    
    @Override
    public void clamp(Float n1, Float n2, IPoint2<Float, Float> p)
    {
        setX(p.x() > n2 ? n2 : (p.x() < n1) ? n1 : p.x());
        setY(p.y() > n2 ? n2 : (p.y() < n1) ? n1 : p.y());
    }
    
    @Override
    public void clampMin(Float n, IPoint2<Float, Float> p)
    {
        setX(p.x() < n ? n : p.x());
        setY(p.y() < n ? n : p.y());
    }
    
    @Override
    public void clampMax(Float n, IPoint2<Float, Float> p)
    {
        setX(p.x() > n ? n : p.x());
        setY(p.y() > n ? n : p.y());
    }
    
    @Override
    public void absolute(IPoint2<Float, Float> p)
    {
        set(Math.abs(p.x()),Math.abs(p.y()));
    }
    
    @Override
    public void absolute()
    {
        set(Math.abs(x()),Math.abs(y()));
    }
    
    @Override
    public void negate()
    {
        setX(-x());
        setY(-y());
    }
    
    @Override
    public void negate(IPoint2<Float, Float> p)
    {
        setX(-p.x());
        setY(-p.y());
    }
    
    @Override
    public void add(IPoint2<Float, Float> p)
    {
        setX(x()+p.x());
        setY(y()+p.y());
    }
    
    @Override
    public void add(IPoint2<Float, Float> p1, IPoint2<Float, Float> p2)
    {
        set(p1.x()+p2.x(),p1.y()+p2.y());
    }
    
    @Override
    public void add(Float x, Float y)
    {
        set(x+x(),y+y());
    }
    
    @Override
    public void sub(IPoint2<Float, Float> p)
    {
        setX(x()-p.x());
        setY(y()-p.y());
    }
    
    @Override
    public void sub(IPoint2<Float, Float> p1, IPoint2<Float, Float> p2)
    {
        set(p1.x()-p2.x(),p1.y()-p2.y());
    }
    
    @Override
    public void sub(Float x, Float y)
    {
        set(x-x(),y-y());
    }
    
    @Override
    public void multiply(IPoint2<Float, Float> p)
    {
        setX(x()*p.x());
        setY(y()*p.y());
    }
    
    public void interpolate(IPoint2<Float,Float> p,Float n)
    {
        setX((1.0f-n)*x()+n*p.x());
        setY((1.0f-n)*y()+n*p.y());
    }
    
    public void interpolate(IPoint2<Float,Float> p1,IPoint2<Float,Float> p2,Float n)
    {
        setX((1.0f-n)*p1.x()+n*p2.x());
        setY((1.0f-n)*p1.y()+n*p2.y());
    }
    
    public boolean epsilonEquals(IPoint2<Float,Float> p,Float f)
    {
        float f2 = x()-p.x();
        
        if(Float.isNaN(f2))
        {
            return false;
        }
        
        float f3 = f2 < 0.0f ? -f2 : f2;
        if(f3 > f)
        {
            return false;
        }
        
        f2 = y()-p.y();
        
        if(Float.isNaN(f2))
        {
            return false;
        }
        
        float f4 = f2 < 0.0f ? -f2 : f2;
        return !(f4 > f);
    }
    
    @Override
    public void divide(IPoint2<Float, Float> p)
    {
        if(p.x() == 0.0 || p.y() == 0.0)
        {
            return;
        }
        
        setX(x()/p.x());
        setY(y()/p.y());
    }
    
    @Override
    public void scale(Float n)
    {
        set(x()*n,y()*n);
    }
    
    @Override
    public void scale(IPoint2<Float, Float> p, Float n)
    {
        set(p.x()*n,y()*n);
    }
    
    @Override
    public void scaleAndAdd(IPoint2<Float, Float> p, Float n)
    {
        set(n*x()+p.x(),n*y()+p.y());
    }
    
    @Override
    public void scaleAndAdd(IPoint2<Float, Float> p1, IPoint2<Float, Float> p2, Float n)
    {
        set(n*p1.x()+ p2.x(),n*p1.y()+p2.y());
    }
    
    @Override
    public boolean equals(IPoint2<Float, Float> p)
    {
        return Objects.equals(x(), p.x()) && Objects.equals(y(), p.y());
    }
}