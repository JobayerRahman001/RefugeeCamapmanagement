package cse213.refugeecampfinalproject.Admin;

public class RefugeeAllocationsAdminModel {
    private String refugeeID;
    private String money;
    private String foodWater;
    private String clothes;
    private  String shelter;

    public RefugeeAllocationsAdminModel(String refugeeID, String money, String foodWater, String clothes, String shelter) {
        this.refugeeID = refugeeID;
        this.money = money;
        this.foodWater = foodWater;
        this.clothes = clothes;
        this.shelter = shelter;
    }

    public String getRefugeeID() {
        return refugeeID;
    }

    public void setRefugeeID(String refugeeID) {
        this.refugeeID = refugeeID;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getFoodWater() {
        return foodWater;
    }

    public void setFoodWater(String foodWater) {
        this.foodWater = foodWater;
    }

    public String getClothes() {
        return clothes;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public String getShelter() {
        return shelter;
    }

    public void setShelter(String shelter) {
        this.shelter = shelter;
    }

    @Override
    public String toString() {
        return "RefugeeAllocationsAdminModel{" +
                "refugeeID='" + refugeeID + '\'' +
                ", money='" + money + '\'' +
                ", foodWater='" + foodWater + '\'' +
                ", clothes='" + clothes + '\'' +
                ", shelter='" + shelter + '\'' +
                '}';
    }
}
