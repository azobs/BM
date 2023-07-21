package com.c2psi.bm.validators.stock.product;

import com.c2psi.bm.dtos.stock.product.ArticleDto;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ArticleDtoValidator {
    public static List<String> validate(ArticleDto artDto){
        List<String> errors = new ArrayList<>();
        if(!Optional.ofNullable(artDto).isPresent()){
            errors.add("--Le parametre articledto a valider ne peut etre null--");
        }
        else {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<ArticleDto>> constraintViolations = validator.validate(artDto);

            if (constraintViolations.size() > 0) {
                for (ConstraintViolation<ArticleDto> contraintes : constraintViolations) {
                    errors.add(contraintes.getMessage());
                }
            }
        }
        return errors;
    }
}
