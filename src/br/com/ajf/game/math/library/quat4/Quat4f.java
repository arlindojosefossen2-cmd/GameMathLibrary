package br.com.ajf.game.math.library.quat4;

import br.com.ajf.game.math.library.axisangle4.AxisAngle4d;
import br.com.ajf.game.math.library.axisangle4.AxisAngle4f;
import br.com.ajf.game.math.library.matrix3.Matrix3d;
import br.com.ajf.game.math.library.matrix3.Matrix3f;
import br.com.ajf.game.math.library.point4.IPoint4;
import br.com.ajf.game.math.library.point4.Point4f;

public class Quat4f extends Point4f
{
    public Quat4f()
    {
        this(0f,0f,0f,0f);
    }
    
    public Quat4f(float x, float y, float z, float w)
    {
        float f = (float) (1.0/Math.sqrt(x*x+y*y+z*z+w*w));
        set(f*x,f*y,f*z,f*w);
    }
    
    public Quat4f(float[] arrayPoints)
    {
        this(arrayPoints[0],arrayPoints[1],arrayPoints[2],arrayPoints[3]);
    }
    
    public Quat4f(IPoint4<Float> p)
    {
        this(p.x(),p.y(),p.z(),p.w());
    }
    
    public Quat4f(Quat4f q)
    {
        this(q.x(),q.y(),q.z(),q.w());
    }
    
    public Quat4f(Quat4d q)
    {
        this(Float.parseFloat(String.valueOf(q.x())),
                Float.parseFloat(String.valueOf(q.y())),
                Float.parseFloat(String.valueOf(q.z())),
                Float.parseFloat(String.valueOf(q.w())));
    }
    
    public final void conjugate(
            Quat4f quat4f) {
        this.setData(-quat4f.x());
        this.setY(-quat4f.y());
        this.setZ(-quat4f.z());
        this.setW(quat4f.w());
    }
    
    public final void conjugate() {
        this.setData(-this.x());
        this.setY(-this.y());
        this.setZ(-this.z());
    }
    
    public final void mul(
            Quat4f quat4f, Quat4f quat4f2) {
        if (this != quat4f && this != quat4f2) {
            this.setW(quat4f.w() * quat4f2.w() -
                     quat4f.x() * quat4f2.x() -
                     quat4f.y() * quat4f2.y() -
                     quat4f.z() * quat4f2.z());
            this.setData(quat4f.w() * quat4f2.x()
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
            float f = quat4f.w() * quat4f2.w()
                      - quat4f.x() * quat4f2.x() -
                      quat4f.y() * quat4f2.y() -
                      quat4f.z() * quat4f2.z();
            float f2 = quat4f.w() * quat4f2.x() +
                       quat4f2.w() * quat4f.x() +
                       quat4f.y() * quat4f2.z() -
                       quat4f.z() * quat4f2.y();
            float f3 = quat4f.w() * quat4f2.y() +
                       quat4f2.w() * quat4f.y() -
                       quat4f.x() * quat4f2.z() +
                       quat4f.z() * quat4f2.x();
            this.setZ(quat4f.w() * quat4f2.z() +
                     quat4f2.w() * quat4f.z() +
                     quat4f.x() * quat4f2.y() -
                     quat4f.y() * quat4f2.x());
            this.setW(f);
            this.setData(f2);
            this.setY(f3);
        }
    }
    
    public final void mul(Quat4f quat4f) {
        float f = this.w() * quat4f.w() -
                  this.x() * quat4f.x() - this.y() * quat4f.y() -
                  this.z() * quat4f.z();
        float f2 = this.w() * quat4f.x() +
                   quat4f.w() * this.x() + this.y() * quat4f.z() -
                   this.z() * quat4f.y();
        float f3 = this.w() * quat4f.y() +
                   quat4f.w() * this.y() - this.x() * quat4f.z() +
                   this.z() * quat4f.x();
        this.setZ(this.w() * quat4f.z() +
                 quat4f.w() * this.z() + this.x() * quat4f.y() -
                 this.y() * quat4f.x());
        this.setW(f);
        this.setData(f2);
        this.setY(f3);
    }
    
    public final void mulInverse(Quat4f quat4f,
                                 Quat4f quat4f2) {
        Quat4f quat4f3 = new Quat4f(quat4f2);
        quat4f3.inverse();
        this.mul(quat4f, quat4f3);
    }
    
    public final void mulInverse(Quat4f quat4f) {
        Quat4f quat4f2 = new Quat4f(quat4f);
        quat4f2.inverse();
        this.mul(quat4f2);
    }
    
    public final void inverse(Quat4f quat4f) {
        float f = 1.0f / (quat4f.w() * quat4f.w() +
                          quat4f.x() * quat4f.x() +
                          quat4f.y() * quat4f.y() +
                          quat4f.z() * quat4f.z());
        this.setData(quat4f.x() * f);
        this.setY(quat4f.y() * f);
        this.setZ(quat4f.z() * f);
        this.setW(quat4f.w() * f);
    }
    
    public final void inverse() {
        float f = 1.0f / (this.w() * this.w() +
                          this.x() * this.x() + this.y() * this.y()
                          + this.z() * this.z());
        this.setData(x() * -f);
        this.setY(y() * -f);
        this.setZ( z() * -f);
        this.setW(w() * -f);
    }
    
    public final void normalize(Quat4f quat4f) {
        float f = quat4f.x() * quat4f.x() +
                  quat4f.y() * quat4f.y() +
                  quat4f.z() * quat4f.z() +
                  quat4f.w() * quat4f.w();
        if (f > 0.0f) {
            f = 1.0f / (float)Math.sqrt(f);
            this.setData(quat4f.x() * f);
            this.setY(quat4f.y() * f);
            this.setZ( quat4f.z() * f);
            this.setW(quat4f.w() * f);
        } else {
            this.setData(0.0f);
            this.setY(0.0f);
            this.setZ(0.0f);
            this.setW(0.0f);
        }
    }
    
    public final void normalize() {
        float f = this.x() * this.x() +
                  this.y() * this.y() +
                  this.z() * this.z() +
                  this.w() * this.w();
        if (f > 0.0f) {
            f = 1.0f / (float)Math.sqrt(f);
            this.setData(x() * f);
            this.setY(y() * f);
            this.setZ( z() * f);
            this.setW(w() * f);
        } else {
            this.setData(0.0f);
            this.setY(0.0f);
            this.setZ(0.0f);
            this.setW(0.0f);
        }
    }
    
    public final void set(Matrix3f matrix3f) {
        float f = 0.25f * (matrix3f.getM00() +
                           matrix3f.getM11() + matrix3f.getM22() + 1.0f);
        if (f >= 0.0f) {
            if ((double)f >= 1.0E-30) {
                this.setW((float)Math.sqrt(f));
                f = 0.25f / this.w();
                this.setData((matrix3f.getM21() -
                              matrix3f.getM12()) * f);
                this.setY((matrix3f.getM02() -
                          matrix3f.getM20()) * f);
                this.setZ((matrix3f.getM10() -
                          matrix3f.getM01() * f));
                return;
            }
        } else {
            this.setW(0.0f);
            this.setData(0.0f);
            this.setY(0.0f);
            this.setZ(1.0f);
            return;
        }
        this.setW(0.0f);
        f = -0.5f * (matrix3f.getM11() +
                     matrix3f.getM22());
        if (f >= 0.0f) {
            if ((double)f >= 1.0E-30) {
                this.setData((float)Math.sqrt(f));
                f = 0.5f / this.x();
                this.setY(matrix3f.getM10() * f);
                this.setZ(matrix3f.getM20() * f);
                return;
            }
        } else {
            this.setData(0.0f);
            this.setY(0.0f);
            this.setZ(1.0f);
            return;
        }
        this.setData(0.0f);
        f = 0.5f * (1.0f - matrix3f.getM22());
        if ((double)f >= 1.0E-30) {
            this.setY((float)Math.sqrt(f));
            this.setZ(matrix3f.getM21() /
                     (2.0f * this.y()));
            return;
        }
        this.setY(0.0f);
        this.setZ(1.0f);
    }
    
    public final void set(Matrix3d matrix3d) {
        double d = 0.25 * (matrix3d.getM00() +
                           matrix3d.getM11() + matrix3d.getM22() + 1.0);
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.setW((float)Math.sqrt(d));
                d = 0.25 / (double)this.w();
                this.setData((float)((matrix3d.getM21() -
                                      matrix3d.getM12()) * d));
                this.setY((float)((matrix3d.getM02() -
                                  matrix3d.getM20()) * d));
                this.setZ((float)((matrix3d.getM10() -
                                  matrix3d.getM01()) * d));
                return;
            }
        } else {
            this.setW(0.0f);
            this.setData(0.0f);
            this.setY(0.0f);
            this.setZ(1.0f);
            return;
        }
        this.setW(0.0f);
        d = -0.5 * (matrix3d.getM11() +
                    matrix3d.getM22());
        if (d >= 0.0) {
            if (d >= 1.0E-30) {
                this.setData((float)Math.sqrt(d));
                d = 0.5 / (double)this.x();
                this.setY((float)(matrix3d.getM10() * d));
                this.setZ((float)(matrix3d.getM20() * d));
                return;
            }
        } else {
            this.setData(0.0f);
            this.setY(0.0f);
            this.setZ(1.0f);
            return;
        }
        this.setData(0.0f);
        d = 0.5 * (1.0 - matrix3d.getM22());
        if (d >= 1.0E-30) {
            this.setY((float)Math.sqrt(d));
            this.setZ((float)(matrix3d.getM21() /
                             (2.0 * (double)this.y())));
            return;
        }
        this.setY(0.0f);
        this.setZ(1.0f);
    }
    
    public final void set(AxisAngle4f axisAngle4f) {
        float f = (float)
                          Math.sqrt(axisAngle4f.x() * axisAngle4f.x() +
                                    axisAngle4f.y() * axisAngle4f.y() +
                                    axisAngle4f.z() * axisAngle4f.z());
        if ((double)f < 1.0E-6) {
            this.setW(0.0f);
            this.setData(0.0f);
            this.setY(0.0f);
            this.setZ(0.0f);
        } else {
            f = 1.0f / f;
            float f2 = (float)Math.sin(
                    (double)axisAngle4f.angle() / 2.0);
            this.setW((float)Math.cos(
                    (double)axisAngle4f.angle() / 2.0));
            this.setData(Float.parseFloat(String.valueOf(axisAngle4f.x())) * f *
                         f2);
            this.setY(Float.parseFloat(String.valueOf(axisAngle4f.y())) * f *
                      f2);
            this.setZ(Float.parseFloat(String.valueOf(axisAngle4f.z())) * f *
                      f2);
        }
    }
    
    public final void set(AxisAngle4d axisAngle4d) {
        float f = (float)(1.0 /
                          Math.sqrt(axisAngle4d.x() * axisAngle4d.x() +
                                    axisAngle4d.y() * axisAngle4d.y() +
                                    axisAngle4d.z() * axisAngle4d.z()));
        if ((double)f < 1.0E-6) {
            this.setW(0.0f);
            this.setData(0.0f);
            this.setY(0.0f);
            this.setZ(0.0f);
        } else {
            f = 1.0f / f;
            float f2 = (float)
                               Math.sin(axisAngle4d.angle() / 2.0);
            this.setW((float)
                             Math.cos(axisAngle4d.angle() / 2.0));
            this.setData(Float.parseFloat(String.valueOf(axisAngle4d.x())) * f *
                         f2);
            this.setY(Float.parseFloat(String.valueOf(axisAngle4d.y())) * f *
                      f2);
            this.setZ(Float.parseFloat(String.valueOf(axisAngle4d.z())) * f *
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
            quat4f.setData(-quat4f.x());
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
        this.setW((float)(d2 * (double)this.w() +
                         d * (double)quat4f.w()));
        this.setData((float)(d2 * (double)this.x() +
                         d * (double)quat4f.x()));
        this.setY((float)(d2 * (double)this.y() +
                         d * (double)quat4f.y()));
        this.setZ((float)(d2 * (double)this.z() +
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
            quat4f.setData(-quat4f.x());
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
        this.setW((float)(d2 * (double)quat4f.w() +
                         d * (double)quat4f2.w()));
        this.setData((float)(d2 * (double)quat4f.x() +
                         d * (double)quat4f2.x()));
        this.setY((float)(d2 * (double)quat4f.y() +
                         d * (double)quat4f2.y()));
        this.setZ((float)(d2 * (double)quat4f.z() +
                         d * (double)quat4f2.z()));
    }
}