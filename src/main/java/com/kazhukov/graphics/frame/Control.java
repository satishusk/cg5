package com.kazhukov.graphics.frame;

import static java.lang.Math.PI;

import com.kazhukov.graphics.model.Graphic;
import com.kazhukov.graphics.model.RadiusVector;
import com.kazhukov.graphics.service.ConversionService;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Control extends JPanel {
    private final Graphic graphic;
    private final ConversionService conversionService = new ConversionService();

    public Control(Graphic graphic) {
        this.graphic = graphic;
        setLayout(new GridLayout(3, 1));

        movingSlidersInit();
        sizingSlidersInit();
        rotatingSlidersInit();
    }

    private void movingSlidersInit() {
        JPanel movingSliders = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JLabel xMovingSliderName = new JLabel("xMov");
        JSlider xMovingSlider = new JSlider(SwingConstants.HORIZONTAL);
        xMovingSlider.addChangeListener(new ChangeListener() {
            private int sliderValueBefore = xMovingSlider.getValue();
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = ((JSlider) e.getSource()).getValue();
                moving(3 * (sliderValue - sliderValueBefore), 0, 0);
                sliderValueBefore = sliderValue;
                graphic.update();
            }
        });
        movingSliders.add(xMovingSliderName);
        movingSliders.add(xMovingSlider);

        JLabel yMovingSliderName = new JLabel("yMov");
        JSlider yMovingSlider = new JSlider(SwingConstants.HORIZONTAL);
        yMovingSlider.addChangeListener(new ChangeListener() {
            private int sliderValueBefore = yMovingSlider.getValue();
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = ((JSlider) e.getSource()).getValue();
                moving(0, 3 * (sliderValue - sliderValueBefore), 0);
                sliderValueBefore = sliderValue;
                graphic.update();
            }
        });
        movingSliders.add(yMovingSliderName);
        movingSliders.add(yMovingSlider);

        JLabel zMovingSliderName = new JLabel("zMov");
        JSlider zMovingSlider = new JSlider(SwingConstants.HORIZONTAL);
        zMovingSlider.addChangeListener(new ChangeListener() {
            private int sliderValueBefore = zMovingSlider.getValue();
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = ((JSlider) e.getSource()).getValue();
                moving(0, 0, 3 * (sliderValue - sliderValueBefore));
                sliderValueBefore = sliderValue;
                graphic.update();
            }
        });
        movingSliders.add(zMovingSliderName);
        movingSliders.add(zMovingSlider);

        add(movingSliders);
    }

    private void sizingSlidersInit() {
        JPanel sizingSliders = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JLabel xSizingSliderName = new JLabel("xSiz");
        JSlider xSizingSlider = new JSlider(SwingConstants.HORIZONTAL);
        xSizingSlider.addChangeListener(new ChangeListener() {
            private int sliderValueBefore = xSizingSlider.getValue();
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = ((JSlider) e.getSource()).getValue();
                sizing(1 + (sliderValue - sliderValueBefore) / 10.0, 1, 1);
                sliderValueBefore = sliderValue;
                graphic.update();
            }
        });
        sizingSliders.add(xSizingSliderName);
        sizingSliders.add(xSizingSlider);

        JLabel yMovingSliderName = new JLabel("ySiz");
        JSlider yMovingSlider = new JSlider(SwingConstants.HORIZONTAL);
        yMovingSlider.addChangeListener(new ChangeListener() {
            private int sliderValueBefore = yMovingSlider.getValue();
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = ((JSlider) e.getSource()).getValue();
                sizing(1, 1 + (sliderValue - sliderValueBefore) / 10.0, 1);
                sliderValueBefore = sliderValue;
                graphic.update();
            }
        });
        sizingSliders.add(yMovingSliderName);
        sizingSliders.add(yMovingSlider);

        JLabel zMovingSliderName = new JLabel("zSiz");
        JSlider zMovingSlider = new JSlider(SwingConstants.HORIZONTAL);
        zMovingSlider.addChangeListener(new ChangeListener() {
            private int sliderValueBefore = zMovingSlider.getValue();
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = ((JSlider) e.getSource()).getValue();
                sizing(1, 1, 1 + (sliderValue - sliderValueBefore) / 10.0);
                sliderValueBefore = sliderValue;
                graphic.update();
            }
        });
        sizingSliders.add(zMovingSliderName);
        sizingSliders.add(zMovingSlider);

        add(sizingSliders);
    }

    private void rotatingSlidersInit() {
        JPanel rotatingSliders = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JLabel xRotatingSliderName = new JLabel("xRot");
        JSlider xRotatingSlider = new JSlider(SwingConstants.HORIZONTAL);
        xRotatingSlider.addChangeListener(new ChangeListener() {
            private int sliderValueBefore = xRotatingSlider.getValue();
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = ((JSlider) e.getSource()).getValue();
                rotatingAroundX(angleOfSliderValue(sliderValue - sliderValueBefore));
                sliderValueBefore = sliderValue;
                graphic.update();
            }
        });
        rotatingSliders.add(xRotatingSliderName);
        rotatingSliders.add(xRotatingSlider);

        JLabel yRotatingSliderName = new JLabel("yRot");
        JSlider yRotatingSlider = new JSlider(SwingConstants.HORIZONTAL);
        yRotatingSlider.addChangeListener(new ChangeListener() {
            private int sliderValueBefore = yRotatingSlider.getValue();
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = ((JSlider) e.getSource()).getValue();
                rotatingAroundY(angleOfSliderValue(sliderValue - sliderValueBefore));
                sliderValueBefore = sliderValue;
                graphic.update();
            }
        });
        rotatingSliders.add(yRotatingSliderName);
        rotatingSliders.add(yRotatingSlider);

        JLabel zRotatingSliderName = new JLabel("zRot");
        JSlider zRotatingSlider = new JSlider(SwingConstants.HORIZONTAL);
        zRotatingSlider.addChangeListener(new ChangeListener() {
            private int sliderValueBefore = zRotatingSlider.getValue();
            @Override
            public void stateChanged(ChangeEvent e) {
                int sliderValue = ((JSlider) e.getSource()).getValue();
                rotatingAroundZ(angleOfSliderValue(sliderValue - sliderValueBefore));
                sliderValueBefore = sliderValue;
                graphic.update();
            }
        });
        rotatingSliders.add(zRotatingSliderName);
        rotatingSliders.add(zRotatingSlider);

        add(rotatingSliders);
    }

    public double angleOfSliderValue(double sliderValue) {
        return (sliderValue / 100) *  2 * PI;
    }

    public void moving(double dx, double dy, double dz) {
        for (RadiusVector[] radiusVectors : graphic.getModel().getVectors()) {
            for (RadiusVector radiusVector : radiusVectors) {
                conversionService.moving(radiusVector, dx, dy, dz);
            }
        }
    }

    public void sizing(double kx, double ky, double kz) {
        if (kx == 0 || ky == 0 || kz == 0) return;
        for (RadiusVector[] radiusVectors : graphic.getModel().getVectors()) {
            for (RadiusVector radiusVector : radiusVectors) {
                conversionService.sizing(radiusVector, kx, ky, kz);
            }
        }
    }

    public void rotatingAroundX(double radianAngle) {
        for (RadiusVector[] radiusVectors : graphic.getModel().getVectors()) {
            for (RadiusVector radiusVector : radiusVectors) {
                conversionService.rotatingAroundX(radiusVector, radianAngle);
            }
        }
    }

    public void rotatingAroundY(double radianAngle) {
        for (RadiusVector[] radiusVectors : graphic.getModel().getVectors()) {
            for (RadiusVector radiusVector : radiusVectors) {
                conversionService.rotatingAroundY(radiusVector, radianAngle);
            }
        }
    }

    public void rotatingAroundZ(double radianAngle) {
        for (RadiusVector[] radiusVectors : graphic.getModel().getVectors()) {
            for (RadiusVector radiusVector : radiusVectors) {
                conversionService.rotatingAroundZ(radiusVector, radianAngle);
            }
        }
    }
}
