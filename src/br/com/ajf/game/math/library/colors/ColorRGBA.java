package br.com.ajf.game.math.library.colors;

public class ColorRGBA<X> extends ColorRGB<X>
{
    public ColorRGBA()
    {
    }
    
    public ColorRGBA(IColor<X> c)
    {
        super(c);
        setAlpha(c.alpha());
    }
    
    public ColorRGBA(X r, X g, X b,X a)
    {
        super(r, g, b);
        setAlpha(a);
    }
    
    @Override
    public void get(IColor<X> t)
    {
        super.get(t);
        t.setAlpha(alpha());
    }
    
    @Override
    public void set(IColor<X> t)
    {
        super.set(t);
        setAlpha(t.alpha());
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        return  split[split.length-1]+ "( red= " + red()+", green= "+green()+", blue= "+blue()+", alpha= "+alpha();
    }
    
    @Override
    public boolean equals(IColor<X> t)
    {
        return red() == t.red() && green() == t.green() && blue() == t.blue() && alpha() == t.alpha();
    }
}