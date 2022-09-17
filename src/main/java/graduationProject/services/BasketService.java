package graduationProject.services;

import graduationProject.models.Basket;
import graduationProject.models.Person;
import graduationProject.models.Product;
import graduationProject.repositories.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BasketService {

    private final BasketRepository basketRepository;

    @Autowired
    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public List<Basket> showBasketWithProducts(Person person) {
        return basketRepository.findByBasketOwner(person);
    }
}
