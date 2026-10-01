package br.com.ajf.game.math.library.tuples;

import java.io.*;

public final class ITuplesUtils
{
    private ITuplesUtils()
    {
    
    }
    
    @SuppressWarnings("unchecked")
    public static <X> X read(String path)
    {
        try
        {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path));
            X obj = (X)stream.readObject();
            stream.close();
            return obj;
        }
        catch (IOException | ClassNotFoundException e)
        {
            return null;
        }
    }
    
    public static <X> boolean save(ITuple2<X> t, String path)
    {
        try
        {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path));
            stream.writeObject(t);
            stream.close();
            return true;
        }
        catch (IOException e)
        {
            return false;
        }
    }
    public static <X> boolean save(ITuple3<X> t, String path)
    {
        try
        {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path));
            stream.writeObject(t);
            stream.close();
            return true;
        }
        catch (IOException e)
        {
            return false;
        }
    }
    
    public static <X> boolean save(ITuple4<X> t, String path)
    {
        try
        {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path));
            stream.writeObject(t);
            stream.close();
            return true;
        }
        catch (IOException e)
        {
            return false;
        }
    }
}