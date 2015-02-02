package Chapter4.Exercise1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class MapExample {
	public static void main(String[] args) {
		ComparableHuman taro = new ComparableHuman("taro", 10);
		ComparableHuman jiro = new ComparableHuman("jiro", 20);
		ComparableHuman hanako = new ComparableHuman("hanako", 30);
		
		HashMap<Human, String> hashMap = new HashMap<Human, String>();
		hashMap.put(taro, "千葉県");
		hashMap.put(jiro, "神奈川県");
		hashMap.put(hanako, "東京都");
		
		Set<Entry<Human, String>> s = hashMap.entrySet();
		Iterator<Entry<Human, String>> i = s.iterator();
		while(i.hasNext()){
			Entry<Human, String> e = i.next();
			Human h = e.getKey();
			System.out.println("名前: " + h.getName()
							 + "\t年齢: " + h.getAge()
							 + "\t住所: " + e.getValue());
		}
	}
}

class Human{
	private String name;
	private int age;
	
	public Human(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getAge(){
		return this.age;
	}
}

class ComparableHuman extends Human implements Comparable<Object>{
	public ComparableHuman(String name, int age){
		super(name, age);
	}

	@Override
	public int compareTo(Object o) {
		return getAge() - ((Human)o).getAge();
	}
	
	@Override
	public boolean equals(Object o){
		return getAge() == ((Human)o).getAge();
	}
}