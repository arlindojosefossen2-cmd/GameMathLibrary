package br.com.ajf.game.math.library.gmatrix;

import br.com.ajf.game.math.library.gvector.IGVector;
import br.com.ajf.game.math.library.matrix3.IMatrix3;
import br.com.ajf.game.math.library.matrix4.IMatrix4;

public interface IGMatrix<X>
{
    void mul(IGMatrix<X> gm);
    void mul(IGMatrix<X> gm1,IGMatrix<X> gm2);
    void mul(IGVector<X> gv1,IGVector<X> gv2);
    void add(IGMatrix<X> gm);
    void add(IGMatrix<X> gm1,IGMatrix<X> gm2);
    void sub(IGMatrix<X> gm);
    void sub(IGMatrix<X> gm1,IGMatrix<X> gm2);
    void negate();
    void negate(IGMatrix<X> gm);
    void setIdentity();
    void setZero();
    void identityMinus();
    void invert();
    void invert(IGMatrix<X> gm);
    void copySubMatrix(int n1,int n2,int n3,int n4,int n5,int n6,IGMatrix<X> gm);
    void setSize(int n1,int n2);
    void set(X[] array);
    void set(IMatrix3<X> m);
    void set(IMatrix4<X> m);
    void set(IGMatrix<X> gm);
    int getNumRow();
    int getNumCol();
    X getElement(int n1,int n2);
    X setElement(int n1,int n2,X v);
    void getRow(int n,X[] array);
    void getRow(int n,IGVector<X> gv);
    void getColumn(int n,X[] array);
    void getColumn(int n,IGVector<X> gv);
    void get(IMatrix3<X> m);
    void get(IMatrix4<X> m);
    void get(IGMatrix<X> gm);
    void setRow(int n,X[] array);
    void setRow(int n,IGVector<X> gv);
    void setColumn(int n,X[] array);
    void setColumn(int n,IGVector<X> gv);
    void mulTransposeBoth(IGMatrix<X> gm1,IGMatrix<X> gm2);
    void mulTransposeRight(IGMatrix<X> gm1,IGMatrix<X> gm2);
    void mulTransposeLeft(IGMatrix<X> gm1,IGMatrix<X> gm2);
    void transpose();
    void transpose(IGMatrix<X> gm);
    void checkMatrix(IGMatrix<X> gm);
    boolean equals(IGMatrix<X> gm);
    boolean epsilonEquals(IGMatrix<X> gm,X v);
    X trace();
    int svd(IGMatrix<X> gm1,IGMatrix<X> gm2,IGMatrix<X> gm3);
    int lud(IGMatrix<X> gm,IGVector<X> gv);
    void setScale(X s);
    void invertGeneral(IGMatrix<X> gm);
    static boolean luDecomposition(int n,double[] dArray,int[] nArray,int[] nArray2)
    {
        return false;
    }
    
    static boolean luBackSubstitution(int n,double[] dArray,int[] nArray,double[] nArray2)
    {
        return false;
    }
    void compute(int n,int n2,double[] dArray,double[] dArray2,IGMatrix<X> gm1,IGMatrix<X> gm2);
    int computeSVD(IGMatrix<X> gm1,IGMatrix<X> gm2,IGMatrix<X> gm3,IGMatrix<X> gm4);
    void print_se(X[] da,X[] da2);
    void update_v(int n,IGMatrix<X> gm,double[] dArray,double[] dArray2);
    void chase_up(double[] dArray,double[] dArray2,IGMatrix<X> gm);
    void chase_across(double[] dArray,double[] dArray2,int n,IGMatrix<X> gm);
    void update_v_split(int n,int n2,IGMatrix<X> gm,double[] dArray,double[] dArray2,IGMatrix<X> gm2,IGMatrix<X> gm3);
    void update_u_split(int n,int n2,IGMatrix<X> gm,double[] dArray,double[] dArray2,IGMatrix<X> gm2,IGMatrix<X> gm3);
    void update_u(int n,IGMatrix<X> gm,double[] dArray,double[] dArray2);
    void print_m(IGMatrix<X> gm,IGMatrix<X> gm2,IGMatrix<X> gm3);
    void print_svd(double[] dArray,double[] dArray2,IGMatrix<X> gm1,IGMatrix<X> gm2);
    X max(X v,X v2);
    X mim(X v,X v2);
    
    static double compute_shift(double d,double d2,double d3)
    {
        return 0.0;
    }
    static int compute_2x2(double d,double d2,double d3,double[] dArray,double[] dArray2,double[] dArray3,double[] dArray4,double[] dArray5,int n)
    {
        return 0;
    }
    static double compute_rot(double d,double d2,double[] dArray,double[] dArray2)
    {
        return 0.0;
    }
    static double d_sign(double d,double d2)
    {
        return 0.0;
    }
}