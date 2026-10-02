package br.com.ajf.game.math.library.tuples.tmath3;

import br.com.ajf.game.math.library.tuples.tuple3.ITuple3;

public final class TMath3i implements TMath3<Integer>
{
    @Override
    public Integer distanceSquared(ITuple3<Integer> p1, ITuple3<Integer> p2)
    {
        int f = p1.x()-p2.x();
        int f2 = p1.y()-p2.y();
        int f3 = p1.z()-p2.z();
        return (f * f + f2 * f2 + f3 * f3);
    }
    
    @Override
    public Integer distance(ITuple3<Integer> p1, ITuple3<Integer> p2)
    {
        return (int) Math.sqrt(distanceSquared(p1,p2));
    }
    
    @Override
    public Integer distanceL1(ITuple3<Integer> p1, ITuple3<Integer> p2)
    {
        return Math.abs(p1.x()-p2.x())+Math.abs(p1.y()-p2.y())+Math.abs(p1.z()-p2.z());
    }
    
    @Override
    public Integer distanceLinF(ITuple3<Integer> p1, ITuple3<Integer> p2)
    {
        int f = Math.max(Math.abs(p1.x()-p2.x()),Math.abs(p1.y()-p2.y()));
        return Math.max(f,Math.abs(p1.z() - p2.z()));
    }
    
    @Override
    public void clamp(ITuple3<Integer> p, Integer n1, Integer n2)
    {
        p.setX(p.x() > n2 ? n2 : (p.x() < n1 ? n1 : p.x()));
        p.setY(p.y() > n2 ? n2 : (p.y() < n1 ? n1 : p.y()));
        p.setZ(p.z() > n2 ? n2 : (p.z() < n1 ? n1 : p.z()));
    }
    
    @Override
    public void clamp(ITuple3<Integer> p1,ITuple3<Integer> p2,Integer n1, Integer n2)
    {
        p1.setX(p2.x() > n2 ? n2 : (p2.x() < n1 ? n1 : p2.x()));
        p1.setY(p2.y() > n2 ? n2 : (p2.y() < n1 ? n1 : p2.y()));
        p1.setZ(p2.z() > n2 ? n2 : (p2.z() < n1 ? n1 : p2.z()));
    }
    
    @Override
    public void clampMin(ITuple3<Integer> p,Integer n)
    {
        p.setX(p.x() < n ? n : p.x());
        p.setY(p.y() < n ? n : p.y());
        p.setZ(p.z() < n ? n : p.z());
    }
    
    @Override
    public void clampMax(ITuple3<Integer> p,Integer n)
    {
        p.setX(p.x() > n ? n : p.x());
        p.setY(p.y() > n ? n : p.y());
        p.setZ(p.z() > n ? n : p.z());
    }
    
    @Override
    public void absolute(ITuple3<Integer> p)
    {
        if(p == null)
        {
            return;
        }
        p.setX(Math.abs(p.x()));
        p.setY(Math.abs(p.y()));
        p.setZ(Math.abs(p.z()));
    }
    
    @Override
    public void absolute(ITuple3<Integer> p1,ITuple3<Integer> p2)
    {
        if(p1 == null || p2 == null)
        {
            return;
        }
        p1.setX(Math.abs(p2.x()));
        p1.setY(Math.abs(p2.y()));
        p1.setZ(Math.abs(p2.z()));
    }
    
    @Override
    public void negate(ITuple3<Integer> p)
    {
        if(p == null)
        {
            return;
        }
        p.setX(-p.x());
        p.setY(-p.y());
        p.setZ(-p.z());
    }
    
    @Override
    public void negate(ITuple3<Integer> p1,ITuple3<Integer> p2)
    {
        if(p1 == null || p2 == null)
        {
            return;
        }
        
        p1.setX(-p2.x());
        p1.setY(-p2.y());
        p1.setZ(-p2.z());
    }
    
    @Override
    public void add(ITuple3<Integer> p, Integer v)
    {
        if(p == null || v == null)
        {
            return;
        }
        p.setX(p.x()+v);
        p.setY(p.y()+v);
        p.setZ(p.z()+v);
    }
    
    @Override
    public void add(ITuple3<Integer> p1, ITuple3<Integer> p2)
    {
        if(p1 == null || p2 == null)
        {
            return;
        }
        
        p1.setX(p1.x()+p2.x());
        p1.setY(p1.y()+p2.y());
        p1.setZ(p1.z()+p2.z());
    }
    
    @Override
    public void sub(ITuple3<Integer> p, Integer v)
    {
        if(p == null || v == null)
        {
            return;
        }
        p.setX(p.x()-v);
        p.setY(p.y()-v);
        p.setZ(p.z()-v);
    }
    
    @Override
    public void sub(ITuple3<Integer> p1, ITuple3<Integer> p2)
    {
        if(p1 == null || p2 == null)
        {
            return;
        }
        
        p1.setX(p1.x()-p2.x());
        p1.setY(p1.y()-p2.y());
        p1.setZ(p1.z()-p2.z());
    }
    
    @Override
    public void multiply(ITuple3<Integer> p, Integer v)
    {
        if(p == null || v == null)
        {
            return;
        }
        
        p.setX(p.x()*v);
        p.setY(p.y()*v);
        p.setZ(p.z()*v);
    }
    
    @Override
    public void multiply(ITuple3<Integer> p1, ITuple3<Integer> p2)
    {
        if(p1 == null || p2 == null)
        {
            return;
        }
        
        p1.setX(p1.x()*p2.x());
        p1.setY(p1.y()*p2.y());
        p1.setZ(p1.z()*p2.z());
    }
    
    @Override
    public void divide(ITuple3<Integer> p, Integer v)
    {
        if(p == null || v == null || v == 0)
        {
            return;
        }
        p.setX(p.x()/v);
        p.setY(p.y()/v);
        p.setZ(p.z()/v);
    }
    
    @Override
    public void divide(ITuple3<Integer> p1, ITuple3<Integer> p2)
    {
        if(p1 == null || p2 == null || p2.x() == 0 || p2.y() == 0 || p2.z() == 0)
        {
            return;
        }
        
        p1.setX(p1.x()/p2.x());
        p1.setY(p1.y()/p2.y());
        p1.setZ(p1.z()/p2.z());
    }
    
    @Override
    public void scale(ITuple3<Integer> p, Integer s)
    {
        if(p == null || s == null)
        {
            return;
        }
        p.setX(p.x()*s);
        p.setY(p.y()*s);
        p.setZ(p.z()*s);
    }
    
    @Override
    public void scaleAndAdd(ITuple3<Integer> p1, ITuple3<Integer> p2, Integer s)
    {
        if(p1 == null || p2 == null || s == null)
        {
            return;
        }
        p1.setX(p1.x()*s+p2.x());
        p1.setY(p1.y()*s+p2.y());
        p1.setZ(p1.z()*s+p2.z());
    }
    
    @Override
    public boolean equals(ITuple3<Integer> p1, ITuple3<Integer> p2)
    {
        if(p1 == null || p2 == null)
        {
            return false;
        }
        return p1.equals(p2);
    }
}