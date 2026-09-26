package br.com.ajf.game.math.library.matrix3;

import java.util.Arrays;
import java.util.Objects;

public abstract class Matrix3<X> implements IMatrix3<X>
{
    @SuppressWarnings("unchecked")
    private X[][] matrix = (X[][])new Object[3][3];
    
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
    
    public Matrix3(X[][] matrix)
    {
        this.matrix = matrix;
    }
    
    public X[][] getMatrix()
    {
        return matrix;
    }
    
    public void setMatrix(X[][] matrix)
    {
        this.matrix = matrix;
    }
    
    public void set(X n1,X n2,X n3,X n4,X n5,X n6,X n7,X n8,X n9)
    {
        matrix[0][0] = n1;
        matrix[0][1] = n2;
        matrix[0][2] = n3;
        matrix[1][0] = n4;
        matrix[1][1] = n5;
        matrix[1][2] = n6;
        matrix[2][0] = n7;
        matrix[2][1] = n8;
        matrix[2][2] = n9;
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
            for (int j = 0; j < this.matrix[i].length; j++)
            {
                if(this.matrix[i][j] == matrix.getMatrix()[i][j])
                {
                    checked = true;
                }
                else
                {
                   return false;
                }
            }
        }
        return checked;
    }
    
    @Override
    public X getM00()
    {
        return matrix[0][0];
    }
    
    @Override
    public void setM00(X n)
    {
        matrix[0][0] = n;
    }
    
    @Override
    public X getM01()
    {
        return matrix[0][1];
    }
    
    @Override
    public void setM01(X n)
    {
        matrix[0][1] = n;
    }
    
    @Override
    public X getM02()
    {
        return matrix[0][2];
    }
    
    @Override
    public void setM02(X n)
    {
        matrix[0][2] = n;
    }
    
    @Override
    public X getM10()
    {
        return matrix[1][0];
    }
    
    @Override
    public void setM10(X n)
    {
        matrix[1][0] = n;
    }
    
    @Override
    public X getM11()
    {
        return matrix[1][1];
    }
    
    @Override
    public void setM11(X n)
    {
        matrix[1][1] = n;
    }
    
    @Override
    public X getM12()
    {
        return matrix[1][2];
    }
    
    @Override
    public void setM12(X n)
    {
        matrix[1][2] = n;
    }
    
    @Override
    public X getM20()
    {
        return matrix[2][0];
    }
    
    @Override
    public void setM20(X n)
    {
        matrix[2][0] = n;
    }
    
    @Override
    public X getM21()
    {
        return matrix[2][1];
    }
    
    @Override
    public void setM21(X n)
    {
        matrix[2][1] = n;
    }
    
    @Override
    public X getM22()
    {
        return matrix[2][2];
    }
    
    @Override
    public void setM22(X n)
    {
        matrix[2][2] = n;
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
        return Arrays.deepHashCode(getMatrix());
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        
        StringBuilder name = new StringBuilder(split[split.length - 1] + "\n{ ");
        
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if(matrix[i].length - 1 == j)
                {
                    name.append("\t").append(matrix[i][j]);
                }
                else
                {
                    name.append("\t").append(matrix[i][j]).append(" , ");
                }
            }
           name.append("\n");
        }
        name.append("\n}");
        
        return name.toString();
    }
}