package data.enums;

public enum StoreData {
    KIRITAN_SENDAI("　　　　きりたんストア","仙台支店","",""),
    YUKARI("　　　　　ゆかりショップ","","",""),
    MAKI_TOKYO("　　　　　マキマキマーケット","東京支店","03-0000-0000","東京都千代田区××０丁目");

    private String name;
    private String branchName;
    private String phoneNumber;
    private String address;

    StoreData(String name, String branchName, String phoneNumber, String address){
        this.name = name;
        this.branchName = branchName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName(){
        return this.name;
    }

    public String getBranchName(){
        return this.branchName;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getAddress(){
        return this.address;
    }
}
