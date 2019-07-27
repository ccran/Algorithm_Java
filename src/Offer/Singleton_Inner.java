package Offer;

public class Singleton_Inner {
    private Singleton_Inner(){}
    private Singleton_Inner instance = null;

    public static Singleton_Inner getInstance(){
        return Inner.instance;
    }

    private static class Inner{
        private static final Singleton_Inner instance = new Singleton_Inner();
    }
}
