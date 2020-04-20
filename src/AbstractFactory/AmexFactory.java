package AbstractFactory;

public class AmexFactory extends CreditCardFactory {

    @Override
    public  CreditCard getCreditCard (CardType cardType){

        switch (cardType) {
            case GOLD:
                return new AmexGoldCreditCard();
            case PLATUNUM:
                return new AmexPlatinumCreditCard();
        }


        return null;

    }
}
