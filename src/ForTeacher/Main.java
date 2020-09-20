package ForTeacher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Main {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton pointButton = new JButton("상벌점");
	JButton stayButton = new JButton("외박일지");
	public Main() {
		frame.setBounds(100, 100, 667, 402);
		frame.setResizable(false);
		
		panel.setPreferredSize(new Dimension(650, 450));//크기고정
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		pointButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uC255, 255, 204C810.GIF"));
		pointButton.setForeground(new Color(255, 255, 255));
		pointButton.setBackground(Color.WHITE);
		pointButton.setBounds(73, 194, 127, 58);
		panel.add(pointButton);
		
		stayButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uC678\uBC15\uC77C\uC9C0.GIF"));
		stayButton.setForeground(new Color(255, 255, 255));
		stayButton.setBackground(Color.WHITE);
		stayButton.setBounds(73, 194, 127, 58);
		panel.add(stayButton);
	}
}
