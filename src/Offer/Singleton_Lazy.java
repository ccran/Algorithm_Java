package Offer;

public class Singleton_Lazy {
    private static Singleton_Lazy instance = null;
    private Singleton_Lazy(){}

    public static Singleton_Lazy getInstance(){
        if(instance==null){
            synchronized (Singleton_Lazy.class){
                if(instance==null){
                    instance = new Singleton_Lazy();
                }
            }
        }
        return instance;
    }
}
