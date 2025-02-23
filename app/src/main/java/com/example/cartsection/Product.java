package com.example.cartsection;

public class Product {
    private String name;
    private int quantity;
    private boolean isSelected;  // New field for selection

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.isSelected = false;  // Default to unselected
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
