package graduationProject.repositories;

import graduationProject.models.Basket;
import graduationProject.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {

    List<Basket> findByBasketOwner(Person basketOwner);
}
