import Basket.BasicInformation;
import Basket.PurchasedGoods;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    public final static String HR =  "===============================";
    public final static String HR2 = " ----------------------------- ";

    public static void main(String[] args) {
        //レシート印字用のデータ生成
        BasicInformation basicInformation = getBasicInformation();
        List<PurchasedGoods> goodsList = getGoodsList();

        //ここからがレシート処理
        //header
        System.out.println();
        System.out.println(lineFormatCentral(basicInformation.getStoreName()));
        System.out.println(basicInformation.getBranchName());
        System.out.println();
        System.out.println(HR);

        //contents
        String printStr = null;
        BigDecimal sum = new BigDecimal("0");
        for(PurchasedGoods goods : goodsList){
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

        //footer
        System.out.println(HR);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日　hh時mm分ss秒");
        System.out.println(sdf.format(basicInformation.getPurchaseTime()));

    }


    //テスト用のBasicInformationを生成する
    private static BasicInformation getBasicInformation(){
        Calendar c = Calendar.getInstance();
        c.set(2019,1,10,12,34,50);

        return new BasicInformation("イタコ食堂","恐山支店",c.getTime(),"2000");
    }

    //テスト用のPurchasedGoodsリストを生成する
    private static List<PurchasedGoods> getGoodsList(){
        ArrayList<PurchasedGoods> goodsList = new ArrayList<PurchasedGoods>();

        goodsList.add(new PurchasedGoods("あじの盛り塩焼き","500"));
        goodsList.add(new PurchasedGoods("水の子サラダ","250"));
        goodsList.add(new PurchasedGoods("お神酒","300"));

        return goodsList;
    }

    private static String lineFormatGoodsRow(String orgStr, BigDecimal orgDec){
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

    private static String lineFormatCentral(String orgStr){
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
