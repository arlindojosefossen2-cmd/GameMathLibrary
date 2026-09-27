package br.com.ajf.game.math.library.axisangle4;

import br.com.ajf.game.math.library.point3.IPoint3;

public class AxisAngle4f extends AxisAngle4<Float>
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
    
    
}