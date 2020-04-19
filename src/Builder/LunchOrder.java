package Builder;

public class LunchOrder {

    public static class Builder {
        private String bread;
        private String condiments;
        private String meat;
        private String dressing;

        public Builder() {

        }

        public LunchOrder build () {
            // call the private constructor in the outer class
            return new LunchOrder(this);
        }

        public Builder bread(String bread)  {
            this.bread = bread;
            return this;
        }

        public Builder meat(String meat)  {
            this.meat = meat;
            return this;
        }

        public Builder condiments(String condiments)  {
            this.condiments = condiments;
            return this;
        }

        public Builder dressing( String dressing )  {
            this.dressing = dressing;
            return this;
        }
    }

    private  final String bread;
    private  final String meat;
    private  final String dressing;
    private  final String condiments;

    //A member declared as private final String without initialisation means that
    // 1) that member must be set on construction and, 2) it cannot be set subsequently
    // to refer to another string. These two things serve to increase program stability.
    // Also, because any particular string is immutable, these fields are constant.

    private LunchOrder(Builder builder){
        this.bread = builder.bread;
        this.meat = builder.meat;
        this.dressing = builder.dressing;
        this.condiments = builder.condiments;
    }

    public String getBread() {
        return bread;
    }

    public String getMeat() {
        return meat;
    }

    public String getDressing() {
        return dressing;
    }

    public String getCondiments() {
        return condiments;
    }

}

//Static inner class is used in the builder pattern. Static inner class can instantiate it's outer class
//which has only private constructor. So you can use static inner class to instantiate the outer class
//which only has private constructor.It can access static data members of outer class including private.
// Static nested class cannot access non-static (instance) data member or method.
//Keep in mind that if your class has multiple attributes with the same type or optional when you design your
// class, it is time to consider the Builder Pattern. If now, you may want to add more parameters to your class,
// then it is never too late to consider refactoring your code with the Builder pattern.
// But, nothing is perfect; the Builder pattern has its own disadvantages, like being more verbose than
// the telescoping constructor pattern.

//Avoid multiple constructor
//promotes immutability

//StringBuilder is an example.