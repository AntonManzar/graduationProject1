package graduationProject.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "person_age")
    private int personAge;

    @Column(name = "person_email")
    private String personEmail;

    @Column(name = "person_role")
    private String personRole;

    @Column(name = "time_registration_person")
    private Date timeRegistrationPerson;

    @OneToMany(mappedBy = "orderOwner")
    private List<Order> orders;

    @OneToMany(mappedBy = "basketOwner")
    private List<Basket> basketList;

    public Person() {
    }

    public Person(String personName, int personAge, String personEmail, String personRole, Date timeRegistrationPerson) {
        this.personName = personName;
        this.personAge = personAge;
        this.personEmail = personEmail;
        this.personRole = personRole;
        this.timeRegistrationPerson = timeRegistrationPerson;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonRole() {
        return personRole;
    }

    public void setPersonRole(String personRole) {
        this.personRole = personRole;
    }

    public Date getTimeRegistrationPerson() {
        return timeRegistrationPerson;
    }

    public void setTimeRegistrationPerson(Date timeRegistrationPerson) {
        this.timeRegistrationPerson = timeRegistrationPerson;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Basket> getBasketList() {
        return basketList;
    }

    public void setBasketList(List<Basket> basketList) {
        this.basketList = basketList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", personAge=" + personAge +
                ", personEmail='" + personEmail + '\'' +
                ", personRole='" + personRole + '\'' +
                ", timeRegistrationPerson=" + timeRegistrationPerson +
                '}';
    }
}
