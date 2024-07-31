package kodlama.io.rentacar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "plate", unique = true)
    private String plate;

    @Column(name = "dailyprice")
    private double dailyprice;

    @Column(name = "modelYear")
    private int modelYear;


    @Column(name = "state")
    private int state;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private ModelEntity model;

}
