package Chapter4.Exercise2;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class TreeMapExample {
	public static void main(String[] args) {
		ComparableHuman taro = new ComparableHuman("taro", 80);
		ComparableHuman jiro = new ComparableHuman("jiro", 20);
		ComparableHuman hanako = new ComparableHuman("hanako", 30);
		
		TreeMap<Human, String> treeMap = new TreeMap<Human, String>();
		treeMap.put(taro, "千葉県");
		treeMap.put(jiro, "神奈川県");
		treeMap.put(hanako, "東京都");
		
		Set<Entry<Human, String>> s = treeMap.entrySet();
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
	public int compareTo(Object o){
		return getAge() - ((Human)o).getAge();
	}
	
	@Override
	public boolean equals(Object o){
		return getAge() == ((Human)o).getAge();
	}
}