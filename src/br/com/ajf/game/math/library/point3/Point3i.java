package br.com.ajf.game.math.library.point3;

public final class Point3i extends Point3<Integer,Integer,Integer>
{
    public Point3i()
    {
        this(0,0,0);
    }
    
    public Point3i(int x, int y, int z)
    {
       super(x,y,z);
    }
    
    public Point3i(int[] arrayPoints)
    {
        set(arrayPoints);
    }
    
    public Point3i(Point3<Integer, Integer, Integer> p)
    {
        super(p);
    }
    
    @Override
    public void set(Integer x, Integer y, Integer z)
    {
        setX(x);
        setY(y);
        setZ(z);
    }
    
    @Override
    public void set(IPoint3<Integer, Integer, Integer> p)
    {
        set(p.x(),p.y(),p.z());
    }
    
    public void set(int[] arrayPoints)
    {
        if(arrayPoints.length < 3)
        {
            return;
        }
        
        set(arrayPoints[0],arrayPoints[1],arrayPoints[2]);
    }
    
    @Override
    public void add(IPoint3<Integer, Integer, Integer> p)
    {
        set(x()+p.x(),y()+p.y(),z()+p.z());
    }
    
    @Override
    public void add(IPoint3<Integer, Integer, Integer> p1, IPoint3<Integer, Integer, Integer> p2)
    {
        set(p1.x()+p2.x(),p1.y()+p2.y(),p1.z()+p2.z());
    }
    
    @Override
    public void sub(IPoint3<Integer, Integer, Integer> p)
    {
        set(x()-p.x(),y()-p.y(),z()-p.z());
    }
    
    @Override
    public void sub(IPoint3<Integer, Integer, Integer> p1, IPoint3<Integer, Integer, Integer> p2)
    {
        set(p1.x()-p2.x(),p1.y()-p2.y(),p1.z()-p2.z());
    }
    
    @Override
    public void negate()
    {
        set(-x(),-y(),-z());
    }
    
    @Override
    public void negate(IPoint3<Integer, Integer, Integer> p)
    {
        set(-p.x(),-p.y(),-p.z());
    }
    
    @Override
    public void scale(Integer n)
    {
        set(n*x(),n*y(),n*z());
    }
    
    @Override
    public void scale(Integer n, IPoint3<Integer, Integer, Integer> p)
    {
        set(n*p.x(),n*p.y(),n*p.z());
    }
    
    @Override
    public void scaleAndAdd(Integer n, IPoint3<Integer, Integer, Integer> p1, IPoint3<Integer, Integer, Integer> p2)
    {
        set(n*p1.x()+p2.x(),n*p1.y()+p2.y(),n*p1.z()+p2.z());
    }
    
    @Override
    public void scaleAndAdd(Integer n, IPoint3<Integer, Integer, Integer> p)
    {
        set(n*x()+p.x(),n*y()+p.y(),n*z()+p.z());
    }
    
    @Override
    public void clamp(Integer n1, Integer n2, IPoint3<Integer, Integer, Integer> p)
    {
        setX(p.x() > n2 ? n2 : (p.x() < n1 ? n1 : p.x()));
        setY(p.y() > n2 ? n2 : (p.y() < n1 ? n1 : p.y()));
        setZ(p.z() > n2 ? n2 : (p.z() < n1 ? n1 : p.z()));
    }
    
    @Override
    public void clampMin(Integer n, IPoint3<Integer, Integer, Integer> p)
    {
        setX(p.x() < n ? n : p.x());
        setY(p.y() < n ? n : p.y());
        setZ(p.z() < n ? n : p.z());
    }
    
    @Override
    public void clampMax(Integer n, IPoint3<Integer, Integer, Integer> p)
    {
        setX(p.x() > n ? n : p.x());
        setY(p.y() > n ? n : p.y());
        setZ(p.z() > n ? n : p.z());
    }
    
    @Override
    public void absolute()
    {
        set(Math.abs(x()),Math.abs(y()),Math.abs(z()));
    }
    
    @Override
    public void absolute(IPoint3<Integer, Integer, Integer> p)
    {
        set(Math.abs(p.x()),Math.abs(p.y()),Math.abs(p.z()));
    }
    
    @Override
    public void clamp(Integer n1, Integer n2)
    {
        if(x() > n2)
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
        
        if(z() > n2)
        {
            setZ(n2);
        }
        else if(z() < n1)
        {
            setZ(n1);
        }
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
        
        if(z() < n)
        {
            setZ(n);
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
        
        if(z() > n)
        {
            setZ(n);
        }
    }
}