package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import dao.RecordDAO;
import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;
import service.ReportService;

public class CategoryListener implements ActionListener{
	
	public static Date dateStart;
	public static Date dateEnd;
	
	public void actionPerformed(ActionEvent e) {
		CategoryPanel p = CategoryPanel.instance;
		JButton b = (JButton)e.getSource();
		
		if(b == p.bAdd){
			String name = JOptionPane.showInputDialog(p,"��ӷ���",null);
			if(name == null){
				return;
			}
			if(name.trim().length() == 0){
				JOptionPane.showMessageDialog(p,"�������Ʋ���Ϊ��");
				return;
			}
			new CategoryService().add(name);
			JOptionPane.showMessageDialog(p,"��ӳɹ�");
		}
		
		if(b == p.bDelete){
			Category c = p.getSelectedCategory();
			if(c.recordNumber == 0){
				if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p,"ȷ��Ҫɾ��?")){
					return;
				}
			}
			if(c.recordNumber != 0){
				if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p,"ȷ��Ҫɾ�������༰�䱾�����µ�ȫ�����Ѽ�¼?")){
					return;
				}
				new RecordDAO().deleteRecord(c.id);
			}
			new CategoryService().delete(c.id);
			JOptionPane.showMessageDialog(p,"ɾ���ɹ�");
		}
		
		if(b == p.bEdit){
			Category category = p.getSelectedCategory();
			String name = JOptionPane.showInputDialog(p,"�޸ķ�������",category.name);//��������Ϣ ���������name
			if(name == null){
				return;
			}
			if(name.length() == 0){
				JOptionPane.showMessageDialog(p,"�������Ʋ���Ϊ��");
				return;
			}
			new CategoryService().update(category.id,name);
			JOptionPane.showMessageDialog(p,"�޸ĳɹ�");
		}
		
		if(b == p.bCheck){
			p.bAllbool = false;
			p.bCheckbool = true;
			p.bAll.setSelected(false);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			int year = p.getSelectedYear();
			int month = p.getSelectedMonth();
			int monthDays = new ReportService().getMonthDays(year,month);
			String start = year+"/"+month+"/"+1+" 00:00:00";
			String end = year+"/"+month+"/"+monthDays+" 23:59:59";
			try {
				dateStart = sdf.parse(start);
				dateEnd = sdf.parse(end);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		
		p.update();
	}
}