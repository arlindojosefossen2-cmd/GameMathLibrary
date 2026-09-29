package br.com.ajf.game.math.library.matrix3;

import br.com.ajf.game.math.library.axisangle4.AxisAngle4;
import br.com.ajf.game.math.library.quat4.Quat4d;
import br.com.ajf.game.math.library.quat4.Quat4f;
import br.com.ajf.game.math.library.point3.IPoint3;

import java.util.Arrays;
import java.util.Objects;

public final class Matrix3d extends Matrix3<Double>
{
    public Matrix3d()
    {
        for (int i = 0; i < this.getMatrix().length; i++)
        {
            Arrays.fill(this.getMatrix()[i], 0.0);
        }
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
        for (int i = 0; i < this.getMatrix().length; i++)
        {
            for (int j = 0; j < this.getMatrix()[i].length; j++)
            {
                this.getMatrix()[i][j] = Double.parseDouble(String.valueOf(matrix.getMatrix()[i][j]));
            }
        }
    }
    
    public Matrix3d(Double[][] matrix)
    {
        super(matrix);
    }
    
    public static void compute_svd(double[] dArray, double[] dArray3, double[] dArray2)
    {
        double d;
        int n;
        double[] dArray4 = new double[9];
        double[] dArray5 = new double[9];
        double[] dArray6 = new double[9];
        double[] dArray7 = new double[9];
        double[] dArray8 = dArray6;
        double[] dArray9 = dArray7;
        double[] dArray10 = new double[9];
        double[] dArray11 = new double[3];
        double[] dArray12 = new double[3];
        int n2 = 0;
        for (n = 0; n < 9; ++n)
        {
            dArray10[n] = dArray[n];
        }
        if (dArray[3] * dArray[3] < 1.110223024E-16) {
            dArray4[0] = 1.0;
            dArray4[1] = 0.0;
            dArray4[2] = 0.0;
            dArray4[3] = 0.0;
            dArray4[4] = 1.0;
            dArray4[5] = 0.0;
            dArray4[6] = 0.0;
            dArray4[7] = 0.0;
            dArray4[8] = 1.0;
        }
        else if (dArray[0] * dArray[0] < 1.110223024E-16) {
            dArray8[0] = dArray[0];
            dArray8[1] = dArray[1];
            dArray8[2] = dArray[2];
            dArray[0] = dArray[3];
            dArray[1] = dArray[4];
            dArray[2] = dArray[5];
            dArray[3] = -dArray8[0];
            dArray[4] = -dArray8[1];
            dArray[5] = -dArray8[2];
            dArray4[0] = 0.0;
            dArray4[1] = 1.0;
            dArray4[2] = 0.0;
            dArray4[3] = -1.0;
            dArray4[4] = 0.0;
            dArray4[5] = 0.0;
            dArray4[6] = 0.0;
            dArray4[7] = 0.0;
            dArray4[8] = 1.0;
        }
        else {
            d = 1.0 / Math.sqrt(dArray[0] * dArray[0] + dArray[3] * dArray[3]);
            double d2 = dArray[0] * d;
            double d3 = dArray[3] * d;
            dArray8[0] = d2 * dArray[0] + d3 * dArray[3];
            dArray8[1] = d2 * dArray[1] + d3 * dArray[4];
            dArray8[2] = d2 * dArray[2] + d3 * dArray[5];
            dArray[3] = -d3 * dArray[0] + d2 * dArray[3];
            dArray[4] = -d3 * dArray[1] + d2 * dArray[4];
            dArray[5] = -d3 * dArray[2] + d2 * dArray[5];
            dArray[0] = dArray8[0];
            dArray[1] = dArray8[1];
            dArray[2] = dArray8[2];
            dArray4[0] = d2;
            dArray4[1] = d3;
            dArray4[2] = 0.0;
            dArray4[3] = -d3;
            dArray4[4] = d2;
            dArray4[5] = 0.0;
            dArray4[6] = 0.0;
            dArray4[7] = 0.0;
            dArray4[8] = 1.0;
        }
        if (!(dArray[6] * dArray[6] < 1.110223024E-16)) {
            if (dArray[0] * dArray[0] < 1.110223024E-16) {
                dArray8[0] = dArray[0];
                dArray8[1] = dArray[1];
                dArray8[2] = dArray[2];
                dArray[0] = dArray[6];
                dArray[1] = dArray[7];
                dArray[2] = dArray[8];
                dArray[6] = -dArray8[0];
                dArray[7] = -dArray8[1];
                dArray[8] = -dArray8[2];
                dArray8[0] = dArray4[0];
                dArray8[1] = dArray4[1];
                dArray8[2] = dArray4[2];
                dArray4[0] = dArray4[6];
                dArray4[1] = dArray4[7];
                dArray4[2] = dArray4[8];
                dArray4[6] = -dArray8[0];
                dArray4[7] = -dArray8[1];
                dArray4[8] = -dArray8[2];
            }
            else {
                d = 1.0 / Math.sqrt(dArray[0] * dArray[0] + dArray[6] * dArray[6]);
                double d4 = dArray[0] * d;
                double d5 = dArray[6] * d;
                dArray8[0] = d4 * dArray[0] + d5 * dArray[6];
                dArray8[1] = d4 * dArray[1] + d5 * dArray[7];
                dArray8[2] = d4 * dArray[2] + d5 * dArray[8];
                dArray[6] = -d5 * dArray[0] + d4 * dArray[6];
                dArray[7] = -d5 * dArray[1] + d4 * dArray[7];
                dArray[8] = -d5 * dArray[2] + d4 * dArray[8];
                dArray[0] = dArray8[0];
                dArray[1] = dArray8[1];
                dArray[2] = dArray8[2];
                dArray8[0] = d4 * dArray4[0];
                dArray8[1] = d4 * dArray4[1];
                dArray4[2] = d5;
                dArray8[6] = -dArray4[0] * d5;
                dArray8[7] = -dArray4[1] * d5;
                dArray4[8] = d4;
                dArray4[0] = dArray8[0];
                dArray4[1] = dArray8[1];
                dArray4[6] = dArray8[6];
                dArray4[7] = dArray8[7];
            }
        }
        if (dArray[2] * dArray[2] < 1.110223024E-16) {
            dArray5[0] = 1.0;
            dArray5[1] = 0.0;
            dArray5[2] = 0.0;
            dArray5[3] = 0.0;
            dArray5[4] = 1.0;
            dArray5[5] = 0.0;
            dArray5[6] = 0.0;
            dArray5[7] = 0.0;
            dArray5[8] = 1.0;
        }
        else if (dArray[1] * dArray[1] < 1.110223024E-16) {
            dArray8[2] = dArray[2];
            dArray8[5] = dArray[5];
            dArray8[8] = dArray[8];
            dArray[2] = -dArray[1];
            dArray[5] = -dArray[4];
            dArray[8] = -dArray[7];
            dArray[1] = dArray8[2];
            dArray[4] = dArray8[5];
            dArray[7] = dArray8[8];
            dArray5[0] = 1.0;
            dArray5[1] = 0.0;
            dArray5[2] = 0.0;
            dArray5[3] = 0.0;
            dArray5[4] = 0.0;
            dArray5[5] = -1.0;
            dArray5[6] = 0.0;
            dArray5[7] = 1.0;
            dArray5[8] = 0.0;
        }
        else {
            d = 1.0 / Math.sqrt(dArray[1] * dArray[1] + dArray[2] * dArray[2]);
            double d6 = dArray[1] * d;
            double d7 = dArray[2] * d;
            dArray8[1] = d6 * dArray[1] + d7 * dArray[2];
            dArray[2] = -d7 * dArray[1] + d6 * dArray[2];
            dArray[1] = dArray8[1];
            dArray8[4] = d6 * dArray[4] + d7 * dArray[5];
            dArray[5] = -d7 * dArray[4] + d6 * dArray[5];
            dArray[4] = dArray8[4];
            dArray8[7] = d6 * dArray[7] + d7 * dArray[8];
            dArray[8] = -d7 * dArray[7] + d6 * dArray[8];
            dArray[7] = dArray8[7];
            dArray5[0] = 1.0;
            dArray5[1] = 0.0;
            dArray5[2] = 0.0;
            dArray5[3] = 0.0;
            dArray5[4] = d6;
            dArray5[5] = -d7;
            dArray5[6] = 0.0;
            dArray5[7] = d7;
            dArray5[8] = d6;
        }
        if (!(dArray[7] * dArray[7] < 1.110223024E-16)) {
            if (dArray[4] * dArray[4] < 1.110223024E-16) {
                dArray8[3] = dArray[3];
                dArray8[4] = dArray[4];
                dArray8[5] = dArray[5];
                dArray[3] = dArray[6];
                dArray[4] = dArray[7];
                dArray[5] = dArray[8];
                dArray[6] = -dArray8[3];
                dArray[7] = -dArray8[4];
                dArray[8] = -dArray8[5];
                dArray8[3] = dArray4[3];
                dArray8[4] = dArray4[4];
                dArray8[5] = dArray4[5];
                dArray4[3] = dArray4[6];
                dArray4[4] = dArray4[7];
                dArray4[5] = dArray4[8];
                dArray4[6] = -dArray8[3];
                dArray4[7] = -dArray8[4];
                dArray4[8] = -dArray8[5];
            }
            else {
                d = 1.0 / Math.sqrt(dArray[4] * dArray[4] + dArray[7] * dArray[7]);
                double d8 = dArray[4] * d;
                double d9 = dArray[7] * d;
                dArray8[3] = d8 * dArray[3] + d9 * dArray[6];
                dArray[6] = -d9 * dArray[3] + d8 * dArray[6];
                dArray[3] = dArray8[3];
                dArray8[4] = d8 * dArray[4] + d9 * dArray[7];
                dArray[7] = -d9 * dArray[4] + d8 * dArray[7];
                dArray[4] = dArray8[4];
                dArray8[5] = d8 * dArray[5] + d9 * dArray[8];
                dArray[8] = -d9 * dArray[5] + d8 * dArray[8];
                dArray[5] = dArray8[5];
                dArray8[3] = d8 * dArray4[3] + d9 * dArray4[6];
                dArray4[6] = -d9 * dArray4[3] + d8 * dArray4[6];
                dArray4[3] = dArray8[3];
                dArray8[4] = d8 * dArray4[4] + d9 * dArray4[7];
                dArray4[7] = -d9 * dArray4[4] + d8 * dArray4[7];
                dArray4[4] = dArray8[4];
                dArray8[5] = d8 * dArray4[5] + d9 * dArray4[8];
                dArray4[8] = -d9 * dArray4[5] + d8 * dArray4[8];
                dArray4[5] = dArray8[5];
            }
        }
        dArray9[0] = dArray[0];
        dArray9[1] = dArray[4];
        dArray9[2] = dArray[8];
        dArray11[0] = dArray[1];
        dArray11[1] = dArray[5];
        if (!(dArray11[0] * dArray11[0] < 1.110223024E-16) || !(dArray11[1] * dArray11[1] < 1.110223024E-16)) {
            Matrix3d.compute_qr(dArray9, dArray11, dArray4, dArray5);
        }
        dArray12[0] = dArray9[0];
        dArray12[1] = dArray9[1];
        dArray12[2] = dArray9[2];
        if (Matrix3d.almostEqual(Math.abs(dArray12[0]), 1.0) && Matrix3d.almostEqual(Math.abs(dArray12[1]), 1.0) &&
            Matrix3d.almostEqual(Math.abs(dArray12[2]), 1.0)) {
            for (n = 0; n < 3; ++n) {
                if (!(dArray12[n] < 0.0)) continue;
                ++n2;
            }
            if (n2 == 0 || n2 == 2) {
                dArray2[2] = 1.0;
                dArray2[1] = 1.0;
                dArray2[0] = 1.0;
                for (n = 0; n < 9; ++n) {
                    dArray3[n] = dArray10[n];
                }
                return;
            }
        }
        Matrix3d.transpose_mat(dArray4, dArray6);
        Matrix3d.transpose_mat(dArray5, dArray7);
        Matrix3d.svdReorder(dArray, dArray6, dArray7, dArray12, dArray3, dArray2);
    }
    
    public static int compute_qr(double[] dArray,
                                  double[] dArray2,
                                  double[] dArray3,
                                  double[] dArray4)
    {
        double d;
        double d2;
        double[] dArray5 = new double[2];
        double[] dArray6 = new double[2];
        double[] dArray7 = new double[2];
        double[] dArray8 = new double[2];
        double[] dArray9 = new double[9];
        double d3 = 1.0;
        double d4 = -1.0;
        boolean bl = false;
        int n = 1;
        if (Math.abs(dArray2[1]) < 4.89E-15 || Math.abs(dArray2[0]) < 4.89E-15) {
            bl = true;
        }
        for (int i = 0; i < 10 && !bl; ++i) {
            double d5 = Matrix3d.compute_shift(dArray[1], dArray2[1], dArray[2]);
            double d6 = (Math.abs(dArray[0]) - d5) * (Matrix3d.d_sign(d3, dArray[0]) + d5 / dArray[0]);
            double d7 = dArray2[0];
            double d8 = Matrix3d.compute_rot(d6, d7, dArray8, dArray6, 0, n);
            d6 = dArray6[0] * dArray[0] + dArray8[0] * dArray2[0];
            dArray2[0] = dArray6[0] * dArray2[0] - dArray8[0] * dArray[0];
            d7 = dArray8[0] * dArray[1];
            dArray[1] = dArray6[0] * dArray[1];
            d8 = Matrix3d.compute_rot(d6, d7, dArray7, dArray5, 0, n);
            n = 0;
            dArray[0] = d8;
            d6 = dArray5[0] * dArray2[0] + dArray7[0] * dArray[1];
            dArray[1] = dArray5[0] * dArray[1] - dArray7[0] * dArray2[0];
            d7 = dArray7[0] * dArray2[1];
            dArray2[1] = dArray5[0] * dArray2[1];
            dArray2[0] = d8 = Matrix3d.compute_rot(d6, d7, dArray8, dArray6, 1, n);
            d6 = dArray6[1] * dArray[1] + dArray8[1] * dArray2[1];
            dArray2[1] = dArray6[1] * dArray2[1] - dArray8[1] * dArray[1];
            d7 = dArray8[1] * dArray[2];
            dArray[2] = dArray6[1] * dArray[2];
            dArray[1] = d8 = Matrix3d.compute_rot(d6, d7, dArray7, dArray5, 1, n);
            d6 = dArray5[1] * dArray2[1] + dArray7[1] * dArray[2];
            dArray[2] = dArray5[1] * dArray[2] - dArray7[1] * dArray2[1];
            dArray2[1] = d6;
            d2 = dArray3[0];
            dArray3[0] = dArray5[0] * d2 + dArray7[0] * dArray3[3];
            dArray3[3] = -dArray7[0] * d2 + dArray5[0] * dArray3[3];
            d2 = dArray3[1];
            dArray3[1] = dArray5[0] * d2 + dArray7[0] * dArray3[4];
            dArray3[4] = -dArray7[0] * d2 + dArray5[0] * dArray3[4];
            d2 = dArray3[2];
            dArray3[2] = dArray5[0] * d2 + dArray7[0] * dArray3[5];
            dArray3[5] = -dArray7[0] * d2 + dArray5[0] * dArray3[5];
            d2 = dArray3[3];
            dArray3[3] = dArray5[1] * d2 + dArray7[1] * dArray3[6];
            dArray3[6] = -dArray7[1] * d2 + dArray5[1] * dArray3[6];
            d2 = dArray3[4];
            dArray3[4] = dArray5[1] * d2 + dArray7[1] * dArray3[7];
            dArray3[7] = -dArray7[1] * d2 + dArray5[1] * dArray3[7];
            d2 = dArray3[5];
            dArray3[5] = dArray5[1] * d2 + dArray7[1] * dArray3[8];
            dArray3[8] = -dArray7[1] * d2 + dArray5[1] * dArray3[8];
            d = dArray4[0];
            dArray4[0] = dArray6[0] * d + dArray8[0] * dArray4[1];
            dArray4[1] = -dArray8[0] * d + dArray6[0] * dArray4[1];
            d = dArray4[3];
            dArray4[3] = dArray6[0] * d + dArray8[0] * dArray4[4];
            dArray4[4] = -dArray8[0] * d + dArray6[0] * dArray4[4];
            d = dArray4[6];
            dArray4[6] = dArray6[0] * d + dArray8[0] * dArray4[7];
            dArray4[7] = -dArray8[0] * d + dArray6[0] * dArray4[7];
            d = dArray4[1];
            dArray4[1] = dArray6[1] * d + dArray8[1] * dArray4[2];
            dArray4[2] = -dArray8[1] * d + dArray6[1] * dArray4[2];
            d = dArray4[4];
            dArray4[4] = dArray6[1] * d + dArray8[1] * dArray4[5];
            dArray4[5] = -dArray8[1] * d + dArray6[1] * dArray4[5];
            d = dArray4[7];
            dArray4[7] = dArray6[1] * d + dArray8[1] * dArray4[8];
            dArray4[8] = -dArray8[1] * d + dArray6[1] * dArray4[8];
            dArray9[0] = dArray[0];
            dArray9[1] = dArray2[0];
            dArray9[2] = 0.0;
            dArray9[3] = 0.0;
            dArray9[4] = dArray[1];
            dArray9[5] = dArray2[1];
            dArray9[6] = 0.0;
            dArray9[7] = 0.0;
            dArray9[8] = dArray[2];
            if (!(Math.abs(dArray2[1]) < 4.89E-15) && !(Math.abs(dArray2[0]) < 4.89E-15)) continue;
            bl = true;
        }
        if (Math.abs(dArray2[1]) < 4.89E-15) {
            Matrix3d.compute_2X2(dArray[0], dArray2[0], dArray[1], dArray, dArray7, dArray5, dArray8, dArray6, 0);
            d2 = dArray3[0];
            dArray3[0] = dArray5[0] * d2 + dArray7[0] * dArray3[3];
            dArray3[3] = -dArray7[0] * d2 + dArray5[0] * dArray3[3];
            d2 = dArray3[1];
            dArray3[1] = dArray5[0] * d2 + dArray7[0] * dArray3[4];
            dArray3[4] = -dArray7[0] * d2 + dArray5[0] * dArray3[4];
            d2 = dArray3[2];
            dArray3[2] = dArray5[0] * d2 + dArray7[0] * dArray3[5];
            dArray3[5] = -dArray7[0] * d2 + dArray5[0] * dArray3[5];
            d = dArray4[0];
            dArray4[0] = dArray6[0] * d + dArray8[0] * dArray4[1];
            dArray4[1] = -dArray8[0] * d + dArray6[0] * dArray4[1];
            d = dArray4[3];
            dArray4[3] = dArray6[0] * d + dArray8[0] * dArray4[4];
            dArray4[4] = -dArray8[0] * d + dArray6[0] * dArray4[4];
            d = dArray4[6];
            dArray4[6] = dArray6[0] * d + dArray8[0] * dArray4[7];
            dArray4[7] = -dArray8[0] * d + dArray6[0] * dArray4[7];
        } else {
            Matrix3d.compute_2X2(dArray[1], dArray2[1], dArray[2], dArray, dArray7, dArray5, dArray8, dArray6, 1);
            d2 = dArray3[3];
            dArray3[3] = dArray5[0] * d2 + dArray7[0] * dArray3[6];
            dArray3[6] = -dArray7[0] * d2 + dArray5[0] * dArray3[6];
            d2 = dArray3[4];
            dArray3[4] = dArray5[0] * d2 + dArray7[0] * dArray3[7];
            dArray3[7] = -dArray7[0] * d2 + dArray5[0] * dArray3[7];
            d2 = dArray3[5];
            dArray3[5] = dArray5[0] * d2 + dArray7[0] * dArray3[8];
            dArray3[8] = -dArray7[0] * d2 + dArray5[0] * dArray3[8];
            d = dArray4[1];
            dArray4[1] = dArray6[0] * d + dArray8[0] * dArray4[2];
            dArray4[2] = -dArray8[0] * d + dArray6[0] * dArray4[2];
            d = dArray4[4];
            dArray4[4] = dArray6[0] * d + dArray8[0] * dArray4[5];
            dArray4[5] = -dArray8[0] * d + dArray6[0] * dArray4[5];
            d = dArray4[7];
            dArray4[7] = dArray6[0] * d + dArray8[0] * dArray4[8];
            dArray4[8] = -dArray8[0] * d + dArray6[0] * dArray4[8];
        }
        return 0;
    }
    
    static int compute_2X2(double d, double d2, double d3, double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4, double[] dArray5, int n) {
        double d4;
        double d5;
        double d6 = 2.0;
        double d7 = 1.0;
        double d8 = dArray[0];
        double d9 = dArray[1];
        double d10 = 0.0;
        double d11 = 0.0;
        double d12 = 0.0;
        double d13 = 0.0;
        double d14 = 0.0;
        double d15 = d;
        double d16 = Math.abs(d15);
        double d17 = d3;
        double d18 = Math.abs(d3);
        int n2 = 1;
        boolean bl = d18 > d16;
        if (bl) {
            n2 = 3;
            double d19 = d15;
            d15 = d17;
            d17 = d19;
            d19 = d16;
            d16 = d18;
            d18 = d19;
        }
        if ((d5 = Math.abs(d4 = d2)) == 0.0) {
            dArray[1] = d18;
            dArray[0] = d16;
            d10 = 1.0;
            d11 = 1.0;
            d12 = 0.0;
            d13 = 0.0;
        } else {
            boolean bl2 = true;
            if (d5 > d16) {
                n2 = 2;
                if (d16 / d5 < 1.110223024E-16) {
                    bl2 = false;
                    d8 = d5;
                    d9 = d18 > 1.0 ? d16 / (d5 / d18) : d16 / d5 * d18;
                    d10 = 1.0;
                    d12 = d17 / d4;
                    d13 = 1.0;
                    d11 = d15 / d4;
                }
            }
            if (bl2) {
                double d20 = d16 - d18;
                double d21 = d20 == d16 ? 1.0 : d20 / d16;
                double d22 = d4 / d15;
                double d23 = 2.0 - d21;
                double d24 = d22 * d22;
                double d25 = d23 * d23;
                double d26 = Math.sqrt(d25 + d24);
                double d27 = d21 == 0.0 ? Math.abs(d22) : Math.sqrt(d21 * d21 + d24);
                double d28 = (d26 + d27) * 0.5;
                if (d5 > d16) {
                    n2 = 2;
                    if (d16 / d5 < 1.110223024E-16) {
                        bl2 = false;
                        d8 = d5;
                        d9 = d18 > 1.0 ? d16 / (d5 / d18) : d16 / d5 * d18;
                        d10 = 1.0;
                        d12 = d17 / d4;
                        d13 = 1.0;
                        d11 = d15 / d4;
                    }
                }
                if (bl2) {
                    d20 = d16 - d18;
                    d21 = d20 == d16 ? 1.0 : d20 / d16;
                    d22 = d4 / d15;
                    d23 = 2.0 - d21;
                    d24 = d22 * d22;
                    d25 = d23 * d23;
                    d26 = Math.sqrt(d25 + d24);
                    d27 = d21 == 0.0 ? Math.abs(d22) : Math.sqrt(d21 * d21 + d24);
                    d28 = (d26 + d27) * 0.5;
                    d9 = d18 / d28;
                    d8 = d16 * d28;
                    d23 = d24 == 0.0 ? (d21 == 0.0 ? Matrix3d.d_sign(d6, d15) * Matrix3d.d_sign(d7, d4) : d4 / Matrix3d.d_sign(d20, d15) + d22 / d23) : (d22 / (d26 + d23) + d22 / (d27 + d21)) * (d28 + 1.0);
                    d21 = Math.sqrt(d23 * d23 + 4.0);
                    d11 = 2.0 / d21;
                    d13 = d23 / d21;
                    d10 = (d11 + d13 * d22) / d28;
                    d12 = d17 / d15 * d13 / d28;
                }
            }
            if (bl) {
                dArray3[0] = d13;
                dArray2[0] = d11;
                dArray5[0] = d12;
                dArray4[0] = d10;
            } else {
                dArray3[0] = d10;
                dArray2[0] = d12;
                dArray5[0] = d11;
                dArray4[0] = d13;
            }
            if (n2 == 1) {
                d14 = Matrix3d.d_sign(d7, dArray5[0]) * Matrix3d.d_sign(d7, dArray3[0]) * Matrix3d.d_sign(d7, d);
            }
            if (n2 == 2) {
                d14 = Matrix3d.d_sign(d7, dArray4[0]) * Matrix3d.d_sign(d7, dArray3[0]) * Matrix3d.d_sign(d7, d2);
            }
            if (n2 == 3) {
                d14 = Matrix3d.d_sign(d7, dArray4[0]) * Matrix3d.d_sign(d7, dArray2[0]) * Matrix3d.d_sign(d7, d3);
            }
            dArray[n] = Matrix3d.d_sign(d8, d14);
            double d29 = d14 * Matrix3d.d_sign(d7, d) * Matrix3d.d_sign(d7, d3);
            dArray[n + 1] = Matrix3d.d_sign(d9, d29);
        }
        return 0;
    }
    
    static double compute_rot(double d, double d2, double[] dArray, double[] dArray2, int n, int n2) {
        double d3;
        double d4;
        double d5;
        if (d2 == 0.0) {
            d5 = 1.0;
            d4 = 0.0;
            d3 = d;
        } else if (d == 0.0) {
            d5 = 0.0;
            d4 = 1.0;
            d3 = d2;
        } else {
            double d6 = d;
            double d7 = d2;
            double d8 = Matrix3d.max(Math.abs(d6), Math.abs(d7));
            if (d8 >= 4.994797680505588E145) {
                int n3 = 0;
                while (d8 >= 4.994797680505588E145) {
                    ++n3;
                    d8 = Matrix3d.max(Math.abs(d6 *= 2.002083095183101E-146), Math.abs(d7 *= 2.002083095183101E-146));
                }
                d3 = Math.sqrt(d6 * d6 + d7 * d7);
                d5 = d6 / d3;
                d4 = d7 / d3;
                int n4 = n3;
                for (int i = 1; i <= n3; ++i) {
                    d3 *= 4.994797680505588E145;
                }
            } else if (d8 <= 2.002083095183101E-146) {
                int n5 = 0;
                while (d8 <= 2.002083095183101E-146) {
                    ++n5;
                    d8 = Matrix3d.max(Math.abs(d6 *= 4.994797680505588E145), Math.abs(d7 *= 4.994797680505588E145));
                }
                d3 = Math.sqrt(d6 * d6 + d7 * d7);
                d5 = d6 / d3;
                d4 = d7 / d3;
                int n6 = n5;
                for (int i = 1; i <= n5; ++i) {
                    d3 *= 2.002083095183101E-146;
                }
            } else {
                d3 = Math.sqrt(d6 * d6 + d7 * d7);
                d5 = d6 / d3;
                d4 = d7 / d3;
            }
            if (Math.abs(d) > Math.abs(d2) && d5 < 0.0) {
                d5 = -d5;
                d4 = -d4;
                d3 = -d3;
            }
        }
        dArray[n] = d4;
        dArray2[n] = d5;
        return d3;
    }
    
    static void mat_mul(double[] dArray, double[] dArray2, double[] dArray3) {
        double[] dArray4 = new double[]{dArray[0] * dArray2[0] + dArray[1] * dArray2[3] + dArray[2] * dArray2[6], dArray[0] * dArray2[1] + dArray[1] * dArray2[4] + dArray[2] * dArray2[7], dArray[0] * dArray2[2] + dArray[1] * dArray2[5] + dArray[2] * dArray2[8], dArray[3] * dArray2[0] + dArray[4] * dArray2[3] + dArray[5] * dArray2[6], dArray[3] * dArray2[1] + dArray[4] * dArray2[4] + dArray[5] * dArray2[7], dArray[3] * dArray2[2] + dArray[4] * dArray2[5] + dArray[5] * dArray2[8], dArray[6] * dArray2[0] + dArray[7] * dArray2[3] + dArray[8] * dArray2[6], dArray[6] * dArray2[1] + dArray[7] * dArray2[4] + dArray[8] * dArray2[7], dArray[6] * dArray2[2] + dArray[7] * dArray2[5] + dArray[8] * dArray2[8]};
        System.arraycopy(dArray4, 0, dArray3, 0, 9);
    }
    
    static void transpose_mat(double[] dArray, double[] dArray2) {
        dArray2[0] = dArray[0];
        dArray2[1] = dArray[3];
        dArray2[2] = dArray[6];
        dArray2[3] = dArray[1];
        dArray2[4] = dArray[4];
        dArray2[5] = dArray[7];
        dArray2[6] = dArray[2];
        dArray2[7] = dArray[5];
        dArray2[8] = dArray[8];
    }
    
    static double max3(double[] dArray) {
        if (dArray[0] > dArray[1]) {
            return Math.max(dArray[0], dArray[2]);
        }
        return Math.max(dArray[1], dArray[2]);
    }
    
    private static boolean almostEqual(double d, double d2) {
        double d3;
        double d4;
        if (d == d2) {
            return true;
        }
        double d5 = Math.abs(d - d2);
        double d6 = Math.abs(d);
        double d7 = d4 = d6 >= (d3 = Math.abs(d2)) ? d6 : d3;
        if (d5 < 1.0E-6) {
            return true;
        }
        return d5 / d4 < 1.0E-4;
    }
    
    public IMatrix3<Double> clone() {
        Matrix3d matrix3d = null;
        matrix3d = (Matrix3d)super.clone();
        return matrix3d;
    }
    
    static void print_mat(double[] dArray) {
        for (int i = 0; i < 3; ++i) {
            System.out.println(dArray[i * 3] + " " + dArray[i * 3 + 1] + " " + dArray[i * 3 + 2] + "\n");
        }
    }
    
    static void print_det(double[] dArray) {
        double d = dArray[0] * dArray[4] * dArray[8] + dArray[1] * dArray[5] * dArray[6] + dArray[2] * dArray[3] * dArray[7] - dArray[2] * dArray[4] * dArray[6] - dArray[0] * dArray[5] * dArray[7] - dArray[1] * dArray[3] * dArray[8];
        System.out.println("det= " + d);
    }
    
    static double max(double d, double d2) {
        return Math.max(d, d2);
    }
    
    static double min(double d, double d2) {
        return Math.min(d, d2);
    }
    
    static double d_sign(double d, double d2) {
        double d3 = d >= 0.0 ? d : -d;
        return d2 >= 0.0 ? d3 : -d3;
    }
    
    static double compute_shift(double d, double d2, double d3) {
        double d4;
        double d5 = Math.abs(d);
        double d6 = Math.abs(d2);
        double d7 = Math.abs(d3);
        double d8 = Matrix3d.min(d5, d7);
        double d9 = Matrix3d.max(d5, d7);
        if (d8 == 0.0) {
            d4 = 0.0;
            if (d9 != 0.0) {
                double d10 = Matrix3d.min(d9, d6) / Matrix3d.max(d9, d6);
            }
        } else if (d6 < d9) {
            double d11 = d8 / d9 + 1.0;
            double d12 = (d9 - d8) / d9;
            double d13 = d6 / d9;
            double d14 = d13 * d13;
            double d15 = 2.0 / (Math.sqrt(d11 * d11 + d14) + Math.sqrt(d12 * d12 + d14));
            d4 = d8 * d15;
        } else {
            double d16 = d9 / d6;
            if (d16 == 0.0) {
                d4 = d8 * d9 / d6;
            } else {
                double d17 = d8 / d9 + 1.0;
                double d18 = (d9 - d8) / d9;
                double d19 = d17 * d16;
                double d20 = d18 * d16;
                double d21 = 1.0 / (Math.sqrt(d19 * d19 + 1.0) + Math.sqrt(d20 * d20 + 1.0));
                d4 = d8 * d21 * d16;
                d4 += d4;
            }
        }
        return d4;
    }
    
    public static void svdReorder(double[] dArray, double[] dArray2, double[] dArray3,
                                  double[] dArray4, double[] dArray5, double[] dArray6)
    {
        int[] nArray = new int[3];
        int[] nArray2 = new int[3];
        double[] dArray7 = new double[3];
        double[] dArray8 = new double[9];
        if (dArray4[0] < 0.0) {
            dArray4[0] = -dArray4[0];
            dArray3[0] = -dArray3[0];
            dArray3[1] = -dArray3[1];
            dArray3[2] = -dArray3[2];
        }
        if (dArray4[1] < 0.0) {
            dArray4[1] = -dArray4[1];
            dArray3[3] = -dArray3[3];
            dArray3[4] = -dArray3[4];
            dArray3[5] = -dArray3[5];
        }
        if (dArray4[2] < 0.0) {
            dArray4[2] = -dArray4[2];
            dArray3[6] = -dArray3[6];
            dArray3[7] = -dArray3[7];
            dArray3[8] = -dArray3[8];
        }
        Matrix3d.mat_mul(dArray2, dArray3, dArray8);
        if (Matrix3d.almostEqual(Math.abs(dArray4[0]), Math.abs(dArray4[1])) && Matrix3d.almostEqual(Math.abs(dArray4[1]), Math.abs(dArray4[2]))) {
            int n;
            for (n = 0; n < 9; ++n) {
                dArray5[n] = dArray8[n];
            }
            for (n = 0; n < 3; ++n) {
                dArray6[n] = dArray4[n];
            }
        } else {
            int n;
            int n2;
            int n3;
            if (dArray4[0] > dArray4[1]) {
                if (dArray4[0] > dArray4[2]) {
                    if (dArray4[2] > dArray4[1]) {
                        nArray[0] = 0;
                        nArray[1] = 2;
                        nArray[2] = 1;
                    } else {
                        nArray[0] = 0;
                        nArray[1] = 1;
                        nArray[2] = 2;
                    }
                } else {
                    nArray[0] = 2;
                    nArray[1] = 0;
                    nArray[2] = 1;
                }
            } else if (dArray4[1] > dArray4[2]) {
                if (dArray4[2] > dArray4[0]) {
                    nArray[0] = 1;
                    nArray[1] = 2;
                    nArray[2] = 0;
                } else {
                    nArray[0] = 1;
                    nArray[1] = 0;
                    nArray[2] = 2;
                }
            } else {
                nArray[0] = 2;
                nArray[1] = 1;
                nArray[2] = 0;
            }
            dArray7[0] = dArray[0] * dArray[0] + dArray[1] * dArray[1] + dArray[2] * dArray[2];
            dArray7[1] = dArray[3] * dArray[3] + dArray[4] * dArray[4] + dArray[5] * dArray[5];
            dArray7[2] = dArray[6] * dArray[6] + dArray[7] * dArray[7] + dArray[8] * dArray[8];
            if (dArray7[0] > dArray7[1]) {
                if (dArray7[0] > dArray7[2]) {
                    n3 = 0;
                    if (dArray7[2] > dArray7[1]) {
                        n2 = 1;
                        n = 2;
                    } else {
                        n = 1;
                        n2 = 2;
                    }
                } else {
                    n2 = 0;
                    n3 = 1;
                    n = 2;
                }
            } else if (dArray7[1] > dArray7[2]) {
                n = 0;
                if (dArray7[2] > dArray7[0]) {
                    n2 = 1;
                    n3 = 2;
                } else {
                    n3 = 1;
                    n2 = 2;
                }
            } else {
                n2 = 0;
                n = 1;
                n3 = 2;
            }
            int n4 = nArray[n3];
            dArray6[0] = dArray4[n4];
            n4 = nArray[n];
            dArray6[1] = dArray4[n4];
            n4 = nArray[n2];
            dArray6[2] = dArray4[n4];
            n4 = nArray[n3];
            dArray5[0] = dArray8[n4];
            n4 = nArray[n3] + 3;
            dArray5[3] = dArray8[n4];
            n4 = nArray[n3] + 6;
            dArray5[6] = dArray8[n4];
            n4 = nArray[n];
            dArray5[1] = dArray8[n4];
            n4 = nArray[n] + 3;
            dArray5[4] = dArray8[n4];
            n4 = nArray[n] + 6;
            dArray5[7] = dArray8[n4];
            n4 = nArray[n2];
            dArray5[2] = dArray8[n4];
            n4 = nArray[n2] + 3;
            dArray5[5] = dArray8[n4];
            n4 = nArray[n2] + 6;
            dArray5[8] = dArray8[n4];
        }
    }
    
    @Override
    public void setIdentity()
    {
        for (int r = 0; r < getMatrix().length; r++)
        {
            for (int c = 0; c < getMatrix()[r].length; c++)
            {
                getMatrix()[r][c] = r == c ? 1.0 : 0.0;
            }
        }
    }
    
    @Override
    public void setScale(Double s)
    {
        for (int r = 0; r < getMatrix().length; r++)
        {
            for (int c = 0; c < getMatrix()[r].length; c++)
            {
                getMatrix()[r][c] *= s;
            }
        }
    }
    
    @Override
    public void setElement(int n, int n2, Double v)
    {
        if(n < 0 || n >= getMatrix().length || n2 < 0 || n2 >= getMatrix()[0].length || v == null)
        {
            return;
        }
        
        getMatrix()[n][n2] = v;
    }
    
    @Override
    public void getRow(int n, IPoint3<Double> v)
    {
        if(n < 0 || n >= getMatrix().length || v == null)
        {
            return;
        }
        v.set(getMatrix()[n][0], getMatrix()[n][1], getMatrix()[n][2]);
    }
    
    @Override
    public void getRow(int n, Double[] array)
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
    public void getColumn(int n, IPoint3<Double> v)
    {
        if(n < 0 || n >= getMatrix().length || v == null)
        {
            return;
        }
        v.set(getMatrix()[0][n], getMatrix()[1][n], getMatrix()[2][n]);
    }
    
    @Override
    public void getColumn(int n, Double[] array)
    {
        if(n < 0 || n >= getMatrix().length || array == null || array.length < 3)
        {
            return;
        }
        array[0] = getMatrix()[0][n];
        array[1] = getMatrix()[1][n];
        array[2] = getMatrix()[2][n];
    }
    
    @Override
    public Double getElement(int n, int n2)
    {
        if(n >= getMatrix().length || n < 0 || n2 >= getMatrix()[0].length || n2 < 0)
        {
            return null;
        }
        return getMatrix()[n][n2];
    }
    
    @Override
    public void setRow(int n, Double n1, Double n2, Double n3)
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
    public void setRow(int n, IPoint3<Double> v)
    {
        if(v == null)
        {
            return;
        }
        
        setRow(n,v.x(),v.y(),v.z());
    }
    
    @Override
    public void setRow(int n, Double[] array)
    {
        if(array == null || array.length < 3)
        {
            return;
        }
        setRow(n,array[0],array[1],array[2]);
    }
    
    @Override
    public void setColumn(int n, Double n1, Double n2, Double n3)
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
    public void setColumn(int n, IPoint3<Double> v)
    {
        if(v == null)
        {
            return;
        }
        
        setColumn(n,v.x(),v.y(),v.z());
    }
    
    @Override
    public void setColumn(int n, Double[] array)
    {
        if(array == null || array.length < 3)
        {
            return;
        }
        setColumn(n,array[0],array[1],array[2]);
    }
    
    @Override
    public Double getScale()
    {
        double[] dArray = new double[9];
        double[] dArray2 = new double[3];
        this.getScaledRotate(dArray2,dArray);
        return Matrix3d.max3(dArray2);
    }
    
    @Override
    public void add(Double v)
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
    public void add(Double v, IMatrix3<Double> m)
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
    public void add(IMatrix3<Double> m1, IMatrix3<Double> m2)
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
    public void add(IMatrix3<Double> m)
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
    public void sub(IMatrix3<Double> m1, IMatrix3<Double> m2)
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
    public void sub(IMatrix3<Double> m)
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
        double f = this.getM10();
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
    public void transpose(IMatrix3<Double> m)
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
    public void set(Double[][] m)
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
    public void set(IMatrix3<Double> m)
    {
        set(m.getMatrix());
    }
    
    public void set(Matrix3f m)
    {
        set(Double.valueOf(String.valueOf(m.getMatrix()[0][0])),
                Double.valueOf(String.valueOf(m.getMatrix()[0][1])),
                Double.valueOf(String.valueOf(m.getMatrix()[0][2])),
                Double.valueOf(String.valueOf(m.getMatrix()[1][0])),
                Double.valueOf(String.valueOf(m.getMatrix()[1][1])),
                Double.valueOf(String.valueOf(m.getMatrix()[1][2])),
                Double.valueOf(String.valueOf(m.getMatrix()[2][0])),
                Double.valueOf(String.valueOf(m.getMatrix()[2][1])),
                Double.valueOf(String.valueOf(m.getMatrix()[2][2]))  );
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
            int n4 = -1;
            for (int j = 0; j < 3; ++j) {
                int n5 = nArray[n + j];
                double d = dArray2[i + 3 * n5];
                dArray2[i + 3 * n5] = dArray2[i + 3 * j];
                if (n4 >= 0) {
                    n2 = j * 3;
                    for (int k = n4; k <= j - 1; ++k) {
                        d -= dArray[n2 + k] * dArray2[i + 3 * k];
                    }
                } else if (d != 0.0) {
                    n4 = j;
                }
                dArray2[i + 3 * j] = d;
            }
            n2 = 6;
            int n6 = i + 6;
            dArray2[n6] = dArray2[n6] / dArray[n2 + 2];
            dArray2[i + 3] = (dArray2[i + 3] - dArray[(n2 -= 3) + 2] * dArray2[i + 6]) / dArray[n2 + 1];
            dArray2[i] = (dArray2[i] - dArray[(n2 -= 3) + 1] * dArray2[i + 3] - dArray[n2 + 2] * dArray2[i + 6]) / dArray[n2];
        }
    }
    
    @Override
    public void invert()
    {
        invertGeneral(this);
    }
    
    @Override
    public void invert(IMatrix3<Double> m)
    {
        invertGeneral(m);
    }
    
    @Override
    public void invertGeneral(IMatrix3<Double> m)
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
        
        set(dArray2[0],dArray2[1],dArray2[2],dArray2[3],dArray2[4],dArray2[5],dArray2[6],dArray2[7],dArray2[8]);
    }
    
    @Override
    public Double determinate()
    {
        return this.getM00()*(this.getM11()*this.getM22()-this.getM12()*this.getM21())+
               this.getM01()*(this.getM12()*this.getM20()-this.getM10()*this.getM22())+
               this.getM02()*(this.getM10()*this.getM21()-this.getM11()*this.getM20());
    }
    
    @Override
    public void set(Double v)
    {
        set(v,0.0,0.0,0.0,v,0.0,0.0,0.0,v);
    }
    
    @Override
    public void rotX(Double x)
    {
        double v2 = Math.sin(x);
        double v3 = Math.cos(x);
        set(1.0,0.0,0.0,0.0,v3,-v2,0.0,v2,v3);
    }
    
    @Override
    public void rotY(Double y)
    {
        double f2 =  Math.cos(y);
        double f3 =  Math.sin(y);
        set(f2,0.0,f3,0.0,1.0,0.0,-f3,0.0,f2);
    }
    
    @Override
    public void rotZ(Double z)
    {
        double f2 = Math.cos(z);
        double f3 =  Math.sin(z);
        set(f2,-f3,0.0,f3,f2,0.0,0.0,0.0,1.0);
    }
    
    @Override
    public void mul(Double v)
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
    public void mul(Double v, IMatrix3<Double> m)
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
    public void mul(IMatrix3<Double> matrix3f)
    {
        double f = this.getM00() * matrix3f.getM00() +
                  this.getM01() * matrix3f.getM10() +
                  this.getM02() * matrix3f.getM20();
        double f2 = this.getM00() * matrix3f.getM01() +
                   this.getM01() * matrix3f.getM11() +
                   this.getM02() * matrix3f.getM21();
        double f3 = this.getM00() * matrix3f.getM02() +
                   this.getM01() * matrix3f.getM12() +
                   this.getM02() * matrix3f.getM22();
        double f4 = this.getM10() * matrix3f.getM00() +
                   this.getM11() * matrix3f.getM10() +
                   this.getM12() * matrix3f.getM20();
        double f5 = this.getM10() * matrix3f.getM01() +
                   this.getM11() * matrix3f.getM11() +
                   this.getM12() * matrix3f.getM21();
        double f6 = this.getM10() * matrix3f.getM02() +
                   this.getM11() * matrix3f.getM12() +
                   this.getM12() * matrix3f.getM22();
        double f7 = this.getM20() * matrix3f.getM00() +
                   this.getM21() * matrix3f.getM10() +
                   this.getM22() * matrix3f.getM20();
        double f8 = this.getM20() * matrix3f.getM01() +
                   this.getM21() * matrix3f.getM11() +
                   this.getM22() * matrix3f.getM21();
        double f9 = this.getM20() * matrix3f.getM02() +
                   this.getM21() * matrix3f.getM12() +
                   this.getM22() * matrix3f.getM22();
        set(f,f2,f3,f4,f5,f6,f7,f8,f9);
    }
    
    @Override
    public void mul(IMatrix3<Double> m1, IMatrix3<Double> m2)
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
    public void mulAndNormalize(IMatrix3<Double> m1, IMatrix3<Double> m2)
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
        
        set(dArray2[0],
                dArray2[1],
                dArray2[2],
                dArray2[3],
                dArray2[4],
                dArray2[5],
                dArray2[6],
                dArray2[7],
                dArray2[8]);
    }
    
    @Override
    public void mulAndNormalize(IMatrix3<Double> m)
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
        
        set(dArray2[0],
                dArray2[1],
                dArray2[2],
                dArray2[3],
                dArray2[4],
                dArray2[5],
                dArray2[6],
                dArray2[7],
                dArray2[8]);
    }
    
    @Override
    public void mulAndTransposeBoth(IMatrix3<Double> m1, IMatrix3<Double> m2)
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
            double f = m1.getM00() * m2.getM00() +
                      m1.getM10() * m2.getM01() +
                      m1.getM20() * m2.getM02();
            double f2 = m1.getM00() * m2.getM10() +
                       m1.getM10() * m2.getM11() +
                       m1.getM20() * m2.getM12();
            double f3 = m1.getM00() * m2.getM20() +
                       m1.getM10() * m2.getM21() +
                       m1.getM20() * m2.getM22();
            double f4 = m1.getM01() * m2.getM00() +
                       m1.getM11() * m2.getM01() +
                       m1.getM21() * m2.getM02();
            double f5 = m1.getM01() * m2.getM10() +
                       m1.getM11() * m2.getM11() +
                       m1.getM21() * m2.getM12();
            double f6 = m1.getM01() * m2.getM20() +
                       m1.getM11() * m2.getM21() +
                       m1.getM21() * m2.getM22();
            double f7 = m1.getM02() * m2.getM00() +
                       m1.getM12() * m2.getM01() +
                       m1.getM22() * m2.getM02();
            double f8 = m1.getM02() * m2.getM10() +
                       m1.getM12() * m2.getM11() +
                       m1.getM22() * m2.getM12();
            double f9 = m1.getM02() * m2.getM20() +
                       m1.getM12() * m2.getM21() +
                       m1.getM22() * m2.getM22();
            set(f,f2,f3,f4,f5,f6,f7,f8,f9);
        }
    }
    
    @Override
    public void mulAndTransposeRight(IMatrix3<Double> m1, IMatrix3<Double> m2)
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
            double f = m1.getM00() * m2.getM00() +
                      m1.getM01() * m2.getM01() +
                      m1.getM02() * m2.getM02();
            double f2 = m1.getM00() * m2.getM10() +
                       m1.getM01() * m2.getM11() +
                       m1.getM02() * m2.getM12();
            double f3 = m1.getM00() * m2.getM20() +
                       m1.getM01() * m2.getM21() +
                       m1.getM02() * m2.getM22();
            double f4 = m1.getM10() * m2.getM00() +
                       m1.getM11() * m2.getM01() +
                       m1.getM12() * m2.getM02();
            double f5 = m1.getM10() * m2.getM10() +
                       m1.getM11() * m2.getM11() +
                       m1.getM12() * m2.getM12();
            double f6 = m1.getM10() * m2.getM20() +
                       m1.getM11() * m2.getM21() +
                       m1.getM12() * m2.getM22();
            double f7 = m1.getM20() * m2.getM00() +
                       m1.getM21() * m2.getM01() +
                       m1.getM22() * m2.getM02();
            double f8 = m1.getM20() * m2.getM10() +
                       m1.getM21() * m2.getM11() +
                       m1.getM22() * m2.getM12();
            double f9 = m1.getM20() * m2.getM20() +
                       m1.getM21() * m2.getM21() +
                       m1.getM22() * m2.getM22();
            set(f,f2,f3,f4,f5,f6,f7,f8,f9);
        }
    }
    
    @Override
    public void mulAndTransposeLeft(IMatrix3<Double> m1, IMatrix3<Double> m2)
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
            double f = m1.getM00() * m2.getM00() +
                      m1.getM10() * m2.getM10() +
                      m1.getM20() * m2.getM20();
            double f2 = m1.getM00() * m2.getM01() +
                       m1.getM10() * m2.getM11() +
                       m1.getM20() * m2.getM21();
            double f3 = m1.getM00() * m2.getM02() +
                       m1.getM10() * m2.getM12() +
                       m1.getM20() * m2.getM22();
            double f4 = m1.getM01() * m2.getM00() +
                       m1.getM11() * m2.getM10() +
                       m1.getM21() * m2.getM20();
            double f5 = m1.getM01() * m2.getM01() +
                       m1.getM11() * m2.getM11() +
                       m1.getM21() * m2.getM21();
            double f6 = m1.getM01() * m2.getM02() +
                       m1.getM11() * m2.getM12() +
                       m1.getM21() * m2.getM22();
            double f7 = m1.getM02() * m2.getM00() +
                       m1.getM12() * m2.getM10() +
                       m1.getM22() * m2.getM20();
            double f8 = m1.getM02() * m2.getM01() +
                       m1.getM12() * m2.getM11() +
                       m1.getM22() * m2.getM21();
            double f9 = m1.getM02() * m2.getM02() +
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
        set(dArray[0],dArray[1],dArray[2],dArray[3],dArray[4],dArray[5],dArray[6],dArray[7],dArray[8]);
    }
    
    @Override
    public void normalizeCP()
    {
        double f = 1.0f/Math.sqrt(getM00()*getM00()+getM10()*getM10()+getM20()*getM20());
        setM00(getM00()*f);
        setM10(getM10()*f);
        setM20(getM20()*f);
        
        f = 1.0f/Math.sqrt(getM01()*getM01()+getM11()*getM11()+getM21()*getM21());
        setM01(getM01()*f);
        setM11(getM11()*f);
        setM21(getM21()*f);
        
        setM02(getM10()*getM21()-getM11()*getM20());
        setM12(getM01()*getM20()-getM00()*getM21());
        setM22(getM00()*getM11()-getM01()*getM10());
    }
    
    @Override
    public void normalize(IMatrix3<Double> m)
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
        set(dArray2[0],dArray2[1],dArray2[2],dArray2[3],dArray2[4],dArray2[5],dArray2[6],dArray2[7],dArray2[8]);
    }
    
    @Override
    public void normalizeCP(IMatrix3<Double> m)
    {
        double f = 1.0f/Math.sqrt(m.getM00()*m.getM00()+m.getM10()*m.getM10()+m.getM20()*m.getM20());
        setM00(m.getM00()*f);
        setM10(m.getM10()*f);
        setM20(m.getM20()*f);
        
        f = 1.0f/Math.sqrt(m.getM01()*m.getM01()+m.getM11()*m.getM11()+m.getM21()*m.getM21());
        setM01(m.getM01()*f);
        setM11(m.getM11()*f);
        setM21(m.getM21()*f);
        
        setM02(getM10()*getM21()-getM11()*getM20());
        setM12(getM01()*getM20()-getM00()*getM21());
        setM22(getM00()*getM11()-getM01()*getM10());
    }
    
    public boolean equals(IMatrix3<Double> m)
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
        
        IMatrix3<Double> m = (Matrix3d)o;
        
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
    public boolean epsilonEquals(IMatrix3<Double> m, Double v)
    {
        double d2 = this.getM00() - m.getM00();
        double d3 = d2 < 0.0 ? -d2 : d2;
        if (d3 > v) {
            return false;
        }
        d2 = this.getM01() - m.getM01();
        double d4 = d2 < 0.0 ? -d2 : d2;
        if (d4 > v) {
            return false;
        }
        d2 = this.getM02() - m.getM02();
        double d5 = d2 < 0.0 ? -d2 : d2;
        if (d5 > v) {
            return false;
        }
        d2 = this.getM10() - m.getM10();
        double d6 = d2 < 0.0 ? -d2 : d2;
        if (d6 > v) {
            return false;
        }
        d2 = this.getM11() - m.getM11();
        double d7 = d2 < 0.0 ? -d2 : d2;
        if (d7 > v) {
            return false;
        }
        d2 = this.getM12() - m.getM12();
        double d8 = d2 < 0.0 ? -d2 : d2;
        if (d8 > v) {
            return false;
        }
        d2 = this.getM20() - m.getM20();
        double d9 = d2 < 0.0 ? -d2 : d2;
        if (d9 > v) {
            return false;
        }
        d2 = this.getM21() - m.getM21();
        double d10 = d2 < 0.0 ? -d2 : d2;
        if (d10 > v) {
            return false;
        }
        d2 = this.getM22() - m.getM22();
        double d11 = d2 < 0.0 ? -d2 : d2;
        return !(d11 > v);
    }
    
    @Override
    public void setZero()
    {
        set(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
    }
    
    @Override
    public void negate()
    {
        set(-getM00(),-getM01(),-getM02(),-getM10(),-getM11(),-getM12(),-getM20(),-getM21(),-getM22());
    }
    
    @Override
    public void negate(IMatrix3<Double> m)
    {
        set(-m.getM00(),-m.getM01(),-m.getM02(),-m.getM10(),-m.getM11(),-m.getM12(),-m.getM20(),-m.getM21(),-m.getM22());
    }
    
    @Override
    public void transform(IPoint3<Double> p)
    {
        double f = getM00()*p.x()+getM01()*p.y()+getM02()*p.z();
        double f2 = getM10()*p.x()+getM11()*p.y()+getM12()*p.z();
        double f3 = getM20()*p.x()+getM21()*p.y()+getM22()*p.z();
        p.set(f,f2,f3);
    }
    
    @Override
    public void getScaledRotate(double[] dArray, double[] dArray2)
    {
        double[] dArray3 = new double[]{getM00(),getM01(),getM02(),getM10(),getM11(),getM12(),getM20(),getM21(),getM22()};
        Matrix3d.compute_svd(dArray3,dArray,dArray2);
    }
    
    @Override
    public void set(AxisAngle4<Double> axisAngle)
    {
        double f = Math.sqrt(axisAngle.x()*axisAngle.x()+axisAngle.y()*axisAngle.y()+axisAngle.z()*axisAngle.z());
        
        if(f < 1.0E-8)
        {
            set(1.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0,1.0);
        }
        else
        {
            f = 1.0f/f;
            
            double f2 = axisAngle.x()*f;
            double f3 = axisAngle.y()*f;
            double f4 = axisAngle.z()*f;
            double f5 = Math.sin(axisAngle.angle());
            double f6 = Math.cos(axisAngle.angle());
            double f7 = 1f-f6;
            double f8 = f2*f4;
            double f9 = f2 * f3;
            double f10 = f3*f4;
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
        setM00(1.0-2.0*quat.y()*quat.y()-2.0*quat.z()*quat.z());
        setM10(2.0*(quat.x()*quat.y()+quat.w()*quat.z()));
        setM20(2.0*(quat.x()*quat.z()-quat.w()*quat.y()));
        setM01(2.0*(quat.x()*quat.y()-quat.w()*quat.z()));
        setM11(1.0-2.0*quat.x()*quat.x()-2.0*quat.z()*quat.z());
        setM21(2.0*(quat.y()*quat.z()+quat.w()*quat.x()));
        setM02(2.0*(quat.x()*quat.z()+quat.w()*quat.y()));
        setM12(2.0*(quat.y()*quat.z()-quat.w()*quat.x()));
        setM22(1.0-2.0*quat.x()*quat.x()-2.0*quat.y()*quat.y());
    }
    
    @Override
    public void set(Quat4d quat)
    {
        setM00((1.0 - 2.0 * quat.y() * quat.y() - 2.0 * quat.z() * quat.z()));
        setM10((2.0 * (quat.x() * quat.y() + quat.w() * quat.z())));
        setM20( (2.0 * (quat.x() * quat.z() - quat.w() * quat.y())));
        setM01( (2.0 * (quat.x() * quat.y() - quat.w() * quat.z())));
        setM11((1.0 - 2.0 * quat.x() * quat.x() - 2.0 * quat.z() * quat.z()));
        setM21((2.0 * (quat.y() * quat.z() + quat.w() * quat.x())));
        setM02( (2.0 * (quat.x() * quat.z() + quat.w() * quat.y())));
        setM12((2.0 * (quat.y() * quat.z() - quat.w() * quat.x())));
        setM22( (1.0 - 2.0 * quat.x() * quat.x() - 2.0 * quat.y() * quat.y()));
    }
}