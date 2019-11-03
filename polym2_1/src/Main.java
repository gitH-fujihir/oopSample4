import Basket.BasicInformation;
import Basket.ConstValue;
import Basket.PurchasedGoods;
import receipt.oop.ReceiptCreatorKiri;
import receipt.oop.ReceiptCreatorMaki;
import receipt.oop.ReceiptCreatorYuka;

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

        executeRC(basicInformation,goodsList);
        executeRC(basicInformation2,goodsList);
        executeRC(basicInformation3,goodsList);

    }

    private static ArrayList<PurchasedGoods> createSampleGoodsList(){
        ArrayList<PurchasedGoods> goodsList = new ArrayList<PurchasedGoods>();

        goodsList.add(new PurchasedGoods("きりたんぽ","500"));
        goodsList.add(new PurchasedGoods("みそ　　　","250"));
        goodsList.add(new PurchasedGoods("とりにく　","300"));

        return goodsList;
    }

    private static void executeRC(BasicInformation bi,ArrayList<PurchasedGoods> goodsList){
        if(bi.getStoreName().equals(ConstValue.STORE_NM_KIRITAN)){
            ReceiptCreatorKiri rc = new ReceiptCreatorKiri();
            rc.execute(bi,goodsList);
        }else if(bi.getStoreName().equals(ConstValue.STORE_NM_YUKARI)){
            ReceiptCreatorYuka rc = new ReceiptCreatorYuka();
            rc.execute(bi,goodsList);
        }else if(bi.getStoreName().equals(ConstValue.STORE_NM_MAKI)){
            ReceiptCreatorMaki rc = new ReceiptCreatorMaki();
            rc.execute(bi,goodsList);
        }
        System.out.println();

    }
}
