package model.receipt;

import data.dto.BasicInformation;
import data.dto.PurchasedGoods;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReceiptCreatorMaki implements IReceiptCreator{
    private BasicInformation basicInformation = null;

    @Override
    public void setInitData(BasicInformation basicInformation) {
        this.basicInformation = basicInformation;
    }

    @Override
    public void createHeader(){
        System.out.println(basicInformation.getStoreName());
        System.out.println(basicInformation.getBranchName());
        System.out.println("  " + basicInformation.getAddress());
        System.out.println("  " + basicInformation.getPhoneNumber());
        SimpleDateFormat sdf = new SimpleDateFormat("              yyyy/MM/dd　hh:mm:ss");
        System.out.println(sdf.format(basicInformation.getPurchaseTime()));
        System.out.println(HR);
    }

    @Override
    public void createContents(List<PurchasedGoods> purchasedGoodsList){
        String printStr = null;
        BigDecimal sum = new BigDecimal("0");
        for(PurchasedGoods goods : purchasedGoodsList){
            sum = sum.add(goods.getPrice());
            printStr = String.format("%-20s %5d", goods.getGoodsName(), goods.getPrice().intValue());
            System.out.println(printStr);
        }
        System.out.println(HR2);

        printStr = String.format("%-20s %5d", "合計　　　", sum.intValue());
        System.out.println(printStr);

        System.out.println(HR2);
        basicInformation.getPaymentAmount().intValue();
        printStr = String.format("%-20s %5d", "お預り　　", basicInformation.getPaymentAmount().intValue());
        System.out.println(printStr);

        BigDecimal change = basicInformation.getPaymentAmount().subtract(sum);
        printStr = String.format("%-20s %5d", "お釣り　　", change.intValue());
        System.out.println(printStr);
    }

    @Override
    public void createFooter(){
    }
}
