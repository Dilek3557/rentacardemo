package kodlama.io.rentAcar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentAcar.business.abstracts.BrandService;
import kodlama.io.rentAcar.business.requests.CreateBrandRequest;
import kodlama.io.rentAcar.business.requests.UpdateBrandRequest;
import kodlama.io.rentAcar.business.responses.GetAllBrandsResponse;


import kodlama.io.rentAcar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private   BrandService brandService;


    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
public void add(@RequestBody()@Valid() CreateBrandRequest createBrandRequest){
    this.brandService.add(createBrandRequest);

    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBrandRequest updateBrandRequest) {
        updateBrandRequest.setId(id); // Güncellenecek markanın ID'sini set etmek gerekebilir, bağlı olarak

        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
this.brandService.delete(id);
    }

}
