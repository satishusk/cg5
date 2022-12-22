package com.kazhukov.graphics.model;

public abstract class VectorModel {
  protected RadiusVector[][] vectors;

  public VectorModel(int iSize, int jSize) {
    vectors = new RadiusVector[iSize][jSize];
  }

  public VectorModel(RadiusVector[][] vectors) {
    this.vectors = vectors;
  }

  public int getX(int i, int j) {
    if (i >= vectors.length) i = 0;
    if (j >= vectors[i].length) j = 0;
    return vectors[i][j].getIntX();
  }

  public int getY(int i, int j) {
    if (i >= vectors.length) i = 0;
    if (j >= vectors[i].length) j = 0;
    return vectors[i][j].getIntY();
  }

  public int getZ(int i, int j) {
    if (i >= vectors.length) i = 0;
    if (j >= vectors[i].length) j = 0;
    return vectors[i][j].getIntZ();
  }

  public RadiusVector[][] getVectors() {
    return vectors;
  }

  public RadiusVector[][] axonometricVectors() {
    RadiusVector[][] radiusVectors = new RadiusVector[vectors.length][vectors[0].length];
    for (int i = 0; i < getVectors().length; i++) {
      for (int j = 0; j < getVectors()[i].length; j++) {
        radiusVectors[i][j] = vectors[i][j].axonometricView(-45, -45);
      }
    };
    return radiusVectors;
  }
}
