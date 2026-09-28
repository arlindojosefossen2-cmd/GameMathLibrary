package br.com.ajf.game.math.library.tex;

import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.point3.Point3f;

public class TexCoord3f extends Point3f
{
    public TexCoord3f()
    {
    }
    
    public TexCoord3f(float x, float y, float z)
    {
        super(x, y, z);
    }
    
    public TexCoord3f(float[] arrayPoints)
    {
        super(arrayPoints);
    }
    
    public TexCoord3f(TexCoord3f t)
    {
        this(t.x(),t.y(),t.z());
    }
    
    public TexCoord3f(IPoint3<Float> p)
    {
        super(p);
    }
}
