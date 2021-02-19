package server.frame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import server.QQServer;

import client.frame.MyPanel;

import com.MyTools;

import java.util.Calendar;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;


public class ServerMana extends JPanel implements Runnable
{
	QQServer qqServer=null;
	
	
	JButton btnStart;
	JLabel lblTime;
	Calendar calendar=Calendar.getInstance();
	private JLabel currentTime;
	private JLabel label_1;
	private JLabel lblRun;
	private JLabel lblStateShow;
	public JLabel lblState;
	public int allTime=0;
	public long startTime=0;
	public long endTime=0;
	public boolean isRun=false;
	
	
	public ServerMana() 
	{
		setLayout(null);
		
		btnStart = new JButton("\u542F\u52A8\u670D\u52A1\u5668");
		btnStart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				startOrCloseServer();
			}
		});
		btnStart.setFont(new Font("微软雅黑", Font.BOLD, 28));
		btnStart.setBounds(180, 150, 301, 76);
		add(btnStart);
		
		
		lblStateShow = new JLabel("\u5F53\u524D\u670D\u52A1\u5668\u72B6\u6001\uFF1A");
		lblStateShow.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15) );
		lblStateShow.setBounds(200, 260, 130, 15);
		add(lblStateShow);
		
		JLabel label = new JLabel("\u5F53\u524D\u670D\u52A1\u5668\u65F6\u95F4\uFF1A");
		label.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15) );
		label.setBounds(200, 300, 130, 15);
		add(label);
		
		label_1 = new JLabel("\u670D\u52A1\u5668\u8FD0\u884C\u65F6\u95F4\uFF1A");
		label_1.setBounds(200, 340, 130, 15);
		label_1.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15) );
		add(label_1);
		
		lblState = new JLabel("服务器未运行");
		lblState.setBounds(330, 260, 135, 15);
		lblState.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15) );
		add(lblState);
		
		currentTime = new JLabel("");
		currentTime.setBounds(330, 300, 192, 15);
		currentTime.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15) );
		add(currentTime);
		
	
		lblRun = new JLabel("");
		lblRun.setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15) );
		lblRun.setBounds(330, 340, 135, 15);
		add(lblRun);
		
	
		
	
	
		Thread thread=new Thread(this);
		thread.start();
		
	}


	public void run()
	{
		while(true)
		{
			showTime();
			if(isRun)
			{
				endTime=System.currentTimeMillis();
				showRunTime();
			}
			else 
			{
				showRunTime();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void showTime()
	{
		Calendar calendar=Calendar.getInstance();
		String time=calendar.get(Calendar.YEAR)+"年"
				+(calendar.get(Calendar.MONTH)+1)+"月"
				+calendar.get(Calendar.DATE)+"日"
				+" "
				+calendar.get(Calendar.HOUR_OF_DAY)+":"
				+calendar.get(Calendar.MINUTE)+":"
				+calendar.get(Calendar.SECOND);
		currentTime.setText(time);
	}
	public void showRunTime()
	{
		allTime=(int)(endTime-startTime)/1000;
		lblRun.setText(String.valueOf(allTime));
	}
	public void startOrCloseServer()
	{
		if(btnStart.getText().equals("启动服务器"))
		{
			qqServer=new QQServer(MyTools.QQServerPort);
			allTime=0;
			startTime=System.currentTimeMillis();
			isRun=true;
			lblState.setText("服务器正在运行中...");
			btnStart.setText("停止服务器");
		}
		else if(btnStart.getText().equals("停止服务器"))
		{
			if(qqServer!=null)
			{
				qqServer.closeServer();
				isRun=false;
				lblState.setText("服务器已关闭。");
				JOptionPane.showMessageDialog(null,"本次服务器总共运行"+allTime+"秒");
				btnStart.setText("启动服务器");
			}
		}
	}
	
	
}
