package cse213.refugeecampfinalproject.ResourceManager;

public class ResourcesDistributeRationsModel {
    private String food;
    private String water;

    public ResourcesDistributeRationsModel(String food, String water) {
        this.food = food;
        this.water = water;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    @Override
    public String toString() {
        return "ResourcesDistributeRationsModel{" +
                "food='" + food + '\'' +
                ", water='" + water + '\'' +
                '}';
    }
}

