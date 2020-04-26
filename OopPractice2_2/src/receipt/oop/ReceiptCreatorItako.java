package receipt.oop;

import Basket.BasicInformation;
import Basket.PurchasedGoods;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReceiptCreatorItako implements IReceiptCreator{

    public void createHeader(BasicInformation basicInformation){
        System.out.println();
        System.out.println(lineFormatCentral(basicInformation.getStoreName()));
        System.out.println(basicInformation.getBranchName());
        System.out.println();
        System.out.println(HR);
    }

    public void createContents(BasicInformation basicInformation, List<PurchasedGoods> purchasedGoodsList){
        String printStr = null;
        BigDecimal sum = new BigDecimal("0");
        for(PurchasedGoods goods : purchasedGoodsList){
            sum = sum.add(goods.getPrice());
            printStr = lineFormatGoodsRow(goods.getGoodsName(), goods.getPrice());
            System.out.println(printStr);
        }
        System.out.println(HR2);
        printStr = lineFormatGoodsRow("合計", sum);
        System.out.println(printStr);

        System.out.println(HR2);
        basicInformation.getPaymentAmount().intValue();
        printStr = lineFormatGoodsRow("お預り", basicInformation.getPaymentAmount());
        System.out.println(printStr);

        BigDecimal change = basicInformation.getPaymentAmount().subtract(sum);
        printStr = lineFormatGoodsRow("お釣り", change);
        System.out.println(printStr);
    }

    public void createFooter(BasicInformation basicInformation){
        System.out.println(HR);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日　hh時mm分ss秒");
        System.out.println(sdf.format(basicInformation.getPurchaseTime()));
    }

    private String lineFormatGoodsRow(String orgStr, BigDecimal orgDec){
        final int gNameLen = 20;
        final int gPirceLen = 6;

        int diffStrLen = 0;
        for(char c : orgStr.toCharArray()){
            if(String.valueOf(c).getBytes().length > 1){
                //全角の場合
                diffStrLen++;
            }
        }

        return String.format(" %-"+ (gNameLen - diffStrLen) +"s %" + gPirceLen + "d円 ",orgStr,orgDec.intValue());

    }

    private String lineFormatGoodsRowYenSign(String orgStr, BigDecimal orgDec){
        final int gNameLen = 20;
        final int gPirceLen = 6;

        int diffStrLen = 0;
        for(char c : orgStr.toCharArray()){
            if(String.valueOf(c).getBytes().length > 1){
                //全角の場合
                diffStrLen++;
            }
        }

        return String.format(" %-"+ (gNameLen - diffStrLen) +"s \\%," + gPirceLen + "d ",orgStr,orgDec.intValue());
    }

    private String lineFormatGoodsRowNoSign(String orgStr, BigDecimal orgDec){
        final int gNameLen = 20;
        final int gPirceLen = 6;

        int diffStrLen = 0;
        for(char c : orgStr.toCharArray()){
            if(String.valueOf(c).getBytes().length > 1){
                //全角の場合
                diffStrLen++;
            }
        }

        return String.format(" %-"+ (gNameLen - diffStrLen) +"s  %," + gPirceLen + "d ",orgStr,orgDec.intValue());
    }

    private String lineFormatCentral(String orgStr){
        final int strLen = 31;

        int diffStrLen = 0;
        for(char c : orgStr.toCharArray()){
            if(String.valueOf(c).getBytes().length > 1){
                //全角の場合
                diffStrLen++;
            }
        }

        int preSpCnt = (strLen - orgStr.length() - diffStrLen) / 2;
        //String displayStr = IntStream.range(0, preSpCnt).mapToObj(i -> " ").collect(Collectors.joining("", "", orgStr));
        StringBuffer displayStr = new StringBuffer();
        for(int i = 0 ; i < preSpCnt; i++) {
            displayStr.append(" ");
        }
        displayStr.append(orgStr);

        return String.format("%-"+ (strLen - diffStrLen) +"s",displayStr);
    }

}
