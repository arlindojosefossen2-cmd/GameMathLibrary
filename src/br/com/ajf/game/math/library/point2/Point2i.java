package br.com.ajf.game.math.library.point2;

import java.util.Objects;

public final class Point2i extends Point2<Integer,Integer>
{
    public Point2i()
    {
        this(0,0);
    }
    
    public Point2i(int x,int y)
    {
       super(x,y);
    }
    
    public Point2i(Integer x, Integer y)
    {
        super(x, y);
    }
    
    public Point2i(Point2<Integer, Integer> p)
    {
        super(p);
    }
    
    @Override
    public void set(Integer x, Integer y)
    {
        setX(x);
        setY(y);
    }
    
    @Override
    public void set(IPoint2<Integer, Integer> p)
    {
        set(p.x(),p.y());
    }
    
    @Override
    public void clampMin(Integer n)
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
    public void clampMax(Integer n)
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
    public void clamp(Integer n1, Integer n2)
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
    public void clamp(Integer n1, Integer n2, IPoint2<Integer, Integer> p)
    {
        setX(p.x() > n2 ? n2 : (p.x() < n1) ? n1 : p.x());
        setY(p.y() > n2 ? n2 : (p.y() < n1) ? n1 : p.y());
    }
    
    @Override
    public void clampMin(Integer n1, IPoint2<Integer, Integer> p)
    {
        setX((p.x() < n1) ? n1 : p.x());
        setY((p.y() < n1) ? n1 : p.y());
    }
    
    @Override
    public void clampMax(Integer n1, IPoint2<Integer, Integer> p)
    {
        setX((p.x() > n1) ? n1 : p.x());
        setY((p.y() > n1) ? n1 : p.y());
    }
    
    @Override
    public void absolute(IPoint2<Integer, Integer> p)
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
    public void negate(IPoint2<Integer, Integer> p)
    {
        setX(-p.x());
        setY(-p.y());
    }
    
    @Override
    public void add(IPoint2<Integer, Integer> p)
    {
        setX(x()+p.x());
        setY(y()+p.y());
    }
    
    @Override
    public void add(IPoint2<Integer, Integer> p1, IPoint2<Integer, Integer> p2)
    {
        this.set(p1.x()+p2.x(),p1.y()+p2.y());
    }
    
    @Override
    public void add(Integer x, Integer y)
    {
        this.set(x()+x,y()+y);
    }
    
    @Override
    public void sub(IPoint2<Integer, Integer> p)
    {
        setX(x()-p.x());
        setY(y()-p.y());
    }
    
    @Override
    public void sub(IPoint2<Integer, Integer> p1, IPoint2<Integer, Integer> p2)
    {
        this.set(p1.x()-p2.x(),p1.y()-p2.y());
    }
    
    @Override
    public void sub(Integer x, Integer y)
    {
        this.set(x()-x,y()-y);
    }
    
    @Override
    public void multiply(IPoint2<Integer, Integer> p)
    {
        setX(x()*p.x());
        setY(y()*p.y());
    }
    
    @Override
    public void divide(IPoint2<Integer, Integer> p)
    {
        if(p.x() == 0 || p.y() == 0)
        {
            return;
        }
        
        setX(x()/p.x());
        setY(y()/p.y());
    }
    
    @Override
    public void scale(Integer n)
    {
        set(n*x(),n*y());
    }
    
    @Override
    public void scale(IPoint2<Integer, Integer> p, Integer n)
    {
        set(n*p.x(),n*p.y());
    }
    
    @Override
    public void scaleAndAdd(IPoint2<Integer, Integer> p, Integer n)
    {
        set(n*x()+p.x(),n*y()+p.y());
    }
    
    @Override
    public void scaleAndAdd(IPoint2<Integer, Integer> p1, IPoint2<Integer, Integer> p2, Integer n)
    {
        set(n*p1.x()+p2.x(),n*p1.y()+p2.y());
    }
    
    @Override
    public boolean equals(IPoint2<Integer, Integer> p)
    {
        return Objects.equals(x(), p.x()) && Objects.equals(y(), p.y());
    }
}