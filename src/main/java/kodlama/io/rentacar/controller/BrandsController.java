package kodlama.io.rentacar.controller;

import jakarta.validation.Valid;
import kodlama.io.rentacar.dto.request.CreateBrandRequest;
import kodlama.io.rentacar.dto.request.UpdateBrandRequest;
import kodlama.io.rentacar.dto.response.GetAllBrandsResponse;
import kodlama.io.rentacar.dto.response.GetByIdBrandResponse;
import kodlama.io.rentacar.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {

    private final BrandService brandService;

    @GetMapping
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBrandRequest updateBrandRequest) {
        updateBrandRequest.setId(id); // Güncellenecek markanın ID'sini set etmek gerekebilir, bağlı olarak

        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }

}
