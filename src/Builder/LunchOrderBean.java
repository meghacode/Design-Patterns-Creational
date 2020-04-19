package Builder;

//Bean model vs telescopic constructor
public class LunchOrderBean {

    private String bread;
    private String meat;
    private String condiments;
    private String dressing;

    LunchOrderBean() {} //no argument constructor

//    LunchOrderBean(String bread){  //telescopic constructor
//        this.bread = bread;
//    }
//
//    LunchOrderBean (String bread, String meat) {
//        this(bread);
//        this.meat = meat;
//    }

    public String getBread() {
        return bread;
    }

    public  void  setBread( String bread) {
        this.bread = bread;
    }

    public String getMeat() {
        return meat;
    }

    public  void  setMeat( String meat) {
        this.meat = meat;
    }

    public String getCondiments() {
        return condiments;
    }

    public  void  setCondiments( String condiments) {
        this.condiments = condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public  void  setDressing( String dressing) {
        this.dressing = dressing;
    }

}


//Telescoping Constructor. ... A class has multiple constructors, where each constructor calls a more
// specific constructor in the hierarchy, which has more parameters than itself, providing default values
// for the extra parameters. The next constructor does the same until there is no left.



// It is no surprise that the JavaBean pattern increases the readability of code and the flexibility of object
// construction. But, this solution has two big disadvantages: the first one is that the object state will be
// inconsistent unless all the attributes are set explicitly; the second one is that the JavaBean pattern makes
// a class mutable and requires extra efforts of developers to ensure thread safety.