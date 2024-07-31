package kodlama.io.rentAcar.business.abstracts;
import kodlama.io.rentAcar.business.requests.CreateModelRequest;
import kodlama.io.rentAcar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
  List<GetAllModelsResponse> getAll();
  void add(CreateModelRequest createModelRequest );
}

