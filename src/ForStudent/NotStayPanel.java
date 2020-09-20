package ForStudent;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

public class NotStayPanel {
	JPanel panel = new JPanel();
	JButton notStayButton = new JButton("확인");
	public NotStayPanel() {
		panel.setPreferredSize(new Dimension(650, 450));//크기고정
		panel.setBackground(new Color(255, 255, 204));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
			
		JLabel notStayLabel = new JLabel("금토외박입니다. 일요일 21시까지 입실하세요.");
		notStayLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		notStayLabel.setBounds(87, 121, 476, 191);
		panel.add(notStayLabel);
		notStayButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uD655\uC7782.GIF"));
			
		notStayButton.setBounds(560, 396, 76, 42);
		panel.add(notStayButton);
	}
}
