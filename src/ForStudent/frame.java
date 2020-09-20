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
		setBackground(new Color(255, 255, 204)); //학생
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		setLocationRelativeTo(null);
		LoginPanel log = new LoginPanel();
		setContentPane(log.panel);
		
		Main Main = new Main();
		
		
		log.loginButton.addActionListener(new ActionListener() {//로그인
			public void actionPerformed(ActionEvent arg0) {
				
				if(log.loginCheck()==true) {//로그인이 되면.
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
							if(OutingPanel.getOutingFlag() == 0) { //나갈 때
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
											JOptionPane.showMessageDialog(null, "다시 입력해주세요");
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
							}else { //들어올 때
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
							
							if(Main.getLocal().equals("서울") || Main.getLocal().equals("경기")) {
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
								
							}else { //서울, 경기 학생이 아니면.
								
								if(Main.getStayFlag() == 0) {//창을 한번도 안열었을 때 flag = 0
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
								else {//창을 한번 열었을 때 flag = 1
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
		
				}//end of if문 로그인 되었을 때 
			}
		}); //end of Login
	}

}
