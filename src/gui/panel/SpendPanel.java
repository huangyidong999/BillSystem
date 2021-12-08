package gui.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.page.SpendPage;
import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class SpendPanel extends WorkingPanel{
	
	static{
		GUIUtil.useLNF();
	}

	public static SpendPanel instance = new SpendPanel();
	
	public JLabel lMonthSpend = new JLabel("Cost of this month");
	public JLabel lTodaySpend = new JLabel("Cost of this day");
	public JLabel lAvgSpendPerDay = new JLabel("daily cost");
	public JLabel lMonthLeft= new JLabel("rest of money in this month");
	public JLabel lDayAvgAvailable = new JLabel("daily budget");
	public JLabel lMonthLeftDay = new JLabel("How long to end this month");
	
	public JLabel vMonthSpend = new JLabel("£¤1000");
	public JLabel vTodaySpend = new JLabel("£¤10");
	public JLabel vAvgSpendPerDay = new JLabel("£¤20");
	public JLabel vMonthAvailable = new JLabel("£¤500");
	public JLabel vDayAvgAvailable = new JLabel("£¤20");
	public JLabel vMonthLeftDay = new JLabel("23");

	CircleProgressBar bar;
	
	private JPanel south(){
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2,4));
		
		p.add(lAvgSpendPerDay);
        p.add(lMonthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMonthAvailable);
        p.add(vDayAvgAvailable);
        p.add(vMonthLeftDay);
		
		return p;
	}
	
	private JPanel center(){
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(west(),BorderLayout.WEST);
		p.add(center2(),BorderLayout.CENTER);
		return p;
	}
	
	private JPanel west(){
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,1));
		
		p.add(lMonthSpend);
        p.add(vMonthSpend);
        p.add(lTodaySpend);
        p.add(vTodaySpend);
		
		return p;
	}
	
	private JComponent center2(){
		return bar;
	}
	
	private SpendPanel(){
		this.setLayout(new BorderLayout());
		bar = new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.blueColor);
		GUIUtil.setColor(ColorUtil.grayColor,lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
                lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
		GUIUtil.setColor(ColorUtil.blueColor,vMonthSpend, vTodaySpend);
		vMonthSpend.setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,23));
		vTodaySpend.setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,23));
		
		this.add(center(),BorderLayout.CENTER);
		this.add(south(),BorderLayout.SOUTH);
	}

	public void updateData() {
		SpendPage spend = new SpendService().getSpendPage();
		vMonthSpend.setText(spend.monthSpend);
		vTodaySpend.setText(spend.todaySpend);
        vAvgSpendPerDay.setText(spend.avgSpendPerDay);
        vMonthAvailable.setText(spend.monthAvailable);
        vDayAvgAvailable.setText(spend.dayAvgAvailable);
        vMonthLeftDay.setText(spend.monthLeftDay);
        
        if(spend.isOverSpend){
        	GUIUtil.setColor(ColorUtil.warningColor,vMonthSpend,vTodaySpend,vMonthAvailable);
        }else{
        	GUIUtil.setColor(ColorUtil.blueColor,vMonthSpend,vTodaySpend);
        	GUIUtil.setColor(ColorUtil.grayColor,vMonthAvailable);
        }
        
        bar.setProgress(spend.usagePercentage);
        bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
	}

	public void addListener(){}
}