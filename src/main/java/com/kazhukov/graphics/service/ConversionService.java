package com.kazhukov.graphics.service;

import com.kazhukov.graphics.model.RadiusVector;

public class ConversionService {
  public void moving(RadiusVector radiusVector, double dx, double dy, double dz) {
    radiusVector.moveX(dx);
    radiusVector.moveY(dy);
    radiusVector.moveZ(dz);
  }

  public void sizing(RadiusVector radiusVector, double kx, double ky, double kz) {
    radiusVector.sizeX(kx);
    radiusVector.sizeY(ky);
    radiusVector.sizeZ(kz);
  }

  public void rotatingAroundX(RadiusVector radiusVector, double radianAngle) {
    radiusVector.rotateAroundX(radianAngle);
  }

  public void rotatingAroundY(RadiusVector radiusVector, double radianAngle) {
    radiusVector.rotateAroundY(radianAngle);
  }

  public void rotatingAroundZ(RadiusVector radiusVector, double radianAngle) {
    radiusVector.rotateAroundZ(radianAngle);
  }
}
