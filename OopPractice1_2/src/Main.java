import Basket.BasicInformation;
import Basket.PurchasedGoods;
import receipt.nooop.ReceiptControllerVer2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Calendar c = Calendar.getInstance();
        c.set(2019,1,10,12,34,50);

        BasicInformation basicInformation = getBasicInformation();
        List<PurchasedGoods> goodsList = getGoodsList();

        BasicInformation basicInformation2 =getBasicInformationYukari();
        List<PurchasedGoods> goodsList2 = getGoodsListYukari();

        ReceiptControllerVer2 receiptController = new ReceiptControllerVer2();
        receiptController.execute(basicInformation,goodsList);
        System.out.println();

        receiptController = new ReceiptControllerVer2();
        receiptController.execute(basicInformation2,goodsList2);

    }

    //テスト用のBasicInformationを生成する
    private static BasicInformation getBasicInformation(){
        Calendar c = Calendar.getInstance();
        c.set(2019,1,10,12,34,50);

        return new BasicInformation(ReceiptControllerVer2.STORE_NM_ITAKO,"恐山支店",c.getTime(),"2000");
    }
    //テスト用のBasicInformationを生成する
    private static BasicInformation getBasicInformationYukari(){
        Calendar c = Calendar.getInstance();
        c.set(2019,1,10,12,34,50);

        return new BasicInformation(ReceiptControllerVer2.STORE_NM_YUKARI,null,c.getTime(),"5000");
    }

    //テスト用のPurchasedGoodsリストを生成する
    private static List<PurchasedGoods> getGoodsList(){
        ArrayList<PurchasedGoods> goodsList = new ArrayList<PurchasedGoods>();

        goodsList.add(new PurchasedGoods("あじの盛り塩焼き","500"));
        goodsList.add(new PurchasedGoods("水の子サラダ","250"));
        goodsList.add(new PurchasedGoods("お神酒","300"));

        return goodsList;
    }

    //テスト用のPurchasedGoodsリストを生成する
    private static List<PurchasedGoods> getGoodsListYukari(){
        ArrayList<PurchasedGoods> goodsList = new ArrayList<PurchasedGoods>();

        goodsList.add(new PurchasedGoods("猿でもわかる手続き型","1500"));
        goodsList.add(new PurchasedGoods("猫でもわかるOOP","1250"));
        goodsList.add(new PurchasedGoods("犬でもわかる関数型","1300"));

        return goodsList;
    }

}
