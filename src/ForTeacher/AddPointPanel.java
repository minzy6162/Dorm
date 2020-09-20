package ForTeacher;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ForStudent.LoginPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

public class AddPointPanel {
	JPanel panel = new JPanel();
	private JTextField idText;
	JButton AddPointButton = new JButton("확인");
	DB db = new DB();
	JSpinner plus_pSpinner = new JSpinner();
	JSpinner minus_pSpinner = new JSpinner();
	
	public AddPointPanel() {
		panel.setPreferredSize(new Dimension(650, 450));//크기고정
		panel.setBackground(new Color(255, 255, 204));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		JLabel idLabel = new JLabel("학번 : ");
		idLabel.setBounds(233, 120, 62, 18);
		panel.add(idLabel);
		
		JLabel plus_pLabel = new JLabel("상점 : ");
		plus_pLabel.setBounds(233, 174, 62, 18);
		panel.add(plus_pLabel);
		
		JLabel minus_pLabel = new JLabel("벌점 : ");
		minus_pLabel.setBounds(233, 240, 62, 18);
		panel.add(minus_pLabel);
		
		idText = new JTextField();
		idText.setBounds(306, 117, 116, 24);
		panel.add(idText);
		idText.setColumns(10);
		
		
		plus_pSpinner.setBounds(317, 176, 77, 24);
		panel.add(plus_pSpinner);
		
		
		
		minus_pSpinner.setBounds(317, 237, 77, 24);
		panel.add(minus_pSpinner);
		int minus_p = (int)minus_pSpinner.getModel().getValue();
		AddPointButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uD655\uC7782.GIF"));
		
				
		AddPointButton.setBounds(559, 400, 77, 38);
		panel.add(AddPointButton);
	}
	public void AddPoint() {
		setPlus_p();
		setMinus_p();
		setTotal_p();
		clear_textField();
	}
	public void setPlus_p() {
		String sql = "select * FROM point where id = "+ idText.getText() + ";";
		int plus_p = (int) plus_pSpinner.getModel().getValue();
		int Plus_p = 0;
		try {
			db.rs = db.st.executeQuery(sql);
			while(db.rs.next()) { 
				Plus_p = db.rs.getInt("plus_p") + plus_p;
			} 
			String setPlus_p =
					"UPDATE point SET plus_p = " + Plus_p + " where id = " + idText.getText() + ";";
					db.st.executeUpdate(setPlus_p);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public void setMinus_p() {
		String sql = "select * FROM point where id = "+ idText.getText() + ";";
		int minus_p = (int) minus_pSpinner.getModel().getValue();
		int Minus_p = 0;
		try {
			db.rs = db.st.executeQuery(sql);
			while(db.rs.next()) {
				Minus_p = db.rs.getInt("minus_p") + minus_p;
			} 
			String setMinus_p =
					"UPDATE point SET minus_p = " + Minus_p + " where id = " + idText.getText() + ";";
					db.st.executeUpdate(setMinus_p);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public void setTotal_p() {
		String sql = "select * FROM point where id = "+ idText.getText() + ";";
		int Total_p = 0;
		try {
			db.rs = db.st.executeQuery(sql);
			while(db.rs.next()) {
				Total_p =  db.rs.getInt("plus_p") - db.rs.getInt("minus_p");
			}
			String setTotal_p = "UPDATE point SET total_p = " + Total_p + " where id = " + idText.getText();
			db.st.executeUpdate(setTotal_p);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void clear_textField() {
		idText.setText("");
		plus_pSpinner.setValue(0);
		minus_pSpinner.setValue(0);
	}
}
