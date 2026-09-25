package br.com.ajf.game.math.library.vector4;

import br.com.ajf.game.math.library.point4.IPoint4;
import br.com.ajf.game.math.library.vector3.IVector3;

public class Vector4f extends Vector4<Float,Float,Float,Float>
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
    
    public void normalize(IVector4<Float,Float,Float,Float> v)
    {
        float f = (float) (1.0/Math.sqrt(v.x()*v.x()+v.y()*v.y()+v.z()*v.z()+v.w()*v.w()));
        set(v.x()*f,v.y()*f,v.z()*f,v.w()*f);
    }
    
    public void normalize()
    {
        float f = (float) (1.0/Math.sqrt(x()*x()+y()*y()+z()*z()+w()*w()));
        set(x()*f,y()*f,z()*f,w()*f);
    }
    
    public Float angle(IVector4<Float,Float,Float,Float> v)
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
    
    public Float dot(IVector4<Float,Float,Float,Float> v)
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
    
    public void set(IVector3<Float,Float,Float> p)
    {
        set(p.x(),p.y(),p.z(),0.0f);
    }
    
    public Float distanceSquared(IVector4<Float,Float,Float,Float> p)
    {
        float f = x()-p.x();
        float f2 = y()-p.y();
        float f3 = z()-p.z();
        float f4 = w()-p.w();
        return f*f+f2*f2+f3*f3+f4*f4;
    }
    
    public Float distance(IVector4<Float,Float,Float,Float> p)
    {
        return (float) Math.sqrt(distanceSquared(p));
    }
    
    public Float distanceL1(IVector4<Float,Float,Float,Float> p)
    {
        return Math.abs(x()-p.x())+Math.abs(y()-p.y())+Math.abs(z()-p.z())+Math.abs(w()-p.w());
    }
    
    public Float distanceLinF(IVector4<Float,Float,Float,Float> p)
    {
        float f = Math.max(Math.abs(x()-p.x()),Math.abs(y()-p.y()));
        float f2 = Math.max(Math.abs(z()-p.z()),Math.abs(w()-p.w()));
        return Math.max(f,f2);
    }
    
    public void project(IVector4<Float,Float,Float,Float> p)
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
    
    public float[] get()
    {
        return new float[]{x(),y(),z(),w()};
    }
    
    @Override
    public void set(Float x, Float y, Float z, Float w)
    {
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }
    
    @Override
    public void set(IPoint4<Float,Float,Float,Float> p)
    {
        set(p.x(),p.y(),p.z(),p.w());
    }
    
    @Override
    public void add(IPoint4<Float,Float,Float,Float> p)
    {
        set(x()+p.x(),y()+p.y(),z()+p.z(),w()+p.w());
    }
    
    @Override
    public void add(IPoint4<Float,Float,Float,Float> p1, IPoint4<Float,Float,Float,Float> p2)
    {
        set(p1.x()+p2.x(),p1.y()+p2.y(),p1.z()+p2.z(),p1.w()+p2.w());
    }
    
    @Override
    public void sub(IPoint4<Float,Float,Float,Float> p)
    {
        set(x()-p.x(),y()-p.y(),z()-p.z(),w()-p.w());
    }
    
    @Override
    public void sub(IPoint4<Float,Float,Float,Float> p1, IPoint4<Float,Float,Float,Float> p2)
    {
        set(p1.x()-p2.x(),p1.y()-p2.y(),p1.z()-p2.z(),p1.w()-p2.w());
    }
    
    public void interpolate(IPoint4<Float,Float,Float,Float> p,float f)
    {
        setX((1.0f-f)*x()+f*p.x());
        setY((1.0f-f)*y()+f*p.y());
        setZ((1.0f-f)*z()+f*p.z());
        setW((1.0f-f)*w()+f*p.w());
    }
    
    public void interpolate(IPoint4<Float,Float,Float,Float> p1,IPoint4<Float,Float,Float,Float> p2,float f)
    {
        setX((1.0f-f)*p1.x()+f*p2.x());
        setY((1.0f-f)*p1.y()+f*p2.y());
        setZ((1.0f-f)*p1.z()+f*p2.z());
        setW((1.0f-f)*p1.w()+f*p2.w());
    }
    
    public boolean epsilonEquals(IPoint4<Float,Float,Float,Float> p,float f)
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
        
        if(f4 > f)
        {
            return false;
        }
        
        f2 = z()-p.z();
        
        if(Float.isNaN(f2))
        {
            return false;
        }
        
        float f5 = f2 < 0.0f ? -f2 : f2;
        
        if(f5 > f)
        {
            return false;
        }
        
        f2 = w()-p.w();
        
        if(Float.isNaN(f2))
        {
            return false;
        }
        
        float f6 = f2 < 0.0f ? -f2 : f2;
        
        return !(f6 > f);
    }
    
    @Override
    public void negate()
    {
        set(-x(),-y(),-z(),-w());
    }
    
    @Override
    public void negate(IPoint4<Float,Float,Float,Float> p)
    {
        set(-p.x(),-p.y(),-p.z(),-p.w());
    }
    
    @Override
    public void scale(Float n)
    {
        set(x()*n,y()*n,z()*n,w()*n);
    }
    
    @Override
    public void scale(Float n, IPoint4<Float,Float,Float,Float> p)
    {
        set(n*p.x(),n*p.y(),n*p.z(),n*p.w());
    }
    
    @Override
    public void scaleAndAdd(Float n, IPoint4<Float,Float,Float,Float> p)
    {
        setX(n*x()+p.x());
        setY(n*y()+p.y());
        setZ(n*z()+p.z());
        setW(n*w()+p.w());
    }
    
    @Override
    public void scaleAndAdd(Float n, IPoint4<Float,Float,Float,Float> p1, IPoint4<Float,Float,Float,Float> p2)
    {
        setX(n*p1.x()+p2.x());
        setY(n*p1.y()+p2.y());
        setZ(n*p1.z()+p2.z());
        setW(n*p1.w()+p2.w());
    }
    
    @Override
    public void clamp(Float n1, Float n2, IPoint4<Float,Float,Float,Float> p)
    {
        setX(p.x() > n2 ? n2 : (p.x() < n1 ? n1 : p.x()));
        setY(p.y() > n2 ? n2 : (p.y() < n1 ? n1 : p.y()));
        setZ(p.z() > n2 ? n2 : (p.z() < n1 ? n1 : p.z()));
        setW(p.w() > n2 ? n2 : (p.w() < n1 ? n1 : p.w()));
    }
    
    @Override
    public void clampMin(Float n, IPoint4<Float,Float,Float,Float> p)
    {
        setX((p.x() < n ? n : p.x()));
        setY((p.y() < n ? n : p.y()));
        setZ((p.z() < n ? n : p.z()));
        setW((p.w() < n ? n : p.w()));
    }
    
    @Override
    public void clampMax(Float n, IPoint4<Float,Float,Float,Float> p)
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
    public void absolute(IPoint4<Float,Float,Float,Float> p)
    {
        set(Math.abs(p.x()),Math.abs(p.y()),Math.abs(p.z()),Math.abs(p.w()));
    }
    
    @Override
    public void clamp(Float n1, Float n2)
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