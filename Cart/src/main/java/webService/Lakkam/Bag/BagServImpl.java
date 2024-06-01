package webService.Lakkam.Bag;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webService.Lakkam.Person.Person;
import webService.Lakkam.Person.PersonRepository;
import webService.Lakkam.Product.Product;
import webService.Lakkam.Product.ProductRepository;

import java.util.List;
@Service
public class BagServImpl implements BagService {

    private final BagRepository bagRepository;
    private final PersonRepository personRepository;
    private final ProductRepository productRepository;

    @Autowired
    public BagServImpl(BagRepository bagRepository, PersonRepository personRepository, ProductRepository productRepository) {
        this.bagRepository = bagRepository;
        this.personRepository = personRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Bag addProductToBag(Long personId, Long productId, int quantity) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new IllegalArgumentException("Person not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        Bag bag = new Bag(quantity, person, product);
        return bagRepository.save(bag);
    }

    public List<Bag> getBagByPerson(Long personId) {
        return bagRepository.findByPersonId(personId);
    }
}
