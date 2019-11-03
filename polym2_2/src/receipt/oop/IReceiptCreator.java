package receipt.oop;

import Basket.BasicInformation;
import Basket.PurchasedGoods;

import java.util.List;

public interface IReceiptCreator {

    public void execute(BasicInformation basicInformation, List<PurchasedGoods> purchasedGoodsList);

}
