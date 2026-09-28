package br.com.ajf.game.math.library.tex;

import br.com.ajf.game.math.library.point4.IPoint4;
import br.com.ajf.game.math.library.point4.Point4f;

public class TexCoord4f extends Point4f
{
    public TexCoord4f()
    {
    }
    
    public TexCoord4f(float x, float y, float z, float w)
    {
        super(x, y, z, w);
    }
    
    public TexCoord4f(float[] arrayPoints)
    {
        super(arrayPoints);
    }
    
    public TexCoord4f(TexCoord4f t)
    {
        this(t.x(),t.y(),t.z(),t.w());
    }
    
    public TexCoord4f(IPoint4<Float> p)
    {
        super(p);
    }
}