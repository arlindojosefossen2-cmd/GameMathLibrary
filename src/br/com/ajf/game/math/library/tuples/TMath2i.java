package br.com.ajf.game.math.library.tuples;

public final class TMath2i implements TMath<Integer>
{
    @Override
    public void clamp(ITuple2<Integer> p,Integer n1, Integer n2)
    {
        p.setX(p.x() > n2 ? n2 : (p.x() < n1 ? n1 : p.x()));
        p.setY(p.y() > n2 ? n2 : (p.y() < n1 ? n1 : p.y()));
    }
    
    @Override
    public void clampMin(ITuple2<Integer> p,Integer n)
    {
        p.setX(p.x() < n ? n : p.x());
        p.setY(p.y() < n ? n : p.y());
    }
    
    @Override
    public void clampMax(ITuple2<Integer> p,Integer n)
    {
        p.setX(p.x() > n ? n : p.x());
        p.setY(p.y() > n ? n : p.y());
    }
    
    @Override
    public void absolute(ITuple2<Integer> p)
    {
        if(p == null)
        {
            return;
        }
        p.setX(Math.abs(p.x()));
        p.setY(Math.abs(p.y()));
    }
    
    @Override
    public void absolute(ITuple2<Integer> p1,ITuple2<Integer> p2)
    {
        if(p1 == null || p2 == null)
        {
            return;
        }
        p1.setX(Math.abs(p2.x()));
        p1.setY(Math.abs(p2.y()));
    }
    
    @Override
    public void negate(ITuple2<Integer> p)
    {
        if(p == null)
        {
            return;
        }
        p.setX(-p.x());
        p.setY(-p.y());
    }
    
    @Override
    public void negate(ITuple2<Integer> p1,ITuple2<Integer> p2)
    {
        if(p1 == null || p2 == null)
        {
            return;
        }
        
        p1.setX(-p2.x());
        p1.setY(-p2.y());
    }
    
    @Override
    public void add(ITuple2<Integer> p, Integer v)
    {
        if(p == null || v == null)
        {
            return;
        }
        p.setX(p.x()+v);
        p.setY(p.y()+v);
    }
    
    @Override
    public void add(ITuple2<Integer> p1, ITuple2<Integer> p2)
    {
        if(p1 == null || p2 == null)
        {
            return;
        }
        
        p1.setX(p1.x()+p2.x());
        p1.setY(p1.y()+p2.y());
    }
    
    @Override
    public void sub(ITuple2<Integer> p, Integer v)
    {
        if(p == null || v == null)
        {
            return;
        }
        p.setX(p.x()-v);
        p.setY(p.y()-v);
    }
    
    @Override
    public void sub(ITuple2<Integer> p1, ITuple2<Integer> p2)
    {
        if(p1 == null || p2 == null)
        {
            return;
        }
        
        p1.setX(p1.x()-p2.x());
        p1.setY(p1.y()-p2.y());
    }
    
    @Override
    public void multiply(ITuple2<Integer> p, Integer v)
    {
        if(p == null || v == null)
        {
            return;
        }
        
        p.setX(p.x()*v);
        p.setY(p.y()*v);
    }
    
    @Override
    public void multiply(ITuple2<Integer> p1, ITuple2<Integer> p2)
    {
        if(p1 == null || p2 == null)
        {
            return;
        }
        
        p1.setX(p1.x()*p2.x());
        p1.setY(p1.y()*p2.y());
    }
    
    @Override
    public void divide(ITuple2<Integer> p, Integer v)
    {
        if(p == null || v == null || v == 0)
        {
            return;
        }
        p.setX(p.x()/v);
        p.setY(p.y()/v);
    }
    
    @Override
    public void divide(ITuple2<Integer> p1, ITuple2<Integer> p2)
    {
        if(p1 == null || p2 == null || p2.x() == 0 || p2.y() == 0)
        {
            return;
        }
        
        p1.setX(p1.x()/p2.x());
        p1.setY(p1.y()/p2.y());
    }
    
    @Override
    public void scale(ITuple2<Integer> p, Integer s)
    {
        if(p == null || s == null)
        {
            return;
        }
        p.setX(p.x()*s);
        p.setY(p.y()*s);
    }
    
    @Override
    public void scaleAndAdd(ITuple2<Integer> p1, ITuple2<Integer> p2, Integer s)
    {
        if(p1 == null || p2 == null || s == null)
        {
            return;
        }
        p1.setX(p1.x()*s+p2.x());
        p1.setY(p1.y()*s+p2.y());
    }
    
    @Override
    public boolean equals(ITuple2<Integer> p1, ITuple2<Integer> p2)
    {
        if(p1 == null || p2 == null)
        {
            return false;
        }
        return p1.equals(p2);
    }
}