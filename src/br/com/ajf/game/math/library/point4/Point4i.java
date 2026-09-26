package br.com.ajf.game.math.library.point4;

public final class Point4i extends Point4<Integer>
{
    public Point4i()
    {
        this(0,0,0,0);
    }
    
    public Point4i(int x, int y, int z, int w)
    {
        super(x,y,z,w);
    }
    
    public Point4i(int[] arrayPoints)
    {
        set(arrayPoints);
    }
    
    public Point4i(Point4<Integer> p)
    {
        super(p);
    }
    
    public void set(int[] array)
    {
        if(array.length < 4)
        {
            return;
        }
        
        set(array[0],array[1],array[2],array[3]);
    }
    
    public int[] get()
    {
        return new int[]{x(),y(),z(),w()};
    }
    
    @Override
    public void set(Integer x, Integer y, Integer z, Integer w)
    {
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }
    
    @Override
    public void set(IPoint4<Integer> p)
    {
        set(p.x(),p.y(),p.z(),p.w());
    }
    
    @Override
    public void add(IPoint4<Integer> p)
    {
        set(x()+p.x(),y()+p.y(),z()+p.z(),w()+p.w());
    }
    
    @Override
    public void add(IPoint4<Integer> p1, IPoint4<Integer> p2)
    {
        set(p1.x()+p2.x(),p1.y()+p2.y(),p1.z()+p2.z(),p1.w()+p2.w());
    }
    
    @Override
    public void sub(IPoint4<Integer> p)
    {
        set(x()-p.x(),y()-p.y(),z()-p.z(),w()-p.w());
    }
    
    @Override
    public void sub(IPoint4<Integer> p1, IPoint4<Integer> p2)
    {
        set(p1.x()-p2.x(),p1.y()-p2.y(),p1.z()-p2.z(),p1.w()-p2.w());
    }
    
    @Override
    public void negate()
    {
        set(-x(),-y(),-z(),-w());
    }
    
    @Override
    public void negate(IPoint4<Integer> p)
    {
        set(-p.x(),-p.y(),-p.z(),-p.w());
    }
    
    @Override
    public void scale(Integer n)
    {
        set(x()*n,y()*n,z()*n,w()*n);
    }
    
    @Override
    public void scale(Integer n, IPoint4<Integer> p)
    {
        set(n*p.x(),n*p.y(),n*p.z(),n*p.w());
    }
    
    @Override
    public void scaleAndAdd(Integer n, IPoint4<Integer> p)
    {
        setX(n*x()+p.x());
        setY(n*y()+p.y());
        setZ(n*z()+p.z());
        setW(n*w()+p.w());
    }
    
    @Override
    public void scaleAndAdd(Integer n, IPoint4<Integer> p1, IPoint4<Integer> p2)
    {
        setX(n*p1.x()+p2.x());
        setY(n*p1.y()+p2.y());
        setZ(n*p1.z()+p2.z());
        setW(n*p1.w()+p2.w());
    }
    
    @Override
    public void clamp(Integer n1, Integer n2, IPoint4<Integer> p)
    {
        setX(p.x() > n2 ? n2 : (p.x() < n1 ? n1 : p.x()));
        setY(p.y() > n2 ? n2 : (p.y() < n1 ? n1 : p.y()));
        setZ(p.z() > n2 ? n2 : (p.z() < n1 ? n1 : p.z()));
        setW(p.w() > n2 ? n2 : (p.w() < n1 ? n1 : p.w()));
    }
    
    @Override
    public void clampMin(Integer n, IPoint4<Integer> p)
    {
        setX((p.x() < n ? n : p.x()));
        setY((p.y() < n ? n : p.y()));
        setZ((p.z() < n ? n : p.z()));
        setW((p.w() < n ? n : p.w()));
    }
    
    @Override
    public void clampMax(Integer n, IPoint4<Integer> p)
    {
        setX((p.x() > n ? n : p.x()));
        setY((p.y() > n ? n : p.y()));
        setZ((p.z() > n ? n : p.z()));
        setW((p.w() > n ? n : p.w()));
    }
    
    @Override
    public void absolute()
    {
        set(Math.abs(x()),Math.abs(y()),Math.abs(z()),Math.abs(w()));
    }
    
    @Override
    public void absolute(IPoint4<Integer> p)
    {
        set(Math.abs(p.x()),Math.abs(p.y()),Math.abs(p.z()),Math.abs(p.w()));
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
        
        if(w() > n2)
        {
            setW(n2);
        }
        else if(w() < n1)
        {
            setW(n1);
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
        
        if(w() < n)
        {
            setW(n);
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
        
        if(w() > n)
        {
            setW(n);
        }
    }
}