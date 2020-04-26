package receipt.oop;

import Basket.BasicInformation;
import Basket.PurchasedGoods;

import java.util.List;

public interface IReceiptCreator {
    public final static String HR =  "===============================";
    public final static String HR2 = " ----------------------------- ";

    public void createHeader(BasicInformation basicInformation);

    public void createContents(BasicInformation basicInformation, List<PurchasedGoods> purchasedGoodsList);

    public void createFooter(BasicInformation basicInformation);

}
