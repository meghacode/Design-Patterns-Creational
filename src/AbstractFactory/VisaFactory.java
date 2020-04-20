package AbstractFactory;

public class VisaFactory extends CreditCardFactory {

    @Override
    public  CreditCard getCreditCard (CardType cardType){

        switch (cardType) {
            case GOLD:
                return new VisaGoldCreditCard();
            case PLATUNUM:
                return new VisaPlatinumCreditCard();
        }


        return null;

    }


}
