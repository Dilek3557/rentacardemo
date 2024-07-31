package kodlama.io.rentacar.repository;


import kodlama.io.rentacar.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepostitory extends JpaRepository<ModelEntity, Integer> {
}
