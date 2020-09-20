package ForTeacher;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

public class ViewOutingPanel  {
	JPanel panel = new JPanel();
	public ViewOutingPanel() {
		panel.setPreferredSize(new Dimension(650, 450));//크기고정
		panel.setBackground(new Color(255, 255, 204));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
	}

}
