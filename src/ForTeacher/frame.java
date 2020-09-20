package ForTeacher;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frame() {
		setBackground(new Color(255, 255, 204)); //선생님
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 504);
		setLocationRelativeTo(null);
		
		Main Main = new Main();
		setContentPane(Main.panel);
		
		
		//PointPanel
		Main.pointButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPointPanel VPointPanel = new ViewPointPanel();
				Main.panel.setVisible(false);
				setContentPane(VPointPanel.panel);
				VPointPanel.panel.setVisible(true);
				
				VPointPanel.ShowTable();
				
				VPointPanel.backButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						VPointPanel.panel.setVisible(false);
						setContentPane(Main.panel);
						Main.panel.setVisible(true);
					}
				});
				VPointPanel.addPointButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AddPointPanel APointPanel = new AddPointPanel();
						VPointPanel.panel.setVisible(false);
						setContentPane(APointPanel.panel);
						APointPanel.panel.setVisible(true);
						
						APointPanel.AddPointButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								APointPanel.AddPoint();
								Main.panel.setVisible(false);
								JOptionPane.showMessageDialog(null, "상벌점이 추가 되었습니다. ");
								setContentPane(Main.panel);
								Main.panel.setVisible(true);
							}
						});
					}
				});
			}
		});
		
		
		
		
		
		
		//StayPanel
		ViewStayPanel VStayPanel = new ViewStayPanel();
		Main.stayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.panel.setVisible(false);
				setContentPane(VStayPanel.panel);
				VStayPanel.panel.setVisible(true);
				
				VStayPanel.ShowTable();
				
				VStayPanel.backButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VStayPanel.panel.setVisible(false);
						setContentPane(Main.panel);
						Main.panel.setVisible(true);
					}
				});
				
			}
		});
		
		
	}

}
