package ForStudent;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginPanel{
//	public static JFrame FRAME = new JFrame();

	public static int id;
	private JTextField idText;
	private JTextField nameText;
	private JTextField roomText;
	private Image scrennImage;//더플버퍼링 막는
	private Graphics screenGraphic;//더플버퍼링 막는
	
	private Image dorm;
	
	
	JButton loginButton = new JButton("Login");
	JPanel panel = new JPanel();
	
	public LoginPanel() {
		panel.setPreferredSize(new Dimension(650, 450));//크기고정
		panel.setBackground(new Color(255, 255, 204));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setVisible(true);
		panel.setLayout(null);
		

		idText = new JTextField();
		idText.setBounds(242, 101, 214, 27);
		panel.add(idText);
		idText.setColumns(10);
		
		nameText = new JTextField();
		nameText.setBounds(242, 195, 214, 24);
		panel.add(nameText);
		nameText.setColumns(10);
		
		roomText = new JTextField();
		roomText.setBounds(242, 284, 214, 24);
		panel.add(roomText);
		roomText.setColumns(10);
		
		JLabel idLabel = new JLabel("학번 : ");
		idLabel.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 20));
		idLabel.setBounds(166, 103, 62, 18);
		panel.add(idLabel);
		
		JLabel nameLabel = new JLabel("이름 :");
		nameLabel.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 20));
		nameLabel.setBounds(166, 196, 62, 18);
		panel.add(nameLabel);
		
		JLabel roomLabel = new JLabel("호실 :");
		roomLabel.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 20));
		roomLabel.setBounds(166, 285, 62, 18);
		panel.add(roomLabel);
		loginButton.setIcon(new ImageIcon("C:\\Users\\\uCD5C\uBBFC\uC815\\Desktop\\\uB85C\uADF8\uC778.GIF"));
		
		
		loginButton.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 21));
		loginButton.setBounds(479, 346, 145, 65);
		panel.add(loginButton);
		
		
		dorm = new ImageIcon(LoginPanel.class.getResource("../image/dorm.jpg")).getImage();
		
		
	}
	
	
	public boolean loginCheck() {
		DB db = new DB(); //디비 연결
		id = Integer.parseInt(idText.getText());

		try {
			String sql = "select * from student where id = "+ id + ";";
			db.rs = db.st.executeQuery(sql); //실행 

			while(db.rs.next()) {	
        	if(db.rs.getString("name").equals(nameText.getText()) && db.rs.getString("room").equals(roomText.getText())) 
        	{
        		JOptionPane.showMessageDialog(null, "로그인 되었습니다. ");
        		return true; 
			}
        	else {
				JOptionPane.showMessageDialog(null,"다시 입력해주세요. ");
				return false;
			}
			}
			
		}
		catch(Exception e2){ //디비 오류
        	System.out.println("오류 Login " + e2.getMessage());
        }
		return false;
	}
}
