package data.dto;

import data.enums.StoreData;

import java.math.BigDecimal;
import java.util.Date;

public class BasicInformation {

    private StoreData storeData = null;
    private Date purchaseTime = null;
    private BigDecimal paymentAmount = null;

    public BasicInformation(StoreData storeData,Date purchaseTime,String paymentAmount){
        setStoreData(storeData);
        setPurchaseTime(purchaseTime);
        setPaymentAmount(paymentAmount);
    }

    public StoreData getStoreData() {
        return storeData;
    }

    public void setStoreData(StoreData storeData) {
        this.storeData = storeData;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = new BigDecimal(paymentAmount);
    }

    public String getStoreName() {
        return storeData.getName();
    }

    public String getBranchName() {
        return storeData.getBranchName();
    }

    public String getPhoneNumber() {
        return storeData.getPhoneNumber();
    }

    public String getAddress() {
        return storeData.getAddress();
    }


}
