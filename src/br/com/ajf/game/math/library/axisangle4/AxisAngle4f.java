package br.com.ajf.game.math.library.axisangle4;

import br.com.ajf.game.math.library.matrix3.Matrix3d;
import br.com.ajf.game.math.library.matrix3.Matrix3f;
import br.com.ajf.game.math.library.matrix4.Matrix4d;
import br.com.ajf.game.math.library.matrix4.Matrix4f;
import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.quat4.Quat4d;
import br.com.ajf.game.math.library.quat4.Quat4f;

public final class AxisAngle4f extends AxisAngle4<Float>
{
    public AxisAngle4f()
    {
        this(0.0f,0.0f,1.0f,0.0f);
    }
    
    public AxisAngle4f(Float x, Float y, Float z, Float angle)
    {
        super(x, y, z, angle);
    }
    
    public AxisAngle4f(Float[] data)
    {
        super(data);
    }
    
    public AxisAngle4f(AxisAngle4<Float> aa)
    {
        super(aa);
    }
    
    public AxisAngle4f(IPoint3<Float> p, Float angle)
    {
        super(p, angle);
    }
    
    @Override
    public void set(Float x, Float y, Float z, Float angle)
    {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
        this.setAngle(angle);
    }
    
    @Override
    public void set(Float[] array)
    {
        set(array[0],array[1],array[2],array[3]);
    }
    
    @Override
    public void set(AxisAngle4<Float> aa)
    {
        set(aa.x(),aa.y(),aa.z(),aa.angle());
    }
    
    @Override
    public void set(IPoint3<Float> v, Float angle)
    {
        set(v.x(),v.y(),v.z(),angle);
    }
    
    @Override
    public void get(Float[] x)
    {
        if(x.length < 4)
        {
            return;
        }
        
        x[0] = x();
        x[1] = y();
        x[2] = z();
        x[3] = angle();
    }
    
    @Override
    public void set(Quat4f q)
    {
        double d = q.x()*q.x()+q.y()*q.y()+q.z()*q.z();
        
        if(d > 1.0E-6)
        {
            d = Math.sqrt(d);
            
            double d2 = 1.0/d;
            
            setX((float)((double)q.x()*d2));
            setY((float)((double)q.y()*d2));
            setZ((float)((double)q.z()*d2));
            setAngle((float)(2.0*Math.atan2(d,q.w())));
        }
        else
        {
            set(0f,1f,0f,0f);
        }
    }
    
    @Override
    public void set(Quat4d q)
    {
        double d = q.x()*q.x()+q.y()*q.y()+q.z()*q.z();
        
        if(d > 1.0E-6)
        {
            d = Math.sqrt(d);
            
            double d2 = 1.0/d;
            
            setX((float)(q.x() * d2));
            setY((float)(q.y() * d2));
            setZ((float)(q.z() * d2));
            setAngle((float)(2.0*Math.atan2(d,q.w())));
        }
        else
        {
            set(0f,1f,0f,0f);
        }
    }
    
    @Override
    public void set(Matrix3f m)
    {
        setX(m.getM21()-m.getM12());
        setY(m.getM02()-m.getM20());
        setZ(m.getM10()-m.getM01());
        
        double d = x()*x()+y()*y()+z()*z();
        
        if(d > 1.0E-6)
        {
            d = Math.sqrt(d);
            double d2 = 0.5 * d;
            double d3 = 0.5 * ((double) (m.getM00()+m.getM11()+m.getM22())-1.0);
            setAngle((float)Math.atan2(d2,d3));
            double d4 = 1.0/d;
            
            setX((float)((double)x()*d4));
            setY((float)((double)y()*d4));
            setZ((float)((double)z()*d4));
        }
        else
        {
            set(0f,1f,0f,0f);
        }
    }
    
    @Override
    public void set(Matrix3d m)
    {
        setX((float) (m.getM21() - m.getM12()));
        setY((float) (m.getM02() - m.getM20()));
        setZ((float) (m.getM10() - m.getM01()));
        
        double d = x()*x()+y()*y()+z()*z();
        
        if(d > 1.0E-6)
        {
            d = Math.sqrt(d);
            double d2 = 0.5 * d;
            double d3 = 0.5 * ((m.getM00() + m.getM11() + m.getM22()) - 1.0);
            setAngle((float)Math.atan2(d2,d3));
            double d4 = 1.0/d;
            
            setX((float)((double)x()*d4));
            setY((float)((double)y()*d4));
            setZ((float)((double)z()*d4));
        }
        else
        {
            set(0f,1f,0f,0f);
        }
    }
    
    @Override
    public void set(Matrix4f m)
    {
        Matrix3f m3f = new Matrix3f();
        m.get(m3f);
        setX(m3f.getM21()-m3f.getM12());
        setY(m3f.getM02()-m3f.getM20());
        setZ(m3f.getM10()-m3f.getM01());
        
        double d = x()*x()+y()*y()+z()*z();
        
        if(d > 1.0E-6)
        {
            d = Math.sqrt(d);
            double d2 = 0.5*d;
            double d3 = 0.5*(m3f.getM00()+m3f.getM11()+m3f.getM22()-1.0);
            setAngle((float) Math.atan2(d2,d3));
            double d4 = 1.0/d;
            setX((float)(x()*d4));
            setY((float)(y()*d4));
            setZ((float)(z()*d4));
        }
        else
        {
            setX(0.0f);
            setY(1.0f);
            setZ(0f);
            setAngle(0f);
        }
    }
    
    @Override
    public void set(Matrix4d m)
    {
        Matrix3d m3f = new Matrix3d();
        m.get(m3f);
        setX((float) (m3f.getM21() - m3f.getM12()));
        setY((float) (m3f.getM02() - m3f.getM20()));
        setZ((float) (m3f.getM10() - m3f.getM01()));
        
        double d = x()*x()+y()*y()+z()*z();
        
        if(d > 1.0E-6)
        {
            d = Math.sqrt(d);
            double d2 = 0.5*d;
            double d3 = 0.5*(m3f.getM00()+m3f.getM11()+m3f.getM22()-1.0);
            setAngle((float) Math.atan2(d2,d3));
            double d4 = 1.0/d;
            setX((float)(x()*d4));
            setY((float)(y()*d4));
            setZ((float)(z()*d4));
        }
        else
        {
            setX(0.0f);
            setY(1.0f);
            setZ(0f);
            setAngle(0f);
        }
    }
    
    @Override
    public boolean epsilonEquals(AxisAngle4<Float> aa, Float f)
    {
        float f2 = x()-aa.x();
        float f3 = f2 < 0f ? -f2 : f2;
        if(f3 > f)
        {
            return false;
        }
        f2 = y()-aa.y();
        
        f3 = f2 < 0f ? -f2:f2;
        
        if(f3 > f)
        {
            return false;
        }
        
        f2 = z()-aa.z();
        f3 = f2 < 0f ? -f2:f2;
        if(f3 > f)
        {
            return false;
        }
        
        f2 = angle()-aa.angle();
        f3 = f2 < 0f ? -f2:f2;
        return !(f3 > f);
    }
}