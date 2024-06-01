package webService.Lakkam.Bag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bag")
public class BagController {

    @Autowired
    private BagService bagService;

    @PostMapping("/add")
    public Bag addProductToBag(@RequestParam Long personId, @RequestParam Long productId, @RequestParam int quantity) {
        return bagService.addProductToBag(personId, productId, quantity);
    }

    @GetMapping("/{personId}")
    public List<Bag> getBagByPerson(@PathVariable Long personId) {
        return bagService.getBagByPerson(personId);
    }
}