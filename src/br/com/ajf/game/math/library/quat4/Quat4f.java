package br.com.ajf.game.math.library.quat4;

import br.com.ajf.game.math.library.point4.IPoint4;
import br.com.ajf.game.math.library.point4.Point4f;

public class Quat4f extends Point4f
{
    public Quat4f()
    {
        this(0f,0f,0f,0f);
    }
    
    public Quat4f(float x, float y, float z, float w)
    {
        float f = (float) (1.0/Math.sqrt(x*x+y*y+z*z+w*w));
        set(f*x,f*y,f*z,f*w);
    }
    
    public Quat4f(float[] arrayPoints)
    {
        this(arrayPoints[0],arrayPoints[1],arrayPoints[2],arrayPoints[3]);
    }
    
    public Quat4f(IPoint4<Float> p)
    {
        this(p.x(),p.y(),p.z(),p.w());
    }
    
    public Quat4f(Quat4f q)
    {
        this(q.x(),q.y(),q.z(),q.w());
    }
    
    public Quat4f(Quat4d q)
    {
        this(Float.parseFloat(String.valueOf(q.x())),
                Float.parseFloat(String.valueOf(q.y())),
                Float.parseFloat(String.valueOf(q.z())),
                Float.parseFloat(String.valueOf(q.w())));
    }
    
    
}