package model.basket;

import data.dto.BasicInformation;
import data.dto.PurchasedGoods;
import data.enums.StoreData;
import main.Main;

import java.util.ArrayList;
import java.util.Calendar;

public class BasketInfoReader {

    public BasicInformation readBasicInformation(){
        //ダミー処理
        Calendar c = Calendar.getInstance();
        c.set(2019,1,10,12,34,50);
        BasicInformation basicInformation = null;

        if(Main.dummy % 3 == 0){
            basicInformation = new BasicInformation(StoreData.KIRITAN_SENDAI,c.getTime(),"2000");
        }else if(Main.dummy % 3 == 1){
            basicInformation = new BasicInformation(StoreData.YUKARI,c.getTime(),"2000");
        }else if(Main.dummy % 3 == 2){
            basicInformation = new BasicInformation(StoreData.MAKI_TOKYO,c.getTime(),"2000");
        }

        return basicInformation;
    }

    public ArrayList<PurchasedGoods> scanGoods(){
        //ダミー処理
        ArrayList<PurchasedGoods> goodsList = new ArrayList<PurchasedGoods>();

        goodsList.add(new PurchasedGoods("きりたんぽ","500"));
        goodsList.add(new PurchasedGoods("みそ　　　","250"));
        goodsList.add(new PurchasedGoods("とりにく　","300"));

        return goodsList;

    }
}
