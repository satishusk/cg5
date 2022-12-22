package com.kazhukov.graphics.model;

import com.kazhukov.graphics.frame.Panel;
import java.awt.geom.AffineTransform;

public class Graphic {
  private final Panel panel;
  private final VectorModel model;

  public Graphic(Panel panel, VectorModel model) {
    this.panel = panel;
    this.model = model;
  }

  public void update() {
    AffineTransform affineTransform = panel.getImageGraphics().getTransform();
    panel.getImageGraphics().translate(panel.getWidth() / 2, panel.getHeight() / 2);
    panel.getImageGraphics().scale(1, -1);
    panel.clear();

    VectorModel vectorModel = new Superellipsoid(model.axonometricVectors());
    for (int i = 0; i < vectorModel.getVectors().length - 1; i++) {
      for (int j = 0; j < vectorModel.getVectors()[i].length; j++) {
        connectToPolygon(vectorModel, i, j);
      }
    }

    panel.getImageGraphics().setTransform(affineTransform);
    panel.revalidate();
    panel.repaint();
  }

  private void connectToPolygon(VectorModel model, int i, int j) {
    panel.getImageGraphics().drawLine(
        model.getX(i, j), model.getY(i, j),
        model.getX(i, j + 1), model.getY(i, j + 1)
    );
    panel.getImageGraphics().drawLine(
        model.getX(i, j + 1), model.getY(i, j + 1),
        model.getX(i + 1, j + 1), model.getY(i + 1, j + 1)
    );
    panel.getImageGraphics().drawLine(
        model.getX(i + 1, j + 1), model.getY(i + 1, j + 1),
        model.getX(i + 1, j), model.getY(i + 1, j)
    );
    panel.getImageGraphics().drawLine(
        model.getX(i + 1, j), model.getY(i + 1, j),
        model.getX(i, j), model.getY(i, j)
    );
  }

  public VectorModel getModel() {
    return model;
  }
}
