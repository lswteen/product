package kr.co.renzo.core.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<EnumValid, String> {
    private EnumValid annotation;

    @Override
    public void initialize(EnumValid annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(String valueForValidation, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;

        Object[] enumValues = this.annotation.enumClass().getEnumConstants();

        if (enumValues != null) {
            for (Object enumValue : enumValues) {
                if (hasEnumValue(valueForValidation, enumValue, this.annotation.ignoreCase())) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    private boolean hasEnumValue(String valueForValidation, Object enumValue, boolean ignoreCase) {
        return valueForValidation == null
                || valueForValidation.equals(enumValue.toString())
                || (ignoreCase && valueForValidation.equalsIgnoreCase(enumValue.toString()));
    }
}
