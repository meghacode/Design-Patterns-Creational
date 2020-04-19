package Prototype;

import java.util.HashMap;
import java.util.Map;

public class Registery {

    private Map<String,Item> items = new HashMap<String, Item>();

    public Registery() {
        loadItems();
    }

    public Item createItem(String type) {

        Item item = null;

        try {
            item =(Item)items.get(type).clone(); //cast is necessary because the clone method returns Object

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return item;

    }

    private void loadItems () {
        Movie movie = new Movie();
        movie.setDuration("200");
        movie.setPrice(8979897);
        movie.setTitle("Marvel");

        items.put("Movie",movie);

        Book book = new Book();
        book.setPages(788);
        book.setPrice(8898790);
        movie.setTitle("Marvel");

        items.put("Book",book);
    }

}

//When Would I Use This Pattern?
// Composition, creation and representation of objects should be decoupled from the system.
// Classes to be created are specified at runtime
// You need to hide the complexity of creating new instance from the client
// Creating an object is an expensive operation and it would be more efficient to copy an object.
// Objects are required that are similar to existing objects.

//The pattern is used by the Cloneable interface in Java. Cloneable is implemented as a marker
// interface to show what objects can be cloned, as Object already defined a protected clone() method.
// Client can override, or call the superclass implementation, of this clone method to do the copy.

//One of the downsides to this pattern is that the process of copying an object can be complicated.
// Also, classes that have circular references to other classes are difficult to clone. Overuse of the
// pattern could affect performance, as the prototype object itself would need to be instantiated if
// you use a registry of prototypes.

//mostly used with other pattern

//sometimes deep copy is required

