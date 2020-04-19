import Builder.LunchOrder;
import Prototype.Movie;
import Prototype.Record;
import Prototype.Registery;
import Prototype.Statement;
import Singleton.DbSingleton;
import Singleton.DbSingletonLazy;
import Singleton.ThreadSafeSingleton;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //If u get instance of java runtime u will know that it's a singleton object

        Runtime singletonRuntime =Runtime.getRuntime();
        singletonRuntime.gc();
        //Runtime. gc() method runs the garbage collector. Calling this method suggests that the
        //Java virtual machine expend effort toward recycling unused objects in order to make the
        //memory they currently occupy available for quick reuse.

        System.out.println(singletonRuntime);

        Runtime anotherSingletonRuntime = Runtime.getRuntime();
        System.out.println(anotherSingletonRuntime);

        if(singletonRuntime == anotherSingletonRuntime) {
            System.out.println("Both instances are same");
        }


        // Call DbSingleton Class To Create Singleton Object

        DbSingleton dbSingleton = DbSingleton.getInstance();
        DbSingleton dbSingleton1 = DbSingleton.getInstance();
        System.out.println(dbSingleton1);
        System.out.println(dbSingleton);



        // Lazy loading
        DbSingletonLazy dbSingletonLazy = DbSingletonLazy.getInstance();
        DbSingletonLazy dbSingletonLazy1 = DbSingletonLazy.getInstance();
        System.out.println(dbSingletonLazy);
        System.out.println(dbSingletonLazy1);

        //Thread safe singleton
        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton threadSafeSingleton1 = ThreadSafeSingleton.getInstance();
        System.out.println(threadSafeSingleton);
        System.out.println(threadSafeSingleton1);

        //Builder Example

        LunchOrder.Builder builder = new LunchOrder.Builder();
        builder.bread("Wheat").meat("Chicken").dressing("salad").condiments("lettuce");

        LunchOrder lunchOrder = builder.build();

        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getMeat());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());

        //exaple with colne (Shallow copy i.e references remain same) change in one reflects in both

        List<String> params = new ArrayList<>();
        params.add("star wars");

        Statement firstStatement = new Statement("select * from movies where titile in ?",
                params,new Record());
        Statement secondStatement = firstStatement.clone();

        System.out.println(firstStatement.getSql());
        System.out.println(secondStatement.getSql());

        System.out.println(firstStatement.getParameters());
        System.out.println(secondStatement.getParameters());

        secondStatement.getParameters().add("aiugiugi");

        System.out.println(firstStatement.getParameters());
        System.out.println(secondStatement.getParameters());

        System.out.println(firstStatement.getRecord());
        System.out.println(secondStatement.getRecord());


        //Prototype pattern using registry of objects

        Registery registery = new Registery();
        Movie movie = (Movie) registery.createItem("Movie");
        movie.setTitle("Ant Man");

        System.out.println(movie);
        System.out.println(movie.getTitle());

        Movie movie1 = (Movie) registery.createItem("Movie");
        movie.setDuration("78979");

        System.out.println(movie1);
        System.out.println(movie1.getDuration());




    }
}
