package ua.iobradovuch.quiz.service;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Constraint(validatedBy = FieldMatchValidator.class)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldMatch {
    String message() default "";
    String first();
    String second();

    @Target( { ElementType.TYPE, ElementType.ANNOTATION_TYPE} )
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        FieldMatch[] value();
    }
}
