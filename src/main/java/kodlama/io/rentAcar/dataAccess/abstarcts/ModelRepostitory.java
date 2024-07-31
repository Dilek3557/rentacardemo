package kodlama.io.rentAcar.dataAccess.abstarcts;


import kodlama.io.rentAcar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepostitory  extends JpaRepository<Model, Integer> {
}
