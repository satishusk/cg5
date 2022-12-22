package com.kazhukov.graphics.frame;

import com.jogamp.opengl.util.GLReadBufferUtil;
import com.kazhukov.graphics.model.Graphic;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Panel extends JPanel {
  private BufferedImage bufferedImage;
  private Graphics2D imageGraphics;
  private boolean isFirstPaint = true;
  private Graphic graphic;

  @Override
  public void setPreferredSize(Dimension preferredSize) {
    super.setPreferredSize(preferredSize);
    bufferedImage = new BufferedImage(preferredSize.width, preferredSize.height, BufferedImage.TYPE_INT_ARGB);
    imageGraphics = configGraphics(bufferedImage.createGraphics());
  }

  @Override
  public void paint(Graphics g) {
    if (isFirstPaint) {
      AffineTransform affineTransform = imageGraphics.getTransform();
      imageGraphics.translate(getWidth() / 2, getHeight() / 2);
      imageGraphics.scale(1, -1);
      clear();
      imageGraphics.setTransform(affineTransform);
      if (graphic != null) {
        graphic.update();
      }
      isFirstPaint = false;
    }

    g.drawImage(bufferedImage, 0, 0, null);
  }

  private Graphics2D configGraphics(Graphics graphics) {
    Graphics2D g2 = (Graphics2D) graphics;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setColor(Color.WHITE);
    return g2;
  }

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  public Graphics2D getImageGraphics() {
    return imageGraphics;
  }

  public void clear() {
    Color prevColor = imageGraphics.getColor();
    imageGraphics.setColor(Color.BLACK);
    imageGraphics.fillRect(-getWidth() / 2, -getHeight() / 2, getWidth(), getHeight());
    imageGraphics.setColor(prevColor);

    imageGraphics.drawLine(0, 0, 0, getHeight() / 2 - 40);
    imageGraphics.drawLine(0, 0, -(getWidth() / 2 - 40), -(getHeight() / 2 - 40) + 150);
    imageGraphics.drawLine(0, 0, (getWidth() / 2 - 40), -(getHeight() / 2 - 40) + 150);
  }

  public void setGraphic(Graphic graphic) {
    this.graphic = graphic;
  }

  public void setMouseListener(MouseListener mouseListener) {
    MouseListener[] mouseListeners = getMouseListeners();
    for (MouseListener l : mouseListeners) {
      removeMouseListener(l);
    }
    addMouseListener(mouseListener);
  }
}
