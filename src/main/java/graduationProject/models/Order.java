package graduationProject.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "time_created_order")
    private Date timeCreatedOrder;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person orderOwner;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> ordersProduct;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getTimeCreatedOrder() {
        return timeCreatedOrder;
    }

    public void setTimeCreatedOrder(Date timeCreatedOrder) {
        this.timeCreatedOrder = timeCreatedOrder;
    }

    public Person getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(Person orderOwner) {
        this.orderOwner = orderOwner;
    }

    public List<OrderProduct> getOrdersProduct() {
        return ordersProduct;
    }

    public void setOrdersProduct(List<OrderProduct> ordersProduct) {
        this.ordersProduct = ordersProduct;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", timeCreatedOrder=" + timeCreatedOrder +
                ", orderOwner=" + orderOwner +
                '}';
    }
}
