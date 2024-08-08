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
@SequenceGenerator(name = "brand_id_seq", sequenceName = "brand_id_seq",allocationSize = 1)
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_id_seq")
   // Bu anotasyon, id alanının değerinin otomatik olarak sıralı bir sequence tarafından sağlanacağını belirtir. Bu, her yeni marka eklediğinizde id'nin otomatik olarak artmasını sağlar.
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
//Bu anotasyon, bir markanın birden fazla modelle ilişkilendirilebileceğini belirtir. mappedBy = "brand" ifadesi, ModelEntity sınıfındaki brand alanının bu ilişkiyi yönettiğini ve bu ilişkiyi brands tablosu üzerinden kurduğunu belirtir. Bu, bir markanın birden fazla model ile ilişkilendirilebileceği anlamına gelir.
    @OneToMany(mappedBy = "brand")
    private List<ModelEntity> models;
}
