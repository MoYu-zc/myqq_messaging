package server.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import server.QQServer;

public class qgdMana extends JPanel{
	
	QQServer qqServer=null;
	ServerMana sm=new ServerMana();
	
	public JTextArea textArea公告;
	private JPanel panel;
	private JTextArea textArea弹窗;
	private JButton btn弹窗;
	private JPanel panel公告;
	
	public qgdMana() {
		
		setLayout(null);
		
		panel公告 = new JPanel();
		panel公告.setBorder(new TitledBorder(null, "\u53D1\u5E03\u804A\u5929\u5BA4\u516C\u544A", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel公告.setBounds(12, 25, 661, 220);
		add(panel公告);
		
		 textArea公告 = new JTextArea();
		JButton btn发布公告 = new JButton("\u53D1\u5E03\u804A\u5929\u5BA4\u516C\u544A");
		btn发布公告.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				sendPublicMessage();
			}
		});
		GroupLayout gl_panel公告 = new GroupLayout(panel公告);
		gl_panel公告.setHorizontalGroup(
			gl_panel公告.createParallelGroup(Alignment.LEADING)
				.addComponent(textArea公告, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_panel公告.createSequentialGroup()
					.addContainerGap(63, Short.MAX_VALUE)
					.addComponent(btn发布公告, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(255))
		);
		gl_panel公告.setVerticalGroup(
			gl_panel公告.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel公告.createSequentialGroup()
					.addComponent(textArea公告, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn发布公告, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
		);
		panel公告.setLayout(gl_panel公告);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u53D1\u5E03\u5F39\u7A97\u516C\u544A", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 280, 661, 220);
		add(panel);
		
		
		textArea弹窗 = new JTextArea();
		
		btn弹窗 = new JButton("\u53D1\u5E03\u5F39\u7A97\u516C\u544A");
		btn弹窗.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				showWindow();
			}
		});
		
		GroupLayout gl_panel弹窗公告 = new GroupLayout(panel);
		gl_panel弹窗公告.setHorizontalGroup(
				gl_panel弹窗公告.createParallelGroup(Alignment.LEADING)
				.addComponent(textArea弹窗, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_panel弹窗公告.createSequentialGroup()
					.addContainerGap(63, Short.MAX_VALUE)
					.addComponent(btn弹窗, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(255))
		);
		gl_panel弹窗公告.setVerticalGroup(
				gl_panel弹窗公告.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel弹窗公告.createSequentialGroup()
					.addComponent(textArea弹窗, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn弹窗, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel弹窗公告);
		
		add(panel);
	}
	
	/**
	 * 发布聊天室公告
	 */
	public void sendPublicMessage()
	{
		if(sm.btnStart.getText().equals("停止服务器"))
		{
    		if(textArea公告.getText().equals(""))
    			JOptionPane.showMessageDialog(null, "公告内容不能为空！");
    		else
    			qqServer.sendPublicMessage(textArea公告.getText());
		}
		else
		{
			JOptionPane.showMessageDialog(null, "您还未启动服务器，不能发布公告！");
		}
	}
	/**
	 * 弹窗
	 */
	public void showWindow()
	{
		if(sm.btnStart.getText().equals("停止服务器"))
		{
    		if(textArea弹窗.getText().equals(""))
    			JOptionPane.showMessageDialog(null, "弹窗内容不能为空！");
    		else
    			qqServer.sendShowWindow(textArea弹窗.getText());
		}
		else
		{
			JOptionPane.showMessageDialog(null, "您还未启动服务器，不能发布弹窗公告！");
		}}

}
