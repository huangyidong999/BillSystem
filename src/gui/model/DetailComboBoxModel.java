package gui.model;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entity.Category;
import service.DetailService;

public class DetailComboBoxModel implements ComboBoxModel<Category>{

	public List<Category> cs = new DetailService().listCategory();//�����Ѵ�������������ķ���
	
	Category c;
	
	public DetailComboBoxModel() {
		if(!cs.isEmpty()) {
			c = cs.get(0);
		}
	}
	
	public int getSize() {
		return cs.size();
	}

	public Category getElementAt(int index) {
		return cs.get(index);
	}

	public void addListDataListener(ListDataListener l) {}

	public void removeListDataListener(ListDataListener l) {}

	public void setSelectedItem(Object anItem) {
		c = (Category)anItem;
	}

	public Object getSelectedItem() {
		if(!cs.isEmpty()) {
			return c;
		} else {
			return null;
		}
	}
}