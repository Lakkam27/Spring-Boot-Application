package webService.Lakkam.Bag;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BagRepository extends JpaRepository<Bag,Long> {
    List<Bag> findByPersonId(Long personId);
}
