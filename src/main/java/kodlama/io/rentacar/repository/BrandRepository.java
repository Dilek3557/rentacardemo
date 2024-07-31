package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {

    boolean existsByName(String name);

}
