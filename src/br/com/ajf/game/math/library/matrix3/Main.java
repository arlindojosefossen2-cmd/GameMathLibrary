package br.com.ajf.game.math.library.matrix3;

public class Main
{
    public static void main(String[] args)
    {
        IMatrix3<?> m = new Matrix3f();
        System.out.println(m);
        
        Matrix3d md = new Matrix3d();
        md.setM00(2.998);
        System.out.println(md);
    }
}
