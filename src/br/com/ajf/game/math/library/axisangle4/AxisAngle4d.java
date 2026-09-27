package br.com.ajf.game.math.library.axisangle4;

import br.com.ajf.game.math.library.point3.IPoint3;

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
}