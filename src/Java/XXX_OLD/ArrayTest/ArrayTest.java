package Java.XXX_OLD.ArrayTest;


/**
 *
 * @author g_sedelnikov
 */
public class ArrayTest {
    
    public static void start(){
        int N = 10000;
        long sTime = System.nanoTime();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
               arr[i][j] = i+ j;
            }
        }
        System.out.println("0 : " + (System.nanoTime() - sTime)/1_000);

        
        sTime = System.nanoTime();
        for (int i = 0; i < N; i++){
            arr[i][i] = i+ i;
            for (int j = 0; j < i; j++){
               arr[i][j] = arr[j][i] = i + j;
            }
        }
        System.out.println("1 : " + (System.nanoTime() - sTime)/1_000);

        sTime = System.nanoTime();
        for (int i = 0; i < N; i++){
            arr[i][i] = i+ i;
            for (int j = 0; j < i; j++){
               arr[j][i] = arr[j][i] = i+ j;
            }
        }
        System.out.println("2 : " + (System.nanoTime() - sTime)/1_000);

//        sTime = System.nanoTime();
//        for (int i = 0; i < N; i++){
//            int q[] = arr[i];
//            int w[] = arr[i];
//            q[i] = i+ i;
//            for (int j = 0; j < i; j++){
//                q[j] = i + i;
//            }
//        }
//        System.out.println("2: " + (System.nanoTime() - sTime)/1_000);
        
        
        int[] arr2 = new int[N*N];
        sTime = System.nanoTime();
        for(int i = 0; i < N; i++) {
          for(int j = 0; j < N; j++) {
            arr2[i*N + j] = i + j; 
          }
        }
        System.out.println("10: " + (System.nanoTime() - sTime)/1_000);


        sTime = System.nanoTime();
        for(int i = 0; i < N; i++) {
            arr2[i*N + i] = i + i;   
            for(int j = 0; j < i; j++) {
                arr2[i*N + j] = arr2[j*N + i] = i + j; 
            }
        }
        System.out.println("11: " + (System.nanoTime() - sTime)/1_000);    
    
        
        sTime = System.nanoTime();
        int odd = (N % 2);
        int l = N - odd;
        for(int i = 0; i < l; ++i) {
          int t0, t1;   
          int a0[] = arr[t0 = i];
          int a1[] = arr[t1 = ++i];
          for(int j = 0; j < N; ++j) {
            a0[j] = t0 + j;
            a1[j] = t1 + j;
          }
        }
        if(odd != 0) {
            int i = N-1;
            int a[] = arr[i];
            for(int j = 0; j < N; ++j) {
                a[j] = i + j;
            }
        }
        System.out.println("99: " + (System.nanoTime() - sTime)/1_000);         
        
    }
    
    
}
