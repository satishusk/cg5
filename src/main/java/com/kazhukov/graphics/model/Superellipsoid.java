package com.kazhukov.graphics.model;

import static java.lang.Math.*;

public class Superellipsoid extends VectorModel {

  public Superellipsoid(int iSize, int jSize, double m, double n) {
    super(iSize, jSize);
    for (int i = 0; i < getVectors().length; i++) {
      for (int j = 0; j < getVectors()[i].length; j++) {
        double v = ((iSize - 1) / 2.0 - i) / ((iSize - 1) / 2.0) * (-PI / 2);
        double u = ((jSize - 1) / 2.0 - j) / ((jSize - 1) / 2.0) * (-PI);
        vectors[i][j] = new RadiusVector(
            200 * sgncos(v, 2 / m) * sgncos(u, 2 / n),
            200 * sgncos(v, 2 / m) * sgnsin(u, 2 / n),
            200 * sgnsin(v, 2 / m)
        );
      }
    }
  }

  public Superellipsoid(RadiusVector[][] vectors) {
    super(vectors);
    this.vectors = vectors;
  }

  private double sgncos(double w, double m) {
    return signum(cos(w)) * pow(abs(cos(w)), m);
  }

  private double sgnsin(double w, double m) {
    return signum(sin(w)) * pow(abs(sin(w)), m);
  }
}
