package Factory;

public class WebsiteFactory {

    public static Website getWebsite(WebsiteType siteType) {
        switch (siteType) {
            case BLOG : { //use enum
                return new Blog();
            }case SHOP : {
                return  new Shop();
            } default:
                return null;
        }
    }
}

//This pattern will allow the creation of objects without exposing the instantiation logic to the client.
//bit complex
//creation of subclass
//Refactoring
