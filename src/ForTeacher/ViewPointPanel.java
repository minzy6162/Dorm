package ForTeacher;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

public class ViewPointPanel {
	JPanel panel = new JPanel();
	private JTable table_1;
	JButton backButton = new JButton("��");
	JButton addPointButton = new JButton("����� �ֱ�");
	
	public ViewPointPanel() {
		panel.setPreferredSize(new Dimension(650, 450));//ũ�����
		panel.setBackground(new Color(255, 255, 204));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 116, 476, 233);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setFont(new Font("����", Font.PLAIN, 17));
		scrollPane.setViewportView(table_1);	
		backButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uD654\uC0B4\uD45C3.GIF"));
		
		backButton.setBounds(14, 12, 116, 27);
		panel.add(backButton);
		addPointButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uC0C1\uBC8C\uC810 \uC8FC\uAE30.GIF"));
		
		addPointButton.setBounds(481, 394, 155, 44);
		panel.add(addPointButton);
	}
	
	public void ShowTable() {
		DefaultTableModel model = new DefaultTableModel();
		//�� �̸�
		model.addColumn("�й� ");
		model.addColumn("�̸�");
		model.addColumn("����");
		model.addColumn("���");
		
		DB db = new DB(); //��� ����

		try {
			String View = "select * from point;";
			db.rs = db.st.executeQuery(View);
			while(db.rs.next()){ //�����Ͱ� ���������� �ݺ�
				String warning;
				if(db.rs.getInt("total_p")>-15){
					warning = ".";
				}else if(db.rs.getInt("total_p")<=-15 && db.rs.getInt("total_p")>-30){
					warning = "�ӽ����";
				}else {
					warning = "�������";
				}
				//��
				model.addRow(new Object [] {
						db.rs.getString("id"),
						db.rs.getString("name"),
						db.rs.getString("total_p"),
						warning						
				});
			}
			table_1.setModel(model);
			
		}
		catch(Exception e3){
			e3.printStackTrace();
		}
	}
}
