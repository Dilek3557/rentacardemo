package kodlama.io.rentAcar.business.concretes;

import kodlama.io.rentAcar.business.abstracts.BrandService;
import kodlama.io.rentAcar.business.requests.CreateBrandRequest;
import kodlama.io.rentAcar.business.requests.UpdateBrandRequest;
import kodlama.io.rentAcar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentAcar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentAcar.business.rules.BrandBusinesRules;
import kodlama.io.rentAcar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentAcar.dataAccess.abstarcts.BrandRepository;
import kodlama.io.rentAcar.entities.concretes.Brand;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;



import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
//bus ınıf business nesnesi

public class BrandManager implements BrandService {
    private   BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
   private BrandBusinesRules brandBusinesRules;

     @Override
    public List<GetAllBrandsResponse> getAll() {
    List<Brand> brands = brandRepository.findAll();


         //iş kurallaır
         List<GetAllBrandsResponse> brandsResponse=brands.stream()
                 .map(brand->this.modelMapperService.forResponse()
                         .map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
     Brand brand=this.brandRepository.findById(id).orElseThrow();
     GetByIdBrandResponse response=this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
         this.brandBusinesRules.checkIfBrandNameExits(createBrandRequest.getName());
    Brand brand =this.modelMapperService.forRequet().map(createBrandRequest,Brand.class);


        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {

        Brand brand =this.modelMapperService.forRequet().map(updateBrandRequest,Brand.class);
this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
this.brandRepository.deleteById(id);
    }
}
