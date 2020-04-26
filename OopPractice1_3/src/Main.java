import Basket.BasicInformation;
import Basket.PurchasedGoods;
import receipt.nooop.ReceiptControllerVer3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BasicInformation basicInformation = getBasicInformation();
        BasicInformation basicInformation2 = getBasicInformationYukari();
        BasicInformation basicInformation3 = getBasicInformationMaki();

        List<PurchasedGoods> goodsList = getGoodsList();
        List<PurchasedGoods> goodsList2 = getGoodsListYukari();
        List<PurchasedGoods> goodsList3 = getGoodsListMaki();

        ReceiptControllerVer3 receiptController = new ReceiptControllerVer3();

        receiptController.execute(basicInformation,goodsList);
        System.out.println();
        receiptController.execute(basicInformation2,goodsList2);
        System.out.println();
        receiptController.execute(basicInformation3,goodsList3);
    }

    //テスト用のBasicInformationを生成する
    private static BasicInformation getBasicInformation(){
        Calendar c = Calendar.getInstance();
        c.set(2019,1,10,12,34,50);

        return new BasicInformation(ReceiptControllerVer3.STORE_NM_ITAKO,"恐山支店",c.getTime(),"2000","999-3456-0000","");
    }

    //テスト用のBasicInformationを生成する
    private static BasicInformation getBasicInformationYukari(){
        Calendar c = Calendar.getInstance();
        c.set(2019,1,10,12,34,50);

        return new BasicInformation(ReceiptControllerVer3.STORE_NM_YUKARI,null,c.getTime(),"5000","012-3456-0000","");
    }

    //テスト用のBasicInformationを生成する
    private static BasicInformation getBasicInformationMaki(){
        Calendar c = Calendar.getInstance();
        c.set(2019,1,10,12,34,50);

        return new BasicInformation(ReceiptControllerVer3.STORE_NM_MAKI,"東京支店",c.getTime(),"2000","03-0000-0000","東京都千代田区××０丁目");
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

    //テスト用のPurchasedGoodsリストを生成する
    private static List<PurchasedGoods> getGoodsListMaki(){
        ArrayList<PurchasedGoods> goodsList = new ArrayList<PurchasedGoods>();

        goodsList.add(new PurchasedGoods("パン","200"));
        goodsList.add(new PurchasedGoods("ミネラルウォーター","250"));
        goodsList.add(new PurchasedGoods("とりにく","300"));
        goodsList.add(new PurchasedGoods("いちご","400"));

        return goodsList;
    }
}
