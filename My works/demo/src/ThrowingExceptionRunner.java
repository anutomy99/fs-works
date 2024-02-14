import java.security.SecureRandom;

class Amount{
    private String currency;
    private  int amount;

    public Amount(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }
    public  void add(Amount that){
        if(!this.currency.equals(that.currency)){
//            throw  new InterruptedException("Currencies don't Match "+this.currency+" & "+that.currency);
             throw new CurrenciesDoNotMatchException("Currencies don't Match "+this.currency+" & "+that.currency);
        }
        this.amount = this.amount+ that.amount;
    }

    @Override
    public String toString() {
        return amount+"  "+currency;
    }
}
class CurrenciesDoNotMatchException extends RuntimeException{
    public CurrenciesDoNotMatchException(String msg){
        super(msg);
    }
}
public class ThrowingExceptionRunner {
    public static void main(String[] args)  {
        Amount amount1 = new Amount("USD",10);
        Amount amount2 = new Amount("INR",10);
        amount1.add(amount2);
        System.out.println(amount1);
    }
}
