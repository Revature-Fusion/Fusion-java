package models;

import java.util.Objects;

public class OrderDetails {

    private int oDID;    // Order Detail ID

    private int oID;    // Order ID

    private int pID;    // Product ID

    private int quantity; // Quantity

    public OrderDetails(){}

    public OrderDetails(int oDID, int oID, int pID, int quantity) {
        this.oDID = oDID;
        this.oID = oID;
        this.pID = pID;
        this.quantity = quantity;
    }

    public int getoDID() {
        return oDID;
    }

    public void setoDID(int oDID) {
        this.oDID = oDID;
    }

    public int getoID() {
        return oID;
    }

    public void setoID(int oID) {
        this.oID = oID;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return oDID == that.oDID && oID == that.oID && pID == that.pID && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(oDID, oID, pID, quantity);
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "oDID=" + oDID +
                ", oID=" + oID +
                ", pID=" + pID +
                ", quantity=" + quantity +
                '}';
    }

}
