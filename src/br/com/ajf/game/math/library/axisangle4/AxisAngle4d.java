package br.com.ajf.game.math.library.axisangle4;

import br.com.ajf.game.math.library.matrix3.Matrix3d;
import br.com.ajf.game.math.library.matrix3.Matrix3f;
import br.com.ajf.game.math.library.matrix4.Matrix4d;
import br.com.ajf.game.math.library.matrix4.Matrix4f;
import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.quat4.Quat4d;
import br.com.ajf.game.math.library.quat4.Quat4f;

public class AxisAngle4d extends AxisAngle4<Double>
{
    public AxisAngle4d()
    {
        this(0.0,0.0,1.0,0.0);
    }
    
    public AxisAngle4d(Double aDouble, Double y, Double z, Double angle)
    {
        super(aDouble, y, z, angle);
    }
    
    public AxisAngle4d(Double[] data)
    {
        super(data);
    }
    
    public AxisAngle4d(AxisAngle4<Double> aa)
    {
        super(aa);
    }
    
    public AxisAngle4d(IPoint3<Double> p, Double angle)
    {
        super(p, angle);
    }
    
    @Override
    public void set(Double x, Double y, Double z, Double angle)
    {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
        this.setAngle(angle);
    }
    
    @Override
    public void set(Double[] array)
    {
        set(array[0],array[1],array[2],array[3]);
    }
    
    @Override
    public void set(AxisAngle4<Double> aa)
    {
        set(aa.x(),aa.y(),aa.z(),aa.angle());
    }
    
    @Override
    public void set(IPoint3<Double> v, Double angle)
    {
        set(v.x(),v.y(),v.z(),angle);
    }
    
    @Override
    public void get(Double[] x)
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
            
            setX(((double)q.x()*d2));
            setY(((double)q.y()*d2));
            setZ(((double)q.z()*d2));
            setAngle((2.0*Math.atan2(d,q.w())));
        }
        else
        {
            set(0.0,1.0,0.0,0.0);
        }
    }
    
    @Override
    public void set(Matrix4f m)
    {
        Matrix3f m3f = new Matrix3f();
        m.get(m3f);
        setX((double) (m3f.getM21() - m3f.getM12()));
        setY((double) (m3f.getM02() - m3f.getM20()));
        setZ((double) (m3f.getM10() - m3f.getM01()));
        
        double d = x()*x()+y()*y()+z()*z();
        
        if(d > 1.0E-6)
        {
            d = Math.sqrt(d);
            double d2 = 0.5*d;
            double d3 = 0.5*(m3f.getM00()+m3f.getM11()+m3f.getM22()-1.0);
            setAngle( Math.atan2(d2,d3));
            double d4 = 1.0/d;
            setX(x()*d4);
            setY(y()*d4);
            setZ((z()*d4));
        }
        else
        {
            setX(0.0);
            setY(1.0);
            setZ(0.0);
            setAngle(0.0);
        }
    }
    
    @Override
    public void set(Matrix4d m)
    {
        Matrix3d m3f = new Matrix3d();
        m.get(m3f);
        setX( (m3f.getM21() - m3f.getM12()));
        setY(m3f.getM02() - m3f.getM20());
        setZ( (m3f.getM10() - m3f.getM01()));
        
        double d = x()*x()+y()*y()+z()*z();
        
        if(d > 1.0E-6)
        {
            d = Math.sqrt(d);
            double d2 = 0.5*d;
            double d3 = 0.5*(m3f.getM00()+m3f.getM11()+m3f.getM22()-1.0);
            setAngle(Math.atan2(d2,d3));
            double d4 = 1.0/d;
            setX((x()*d4));
            setY((y()*d4));
            setZ((z()*d4));
        }
        else
        {
            setX(0.0);
            setY(1.0);
            setZ(0.0);
            setAngle(0.0);
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
            
            setX((q.x() * d2));
            setY((q.y() * d2));
            setZ((q.z() * d2));
            setAngle((2.0*Math.atan2(d,q.w())));
        }
        else
        {
            set(0.0,1.0,0.0,0.0);
        }
    }
    
    @Override
    public void set(Matrix3f m)
    {
        setX((double) (m.getM21() - m.getM12()));
        setY((double) (m.getM02() - m.getM20()));
        setZ((double) (m.getM10() - m.getM01()));
        
        double d = x()*x()+y()*y()+z()*z();
        
        if(d > 1.0E-6)
        {
            d = Math.sqrt(d);
            double d2 = 0.5 * d;
            double d3 = 0.5 * ((double) (m.getM00()+m.getM11()+m.getM22())-1.0);
            setAngle(Math.atan2(d2,d3));
            double d4 = 1.0/d;
            
            setX((x() * d4));
            setY((y() * d4));
            setZ((z() * d4));
        }
        else
        {
            set(0.0,1.0,0.0,0.0);
        }
    }
    
    @Override
    public void set(Matrix3d m)
    {
        setX((m.getM21() - m.getM12()));
        setY((m.getM02() - m.getM20()));
        setZ( (m.getM10() - m.getM01()));
        
        double d = x()*x()+y()*y()+z()*z();
        
        if(d > 1.0E-6)
        {
            d = Math.sqrt(d);
            double d2 = 0.5 * d;
            double d3 = 0.5 * ((m.getM00() + m.getM11() + m.getM22()) - 1.0);
            setAngle(Math.atan2(d2,d3));
            double d4 = 1.0/d;
            
            setX(x() * d4);
            setY(y() * d4);
            setZ(z()*d4);
        }
        else
        {
            set(0.0,1.0,0.0,0.0);
        }
    }
    
    @Override
    public boolean epsilonEquals(AxisAngle4<Double> aa, Double f)
    {
        double f2 = x()-aa.x();
        double f3 = f2 < 0f ? -f2 : f2;
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