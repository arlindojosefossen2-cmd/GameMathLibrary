package br.com.ajf.game.math.library.quat4;

import br.com.ajf.game.math.library.point4.IPoint4;
import br.com.ajf.game.math.library.point4.Point4d;

public class Quat4d extends Point4d
{
    public Quat4d()
    {
        this(0.0,0.0,0.0,0.0);
    }
    
    public Quat4d(double x, double y, double z, double w)
    {
        double d = 1.0/Math.sqrt(x*x+y*y+z*z+w*w);
        set(d*x,d*y,d*z,d*w);
    }
    
    public Quat4d(double[] arrayPoints)
    {
        this(arrayPoints[0],arrayPoints[1],arrayPoints[2],arrayPoints[3]);
    }
    
    public Quat4d(IPoint4<Double> p)
    {
        this(p.x(),p.y(),p.z(),p.w());
    }
    
    public Quat4d(Quat4d q)
    {
        this(q.x(),q.y(),q.z(),q.w());
    }
    
    public Quat4d(Quat4f q)
    {
        this(Double.parseDouble(String.valueOf(q.x())),Double.parseDouble(String.valueOf(q.y())),Double.parseDouble(String.valueOf(q.z())),Double.parseDouble(String.valueOf(q.w())));
    }
}