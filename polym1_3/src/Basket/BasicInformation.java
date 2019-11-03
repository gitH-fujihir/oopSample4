package Basket;

import java.math.BigDecimal;
import java.util.Date;

public class BasicInformation {

    private String storeName = null;
    private String branchName = null;
    private Date purchaseTime = null;
    private BigDecimal paymentAmount = null;

    //追加
    private String phoneNumber = null;
    private String address = null;

    public BasicInformation(String storeName, String branchName, Date purchaseTime, String paymentAmount,String phoneNumber,String address){
        setStoreName(storeName);
        setBranchName(branchName);
        setPurchaseTime(purchaseTime);
        setPaymentAmount(paymentAmount);
        setPhoneNumber(phoneNumber);
        setAddress(address);
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
