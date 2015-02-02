package Chapter1;
import java.util.Vector;
 
public class NumberList {
 
    public static void main(String args[]) {
    	int num = 10;
    	Vector<String> vector = new Vector<String>();
    	
    	for(int i=0;i<num;i++){
    		vector.add(new Integer(i).toString());
    	}
    	
    	for(int i=0;i<num;i++){
    		String text = vector.get(i);
    		System.out.println(text);
    	}
    }
}