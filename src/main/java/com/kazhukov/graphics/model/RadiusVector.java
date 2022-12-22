package com.kazhukov.graphics.model;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

import org.jzy3d.maths.Coord3d;

public class RadiusVector {
  private double x;
  private double y;
  private double z;

  public RadiusVector(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public void setZ(double z) {
    this.z = z;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getZ() {
    return z;
  }

  public int getIntX() {
    return (int)x;
  }

  public int getIntY() {
    return (int)y;
  }

  public int getIntZ() {
    return (int)z;
  }

  public double length() {
    return sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2));
  }

  public void moveX(double dx) {
    x += dx;
  }

  public void moveY(double dy) {
    y += dy;
  }

  public void moveZ(double dz) {
    z += dz;
  }

  public void sizeX(double kx) {
    x *= kx;
  }

  public void sizeY(double ky) {
    y *= ky;
  }

  public void sizeZ(double kz) {
    z *= kz;
  }

  public void rotateAroundX(double angle) {
    double y0 = y;
    double z0 = z;
    y = y0 * cos(angle) - z0 * sin(angle);
    z = y0 * sin(angle) + z0 * cos(angle);
  }

  public void rotateAroundY(double angle) {
    double x0 = x;
    double z0 = z;
    x = x0 * cos(angle) + z0 * sin(angle);
    z = -x0 * sin(angle) + z0 * cos(angle);
  }

  public void rotateAroundZ(double angle) {
    double x0 = x;
    double y0 = y;
    x = x0 * cos(angle) - y0 * sin(angle);
    y = x0 * sin(angle) + y0 * cos(angle);
  }

  public RadiusVector axonometricView(int angleA, int angleB) {
    return new RadiusVector(
        x * cos(angleA) + y * sin(angleA),
        -x * sin(angleA) * cos(angleB) + y * cos(angleA) * cos(angleB) + z * sin(angleB),
        x * sin(angleA) * sin(angleB) - y * cos(angleA) * sin(angleB) + z * cos(angleB)
    );
  }
}
