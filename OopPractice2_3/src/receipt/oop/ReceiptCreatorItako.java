package receipt.oop;

import Basket.BasicInformation;
import Basket.PurchasedGoods;
import receipt.oop.util.FormatUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReceiptCreatorItako implements IReceiptCreator{

    FormatUtil forUtil = new FormatUtil();

    public void createHeader(BasicInformation basicInformation){
        System.out.println();
        System.out.println(forUtil.lineFormatCentral(basicInformation.getStoreName()));
        System.out.println(basicInformation.getBranchName());
        System.out.println();
        System.out.println(HR);
    }

    public void createContents(BasicInformation basicInformation, List<PurchasedGoods> purchasedGoodsList){
        String printStr = null;
        BigDecimal sum = new BigDecimal("0");
        for(PurchasedGoods goods : purchasedGoodsList){
            sum = sum.add(goods.getPrice());
            printStr = forUtil.lineFormatGoodsRow(goods.getGoodsName(), goods.getPrice());
            System.out.println(printStr);
        }
        System.out.println(HR2);
        printStr = forUtil.lineFormatGoodsRow("合計", sum);
        System.out.println(printStr);

        System.out.println(HR2);
        basicInformation.getPaymentAmount().intValue();
        printStr = forUtil.lineFormatGoodsRow("お預り", basicInformation.getPaymentAmount());
        System.out.println(printStr);

        BigDecimal change = basicInformation.getPaymentAmount().subtract(sum);
        printStr = forUtil.lineFormatGoodsRow("お釣り", change);
        System.out.println(printStr);
    }

    public void createFooter(BasicInformation basicInformation){
        System.out.println(HR);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日　hh時mm分ss秒");
        System.out.println(sdf.format(basicInformation.getPurchaseTime()));
    }

}
