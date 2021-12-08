package gui.page;

import util.GUIUtil;

public class SpendPage {

	//��������
    public String monthSpend;
    //��������
    public String todaySpend;
    //�վ�����
    public String avgSpendPerDay;
    //����ʣ��
    public String monthAvailable;
    //�վ�����
    public String dayAvgAvailable;
    //������ĩ
    public String monthLeftDay;
    //ʹ�ñ���
    public int usagePercentage;
    //�Ƿ�֧
    public boolean isOverSpend = false;
	
    public SpendPage(double monthSpend, double todaySpend, double avgSpendPerDay, double monthAvailable, double dayAvgAvailable,
            int monthLeftDay, int usagePercentage) {
        this.monthSpend = "��" + GUIUtil.double2(monthSpend);
        this.todaySpend = "��" + GUIUtil.double2(todaySpend);
        this.avgSpendPerDay = "��" + GUIUtil.double2(avgSpendPerDay);
        if(monthAvailable < 0)
            isOverSpend = true;
 
        if(!isOverSpend){
            this.monthAvailable = "��" + GUIUtil.double2(monthAvailable);
            this.dayAvgAvailable = "��" + GUIUtil.double2(dayAvgAvailable);
        }else{
            this.monthAvailable = "��֧" + GUIUtil.double2(0 - monthAvailable);
            this.dayAvgAvailable = "��0";
        }
 
        this.monthLeftDay = monthLeftDay + "��";
        this.usagePercentage = usagePercentage;
    }
}