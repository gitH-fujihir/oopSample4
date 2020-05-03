package receipt.oop;

import Basket.BasicInformation;
import Basket.PurchasedGoods;

import java.util.List;

public class ReceiptController {
    public static final String STORE_NM_ITAKO = "イタコ食堂";
    public static final String STORE_NM_YUKARI = "ゆかりショップ";
    public static final String STORE_NM_MAKI = "マキマキマーケット";

    public void execute(BasicInformation basicInformation, List<PurchasedGoods> purchasedGoodsList){
        try {
            IReceiptCreator creator = getReceiptCreator(basicInformation);

            //header
            creator.createHeader(basicInformation);

            //contents
            creator.createContents(basicInformation, purchasedGoodsList);

            //footer
            creator.createFooter(basicInformation);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private IReceiptCreator getReceiptCreator(BasicInformation bi) throws Exception {
        IReceiptCreator creator = null;
        if(bi.getStoreName().equals(STORE_NM_ITAKO)){
            creator = new ReceiptCreatorItako();
        }else if(bi.getStoreName().equals(STORE_NM_YUKARI)){
            creator = new ReceiptCreatorYukari();
        }else if(bi.getStoreName().equals(STORE_NM_MAKI)){
            creator = new ReceiptCreatorMaki();
        }else{
            System.out.println("想定外の値：" + bi.getStoreName());
            throw new Exception();
        }

        return creator;

    }
}
