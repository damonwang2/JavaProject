package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;

@Inherited
@Documented
public @interface Greeting {
    enum FontColor{BLUE, RED, GREEN}
    String name();
    FontColor fontColor() default FontColor.GREEN;
}
