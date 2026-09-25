package br.com.ajf.game.math.library.matrix3;

import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.point3.Point3;

import java.util.Arrays;

public final class Matrix3f extends Matrix3<Float>
{
    public Matrix3f()
    {
        Arrays.fill(getMatrix(), 0.0f);
    }
    
    public Matrix3f(Float n1, Float n2, Float n3, Float n4, Float n5, Float n6, Float n7, Float n8, Float n9)
    {
        super(n1, n2, n3, n4, n5, n6, n7, n8, n9);
    }
    
    public Matrix3f(IMatrix3<Float> matrix)
    {
        super(matrix);
    }
    
    public Matrix3f(Matrix3d matrix)
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            getMatrix()[i] = Float.valueOf(String.valueOf(matrix.getMatrix()[i]));
        }
    }
    
    public Matrix3f(Float[] matrix)
    {
        super(matrix);
    }
    
    @Override
    public void setIdentity()
    {
    
    }
    
    @Override
    public void setScale(Float aFloat)
    {
    
    }
    
    @Override
    public void setElement(int n, int n2, Float aFloat)
    {
    
    }
    
    @Override
    public void getRow(int n, Point3<Float, Float, Float> v)
    {
    
    }
    
    @Override
    public void getRow(int n, Float[] array)
    {
    
    }
    
    @Override
    public void getColumn(int n, Point3<Float, Float, Float> v)
    {
    
    }
    
    @Override
    public void getColumn(int n, Float[] fArray)
    {
    
    }
    
    @Override
    public Float getElement(int n, int n2)
    {
        return 0f;
    }
    
    @Override
    public void setRow(int n, Float n1, Float n2, Float n3)
    {
    
    }
    
    @Override
    public void setRow(int n, Point3<Float, Float, Float> v)
    {
    
    }
    
    @Override
    public void setRow(int n, Float[] array)
    {
    
    }
    
    @Override
    public void setColumn(int n, Float n1, Float n2, Float n3)
    {
    
    }
    
    @Override
    public void setColumn(int n, Point3<Float, Float, Float> v)
    {
    
    }
    
    @Override
    public void setColumn(int n, Float[] array)
    {
    
    }
    
    @Override
    public Float getScale()
    {
        return 0f;
    }
    
    @Override
    public void add(Float aFloat)
    {
    
    }
    
    @Override
    public void add(Float aFloat, IMatrix3<Float> m)
    {
    
    }
    
    @Override
    public void add(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
    
    }
    
    @Override
    public void add(IMatrix3<Float> m)
    {
    
    }
    
    @Override
    public void sub(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
    
    }
    
    @Override
    public void sub(IMatrix3<Float> m)
    {
    
    }
    
    @Override
    public void transpose()
    {
    
    }
    
    @Override
    public void transpose(IMatrix3<Float> m)
    {
    
    }
    
    @Override
    public void set(Float[] m)
    {
    
    }
    
    @Override
    public void set(IMatrix3<Float> m)
    {
    
    }
    
    @Override
    public void invert()
    {
    
    }
    
    @Override
    public void invert(IMatrix3<Float> m)
    {
    
    }
    
    @Override
    public void invertGeneral(IMatrix3<Float> m)
    {
    
    }
    
    @Override
    public boolean luDecomposition(double[] dArray, int[] nArray)
    {
        return false;
    }
    
    @Override
    public void luBackSubstitution(double[] dArray, int[] nArray, double[] dArray2)
    {
    
    }
    
    @Override
    public Float determinate()
    {
        return 0f;
    }
    
    @Override
    public void set(Float aFloat)
    {
    
    }
    
    @Override
    public void rotX(Float aFloat)
    {
    
    }
    
    @Override
    public void rotY(Float y)
    {
    
    }
    
    @Override
    public void rotZ(Float z)
    {
    
    }
    
    @Override
    public void mul(Float aFloat)
    {
    
    }
    
    @Override
    public void mul(Float aFloat, IMatrix3<Float> m)
    {
    
    }
    
    @Override
    public void mul(IMatrix3<Float> m)
    {
    
    }
    
    @Override
    public void mul(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
    
    }
    
    @Override
    public void mulAndNormalize(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
    
    }
    
    @Override
    public void mulAndNormalize(IMatrix3<Float> m)
    {
    
    }
    
    @Override
    public void mulAndTransposeBoth(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
    
    }
    
    @Override
    public void mulAndTransposeRight(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
    
    }
    
    @Override
    public void mulAndTransposeLeft(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
    
    }
    
    @Override
    public void normalize()
    {
    
    }
    
    @Override
    public void normalizeCP()
    {
    
    }
    
    @Override
    public void normalize(IMatrix3<Float> m)
    {
    
    }
    
    @Override
    public void normalizeCP(IMatrix3<Float> m)
    {
    
    }
    
    @Override
    public boolean epsilonEquals(IMatrix3<Float> m, Float aFloat)
    {
        return false;
    }
    
    @Override
    public void setZero()
    {
    
    }
    
    @Override
    public void negate()
    {
    
    }
    
    @Override
    public void negate(IMatrix3<Float> m)
    {
    
    }
    
    @Override
    public void transform(IPoint3<Float, Float, Float> p1, IPoint3<Float, Float, Float> p2)
    {
    
    }
    
    @Override
    public void getScaledRotate(double[] dArray, double[] dArray2)
    {
    
    }
}