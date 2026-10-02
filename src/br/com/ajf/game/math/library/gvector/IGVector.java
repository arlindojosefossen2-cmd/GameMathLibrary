package br.com.ajf.game.math.library.gvector;

import br.com.ajf.game.math.library.tuples.tuple2.ITuple2;
import br.com.ajf.game.math.library.tuples.tuple3.ITuple3;
import br.com.ajf.game.math.library.tuples.tuple4.ITuple4;

import java.io.Serializable;

public interface IGVector<X> extends Serializable,Cloneable
{
   X norm();
   X normSquared();
   void normalize();
   void normalize(IGVector<X> gv);
   void scale(X s);
   void scale(X s,IGVector<X> gv);
   void scaleAndAdd(X s,IGVector<X> gv1,IGVector<X> gv2);
   void add(IGVector<X> gv);
   void add(IGVector<X> gv1,IGVector<X> gv2);
   void sub(IGVector<X> gv);
   void sub(IGVector<X> gv1,IGVector<X> gv2);
   void negate();
   void zero();
   void setSize(int size);
   void set(X[] array);
   void set(IGVector<X> gv);
   void set(ITuple2<X> t);
   void set(ITuple3<X> t);
   void set(ITuple4<X> t);
   int getSize();
   X getElement(int n);
   void setElement(int n,X e);
   boolean equals(IGVector<X> gv);
   boolean epsilonEquals(IGVector<X> gv,X v);
   X dot(IGVector<X> gv);
   X angle(IGVector<X> gv);
   void interpolate(IGVector<X> gv,X v);
   void interpolate(IGVector<X> gv1,IGVector<X> gv2,X v);
}