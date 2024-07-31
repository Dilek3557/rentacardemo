package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentacar.dataAccess.abstarcts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinesRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExits(String name) {
        if (this.brandRepository.existsByname(name)) {

            throw new ProblemDetails.BusinessException("Brand name already exits");

        }


    }


}
