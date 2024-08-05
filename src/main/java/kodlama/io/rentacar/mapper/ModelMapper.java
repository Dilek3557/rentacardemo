package kodlama.io.rentacar.mapper;

import kodlama.io.rentacar.dto.request.CreateModelRequest;
import kodlama.io.rentacar.dto.response.GetAllModelsResponse;
import kodlama.io.rentacar.entity.ModelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    GetAllModelsResponse modelEntityToGetAllModelsResponse(ModelEntity entity);

    ModelEntity createModelRequestToModelEntity(CreateModelRequest request);
}
