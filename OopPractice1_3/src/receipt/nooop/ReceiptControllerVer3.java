package receipt.nooop;

import Basket.BasicInformation;
import Basket.PurchasedGoods;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReceiptControllerVer3 {
    public static final String STORE_NM_ITAKO = "イタコ食堂";
    public static final String STORE_NM_YUKARI = "ゆかりショップ";
    public static final String STORE_NM_MAKI = "マキマキマーケット";

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

    private void createHeader(BasicInformation basicInformation){
        System.out.println();
        System.out.println(lineFormatCenter(basicInformation.getStoreName()));
        if(basicInformation.getStoreName().equals(STORE_NM_ITAKO) ||
                basicInformation.getStoreName().equals(STORE_NM_MAKI)){
            System.out.println(basicInformation.getBranchName());
        }
        if(basicInformation.getStoreName().equals(STORE_NM_MAKI)){
            System.out.println("  " + basicInformation.getAddress());
            System.out.println("  " + basicInformation.getPhoneNumber());
            SimpleDateFormat sdf = new SimpleDateFormat("           yyyy/MM/dd　hh:mm:ss");
            System.out.println(sdf.format(basicInformation.getPurchaseTime()));
        }else{
            System.out.println();
        }
        System.out.println(HR);
    }

    private void createContents(BasicInformation basicInformation, List<PurchasedGoods> purchasedGoodsList){
        String printStr = null;
        BigDecimal sum = new BigDecimal("0");
        for(PurchasedGoods goods : purchasedGoodsList){
            sum = sum.add(goods.getPrice());
            if(basicInformation.getStoreName().equals(STORE_NM_ITAKO)) {
                printStr = lineFormatGoodsRow(goods.getGoodsName(), goods.getPrice());
            }else if(basicInformation.getStoreName().equals(STORE_NM_YUKARI)) {
                printStr = lineFormatGoodsRowYenSign(goods.getGoodsName(), goods.getPrice());
            }else {
                printStr = lineFormatGoodsRowNoSign(goods.getGoodsName(), goods.getPrice());
            }
            System.out.println(printStr);
        }
        System.out.println(HR2);
        if(basicInformation.getStoreName().equals(STORE_NM_ITAKO)) {
            printStr = lineFormatGoodsRow("合計", sum);
        }else {
            printStr = lineFormatGoodsRowYenSign("合計", sum);
        }
        System.out.println(printStr);

        System.out.println(HR2);
        basicInformation.getPaymentAmount().intValue();
        if(basicInformation.getStoreName().equals(STORE_NM_ITAKO)) {
            printStr = lineFormatGoodsRow("お預り", basicInformation.getPaymentAmount());
        }else {
            printStr = lineFormatGoodsRowYenSign("お預り", basicInformation.getPaymentAmount());
        }
        System.out.println(printStr);

        BigDecimal change = basicInformation.getPaymentAmount().subtract(sum);
        if(basicInformation.getStoreName().equals(STORE_NM_ITAKO)) {
            printStr = lineFormatGoodsRow("お釣り", change);
        }else{
            printStr = lineFormatGoodsRowYenSign("お釣り", change);
        }
        System.out.println(printStr);
    }

    private void createFooter(BasicInformation basicInformation){
        if(basicInformation.getStoreName().equals(STORE_NM_ITAKO) ||
                basicInformation.getStoreName().equals(STORE_NM_YUKARI) ){
            System.out.println(HR);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日　hh時mm分ss秒");
            System.out.println(sdf.format(basicInformation.getPurchaseTime()));
        }
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

    private String lineFormatGoodsRowYenSign(String gName, BigDecimal gPrice){
        final int gNameLen = 20;
        final int gPriceLen = 6;

        int diffStrLen = 0;
        for(char c : gName.toCharArray()){
            if(String.valueOf(c).getBytes().length > 1){
                //全角の場合
                diffStrLen++;
            }
        }

        return String.format(" %-"+ (gNameLen - diffStrLen) +"s \\%," + gPriceLen + "d ",gName,gPrice.intValue());
    }

    private String lineFormatGoodsRowNoSign(String gName, BigDecimal gPrice){
        final int gNameLen = 20;
        final int gPriceLen = 6;

        int diffStrLen = 0;
        for(char c : gName.toCharArray()){
            if(String.valueOf(c).getBytes().length > 1){
                //全角の場合
                diffStrLen++;
            }
        }

        return String.format(" %-"+ (gNameLen - diffStrLen) +"s  %," + gPriceLen + "d ",gName,gPrice.intValue());
    }

    private String lineFormatCenter(String orgStr){
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
