import Basket.BasicInformation;
import Basket.ConstValue;
import Basket.PurchasedGoods;
import receipt.nooop.ReceiptCreatorVer2;

import java.util.ArrayList;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Calendar c = Calendar.getInstance();
        c.set(2019,1,10,12,34,50);

        BasicInformation basicInformation = new BasicInformation(ConstValue.STORE_NM_KIRITAN,"仙台支店",c.getTime(),"2000");
        ArrayList<PurchasedGoods> goodsList = new ArrayList<PurchasedGoods>();
        goodsList.add(new PurchasedGoods("きりたんぽ","500"));
        goodsList.add(new PurchasedGoods("みそ　　　","250"));
        goodsList.add(new PurchasedGoods("とりにく　","300"));

        BasicInformation basicInformation2 = new BasicInformation(ConstValue.STORE_NM_YUKARI,"",c.getTime(),"2000");
        //商品内容は同じにします。
        ArrayList<PurchasedGoods> goodsList2 = new ArrayList<PurchasedGoods>();
        goodsList2.add(new PurchasedGoods("きりたんぽ","500"));
        goodsList2.add(new PurchasedGoods("みそ　　　","250"));
        goodsList2.add(new PurchasedGoods("とりにく　","300"));


        ReceiptCreatorVer2 receiptCreator = new ReceiptCreatorVer2();
        receiptCreator.execute(basicInformation,goodsList);
        System.out.println();

        receiptCreator = new ReceiptCreatorVer2();
        receiptCreator.execute(basicInformation2,goodsList2);

    }
}
