package receipt.oop.util;

import java.math.BigDecimal;

public class FormatUtil {
    public String lineFormatGoodsRow(String orgStr, BigDecimal orgDec){
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

    public String lineFormatGoodsRowYenSign(String orgStr, BigDecimal orgDec){
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

    public String lineFormatGoodsRowNoSign(String orgStr, BigDecimal orgDec){
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

    public String lineFormatCentral(String orgStr){
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
