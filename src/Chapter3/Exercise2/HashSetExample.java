package Chapter3.Exercise2;
import java.util.HashSet;
import java.util.Iterator;

class HashSetExample {
	public static void main(String[] args) {
		ComparableHuman taro = new ComparableHuman("taro", 10);
		ComparableHuman hanako = new ComparableHuman("hanako", 20);
		ComparableHuman jiro = new ComparableHuman("jiro", 80);
		
		HashSet<ComparableHuman> hashSet = new HashSet<ComparableHuman>();
		hashSet.add(taro);
		hashSet.add(hanako);
		hashSet.add(jiro);
		hashSet.add(taro);
		//同じオブジェクトは追加されない。
		Iterator<ComparableHuman> iterator = hashSet.iterator();
		
		while(iterator.hasNext()){
			ComparableHuman human = iterator.next();
			System.out.println("Name: " + human.getName() + "\tAge: " + human.getAge()
					+ "\tHash: " + human.hashCode());
			
			if(taro.equals(human)){
				System.out.println("equals: 同い年です。");
			}
		
			if(taro.compareTo(human)>0){
				System.out.println("compareTo: " + taro.getName() + "のほうが年上です。");
			}else if(taro.compareTo(human) == 0){
				System.out.println("compareTo: 同い年です。");
			}else{
				System.out.println("compareTo: " + human.getName() + "のほうが年上です。");
			}
		}
		
		ComparableHuman taro2 = new ComparableHuman("taro", 10);
		if(taro.equals(taro2)){
			System.out.println("equal");
		}else{
			System.out.println("not equal");
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
		return name;
	}
	
	public int getAge(){
		return age;
	}
}

class ComparableHuman extends Human implements Comparable<Object>{

	public ComparableHuman(String name, int age) {
		super(name, age);
	}

	//独自実装
	//年齢を比較し、その年齢差を返す。
	@Override
	public int compareTo(Object o) {
		return this.getAge() - ((Human)o).getAge();
	}
	
	//独自実装
	//引数に与えられたオブジェクトが等しいかを返す。
	//年齢が等しければTrueとする。
	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(!(o instanceof ComparableHuman)) return false;
		ComparableHuman h = (ComparableHuman)o;
		return this.getAge() == h.getAge();
	}
}





