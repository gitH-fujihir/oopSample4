package receipt.nooop;

import Basket.BasicInformation;
import Basket.PurchasedGoods;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReceiptController {
    public final static String HR =  "===============================";
    public final static String HR2 = " ----------------------------- ";

    public void execute(BasicInformation basicInformation, List<PurchasedGoods> purchasedGoodsList){
        //header
        createHeader(basicInformation);

        //contents
        createContents(basicInformation, purchasedGoodsList);

        //footer
        createFooter(basicInformation);
    }

    private void createHeader(BasicInformation basicInformation) {
        //header
        System.out.println();
        System.out.println(lineFormatCentral(basicInformation.getStoreName()));
        System.out.println(basicInformation.getBranchName());
        System.out.println();
        System.out.println(HR);
    }

    private void createContents(BasicInformation basicInformation, List<PurchasedGoods> purchasedGoodsList) {
        //contents
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

    private void createFooter(BasicInformation basicInformation) {
        //footer
        System.out.println(HR);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日　hh時mm分ss秒");
        System.out.println(sdf.format(basicInformation.getPurchaseTime()));
    }

    private String lineFormatGoodsRow(String gName, BigDecimal gPrice){
        final int gNameLen = 20;
        final int gPirceLen = 6;

        int diffStrLen = 0;
        for(char c : gName.toCharArray()){
            if(String.valueOf(c).getBytes().length > 1){
                //全角の場合
                diffStrLen++;
            }
        }

        return String.format(" %-"+ (gNameLen - diffStrLen) +"s %" + gPirceLen + "d円 ",gName,gPrice.intValue());

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
