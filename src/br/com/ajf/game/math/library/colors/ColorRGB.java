package br.com.ajf.game.math.library.colors;

import java.util.Arrays;
import java.util.Objects;

public class ColorRGB<X> implements IColorRGB<X>
{
    @SuppressWarnings("unchecked")
    private final X[] data = (X[])new Object[3];
    
    public ColorRGB()
    {
    
    }
    
    public ColorRGB(IColorRGB<X> c)
    {
        set(c);
    }
    
    public ColorRGB(X r, X g, X b)
    {
        setRed(r);
        setGreen(g);
        setBlue(b);
    }
    
    @Override
    public void get(IColorRGB<X> t)
    {
        t.setRed(red());
        t.setGreen(green());
        t.setBlue(t.blue());
    }
    
    @Override
    public void set(IColorRGB<X> t)
    {
        setRed(t.red());
        setGreen(t.green());
        setBlue(t.blue());
    }
    @Override
    @SuppressWarnings("unchecked")
    public IColorRGB<X> clone()
    {
        try
        {
            return (IColorRGB<X>) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof ColorRGB<?> rbgColor))
            return false;
        return Objects.deepEquals(data, rbgColor.data);
    }
    
    @Override
    public int hashCode()
    {
        return Arrays.hashCode(data);
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        return  split[split.length-1]+ "( red= " + red()+", green= "+green()+", blue= "+blue()+" )";
    }
    
    @Override
    public boolean equals(IColorRGB<X> t)
    {
        return red() == t.red() && green() == t.green() && blue() == t.blue();
    }
    
    @Override
    public X red()
    {
        return data[0];
    }
    
    @Override
    public void setRed(X r)
    {
        data[0] = r;
    }
    
    @Override
    public X green()
    {
        return data[1];
    }
    
    @Override
    public void setGreen(X g)
    {
        data[1] = g;
    }
    
    @Override
    public X blue()
    {
        return data[2];
    }
    
    @Override
    public void setBlue(X b)
    {
        data[2] = b;
    }
}