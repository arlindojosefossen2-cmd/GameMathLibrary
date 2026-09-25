package br.com.ajf.game.math.library.vector4;

import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.point4.IPoint4;
import br.com.ajf.game.math.library.point4.Point4f;

public class Vector4f extends Point4f
{
    public Vector4f()
    {
    }
    
    public Vector4f(float x, float y, float z, float w)
    {
        super(x, y, z, w);
    }
    
    public Vector4f(float[] arrayPoints)
    {
        super(arrayPoints);
    }
    
    public Vector4f(Float x, Float y, Float z, Float w)
    {
        super(x, y, z, w);
    }
    
    public Vector4f(IPoint4<Float, Float, Float, Float> p)
    {
        super(p);
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
    
    public float angle(Vector4f v)
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
    
    public float dot(Vector4f v)
    {
        return x()*v.x()+y()*v.y()+z()*v.z()+w()*v.w();
    }
    
    public float length()
    {
        return (float) Math.sqrt(lengthSquared());
    }
    
    public float lengthSquared()
    {
        return x()*x()+y()*y()+z()*z()+w()*w();
    }
    
    public void set(IPoint3<Float,Float,Float> p)
    {
        set(p.x(),p.y(),p.z(),0.0f);
    }
}