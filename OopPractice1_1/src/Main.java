import Basket.BasicInformation;
import Basket.PurchasedGoods;
import receipt.nooop.ReceiptController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BasicInformation basicInformation = getBasicInformation();
        List<PurchasedGoods> goodsList = getGoodsList();

        ReceiptController receiptController = new ReceiptController();
        receiptController.execute(basicInformation,goodsList);

    }

    //テスト用のBasicInformationを生成する
    private static BasicInformation getBasicInformation(){
        Calendar c = Calendar.getInstance();
        c.set(2019,1,10,12,34,50);

        return new BasicInformation("イタコ食堂","恐山支店",c.getTime(),"2000");
    }

    //テスト用のPurchasedGoodsリストを生成する
    private static List<PurchasedGoods> getGoodsList(){
        ArrayList<PurchasedGoods> goodsList = new ArrayList<PurchasedGoods>();

        goodsList.add(new PurchasedGoods("あじの盛り塩焼き","500"));
        goodsList.add(new PurchasedGoods("水の子サラダ","250"));
        goodsList.add(new PurchasedGoods("お神酒","300"));

        return goodsList;
    }

}
