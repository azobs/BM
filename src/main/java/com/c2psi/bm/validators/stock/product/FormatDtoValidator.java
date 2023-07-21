package com.c2psi.bm.validators.stock.product;

import com.c2psi.bm.dtos.stock.product.FormatDto;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class FormatDtoValidator {
    public static List<String> validate(FormatDto dto){
        List<String> errors = new ArrayList<>();
        if(!Optional.ofNullable(dto).isPresent()){
            errors.add("--Le parametre FormatDto a valider ne peut etre null--");
        }
        else {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<FormatDto>> constraintViolations = validator.validate(dto);

            if (constraintViolations.size() > 0) {
                for (ConstraintViolation<FormatDto> contraintes : constraintViolations) {
                    errors.add(contraintes.getMessage());
                }
            }
        }
        return errors;
    }
}
