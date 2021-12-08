package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

public class ConfigListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		ConfigPanel p = ConfigPanel.instance;
		if(!GUIUtil.checkDoubleNumber(p,p.tfBudget,"����Ԥ��")){
			return;
		}
		String mysqlPath = p.tfMysqlPath.getText();
		if(mysqlPath.length() != 0){// =0��ʱ��???
			File commandFile = new File(mysqlPath,"bin/mysql.exe");
			if(!commandFile.exists()){
				JOptionPane.showMessageDialog(p,"mysql·������ȷ");
				p.tfMysqlPath.grabFocus();
				return;
			}
		}
		
		ConfigService cs = new ConfigService();
		cs.update(ConfigService.budget,p.tfBudget.getText());
		cs.update(ConfigService.mysqlPath,mysqlPath);
		
		JOptionPane.showMessageDialog(p,"�����޸ĳɹ�");
		
		p.updateData();
	}
}