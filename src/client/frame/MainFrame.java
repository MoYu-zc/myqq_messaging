﻿package client.frame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import client.control.Login;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author LXA
 *
 */
public class MainFrame extends JFrame
{
	public JLabel lbl设置;
	public JLabel lbl头像;
	public JComboBox comboBox状态;
	public JLabel lbl用户名;
	public JLabel lbl个性签名;
	public JTree tree;
	private JTabbedPane tabbedPane;
	private JPanel panel好友列表;
	private JPanel panel群;
	private JPanel panel最近;
	private JScrollPane scrollPane好友;
	private JPanel panel用户信息;
	private JPanel panel好友面板;
	private JPanel panel设置面板;
	private JPopupMenu popupMenu好友列表;
	private JMenuItem menuItem发送即时消息;
	private JMenuItem menuItem查看好友信息;
	private JMenuItem menuItem发送文件;
	private JMenuItem menuItem删除用户;
	private JButton jbu;
	private JLabel jl;
	private ImageIcon icon;


	/**
	 * Create the frame.
	 */
	

	public MainFrame()
	{
		//setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/client/img/QQ_64.png")));
		setTitle("即时通讯");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 1000);
		
		panel用户信息 = new JPanel();
		
		
		panel好友面板 = new JPanel();
		
		panel设置面板 = new JPanel();
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel用户信息, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
				.addComponent(panel设置面板, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
				.addComponent(panel好友面板, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel用户信息, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel好友面板, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel设置面板, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
		);
		panel好友面板.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel好友面板.add(tabbedPane, BorderLayout.CENTER);
		
		panel好友列表 = new JPanel();
		tabbedPane.addTab("  \u597D\u53CB  ", null, panel好友列表, null);
		panel好友列表.setLayout(new BorderLayout(0, 0));
		
		scrollPane好友 = new JScrollPane();
		panel好友列表.add(scrollPane好友);
		
		tree = new JTree();
		scrollPane好友.setViewportView(tree);
		
		popupMenu好友列表 = new JPopupMenu();
		addPopup(tree, popupMenu好友列表);
		
		menuItem发送即时消息 = new JMenuItem("\u53D1\u9001\u5373\u65F6\u6D88\u606F");
		menuItem发送即时消息.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				startChat(e);
			}
		});
		//menuItem发送即时消息.setIcon(new ImageIcon(MainFrame.class.getResource("/client/img/QQ_16.png")));
		popupMenu好友列表.add(menuItem发送即时消息);
		
		menuItem发送文件 = new JMenuItem("\u53D1\u9001\u6587\u4EF6");
		menuItem发送文件.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				sendFile(e);
			}
		});
		popupMenu好友列表.add(menuItem发送文件);
		
		
		menuItem删除用户 = new JMenuItem("\u5220\u9664\u7528\u6237");
		menuItem删除用户.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				deleteFriend(e);
			}
		});
		popupMenu好友列表.add(menuItem删除用户);

		panel群 = new JPanel();
		tabbedPane.addTab("  \u7FA4\u7EC4  ", null, panel群, null);
		
		JButton btn聊天室 = new JButton("进入聊天室");
		btn聊天室.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				gotoChatRoom();
			}
		});
		btn聊天室.setFont(new Font("微软雅黑", Font.PLAIN, 28));
		
		JButton btn新建聊天室 = new JButton("\u65B0\u5EFA\u804A\u5929\u5BA4");
		btn新建聊天室.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				buildNewChatRoom();
			}
		});
		btn新建聊天室.setFont(new Font("微软雅黑", Font.PLAIN, 28));
		GroupLayout gl_panel群 = new GroupLayout(panel群);
		gl_panel群.setHorizontalGroup(
			gl_panel群.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel群.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel群.createParallelGroup(Alignment.TRAILING)
						.addComponent(btn新建聊天室, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
						.addComponent(btn聊天室, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel群.setVerticalGroup(
			gl_panel群.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel群.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn聊天室, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn新建聊天室, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(132, Short.MAX_VALUE))
		);
		panel群.setLayout(gl_panel群);
		
		panel最近 = new JPanel();
		tabbedPane.addTab("  空间  ",null, panel最近, null);
		tabbedPane.setFont(new Font("宋体",Font.BOLD,22));
		
		JButton btn= new JButton("进入空间");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				try {
					browse2("https://qzone.qq.com/");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn.setFont(new Font("微软雅黑", Font.PLAIN, 28));
		
		GroupLayout gl_panel空 = new GroupLayout(panel最近);
		gl_panel空.setHorizontalGroup(
				gl_panel空.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel空.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel空.createParallelGroup(Alignment.TRAILING)
						.addComponent(btn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
							)
					.addContainerGap())
		);
		gl_panel空.setVerticalGroup(
				gl_panel空.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel空.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(132, Short.MAX_VALUE))
		);
		panel最近.setLayout(gl_panel空);
		
		panel设置面板.setLayout(null);
		lbl设置 = new JLabel("");
		lbl设置.setIcon(new ImageIcon(MainFrame.class.getResource("/client/img/button/QQ_settings_1.png")));
		lbl设置.setBounds(130,3, 100, 64);
		lbl设置.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				// 处理鼠标点击
			}
			public void mouseEntered(MouseEvent e) {
				// 处理鼠标移入
			}
			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}
			public void mousePressed(MouseEvent e) {
				// 处理鼠标按下
			}
			public void mouseReleased(MouseEvent e) {
			/**
			 * 
			 * 等待添加
			 */
				// 处理鼠标释放
			}
		});
		panel设置面板.add(lbl设置);
		panel用户信息.setLayout(null);
		
		lbl头像 = new JLabel("");
		lbl头像.setIcon(new ImageIcon(MainFrame.class.getResource("/client/img/headImage/head_boy_01_64.jpg")));
		lbl头像.setBounds(130, 7, 64, 64);
		panel用户信息.add(lbl头像);
		
		comboBox状态 = new JComboBox();
		comboBox状态.setBounds(135, 103, 58, 28);
		panel用户信息.add(comboBox状态);
		
		lbl用户名 = new JLabel("\u9A6C\u5316\u817E");
		lbl用户名.setFont(new Font("黑体", Font.BOLD, 18));
		lbl用户名.setBounds(155, 80, 90, 25);
		panel用户信息.add(lbl用户名);
		
		lbl个性签名 = new JLabel("\u5404\u4F4D\u817E\u8BAF\u7F51\u53CB\u597D\uFF0CQQ2013\u5373\u5C06\u516C\u6D4B\u4E86");
		lbl个性签名.setBounds(10, 135, 210, 20);
		lbl个性签名.setFont(new Font("宋体",Font.BOLD,15));
		panel用户信息.add(lbl个性签名);
		getContentPane().setLayout(groupLayout);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private static void browse2(String url) throws Exception {
        Desktop desktop = Desktop.getDesktop();
        if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
            URI uri = new URI(url);
            desktop.browse(uri);
        }
    }


	
	/**
	 * 开始聊天
	 */
	public void startChat(ActionEvent e)
	{
	}
	/**
	 * 获取好友资料
	 * @param e
	 */
	public void getFriendInfo(ActionEvent e)
	{
		
	}
	/**
	 * 发送文件
	 * @param e
	 */
	public void sendFile(ActionEvent e)
	{
		
	}
	/**
	 * 删除好友
	 * @param e
	 */
	public void deleteFriend(ActionEvent e)
	{
		
	}
	/**
	 * 进入聊天室
	 */
	public void gotoChatRoom()
	{}
	
	/**
	 * 新建聊天室
	 */
	public void buildNewChatRoom()
	{
		
	}
}
/*TreePath path =tree.getSelectionPath();
if (path.getPathCount()>1) //选择的不是根节点
{ 
	System.out.println(path);
	DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();  
	DefaultTreeModel treeModel= (DefaultTreeModel) tree.getModel();
	treeModel.removeNodeFromParent(node);
} */ 