package graduationProject.models;

import javax.persistence.*;

@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @Column(name = "basket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basketId;

    @Column(name = "basket_amount")
    private int basketAmount;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person basketOwner;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    public Basket() {
    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public int getBasketAmount() {
        return basketAmount;
    }

    public void setBasketAmount(int basketAmount) {
        this.basketAmount = basketAmount;
    }

    public Person getBasketOwner() {
        return basketOwner;
    }

    public void setBasketOwner(Person basketOwner) {
        this.basketOwner = basketOwner;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basketId=" + basketId +
                ", basketAmount=" + basketAmount +
                ", basketOwner=" + basketOwner +
                ", product=" + product +
                '}';
    }
}
