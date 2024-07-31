package kodlama.io.rentacar.dataAccess.abstarcts;

import kodlama.io.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByname(String name);

}
