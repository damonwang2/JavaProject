package javaProperty.annotation;

@AnnotationTest
public class Father {

    private String name;
    
    private String Property;

    public Father(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void say() {
        System.out.println("小狗:汪汪汪汪.....");
    }

    public void getProperty() {
        System.out.println(this.Property);
    }
}
