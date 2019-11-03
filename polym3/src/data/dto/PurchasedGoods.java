package data.dto;

import java.math.BigDecimal;

public class PurchasedGoods {
    private String goodsName = null;
    private BigDecimal price = null;

    public PurchasedGoods(String goodsName, String price){
        this.goodsName = goodsName;
        this.price = new BigDecimal(price);
    }

    public String getGoodsName() {
        return goodsName;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
