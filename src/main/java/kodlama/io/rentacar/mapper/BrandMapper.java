package kodlama.io.rentacar.mapper;

import kodlama.io.rentacar.dto.request.CreateBrandRequest;
import kodlama.io.rentacar.dto.request.UpdateBrandRequest;
import kodlama.io.rentacar.dto.response.GetAllBrandsResponse;
import kodlama.io.rentacar.dto.response.GetByIdBrandResponse;
import kodlama.io.rentacar.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")  // Bu satırı ekleyin
public interface BrandMapper {

    @Mapping(source = "name", target = "name")
    BrandEntity createBrandRequestToBrandEntity(CreateBrandRequest request);
//CreateBrandRequest nesnesini BrandEntity nesnesine dönüştürür. Bu işlem genellikle yeni bir marka oluşturulurken kullanılır.
    @Mapping(source = "name", target = "name")
    BrandEntity updateBrandRequestToBrandEntity(UpdateBrandRequest request);

    GetAllBrandsResponse brandEntityToGetAllBrandsResponse(BrandEntity entity);
//Entity'den DTO'ya Dönüşüm:
//brandEntityToGetAllBrandsResponse(BrandEntity entity): BrandEntity nesnesini GetAllBrandsResponse nesnesine dönüştürür. Bu dönüşüm, markaların listelendiği yanıtları oluşturmak için kullanılır.
    GetByIdBrandResponse brandEntityToGetByIdBrandResponse(BrandEntity entity);
}
/*BrandMapper sınıfı, CreateBrandRequest, UpdateBrandRequest, GetAllBrandsResponse,
 GetByIdBrandResponse gibi DTO'lar ile BrandEntity gibi veri tabanı varlıkları arasında veri dönüşüm
 işlemlerini kolaylaştırır. Bu dönüşüm işlemleri, API'nin farklı katmanları arasında veri aktarımını standart
ve hatasız bir şekilde yapmanıza olanak tanır.
 */

