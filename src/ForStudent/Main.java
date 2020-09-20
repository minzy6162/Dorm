package ForStudent;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton pointButton = new JButton("상벌점");
	JButton outingButton = new JButton("외출일지");
	JButton stayButton = new JButton("외박일지");
	
	public Main() {
		frame.setTitle("기숙사 관리");
		frame.setBounds(100, 100, 295, 226);
		
		panel.setPreferredSize(new Dimension(650, 450));//크기고정
		panel.setBackground(new Color(255, 255, 204));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		pointButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uC0C1\uBC8C\uC8103.GIF"));
				
		pointButton.setBounds(70, 218, 126, 44);
		panel.add(pointButton);		
		outingButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uC678\uCD9C\uC77C\uC9C08.GIF"));
	
		outingButton.setBounds(283, 218, 126, 44);
		panel.add(outingButton);
		stayButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uC678\uBC15\uC77C\uC9C06.GIF"));
		
		
		stayButton.setBounds(482, 222, 126, 36);
		panel.add(stayButton);
	}
	public String getLocal() {
		DB db = new DB();
		String sql = "SELECT * FROM stay where id = " + LoginPanel.id + ";";
		try {
			db.rs = db.st.executeQuery(sql);
			while(db.rs.next()) {
				return db.rs.getString("local");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getStayFlag() {
		DB db = new DB();
		String sql = "SELECT * FROM stay where id = " + LoginPanel.id + ";";
		try {
			db.rs = db.st.executeQuery(sql);
			while(db.rs.next()) {
				return db.rs.getInt("flag");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
