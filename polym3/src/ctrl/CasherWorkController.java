package ctrl;

import model.basket.BasketInfoReader;
import model.receipt.IReceiptCreator;
import model.receipt.ReceiptCreatorKiri;
import model.receipt.ReceiptCreatorMaki;
import model.receipt.ReceiptCreatorYuka;
import data.dto.BasicInformation;
import data.dto.PurchasedGoods;

import java.util.List;

public class CasherWorkController {

    /**
     * レジ業務実行処理
     */
    public void execute(){

        BasketInfoReader basketInfoReader = new BasketInfoReader();

        //基本情報や商品リストを読み取り取得する
        BasicInformation basicInformation = basketInfoReader.readBasicInformation();
        List<PurchasedGoods> purchasedGoodsList = basketInfoReader.scanGoods();

        //レシート生成クラスを取得する
        IReceiptCreator creator = receiptCreatorFactory(basicInformation);

        //レシート生成クラスからレシート情報を出力
        //初期設定→ヘッダー→本文→フッダーの順に呼び出す。
        creator.setInitData(basicInformation);
        creator.createHeader();
        creator.createContents(purchasedGoodsList);
        creator.createFooter();

    }


    /**
     * レシート生成クラスの生成処理部分を別メソッドとして定義する。（ファクトリーメソッド）
     * @param basicInformation
     * @return
     */
    private IReceiptCreator receiptCreatorFactory(BasicInformation basicInformation){
        IReceiptCreator rc = null;

        switch (basicInformation.getStoreData()){
            case KIRITAN_SENDAI:
                rc = new ReceiptCreatorKiri();
                break;
            case YUKARI:
                rc = new ReceiptCreatorYuka();
                break;
            case MAKI_TOKYO:
                rc = new ReceiptCreatorMaki();
                break;
            default:
                //どれにも当てはまらないとき
                throw new IllegalArgumentException();
        }

        return rc;
    }
}
