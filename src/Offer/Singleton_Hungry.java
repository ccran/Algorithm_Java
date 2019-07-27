package Offer;

// 饿汉式
public class Singleton_Hungry{
    private static Singleton_Hungry singleton = new Singleton_Hungry();
    private Singleton_Hungry(){}
    public static Singleton_Hungry getInstance(){
        return singleton;
    }

    public void method(){
        System.out.println("method!!!!");
    }
}
