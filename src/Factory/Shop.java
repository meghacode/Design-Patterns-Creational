package Factory;

public class Shop extends Website {

    @Override
    public void createWebsite() {
        pages.add(new CartPgae());
        pages.add(new ItemPage());
        pages.add(new SearchPage());
    }


}
