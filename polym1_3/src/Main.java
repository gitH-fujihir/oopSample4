import Basket.BasicInformation;
import Basket.ConstValue;
import Basket.PurchasedGoods;
import receipt.nooop.ReceiptCreatorVer3;

import java.util.ArrayList;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Calendar c = Calendar.getInstance();
        c.set(2019,1,10,12,34,50);

        BasicInformation basicInformation = new BasicInformation(ConstValue.STORE_NM_KIRITAN,"仙台支店",c.getTime(),"2000","","");
        BasicInformation basicInformation2 = new BasicInformation(ConstValue.STORE_NM_YUKARI,"",c.getTime(),"2000","","");
        BasicInformation basicInformation3 = new BasicInformation(ConstValue.STORE_NM_MAKI,"東京支店",c.getTime(),"2000","03-0000-0000","東京都千代田区××０丁目");

        ArrayList<PurchasedGoods> goodsList = createSampleGoodsList();

        ReceiptCreatorVer3 receiptCreator = new ReceiptCreatorVer3();

        receiptCreator.execute(basicInformation,goodsList);
        System.out.println();
        receiptCreator.execute(basicInformation2,goodsList);
        System.out.println();
        receiptCreator.execute(basicInformation3,goodsList);
    }

    private static ArrayList<PurchasedGoods> createSampleGoodsList(){
        ArrayList<PurchasedGoods> goodsList = new ArrayList<PurchasedGoods>();

        goodsList.add(new PurchasedGoods("きりたんぽ","500"));
        goodsList.add(new PurchasedGoods("みそ　　　","250"));
        goodsList.add(new PurchasedGoods("とりにく　","300"));

        return goodsList;
    }
}
