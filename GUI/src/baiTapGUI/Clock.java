  package baiTapGUI;

  import java.applet.Applet;
  import java.awt.BorderLayout;
  import java.awt.Color;
  import java.awt.Dimension;
  import java.awt.Font;
  import java.awt.Graphics;
  import java.text.SimpleDateFormat;
  import java.util.Calendar;
  import java.util.GregorianCalendar;
  import java.util.TimeZone;
  import java.util.Timer;
  import java.util.TimerTask;
  import javax.swing.JFrame;

public class Clock extends Applet {

      GregorianCalendar cal;
      Timer clockTimer = new Timer();
      TimeZone clockTimeZone = TimeZone.getDefault();

      public Clock() {
          clockTimer.schedule(new TickTimerTask(), 0, 1000);
      }

      @Override
      public void init() {}

      @Override
      public void paint(Graphics g) {
          g.setColor(Color.BLUE);
          g.fillOval(40, 40, 220, 220);
          g.setColor(Color.WHITE);
          g.fillOval(50, 50, 200, 200);
          double second = cal.get(Calendar.SECOND);
          double minute = cal.get(Calendar.MINUTE);
          double hours = cal.get(Calendar.HOUR);

          for (int i = 0; i < 60; i++) {
              int length = 90;
              double rad = (i * 6) * (Math.PI) / 180;
              if (i % 5 == 0) {
                  length = 82;
                  g.setColor(Color.BLUE);
              } else {
                  g.setColor(Color.GRAY);
              }
              int x = 150 + (int)(95 * Math.cos(rad - (Math.PI / 2)));
              int y = 150 + (int)(95 * Math.sin(rad - (Math.PI / 2)));
              int x1 = 150 + (int)(length * Math.cos(rad - (Math.PI / 2)));
              int y1 = 150 + (int)(length * Math.sin(rad - (Math.PI / 2)));
              g.drawLine(x, y, x1, y1);
          }
          //vẽ kim đồng hồ
          drawHands(g, second, minute, hours);
          SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
          g.setColor(Color.BLUE);
          g.setFont(new Font("Tahoma", Font.BOLD, 16));
          g.drawString(sdf.format(cal.getTime()), 120, 280);
          g.setFont(new Font("Arial", Font.BOLD, 10));
           g.drawString("12",146 , 80);
           g.drawString("3",222 , 153);
           g.drawString("9",72 , 153);
           g.drawString("6",148 , 230);

      }
      public void drawHands(Graphics g, double second, double minute, double hours) {
          double rSecond = (second * 6) * (Math.PI) / 180;
          double rMinute = ((minute + (second / 60)) * 6) * (Math.PI) / 180;
          double rHours = ((hours + (minute / 60)) * 30) * (Math.PI) / 180;
          g.setColor(Color.RED);
          g.drawLine(150, 150, 150 + (int)(100 * Math.cos(rSecond - (Math.PI / 2))), 150 + (int)(100 * Math.sin(rSecond - (Math.PI / 2))));
          g.setColor(Color.BLACK);
          g.drawLine(150, 150, 150 + (int)(70 * Math.cos(rMinute - (Math.PI / 2))), 150 + (int)(70 * Math.sin((rMinute - (Math.PI / 2)))));
          g.drawLine(150, 150, 150 + (int)(50 * Math.cos(rHours - (Math.PI / 2))), 150 + (int)(50 * Math.sin(rHours - (Math.PI / 2))));
      }

      class TickTimerTask extends TimerTask {

          @Override
          public void run() {
              cal = (GregorianCalendar) GregorianCalendar.getInstance(clockTimeZone);
              repaint();
          }
      }
      public static void main(String[] args) {
          // TODO code application logic here
          JFrame frame = new JFrame("Clock");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setPreferredSize(new Dimension(480, 360));
          Clock clock2d = new Clock();
          clock2d.setPreferredSize(new Dimension(480, 360));
          clock2d.init();
          frame.setLayout(new BorderLayout());
          frame.getContentPane().add(clock2d, BorderLayout.CENTER);
          frame.pack();
          frame.setVisible(true);
      }
  }