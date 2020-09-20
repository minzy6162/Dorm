package ForTeacher;

import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

public class ViewStayPanel {
	DB db = new DB();
	JPanel panel = new JPanel();
	private JTable table;
	JButton backButton = new JButton("←");
	public ViewStayPanel() {
		panel.setPreferredSize(new Dimension(650, 450));//크기고정
		panel.setBackground(new Color(255, 255, 204));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 70, 375, 300);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		backButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uD654\uC0B4\uD45C3.GIF"));
	
		
		
		backButton.setBounds(14, 12, 117, 27);
		panel.add(backButton);
			
	}
	public void ShowTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("학번");
		model.addColumn("이름");
		model.addColumn("잔류여부");
		model.addColumn("목적지");
		try {
			String View = "SELECT * FROM stay;";
			db.rs = db.st.executeQuery(View);
			while(db.rs.next()) {
				model.addRow(new Object [] {
					db.rs.getString("id"),
					db.rs.getString("name"),
					db.rs.getString("stay"),
					db.rs.getString("destination")				
				});
			}
			table.setModel(model);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
