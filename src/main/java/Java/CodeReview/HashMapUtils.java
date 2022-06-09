package Java.CodeReview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapUtils {
    private final static int xx = 1;
	HashMap<Integer, Integer> map;

	public HashMapUtils() {	}

	public HashMapUtils(HashMap map) {
            this.map = map;
	}

	public int sum(){
            Integer sum = 0;
            for(int i = 0; i < this.map.size(); i++)
                sum += this.map.get(i);
            return sum;
	}
	
	public double avarage(){
            return sum()/this.map.size();
	}
	
	private double calc_square(Integer key1, Integer key2) throws Exception{
        int x = this.map.get(key1);

        int y = this.map.get(key2);
        return Math.sqrt(x*x+y*y);
	}

	public void finalize() throws Exception{
            throw new Exception("Error");
	}

	public String removeByValue(Integer value) {
        map.forEach((integer1, integer2) -> {
            if(this.map.get(integer1) == integer2){
                this.map.remove(integer1);
            }
        });

        return null; // TODO Del for review
        }

	@Override
	public String toString() {
        String s = "";
            for(int i = 0; i < this.map.size(); i++){
                s += this.map.get(i).toString() + ", ";
            }
            return "Map [" + s + "]";
       }

    public Integer[] GetAsArray() {
        Object array = new Integer[this.map.size()];

        array = this.map.entrySet().stream().map(i -> i.getValue()).collect(Collectors.toList());
//        return array; // TODO uncomment for review
        return null;  //  TODO Del for review
    }

}