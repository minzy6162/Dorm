package ForStudent;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ForTeacher.AddPointPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ComePanel {
	JPanel panel = new JPanel();
	JButton comeinButton = new JButton("들어옴");

	public ComePanel() {
		panel.setBackground(new Color(255, 255, 204));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		comeinButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uB4E4\uC5B4\uC6341.GIF"));
		
		
		comeinButton.setBounds(272, 269, 99, 47);
		panel.add(comeinButton);
	}
	public void setComein() {
		setOutingFlag();
		checkLate();
		setReal_t();
	}
	public void setOutingFlag() {
		DB db = new DB();
		String sql = "UPDATE outing SET flag = "+ 0
			+ " where id = " + LoginPanel.id +";";
		try {
			db.st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//+디비 비우기
	}
	public void checkLate() {
		DB db = new DB();
		int comein_t, real_comein_t;
		real_comein_t = Integer.parseInt(getDate());
		String sql = "SELECT * FROM outing where id = " + LoginPanel.id + ";";
		
		try {
			db.rs = db.st.executeQuery(sql);
			while(db.rs.next()) {
				comein_t = db.rs.getInt("comein_t");
				if(comein_t < real_comein_t || real_comein_t > 2100) {
					setMinus_p();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setMinus_p() {
		DB db = new DB();
		int minus_p;
		minus_p = getMinus_p() + 5;
		 
		
		String setMinus_p = "UPDATE point SET minus_p = " + minus_p
				+ " where id = " + LoginPanel.id+";";
		try {
			db.st.executeUpdate(setMinus_p);
			setTotal_p();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void setTotal_p() {
		DB db = new DB();
		String sql = "select * FROM point where id = "+ LoginPanel.id + ";";
		int Total_p = 0;
		try {
			db.rs = db.st.executeQuery(sql);
			while(db.rs.next()) {
				Total_p =  db.rs.getInt("plus_p") - db.rs.getInt("minus_p");
			}
			String setTotal_p = "UPDATE point SET total_p = " + Total_p + " where id = " + LoginPanel.id;
			db.st.executeUpdate(setTotal_p);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void setReal_t() {
		DB db = new DB();
		Date time = new Date();
		SimpleDateFormat date = new SimpleDateFormat("HHmm");
		String setDate = "UPDATE outing SET real_comein_t = '" + date.format(time)
			+ "' where id = " + LoginPanel.id + ";";
		try {
			db.st.executeLargeUpdate(setDate);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public String getDate() {
		DB db = new DB();
		Date time = new Date();
		SimpleDateFormat date = new SimpleDateFormat("HHmm");
		return date.format(time);

	}
	public int getMinus_p() {
		DB db = new DB();
		String sql = "SELECT * FROM point where id = " + LoginPanel.id + ";";
		try {
			db.rs = db.st.executeQuery(sql);
			while(db.rs.next()) {
				return db.rs.getInt("minus_p");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}return 0;
	}
}
