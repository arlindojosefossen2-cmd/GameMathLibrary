package br.com.ajf.game.math.library.matrix3;

import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.point3.Point3;

import java.util.Arrays;

public final class Matrix3d extends Matrix3<Double>
{
    public Matrix3d()
    {
        Arrays.fill(getMatrix(), 0.0);
    }
    
    public Matrix3d(Double n1, Double n2, Double n3, Double n4, Double n5, Double n6, Double n7, Double n8, Double n9)
    {
        super(n1, n2, n3, n4, n5, n6, n7, n8, n9);
    }
    
    public Matrix3d(IMatrix3<Double> matrix)
    {
        super(matrix);
    }
    
    public Matrix3d(Matrix3f matrix)
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            getMatrix()[i] = Double.valueOf(matrix.getMatrix()[i]);
        }
    }
    
    public Matrix3d(Double[] matrix)
    {
        super(matrix);
    }
    
    @Override
    public void setIdentity()
    {
    
    }
    
    @Override
    public void setScale(Double aDouble)
    {
    
    }
    
    @Override
    public void setElement(int n, int n2, Double aDouble)
    {
    
    }
    
    @Override
    public void getRow(int n, Point3<Double, Double, Double> v)
    {
    
    }
    
    @Override
    public void getRow(int n, Double[] array)
    {
    
    }
    
    @Override
    public void getColumn(int n, Point3<Double, Double, Double> v)
    {
    
    }
    
    @Override
    public void getColumn(int n, Double[] fArray)
    {
    
    }
    
    @Override
    public Double getElement(int n, int n2)
    {
        return 0.0;
    }
    
    @Override
    public void setRow(int n, Double n1, Double n2, Double n3)
    {
    
    }
    
    @Override
    public void setRow(int n, Point3<Double, Double, Double> v)
    {
    
    }
    
    @Override
    public void setRow(int n, Double[] array)
    {
    
    }
    
    @Override
    public void setColumn(int n, Double n1, Double n2, Double n3)
    {
    
    }
    
    @Override
    public void setColumn(int n, Point3<Double, Double, Double> v)
    {
    
    }
    
    @Override
    public void setColumn(int n, Double[] array)
    {
    
    }
    
    @Override
    public Double getScale()
    {
        return 0.0;
    }
    
    @Override
    public void add(Double aDouble)
    {
    
    }
    
    @Override
    public void add(Double aDouble, IMatrix3<Double> m)
    {
    
    }
    
    @Override
    public void add(IMatrix3<Double> m1, IMatrix3<Double> m2)
    {
    
    }
    
    @Override
    public void add(IMatrix3<Double> m)
    {
    
    }
    
    @Override
    public void sub(IMatrix3<Double> m1, IMatrix3<Double> m2)
    {
    
    }
    
    @Override
    public void sub(IMatrix3<Double> m)
    {
    
    }
    
    @Override
    public void transpose()
    {
    
    }
    
    @Override
    public void transpose(IMatrix3<Double> m)
    {
    
    }
    
    @Override
    public void set(Double[] m)
    {
    
    }
    
    @Override
    public void set(IMatrix3<Double> m)
    {
    
    }
    
    @Override
    public void invert()
    {
    
    }
    
    @Override
    public void invert(IMatrix3<Double> m)
    {
    
    }
    
    @Override
    public void invertGeneral(IMatrix3<Double> m)
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
    public Double determinate()
    {
        return 0.0;
    }
    
    @Override
    public void set(Double aDouble)
    {
    
    }
    
    @Override
    public void rotX(Double aDouble)
    {
    
    }
    
    @Override
    public void rotY(Double y)
    {
    
    }
    
    @Override
    public void rotZ(Double z)
    {
    
    }
    
    @Override
    public void mul(Double aDouble)
    {
    
    }
    
    @Override
    public void mul(Double aDouble, IMatrix3<Double> m)
    {
    
    }
    
    @Override
    public void mul(IMatrix3<Double> m)
    {
    
    }
    
    @Override
    public void mul(IMatrix3<Double> m1, IMatrix3<Double> m2)
    {
    
    }
    
    @Override
    public void mulAndNormalize(IMatrix3<Double> m1, IMatrix3<Double> m2)
    {
    
    }
    
    @Override
    public void mulAndNormalize(IMatrix3<Double> m)
    {
    
    }
    
    @Override
    public void mulAndTransposeBoth(IMatrix3<Double> m1, IMatrix3<Double> m2)
    {
    
    }
    
    @Override
    public void mulAndTransposeRight(IMatrix3<Double> m1, IMatrix3<Double> m2)
    {
    
    }
    
    @Override
    public void mulAndTransposeLeft(IMatrix3<Double> m1, IMatrix3<Double> m2)
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
    public void normalize(IMatrix3<Double> m)
    {
    
    }
    
    @Override
    public void normalizeCP(IMatrix3<Double> m)
    {
    
    }
    
    @Override
    public boolean epsilonEquals(IMatrix3<Double> m, Double aDouble)
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
    public void negate(IMatrix3<Double> m)
    {
    
    }
    
    @Override
    public void transform(IPoint3<Double, Double, Double> p1, IPoint3<Double, Double, Double> p2)
    {
    
    }
    
    @Override
    public void getScaledRotate(double[] dArray, double[] dArray2)
    {
    
    }
}