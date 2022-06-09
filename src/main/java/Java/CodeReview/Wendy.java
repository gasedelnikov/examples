package Java.CodeReview;

import java.util.ArrayList;

public class Wendy {
	ArrayList<Integer> list;
	
	public Wendy() {	}

	public Wendy(ArrayList list) {
            this.list = list;
	}

	public int sum(){
            Integer sum = 0;
            for(int i = 0; i < this.list.size(); i++)
                sum += this.list.get(i);
            return sum;
	}
	
	public double avarage(){
            return sum()/this.list.size();
	}
	
	private double calc(int index1, int index2) throws Exception{
            int x = this.list.get(index1);
            int y = this.list.get(index2);
            return Math.sqrt(x*x+y*y);
	}

	public void finalize() throws Exception{
            throw new Exception("Error");
	}

	public String removeByValue(Integer value) {
            for(int i=this.list.size()-1; i>=0; i--){
                if(this.list.get(i) == value){
                    this.list.remove(i);
                    break;
                }
            }
        return null; // TODO Del for review
        }

	@Override
	public String toString() {
            String strList = "";
            for(int i = 0; i < this.list.size(); i++){
                strList += this.list.get(i).toString() + ", ";
            }
            return "Bob [list=" + strList + "]";
       }
}