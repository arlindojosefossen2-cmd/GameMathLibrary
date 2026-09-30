package br.com.ajf.game.math.library.matrix4;

import br.com.ajf.game.math.library.axisangle4.AxisAngle4;
import br.com.ajf.game.math.library.matrix3.IMatrix3;
import br.com.ajf.game.math.library.matrix3.Matrix3d;
import br.com.ajf.game.math.library.point3.IPoint3;
import br.com.ajf.game.math.library.point4.IPoint4;
import br.com.ajf.game.math.library.quat4.Quat4d;
import br.com.ajf.game.math.library.quat4.Quat4f;

import java.util.Arrays;

public final class Matrix4d extends Matrix4<Double>
{
    public Matrix4d()
    {
    }
    
    public Matrix4d(Double[] array)
    {
        super(array);
    }
    
    public Matrix4d(IMatrix4<Double> m)
    {
        super(m);
    }
    
    public Matrix4d(Double[][] matrix)
    {
        super(matrix);
    }
    
    @Override
    public void setIdentity()
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                getMatrix()[i][j] = i == j ? 1.0 : 0.0;
            }
        }
    }
    
    @Override
    public void setScale(Double v)
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        getScaleRotate(dArray2,dArray);
        setM00((dArray[0]*v));
        setM01((dArray[1]*v));
        setM02((dArray[2]*v));
        setM10((dArray[3]*v));
        setM11((dArray[4]*v));
        setM12((dArray[5]*v));
        setM20((dArray[6]*v));
        setM21((dArray[7]*v));
        setM22((dArray[8]*v));
    }
    
    @Override
    public void get(IMatrix3<Double> m)
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        getScaleRotate(dArray2,dArray);
        m.setM00((dArray[0]));
        m.setM01((dArray[1]));
        m.setM02((dArray[2]));
        m.setM10((dArray[3]));
        m.setM11((dArray[4]));
        m.setM12((dArray[5]));
        m.setM20((dArray[6]));
        m.setM21((dArray[7]));
        m.setM22((dArray[8]));
    }
    
    @Override
    public Double get(IMatrix3<Double> m, IPoint3<Double> v)
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        getScaleRotate(dArray2,dArray);
        m.setM00((dArray[0]));
        m.setM01((dArray[1]));
        m.setM02((dArray[2]));
        m.setM10((dArray[3]));
        m.setM11((dArray[4]));
        m.setM12((dArray[5]));
        m.setM20((dArray[6]));
        m.setM21((dArray[7]));
        m.setM22((dArray[8]));
        v.set(getM03(),getM13(),getM23());
        return Matrix3d.max3(dArray2);
    }
    
    @Override
    public void get(Quat4f quat)
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        double d = 0.25 * (1.0 + dArray[0] + dArray[4] + dArray[8]);
        if (!((d < 0.0 ? -d : d) < 1.0E-30)) {
            quat.setW((float)Math.sqrt(d));
            d = 0.25 / (double)quat.w();
            quat.setX((float)((dArray[7] - dArray[5]) * d));
            quat.setY((float)((dArray[2] - dArray[6]) * d));
            quat.setZ((float)((dArray[3] - dArray[1]) * d));
            return;
        }
        quat.setW(0.0f);
        d = -0.5 * (dArray[4] + dArray[8]);
        if (!((d < 0.0 ? -d : d) < 1.0E-30)) {
            quat.setX((float)Math.sqrt(d));
            d = 0.5 / (double)quat.x();
            quat.setY((float)(dArray[3] * d));
            quat.setZ((float)(dArray[6] * d));
            return;
        }
        quat.setX(0.0f);
        d = 0.5 * (1.0 - dArray[8]);
        if (!((d < 0.0 ? -d : d) < 1.0E-30)) {
            quat.setY((float)Math.sqrt(d));
            quat.setZ((float)(dArray[7] / (2.0 * (double)quat.y())));
            return;
        }
        quat.setY(0.0f);
        quat.setZ(1.0f);
    }
    
    @Override
    public void get(Quat4d quat)
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        double d = 0.25 * (1.0 + dArray[0] + dArray[4] + dArray[8]);
        if (!((d < 0.0 ? -d : d) < 1.0E-30)) {
            quat.setW(Math.sqrt(d));
            d = 0.25 / quat.w();
            quat.setX(((dArray[7] - dArray[5]) * d));
            quat.setY(((dArray[2] - dArray[6]) * d));
            quat.setZ(((dArray[3] - dArray[1]) * d));
            return;
        }
        quat.setW(0.0);
        d = -0.5 * (dArray[4] + dArray[8]);
        if (!((d < 0.0 ? -d : d) < 1.0E-30)) {
            quat.setX(Math.sqrt(d));
            d = 0.5 / quat.x();
            quat.setY((dArray[3] * d));
            quat.setZ((dArray[6] * d));
            return;
        }
        quat.setX(0.0);
        d = 0.5 * (1.0 - dArray[8]);
        if (!((d < 0.0 ? -d : d) < 1.0E-30)) {
            quat.setY(Math.sqrt(d));
            quat.setZ((dArray[7] / (2.0 * (double)quat.y())));
            return;
        }
        quat.setY(0.0);
        quat.setZ(1.0);
    }
    
    @Override
    public Double getScale()
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        getScaleRotate(dArray2,dArray);
        return Matrix3d.max3(dArray2);
    }
    
    @Override
    public void add(Double v)
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                getMatrix()[i][j] += v;
            }
        }
    }
    
    @Override
    public void add(IMatrix4<Double> m)
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                getMatrix()[i][j] += m.getMatrix()[i][j] ;
            }
        }
    }
    
    @Override
    public void add(Double v, IMatrix4<Double> m)
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                getMatrix()[i][j] = m.getMatrix()[i][j] + v;
            }
        }
    }
    
    @Override
    public void add(IMatrix4<Double> m1, IMatrix4<Double> m2)
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                getMatrix()[i][j] = m1.getMatrix()[i][j] + m2.getMatrix()[i][j] ;
            }
        }
    }
    
    @Override
    public void sub(IMatrix4<Double> m)
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                getMatrix()[i][j] -= m.getMatrix()[i][j] ;
            }
        }
    }
    
    @Override
    public void sub(IMatrix4<Double> m1, IMatrix4<Double> m2)
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                getMatrix()[i][j] = m1.getMatrix()[i][j] - m2.getMatrix()[i][j] ;
            }
        }
    }
    
    @Override
    public void set(Quat4f quat)
    {
        this.setM00(1.0 - 2.0f * quat.y() * quat.y() - 2.0f * quat.z() * quat.z());
        this.setM10(2.0 * (quat.x() * quat.y() + quat.w() * quat.z()));
        this.setM20(2.0 * (quat.x() * quat.z() - quat.w() * quat.y()));
        this.setM01(2.0 * (quat.x() * quat.y() - quat.w() * quat.z()));
        this.setM11(1.0 - 2.0f * quat.x() * quat.x() - 2.0f * quat.z() * quat.z());
        this.setM21(2.0 * (quat.y() * quat.z() + quat.w() * quat.x()));
        this.setM02(2.0 * (quat.x() * quat.z() + quat.w() * quat.y()));
        this.setM12(2.0 * (quat.y() * quat.z() - quat.w() * quat.x()));
        this.setM22(1.0 - 2.0f * quat.x() * quat.x() - 2.0f * quat.y() * quat.y());
        this.setM03(0.0);
        this.setM13(0.0);
        this.setM23(0.0);
        this.setM30(0.0);
        this.setM31(0.0);
        this.setM32(0.0);
        this.setM33(1.0);
    }
    
    @Override
    public void set(Quat4d quat)
    {
        this.setM00( (1.0f - 2.0f * quat.y() * quat.y() - 2.0f * quat.z() * quat.z()));
        this.setM10( (2.0f * (quat.x() * quat.y() + quat.w() * quat.z())));
        this.setM20((2.0f * (quat.x() * quat.z() - quat.w() * quat.y())));
        this.setM01( (2.0f * (quat.x() * quat.y() - quat.w() * quat.z())));
        this.setM11( (1.0f - 2.0f * quat.x() * quat.x() - 2.0f * quat.z() * quat.z()));
        this.setM21( (2.0f * (quat.y() * quat.z() + quat.w() * quat.x())));
        this.setM02( (2.0f * (quat.x() * quat.z() + quat.w() * quat.y())));
        this.setM12( (2.0f * (quat.y() * quat.z() - quat.w() * quat.x())));
        this.setM22( (1.0f - 2.0f * quat.x() * quat.x() - 2.0f * quat.y() * quat.y()));
        this.setM03(0.0);
        this.setM13(0.0);
        this.setM23(0.0);
        this.setM30(0.0);
        this.setM31(0.0);
        this.setM32(0.0);
        this.setM33(1.0);
    }
    
    @Override
    public void set(AxisAngle4<Double> aa)
    {
        double d = Math.sqrt(aa.x() * aa.x() + aa.y() * aa.y() + aa.z() * aa.z());
        if (d < 1.0E-8) {
            this.setM00(1.0);
            this.setM01(0.0);
            this.setM02(0.0);
            this.setM10(0.0);
            this.setM11(1.0);
            this.setM12(0.0);
            this.setM20(0.0);
            this.setM21(0.0);
            this.setM22(1.0);
        } else {
            d = 1.0 / d;
            double d2 = aa.x() * d;
            double d3 = aa.y() * d;
            double d4 = aa.z() * d;
            float f = (float)Math.sin(aa.angle());
            float f2 = (float)Math.cos(aa.angle());
            float f3 = 1.0f - f2;
            float f4 = (float)(d2 * d4);
            float f5 = (float)(d2 * d3);
            float f6 = (float)(d3 * d4);
            this.setM00(f3 * (d2 * d2) + f2);
            this.setM01(f3 * f5 - f * d4);
            this.setM02(f3 * f4 + f * d3);
            this.setM10(f3 * f5 + f * d4);
            this.setM11(f3 * (d3 * d3) + f2);
            this.setM12(f3 * f6 - f * d2);
            this.setM20(f3 * f4 - f * d3);
            this.setM21(f3 * f6 + f * d2);
            this.setM22(f3 * (d4 * d4) + f2);
        }
        this.setM03(0.0);
        this.setM13(0.0);
        this.setM23(0.0);
        this.setM30(0.0);
        this.setM31(0.0);
        this.setM32(0.0);
        this.setM33(1.0);
    }
    
    @Override
    public void set(Quat4d quat, IPoint3<Double> v, Double d)
    {
        this.setM00( (d * (1.0f - 2.0f * quat.y() * quat.y() - 2.0f * quat.z() * quat.z())));
        this.setM10( (d * (2.0f * (quat.x() * quat.y() + quat.w() * quat.z()))));
        this.setM20( (d * (2.0f * (quat.x() * quat.z() - quat.w() * quat.y()))));
        this.setM01( (d * (2.0f * (quat.x() * quat.y() - quat.w() * quat.z()))));
        this.setM11( (d * (1.0f - 2.0f * quat.x() * quat.x() - 2.0f * quat.z() * quat.z())));
        this.setM21( (d * (2.0f * (quat.y() * quat.z() + quat.w() * quat.x()))));
        this.setM02( (d * (2.0f * (quat.x() * quat.z() + quat.w() * quat.y()))));
        this.setM12( (d * (2.0f * (quat.y() * quat.z() - quat.w() * quat.x()))));
        this.setM22( (d * (1.0f - 2.0f * quat.x() * quat.x() - 2.0f * quat.y() * quat.y())));
        this.setM03(Double.parseDouble(String.valueOf(v.x())));
        this.setM13(Double.parseDouble(String.valueOf(v.y())));
        this.setM23(Double.parseDouble(String.valueOf(v.z())));
        this.setM30(0.0);
        this.setM31(0.0);
        this.setM32(90.0);
        this.setM33(1.0);
    }
    
    @Override
    public void set(Quat4f quat, IPoint3<Float> v, Float f)
    {
        this.setM00(f * (1.0 - 2.0f * quat.y() * quat.y() - 2.0f * quat.z() * quat.z()));
        this.setM10(f * (2.0 * (quat.x() * quat.y() + quat.w() * quat.z())));
        this.setM20(f * (2.0 * (quat.x() * quat.z() - quat.w() * quat.y())));
        this.setM01(f * (2.0 * (quat.x() * quat.y() - quat.w() * quat.z())));
        this.setM11(f * (1.0 - 2.0f * quat.x() * quat.x() - 2.0f * quat.z() * quat.z()));
        this.setM21(f * (2.0 * (quat.y() * quat.z() + quat.w() * quat.x())));
        this.setM02(f * (2.0 * (quat.x() * quat.z() + quat.w() * quat.y())));
        this.setM12(f * (2.0 * (quat.y() * quat.z() - quat.w() * quat.x())));
        this.setM22(f * (1.0 - 2.0f * quat.x() * quat.x() - 2.0f * quat.y() * quat.y()));
        this.setM03(Double.parseDouble(String.valueOf(v.x())));
        this.setM13(Double.parseDouble(String.valueOf(v.y())));
        this.setM23(Double.parseDouble(String.valueOf(v.z())));
        this.setM30(0.0);
        this.setM31(0.0);
        this.setM32(90.0);
        this.setM33(1.0);
    }
    
    @Override
    public void invertGeneral(IMatrix4<Double> m)
    {
        double[] dArray = new double[16];
        double[] dArray2 = new double[16];
        int[] nArray = new int[4];
        dArray[0] = m.getM00();
        dArray[1] = m.getM01();
        dArray[2] = m.getM02();
        dArray[3] = m.getM03();
        dArray[4] = m.getM10();
        dArray[5] = m.getM11();
        dArray[6] = m.getM12();
        dArray[7] = m.getM13();
        dArray[8] = m.getM20();
        dArray[9] = m.getM21();
        dArray[10] = m.getM22();
        dArray[11] = m.getM23();
        dArray[12] = m.getM30();
        dArray[13] = m.getM31();
        dArray[14] = m.getM32();
        dArray[15] = m.getM33();
        if (!Matrix4d.luDecomposition(dArray, nArray))
        {
            return;
        }
        for (int i = 0; i < 16; ++i)
        {
            dArray2[i] = 0.0;
        }
        dArray2[0] = 1.0;
        dArray2[5] = 1.0;
        dArray2[10] = 1.0;
        dArray2[15] = 1.0;
        Matrix4d.luBacksubstitution(dArray, nArray, dArray2);
        set(new Double[]{ dArray2[0],dArray2[1],  dArray2[2], dArray2[3],
                        dArray2[4], dArray2[5], dArray2[6],  dArray2[7],
                         dArray2[8],  dArray2[9],  dArray2[10],  dArray2[11],
                         dArray2[12],  dArray2[13], dArray2[14],  dArray2[15]});
    }
    
    static boolean luDecomposition(double[] dArray, int[] nArray) {
        int n;
        double[] dArray2 = new double[4];
        int n2 = 0;
        int n3 = 0;
        int n4 = 4;
        while (n4-- != 0) {
            double d = 0.0;
            n = 4;
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
        for (n4 = 0; n4 < 4; ++n4) {
            double d;
            int n5;
            int n6;
            int n7;
            double d3;
            int n8;
            for (n2 = 0; n2 < n4; ++n2) {
                n8 = n + 4 * n2 + n4;
                d3 = dArray[n8];
                int n9 = n2;
                int n10 = n + 4 * n2;
                n7 = n + n4;
                while (n9-- != 0) {
                    d3 -= dArray[n10] * dArray[n7];
                    ++n10;
                    n7 += 4;
                }
                dArray[n8] = d3;
            }
            double d4 = 0.0;
            n3 = -1;
            for (n2 = n4; n2 < 4; ++n2) {
                double d5 = 0;
                n8 = n + 4 * n2 + n4;
                d3 = dArray[n8];
                n6 = n4;
                n5 = n + 4 * n2;
                n7 = n + n4;
                while (n6-- != 0) {
                    d3 -= dArray[n5] * dArray[n7];
                    ++n5;
                    n7 += 4;
                }
                dArray[n8] = d3;
                d = dArray2[n2] * Math.abs(d3);
                if (!(d5 >= d4)) continue;
                d4 = d;
                n3 = n2;
            }
          
            if (n4 != n3) {
                n6 = 4;
                n5 = n + 4 * n3;
                n7 = n + 4 * n4;
                while (n6-- != 0) {
                    d = dArray[n5];
                    dArray[n5++] = dArray[n7];
                    dArray[n7++] = d;
                }
                dArray2[n3] = dArray2[n4];
            }
            nArray[n4] = n3;
            if (dArray[n + 4 * n4 + n4] == 0.0) {
                return false;
            }
            if (n4 == 3) continue;
            d = 1.0 / dArray[n + 4 * n4 + n4];
            n8 = n + 4 * (n4 + 1) + n4;
            n2 = 3 - n4;
            while (n2-- != 0) {
                int n11 = n8;
                dArray[n11] = dArray[n11] * d;
                n8 += 4;
            }
        }
        return true;
    }
    
    static void luBacksubstitution(double[] dArray, int[] nArray, double[] dArray2) {
        int n = 0;
        for (int i = 0; i < 4; ++i) {
            int n2;
            int n4 = -1;
            for (int j = 0; j < 4; ++j) {
                int n5 = nArray[n + j];
                double d = dArray2[i + 4 * n5];
                dArray2[i + 4 * n5] = dArray2[i + 4 * j];
                if (n4 >= 0) {
                    n2 = j * 4;
                    for (int k = n4; k <= j - 1; ++k) {
                        d -= dArray[n2 + k] * dArray2[i + 4 * k];
                    }
                } else if (d != 0.0) {
                    n4 = j;
                }
                dArray2[i + 4 * j] = d;
            }
            n2 = 12;
            int n6 = i + 12;
            dArray2[n6] = dArray2[n6] / dArray[n2 + 3];
            dArray2[i + 8] = (dArray2[i + 8] - dArray[(n2 -= 4) + 3] * dArray2[i + 12]) / dArray[n2 + 2];
            dArray2[i + 4] = (dArray2[i + 4] - dArray[(n2 -= 4) + 2] * dArray2[i + 8] - dArray[n2 + 3] * dArray2[i + 12]) / dArray[n2 + 1];
            dArray2[i] = (dArray2[i] - dArray[(n2 -= 4) + 1] * dArray2[i + 4] - dArray[n2 + 2] * dArray2[i + 8] - dArray[n2 + 3] * dArray2[i + 12]) / dArray[n2];
        }
    }
    
    @Override
    public Double determinant()
    {
        double f = this.getM00() * (this.getM11() * this.getM22() * this.getM33() + this.getM12() * this.getM23() * this.getM31() +
                                   this.getM13() * this.getM21() * this.getM32() - this.getM13() * this.getM22() * this.getM31() -
                                   this.getM11() * this.getM23() * this.getM32() - this.getM12() * this.getM21() * this.getM33());
        f -= this.getM01() * (this.getM10() * this.getM22() * this.getM33() + this.getM12() * this.getM23() * this.getM30() +
                              this.getM13() * this.getM20() * this.getM32() - this.getM13() * this.getM22() * this.getM30() -
                              this.getM10() * this.getM23() * this.getM32() - this.getM12() * this.getM20() * this.getM33());
        f += this.getM02() * (this.getM10() * this.getM21() * this.getM33() + this.getM11() * this.getM23() * this.getM30() +
                              this.getM13() * this.getM20() * this.getM31() - this.getM13() * this.getM21() * this.getM30() -
                              this.getM10() * this.getM23() * this.getM31() - this.getM11() * this.getM20() * this.getM33());
        return f -= this.getM03() * (this.getM10() * this.getM21() * this.getM32() + this.getM11() * this.getM22() * this.getM30() +
                                     this.getM12() * this.getM20() * this.getM31() - this.getM12() * this.getM21() * this.getM30() -
                                     this.getM10() * this.getM22() * this.getM31() - this.getM11() * this.getM20() * this.getM32());
    }
    
    @Override
    public void set(IMatrix3<Double> m)
    {
        if(m == null || m.getMatrix() == null)
        {
            return;
        }
        
        set(new Double[]{m.getM00(),m.getM01(),m.getM02(),0.0, m.getM10(),m.getM11(),m.getM12(),0.0,m.getM20(),m.getM21(),m.getM22(),0.0,0.0,0.0,0.0,1.0});
    }
    
    @Override
    public void set(Double v)
    {
        if(v == null)
        {
            return;
        }
        
        set(new Double[]{v,0.0,0.0,0.0,0.0,v,0.0,0.0,0.0,v,0.0,0.0,0.0,0.0,1.0});
    }
    
    @Override
    public void set(IPoint3<Double> v)
    {
        if(v == null)
        {
            return;
        }
        
        set(new Double[]{1.0,0.0,0.0,v.x(),0.0,1.0,0.0,v.y(),0.0,0.0,1.0,v.z(),0.0,0.0,0.0,1.0});
        
    }
    
    @Override
    public void set(Double n, IPoint3<Double> v)
    {
        if(v == null || n == null)
        {
            return;
        }
        
        set(new Double[]{n,0.0,0.0,v.x(),0.0,n,0.0,v.y(),0.0,0.0,n,v.z(),0.0,0.0,0.0,1.0});
    }
    
    @Override
    public void set(IPoint3<Double> v, Double n)
    {
        if(v == null || n == null)
        {
            return;
        }
        
        set(new Double[]{n,0.0,0.0,n*v.x(),0.0,n,0.0,n*v.y(),0.0,0.0,n,n*v.z(),0.0,0.0,0.0,1.0});
    }
    
    @Override
    public void set(IMatrix3<Double> m, IPoint3<Double> v, Double n)
    {
        if(m == null || v == null || n == null)
        {
            return;
        }
        
        set(new Double[]{m.getM00()*n,m.getM01()*n,m.getM02()*n,v.x(),m.getM10()*n,m.getM11()*n,m.getM12()*n,v.y(),m.getM20()*n,m.getM21()*n,m.getM22()*n,v.z()
                ,0.0,0.0,0.0,1.0});
    }
    
    @Override
    public void rotX(Double v)
    {
        if(v == null)
        {
            return;
        }
        
        double f2 = Math.cos(v);
        double f3 = Math.sin(v);
        
        set(new Double[]{1.0,0.0,0.0,0.0,0.0,f3,-f2,0.0,0.0,f2,f3,0.0,0.0,0.0,0.0,1.0});
        
    }
    
    @Override
    public void rotY(Double v)
    {
        if(v == null)
        {
            return;
        }
        
        double f2 =  Math.cos(v);
        double f3 =  Math.sin(v);
        
        set(new Double[]{f2,0.0,f3,0.0,0.0,1.0,0.0,0.0,-f3,0.0,f2,0.0,0.0,0.0,0.0,1.0});
    }
    
    @Override
    public void rotZ(Double v)
    {
        if(v == null)
        {
            return;
        }
        
        double f2 = Math.cos(v);
        double f3 = Math.sin(v);
        
        set(new Double[]{f2,-f3,0.0,0.0,f3,f2,0.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0,1.0});
    }
    
    @Override
    public void mul(Double v)
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                getMatrix()[i][j] *= v;
            }
        }
    }
    
    @Override
    public void mul(IMatrix4<Double> m)
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                double sum = 0;
                
                for (int k = 0; k < getMatrix().length; k++)
                {
                    sum += getMatrix()[i][k]*m.getMatrix()[k][j];
                }
                
                getMatrix()[i][j] = sum;
            }
        }
    }
    
    @Override
    public void mul(Double v, IMatrix4<Double> m)
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                getMatrix()[i][j] = v * m.getMatrix()[i][j];
            }
        }
    }
    
    @Override
    public void mul(IMatrix4<Double> m1, IMatrix4<Double> m2)
    {
        if (this != m1 && this != m2)
        {
            m1.mul(m2);
            set(m1);
        }
    }
    
    @Override
    public void mulTransposeBoth(IMatrix4<Double> m1, IMatrix4<Double> m2)
    {
        if (this != m1 && this != m2) {
            this.setM00(m1.getM00() * m2.getM00() + m1.getM10() * m2.getM01() + m1.getM20() * m2.getM02() + m1.getM30() * m2.getM03());
            this.setM01( m1.getM00() * m2.getM10() + m1.getM10() * m2.getM11() + m1.getM20() * m2.getM12() + m1.getM30() * m2.getM13());
            this.setM02(m1.getM00() * m2.getM20() + m1.getM10() * m2.getM21() + m1.getM20() * m2.getM22() + m1.getM30() * m2.getM23());
            this.setM03( m1.getM00() * m2.getM30() + m1.getM10() * m2.getM31() + m1.getM20() * m2.getM32() + m1.getM30() * m2.getM33());
            this.setM10(m1.getM01() * m2.getM00() + m1.getM11() * m2.getM01() + m1.getM21() * m2.getM02() + m1.getM31() * m2.getM03());
            this.setM11(m1.getM01() * m2.getM10() + m1.getM11() * m2.getM11() + m1.getM21() * m2.getM12() + m1.getM31() * m2.getM13());
            this.setM12( m1.getM01() * m2.getM20() + m1.getM11() * m2.getM21() + m1.getM21() * m2.getM22() + m1.getM31() * m2.getM23());
            this.setM13( m1.getM01() * m2.getM30() + m1.getM11() * m2.getM31() + m1.getM21() * m2.getM32() + m1.getM31() * m2.getM33());
            this.setM20( m1.getM02() * m2.getM00() + m1.getM12() * m2.getM01() + m1.getM22() * m2.getM02() + m1.getM32() * m2.getM03());
            this.setM21(m1.getM02() * m2.getM10() + m1.getM12() * m2.getM11() + m1.getM22() * m2.getM12() + m1.getM32() * m2.getM13());
            this.setM22(m1.getM02() * m2.getM20() + m1.getM12() * m2.getM21() + m1.getM22() * m2.getM22() + m1.getM32() * m2.getM23());
            this.setM23( m1.getM02() * m2.getM30() + m1.getM12() * m2.getM31() + m1.getM22() * m2.getM32() + m1.getM32() * m2.getM33());
            this.setM30(m1.getM03() * m2.getM00() + m1.getM13() * m2.getM01() + m1.getM23() * m2.getM02() + m1.getM33() * m2.getM03());
            this.setM31( m1.getM03() * m2.getM10() + m1.getM13() * m2.getM11() + m1.getM23() * m2.getM12() + m1.getM33() * m2.getM13());
            this.setM32(m1.getM03() * m2.getM20() + m1.getM13() * m2.getM21() + m1.getM23() * m2.getM22() + m1.getM33() * m2.getM23());
            this.setM33( m1.getM03() * m2.getM30() + m1.getM13() * m2.getM31() + m1.getM23() * m2.getM32() + m1.getM33() * m2.getM33());
        } else {
            double f = m1.getM00() * m2.getM00() + m1.getM10() * m2.getM01() + m1.getM20() * m2.getM02() + m1.getM30() * m2.getM03();
            double f2 = m1.getM00() * m2.getM10() + m1.getM10() * m2.getM11() + m1.getM20() * m2.getM12() + m1.getM30() * m2.getM13();
            double f3 = m1.getM00() * m2.getM20() + m1.getM10() * m2.getM21() + m1.getM20() * m2.getM22() + m1.getM30() * m2.getM23();
            double f4 = m1.getM00() * m2.getM30() + m1.getM10() * m2.getM31() + m1.getM20() * m2.getM32() + m1.getM30() * m2.getM33();
            double f5 = m1.getM01() * m2.getM00() + m1.getM11() * m2.getM01() + m1.getM21() * m2.getM02() + m1.getM31() * m2.getM03();
            double f6 = m1.getM01() * m2.getM10() + m1.getM11() * m2.getM11() + m1.getM21() * m2.getM12() + m1.getM31() * m2.getM13();
            double f7 = m1.getM01() * m2.getM20() + m1.getM11() * m2.getM21() + m1.getM21() * m2.getM22() + m1.getM31() * m2.getM23();
            double f8 = m1.getM01() * m2.getM30() + m1.getM11() * m2.getM31() + m1.getM21() * m2.getM32() + m1.getM31() * m2.getM33();
            double f9 = m1.getM02() * m2.getM00() + m1.getM12() * m2.getM01() + m1.getM22() * m2.getM02() + m1.getM32() * m2.getM03();
            double f10 = m1.getM02() * m2.getM10() + m1.getM12() * m2.getM11() + m1.getM22() * m2.getM12() + m1.getM32() * m2.getM13();
            double f11 = m1.getM02() * m2.getM20() + m1.getM12() * m2.getM21() + m1.getM22() * m2.getM22() + m1.getM32() * m2.getM23();
            double f12 = m1.getM02() * m2.getM30() + m1.getM12() * m2.getM31() + m1.getM22() * m2.getM32() + m1.getM32() * m2.getM33();
            double f13 = m1.getM03() * m2.getM00() + m1.getM13() * m2.getM01() + m1.getM23() * m2.getM02() + m1.getM33() * m2.getM03();
            double f14 = m1.getM03() * m2.getM10() + m1.getM13() * m2.getM11() + m1.getM23() * m2.getM12() + m1.getM33() * m2.getM13();
            double f15 = m1.getM03() * m2.getM20() + m1.getM13() * m2.getM21() + m1.getM23() * m2.getM22() + m1.getM33() * m2.getM23();
            double f16 = m1.getM03() * m2.getM30() + m1.getM13() * m2.getM31() + m1.getM23() * m2.getM32() + m1.getM33() * m2.getM33();
            this.setM00(f);
            this.setM01(f2);
            this.setM02(f3);
            this.setM03(f4);
            this.setM10(f5);
            this.setM11(f6);
            this.setM12(f7);
            this.setM13(f8);
            this.setM20(f9);
            this.setM21(f10);
            this.setM22(f11);
            this.setM23(f12);
            this.setM30(f13);
            this.setM31(f14);
            this.setM32(f15);
            this.setM33(f16);
        }
    }
    
    @Override
    public void mulTransposeRight(IMatrix4<Double> m1, IMatrix4<Double> m2)
    {
        if (this != m1 && this != m2) {
            this.setM00(m1.getM00() * m2.getM00() + m1.getM01() * m2.getM01() + m1.getM02() * m2.getM02() + m1.getM03() * m2.getM03());
            this.setM01(m1.getM00() * m2.getM10() + m1.getM01() * m2.getM11() + m1.getM02() * m2.getM12() + m1.getM03() * m2.getM13());
            this.setM02(m1.getM00() * m2.getM20() + m1.getM01() * m2.getM21() + m1.getM02() * m2.getM22() + m1.getM03() * m2.getM23());
            this.setM03(m1.getM00() * m2.getM30() + m1.getM01() * m2.getM31() + m1.getM02() * m2.getM32() + m1.getM03() * m2.getM33());
            this.setM10(m1.getM10() * m2.getM00() + m1.getM11() * m2.getM01() + m1.getM12() * m2.getM02() + m1.getM13() * m2.getM03());
            this.setM11(m1.getM10() * m2.getM10() + m1.getM11() * m2.getM11() + m1.getM12() * m2.getM12() + m1.getM13() * m2.getM13());
            this.setM12(m1.getM10() * m2.getM20() + m1.getM11() * m2.getM21() + m1.getM12() * m2.getM22() + m1.getM12() * m2.getM23());
            this.setM13(m1.getM10() * m2.getM30() + m1.getM11() * m2.getM31() + m1.getM12() * m2.getM32() + m1.getM31() * m2.getM33());
            this.setM20(m1.getM20() * m2.getM00() + m1.getM21() * m2.getM01() + m1.getM22() * m2.getM02() + m1.getM23() * m2.getM03());
            this.setM21(m1.getM20() * m2.getM10() + m1.getM21() * m2.getM11() + m1.getM22() * m2.getM12() + m1.getM23() * m2.getM13());
            this.setM22(m1.getM20() * m2.getM20() + m1.getM21() * m2.getM21() + m1.getM22() * m2.getM22() + m1.getM23() * m2.getM23());
            this.setM23(m1.getM20() * m2.getM30() + m1.getM21() * m2.getM31() + m1.getM22() * m2.getM32() + m1.getM23() * m2.getM33());
            this.setM30(m1.getM30() * m2.getM00() + m1.getM31() * m2.getM01() + m1.getM32() * m2.getM02() + m1.getM33() * m2.getM03());
            this.setM31(m1.getM30() * m2.getM10() + m1.getM31() * m2.getM11() + m1.getM32() * m2.getM12() + m1.getM33() * m2.getM13());
            this.setM32(m1.getM30() * m2.getM20() + m1.getM31() * m2.getM21() + m1.getM32() * m2.getM22() + m1.getM33() * m2.getM23());
            this.setM33(m1.getM30() * m2.getM30() + m1.getM31() * m2.getM31() + m1.getM32() * m2.getM32() + m1.getM33() * m2.getM33());
        } else {
            double f = (m1.getM00() * m2.getM00() + m1.getM01() * m2.getM01() + m1.getM02() * m2.getM02() + m1.getM03() * m2.getM03());
            double f2 = (m1.getM00() * m2.getM10() + m1.getM01() * m2.getM11() + m1.getM02() * m2.getM12() + m1.getM03() * m2.getM13());
            double f3 = (m1.getM00() * m2.getM20() + m1.getM01() * m2.getM21() + m1.getM02() * m2.getM22() + m1.getM03() * m2.getM23());
            double f4 = (m1.getM00() * m2.getM30() + m1.getM01() * m2.getM31() + m1.getM02() * m2.getM32() + m1.getM03() * m2.getM33());
            double f5 = (m1.getM10() * m2.getM00() + m1.getM11() * m2.getM01() + m1.getM12() * m2.getM02() + m1.getM13() * m2.getM03());
            double f6 = (m1.getM10() * m2.getM10() + m1.getM11() * m2.getM11() + m1.getM12() * m2.getM12() + m1.getM13() * m2.getM13());
            double f7 = (m1.getM10() * m2.getM20() + m1.getM11() * m2.getM21() + m1.getM12() * m2.getM22() + m1.getM12() * m2.getM23());
            double f8 = (m1.getM10() * m2.getM30() + m1.getM11() * m2.getM31() + m1.getM12() * m2.getM32() + m1.getM31() * m2.getM33());
            double f9 = (m1.getM20() * m2.getM00() + m1.getM21() * m2.getM01() + m1.getM22() * m2.getM02() + m1.getM23() * m2.getM03());
            double f10 = (m1.getM20() * m2.getM10() + m1.getM21() * m2.getM11() + m1.getM22() * m2.getM12() + m1.getM23() * m2.getM13());
            double f11 = (m1.getM20() * m2.getM20() + m1.getM21() * m2.getM21() + m1.getM22() * m2.getM22() + m1.getM23() * m2.getM23());
            double f12 = (m1.getM20() * m2.getM30() + m1.getM21() * m2.getM31() + m1.getM22() * m2.getM32() + m1.getM23() * m2.getM33());
            double f13 = (m1.getM30() * m2.getM00() + m1.getM31() * m2.getM01() + m1.getM32() * m2.getM02() + m1.getM33() * m2.getM03());
            double f14 = (m1.getM30() * m2.getM10() + m1.getM31() * m2.getM11() + m1.getM32() * m2.getM12() + m1.getM33() * m2.getM13());
            double f15 = (m1.getM30() * m2.getM20() + m1.getM31() * m2.getM21() + m1.getM32() * m2.getM22() + m1.getM33() * m2.getM23());
            double f16 = (m1.getM30() * m2.getM30() + m1.getM31() * m2.getM31() + m1.getM32() * m2.getM32() + m1.getM33() * m2.getM33());
            this.setM00(f);
            this.setM01(f2);
            this.setM02(f3);
            this.setM03(f4);
            this.setM10(f5);
            this.setM11(f6);
            this.setM12(f7);
            this.setM13(f8);
            this.setM20(f9);
            this.setM21(f10);
            this.setM22(f11);
            this.setM23(f12);
            this.setM30(f13);
            this.setM31(f14);
            this.setM32(f15);
            this.setM33(f16);
        }
    }
    
    @Override
    public void mulTransposeLeft(IMatrix4<Double> m1, IMatrix4<Double> m2)
    {
        if (this != m1 && this != m2) {
            this.setM00(m1.getM00() * m2.getM00() + m1.getM10() * m2.getM10() + m1.getM20() * m2.getM20() + m1.getM30() * m2.getM30());
            this.setM01(m1.getM00() * m2.getM01() + m1.getM10() * m2.getM11() + m1.getM20() * m2.getM21() + m1.getM30() * m2.getM31());
            this.setM02(m1.getM00() * m2.getM02() + m1.getM10() * m2.getM12() + m1.getM20() * m2.getM22() + m1.getM30() * m2.getM32());
            this.setM03(m1.getM00() * m2.getM03() + m1.getM10() * m2.getM13() + m1.getM20() * m2.getM23() + m1.getM30() * m2.getM33());
            this.setM10(m1.getM01() * m2.getM00() + m1.getM11() * m2.getM10() + m1.getM21() * m2.getM20() + m1.getM31() * m2.getM30());
            this.setM11(m1.getM01() * m2.getM01() + m1.getM11() * m2.getM11() + m1.getM21() * m2.getM21() + m1.getM31() * m2.getM31());
            this.setM12(m1.getM01() * m2.getM02() + m1.getM11() * m2.getM12() + m1.getM21() * m2.getM22() + m1.getM31() * m2.getM32());
            this.setM13(m1.getM01() * m2.getM03() + m1.getM11() * m2.getM13() + m1.getM21() * m2.getM23() + m1.getM31() * m2.getM33());
            this.setM20(m1.getM02() * m2.getM00() + m1.getM12() * m2.getM10() + m1.getM22() * m2.getM20() + m1.getM32() * m2.getM30());
            this.setM21(m1.getM02() * m2.getM01() + m1.getM12() * m2.getM11() + m1.getM22() * m2.getM21() + m1.getM32() * m2.getM31());
            this.setM22(m1.getM02() * m2.getM02() + m1.getM12() * m2.getM12() + m1.getM22() * m2.getM22() + m1.getM32() * m2.getM32());
            this.setM23(m1.getM02() * m2.getM03() + m1.getM12() * m2.getM13() + m1.getM22() * m2.getM23() + m1.getM32() * m2.getM33());
            this.setM30(m1.getM03() * m2.getM00() + m1.getM13() * m2.getM10() + m1.getM23() * m2.getM20() + m1.getM33() * m2.getM30());
            this.setM31(m1.getM03() * m2.getM01() + m1.getM13() * m2.getM11() + m1.getM23() * m2.getM21() + m1.getM33() * m2.getM31());
            this.setM32(m1.getM03() * m2.getM02() + m1.getM13() * m2.getM12() + m1.getM23() * m2.getM22() + m1.getM33() * m2.getM32());
            this.setM33(m1.getM03() * m2.getM03() + m1.getM13() * m2.getM13() + m1.getM23() * m2.getM23() + m1.getM33() * m2.getM33());
        } else {
            double f = m1.getM00() * m2.getM00() + m1.getM10() * m2.getM10() + m1.getM20() * m2.getM20() + m1.getM30() * m2.getM30();
            double f2 = m1.getM00() * m2.getM01() + m1.getM10() * m2.getM11() + m1.getM20() * m2.getM21() + m1.getM30() * m2.getM31();
            double f3 = m1.getM00() * m2.getM02() + m1.getM10() * m2.getM12() + m1.getM20() * m2.getM22() + m1.getM30() * m2.getM32();
            double f4 = m1.getM00() * m2.getM03() + m1.getM10() * m2.getM13() + m1.getM20() * m2.getM23() + m1.getM30() * m2.getM33();
            double f5 = m1.getM01() * m2.getM00() + m1.getM11() * m2.getM10() + m1.getM21() * m2.getM20() + m1.getM31() * m2.getM30();
            double f6 = m1.getM01() * m2.getM01() + m1.getM11() * m2.getM11() + m1.getM21() * m2.getM21() + m1.getM31() * m2.getM31();
            double f7 = m1.getM01() * m2.getM02() + m1.getM11() * m2.getM12() + m1.getM21() * m2.getM22() + m1.getM31() * m2.getM32();
            double f8 = m1.getM01() * m2.getM03() + m1.getM11() * m2.getM13() + m1.getM21() * m2.getM23() + m1.getM31() * m2.getM33();
            double f9 = m1.getM02() * m2.getM00() + m1.getM12() * m2.getM10() + m1.getM22() * m2.getM20() + m1.getM32() * m2.getM30();
            double f10 = m1.getM02() * m2.getM01() + m1.getM12() * m2.getM11() + m1.getM22() * m2.getM21() + m1.getM32() * m2.getM31();
            double f11 = m1.getM02() * m2.getM02() + m1.getM12() * m2.getM12() + m1.getM22() * m2.getM22() + m1.getM32() * m2.getM32();
            double f12 = m1.getM02() * m2.getM03() + m1.getM12() * m2.getM13() + m1.getM22() * m2.getM23() + m1.getM32() * m2.getM33();
            double f13 = m1.getM03() * m2.getM00() + m1.getM13() * m2.getM10() + m1.getM23() * m2.getM20() + m1.getM33() * m2.getM30();
            double f14 = m1.getM03() * m2.getM01() + m1.getM13() * m2.getM11() + m1.getM23() * m2.getM21() + m1.getM33() * m2.getM31();
            double f15 = m1.getM03() * m2.getM02() + m1.getM13() * m2.getM12() + m1.getM23() * m2.getM22() + m1.getM33() * m2.getM32();
            double f16 = m1.getM03() * m2.getM03() + m1.getM13() * m2.getM13() + m1.getM23() * m2.getM23() + m1.getM33() * m2.getM33();
            this.setM00(f);
            this.setM01(f2);
            this.setM02(f3);
            this.setM03(f4);
            this.setM10(f5);
            this.setM11(f6);
            this.setM12(f7);
            this.setM13(f8);
            this.setM20(f9);
            this.setM21(f10);
            this.setM22(f11);
            this.setM23(f12);
            this.setM30(f13);
            this.setM31(f14);
            this.setM32(f15);
            this.setM33(f16);
        }
    }
 
    public boolean epsilonEquals(IMatrix4<Double> m, Float d)
    {
        return epsilonEquals(m,(double)d);
    }
    @Override
    public boolean epsilonEquals(IMatrix4<Double> m, Double d)
    {
        double d2 = this.getM00() - m.getM00();
        double d3 = d2 < 0.0 ? -d2 : d2;
        if (d3 > d) {
            return false;
        }
        d2 = this.getM01() - m.getM01();
        double d4 = d2 < 0.0 ? -d2 : d2;
        if (d4 > d) {
            return false;
        }
        d2 = this.getM02() - m.getM02();
        double d5 = d2 < 0.0 ? -d2 : d2;
        if (d5 > d) {
            return false;
        }
        d2 = this.getM03() - m.getM03();
        double d6 = d2 < 0.0 ? -d2 : d2;
        if (d6 > d) {
            return false;
        }
        d2 = this.getM10() - m.getM10();
        double d7 = d2 < 0.0 ? -d2 : d2;
        if (d7 > d) {
            return false;
        }
        d2 = this.getM11() - m.getM11();
        double d8 = d2 < 0.0 ? -d2 : d2;
        if (d8 > d) {
            return false;
        }
        d2 = this.getM12() - m.getM12();
        double d9 = d2 < 0.0 ? -d2 : d2;
        if (d9 > d) {
            return false;
        }
        d2 = this.getM13() - m.getM13();
        double d10 = d2 < 0.0 ? -d2 : d2;
        if (d10 > d) {
            return false;
        }
        d2 = this.getM20() - m.getM20();
        double d11 = d2 < 0.0 ? -d2 : d2;
        if (d11 > d) {
            return false;
        }
        d2 = this.getM21() - m.getM21();
        double d12 = d2 < 0.0 ? -d2 : d2;
        if (d12 > d) {
            return false;
        }
        d2 = this.getM22() - m.getM22();
        double d13 = d2 < 0.0 ? -d2 : d2;
        if (d13 > d) {
            return false;
        }
        d2 = this.getM23() - m.getM23();
        double d14 = d2 < 0.0 ? -d2 : d2;
        if (d14 > d) {
            return false;
        }
        d2 = this.getM30() - m.getM30();
        double d15 = d2 < 0.0 ? -d2 : d2;
        if (d15 > d) {
            return false;
        }
        d2 = this.getM31() - m.getM31();
        double d16 = d2 < 0.0 ? -d2 : d2;
        if (d16 > d) {
            return false;
        }
        d2 = this.getM32() - m.getM32();
        double d17 = d2 < 0.0 ? -d2 : d2;
        if (d17 > d) {
            return false;
        }
        d2 = this.getM33() - m.getM33();
        double d18 = d2 < 0.0 ? -d2 : d2;
        return !(d18 > d);
    }
    
    @Override
    public void transform(IPoint4<Double> v)
    {
        double f = this.getM00() * v.x() + this.getM01() * v.y() + this.getM02() * v.z() + this.getM03() * v.w();
        double f2 = this.getM10() * v.x() + this.getM11() * v.y() + this.getM12() * v.z() + this.getM13() * v.w();
        double f3 = this.getM20() * v.x() + this.getM21() * v.y() + this.getM22() * v.z() + this.getM23() * v.w();
        v.setW(this.getM30() * v.x() + this.getM31() * v.y() + this.getM32() * v.z() + this.getM33() * v.w());
        v.setX(f);
        v.setY(f2);
        v.setZ(f3);
    }
    
    @Override
    public void transform(IPoint4<Double> v1, IPoint4<Double> v2)
    {
        double f = this.getM00() * v1.x() + this.getM01() * v1.y() + this.getM02() * v1.z() + this.getM03() * v1.w();
        double f2 = this.getM10() * v1.x() + this.getM11() * v1.y() + this.getM12() * v1.z() + this.getM13() * v1.w();
        double f3 = this.getM20() * v1.x() + this.getM21() * v1.y() + this.getM22() * v1.z() + this.getM23() * v1.w();
        v2.setW(this.getM30() * v1.x() + this.getM31() * v1.y() + this.getM32() * v1.z() + this.getM33() * v1.w());
        v2.setX(f);
        v2.setY(f2);
        v2.setZ(f3);
    }
    
    @Override
    public void transform(IPoint3<Double> v)
    {
        double f = this.getM00() * v.x() + this.getM01() * v.y() + this.getM02() * v.z();
        double f2 = this.getM10() * v.x() + this.getM11() * v.y() + this.getM12() * v.z();
        v.setZ(this.getM20() * v.x() + this.getM21() * v.y() + this.getM22() * v.z());
        v.setX(f);
        v.setY(f2);
    }
    
    @Override
    public void transform(IPoint3<Double> v1, IPoint4<Double> v2)
    {
        double f = this.getM00() * v1.x() + this.getM01() * v1.y() + this.getM02() * v1.z();
        double f2 = this.getM10() * v1.x() + this.getM11() * v1.y() + this.getM12() * v1.z();
        v2.setZ(this.getM20() * v1.x() + this.getM21() * v1.y() + this.getM22() * v1.z());
        v2.setX(f);
        v2.setY(f2);
    }
    
    @Override
    public void setRotation(IMatrix3<Double> m)
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.setM00((m.getM00() * dArray2[0]));
        this.setM01((m.getM01() * dArray2[1]));
        this.setM02((m.getM02() * dArray2[2]));
        this.setM10((m.getM10() * dArray2[0]));
        this.setM11((m.getM11() * dArray2[1]));
        this.setM12((m.getM12() * dArray2[2]));
        this.setM20((m.getM20() * dArray2[0]));
        this.setM21((m.getM21() * dArray2[1]));
        this.setM22((m.getM22() * dArray2[2]));
        
    }
    
    @Override
    public void setRotation(Quat4f quat)
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.setM00(((1.0 - 2.0 * quat.y() * quat.y() - 2.0 * quat.z() * quat.z()) * dArray2[0]));
        this.setM10((2.0 * (quat.x() * quat.y() + quat.w() * quat.z()) * dArray2[0]));
        this.setM20((2.0 * (quat.x() * quat.z() - quat.w() * quat.y()) * dArray2[0]));
        this.setM01((2.0 * (quat.x() * quat.y() - quat.w() * quat.z()) * dArray2[1]));
        this.setM11(((1.0 - 2.0 * quat.x() * quat.x() - 2.0 * quat.z() * quat.z()) * dArray2[1]));
        this.setM21((2.0 * (quat.y() * quat.z() + quat.w() * quat.x()) * dArray2[1]));
        this.setM02((2.0 * (quat.x() * quat.z() + quat.w() * quat.y()) * dArray2[2]));
        this.setM12((2.0 * (quat.y() * quat.z() - quat.w() * quat.x()) * dArray2[2]));
        this.setM22(((1.0 - 2.0 * quat.x() * quat.x() - 2.0 * quat.y() * quat.y()) * dArray2[2]));
    }
    
    @Override
    public void setRotation(Quat4d quat)
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        this.setM00(((1.0 - 2.0 * quat.y() * quat.y() - 2.0 * quat.z() * quat.z()) * dArray2[0]));
        this.setM10((2.0 * (quat.x() * quat.y() + quat.w() * quat.z()) * dArray2[0]));
        this.setM20((2.0 * (quat.x() * quat.z() - quat.w() * quat.y()) * dArray2[0]));
        this.setM01((2.0 * (quat.x() * quat.y() - quat.w() * quat.z()) * dArray2[1]));
        this.setM11(((1.0 - 2.0 * quat.x() * quat.x() - 2.0 * quat.z() * quat.z()) * dArray2[1]));
        this.setM21((2.0 * (quat.y() * quat.z() + quat.w() * quat.x()) * dArray2[1]));
        this.setM02((2.0 * (quat.x() * quat.z() + quat.w() * quat.y()) * dArray2[2]));
        this.setM12((2.0 * (quat.y() * quat.z() - quat.w() * quat.x()) * dArray2[2]));
        this.setM22(((1.0 - 2.0 * quat.x() * quat.x() - 2.0 * quat.y() * quat.y()) * dArray2[2]));
        
    }
    
    @Override
    public void setRotation(AxisAngle4<Double> aa)
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaleRotate(dArray2, dArray);
        double d = Math.sqrt(aa.x() * aa.x() + aa.y() * aa.y() + aa.z() * aa.z());
        if (d < 1.0E-8) {
            this.setM00(1.0);
            this.setM01(0.0);
            this.setM02(0.0);
            this.setM10(0.0);
            this.setM11(1.0);
            this.setM12(0.0);
            this.setM20(0.0);
            this.setM21(0.0);
            this.setM22(1.0);
        } else {
            d = 1.0 / d;
            double d2 = (double)aa.x() * d;
            double d3 = (double)aa.y() * d;
            double d4 = (double)aa.z() * d;
            double d5 = Math.sin(aa.angle());
            double d6 = Math.cos(aa.angle());
            double d7 = 1.0 - d6;
            double d8 = aa.x() * aa.z();
            double d9 = aa.x() * aa.y();
            double d10 = aa.y() * aa.z();
            this.setM00(((d7 * d2 * d2 + d6) * dArray2[0]));
            this.setM01(((d7 * d9 - d5 * d4) * dArray2[1]));
            this.setM02(((d7 * d8 + d5 * d3) * dArray2[2]));
            this.setM10(((d7 * d9 + d5 * d4) * dArray2[0]));
            this.setM11(((d7 * d3 * d3 + d6) * dArray2[1]));
            this.setM12((d7 * d10 - d5 * d2) * dArray2[2]);
            this.setM20(((d7 * d8 - d5 * d3) * dArray2[0]));
            this.setM21(((d7 * d10 + d5 * d2) * dArray2[1]));
            this.setM22(((d7 * d4 * d4 + d6) * dArray2[2]));
        }
    }
    
    @Override
    public void setZero()
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            Arrays.fill(getMatrix()[i], 0.0);
        }
    }
    
    @Override
    public void negate()
    {
        negate(this);
    }
    
    @Override
    public void negate(IMatrix4<Double> m)
    {
        for (int i = 0; i < getMatrix().length; i++)
        {
            for (int j = 0; j < getMatrix()[i].length; j++)
            {
                getMatrix()[i][j] = -m.getMatrix()[i][j];
            }
        }
    }
    
    @Override
    public void getScaleRotate(double[] dArray, double[] dArray2)
    {
        double[] dArray3 = new double[]{
                getM00(),getM01(),getM02(),
                getM10(),getM11(),getM12(),
                getM20(),getM21(),getM22()};
        Matrix3d.compute_svd(dArray3,dArray,dArray2);
    }
}