package kodlama.io.rentacar.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "models")
@SequenceGenerator(name = "model_id_seq",sequenceName = "model_id_seq")
public class ModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_id_seq")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;
    @OneToMany(mappedBy = "model")
    private List<CarEntity> cars;
}