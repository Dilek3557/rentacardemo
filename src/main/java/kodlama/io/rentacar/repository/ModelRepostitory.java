package kodlama.io.rentacar.repository;


import kodlama.io.rentacar.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepostitory extends JpaRepository<ModelEntity, Integer> {
}
