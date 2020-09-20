package ForStudent;

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

	/**
	 * Create the frame.
	 */
	public frame() {
		setBackground(new Color(255, 255, 204)); //�л�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		setLocationRelativeTo(null);
		LoginPanel log = new LoginPanel();
		setContentPane(log.panel);
		
		Main Main = new Main();
		
		
		log.loginButton.addActionListener(new ActionListener() {//�α���
			public void actionPerformed(ActionEvent arg0) {
				
				if(log.loginCheck()==true) {//�α����� �Ǹ�.
					log.panel.setVisible(false);
					setContentPane(Main.panel);
					Main.panel.setVisible(true);
					
					
					
					//pointPanel
					Main.pointButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							PointPanel PointPanel = new PointPanel();
							Main.panel.setVisible(false);
							setContentPane(PointPanel.panel);
							PointPanel.panel.setVisible(true);
							
							PointPanel.OkayButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									PointPanel.panel.setVisible(false);
									setContentPane(Main.panel);
									Main.panel.setVisible(true);
								}
							});
						}
					});
					
					//outingPanel
					Main.outingButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							OutingPanel OutingPanel = new OutingPanel();
							if(OutingPanel.getOutingFlag() == 0) { //���� ��
								Main.panel.setVisible(false);
								setContentPane(OutingPanel.panel);
								OutingPanel.panel.setVisible(true);
								
								OutingPanel.okayButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										if(OutingPanel.checkText() == true) {
											OutingPanel.panel.setVisible(false);
											setContentPane(Main.panel);
											Main.panel.setVisible(true);
											OutingPanel.setOuting();
										}else {
											JOptionPane.showMessageDialog(null, "�ٽ� �Է����ּ���");
										}
									}
								});
								OutingPanel.backButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										OutingPanel.panel.setVisible(false);
										setContentPane(Main.panel);
										Main.panel.setVisible(true);
									}
								});
							}else { //���� ��
								ComePanel ComePanel = new ComePanel();
								Main.panel.setVisible(false);
								setContentPane(ComePanel.panel);
								ComePanel.panel.setVisible(true);
								
								ComePanel.comeinButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										ComePanel.panel.setVisible(false);
										setContentPane(Main.panel);
										Main.panel.setVisible(true);
										ComePanel.setComein();
									}
								});
							}
							
							
							
						}
					});
					
					
					//stayPanel
					Main.stayButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							if(Main.getLocal().equals("����") || Main.getLocal().equals("���")) {
								NotStayPanel NStayPanel = new NotStayPanel();

								Main.panel.setVisible(false);
								setContentPane(NStayPanel.panel);
								NStayPanel.panel.setVisible(true);
								
								NStayPanel.notStayButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										NStayPanel.panel.setVisible(false);
										setContentPane(Main.panel);
										Main.panel.setVisible(true);
									}
								});//end of notStayButton
								
							}else { //����, ��� �л��� �ƴϸ�.
								
								if(Main.getStayFlag() == 0) {//â�� �ѹ��� �ȿ����� �� flag = 0
									StayPanel StayPanel = new StayPanel();
									Main.panel.setVisible(false);
									setContentPane(StayPanel.panel);
									StayPanel.panel.setVisible(true);
									
									StayPanel.okayButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											StayPanel.setStay();
											StayPanel.panel.setVisible(false);
											setContentPane(Main.panel);
											Main.panel.setVisible(true);
										}
									});//end of okayButton
									
								}//end of flag=0
								else {//â�� �ѹ� ������ �� flag = 1
									OkayStayPanel OStayPanel = new OkayStayPanel();
									Main.panel.setVisible(false);
									setContentPane(OStayPanel.panel);
									OStayPanel.panel.setVisible(true);
									
									OStayPanel.okayButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											OStayPanel.panel.setVisible(false);
											setContentPane(Main.panel);
											Main.panel.setVisible(true);
											
										}
									});//end of okayButton
									
								}//end of flag = 1
							}
							
						}
						
					});
		
				}//end of if�� �α��� �Ǿ��� �� 
			}
		}); //end of Login
	}

}
