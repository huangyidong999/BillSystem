package entity;

public class Config {
	//Config�������ڴ��������Ϣ�ģ�key��ʾ�ؼ��֣�value��ʾ��Ӧ��ֵ
	
	public int id;
	public String key;
	public String value;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getKey(){
		return key;
	}
	
	public void setKey(String key){
		this.key = key;
	}
	
	public String getValue(){
		return value;
	}
	
	public void setValue(String value){
		this.value = value;
	}
}