package singleton_pattern;

public class SingletonClass {
    private static SingletonClass singleObj;
    private String objName;
    private SingletonClass(String objName){
        this.objName=objName;

    }

    public static SingletonClass getSingleObj (String objName){
        if(singleObj==null) {
           singleObj= new SingletonClass(objName);
        }
        System.out.println(objName);
        return singleObj;
    }
}
