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
    
    public Vector4f(float[] arrayPoints)
    {
        set(arrayPoints);
    }
    
    public Vector4f(IPoint4<Float> p)
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
}