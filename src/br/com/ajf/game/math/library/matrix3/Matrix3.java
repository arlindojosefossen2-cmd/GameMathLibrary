package br.com.ajf.game.math.library.matrix3;

import java.util.Arrays;
import java.util.Objects;

public abstract class Matrix3<X> implements IMatrix3<X>
{
    @SuppressWarnings("unchecked")
    private X[] matrix = (X[])new Object[9];
    
    public Matrix3()
    {
    
    }
    
    public Matrix3(X n1,X n2,X n3,X n4,X n5,X n6,X n7,X n8,X n9)
    {
        set(n1,n2,n3,n4,n5,n6,n7,n8,n9);
    }
    
    public Matrix3(IMatrix3<X> matrix)
    {
        setMatrix(matrix.getMatrix());
    }
    
    public Matrix3(X[] matrix)
    {
        this.matrix = matrix;
    }
    
    public X[] getMatrix()
    {
        return matrix;
    }
    
    public void setMatrix(X[] matrix)
    {
        this.matrix = matrix;
    }
    
    public void set(X n1,X n2,X n3,X n4,X n5,X n6,X n7,X n8,X n9)
    {
        matrix[0] = n1;
        matrix[1] = n2;
        matrix[2] = n3;
        matrix[3] = n4;
        matrix[4] = n5;
        matrix[5] = n6;
        matrix[6] = n7;
        matrix[7] = n8;
        matrix[8] = n9;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public IMatrix3<X> clone()
    {
        try
        {
            return (IMatrix3<X>) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public  boolean equals(IMatrix3<X> matrix)
    {
        if(matrix == null)
        {
            return false;
        }
        
        boolean checked = false;
        
        for (int i = 0; i < this.matrix.length; i++)
        {
            if(this.matrix[i] == matrix.getMatrix()[i])
            {
                checked = true;
            }
            else
            {
                checked = false;
                break;
            }
        }
        return checked;
    }
    
    @Override
    public X getM00()
    {
        return matrix[0];
    }
    
    @Override
    public void setM00(X n)
    {
        matrix[0] = n;
    }
    
    @Override
    public X getM01()
    {
        return matrix[1];
    }
    
    @Override
    public void setM01(X n)
    {
        matrix[1] = n;
    }
    
    @Override
    public X getM02()
    {
        return matrix[2];
    }
    
    @Override
    public void setM02(X n)
    {
        matrix[2] = n;
    }
    
    @Override
    public X getM10()
    {
        return matrix[3];
    }
    
    @Override
    public void setM10(X n)
    {
        matrix[3] = n;
    }
    
    @Override
    public X getM11()
    {
        return matrix[4];
    }
    
    @Override
    public void setM11(X n)
    {
        matrix[4] = n;
    }
    
    @Override
    public X getM12()
    {
        return matrix[5];
    }
    
    @Override
    public void setM12(X n)
    {
        matrix[5] = n;
    }
    
    @Override
    public X getM20()
    {
        return matrix[6];
    }
    
    @Override
    public void setM20(X n)
    {
        matrix[6] = n;
    }
    
    @Override
    public X getM21()
    {
        return matrix[7];
    }
    
    @Override
    public void setM21(X n)
    {
        matrix[7] = n;
    }
    
    @Override
    public X getM22()
    {
        return matrix[8];
    }
    
    @Override
    public void setM22(X n)
    {
        matrix[8] = n;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Matrix3<?> matrix3))
            return false;
        return Objects.deepEquals(getMatrix(), matrix3.getMatrix());
    }
    
    @Override
    public int hashCode()
    {
        return Arrays.hashCode(getMatrix());
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        
        StringBuilder name = new StringBuilder(split[split.length - 1] + "\n{ ");
        
        for (int i = 0; i < matrix.length; i++)
        {
           if(i % 3 == 0)
           {
               name.append("\n");
           }
           
           if(matrix.length - 1 == i)
           {
               name.append("\t").append(matrix[i]);
           }
           else
           {
               name.append("\t").append(matrix[i]).append(" , ");
           }
        }
        name.append("\n}");
        
        return name.toString();
    }
}