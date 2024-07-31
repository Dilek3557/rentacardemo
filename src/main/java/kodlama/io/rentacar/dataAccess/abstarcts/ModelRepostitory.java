package kodlama.io.rentacar.dataAccess.abstarcts;


import kodlama.io.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepostitory extends JpaRepository<Model, Integer> {
}
