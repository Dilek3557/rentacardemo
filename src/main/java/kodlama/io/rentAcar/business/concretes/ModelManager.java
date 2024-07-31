package kodlama.io.rentAcar.business.concretes;

import kodlama.io.rentAcar.business.abstracts.ModelService;
import kodlama.io.rentAcar.business.requests.CreateModelRequest;
import kodlama.io.rentAcar.business.responses.GetAllModelsResponse;
import kodlama.io.rentAcar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentAcar.dataAccess.abstarcts.ModelRepostitory;


import kodlama.io.rentAcar.entities.concretes.Model;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepostitory modelRepository;
    private ModelMapperService modelMapperService;

@Override
    public List<GetAllModelsResponse> getAll(){
        List<Model> models= modelRepository.findAll();


        //iş kurallaır
        List<GetAllModelsResponse> modelsResponse=models.stream()
                .map(model->this.modelMapperService.forResponse()
                        .map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponse;

    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model=this.modelMapperService.forRequet().map(createModelRequest,Model.class);
       
        this.modelRepository.save(model);
    }
}
