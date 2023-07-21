package com.c2psi.bm.validators.client.command;

import com.c2psi.bm.dtos.client.command.BackInDetailsDto;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class BackInDetailsDtoValidator {
    public static List<String> validate(BackInDetailsDto dto){
        List<String> errors = new ArrayList<>();
        if(!Optional.ofNullable(dto).isPresent()){
            errors.add("--Le parametre BackInDetailsDto a valider ne peut etre null--");
        }
        else {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<BackInDetailsDto>> constraintViolations = validator.validate(dto);

            if (constraintViolations.size() > 0) {
                for (ConstraintViolation<BackInDetailsDto> contraintes : constraintViolations) {
                    errors.add(contraintes.getMessage());
                }
            }
        }
        return errors;
    }
}
