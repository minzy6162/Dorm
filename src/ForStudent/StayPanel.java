package ForStudent;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

public class StayPanel {
	JPanel panel = new JPanel();
	JButton okayButton = new JButton("Ȯ��");
	JComboBox stayCombo = new JComboBox();
	private JTextField destinationText;
	
	public StayPanel() {
		panel.setPreferredSize(new Dimension(650, 450));//ũ�����
		panel.setBackground(new Color(255, 255, 204));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		JLabel localLabel = new JLabel("���� : ");
		localLabel.setFont(new Font("����", Font.PLAIN, 21));
		localLabel.setBounds(189, 149, 78, 30);
		panel.add(localLabel);
		
		JLabel localText = new JLabel(getLocal());
		localText.setFont(new Font("����", Font.BOLD, 21));
		localText.setBounds(308, 158, 150, 18);
		panel.add(localText);
		
		JLabel stayLabel = new JLabel("�ܷ����� : ");
		stayLabel.setFont(new Font("����", Font.PLAIN, 21));
		stayLabel.setBounds(189, 197, 108, 33);
		panel.add(stayLabel);
		
		
		stayCombo.setBounds(311, 204, 148, 24);
		panel.add(stayCombo);
		stayCombo.addItem("����");
		stayCombo.addItem("�ܷ�");
		stayCombo.addItem("����ܹ�");
		stayCombo.addItem("���ܹ�");		
		
		JLabel destinationLabel = new JLabel("������ : ");
		destinationLabel.setFont(new Font("����", Font.PLAIN, 21));
		destinationLabel.setBounds(189, 253, 96, 30);
		panel.add(destinationLabel);
		
		destinationText = new JTextField();
		destinationText.setBounds(308, 259, 150, 24);
		panel.add(destinationText);
		destinationText.setColumns(10);
		okayButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uD655\uC7782.GIF"));
		

		okayButton.setBounds(558, 398, 78, 40);
		panel.add(okayButton);
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

	public void setStay() {
		DB db = new DB();
		if(stayCombo.getSelectedItem().equals("����")|| destinationText.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�ܷ����θ� �������ֽð� �������� �Է����ּ���. ");
		}
		else {
			int result = JOptionPane.showConfirmDialog(null, stayCombo.getSelectedItem() + "�� �����Ͻðڽ��ϱ�? \n �����Ͻø�  �ٽ� �����ϽǼ� �����ϴ�. ",
					"Confirm", JOptionPane.YES_NO_OPTION);
			
			if(result == JOptionPane.CLOSED_OPTION) {
				
			}else if(result == JOptionPane.YES_OPTION) {
				String setStayFlag = "UPDATE stay SET flag = " + 1 + " where id = " + LoginPanel.id + ";";
				String setStay = "UPDATE stay SET stay = '" + stayCombo.getSelectedItem()
				+ "' where id = " + LoginPanel.id + ";";
				String setDestination = "UPDATE stay SET destination = '" + destinationText.getText() 
					+ "' where id = " + LoginPanel.id + ";";
				try {
					db.st.executeUpdate(setStayFlag);
					db.st.executeUpdate(setStay);
					db.st.executeUpdate(setDestination);
					JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�. ");
				}		
				catch(SQLException e) {
					e.printStackTrace();
				}
			}else {
				
			}
		}
	}
	
}
