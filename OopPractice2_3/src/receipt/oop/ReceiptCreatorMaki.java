package receipt.oop;

import Basket.BasicInformation;
import Basket.PurchasedGoods;
import receipt.oop.util.FormatUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReceiptCreatorMaki implements IReceiptCreator{

    FormatUtil forUtil = new FormatUtil();

    public void createHeader(BasicInformation basicInformation){
        System.out.println();
        System.out.println(forUtil.lineFormatCentral(basicInformation.getStoreName()));
        System.out.println(basicInformation.getBranchName());
        System.out.println("  " + basicInformation.getAddress());
        System.out.println("  " + basicInformation.getPhoneNumber());
        SimpleDateFormat sdf = new SimpleDateFormat("           yyyy/MM/dd　hh:mm:ss");
        System.out.println(sdf.format(basicInformation.getPurchaseTime()));
        System.out.println(HR);
    }

    public void createContents(BasicInformation basicInformation, List<PurchasedGoods> purchasedGoodsList){
        String printStr = null;
        BigDecimal sum = new BigDecimal("0");
        for(PurchasedGoods goods : purchasedGoodsList){
            sum = sum.add(goods.getPrice());
            printStr = forUtil.lineFormatGoodsRowNoSign(goods.getGoodsName(), goods.getPrice());
            System.out.println(printStr);
        }
        System.out.println(HR2);

        printStr = forUtil.lineFormatGoodsRowYenSign("合計", sum);
        System.out.println(printStr);

        System.out.println(HR2);
        basicInformation.getPaymentAmount().intValue();
        printStr = forUtil.lineFormatGoodsRowYenSign("お預り", basicInformation.getPaymentAmount());
        System.out.println(printStr);

        BigDecimal change = basicInformation.getPaymentAmount().subtract(sum);
        printStr = forUtil.lineFormatGoodsRowYenSign("お釣り", change);
        System.out.println(printStr);
    }

    public void createFooter(BasicInformation basicInformation){
    }

}
