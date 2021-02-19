package client.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class QunChatFrame extends JFrame
{

	private JPanel contentPane;
	public JTree tree;
	public JButton btn发送;
	public JButton btn关闭;
	public JTextPane textPane发送;
	public JTextPane textPane接收框;
	public JTextArea textArea群公告;
	public JLabel jLabel聊天记录;
	private JScrollPane jScrollPane3,jScrollPane1;
	private JPanel jPanel工具面板;
	public JLabel lbl发送文件;
	public JLabel lbl视频;
	public JLabel lbl语音;
	public JLabel lbl文字;
	public JLabel lbl表情;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					QunChatFrame frame = new QunChatFrame();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QunChatFrame()
	{
		setTitle("聊天室");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 750);
		contentPane = new JPanel();
	//	contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel右边 = new JPanel();
		
		JPanel panel左边 = new JPanel();
		panel左边.setBackground(new Color(204, 255, 204));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(panel左边, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel右边, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel右边, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
				.addComponent(panel左边, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
		);
		
		jPanel工具面板 = new JPanel();
		jPanel工具面板.setBackground(new java.awt.Color(204, 255, 255));

		
		JPanel panel中间 = new JPanel();
		
		JPanel panel底部 = new JPanel();
		GroupLayout gl_panel左边 = new GroupLayout(panel左边);
		
		panel左边.setLayout(gl_panel左边);
		gl_panel左边.setHorizontalGroup(gl_panel左边
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(panel底部, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panel中间, javax.swing.GroupLayout.DEFAULT_SIZE,
						486, Short.MAX_VALUE));
		gl_panel左边
				.setVerticalGroup(gl_panel左边
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gl_panel左边
										.createSequentialGroup()
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												panel中间,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												260, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												panel底部,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)));
		panel底部.setBackground(new Color(204, 255, 255));
	
	
		 lbl视频 = new JLabel("");
		lbl视频.setIcon(new ImageIcon(QunChatFrame.class.getResource("/client/img/chat/fun_video_54.png")));
	
		
		 lbl语音 = new JLabel("");
		lbl语音.setIcon(new ImageIcon(QunChatFrame.class.getResource("/client/img/chat/fun_voice_54.png")));
		
		
		 lbl发送文件 = new JLabel("");
		lbl发送文件.setIcon(new ImageIcon(QunChatFrame.class.getResource("/client/img/chat/fun_sendfile_54.png")));
		
		
		panel中间.setLayout(new BorderLayout(0, 0));
		
		jScrollPane1 = new JScrollPane();
		textPane接收框 = new JTextPane();
		textPane接收框.setEditable(false);
		jScrollPane1.setViewportView(textPane接收框);
		panel中间.add(jScrollPane1);
		
		
		
		textPane发送 = new JTextPane();
		
		btn发送 = new JButton("\u53D1\u9001");
		btn发送.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		
		btn关闭 = new JButton("\u5173\u95ED");
		btn关闭.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		
		 lbl文字 = new JLabel("");
		lbl文字.setIcon(new ImageIcon(QunChatFrame.class.getResource("/client/img/chat/fun_font_32.png")));
		
		 lbl表情 = new JLabel("");
		lbl表情.setIcon(new ImageIcon(QunChatFrame.class.getResource("/client/img/chat/fun_face_32.png")));
		
	
		GroupLayout gl_panel底部 = new GroupLayout(panel底部);
	/*	gl_panel底部.setHorizontalGroup(
			gl_panel底部.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel底部.createSequentialGroup()
					.addContainerGap(285, Short.MAX_VALUE)
					.addComponent(btn关闭, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn发送, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
				.addComponent(textPane发送, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_panel底部.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl文字)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl表情)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl语音)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lbl视频)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl发送文件)
					.addContainerGap(258, Short.MAX_VALUE))
		);
		gl_panel底部.setVerticalGroup(
			gl_panel底部.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel底部.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(gl_panel底部.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl文字)
						.addComponent(lbl表情)
						.addComponent(lbl语音)
						.addComponent(lbl视频)
						.addComponent(lbl发送文件))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane发送, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel底部.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btn发送, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btn关闭, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		*/
		jLabel聊天记录 = new JLabel();
		jLabel聊天记录.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/client/img/chat/fun_message_history_32.png"))); // NOI18N
		jLabel聊天记录.setText("\u804a\u5929\u8bb0\u5f55");
		jLabel聊天记录
				.setToolTipText("\u6253\u5f00\u6211\u7684\u804a\u5929\u8bb0\u5f55");
		
		
		jScrollPane3 = new JScrollPane();
		jScrollPane3.setViewportView(textPane发送);

		
		gl_panel底部
				.setHorizontalGroup(gl_panel底部
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel工具面板,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								gl_panel底部
										.createSequentialGroup()
										.addContainerGap(321, Short.MAX_VALUE)
										.addComponent(
												btn关闭,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												77,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												btn发送,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												77,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(5, 5, 5))
						.addComponent(jScrollPane3,
								javax.swing.GroupLayout.DEFAULT_SIZE, 486,
								Short.MAX_VALUE));
		gl_panel底部
				.setVerticalGroup(gl_panel底部
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								gl_panel底部
										.createSequentialGroup()
										.addComponent(
												jPanel工具面板,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												36,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10)
										.addGroup(
												gl_panel底部
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																btn发送,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																38,
																Short.MAX_VALUE)
														.addComponent(
																btn关闭,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																38,
																Short.MAX_VALUE))
										.addContainerGap()));
		
		GroupLayout jPanel工具面板Layout = new GroupLayout(
				jPanel工具面板);
		jPanel工具面板.setLayout(jPanel工具面板Layout);
		jPanel工具面板Layout
		.setHorizontalGroup(jPanel工具面板Layout
				.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel工具面板Layout
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(
										lbl文字,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										36,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(lbl表情)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(lbl语音)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(lbl视频)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(lbl发送文件)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										193, Short.MAX_VALUE)
								.addComponent(jLabel聊天记录)));
		jPanel工具面板Layout
		.setVerticalGroup(jPanel工具面板Layout
				.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						jPanel工具面板Layout
								.createSequentialGroup()
								.addGroup(
										jPanel工具面板Layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lbl文字)
												.addComponent(lbl表情)
												.addComponent(lbl语音)
												.addComponent(lbl视频)
												.addComponent(lbl发送文件)
												.addComponent(
														jLabel聊天记录))
								.addContainerGap()));

		panel底部.setLayout(gl_panel底部);
		panel左边.setLayout(gl_panel左边);
		
		JPanel panel公告 = new JPanel();
		//panel公告.setBackground(new Color(0, 153, 255));
		panel公告.setBorder(new TitledBorder(null, "\u7FA4\u516C\u544A", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, Color.RED));
		
		JScrollPane scrollPane = new JScrollPane();
		panel公告.setLayout(new BorderLayout(0, 0));
		
		textArea群公告 = new JTextArea();
		textArea群公告.setLineWrap(true);
		//textArea群公告.setForeground(new Color(255, 0, 0));
		textArea群公告.setText("暂无公告");
		textArea群公告.setFont(new Font("微软雅黑", Font.BOLD, 18));
		//textArea群公告.setBackground(new Color(255, 204, 0));
		textArea群公告.setEnabled(false);
		panel公告.add(textArea群公告, BorderLayout.CENTER);
		GroupLayout gl_panel右边 = new GroupLayout(panel右边);
		gl_panel右边.setHorizontalGroup(
			gl_panel右边.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel右边.createSequentialGroup()
					.addGap(0)
					.addGroup(gl_panel右边.createParallelGroup(Alignment.LEADING)
						.addComponent(panel公告, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_panel右边.setVerticalGroup(
			gl_panel右边.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel右边.createSequentialGroup()
					.addComponent(panel公告, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
		);
		
		tree = new JTree();
		tree.setRootVisible(false);
		scrollPane.setViewportView(tree);
		panel右边.setLayout(gl_panel右边);
		contentPane.setLayout(gl_contentPane);
	}
}
