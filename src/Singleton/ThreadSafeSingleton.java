package Singleton;

public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton instance = null;//single static instance to be shared by all also volatile

    private  ThreadSafeSingleton() {

        if(instance!=null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    } //private constructor so that people can't create new instances of this class on their own and also protection from reflection

    public static ThreadSafeSingleton getInstance() { // making whole method synchronized has performance issues read below
        if (instance == null)
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null)
                    instance = new ThreadSafeSingleton();
            }

        return instance;
    }
}


//A synchronized method locks on the object instance the method is contained in while a synchronized
// block can lock on ANY object. For synchronized methods, the lock will be held throughout the method
// scope, while in the synchronized block, the lock is held only during that block scope also known as critical section.

//Java Reflection is the process of analyzing and modifying all the capabilities of a class at runtime.
// Reflection API in Java is used to manipulate class and its members which include fields, methods,
// constructor, etc. at runtime.
