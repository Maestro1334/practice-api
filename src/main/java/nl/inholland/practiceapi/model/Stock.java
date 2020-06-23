package nl.inholland.practiceapi.model;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue
    private long id;
    private int quantity;

    @OneToOne(cascade = CascadeType.REMOVE)
    private GPU gpu;

    public Stock() {
    }

    public Stock(int quantity, GPU gpu) {
        this.quantity = quantity;
        this.gpu = gpu;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Stock{");
        sb.append("id=").append(id);
        sb.append(", quantity=").append(quantity);
        sb.append(", gpu=").append(gpu);
        sb.append('}');
        return sb.toString();
    }
}
