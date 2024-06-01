package webService.Lakkam.Bag;

import java.util.List;

public interface BagService {
    Bag addProductToBag(Long personId, Long productId, int quantity);
    List<Bag> getBagByPerson(Long personId);
}
