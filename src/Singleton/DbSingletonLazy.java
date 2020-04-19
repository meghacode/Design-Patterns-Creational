package Singleton;

public class DbSingletonLazy {

    private static DbSingletonLazy instance = null;//single static instance to be shared by all also egar instance

    private  DbSingletonLazy() {} //private constructor so that people can't create new instances of this class on their own

    public static DbSingletonLazy getInstance() {
        if (instance == null)
            instance = new DbSingletonLazy();
        return instance;
    }
}
