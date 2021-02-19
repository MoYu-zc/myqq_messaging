package client.frame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import client.frame.MyPanel;
import javax.swing.JLabel;
//import com.sun.awt.AWTUtilities;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame
{

	private JPanel contentPane;
	public JPasswordField pwd密码;
	private JLabel lblQQ2013;

	public JCheckBox checkBox记住密码;
	public JCheckBox checkBox自动登录;
	public JButton lbl登录,关闭;
	public JTextField textField用户名;
	public JLabel lbl注册账号;
	public JLabel lbl忘记密码;
	public JLabel lbl最小化;
	public JLabel lbl退出;

	public JComboBox comboBox状态;
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
					LoginFrame frame = new LoginFrame();
					//AWTUtilities.setWindowOpaque(frame, false);//设置窗体完全透明
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
	public LoginFrame()
	{
		setTitle("即时通讯");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/client/img/QQ_64.png")));
		setUndecorated(true);//设置窗体没有边框
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		
		contentPane = new MyPanel("../img/纯色背景.gif");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pwd密码 = new JPasswordField();

		pwd密码.setEchoChar('●');
		pwd密码.setBounds(140, 165, 180, 30);
		contentPane.add(pwd密码);
		
		lblQQ2013 = new JLabel("即时通讯");
		lblQQ2013.setForeground(new Color(0, 0, 51));
		lblQQ2013.setFont(new Font("宋体", Font.BOLD, 16));
		lblQQ2013.setBounds(14, 6, 80, 20);
		contentPane.add(lblQQ2013);
	
		
		checkBox记住密码 = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
		checkBox记住密码.setBounds(156, 225, 85, 18);
		contentPane.add(checkBox记住密码);
		
		checkBox自动登录 = new JCheckBox("\u81EA\u52A8\u767B\u5F55");
		checkBox自动登录.setBounds(240, 225, 85, 18);
		contentPane.add(checkBox自动登录);
		
		lbl登录 = new JButton("登录");
		lbl登录.setFont(new Font("楷书",Font.BOLD,24));
		lbl登录.setBounds(90, 268, 100, 30);

		lbl登录.setContentAreaFilled(false);
		lbl登录.addActionListener((ActionListener) this);
		contentPane.add(lbl登录);
		
		关闭=new JButton("关闭");
		关闭.setFont(new Font("楷书",Font.BOLD,24));
		关闭.setBounds(250, 268, 100, 30);

		关闭.setContentAreaFilled(false);
		关闭.addActionListener((ActionListener) this);
		contentPane.add(关闭);
		

		
		JLabel te=new JLabel("账号：");
		te.setBounds(70, 110, 80, 25);
		te.setFont(new Font("楷书",Font.BOLD,19));
		contentPane.add(te);
		
		JLabel pa=new JLabel("密码：");
		pa.setBounds(70, 165, 80, 25);
		pa.setFont(new Font("楷书",Font.BOLD,19));
		contentPane.add(pa);
		
		textField用户名 = new JTextField();

		textField用户名.setBounds(140, 110, 180, 30);
		contentPane.add(textField用户名);
		textField用户名.setColumns(10);
		
		lbl注册账号 = new JLabel("\u6CE8\u518C\u8D26\u53F7");
		lbl注册账号.setFont(new Font("楷书", Font.PLAIN, 15));
		lbl注册账号.setForeground(new Color(0, 51, 255));
		lbl注册账号.setBounds(345, 115, 70, 20);
		contentPane.add(lbl注册账号);
		
		lbl忘记密码 = new JLabel("\u5FD8\u8BB0\u5BC6\u7801");
		lbl忘记密码.setFont(new Font("楷书", Font.PLAIN, 15));
		lbl忘记密码.setForeground(new Color(0, 51, 255));
		lbl忘记密码.setBounds(345, 167, 60, 20);
		contentPane.add(lbl忘记密码);
		
		lbl最小化 = new JLabel("");
		lbl最小化.setIcon(new ImageIcon(LoginFrame.class.getResource("/client/img/button/login_minsize_1.png")));
		lbl最小化.setBounds(284, 0, 29, 19);
		contentPane.add(lbl最小化);
		
		lbl退出 = new JLabel("");
		lbl退出.setIcon(new ImageIcon(LoginFrame.class.getResource("/client/img/button/login_exit_1.png")));
		lbl退出.setBounds(410, -1, 37, 20);
		contentPane.add(lbl退出);
	
		
		comboBox状态 = new JComboBox();
		comboBox状态.setBounds(100, 220, 40, 24);
		contentPane.add(comboBox状态);
	}
}
