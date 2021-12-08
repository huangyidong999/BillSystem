package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Category;
import gui.dialog.AddDialog;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import service.RecordService;
import util.GUIUtil;

public class AddListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		AddDialog d = AddDialog.instance;
		if(d.cbModel.cs.size() == 0){
			JOptionPane.showMessageDialog(d,"�������ѷ���  �޷����  �����������ѷ���");
			MainPanel.instance.workingPanel.show(CategoryPanel.instance);
			return;
		}
		if(!GUIUtil.checkZero(d,d.tfSpend,"���ѽ��")){
			return;
		}
		double spend = Double.parseDouble(d.tfSpend.getText());
		Category c = d.getSelectedCategory();
		String comment = d.tfComment.getText();
		Date date = d.datepick.getDate();
		
		new RecordService().add(spend,c,comment,date);
		
		JOptionPane.showMessageDialog(d,"��ӳɹ�");
		d.setVisible(false);
	}

}
