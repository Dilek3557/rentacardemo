package kodlama.io.rentacar.service;

import kodlama.io.rentacar.dto.request.CreateBrandRequest;
import kodlama.io.rentacar.dto.request.UpdateBrandRequest;
import kodlama.io.rentacar.dto.response.GetAllBrandsResponse;
import kodlama.io.rentacar.dto.response.GetByIdBrandResponse;
import kodlama.io.rentacar.entity.BrandEntity;
import kodlama.io.rentacar.exception.BusinessException;
import kodlama.io.rentacar.mapper.ModelMapperManager;
import kodlama.io.rentacar.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperManager modelMapperService;

    public List<GetAllBrandsResponse> getAll() {
        List<BrandEntity> brands = brandRepository.findAll();


        //iş kurallaır
        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponse;
    }

    public GetByIdBrandResponse getById(int id) {
        BrandEntity brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    public void add(CreateBrandRequest createBrandRequest) {
        if (this.brandRepository.existsByName(createBrandRequest.getName())) {
            throw new BusinessException("Brand name already exits");
        }
        BrandEntity brand = this.modelMapperService.forRequet().map(createBrandRequest, BrandEntity.class);
        this.brandRepository.save(brand);
    }

    public void update(UpdateBrandRequest updateBrandRequest) {

        BrandEntity brand = this.modelMapperService.forRequet().map(updateBrandRequest, BrandEntity.class);
        this.brandRepository.save(brand);
    }

    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
