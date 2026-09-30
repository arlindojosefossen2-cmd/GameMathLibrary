package br.com.ajf.game.math.library.matrix4;

import br.com.ajf.game.math.library.matrix3.IMatrix3;
import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.point4.IPoint4;

import java.util.Arrays;
import java.util.Objects;

public abstract class Matrix4<X> implements IMatrix4<X>
{
    @SuppressWarnings("unchecked")
    private X[][] matrix = (X[][]) new Object[4][4];
    
    public Matrix4()
    {
    
    }
    
    public Matrix4(X[] array)
    {
        if(array == null || array.length < 16)
        {
            return;
        }
        
        int index = 0;
        
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                getMatrix()[i][j] = array[index++];
            }
        }
    }
    
    public Matrix4(IMatrix4<X> m)
    {
        this.setMatrix(m.getMatrix());
    }
    
    public Matrix4(X[][] matrix)
    {
        this.matrix = matrix;
    }
    
    @Override
    public void set(IMatrix4<X> m)
    {
        setMatrix(m.getMatrix());
    }
    
    @Override
    public void invert()
    {
        invertGeneral(this);
    }
    
    @Override
    public void invert(IMatrix4<X> m)
    {
        invertGeneral(m);
    }
    
    @Override
    public void transpose()
    {
        X v = getM10();
        setM10(getM01());
        setM01(v);
        v = getM20();
        setM20(getM02());
        setM02(v);
        v = getM30();
        setM30(getM03());
        setM03(v);
        v = getM21();
        setM21(getM12());
        setM12(v);
        v = getM31();
        setM31(getM13());
        setM13(v);
        v = getM32();
        setM32(getM23());
        setM23(v);
    }
    
    @Override
    public void transpose(IMatrix4<X> m)
    {
        if(this != m)
        {
            setM00(m.getM00());
            setM01(m.getM10());
            setM02(m.getM20());
            setM03(m.getM30());
            setM10(m.getM01());
            setM11(m.getM11());
            setM12(m.getM21());
            setM13(m.getM31());
            setM20(m.getM02());
            setM21(m.getM12());
            setM22(m.getM22());
            setM23(m.getM32());
            setM30(m.getM03());
            setM31(m.getM13());
            setM32(m.getM23());
            setM33(m.getM33());
        }
        else
        {
            transpose();
        }
    }
    
    @Override
    public void setTranslation(IPoint3<X> v)
    {
        setM03(v.x());
        setM13(v.y());
        setM23(v.z());
    }
    
    @Override
    public void set(X[] array)
    {
        if(array == null || array.length < 16)
        {
            return;
        }
        
        int index = 0;
        
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                getMatrix()[i][j] = array[index++];
            }
        }
//        if(array == null || array.length < 16)
//        {
//            return;
//        }
//
//        setM00(array[0]);
//        setM01(array[1]);
//        setM02(array[2]);
//        setM03(array[3]);
//        setM10(array[4]);
//        setM11(array[5]);
//        setM12(array[6]);
//        setM13(array[7]);
//        setM20(array[8]);
//        setM21(array[9]);
//        setM22(array[10]);
//        setM23(array[11]);
//        setM30(array[12]);
//        setM31(array[13]);
//        setM32(array[14]);
//        setM33(array[15]);
    }
    
    @Override
    public void get(IPoint3<X> v)
    {
        v.set(getM03(),getM13(),getM23());
    }
    
    @Override
    public void getRotationScale(IMatrix3<X> m)
    {
        m.setM00(getM00());
        m.setM01(getM01());
        m.setM02(getM02());
        m.setM10(getM10());
        m.setM11(getM11());
        m.setM12(getM12());
        m.setM20(getM20());
        m.setM21(getM21());
        m.setM22(getM22());
    }
    
    @Override
    public void setRotationScale(IMatrix3<X> m)
    {
        setM00(m.getM00());
        setM01(m.getM01());
        setM02(m.getM02());
        setM10(m.getM10());
        setM11(m.getM11());
        setM12(m.getM12());
        setM20(m.getM20());
        setM21(m.getM21());
        setM22(m.getM22());
    }
    
    @Override
    public void setElement(int n1, int n2, X x)
    {
        if(n1 < 0 || n1 >= matrix.length || n2 < 0 || n2 >= matrix[0].length || x == null)
        {
            return;
        }
        matrix[n1][n2] = x;
    }
    
    @Override
    public X getElement(int n1, int n2)
    {
        if(n1 < 0 || n1 >= matrix.length || n2 < 0 || n2 >= matrix[0].length)
        {
            return null;
        }
        return matrix[n1][n2];
    }
    
    @Override
    public void getRow(int n, IPoint4<X> v)
    {
        if(n < 0 || n >= matrix.length || v == null)
        {
            return;
        }
        v.set(matrix[n][0],matrix[n][1],matrix[n][2],matrix[n][3]);
    }
    
    @Override
    public void getRow(int n,X[] array)
    {
        if(n < 0 || n >= matrix.length || array == null || array.length < 4)
        {
            return;
        }
        array[0] = matrix[n][0];
        array[1] = matrix[n][1];
        array[2] = matrix[n][2];
        array[3] = matrix[n][3];
    }
    
    @Override
    public void getColumn(int n, IPoint4<X> v)
    {
        if(n < 0 || n >= matrix.length || v == null)
        {
            return;
        }
        v.set(matrix[0][n],matrix[1][n],matrix[2][n],matrix[3][n]);
    }
    
    @Override
    public void getColumn(int n,X[] array)
    {
        if(n < 0 || n >= matrix.length || array == null || array.length < 4)
        {
            return;
        }
        array[0] = matrix[0][n];
        array[1] = matrix[1][n];
        array[2] = matrix[2][n];
        array[3] = matrix[3][n];
    }
    
    @Override
    public void setRow(int n, X x, X y, X z, X w)
    {
        if(n < 0 || n >= matrix.length || x == null || y == null || z == null || w == null)
        {
            return;
        }
        
        matrix[n][0] = x;
        matrix[n][1] = y;
        matrix[n][2] = z;
        matrix[n][3] = w;
    }
    
    @Override
    public void setRow(int n, IPoint4<X> v)
    {
        if(v == null)
        {
            return;
        }
        setRow(n,v.x(),v.y(),v.z(),v.w());
    }
    
    @Override
    public void setRow(int n, X[] array)
    {
        if(array == null || array.length < 4)
        {
            return;
        }
        setRow(n,array[0], array[1],array[2],array[3]);
    }
    
    @Override
    public void setColumn(int n, X x, X y, X z, X w)
    {
        if(n < 0 || n >= matrix.length || x == null || y == null || z == null || w == null)
        {
            return;
        }
        
        matrix[0][n] = x;
        matrix[1][n] = y;
        matrix[2][n] = z;
        matrix[3][n] = w;
    }
    
    @Override
    public void setColumn(int n, IPoint4<X> v)
    {
        if(v == null)
        {
            return;
        }
        
        setColumn(n,v.x(),v.y(),v.z(),v.w());
    }
    
    @Override
    public void setColumn(int n, X[] array)
    {
        if(array == null || array.length < 4)
        {
            return;
        }
        setColumn(n,array[0],array[1],array[2],array[3]);
    }
    
    @SuppressWarnings("unchecked")
    public IMatrix4<X> clone()
    {
        try
        {
            return (IMatrix4<X>) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public boolean equals(IMatrix4<X> m)
    {
        if(m == null)
        {
            return false;
        }
        
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                if(getMatrix()[i][j] != m.getMatrix()[i][j])
                {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    @Override
    public String toString()
    {
        String[] split = getClass().getName().split("\\.");
        
        StringBuilder name = new StringBuilder(split[split.length - 1] + "\n{ ");
        
        for (X[] xes : matrix)
        {
            for (int j = 0; j < xes.length; j++)
            {
                if (xes.length - 1 == j)
                {
                    name.append("\t").append(xes[j]);
                }
                else
                {
                    name.append("\t").append(xes[j]).append(" , ");
                }
            }
            name.append("\n");
        }
        name.append("\n}");
        
        return name.toString();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Matrix4<?> matrix4))
            return false;
        return Objects.deepEquals(getMatrix(), matrix4.getMatrix());
    }
    
    @Override
    public int hashCode()
    {
        return Arrays.deepHashCode(getMatrix());
    }
    
    public void setMatrix(X[][] matrix)
    {
        this.matrix = matrix;
    }
    
    public X[][] getMatrix()
    {
        return matrix;
    }
    
    @Override
    public X getM00()
    {
        return matrix[0][0];
    }
    
    @Override
    public void setM00(X v)
    {
        matrix[0][0] = v;
    }
    
    @Override
    public X getM01()
    {
        return matrix[0][1];
    }
    
    @Override
    public void setM01(X v)
    {
        matrix[0][1] = v;
    }
    
    @Override
    public X getM02()
    {
        return matrix[0][2];
    }
    
    @Override
    public void setM02(X v)
    {
        matrix[0][2] = v;
    }
    
    @Override
    public X getM10()
    {
        return matrix[1][0];
    }
    
    @Override
    public void setM10(X v)
    {
        matrix[1][0] = v;
    }
    
    @Override
    public X getM11()
    {
        return matrix[1][1];
    }
    
    @Override
    public void setM11(X v)
    {
        matrix[1][1] = v;
    }
    
    @Override
    public X getM12()
    {
        return matrix[1][2];
    }
    
    @Override
    public void setM12(X v)
    {
        matrix[1][2] = v;
    }
    
    @Override
    public X getM20()
    {
        return matrix[2][0];
    }
    
    @Override
    public void setM20(X v)
    {
        matrix[2][0] = v;
    }
    
    @Override
    public X getM21()
    {
        return matrix[2][1];
    }
    
    @Override
    public void setM21(X v)
    {
        matrix[2][1] = v;
    }
    
    @Override
    public X getM22()
    {
        return matrix[2][2];
    }
    
    @Override
    public void setM22(X v)
    {
        matrix[2][2] = v;
    }
    
    @Override
    public X getM03()
    {
        return matrix[0][3];
    }
    
    @Override
    public void setM03(X v)
    {
        matrix[0][3] = v;
    }
    
    @Override
    public X getM13()
    {
        return matrix[1][3];
    }
    
    @Override
    public void setM13(X v)
    {
        matrix[1][3] = v;
    }
    
    @Override
    public X getM23()
    {
        return matrix[2][3];
    }
    
    @Override
    public void setM23(X v)
    {
        matrix[2][3] = v;
    }
    
    @Override
    public X getM30()
    {
        return matrix[3][0];
    }
    
    @Override
    public void setM30(X v)
    {
        matrix[3][0] = v;
    }
    
    @Override
    public X getM31()
    {
        return matrix[3][1];
    }
    
    @Override
    public void setM31(X v)
    {
        matrix[3][1] = v;
    }
    
    @Override
    public X getM32()
    {
        return matrix[3][2];
    }
    
    @Override
    public void setM32(X v)
    {
        matrix[3][2] = v;
    }
    
    @Override
    public X getM33()
    {
        return matrix[3][3];
    }
    
    @Override
    public void setM33(X v)
    {
        matrix[3][3] = v;
    }
}