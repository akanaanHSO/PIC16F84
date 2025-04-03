import javax.swing.*;
import java.awt.Color;
import helper_classes.*;

public class WindowBuilder {
  public static void main(String[] args) {

     JFrame frame = new JFrame("PIC16F84 Simulator");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(938, 507);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#1e1e1e"));

     JButton startButton = new JButton("Start");
     startButton.setBounds(4, 4, 106, 28);
     startButton.setBackground(Color.decode("#2e2e2e"));
     startButton.setForeground(Color.decode("#D9D9D9"));
     startButton.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     startButton.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     startButton.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(startButton, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(startButton);

     frame.add(panel);
     frame.setVisible(true);

  }
}