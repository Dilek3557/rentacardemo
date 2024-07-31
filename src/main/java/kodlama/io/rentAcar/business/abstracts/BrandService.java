package kodlama.io.rentAcar.business.abstracts;

import kodlama.io.rentAcar.business.requests.CreateBrandRequest;
import kodlama.io.rentAcar.business.requests.UpdateBrandRequest;
import kodlama.io.rentAcar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentAcar.business.responses.GetByIdBrandResponse;


import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse>  getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
