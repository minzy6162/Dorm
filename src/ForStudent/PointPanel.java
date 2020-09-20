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

public class PointPanel {
	DB db = new DB();
	JPanel panel = new JPanel();
	JButton OkayButton = new JButton("È®ÀÎ");
	public PointPanel() {
		panel.setPreferredSize(new Dimension(650, 450));//Å©±â°íÁ¤
		panel.setBackground(new Color(255, 255, 204));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		JLabel plus_pLabel = new JLabel("»óÁ¡ : ");
		plus_pLabel.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		plus_pLabel.setBounds(251, 176, 62, 18);
		panel.add(plus_pLabel);
		
		JLabel minus_pLabel = new JLabel("¹úÁ¡ : ");
		minus_pLabel.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		minus_pLabel.setBounds(251, 237, 62, 18);
		panel.add(minus_pLabel);
		
		JLabel total_pLabel = new JLabel("ÃÑÁ¡ : ");
		total_pLabel.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		total_pLabel.setBounds(251, 300, 62, 18);
		panel.add(total_pLabel);
		
		JLabel plus_p = new JLabel(Integer.toString(getPlus_p()));
		plus_p.setBounds(346, 178, 109, 18);
		panel.add(plus_p);
		
		JLabel minus_p = new JLabel(Integer.toString(getMinus_p()));
		minus_p.setBounds(346, 239, 62, 18);
		panel.add(minus_p);
		
		JLabel total_p = new JLabel(Integer.toString(getTatal_p()));
		total_p.setBounds(346, 302, 62, 18);
		panel.add(total_p);
		OkayButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uD655\uC7782.GIF"));
		
		
		
		OkayButton.setFont(new Font("±¼¸²", Font.PLAIN, 21));
		OkayButton.setBounds(558, 400, 78, 38);
		panel.add(OkayButton);
		
	}
	public int getPlus_p() {
		try {
			String sql = "select * FROM point where id = "+ LoginPanel.id + ";";
			db.rs = db.st.executeQuery(sql);
			if(db.rs.next()) {
				return db.rs.getInt("plus_p");
			}
			}
			catch(Exception e2){
	        	System.out.println("¿À·ù Point " + e2.getMessage());
	        }
			return 0;
	}
	public int getMinus_p() {
		try {
			String sql = "select * FROM point where id = "+ LoginPanel.id + ";";
			db.rs = db.st.executeQuery(sql);
			if(db.rs.next()) {
				return db.rs.getInt("minus_p");
			}
			}
			catch(Exception e2){
	        	System.out.println("¿À·ù Point " + e2.getMessage());
	        }
			return 0;
	}
	public int getTatal_p() {
		try {
			String sql = "select * FROM point where id = "+ LoginPanel.id + ";";
			db.rs = db.st.executeQuery(sql);
			if(db.rs.next()) {
				return db.rs.getInt("total_p");
			}
			}
			catch(Exception e2){
	        	System.out.println("¿À·ù Point " + e2.getMessage());
	        }
			return 0;
	}
}
