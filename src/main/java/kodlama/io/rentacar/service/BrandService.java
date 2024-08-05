package kodlama.io.rentacar.service;

import kodlama.io.rentacar.dto.request.CreateBrandRequest;
import kodlama.io.rentacar.dto.request.UpdateBrandRequest;
import kodlama.io.rentacar.dto.response.GetAllBrandsResponse;
import kodlama.io.rentacar.dto.response.GetByIdBrandResponse;
import kodlama.io.rentacar.entity.BrandEntity;
import kodlama.io.rentacar.exception.BusinessException;
import kodlama.io.rentacar.mapper.BrandMapper;
import kodlama.io.rentacar.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public List<GetAllBrandsResponse> getAll() {
        List<BrandEntity> brands = brandRepository.findAll();

        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brandMapper::brandEntityToGetAllBrandsResponse)
                .collect(Collectors.toList());
        return brandsResponse;
    }

    public GetByIdBrandResponse getById(int id) {
        BrandEntity brand = this.brandRepository.findById(id).orElseThrow();
        return brandMapper.brandEntityToGetByIdBrandResponse(brand);
    }

    public void add(CreateBrandRequest createBrandRequest) {
        if (this.brandRepository.existsByName(createBrandRequest.getName())) {
            throw new BusinessException("Brand name already exists");
        }
        BrandEntity brand = brandMapper.createBrandRequestToBrandEntity(createBrandRequest);
        this.brandRepository.save(brand);
    }

    public void update(UpdateBrandRequest updateBrandRequest) {
        BrandEntity brand = brandMapper.updateBrandRequestToBrandEntity(updateBrandRequest);
        this.brandRepository.save(brand);
    }

    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
