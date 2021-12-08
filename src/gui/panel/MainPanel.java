package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

public class MainPanel extends JPanel{

	static{
		GUIUtil.useLNF();
	}
	
	public static MainPanel instance = new MainPanel();
	
	public JToolBar tb = new JToolBar();
	public JButton bSpend = new JButton();
	public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bDetail = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();
	
	public CenterPanel workingPanel;
	
	private MainPanel(){
		GUIUtil.setImageIcon(bSpend, "home.png", "check cost");
		GUIUtil.setImageIcon(bRecord, "record.png", "Add new cost");
        GUIUtil.setImageIcon(bCategory, "category2.png", "Category");
        GUIUtil.setImageIcon(bDetail, "category1.png", "Detail of cost");
        GUIUtil.setImageIcon(bReport, "report.png", "report of month");
        GUIUtil.setImageIcon(bConfig, "config.png", "configuration");
        GUIUtil.setImageIcon(bBackup, "backup.png", "back up");
        GUIUtil.setImageIcon(bRecover, "restore.png", "renew");
        
        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bDetail);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        tb.setFloatable(false);//½ûÖ¹¹¤¾ßÀ¸ÒÆ¶¯
        
        workingPanel = new CenterPanel(0.8);
        
        setLayout(new BorderLayout());
        add(tb,BorderLayout.NORTH);
        add(workingPanel,BorderLayout.CENTER);
        
        addListener();
	}
	
	public void addListener(){
		ToolBarListener listener = new ToolBarListener();
		
		bSpend.addActionListener(listener);
		bRecord.addActionListener(listener);
        bCategory.addActionListener(listener);
        bDetail.addActionListener(listener);
        bReport.addActionListener(listener);
        bConfig.addActionListener(listener);
        bBackup.addActionListener(listener);
        bRecover.addActionListener(listener);
	}
}