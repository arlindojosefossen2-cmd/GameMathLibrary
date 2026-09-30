package br.com.ajf.game.math.library.quat4;

import br.com.ajf.game.math.library.axisangle4.AxisAngle4d;
import br.com.ajf.game.math.library.axisangle4.AxisAngle4f;
import br.com.ajf.game.math.library.matrix3.Matrix3d;
import br.com.ajf.game.math.library.matrix3.Matrix3f;
import br.com.ajf.game.math.library.matrix4.IMatrix4;
import br.com.ajf.game.math.library.point4.IPoint4;
import br.com.ajf.game.math.library.point4.Point4d;

public class Quat4d extends Point4d
{
    public Quat4d()
    {
        this(0.0,0.0,0.0,0.0);
    }
    
    public Quat4d(double x, double y, double z, double w)
    {
        double d = 1.0/Math.sqrt(x*x+y*y+z*z+w*w);
        set(d*x,d*y,d*z,d*w);
    }
    
    public Quat4d(double[] arrayPoints)
    {
        this(arrayPoints[0],arrayPoints[1],arrayPoints[2],arrayPoints[3]);
    }
    
    public Quat4d(IPoint4<Double> p)
    {
        this(p.x(),p.y(),p.z(),p.w());
    }
    
    public Quat4d(Quat4d q)
    {
        this(q.x(),q.y(),q.z(),q.w());
    }
    
    public Quat4d(Quat4f q)
    {
        this(Double.parseDouble(String.valueOf(q.x())),Double.parseDouble(String.valueOf(q.y())),Double.parseDouble(String.valueOf(q.z())),Double.parseDouble(String.valueOf(q.w())));
    }
    
    public final void conjugate(Quat4d quat4f) {
        this.setX(-quat4f.x());
        this.setY(-quat4f.y());
        this.setZ(-quat4f.z());
        this.setW(quat4f.w());
    }
    
    public final void conjugate() {
        this.setX(-this.x());
        this.setY(-this.y());
        this.setZ(-this.z());
    }
    
    public final void mul(Quat4d quat4f, Quat4d quat4f2) {
        if (this != quat4f && this != quat4f2)
        {
            this.setW(quat4f.w() * quat4f2.w() -
                      quat4f.x() * quat4f2.x() -
                      quat4f.y() * quat4f2.y() -
                      quat4f.z() * quat4f2.z());
            this.setX(quat4f.w() * quat4f2.x()
                      + quat4f2.w() * quat4f.x() +
                      quat4f.y() * quat4f2.z() -
                      quat4f.z() * quat4f2.y());
            this.setY(quat4f.w() * quat4f2.y()
                      + quat4f2.w() * quat4f.y() -
                      quat4f.x() * quat4f2.z() +
                      quat4f.z() * quat4f2.x());
            this.setZ(quat4f.w() * quat4f2.z()
                      + quat4f2.w() * quat4f.z() +
                      quat4f.x() * quat4f2.y() -
                      quat4f.y() * quat4f2.x());
        } else {
            double f = quat4f.w() * quat4f2.w()
                      - quat4f.x() * quat4f2.x() -
                      quat4f.y() * quat4f2.y() -
                      quat4f.z() * quat4f2.z();
            double f2 = quat4f.w() * quat4f2.x() +
                       quat4f2.w() * quat4f.x() +
                       quat4f.y() * quat4f2.z() -
                       quat4f.z() * quat4f2.y();
            double f3 = quat4f.w() * quat4f2.y() +
                       quat4f2.w() * quat4f.y() -
                       quat4f.x() * quat4f2.z() +
                       quat4f.z() * quat4f2.x();
            this.setZ(quat4f.w() * quat4f2.z() +
                      quat4f2.w() * quat4f.z() +
                      quat4f.x() * quat4f2.y() -
                      quat4f.y() * quat4f2.x());
            this.setW(f);
            this.setX(f2);
            this.setY(f3);
        }
    }
    
    public final void mul(Quat4d quat4f) {
        double f = this.w() * quat4f.w() -
                  this.x() * quat4f.x() - this.y() * quat4f.y() -
                  this.z() * quat4f.z();
        double f2 = this.w() * quat4f.x() +
                   quat4f.w() * this.x() + this.y() * quat4f.z() -
                   this.z() * quat4f.y();
        double f3 = this.w() * quat4f.y() +
                   quat4f.w() * this.y() - this.x() * quat4f.z() +
                   this.z() * quat4f.x();
        this.setZ(this.w() * quat4f.z() +
                  quat4f.w() * this.z() + this.x() * quat4f.y() -
                  this.y() * quat4f.x());
        this.setW(f);
        this.setX(f2);
        this.setY(f3);
    }
    
    public final void mulInverse(Quat4d quat4f,
                                 Quat4d quat4f2) {
        Quat4d quat4f3 = new Quat4d(quat4f2);
        quat4f3.inverse();
        this.mul(quat4f, quat4f3);
    }
    
    public final void mulInverse(Quat4d quat4f) {
        Quat4d quat4f2 = new Quat4d(quat4f);
        quat4f2.inverse();
        this.mul(quat4f2);
    }
    
    public final void inverse(Quat4d quat4f) {
        double f = 1.0f / (quat4f.w() * quat4f.w() +
                          quat4f.x() * quat4f.x() +
                          quat4f.y() * quat4f.y() +
                          quat4f.z() * quat4f.z());
        this.setX(quat4f.x() * f);
        this.setY(quat4f.y() * f);
        this.setZ(quat4f.z() * f);
        this.setW(quat4f.w() * f);
    }
    
    public final void inverse() {
        double f = 1.0f / (this.w() * this.w() +
                          this.x() * this.x() + this.y() * this.y()
                          + this.z() * this.z());
        this.setX(x() * -f);
        this.setY(y() * -f);
        this.setZ( z() * -f);
        this.setW(w() * -f);
    }
    
    public final void normalize(Quat4f quat4f) {
        double f = quat4f.x() * quat4f.x() +
                  quat4f.y() * quat4f.y() +
                  quat4f.z() * quat4f.z() +
                  quat4f.w() * quat4f.w();
        if (f > 0.0f) {
            f = 1.0f / Math.sqrt(f);
            this.setX(quat4f.x() * f);
            this.setY(quat4f.y() * f);
            this.setZ( quat4f.z() * f);
            this.setW(quat4f.w() * f);
        } else {
            this.setX(0.0);
            this.setY(0.0);
            this.setZ(0.0);
            this.setW(0.0);
        }
    }
    
    public final void normalize() {
        double f = this.x() * this.x() +
                  this.y() * this.y() +
                  this.z() * this.z() +
                  this.w() * this.w();
        if (f > 0.0f) {
            f = 1.0f / Math.sqrt(f);
            this.setX(x() * f);
            this.setY(y() * f);
            this.setZ( z() * f);
            this.setW(w() * f);
        } else {
            this.setX(0.0);
            this.setY(0.0);
            this.setZ(0.0);
            this.setW(0.0);
        }
    }
    
    public final void set(Matrix3f matrix3f) {
        double f = 0.25f * (matrix3f.getM00() +
                           matrix3f.getM11() + matrix3f.getM22() + 1.0f);
        if (f >= 0.0f) {
            if (f >= 1.0E-30) {
                this.setW(Math.sqrt(f));
                f = 0.25f / this.w();
                this.setX((matrix3f.getM21() -
                           matrix3f.getM12()) * f);
                this.setY((matrix3f.getM02() -
                           matrix3f.getM20()) * f);
                this.setZ((matrix3f.getM10() -
                           matrix3f.getM01() * f));
                return;
            }
        } else {
            this.setW(0.0);
            this.setX(0.0);
            this.setY(0.0);
            this.setZ(1.0);
            return;
        }
        this.setW(0.0);
        f = -0.5f * (matrix3f.getM11() +
                     matrix3f.getM22());
        if (f >= 0.0f) {
            if (f >= 1.0E-30) {
                this.setX(Math.sqrt(f));
                f = 0.5f / this.x();
                this.setY(matrix3f.getM10() * f);
                this.setZ(matrix3f.getM20() * f);
                return;
            }
        } else {
            this.setX(0.0);
            this.setY(0.0);
            this.setZ(1.0);
            return;
        }
        this.setX(0.0);
        f = 0.5f * (1.0f - matrix3f.getM22());
        if (f >= 1.0E-30) {
            this.setY(Math.sqrt(f));
            this.setZ(matrix3f.getM21() /
                      (2.0f * this.y()));
            return;
        }
        this.setY(0.0);
        this.setZ(1.0);
    }
    
    public final void set(IMatrix4<Double> matrix4f) {
        double f = 0.25f * (matrix4f.getM00() +
                           matrix4f.getM11() + matrix4f.getM22() +
                           matrix4f.getM33());
        if (f >= 0.0f) {
            if (f >= 1.0E-30) {
                this.setW(Math.sqrt(f));
                f = 0.25f / this.w();
                this.setX((matrix4f.getM21() -
                           matrix4f.getM12()) * f);
                this.setY((matrix4f.getM02() -
                           matrix4f.getM20()) * f);
                this.setZ((matrix4f.getM10() -
                           matrix4f.getM01()) * f);
                return;
            }
        } else {
            this.setX(0.0);
            this.setY(0.0);
            this.setW(0.0);
            this.setZ(1.0);
            return;
        }
        this.setW(0.0);
        f = -0.5f * (matrix4f.getM11() +
                     matrix4f.getM22());
        if (f >= 0.0f) {
            if (f >= 1.0E-30) {
                this.setX(Math.sqrt(f));
                f = 1.0f / (2.0f * this.x());
                this.setY(matrix4f.getM10() * f);
                this.setZ(matrix4f.getM20() * f);
                return;
            }
        } else {
            this.setX(0.0);
            this.setY(0.0);
            this.setZ(1.0);
            return;
        }
        this.setX(0.0);
        f = 0.5f * (1.0f - matrix4f.getM22());
        if (f >= 1.0E-30) {
            this.setY(Math.sqrt(f));
            this.setZ(matrix4f.getM21() /
                      (2.0f * this.y()));
            return;
        }
        this.setY(0.0);
        this.setZ(1.0);
    }
    
    public final void set(Matrix3d matrix3d) {
        double d = 0.25 * (matrix3d.getM00() +
                           matrix3d.getM11() + matrix3d.getM22() + 1.0);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.setW(Math.sqrt(d));
                d = 0.25 / this.w();
                this.setX(((matrix3d.getM21() -
                            matrix3d.getM12()) * d));
                this.setY(((matrix3d.getM02() -
                                   matrix3d.getM20()) * d));
                this.setZ(((matrix3d.getM10() -
                                   matrix3d.getM01()) * d));
                return;
            }
        } else {
            this.setW(0.0);
            this.setX(0.0);
            this.setY(0.0);
            this.setZ(1.0);
            return;
        }
        this.setW(0.0);
        d = -0.5 * (matrix3d.getM11() +
                    matrix3d.getM22());
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.setX(Math.sqrt(d));
                d = 0.5 / this.x();
                this.setY((matrix3d.getM10() * d));
                this.setZ((matrix3d.getM20() * d));
                return;
            }
        } else {
            this.setX(0.0);
            this.setY(0.0);
            this.setZ(1.0);
            return;
        }
        this.setX(0.0);
        d = 0.5 * (1.0 - matrix3d.getM22());
        if (d >= 1.0E-30) {
            this.setY(Math.sqrt(d));
            this.setZ((matrix3d.getM21() /
                              (2.0 * this.y())));
            return;
        }
        this.setY(0.0);
        this.setZ(1.0);
    }
    
    public final void set(AxisAngle4f axisAngle4f) {
        double f = Math.sqrt(axisAngle4f.x() * axisAngle4f.x() +
                                    axisAngle4f.y() * axisAngle4f.y() +
                                    axisAngle4f.z() * axisAngle4f.z());
        if (f < 1.0E-6) {
            this.setW(0.0);
            this.setX(0.0);
            this.setY(0.0);
            this.setZ(0.0);
        } else {
            f = 1.0f / f;
            float f2 = (float)Math.sin(
                    (double)axisAngle4f.angle() / 2.0);
            this.setW(Math.cos(
                    (double)axisAngle4f.angle() / 2.0));
            this.setX(Double.parseDouble(String.valueOf(axisAngle4f.x())) * f *
                      f2);
            this.setY(Double.parseDouble(String.valueOf(axisAngle4f.y())) * f *
                      f2);
            this.setZ(Double.parseDouble(String.valueOf(axisAngle4f.z())) * f *
                      f2);
        }
    }
    
    public final void set(AxisAngle4d axisAngle4d) {
        double f = (1.0 /
                          Math.sqrt(axisAngle4d.x() * axisAngle4d.x() +
                                    axisAngle4d.y() * axisAngle4d.y() +
                                    axisAngle4d.z() * axisAngle4d.z()));
        if (f < 1.0E-6) {
            this.setW(0.0);
            this.setX(0.0);
            this.setY(0.0);
            this.setZ(0.0);
        } else {
            f = 1.0f / f;
            float f2 = (float)
                               Math.sin(axisAngle4d.angle() / 2.0);
            this.setW(
                              Math.cos(axisAngle4d.angle() / 2.0));
            this.setX(Double.parseDouble(String.valueOf(axisAngle4d.x())) * f *
                      f2);
            this.setY(Double.parseDouble(String.valueOf(axisAngle4d.y())) * f *
                      f2);
            this.setZ(Double.parseDouble(String.valueOf(axisAngle4d.z())) * f *
                      f2);
        }
    }
    
    public final void interpolate(Quat4f quat4f,
                                  float f) {
        double d;
        double d2;
        double d3 = this.x() * quat4f.x() +
                    this.y() * quat4f.y() + this.z() * quat4f.z() +
                    this.w() * quat4f.w();
        if (d3 < 0.0) {
            quat4f.setX(-quat4f.x());
            quat4f.setY(-quat4f.y());
            quat4f.setZ(-quat4f.z());
            quat4f.setW(-quat4f.w());
            d3 = -d3;
        }
        if (1.0 - d3 > 1.0E-6) {
            double d4 = Math.acos(d3);
            double d5 = Math.sin(d4);
            d2 = Math.sin((1.0 - (double)f) * d4)
                 / d5;
            d = Math.sin((double)f * d4) / d5;
        } else {
            d2 = 1.0 - (double)f;
            d = f;
        }
        this.setW((d2 * this.w() +
                          d * (double)quat4f.w()));
        this.setX((d2 * this.x() +
                          d * (double)quat4f.x()));
        this.setY((d2 * this.y() +
                          d * (double)quat4f.y()));
        this.setZ((d2 * this.z() +
                          d * (double)quat4f.z()));
    }
    
    public final void interpolate(Quat4f quat4f,
                                  Quat4f quat4f2, float f) {
        double d;
        double d2;
        double d3 = quat4f2.x() * quat4f.x() +
                    quat4f2.y() * quat4f.y() +
                    quat4f2.z() * quat4f.z() +
                    quat4f2.w() * quat4f.w();
        if (d3 < 0.0) {
            quat4f.setX(-quat4f.x());
            quat4f.setY(-quat4f.y());
            quat4f.setZ(-quat4f.z());
            quat4f.setW(-quat4f.w());
            d3 = -d3;
        }
        if (1.0 - d3 > 1.0E-6) {
            double d4 = Math.acos(d3);
            double d5 = Math.sin(d4);
            d2 = Math.sin((1.0 - (double)f) * d4)
                 / d5;
            d = Math.sin((double)f * d4) / d5;
        } else {
            d2 = 1.0 - (double)f;
            d = f;
        }
        this.setW((d2 * (double)quat4f.w() +
                          d * (double)quat4f2.w()));
        this.setX((d2 * (double)quat4f.x() +
                          d * (double)quat4f2.x()));
        this.setY((d2 * (double)quat4f.y() +
                          d * (double)quat4f2.y()));
        this.setZ((d2 * (double)quat4f.z() +
                          d * (double)quat4f2.z()));
    }
}