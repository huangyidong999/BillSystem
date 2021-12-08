package util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIUtil {

	private static String imageFolder = "e:/project/hutubill/img";
	
	public static boolean checkEmpty(JPanel p,JTextField tf,String input){
		String text = tf.getText().trim();
		if(text.length() == 0){
			JOptionPane.showMessageDialog(p,input+"����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	
	public static boolean checkNumber(JPanel p,JTextField tf,String input){
		if(!checkEmpty(p,tf,input)){
			return false;
		}
		String text = tf.getText().trim();
		try{
			Integer.parseInt(text);
			return true;
		}catch(NumberFormatException e1){
			JOptionPane.showMessageDialog(p,input+"��Ҫ������");
			tf.grabFocus();
			return false;
		}
	}
	
	public static boolean checkDoubleNumber(JPanel p,JTextField tf,String input){
		if(!checkEmpty(p,tf,input)){
			return false;
		}
		String text = tf.getText().trim();
		try{
			Double.parseDouble(text);
			return true;
		}catch(NumberFormatException e1){
			JOptionPane.showMessageDialog(p,input+"��Ҫ������");
			tf.grabFocus();
			return false;
		}
	}
	
	public static boolean checkZero(JPanel p,JTextField tf,String input){
		if(!checkDoubleNumber(p,tf,input)){
			return false;
		}
		String text = tf.getText().trim();
		if(Double.parseDouble(text) == 0){
			JOptionPane.showMessageDialog(p,input+"����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	
	public static boolean checkEmpty(JDialog d,JTextField tf,String input){
		String text = tf.getText().trim();
		if(text.length() == 0){
			JOptionPane.showMessageDialog(d,input+"����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	
	public static boolean checkNumber(JDialog d,JTextField tf,String input){
		if(!checkEmpty(d,tf,input)){
			return false;
		}
		String text = tf.getText().trim();
		try{
			Integer.parseInt(text);
			return true;
		}catch(NumberFormatException e1){
			JOptionPane.showMessageDialog(d,input+"��Ҫ������");
			tf.grabFocus();
			return false;
		}
	}
	
	public static boolean checkDoubleNumber(JDialog d,JTextField tf,String input){
		if(!checkEmpty(d,tf,input)){
			return false;
		}
		String text = tf.getText().trim();
		try{
			Double.parseDouble(text);
			return true;
		}catch(NumberFormatException e1){
			JOptionPane.showMessageDialog(d,input+"��Ҫ������");
			tf.grabFocus();
			return false;
		}
	}
	
	public static boolean checkZero(JDialog d,JTextField tf,String input){
		if(!checkDoubleNumber(d,tf,input)){
			return false;
		}
		String text = tf.getText().trim();
		if(Double.parseDouble(text) == 0){
			JOptionPane.showMessageDialog(d,input+"����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	
	public static void setColor(Color color,JComponent... cs){//���ÿɱ������Ĳ���
		for(JComponent c : cs){
			c.setForeground(color);
		}
	}
	
	public static void setImageIcon(JButton b,String fileName,String tip){
		ImageIcon i = new ImageIcon(new File(imageFolder,fileName).getAbsolutePath());
		b.setIcon(i);
		b.setPreferredSize(new Dimension(61,81));//�������ȵĴ�С
		b.setToolTipText(tip);//���ð�ť��ͣ����
		b.setVerticalTextPosition(JButton.BOTTOM);//JButton��ͼ�����ı���λ������
		b.setHorizontalTextPosition(JButton.CENTER);//�������JButton��ͼ�����ı����Ϸ�
		b.setText(tip);
	}
	
	public static void useLNF(){
		try{
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * stretch �������
	 */
	public static void showPanel(JPanel p,double stretch){
		GUIUtil.useLNF();
		JFrame f = new JFrame();
		f.setSize(500,500);
		f.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(stretch);
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		cp.show(p);
	}
	
	public static void showPanel(JPanel p){
		showPanel(p,0.85);
	}
	
	//������λС��
	public static double double2(double d){
		DecimalFormat df = new DecimalFormat("#.00");
		return Double.parseDouble(df.format(d));
	}
}
