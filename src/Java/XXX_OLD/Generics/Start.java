package Java.XXX_OLD.Generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g_sedelnikov
 */
public class Start {
    public static <T> void fill1(List<T> list, T val) { 
        for (int i = 0; i < list.size(); i++) 
            list.set(i, val); 
    }     
    
    public static void start(){
       ClassA A = new ClassA(1);
       ClassB B = new ClassB(2);
       ClassC C = new ClassC(3);
       
       Generics <ClassA> G1 = new Generics<>(); G1.set(A); G1.set(B); G1.set(C);
       ClassA A11 = G1.getVal();
       System.out.println(A11.getA());
       
       Generics <ClassB> G2 = new Generics<>(); G2.set(B);
       Generics <ClassC> G3 = new Generics<>(); G3.set(C);
       Generics <ClassC> G4 = new Generics<>();//       G4.set(A); //incompatible types: ClassA cannot be converted to ClassC
//       Generics <ClassA> G5 = new Generics<ClassC>(); //incompatible types: Generics<ClassC> cannot be converted to Generics<ClassA>
//       Generics <ClassA> G5 = new Generics<ClassB>(); //incompatible types

       Generics <? extends ClassA> T1 = new Generics<>();
//       T1.set(A); error

       Generics <? super ClassA> G6 = new Generics<>();
       G6.set(A); System.out.println(G6.getVal());
       G6.set(B); System.out.println(G6.getVal());
       G6.set(C); System.out.println(G6.getVal());

       Generics <ClassA> G7 = new Generics<>(); G7.set(A); G7.set(B); G7.set(C); 
       Generics <ClassB> G8 = new Generics<>(); G8.set(B); G8.set(C); 
       Generics <ClassC> G9 = new Generics<>(); G9.set(C); 
       Generics <Object> G10 = new Generics<>();  

       add_extends(G7);
       add_extends(G8);
       add_extends(G9);

       add_super(G7);
       add_super(G8);
       add_super(G9);     
       add_super(G10);     
       
       metod(A);
       metod(G8);
       metod(11);

       metod_extends(A);
       metod_extends(B);
       metod_extends(C);

       metod_extends2(A);
       metod_extends2(B);
       metod_extends2(C);       
    }
    
    private static void add_extends(Generics <? extends ClassA> gen){
        System.out.println(" add_extends " + gen.getVal());
    }

    private static void add_super(Generics <? super ClassC> gen){
        System.out.println(" add_super " + gen.getVal());
    }    

    public static <T> void metod(T var) { 
        
    }  
    
    public static <T extends ClassA> void metod_extends(T var) { 
        
    }     

    public static void metod_extends2(ClassA var) { 
        
    }    
    
    
}

