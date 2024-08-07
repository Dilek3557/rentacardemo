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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brands")
@SequenceGenerator(name = "brand_id_seq", sequenceName = "brand_id_seq")
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_id_seq")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<ModelEntity> models;
}
