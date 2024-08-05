package kodlama.io.rentacar.mapper;

import kodlama.io.rentacar.dto.request.CreateBrandRequest;
import kodlama.io.rentacar.dto.request.UpdateBrandRequest;
import kodlama.io.rentacar.dto.response.GetAllBrandsResponse;
import kodlama.io.rentacar.dto.response.GetByIdBrandResponse;
import kodlama.io.rentacar.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")  // Bu satırı ekleyin

public interface BrandMapper {

    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    @Mapping(source = "name", target = "name")
    BrandEntity createBrandRequestToBrandEntity(CreateBrandRequest request);

    @Mapping(source = "name", target = "name")
    BrandEntity updateBrandRequestToBrandEntity(UpdateBrandRequest request);

    GetAllBrandsResponse brandEntityToGetAllBrandsResponse(BrandEntity entity);

    GetByIdBrandResponse brandEntityToGetByIdBrandResponse(BrandEntity entity);
}
