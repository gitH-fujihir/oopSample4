import Basket.BasicInformation;
import Basket.PurchasedGoods;
import receipt.nooop.ReceiptCreator;

import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    public static final String STORE_NM_KIRITAN = "　　　　きりたんストア";

    public static void main(String[] args) {
	// write your code here

        Calendar c = Calendar.getInstance();
        c.set(2019,1,10,12,34,50);

        BasicInformation basicInformation = new BasicInformation(STORE_NM_KIRITAN,"仙台支店",c.getTime(),"2000");

        ArrayList<PurchasedGoods> goodsList = new ArrayList<PurchasedGoods>();

        goodsList.add(new PurchasedGoods("きりたんぽ","500"));
        goodsList.add(new PurchasedGoods("みそ　　　","250"));
        goodsList.add(new PurchasedGoods("とりにく　","300"));

        ReceiptCreator receiptCreator = new ReceiptCreator();

        receiptCreator.execute(basicInformation,goodsList);

    }
}
