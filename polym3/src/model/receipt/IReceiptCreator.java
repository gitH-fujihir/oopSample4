package model.receipt;

import data.dto.BasicInformation;
import data.dto.PurchasedGoods;

import java.util.List;

public interface IReceiptCreator {
    String HR =  "==================================";
    String HR2 = " ----------------------------- ";

    /**
     * 初期データ設定
     * @param basicInformation
     */
    void setInitData(BasicInformation basicInformation);

    /**
     * ヘッダー生成
     */
    void createHeader();

    /**
     * 本文生成
     * @param purchasedGoodsList
     */
    void createContents(List<PurchasedGoods> purchasedGoodsList);

    /**
     * フッダー生成
     */
    void createFooter();

}
