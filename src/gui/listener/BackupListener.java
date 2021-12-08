package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;

public class BackupListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		BackupPanel p = BackupPanel.instance;
		ConfigService cs = new ConfigService();
		String mysqlPath = cs.get(ConfigService.mysqlPath);
		if(mysqlPath.length() == 0){
			JOptionPane.showMessageDialog(p,"����ǰ����������mysql��·��");
			MainPanel.instance.workingPanel.show(ConfigPanel.instance);
			ConfigPanel.instance.tfMysqlPath.grabFocus();
			return;
		}

		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(new File("hutubill.sql"));
		
		fc.setFileFilter(new FileFilter() {
			
			public String getDescription() {
				return ".sql";
			}
			
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".sql");//?
			}
		});
		
		int returnVal = fc.showSaveDialog(p);
		File file = fc.getSelectedFile();
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			if(!file.getName().toLowerCase().endsWith(".sql")) {
				file = new File(file.getParent(),file.getName()+".sql");
//				JOptionPane.showMessageDialog(p,"�ļ���ʽ����ȷ");
//				return;
			}
			try{
				MysqlUtil.backup(mysqlPath,file.getAbsolutePath());
				JOptionPane.showMessageDialog(p,"���ݳɹ� �����ļ�λ�ڣ�\r\n"+file.getAbsolutePath());
			}catch(IOException e1){
				e1.printStackTrace();
				JOptionPane.showMessageDialog(p,"����ʧ��\r\n����\r\n"+e1.getMessage());
			}
		}
	}
}