package kodlama.io.rentAcar.business.rules;

import kodlama.io.rentAcar.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentAcar.dataAccess.abstarcts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinesRules {
    private   BrandRepository brandRepository;

    public void  checkIfBrandNameExits(String name){
if (this.brandRepository.existsByname(name)) {

    throw new ProblemDetails.BusinessException("Brand name already exits");

}


}


}
