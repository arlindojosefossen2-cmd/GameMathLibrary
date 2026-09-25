package br.com.ajf.game.math.library.matrix3;

import br.com.ajf.game.math.library.vector3.Vector3d;
import br.com.ajf.game.math.library.vector3.Vector3f;

public class Main
{
    public static void main(String[] args)
    {
        Matrix3<Float> m = new Matrix3f();
        m.getColumn(1,new Vector3f());
        System.out.println(m);
        
        Matrix3<Double> md = new Matrix3d();
        md.setM00(2.998);
        md.getRow(0,new Vector3d());
        System.out.println(md);
    }
}
