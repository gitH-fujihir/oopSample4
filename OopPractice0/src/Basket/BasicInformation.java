package Basket;

import java.math.BigDecimal;
import java.util.Date;

public class BasicInformation {

    private String storeName = null;
    private String branchName = null;
    private Date purchaseTime = null;
    private BigDecimal paymentAmount = null;

    public BasicInformation(){
    }

    public BasicInformation(String storeName, String branchName, Date purchaseTime, String paymentAmount){
        setStoreName(storeName);
        setBranchName(branchName);
        setPurchaseTime(purchaseTime);
        setPaymentAmount(paymentAmount);
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
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
}
