package ForStudent;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

public class OutingPanel {

	JPanel panel = new JPanel();
	JButton okayButton = new JButton("확인");
	JTextField destinationText;
	JTextField purposeText;
	JComboBox hourCombo = new JComboBox();
	JComboBox minuteCombo = new JComboBox();

	JButton backButton = new JButton("");
	private JLabel TimeNowLabel;
	private JLabel TimeNow;
	private JLabel comein_tLabel;
	
	public OutingPanel() {
		panel.setPreferredSize(new Dimension(650, 450));//크기고정
		panel.setBackground(new Color(255, 255, 204));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		destinationText = new JTextField();
		destinationText.setBounds(72, 202, 116, 24);
		panel.add(destinationText);
		destinationText.setColumns(10);
		
		JLabel destinationLabel = new JLabel("목적지");
		destinationLabel.setBounds(105, 172, 62, 18);
		destinationLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(destinationLabel);
		
		purposeText = new JTextField();
		purposeText.setBounds(188, 202, 116, 24);
		panel.add(purposeText);
		purposeText.setColumns(10);
		
		JLabel purposeLabel = new JLabel("목적");
		purposeLabel.setBounds(219, 173, 62, 18);
		purposeLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		panel.add(purposeLabel);
		
		comein_tLabel = new JLabel("들어 올 시간");
		comein_tLabel.setBounds(434, 174, 124, 18);
		comein_tLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		panel.add(comein_tLabel);
		hourCombo.setBounds(435, 202, 44, 24);
		panel.add(hourCombo);
		
		Date time = new Date();
		SimpleDateFormat date = new SimpleDateFormat("HH");
		hourCombo.addItem("시");
		for(int i = Integer.parseInt(date.format(time)); i<=20; i++) {
			hourCombo.addItem(""+i+"");
		}
		
		JLabel hourLabel = new JLabel("시");
		hourLabel.setBounds(480, 205, 26, 18);
		panel.add(hourLabel);
		minuteCombo.setBounds(501, 202, 44, 24);
		panel.add(minuteCombo);
		minuteCombo.addItem("분");
		for(int i = 0; i<=59; i++) {
			
			minuteCombo.addItem(""+i+"");
		}
		
		JLabel minuteLabel = new JLabel("분");
		minuteLabel.setBounds(549, 205, 26, 18);
		panel.add(minuteLabel);
		okayButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uD655\uC7782.GIF"));
		okayButton.setBounds(562, 397, 74, 41);
		panel.add(okayButton);
		backButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uD654\uC0B4\uD45C2.GIF"));
		backButton.setBounds(40, 26, 116, 24);
		panel.add(backButton);
		
	}
		
	public int getOutingFlag() {
		DB db = new DB();
		String sql = "SELECT * FROM outing where id = " + LoginPanel.id +";";
		try {
			db.rs = db.st.executeQuery(sql);
			while(db.rs.next()) {
				return db.rs.getInt("flag");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public boolean checkText() {//텍스트가 다 찼는지 
		if(
		destinationText.getText().equals("")|
		purposeText.getText().equals("")|
		hourCombo.getSelectedItem().equals("시")|
		minuteCombo.getSelectedItem().equals("분")) {
			return false;
		}else {
			return true;
		}
				
	}
	public void setOuting() {
		setDestination();		
		setPurpose();
		setComein();
		setDate();
		setOutingFlag();
	}
	public void setDate() {
		DB db = new DB();
		Date time = new Date();
		SimpleDateFormat date = new SimpleDateFormat("HHmm");
		String setDate = "UPDATE outing SET exit_t = '" + date.format(time)
			+ "' where id = " + LoginPanel.id +";";
		try {
			db.st.executeLargeUpdate(setDate);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void setDestination() {
		DB db = new DB();
		String sql = "UPDATE outing SET destination = '"+ destinationText.getText()
			+ "' where id = " + LoginPanel.id +";";
		try {
			db.st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setPurpose() {
		DB db = new DB();
		String sql = "UPDATE outing SET purpose = '"+ purposeText.getText()
			+ "' where id = " + LoginPanel.id +";";
		try {
			db.st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setComein() {
		DB db = new DB();
		String hour =  (String) hourCombo.getSelectedItem();
		String minute;
		if(Integer.parseInt((String) minuteCombo.getSelectedItem())<10) {
			minute = "0" + (String)minuteCombo.getSelectedItem();
		}else {
			minute =  (String) minuteCombo.getSelectedItem();
		}
		
		String comein_t = hour + minute;
		String sql = "UPDATE outing SET comein_t = '"+ comein_t
			+ "' where id = " + LoginPanel.id +";";
		try {
			db.st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setOutingFlag() {
		DB db = new DB();
		String sql = "UPDATE outing SET flag = "+ 1
			+ " where id = " + LoginPanel.id +";";
		try {
			db.st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
