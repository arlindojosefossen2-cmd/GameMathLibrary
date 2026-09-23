package br.com.ajf.game.math.library.point2i;

import br.com.ajf.game.math.library.point2d.Point2d;
import br.com.ajf.game.math.library.point2f.Point2f;
import br.com.ajf.game.math.library.utilities.Documentation;

import java.io.Serializable;
import java.util.Objects;

@Documentation(info="Class Point2i is only a class to make casting of Point2f and Point2d")
public class Point2i implements Serializable, Cloneable
{
    private int x;
    private int y;
    
    public Point2i()
    {
        this(0,0);
    }
    
    public Point2i(Point2i p)
    {
        this(p.x,p.y);
    }
    
    public Point2i(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Point2i(int[] arrayPoints)
    {
        this(0,0);
        
        if(arrayPoints.length != 2)
        {
            return;
        }
        
        this.x = arrayPoints[0];
        this.y = arrayPoints[1];
    }
    
    public Point2i floor(Point2f p)
    {
        return new Point2i((int) Math.floor(p.X()), (int) Math.floor(p.Y()));
    }
    
    public Point2i floor(Point2d p)
    {
        return new Point2i((int) Math.floor(p.X()), (int) Math.floor(p.Y()));
    }
    
    public Point2i round(Point2f p)
    {
        return new Point2i(Math.round(p.X()),Math.round(p.Y()));
    }
    
    public Point2i round(Point2d p)
    {
        return new Point2i((int) Math.round(p.X()), (int) Math.round(p.Y()));
    }
    
    public Point2i set(Point2i p)
    {
        return set(p.x,p.y);
    }
    
    public Point2i set(int x,int y)
    {
        setX(x).setY(y);
        return this;
    }
    
    public Point2i set(int[] arrayPoints)
    {
        if(arrayPoints.length != 2)
        {
            return this;
        }
        return set(arrayPoints[0],arrayPoints[1]);
    }
    
    public int[] get()
    {
        return new int[]{x,y};
    }
    
    public int[] get(int[] arrayPoints)
    {
        arrayPoints[0] = x;
        arrayPoints[1] = y;
        return arrayPoints;
    }
    
    public int X()
    {
        return x;
    }
    
    public Point2i setX(int x)
    {
        this.x = x;
        return this;
    }
    
    public int Y()
    {
        return y;
    }
    
    public Point2i setY(int y)
    {
        this.y = y;
        return this;
    }
    
    @Override
    public Point2i clone()
    {
        try
        {
            return (Point2i) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        }
    }
    
    public boolean equals(Point2i p)
    {
        return p.x == x && p.y == y;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Point2i))
            return false;
        Point2i point2i = (Point2i) o;
        return x == point2i.x && y == point2i.y;
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }
    
    @Override
    public String toString()
    {
        return "Point2i(" + "x = " + x + " , y = " + y + " )";
    }
}