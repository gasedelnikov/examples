package Java.Tasks;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class GetPathTest {
    private static final boolean PRINT_PATH = true; 
    
    @Test    
    public void getPath() {
        GetPath instance = new GetPath();    
        
        boolean[][] maze = new boolean[][]{{true, false, true, true, true}
                                          ,{true, false, true, false, true}
                                          ,{true, false, true, false, true}
                                          ,{true, true, true, false, true}
                                          ,{true, false, false, true, true}};
        
        int [][] paths_steps = new int [][]{{+1,0},{-1,0},{0,+1},{0,-1}};        
        
        HashMap<Point, Integer> cache = new HashMap<>();       
        ArrayList<Point> path = instance.getPath(maze, paths_steps, maze.length-1, maze[0].length-1, 0, cache);        
        
        Point[] expected = new Point[]{   new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0)
                                        , new Point(3, 1), new Point(3, 2), new Point(2, 2), new Point(1, 2)
                                        , new Point(0, 2), new Point(0, 3), new Point(0, 4)
                                        , new Point(1, 4), new Point(2, 4), new Point(3, 4), new Point(4, 4)};
        
        boolean rezult = Arrays.equals(path.toArray(), expected); 
        assertEquals(true, rezult);     
        
        if (PRINT_PATH){
            instance.printPath(maze, path);
        }
    }
    
}
