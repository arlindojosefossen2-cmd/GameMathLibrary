package br.com.ajf.game.math.library.tex;

import br.com.ajf.game.math.library.point2.IPoint2;
import br.com.ajf.game.math.library.point2.Point2f;

public class TexCoord2f extends Point2f
{
    public TexCoord2f()
    {
    }
    
    public TexCoord2f(float x, float y)
    {
        super(x, y);
    }
    
    public TexCoord2f(float[] array)
    {
        this(array[0],array[1]);
    }
    
    public TexCoord2f(IPoint2<Float> p)
    {
        super(p);
    }
    
    public TexCoord2f(TexCoord2f t)
    {
        this(t.x(),t.y());
    }
}