package com.kazhukov;

import com.kazhukov.graphics.frame.Control;
import com.kazhukov.graphics.frame.Panel;
import com.kazhukov.graphics.model.Graphic;
import com.kazhukov.graphics.model.Superellipsoid;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Application {
  private static final int WIDTH = 800;
  private static final int HEIGHT = 800;
  private static final int CONTROL_HEIGHT = 50;

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setLayout(new BorderLayout());

    Panel panel = new Panel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT - CONTROL_HEIGHT));
    Graphic graphic = new Graphic(panel, new Superellipsoid(30, 30, 5, 5));
    panel.setGraphic(graphic);
    frame.add(panel, BorderLayout.CENTER);

    Control control = new Control(graphic);
    control.setPreferredSize(new Dimension(WIDTH, CONTROL_HEIGHT));
    frame.add(control, BorderLayout.SOUTH);

    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationByPlatform(true);
    frame.setVisible(true);

    /*
      Какая модель описания трехмерной поверхности использовалась в
      вашей программе? Какие еще бывают модели? Привести формулы
      поверхности вашего варианта.
      {
        Аналитическая модель в параметрическом виде. Ещё бывают: векторная полигональная модель,
        воксельная модель, равномерная сетка, неравномерная сетка.

        x = sgncos(v, 2 / m) * sgncos(u, 2 / n);
        y = sgncos(v, 2 / m) * sgnsin(u, 2 / n);
        z = sgnsin(v, 2 / m);

        private double sgncos(double w, double m) {
          return signum(cos(w)) * pow(abs(cos(w)), m);
        }

        private double sgnsin(double w, double m) {
          return signum(sin(w)) * pow(abs(sin(w)), m);
        }
      }

      Какая проекция использовалась? Привести матрицу проецирования.
      Как расположена плоскость проецирования относительно системы мировых
      координат в данной проекции? Как расположены лучи проецирования
      относительно плоскости проецирования и относительно друг друга?
      Приготовить рисунок расположения системы координат, объекта, плоскости
      проецирования и проекторов. Какие еще бывают проекции?
      {
        Использовалась диметрическая поверхность.

        Матрица:
        cos(angleA),                sin(angleA),                0,            0
        -sin(angleA) * cos(angleB), cos(angleA) * cos(angleB),  sin(angleB),  0
        sin(angleA) * sin(angleB), -cos(angleA) * sin(angleB),  cos(angleB),  0
        0,                          0,                          0,            1

        плоскость расположена произвольно относительно мировых координат,
        лучи проецирования параллельны.

        См. рис. classpath:/resources/image.jpg

        Ещё бывает проекция вида, (центральное проецирование).
      }

      См код.
    */
  }
}