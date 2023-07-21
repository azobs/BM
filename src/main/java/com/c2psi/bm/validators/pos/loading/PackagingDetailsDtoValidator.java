package com.c2psi.bm.validators.pos.loading;

import com.c2psi.bm.dtos.pos.loading.PackagingDetailsDto;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class PackagingDetailsDtoValidator {
    public static List<String> validate(PackagingDetailsDto dto){
        List<String> errors = new ArrayList<>();
        if(!Optional.ofNullable(dto).isPresent()){
            errors.add("--Le parametre PackagingDetailsDto a valider ne peut etre null--");
        }
        else {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<PackagingDetailsDto>> constraintViolations = validator.validate(dto);

            if (constraintViolations.size() > 0) {
                for (ConstraintViolation<PackagingDetailsDto> contraintes : constraintViolations) {
                    errors.add(contraintes.getMessage());
                }
            }
        }
        return errors;
    }
}
