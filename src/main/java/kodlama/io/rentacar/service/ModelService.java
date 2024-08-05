package kodlama.io.rentacar.service;

import kodlama.io.rentacar.dto.request.CreateModelRequest;
import kodlama.io.rentacar.dto.response.GetAllModelsResponse;
import kodlama.io.rentacar.entity.ModelEntity;
import kodlama.io.rentacar.mapper.ModelMapper;
import kodlama.io.rentacar.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public List<GetAllModelsResponse> getAll() {
        List<ModelEntity> models = modelRepository.findAll();

        // İş kurallarını uygulayarak dönüşüm yapın
        return models.stream()
                .map(modelMapper::modelEntityToGetAllModelsResponse)
                .collect(Collectors.toList());
    }

    public void add(CreateModelRequest createModelRequest) {
        ModelEntity model = modelMapper.createModelRequestToModelEntity(createModelRequest);
        modelRepository.save(model);
    }
}
