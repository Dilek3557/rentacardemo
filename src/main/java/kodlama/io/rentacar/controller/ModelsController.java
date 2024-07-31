package kodlama.io.rentacar.controller;

import jakarta.validation.Valid;
import kodlama.io.rentacar.dto.request.CreateModelRequest;
import kodlama.io.rentacar.dto.response.GetAllModelsResponse;
import kodlama.io.rentacar.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/models")
public class ModelsController {

    private final ModelService modelService;

    @GetMapping
    public List<GetAllModelsResponse> getAll() {
        return modelService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest) {
        this.modelService.add(createModelRequest);
    }
}
