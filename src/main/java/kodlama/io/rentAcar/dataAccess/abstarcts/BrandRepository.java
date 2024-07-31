package kodlama.io.rentAcar.dataAccess.abstarcts;

import kodlama.io.rentAcar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BrandRepository  extends JpaRepository<Brand,Integer> {
    boolean existsByname(String name);

}
