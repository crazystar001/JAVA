/*Copyright © 2018 XingZixin*/
/*
 * 注：原本想使用javafx界面可以使页面更加美观一点，但是环境始终无法配置成功，只能使用swing
 * 在查找时设立数组，结果正确数组值变1*/
package a;
/*-------------------------------------import package------------------------------------------------------*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;

public class chess 
{
	
  //变量声明
	private JFrame frame;    //声明swing框架
	private boolean First_men = true;             
	JButton button_num_1,button_num_2,button_num_3;   //声明棋盘按钮
	JButton button_num_4,button_num_5,button_num_6,button_num_7,button_num_8,button_num_9;
	JLabel label;
	private static String[] chessBoard;   //棋盘
	private static String j[],y[];
	private static int p,q;
	private JButton button_restart;
		
	/*--------------------------------------------------------------------------------主函数---------------------------------------------------------------------------------------------------------------------*/
	public static void main(String[] args) 
	{
		//建立棋盘
		chessBoard = new String[8];
		//横
		chessBoard[0] = "1,2,3";
		chessBoard[1] = "4,5,6";
		chessBoard[2] = "7,8,9";
		//竖
		chessBoard[3] = "1,4,7";
		chessBoard[4] = "2,5,8";
		chessBoard[5] = "3,6,9";
		//斜
		chessBoard[6] = "1,5,9";
		chessBoard[7] = "3,5,7";
		j = new String[5];
		for(int i = 0;i < j.length;i++)
			j[i] = "First_men";
		y = new String[5];
		for(int i = 0;i < y.length;i++)
			y[i] = "Second_men";
		p=0;q=0;
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					chess window = new chess();
					window.frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		}
		);
	}
	/*-----------------------------------------------排序------------------------------------------------*/
	public void sortS(String a[])
	{
		int a1[] = new int[a.length];
		for(int i = 0;i < a.length;i++)//赋值
			a1[i] = Integer.parseInt(a[i]);
		for(int i = 0;i < a1.length -1;i++)//排序
			for(int j = i+1;j < a1.length;j++)
			{
				if(a1[i] >a1[j])
				{
					int temp = a1[i];
					a1[i] = a1[j];
					a1[j] = temp;
				}
			}
		for(int i = 0;i < a1.length;i++)//排序完后继续赋值
			a[i] = String.valueOf(a1[i]);
	}
	/*------------------------------判断哪方赢得比赛---------------------------------------------------------*/
 public boolean win(String t[],String a[],String First_men)
	{
	
		int tn[] = new int[t.length];
		int index = 0;
		for(int i = 0;i < a.length;i++)
		{
			for(int j = 0;j < t.length;j++)
			{
				if((index = t[j].indexOf(a[i])) != -1)
				{//说明该点在该方法中存在
					tn[j] += 1;//该方法次数出现+1
				}
			}
		}
		for(int i = 0;i < tn.length;i++)
		{
			if(tn[i] == 3)
			{
				JOptionPane.showConfirmDialog(frame, First_men+"赢了", "恭喜"+First_men,  
	                    JOptionPane.OK_OPTION);  
				return true;
			}	
		}
		
		return false;
	}
	/*--------------------------------------------------------------------------------------------创建应用程序----------------------------------------------------------------------------------*/
	public chess() 
	{

		frame = new JFrame();
		frame.setTitle("AI home work for chess");
		frame.setBounds(100, 100, 548, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(48, 44, 435, 374);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		/*-------------------------------定义棋盘按钮1-9---------------------------------------*/
		 button_num_1= new JButton("1");
		 button_num_1.setBackground(Color.blue);
		 /*监听器*/
		button_num_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if(First_men)
				{
					button_num_1.setBackground(new Color(248,248,255));
					j[p++]="1";
					win(chessBoard,j,"甲");
				}				
				else
				{
					button_num_1.setBackground(new Color(0,0,0));
					y[q++]="1";
					win(chessBoard,y,"乙");
				}
					
				button_num_1.setEnabled(false);
			}
		});
		button_num_1.setBounds(0, 0, 144, 123);
		panel.add(button_num_1);
	/*-----------------------------------------2-----------------------------------------------*/	
		 button_num_2 = new JButton("2");
		 button_num_2.setBackground(Color.blue);
		button_num_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if(First_men)
				{
					button_num_2.setBackground(new Color(248,248,255));
					j[p++]="2";
					win(chessBoard,j,"甲");
				}
				else
				{
					button_num_2.setBackground(new Color(0,0,0));
					y[q++]="2`";
					win(chessBoard,y,"乙");
				}
				button_num_2.setEnabled(false);
			}
		});
		button_num_2.setBounds(143, 0, 138, 123);
		panel.add(button_num_2);
		/*----------------------------------------3------------------------------------------------*/		
		 button_num_2 = new JButton("3");
		 button_num_2.setBackground(Color.blue);
		button_num_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(First_men)
				{
					button_num_2.setBackground(new Color(248,248,255));
					j[p++]="3";
					win(chessBoard,j,"甲");
				}
				else
				{
					button_num_2.setBackground(new Color(0,0,0));
					y[q++]="3";
					win(chessBoard,y,"乙");
				}
				button_num_2.setEnabled(false);
			}
		});
		button_num_2.setBounds(281, 0, 138, 123);
		panel.add(button_num_2);
		/*----------------------------------------4------------------------------------------------*/	
		button_num_4= new JButton("4");
		 button_num_4.setBackground(Color.blue);
		button_num_4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(First_men)
				{
					button_num_4.setBackground(new Color(248,248,255));
					j[p++]="4";
					win(chessBoard,j,"甲");
				}
				else
				{
					button_num_4.setBackground(new Color(0,0,0));
					y[q++]="4";
					win(chessBoard,y,"乙");
				}
				button_num_4.setEnabled(false);
			}
		});
		button_num_4.setBounds(0, 120, 144, 123);
		panel.add(button_num_4);
		/*---------------------------------------5-------------------------------------------------*/	
		 button_num_5 = new JButton("5");
		 button_num_5.setBackground(Color.blue);
		button_num_5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(First_men)
				{
					button_num_5.setBackground(new Color(248,248,255));
					j[p++]="5";
					win(chessBoard,j,"甲");
				}	
				else
				{
					button_num_5.setBackground(new Color(0,0,0));
					y[q++]="5";
					win(chessBoard,y,"乙");
				}
				button_num_5.setEnabled(false);
			}
		});
		button_num_5.setBounds(143, 120, 138, 123);
		panel.add(button_num_5);
		/*----------------------------------------6------------------------------------------------*/	
		 button_num_6 = new JButton("6");
		 button_num_6.setBackground(Color.blue);
		button_num_6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(First_men)
				{
					button_num_6.setBackground(new Color(248,248,255));
					j[p++]="6";
					win(chessBoard,j,"甲");
				}	
				else
				{
					button_num_6.setBackground(new Color(0,0,0));
					y[q++]="6";
					win(chessBoard,y,"乙");
				}
				button_num_6.setEnabled(false);
			}
		});
		button_num_6.setBounds(281, 120, 138, 123);
		panel.add(button_num_6);
		/*------------------------------------------7---------------------------------------------*/	
		 button_num_7 = new JButton("7");
		 button_num_7.setBackground(Color.blue);
		button_num_7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(First_men)
				{
					button_num_7.setBackground(new Color(248,248,255));
					j[p++]="7";
					win(chessBoard,j,"甲");
				}
				else
				{
					button_num_7.setBackground(new Color(0,0,0));
					y[q++]="7";
					win(chessBoard,y,"乙");
				}
				button_num_7.setEnabled(false);
			}
		});
		button_num_7.setBounds(0, 241, 144, 123);
		panel.add(button_num_7);
		/*---------------------------------------8-------------------------------------------------*/		
		 button_num_8 = new JButton("8");
		 button_num_8.setBackground(Color.blue);
		button_num_8.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(First_men)
				{
					button_num_8.setBackground(new Color(248,248,255));
					j[p++]="8";
					win(chessBoard,j,"甲");
				}
				else
				{
					button_num_8.setBackground(new Color(0,0,0));
					y[q++]="8";
					win(chessBoard,y,"乙");
				}
				button_num_8.setEnabled(false);
			}
		});
		button_num_8.setBounds(143, 241, 138, 123);
		panel.add(button_num_8);
		/*----------------------------------------------------------------------------------------*/		
		 button_num_9 = new JButton("9");
		 button_num_9.setBackground(Color.blue);
		button_num_9.addActionListener(new ActionListener()
		{
			//甲点击后变成白色，乙变成黑色r
			public void actionPerformed(ActionEvent e) 
			{
				if(First_men)
				{
					button_num_9.setBackground(new Color(248,248,255));
					j[p++]="9";
					win(chessBoard,j,"甲");
				}
				else
				{
					button_num_9.setBackground(new Color(0,0,0));
					y[q++]="9";
					win(chessBoard,y,"乙");
				}
				button_num_9.setEnabled(false);
			}
		});
		button_num_9.setBounds(281, 241, 138, 123);
		panel.add(button_num_9);
		/*-----------------------------------------------------------定义悔棋按钮------------------------------------------------------------*/
		JButton button_redo = new JButton("悔棋");
		button_redo.setBounds(50, 438, 113, 27);
		frame.getContentPane().add(button_redo);
		/*------------------------------------------------------------定义重新开始按钮------------------------------------------------------*/
		button_restart = new JButton("Restart");
		button_restart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				button_num_1.setEnabled(true);
				button_num_2.setEnabled(true);
				button_num_2.setEnabled(true);
				button_num_4.setEnabled(true);
				button_num_5.setEnabled(true);
				button_num_6.setEnabled(true);
				button_num_7.setEnabled(true);
				button_num_8.setEnabled(true);
				button_num_9.setEnabled(true);
				button_num_1.setBackground(Color.blue);
				button_num_2.setBackground(Color.blue);
				button_num_2.setBackground(Color.blue);
				button_num_4.setBackground(Color.blue);
				button_num_5.setBackground(Color.blue);
				button_num_6.setBackground(Color.blue);
				button_num_7.setBackground(Color.blue);
				button_num_8.setBackground(Color.blue);
				button_num_9.setBackground(Color.blue);
				//恢复默认值
				j = new String[5];
				for(int i = 0;i < j.length;i++)
					j[i] = "First_men";
				y = new String[5];
				for(int i = 0;i < y.length;i++)
					y[i] = "Second_men";
				p=0;q=0;
			}
		});
		button_restart.setBounds(50, 10, 113, 27);
		frame.getContentPane().add(button_restart);
		
		/*--------------------------------------------------------------定义交换按钮------------------------------------------------*/
		JButton button_exchange = new JButton("交换双方");
		button_exchange.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if(First_men)
				{
					First_men = false;
					label.setText("当前棋手：乙");
					return;
				}
				else
				{
					First_men = true;
					label.setText("当前棋手：甲");
					return;
				}
				
			}
		});
		button_exchange.setBounds(200, 438, 113, 27);
		frame.getContentPane().add(button_exchange);
		
		/*显示当前操作者身份*/
		label = new JLabel("当前棋手：甲");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(309, 431, 174, 29);
		frame.getContentPane().add(label);
		
		
	}

}