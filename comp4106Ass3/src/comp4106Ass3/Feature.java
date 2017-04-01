package comp4106Ass3;

import java.util.HashMap;

public class Feature {
	private String name;
	private HashMap<Class,Data> values;
	
	public Feature(String name,Class[] classes){
		values= new HashMap<Class,Data>();
		this.setName(name);
		for(int i=0;i<3;i++){
			Data d=new Data();
			values.put(classes[i], d);
		}
	}

	public Data getData(Class c) {
		return values.get(c);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
