package br.com.ajf.game.math.library.matrix3;

import br.com.ajf.game.math.library.axisangle4.AxisAngle4;
import br.com.ajf.game.math.library.quat4.Quat4d;
import br.com.ajf.game.math.library.quat4.Quat4f;
import br.com.ajf.game.math.library.point3.IPoint3;

import java.util.Arrays;
import java.util.Objects;

public final class Matrix3f extends Matrix3<Float>
{
    public Matrix3f()
    {
        for (int i = 0; i < this.getMatrix().length; i++)
        {
            Arrays.fill(this.getMatrix()[i], 0.0f);
        }
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
        for (int i = 0; i < this.getMatrix().length; i++)
        {
            for (int j = 0; j < this.getMatrix()[i].length; j++)
            {
                this.getMatrix()[i][j] = Float.parseFloat(String.valueOf(matrix.getMatrix()[i][j]));
            }
        }
    }
    
    public Matrix3f(Float[][] matrix)
    {
        super(matrix);
    }
    
    @Override
    public void setIdentity()
    {
        for (int r = 0; r < getMatrix().length; r++)
        {
            for (int c = 0; c < getMatrix()[r].length; c++)
            {
                getMatrix()[r][c] = r == c ? 1.0f : 0.0f;
            }
        }
    }
    
    @Override
    public void setScale(Float s)
    {
        if(s == null)
        {
            return;
        }
        
        for (int r = 0; r < getMatrix().length; r++)
        {
            for (int c = 0; c < getMatrix()[r].length; c++)
            {
                    getMatrix()[r][c] *= s;
            }
        }
    }
    
    @Override
    public void setElement(int n, int n2, Float v)
    {
        if(n < 0 || n >= getMatrix().length || n2 < 0 || n2 >= getMatrix()[0].length || v == null)
        {
            return;
        }
       getMatrix()[n][n2] = v;
    }
    
    @Override
    public void getRow(int r, IPoint3<Float> v)
    {
        if(r < 0 || r >= getMatrix().length || v == null)
        {
            return;
        }
        v.set(getMatrix()[r][0], getMatrix()[r][1], getMatrix()[r][2]);
    }
    
    @Override
    public void getRow(int n, Float[] array)
    {
        if(n < 0 || n >= getMatrix().length || array == null || array.length < 3)
        {
            return;
        }
    
        array[0] = getMatrix()[n][0];
        array[1] = getMatrix()[n][1];
        array[2] = getMatrix()[n][2];
    }
    
    @Override
    public void getColumn(int c, IPoint3<Float> v)
    {
        if(c < 0 || c >= getMatrix().length || v == null)
        {
            return;
        }
        v.set(getMatrix()[0][c], getMatrix()[1][c], getMatrix()[2][c]);
    }
    
    @Override
    public void getColumn(int c, Float[] array)
    {
        if(c < 0 || c >= getMatrix().length || array == null || array.length < 3)
        {
            return;
        }
        array[0] = getMatrix()[0][c];
        array[1] = getMatrix()[1][c];
        array[2] = getMatrix()[2][c];
    }
    
    @Override
    public Float getElement(int n, int n2)
    {
        if(n >= getMatrix().length || n < 0 || n2 >= getMatrix()[0].length || n2 < 0)
        {
            return null;
        }
        return getMatrix()[n][n2];
    }
    
    @Override
    public void setRow(int n, Float n1, Float n2, Float n3)
    {
        if(n < 0 || n >= getMatrix().length || n1 == null || n2 == null || n3 == null)
        {
            return;
        }
        getMatrix()[n][0] = n1;
        getMatrix()[n][1] = n2;
        getMatrix()[n][2] = n3;
    }
    
    @Override
    public void setRow(int n, IPoint3<Float> v)
    {
        if(v == null)
        {
            return;
        }
        setRow(n,v.x(),v.y(),v.z());
    }
    
    @Override
    public void setRow(int n, Float[] array)
    {
        if(array == null || array.length < 3)
        {
            return;
        }
        setRow(n,array[0],array[1],array[2]);
    }
    
    @Override
    public void setColumn(int n, Float n1, Float n2, Float n3)
    {
        if(n < 0 || n > getMatrix().length || n1 == null || n2 == null || n3 == null)
        {
            return;
        }
        getMatrix()[0][n] = n1;
        getMatrix()[1][n] = n2;
        getMatrix()[2][n] = n3;
    }
    
    @Override
    public void setColumn(int n, IPoint3<Float> v)
    {
        if(v == null)
        {
            return;
        }
        setColumn(n,v.x(),v.y(),v.z());
    }
    
    @Override
    public void setColumn(int n, Float[] array)
    {
        if(array == null || array.length < 3)
        {
            return;
        }
        setColumn(n,array[0],array[1],array[2]);
    }
    
    @Override
    public Float getScale()
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaledRotate(dArray2,dArray);
        return (float)Matrix3d.max3(dArray2);
    }
    
    @Override
    public void add(Float v)
    {
        for (int r = 0; r < getMatrix().length; r++)
        {
            for (int c = 0; c < getMatrix()[r].length; c++)
            {
                getMatrix()[r][c] += v;
            }
        }
    }
    
    @Override
    public void add(Float v, IMatrix3<Float> m)
    {
        for (int r = 0; r < getMatrix().length; r++)
        {
            for (int c = 0; c < getMatrix()[r].length; c++)
            {
                getMatrix()[r][c] = m.getMatrix()[r][c] + v;
            }
        }
    }
    
    @Override
    public void add(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
        for (int r = 0; r < getMatrix().length; r++)
        {
            for (int c = 0; c < getMatrix()[r].length; c++)
            {
                getMatrix()[r][c] = m1.getMatrix()[r][c] + m2.getMatrix()[r][c];
            }
        }
    }
    
    @Override
    public void add(IMatrix3<Float> m)
    {
        for (int r = 0; r < getMatrix().length; r++)
        {
            for (int c = 0; c < getMatrix()[r].length; c++)
            {
                getMatrix()[r][c] += m.getMatrix()[r][c];
            }
        }
    }
    
    @Override
    public void sub(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
        for (int r = 0; r < getMatrix().length; r++)
        {
            for (int c = 0; c < getMatrix()[r].length; c++)
            {
                getMatrix()[r][c] = m1.getMatrix()[r][c] - m2.getMatrix()[r][c];
            }
        }
    }
    
    @Override
    public void sub(IMatrix3<Float> m)
    {
        for (int r = 0; r < getMatrix().length; r++)
        {
            for (int c = 0; c < getMatrix()[r].length; c++)
            {
                getMatrix()[r][c] -= m.getMatrix()[r][c];
            }
        }
    }
    
    @Override
    public void transpose()
    {
        float f = this.getM10();
        this.setM10(this.getM01());
        this.setM01(f);
        f = this.getM20();
        this.setM20(this.getM02());
        this.setM20(f);
        f = this.getM21();
        this.setM21(this.getM12());
        this.setM12(f);
    }
    
    @Override
    public void transpose(IMatrix3<Float> m)
    {
        if(this != m)
        {
            this.setM00(m.getM00());
            this.setM01(m.getM10());
            this.setM02(m.getM20());
            this.setM10(m.getM01());
            this.setM11(m.getM11());
            this.setM12(m.getM21());
            this.setM20(m.getM02());
            this.setM21(m.getM12());
            this.setM22(m.getM22());
        }
        else
        {
            transpose();
        }
    }
    
    @Override
    public void set(Float[][] m)
    {
        if(m == null || m.length < 3 || m[0].length < 3)
        {
            return;
        }
        
        set(    m[0][0],
                m[0][1],
                m[0][2],
                m[1][0],
                m[1][1],
                m[1][2],
                m[2][0],
                m[2][1],
                m[2][2]  );
    }
    
    @Override
    public void set(IMatrix3<Float> m)
    {
        set(m.getMatrix());
    }
    
    public void set(Matrix3d m)
    {
        set(Float.valueOf(String.valueOf(m.getMatrix()[0][0])),
                Float.valueOf(String.valueOf(m.getMatrix()[0][1])),
                Float.valueOf(String.valueOf(m.getMatrix()[0][2])),
                Float.valueOf(String.valueOf(m.getMatrix()[1][0])),
                Float.valueOf(String.valueOf(m.getMatrix()[1][1])),
                Float.valueOf(String.valueOf(m.getMatrix()[1][2])),
                Float.valueOf(String.valueOf(m.getMatrix()[2][0])),
                Float.valueOf(String.valueOf(m.getMatrix()[2][1])),
                Float.valueOf(String.valueOf(m.getMatrix()[2][2]))  );
    }
    
    public static boolean luDecomposition(double[] dArray,int[] nArray)
    {
        int n;
        double[] dArray2 = new double[3];
        int n2 = 0;
        int n3 = 0;
        int n4 = 3;
        while (n4-- != 0) {
            double d = 0.0;
            n = 3;
            while (n-- != 0) {
                double d2 = dArray[n2++];
                if (!((d2 = Math.abs(d2)) > d)) continue;
                d = d2;
            }
            if (d == 0.0) {
                return false;
            }
            dArray2[n3++] = 1.0 / d;
        }
        n = 0;
        for (n4 = 0; n4 < 3; ++n4) {
            double d;
            int n5;
            int n6;
            int n7;
            double d3;
            int n8;
            for (n2 = 0; n2 < n4; ++n2) {
                n8 = n + 3 * n2 + n4;
                d3 = dArray[n8];
                int n9 = n2;
                int n10 = n + 3 * n2;
                n7 = n + n4;
                while (n9-- != 0) {
                    d3 -= dArray[n10] * dArray[n7];
                    ++n10;
                    n7 += 3;
                }
                dArray[n8] = d3;
            }
            double d4 = 0.0;
            n3 = -1;
            for (n2 = n4; n2 < 3; ++n2) {
                double d5 = 0;
                n8 = n + 3 * n2 + n4;
                d3 = dArray[n8];
                n6 = n4;
                n5 = n + 3 * n2;
                n7 = n + n4;
                while (n6-- != 0) {
                    d3 -= dArray[n5] * dArray[n7];
                    ++n5;
                    n7 += 3;
                }
                dArray[n8] = d3;
                d = dArray2[n2] * Math.abs(d3);
                if (!(d5 >= d4)) continue;
                d4 = d;
                n3 = n2;
            }
            
            if (n4 != n3) {
                n6 = 3;
                n5 = n + 3 * n3;
                n7 = n + 3 * n4;
                while (n6-- != 0) {
                    d = dArray[n5];
                    dArray[n5++] = dArray[n7];
                    dArray[n7++] = d;
                }
                dArray2[n3] = dArray2[n4];
            }
            nArray[n4] = n3;
            if (dArray[n + 3 * n4 + n4] == 0.0) {
                return false;
            }
            if (n4 == 2) continue;
            d = 1.0 / dArray[n + 3 * n4 + n4];
            n8 = n + 3 * (n4 + 1) + n4;
            n2 = 2 - n4;
            while (n2-- != 0) {
                int n11 = n8;
                dArray[n11] = dArray[n11] * d;
                n8 += 3;
            }
        }
        return true;
    }
    public static void luBackSubstitution(double[] dArray,int[] nArray,double[] dArray2)
    {
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            int n2;
            int n3 = i;
            int n4 = -1;
            for (int j = 0; j < 3; ++j) {
                int n5 = nArray[n + j];
                double d = dArray2[n3 + 3 * n5];
                dArray2[n3 + 3 * n5] = dArray2[n3 + 3 * j];
                if (n4 >= 0) {
                    n2 = j * 3;
                    for (int k = n4; k <= j - 1; ++k) {
                        d -= dArray[n2 + k] * dArray2[n3 + 3 * k];
                    }
                } else if (d != 0.0) {
                    n4 = j;
                }
                dArray2[n3 + 3 * j] = d;
            }
            n2 = 6;
            int n6 = n3 + 6;
            dArray2[n6] = dArray2[n6] / dArray[n2 + 2];
            dArray2[n3 + 3] = (dArray2[n3 + 3] - dArray[(n2 -= 3) + 2] * dArray2[n3 + 6]) / dArray[n2 + 1];
            dArray2[n3] = (dArray2[n3] - dArray[(n2 -= 3) + 1] * dArray2[n3 + 3] - dArray[n2 + 2] * dArray2[n3 + 6]) / dArray[n2];
        }
    }
    
    @Override
    public void invert()
    {
        invertGeneral(this);
    }
    
    @Override
    public void invert(IMatrix3<Float> m)
    {
        invertGeneral(m);
    }
    
    @Override
    public void invertGeneral(IMatrix3<Float> m)
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[9];
        int[] nArray = new int[3];
        
        dArray[0] = m.getMatrix()[0][0];
        dArray[1] = m.getMatrix()[0][1];
        dArray[2] = m.getMatrix()[0][2];
        dArray[3] = m.getMatrix()[1][0];
        dArray[4] = m.getMatrix()[1][1];
        dArray[5] = m.getMatrix()[1][2];
        dArray[6] = m.getMatrix()[2][0];
        dArray[7] = m.getMatrix()[2][1];
        dArray[8] = m.getMatrix()[2][2];
        
        if(!Matrix3f.luDecomposition(dArray,nArray))
        {
            return;
        }
        
        Arrays.fill(dArray2, 0.0);
        
        dArray2[0] = 1.0;
        dArray2[4] = 1.0;
        dArray2[8] = 1.0;
        
        Matrix3f.luBackSubstitution(dArray,nArray,dArray2);
        
        set((float)dArray2[0],(float)dArray2[1],(float)dArray2[2],(float)dArray2[3],(float)dArray2[4],(float)dArray2[5],(float)dArray2[6],(float)dArray2[7],(float)dArray2[8]);
    }
    
    @Override
    public Float determinate()
    {
        return this.getM00()*(this.getM11()*this.getM22()-this.getM12()*this.getM21())+
               this.getM01()*(this.getM12()*this.getM20()-this.getM10()*this.getM22())+
               this.getM02()*(this.getM10()*this.getM21()-this.getM11()*this.getM20());
    }
    
    @Override
    public void set(Float v)
    {
        set(v,0.0f,0.0f,0.0f,v,0.0f,0.0f,0.0f,v);
    }
    
    @Override
    public void rotX(Float x)
    {
        float v2 = (float)Math.sin(x);
        float v3 = (float)Math.cos(x);
        set(1.0f,0.0f,0.0f,0.0f,v3,-v2,0.0f,v2,v3);
    }
    
    @Override
    public void rotY(Float y)
    {
        float f2 = (float) Math.cos(y);
        float f3 = (float) Math.sin(y);
        set(f2,0.0f,f3,0.0f,1.0f,0.0f,-f3,0.0f,f2);
    }
    
    @Override
    public void rotZ(Float z)
    {
        float f2 = (float) Math.cos(z);
        float f3 = (float) Math.sin(z);
        set(f2,-f3,0.0f,f3,f2,0.0f,0.0f,0.0f,1.0f);
    }
    
    @Override
    public void mul(Float v)
    {
        this.setM00(this.getM00()*v);
        this.setM01(this.getM01()*v);
        this.setM02(this.getM02()*v);
        this.setM10(this.getM10()*v);
        this.setM11(this.getM11()*v);
        this.setM12(this.getM12()*v);
        this.setM20(this.getM20()*v);
        this.setM21(this.getM21()*v);
        this.setM22(this.getM22()*v);
    }
    
    @Override
    public void mul(Float v, IMatrix3<Float> m)
    {
        this.setM00(m.getM00()*v);
        this.setM01(m.getM01()*v);
        this.setM02(m.getM02()*v);
        this.setM10(m.getM10()*v);
        this.setM11(m.getM11()*v);
        this.setM12(m.getM12()*v);
        this.setM20(m.getM20()*v);
        this.setM21(m.getM21()*v);
        this.setM22(m.getM22()*v);
    }
    
    @Override
    public void mul(IMatrix3<Float> matrix3f)
    {
        float f = this.getM00() * matrix3f.getM00() +
                  this.getM01() * matrix3f.getM10() +
                  this.getM02() * matrix3f.getM20();
        float f2 = this.getM00() * matrix3f.getM01() +
                   this.getM01() * matrix3f.getM11() +
                   this.getM02() * matrix3f.getM21();
        float f3 = this.getM00() * matrix3f.getM02() +
                   this.getM01() * matrix3f.getM12() +
                   this.getM02() * matrix3f.getM22();
        float f4 = this.getM10() * matrix3f.getM00() +
                   this.getM11() * matrix3f.getM10() +
                   this.getM12() * matrix3f.getM20();
        float f5 = this.getM10() * matrix3f.getM01() +
                   this.getM11() * matrix3f.getM11() +
                   this.getM12() * matrix3f.getM21();
        float f6 = this.getM10() * matrix3f.getM02() +
                   this.getM11() * matrix3f.getM12() +
                   this.getM12() * matrix3f.getM22();
        float f7 = this.getM20() * matrix3f.getM00() +
                   this.getM21() * matrix3f.getM10() +
                   this.getM22() * matrix3f.getM20();
        float f8 = this.getM20() * matrix3f.getM01() +
                   this.getM21() * matrix3f.getM11() +
                   this.getM22() * matrix3f.getM21();
        float f9 = this.getM20() * matrix3f.getM02() +
                   this.getM21() * matrix3f.getM12() +
                   this.getM22() * matrix3f.getM22();
       set(f,f2,f3,f4,f5,f6,f7,f8,f9);
    }
    
    @Override
    public void mul(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
        if(this != m1 && this != m2)
        {
            this.setM00(m1.getM00() * m2.getM00() +
                       m1.getM01() * m2.getM10() +
                       m1.getM02() * m2.getM20());
            this.setM01(m1.getM00() * m2.getM01() +
                       m1.getM01() * m2.getM11() +
                       m1.getM02() * m2.getM21());
            this.setM02(m1.getM00() * m2.getM02() +
                       m1.getM01() * m2.getM12() +
                       m1.getM02() * m2.getM22());
            this.setM10(m1.getM10() * m2.getM00() +
                       m1.getM11() * m2.getM10() +
                       m1.getM12() * m2.getM20());
            this.setM11(m1.getM10() * m2.getM01() +
                       m1.getM11() * m2.getM11() +
                       m1.getM12() * m2.getM21());
            this.setM12(m1.getM10() * m2.getM02() +
                       m1.getM11() * m2.getM12() +
                       m1.getM12() * m2.getM22());
            this.setM20(m1.getM20() * m2.getM00() +
                       m1.getM21() * m2.getM10() +
                       m1.getM22() * m2.getM20());
            this.setM21(m1.getM20() * m2.getM01() +
                       m1.getM21() * m2.getM11() +
                       m1.getM22() * m2.getM21());
            this.setM22(m1.getM20() * m2.getM02() +
                       m1.getM21() * m2.getM12() +
                       m1.getM22() * m2.getM22());
        }
        else
        {
            m1.mul(m2);
            set(m1);
        }
    }
    
    @Override
    public void mulAndNormalize(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[9];
        double[] dArray3 = new double[3];
        
        m1.mul(m2);
        
        dArray[0] = this.getM00();
        dArray[1] = this.getM01();
        dArray[2] = this.getM02();
        dArray[3] = this.getM10();
        dArray[4] = this.getM11();
        dArray[5] = this.getM12();
        dArray[6] = this.getM20();
        dArray[7] = this.getM21();
        dArray[8] = this.getM22();
        
        Matrix3d.compute_svd(dArray,dArray3,dArray2);
        
        set(Float.valueOf(String.valueOf(dArray2[0])),
                Float.valueOf(String.valueOf(dArray2[1])),
                Float.valueOf(String.valueOf(dArray2[2])),
                Float.valueOf(String.valueOf(dArray2[3])),
                Float.valueOf(String.valueOf(dArray2[4])),
                Float.valueOf(String.valueOf(dArray2[5])),
                Float.valueOf(String.valueOf(dArray2[6])),
                Float.valueOf(String.valueOf(dArray2[7])),
                Float.valueOf(String.valueOf(dArray2[8])));
    }
    
    @Override
    public void mulAndNormalize(IMatrix3<Float> m)
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[9];
        double[] dArray3 = new double[3];
        
        this.mul(m);
        
       dArray[0] = this.getM00();
       dArray[1] = this.getM01();
       dArray[2] = this.getM02();
       dArray[3] = this.getM10();
       dArray[4] = this.getM11();
       dArray[5] = this.getM12();
       dArray[6] = this.getM20();
       dArray[7] = this.getM21();
       dArray[8] = this.getM22();
       
       Matrix3d.compute_svd(dArray,dArray3,dArray2);
       
       set(Float.valueOf(String.valueOf(dArray2[0])),
               Float.valueOf(String.valueOf(dArray2[1])),
               Float.valueOf(String.valueOf(dArray2[2])),
               Float.valueOf(String.valueOf(dArray2[3])),
               Float.valueOf(String.valueOf(dArray2[4])),
               Float.valueOf(String.valueOf(dArray2[5])),
               Float.valueOf(String.valueOf(dArray2[6])),
               Float.valueOf(String.valueOf(dArray2[7])),
               Float.valueOf(String.valueOf(dArray2[8])));
    }
    
    @Override
    public void mulAndTransposeBoth(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
        if(this != m1 && this != m2)
        {
            this.setM00(m1.getM00() * m2.getM00() +
                       m1.getM10() * m2.getM01() +
                       m1.getM20() * m2.getM02());
            this.setM01(m1.getM00() * m2.getM10() +
                       m1.getM10() * m2.getM11() +
                       m1.getM20() * m2.getM12());
            this.setM02(m1.getM00() * m2.getM20() +
                       m1.getM10() * m2.getM21() +
                       m1.getM20() * m2.getM22());
            this.setM10(m1.getM01() * m2.getM00() +
                       m1.getM11() * m2.getM01() +
                       m1.getM21() * m2.getM02());
            this.setM11(m1.getM01() * m2.getM10() +
                       m1.getM11() * m2.getM11() +
                       m1.getM21() * m2.getM12());
            this.setM12(m1.getM01() * m2.getM20() +
                       m1.getM11() * m2.getM21() +
                       m1.getM21() * m2.getM22());
            this.setM20(m1.getM02() * m2.getM00() +
                       m1.getM12() * m2.getM01() +
                       m1.getM22() * m2.getM02());
            this.setM21(m1.getM02() * m2.getM10() +
                       m1.getM12() * m2.getM11() +
                       m1.getM22() * m2.getM12());
            this.setM22(m1.getM02() * m2.getM20() +
                       m1.getM12() * m2.getM21() +
                       m1.getM22() * m2.getM22());
        }
        else
        {
            float f = m1.getM00() * m2.getM00() +
                      m1.getM10() * m2.getM01() +
                      m1.getM20() * m2.getM02();
            float f2 = m1.getM00() * m2.getM10() +
                       m1.getM10() * m2.getM11() +
                       m1.getM20() * m2.getM12();
            float f3 = m1.getM00() * m2.getM20() +
                       m1.getM10() * m2.getM21() +
                       m1.getM20() * m2.getM22();
            float f4 = m1.getM01() * m2.getM00() +
                       m1.getM11() * m2.getM01() +
                       m1.getM21() * m2.getM02();
            float f5 = m1.getM01() * m2.getM10() +
                       m1.getM11() * m2.getM11() +
                       m1.getM21() * m2.getM12();
            float f6 = m1.getM01() * m2.getM20() +
                       m1.getM11() * m2.getM21() +
                       m1.getM21() * m2.getM22();
            float f7 = m1.getM02() * m2.getM00() +
                       m1.getM12() * m2.getM01() +
                       m1.getM22() * m2.getM02();
            float f8 = m1.getM02() * m2.getM10() +
                       m1.getM12() * m2.getM11() +
                       m1.getM22() * m2.getM12();
            float f9 = m1.getM02() * m2.getM20() +
                       m1.getM12() * m2.getM21() +
                       m1.getM22() * m2.getM22();
            set(f,f2,f3,f4,f5,f6,f7,f8,f9);
        }
    }
    
    @Override
    public void mulAndTransposeRight(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
        if(this != m1 && this != m2)
        {
            this.setM00(m1.getM00() * m2.getM00() +
                        m1.getM01() * m2.getM01() +
                        m1.getM02() * m2.getM02());
            this.setM01(m1.getM00() * m2.getM10() +
                        m1.getM01() * m2.getM11() +
                        m1.getM20() * m2.getM12());
            this.setM02(m1.getM00() * m2.getM20() +
                        m1.getM01() * m2.getM21() +
                        m1.getM02() * m2.getM22());
            this.setM10(m1.getM10() * m2.getM00() +
                        m1.getM11() * m2.getM01() +
                        m1.getM12() * m2.getM02());
            this.setM11(m1.getM10() * m2.getM10() +
                        m1.getM11() * m2.getM11() +
                        m1.getM12() * m2.getM12());
            this.setM12(m1.getM10() * m2.getM20() +
                        m1.getM11() * m2.getM21() +
                        m1.getM12() * m2.getM22());
            this.setM20(m1.getM20() * m2.getM00() +
                        m1.getM21() * m2.getM01() +
                        m1.getM22() * m2.getM02());
            this.setM21(m1.getM20() * m2.getM10() +
                        m1.getM21() * m2.getM11() +
                        m1.getM22() * m2.getM12());
            this.setM22(m1.getM20() * m2.getM20() +
                        m1.getM21() * m2.getM21() +
                        m1.getM22() * m2.getM22());
        }
        else
        {
            float f = m1.getM00() * m2.getM00() +
                      m1.getM01() * m2.getM01() +
                      m1.getM02() * m2.getM02();
            float f2 = m1.getM00() * m2.getM10() +
                       m1.getM01() * m2.getM11() +
                       m1.getM02() * m2.getM12();
            float f3 = m1.getM00() * m2.getM20() +
                       m1.getM01() * m2.getM21() +
                       m1.getM02() * m2.getM22();
            float f4 = m1.getM10() * m2.getM00() +
                       m1.getM11() * m2.getM01() +
                       m1.getM12() * m2.getM02();
            float f5 = m1.getM10() * m2.getM10() +
                       m1.getM11() * m2.getM11() +
                       m1.getM12() * m2.getM12();
            float f6 = m1.getM10() * m2.getM20() +
                       m1.getM11() * m2.getM21() +
                       m1.getM12() * m2.getM22();
            float f7 = m1.getM20() * m2.getM00() +
                       m1.getM21() * m2.getM01() +
                       m1.getM22() * m2.getM02();
            float f8 = m1.getM20() * m2.getM10() +
                       m1.getM21() * m2.getM11() +
                       m1.getM22() * m2.getM12();
            float f9 = m1.getM20() * m2.getM20() +
                       m1.getM21() * m2.getM21() +
                       m1.getM22() * m2.getM22();
            set(f,f2,f3,f4,f5,f6,f7,f8,f9);
        }
    }
    
    @Override
    public void mulAndTransposeLeft(IMatrix3<Float> m1, IMatrix3<Float> m2)
    {
        if(this != m1 && this != m2)
        {
            this.setM00(m1.getM00() * m2.getM00() +
                        m1.getM10() * m2.getM10() +
                        m1.getM20() * m2.getM20());
            this.setM01(m1.getM00() * m2.getM01() +
                        m1.getM10() * m2.getM11() +
                        m1.getM20() * m2.getM21());
            this.setM02(m1.getM00() * m2.getM02() +
                        m1.getM10() * m2.getM12() +
                        m1.getM20() * m2.getM22());
            this.setM10(m1.getM01() * m2.getM00() +
                        m1.getM11() * m2.getM10() +
                        m1.getM21() * m2.getM20());
            this.setM11(m1.getM01() * m2.getM01() +
                        m1.getM11() * m2.getM11() +
                        m1.getM21() * m2.getM21());
            this.setM12(m1.getM01() * m2.getM02() +
                        m1.getM11() * m2.getM12() +
                        m1.getM21() * m2.getM22());
            this.setM20(m1.getM02() * m2.getM00() +
                        m1.getM12() * m2.getM10() +
                        m1.getM22() * m2.getM20());
            this.setM21(m1.getM02() * m2.getM01() +
                        m1.getM12() * m2.getM11() +
                        m1.getM22() * m2.getM21());
            this.setM22(m1.getM02() * m2.getM02() +
                        m1.getM12() * m2.getM12() +
                        m1.getM22() * m2.getM22());
        }
        else
        {
            float f = m1.getM00() * m2.getM00() +
                      m1.getM10() * m2.getM10() +
                      m1.getM20() * m2.getM20();
            float f2 = m1.getM00() * m2.getM01() +
                       m1.getM10() * m2.getM11() +
                       m1.getM20() * m2.getM21();
            float f3 = m1.getM00() * m2.getM02() +
                       m1.getM10() * m2.getM12() +
                       m1.getM20() * m2.getM22();
            float f4 = m1.getM01() * m2.getM00() +
                       m1.getM11() * m2.getM10() +
                       m1.getM21() * m2.getM20();
            float f5 = m1.getM01() * m2.getM01() +
                       m1.getM11() * m2.getM11() +
                       m1.getM21() * m2.getM21();
            float f6 = m1.getM01() * m2.getM02() +
                       m1.getM11() * m2.getM12() +
                       m1.getM21() * m2.getM22();
            float f7 = m1.getM02() * m2.getM00() +
                       m1.getM12() * m2.getM10() +
                       m1.getM22() * m2.getM20();
            float f8 = m1.getM02() * m2.getM01() +
                       m1.getM12() * m2.getM11() +
                       m1.getM22() * m2.getM21();
            float f9 = m1.getM02() * m2.getM02() +
                       m1.getM12() * m2.getM12() +
                       m1.getM22() * m2.getM22();
            set(f,f2,f3,f4,f5,f6,f7,f8,f9);
        }
    }
    
    @Override
    public void normalize()
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaledRotate(dArray2,dArray);
        set((float)dArray[0],(float)dArray[1],(float)dArray[2],(float)dArray[3],(float)dArray[4],(float)dArray[5],(float)dArray[6],(float)dArray[7],(float)dArray[8]);
    }
    
    @Override
    public void normalizeCP()
    {
        float f = 1.0f/(float)Math.sqrt(getM00()*getM00()+getM10()*getM10()+getM20()*getM20());
        setM00(getM00()*f);
        setM10(getM10()*f);
        setM20(getM20()*f);
        
        f = 1.0f/(float)Math.sqrt(getM01()*getM01()+getM11()*getM11()+getM21()*getM21());
        setM01(getM01()*f);
        setM11(getM11()*f);
        setM21(getM21()*f);
        
        setM02(getM10()*getM21()-getM11()*getM20());
        setM12(getM01()*getM20()-getM00()*getM21());
        setM22(getM00()*getM11()-getM01()*getM10());
    }
    
    @Override
    public void normalize(IMatrix3<Float> m)
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[9];
        double[] dArray3 = new double[3];
        
        dArray[0] = m.getM00();
        dArray[1] = m.getM01();
        dArray[2] = m.getM02();
        dArray[3] = m.getM10();
        dArray[4] = m.getM11();
        dArray[5] = m.getM12();
        dArray[6] = m.getM20();
        dArray[7] = m.getM21();
        dArray[8] = m.getM22();
        
        Matrix3d.compute_svd(dArray,dArray3,dArray2);
        set((float)dArray2[0],(float)dArray2[1],(float)dArray2[2],(float)dArray2[3],(float)dArray2[4],(float)dArray2[5],(float)dArray2[6],(float)dArray2[7],(float)dArray2[8]);
    }
    
    @Override
    public void normalizeCP(IMatrix3<Float> m)
    {
        float f = 1.0f/(float)Math.sqrt(m.getM00()*m.getM00()+m.getM10()*m.getM10()+m.getM20()*m.getM20());
        setM00(m.getM00()*f);
        setM10(m.getM10()*f);
        setM20(m.getM20()*f);
        
        f = 1.0f/(float)Math.sqrt(m.getM01()*m.getM01()+m.getM11()*m.getM11()+m.getM21()*m.getM21());
        setM01(m.getM01()*f);
        setM11(m.getM11()*f);
        setM21(m.getM21()*f);
        
        setM02(getM10()*getM21()-getM11()*getM20());
        setM12(getM01()*getM20()-getM00()*getM21());
        setM22(getM00()*getM11()-getM01()*getM10());
    }
    
    public boolean equals(IMatrix3<Float> m)
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                if(!Objects.equals(getMatrix()[i][j], m.getMatrix()[i][i]))
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean equals(Object o)
    {
        if(!(o instanceof IMatrix3<?>))
        {
            return false;
        }
        
        IMatrix3<Float> m = (Matrix3f)o;
        
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                if(!Objects.equals(getMatrix()[i][j], m.getMatrix()[i][i]))
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hashCode(getMatrix());
    }
    
    @Override
    public boolean epsilonEquals(IMatrix3<Float> m, Float v)
    {
        boolean checked = !(Math.abs(getM00() - m.getM00()) > v);
        
        if(Math.abs(getM01()-m.getM01()) > v)
        {
            checked = false;
        }
        
        if(Math.abs(getM01()-m.getM01()) > v)
        {
            checked = false;
        }
        
        if(Math.abs(getM02()-m.getM02()) > v)
        {
            checked = false;
        }
        
        if(Math.abs(getM10()-m.getM10()) > v)
        {
            checked = false;
        }
        
        
        if(Math.abs(getM11()-m.getM11()) > v)
        {
            checked = false;
        }
        
        if(Math.abs(getM12()-m.getM12()) > v)
        {
            checked = false;
        }
        
        if(Math.abs(getM20()-m.getM20()) > v)
        {
            checked = false;
        }
        
        if(Math.abs(getM21()-m.getM21()) > v)
        {
            checked = false;
        }
        
        if(Math.abs(getM22()-m.getM22()) > v)
        {
            checked = false;
        }
        return checked;
    }
    
    @Override
    public void setZero()
    {
        set(0f,0f,0f,0f,0f,0f,0f,0f,0f);
    }
    
    @Override
    public void negate()
    {
        set(-getM00(),-getM01(),-getM02(),-getM10(),-getM11(),-getM12(),-getM20(),-getM21(),-getM22());
    }
    
    @Override
    public void negate(IMatrix3<Float> m)
    {
        set(-m.getM00(),-m.getM01(),-m.getM02(),-m.getM10(),-m.getM11(),-m.getM12(),-m.getM20(),-m.getM21(),-m.getM22());
    }

    @Override
    public void transform(IPoint3<Float> p)
    {
        float f = getM00()*p.x()+getM01()*p.y()+getM02()*p.z();
        float f2 = getM10()*p.x()+getM11()*p.y()+getM12()*p.z();
        float f3 = getM20()*p.x()+getM21()*p.y()+getM22()*p.z();
        p.set(f,f2,f3);
    }
    
    @Override
    public void getScaledRotate(double[] dArray, double[] dArray2)
    {
        double[] dArray3 = new double[]{getM00(),getM01(),getM02(),getM10(),getM11(),getM12(),getM20(),getM21(),getM22()};
        Matrix3d.compute_svd(dArray3,dArray,dArray2);
    }
    
    @Override
    public void set(AxisAngle4<Float> axisAngle)
    {
        float f = (float)Math.sqrt(axisAngle.x()*axisAngle.x()+axisAngle.y()*axisAngle.y()+axisAngle.z()*axisAngle.z());
        
        if((double)f < 1.0E-8)
        {
            set(1f,0f,0f,0f,1f,0f,0f,0f,1f);
        }
        else
        {
            f = 1.0f/f;
            
            float f2 = axisAngle.x()*f;
            float f3 = axisAngle.y()*f;
            float f4 = axisAngle.z()*f;
            float f5 = (float) Math.sin(axisAngle.angle());
            float f6 = (float) Math.cos(axisAngle.angle());
            float f7 = 1f-f6;
            float f8 = f2*f4;
            float f9 = f2 * f3;
            float f10 = f3*f4;
            setM00(f7*f2*f2+f6);
            setM01(f7*f9-f5*f4);
            setM02(f7*f8+f5*f3);
            setM10(f7*f9+f5*f4);
            setM11(f7*f3*f3+f6);
            setM12(f7*f10-f5*f2);
            setM20(f7*f8-f5*f3);
            setM21(f7*f10+f5*f2);
            setM22(f7*f4*f4+f6);
        }
    }
    
    @Override
    public void set(Quat4f quat)
    {
        setM00(1.0f-2.0f*quat.y()*quat.y()-2.0f*quat.z()*quat.z());
        setM10(2.0f*(quat.x()*quat.y()+quat.w()*quat.z()));
        setM20(2.0f*(quat.x()*quat.z()-quat.w()*quat.y()));
        setM01(2.0f*(quat.x()*quat.y()-quat.w()*quat.z()));
        setM11(1.0f-2.0f*quat.x()*quat.x()-2.0f*quat.z()*quat.z());
        setM21(2.0f*(quat.y()*quat.z()+quat.w()*quat.x()));
        setM02(2.0f*(quat.x()*quat.z()+quat.w()*quat.y()));
        setM12(2.0f*(quat.y()*quat.z()-quat.w()*quat.x()));
        setM22(1.0f-2.0f*quat.x()*quat.x()-2.0f*quat.y()*quat.y());
    }
    
    @Override
    public void set(Quat4d quat)
    {
        setM00((float) (1.0f - 2.0f * quat.y() * quat.y() - 2.0f * quat.z() * quat.z()));
        setM10((float) (2.0f * (quat.x() * quat.y() + quat.w() * quat.z())));
        setM20((float) (2.0f * (quat.x() * quat.z() - quat.w() * quat.y())));
        setM01((float) (2.0f * (quat.x() * quat.y() - quat.w() * quat.z())));
        setM11((float) (1.0f - 2.0f * quat.x() * quat.x() - 2.0f * quat.z() * quat.z()));
        setM21((float) (2.0f * (quat.y() * quat.z() + quat.w() * quat.x())));
        setM02((float) (2.0f * (quat.x() * quat.z() + quat.w() * quat.y())));
        setM12((float) (2.0f * (quat.y() * quat.z() - quat.w() * quat.x())));
        setM22((float) (1.0f - 2.0f * quat.x() * quat.x() - 2.0f * quat.y() * quat.y()));
    }
}