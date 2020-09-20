package ForStudent;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

public class OkayStayPanel  {
	StayPanel StayPanel = new StayPanel();
	JButton okayButton = new JButton("확인");
	JPanel panel = new JPanel();
	public OkayStayPanel() {
		panel.setPreferredSize(new Dimension(650, 450));//크기고정
		panel.setBackground(new Color(255, 255, 204));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		StayPanel StayPanel = new StayPanel();
		panel.setLayout(null);
		JLabel okayStayLabel = new JLabel(getStay()+"입니다. \n 일요일 21시까지 입실하세요.");
		okayStayLabel.setBounds(75, 121, 563, 184);
		okayStayLabel.setFont(new Font("굴림", Font.PLAIN, 21));
		panel.add(okayStayLabel);
		okayButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uD655\uC7782.GIF"));
		
		
		
		okayButton.setBounds(559, 391, 79, 47);
		panel.add(okayButton);
	}
	public String getStay() {
		DB db = new DB();
		String sql = "SELECT * FROM stay where id = " + LoginPanel.id + ";";
		try {
			db.rs = db.st.executeQuery(sql);
			while(db.rs.next()) {
				return db.rs.getString("stay");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
