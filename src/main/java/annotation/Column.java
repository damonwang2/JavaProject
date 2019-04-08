package annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {
    String name() default "fieldName";
    String setFuncName() default "setField";
    String getFuncName() default "getField";
    boolean defaultDBValue() default false;
}