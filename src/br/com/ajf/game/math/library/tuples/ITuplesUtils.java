package br.com.ajf.game.math.library.tuples;

import br.com.ajf.game.math.library.tuples.tuple2.ITuple2;
import br.com.ajf.game.math.library.tuples.tuple3.ITuple3;
import br.com.ajf.game.math.library.tuples.tuple4.ITuple4;

import java.io.*;

public final class ITuplesUtils
{
    @SuppressWarnings("unchecked")
    public <X> X read(String path)
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
    
    public <X> boolean save(ITuple2<X> t, String path)
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
    public <X> boolean save(ITuple3<X> t, String path)
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
    
    public <X> boolean save(ITuple4<X> t, String path)
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