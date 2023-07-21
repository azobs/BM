package com.c2psi.bm.validators.stock.price;

import com.c2psi.bm.dtos.stock.price.CurrencyConversionDto;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CurrencyConversionDtoValidator {
    public static List<String> validate(CurrencyConversionDto dto){
        List<String> errors = new ArrayList<>();
        if(!Optional.ofNullable(dto).isPresent()){
            errors.add("--Le parametre CurrencyConversionDto a valider ne peut etre null--");
        }
        else {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<CurrencyConversionDto>> constraintViolations = validator.validate(dto);

            if (constraintViolations.size() > 0) {
                for (ConstraintViolation<CurrencyConversionDto> contraintes : constraintViolations) {
                    errors.add(contraintes.getMessage());
                }
            }
        }
        return errors;
    }
}
