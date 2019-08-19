package Java.Tasks;

import examples.ExampleInterface;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Нахождение пути в массиве с препятствиями
 * @author GASedelnikov
 */
public class GetPath implements ExampleInterface{
    
    @Override
    public void start() {


       
    }
    
    public void printPath (boolean[][] maze, ArrayList<Point> path){    
        for (int i=0; i< maze.length; i++){
            for (int j=0; j< maze[0].length; j++){ 
                int st = 0;
                for (int k=0; k < path.size(); k++){ 
                    if (path.get(k).equals(new Point(i, j))){
                        st = path.size() - k;
                    }
                }                
                System.out.printf("%3d", st);                        
            }
            System.out.println();  
        }         
    }
    
    public ArrayList<Point> getPath(boolean[][] maze, int [][] paths_steps, int row, int col, int lev, HashMap<Point, Integer> cache){
        lev++;
        ArrayList<Point> result = null;        
        Point point = new Point(row, col);
        Integer cache_lev = (cache.get(point));
        
        if (   row >= 0 
            && row < maze.length 
            && col >= 0 
            && col < maze[0].length 
            && maze[row][col] 
            && (   cache_lev == null
                || cache_lev > lev))
        {
            cache.put(point, lev);
                
            if (row == 0 && col == 0){
                result = new ArrayList<>();                 
            }
            else {
                int levMin = Integer.MAX_VALUE;
                for (int[] paths_step : paths_steps) {
                    ArrayList<Point> tmp_path = getPath(maze, paths_steps, row + paths_step[0], col + paths_step[1], lev, cache);                       
                    if (tmp_path != null && tmp_path.size() < levMin){
                        result = tmp_path;
                        levMin = result.size();
                    }               
                }
            } 
        }
        if (result != null ){
            result.add(point); 
//            System.out.println(result.toString());                      
        }
        return result;        
    }    
}