package br.com.ajf.game.math.library.colors;

public class ColorRGBA<X> extends ColorRGB<X>
{
    private X alpha;
    
    public ColorRGBA()
    {
    }
    
    public ColorRGBA(IColorRGB<X> c)
    {
        super(c);
    }
    
    public ColorRGBA(ColorRGBA<X> c)
    {
        set(c);
        setAlpha(c.alpha);
    }
    
    public ColorRGBA(X r, X g, X b,X a)
    {
        super(r, g, b);
        setAlpha(a);
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        return  split[split.length-1]+ "( red= " + red()+", green= "+green()+", blue= "+blue()+", alpha= "+alpha()+" )";
    }
    
    public X alpha()
    {
        return alpha;
    }
    
    public void setAlpha(X a)
    {
        alpha = a;
    }
}