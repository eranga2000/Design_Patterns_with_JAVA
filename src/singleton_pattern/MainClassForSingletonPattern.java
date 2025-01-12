package singleton_pattern;

public class MainClassForSingletonPattern {
    public static void main(String[] args) {
        SingletonClass hi= SingletonClass.getSingleObj("db");
        SingletonClass hi2= SingletonClass.getSingleObj("45646");
        if(hi==hi2){
            System.out.println("same");
        }
    }
}