package br.com.ajf.game.math.library.vector4;

import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.point4.IPoint4;
import br.com.ajf.game.math.library.point4.Point4f;

public class Vector4f extends Point4f
{
    public Vector4f()
    {
        this(0f,0f,0f,0f);
    }
    
    public Vector4f(float x, float y, float z, float w)
    {
        super(x, y, z, w);
    }
    
    public Vector4f(Float[] arrayPoints)
    {
        set(arrayPoints);
    }
    
    public Vector4f(IPoint4<Float, Float, Float, Float> p)
    {
        super(p);
    }
    
    public Vector4f(Vector4f v)
    {
        this(v.x(),v.y(),v.z(),v.w());
    }
    
    public void normalize(Vector4f v)
    {
        float f = (float) (1.0/Math.sqrt(v.x()*v.x()+v.y()*v.y()+v.z()*v.z()+v.w()*v.w()));
        set(v.x()*f,v.y()*f,v.z()*f,v.w()*f);
    }
    
    public void normalize()
    {
        float f = (float) (1.0/Math.sqrt(x()*x()+y()*y()+z()*z()+w()*w()));
        set(x()*f,y()*f,z()*f,w()*f);
    }
    
    public Float angle(Vector4f v)
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
    
    public Float dot(Vector4f v)
    {
        return x()*v.x()+y()*v.y()+z()*v.z()+w()*v.w();
    }
    
    public Float length()
    {
        return (float) Math.sqrt(lengthSquared());
    }
    
    public Float lengthSquared()
    {
        return x()*x()+y()*y()+z()*z()+w()*w();
    }
    
    public void set(IPoint3<Float,Float,Float> p)
    {
        set(p.x(),p.y(),p.z(),0.0f);
    }
    
    public Float distanceSquared(Vector4f p)
    {
        float f = x()-p.x();
        float f2 = y()-p.y();
        float f3 = z()-p.z();
        float f4 = w()-p.w();
        return f*f+f2*f2+f3*f3+f4*f4;
    }
    
    public Float distance(Vector4f p)
    {
        return (float) Math.sqrt(distanceSquared(p));
    }
    
    public Float distanceL1(Vector4f p)
    {
        return Math.abs(x()-p.x())+Math.abs(y()-p.y())+Math.abs(z()-p.z())+Math.abs(w()-p.w());
    }
    
    public Float distanceLinF(Vector4f p)
    {
        float f = Math.max(Math.abs(x()-p.x()),Math.abs(y()-p.y()));
        float f2 = Math.max(Math.abs(z()-p.z()),Math.abs(w()-p.w()));
        return Math.max(f,f2);
    }
    
    public void project(Vector4f p)
    {
        float f = 1.0f/p.w();
        setX(p.x()*f);
        setY(p.y()*f);
        setZ(p.z()*f);
        setW(1.0f);
    }
    
    public void set(Float[] array)
    {
        if(array.length < 4)
        {
            return;
        }
        
        set(array[0],array[1],array[2],array[3]);
    }
}