package model.zoo;

public abstract class Tableware {
    protected int foodQuantity;

    public void increaseFoodQuantity(int addingQuantity) {
        foodQuantity += addingQuantity;
    }

    public boolean decreaseFoodQuantity(int consumingQuantity) {
        if (foodQuantity < consumingQuantity) return false;
        else {
            foodQuantity -= consumingQuantity;
            return true;
        }
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }
}