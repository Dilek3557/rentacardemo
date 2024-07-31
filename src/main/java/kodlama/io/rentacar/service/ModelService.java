package kodlama.io.rentacar.service;

import kodlama.io.rentacar.dto.request.CreateModelRequest;
import kodlama.io.rentacar.dto.response.GetAllModelsResponse;
import kodlama.io.rentacar.entity.ModelEntity;
import kodlama.io.rentacar.mapper.ModelMapperManager;
import kodlama.io.rentacar.repository.ModelRepostitory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelService {
    private ModelRepostitory modelRepository;
    private ModelMapperManager modelMapperService;

    public List<GetAllModelsResponse> getAll() {
        List<ModelEntity> models = modelRepository.findAll();


        //iş kurallaır
        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponse;

    }

    public void add(CreateModelRequest createModelRequest) {
        ModelEntity model = this.modelMapperService.forRequet().map(createModelRequest, ModelEntity.class);

        this.modelRepository.save(model);
    }
}
