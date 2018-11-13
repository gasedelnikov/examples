package Java.Strings;

import examples.ExampleInterface;

/**
 * Класс примеров работы с HashCode строк
 * 
 * @author GASedelnikov
 */
public class StringWithZeroHashCode implements ExampleInterface{
    private static final int STRING_HASH_CODE_FACTOR = 31;
    
    @Override
    public void start() {
        
        char maxVal = 1908; // 1908
        int hashCode = 1759006336;        
        String xx = getStringByHashCode(hashCode, maxVal);
        
        System.out.println("delta = " + (hashCode - xx.hashCode()));           
    
    }
    
    /**
     * Метод получения массива строк с HashCode равным HashCode исходной строки. 
     * Для пустых строк или одним символом, в начало строки добавляются (char)0.
     * Для строк более чем двумя символами, изменяются проследние два символа в строке
     * , часть строк в результате может быть null.
     * 
     * @param str Исходная строки
     * @param count Кол-во строк в результате.
     * @return
     */
    public String[] getStringWithTheSameHashCode(String str, int count) {
        String[] result = new String[count];
        switch (str.length()){
            case 0: 
            case 1: {
                StringBuilder builder = new StringBuilder();
                builder.append(str);
                for (int i=0; i < count; i++){
                    builder.insert(0,(char)0);
                    result[i] = builder.toString();
                }
                break;
            }
            default: {
                char[] arr = str.toCharArray();
                int i =0;
                while (i < count && arr[arr.length-2] > 0){
                    arr[arr.length-1] += +31;
                    arr[arr.length-2] += -1;
                    result[i] = String.copyValueOf(arr);
                    i++;
                }
                break;
            }
        }
        return result;
    }     
    
    
    /**
     * Метод получения строки с нулевым HashCode на основе заданной строки.
     * Слева к исходной строке добавляется новая строка, таким образом, чтоб у новой строки HashCode = 0
     * 
     * @param str - Исходная строка
     * @return String - Результирующая строка с HashCode = 0
     */
    public String getStringWithZeroHashCode(String str) {
        if (str.hashCode() == 0){
            return str;
        }
        char[] inCA = str.toCharArray();  
        
        int len = 0;
        String xx = "  ";
        char[] newCA = null;
        while ((xx.length() > len)){
            len ++;
            newCA = new char[inCA.length+len];
            System.arraycopy(inCA, 0, newCA, 0, inCA.length);                        
            xx = getStringByHashCode(-String.valueOf(newCA).hashCode());
        }
        System.arraycopy(xx.toCharArray(), 0, newCA, inCA.length + len - xx.length(), xx.length());        
        return String.valueOf(newCA);
    } 

    /**
     * Метод получения строки с нулевым HashCode на основе заданной строки.
     * В результирующей строке все char будут в диапазоне [0, STRING_HASH_CODE_FACTOR]
     * 
     * @param inHashCode - Требуемый hashCode получаемой строки
     * @return Строка с требуемым hashCode 
     */
    public String getStringByHashCode(int inHashCode) {
        return getStringByHashCode(inHashCode, 1);
    }    
    
    /**
     * Метод получения строки с нулевым HashCode на основе заданной строки.
     * В результирующей строке все char будут в диапазоне [0, STRING_HASH_CODE_FACTOR*multipleOfFactor]
     * 
     * @param inHashCode - Требуемый hashCode для получаемой строки
     * @param multipleOfFactor Должен быль в [1, Character.MAX_VALUE/STRING_HASH_CODE_FACTOR]. 
     *        Кратно STRING_HASH_CODE_FACTOR увеличивает максимальное значение char в результирующей строке
     * @return Строка с требуемым hashCode 
     */    
    public String getStringByHashCode(int inHashCode, int multipleOfFactor) {
        if (   multipleOfFactor <= 0 
            || multipleOfFactor > Character.MAX_VALUE / STRING_HASH_CODE_FACTOR ) {
            throw new IllegalArgumentException("multipleOfFactor Должен быть в [1, Character.MAX_VALUE/STRING_HASH_CODE_FACTOR]");
        }        
        if (inHashCode == 0){
            return "";
        }        
        long hash = (inHashCode > 0)? inHashCode : ((long) 2 * Integer.MAX_VALUE + 2 + inHashCode);
        StringBuilder result = new StringBuilder();   
        int factor = STRING_HASH_CODE_FACTOR * multipleOfFactor;
        while (hash > 0){
            char ch = (char)(hash % factor);
            result.insert(0,(char)ch);            
            hash = (long) ((hash - ch) / (STRING_HASH_CODE_FACTOR));
        } 
        return result.toString();
    }   
    
    public String getStringByHashCode_test(int inHashCode, int multipleOfFactor) {
        if (   multipleOfFactor <= 0 
            || multipleOfFactor > Character.MAX_VALUE / STRING_HASH_CODE_FACTOR ) {
            throw new IllegalArgumentException("multipleOfFactor Должен быть в [1, Character.MAX_VALUE/STRING_HASH_CODE_FACTOR]");
        }        
        if (inHashCode == 0){
            return "";
        }        
        long hash = (inHashCode > 0)? inHashCode : ((long) 2 * Integer.MAX_VALUE + 2 + inHashCode);
        StringBuilder result = new StringBuilder();   
        long factor = STRING_HASH_CODE_FACTOR * multipleOfFactor;
        
        long dd = 0;
        long ff = 1; 
        while (hash > 0){
            long ch = hash % factor;
            
            System.out.println(ch); 
        
            result.insert(0,(char)ch);            
            hash = (long)Math.floor((double) (hash - ch) / (STRING_HASH_CODE_FACTOR));
        } 
        
        return result.toString();
    }     
}
