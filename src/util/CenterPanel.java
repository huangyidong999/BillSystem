package util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;

import gui.panel.WorkingPanel;

public class CenterPanel extends JPanel{
	
	private double rate;//�������
	private JComponent c;//��ʾ�����
	private boolean stretch;//�Ƿ�����
	
	public CenterPanel(double rate,boolean stretch){
		this.setLayout(null);
		this.rate = rate;
		this.stretch = stretch;
	}
	
	public CenterPanel(double rate){
		this(rate,true);
	}
	
	public void show(JComponent p){
		this.c = p;
		Component[] cs = getComponents();//��ȡPanel�������
		for(Component c : cs){
			remove(c);
		}
		
		add(p);
			
		if(p instanceof WorkingPanel){//����ת�� ��������ָ���������
			((WorkingPanel) p).updateData();//�������෽��
		}
		
		this.updateUI();
	}
	
	public void repaint(){
		if(c != null){
			Dimension containerSize = this.getSize();//JPanel��С
			Dimension componentSize = c.getPreferredSize();//Ĭ�ϴ�С
			if(stretch){
				c.setSize((int)(containerSize.width*rate),(int)(containerSize.height*rate));
			}else{
				c.setSize(componentSize);
			}
			c.setLocation(containerSize.width/2-c.getSize().width/2,containerSize.height/2-c.getSize().height/2);
		}
		super.repaint();//����Ҫ�ػ�ĵط�����Ҫ��
	}	
}
