package javaProperty.annotation;

import java.lang.reflect.Method;

public interface AOPMethod{
    void after(Object proxy, Method method, Object[] args);
    void before(Object proxy, Method method, Object[] args);
}
