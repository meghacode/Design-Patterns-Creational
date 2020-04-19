package Singleton;

public class DbSingleton {

    private static DbSingleton instance = new DbSingleton(); //single static instance to be shared by all also egar instance

    private  DbSingleton() {} //private constructor so that people can't create new instances of this class on their own

    public static DbSingleton getInstance() {
        return instance;
    }
}
