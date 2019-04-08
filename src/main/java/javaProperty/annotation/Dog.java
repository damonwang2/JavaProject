package javaProperty.annotation;

public class Dog {

    @Seven(value = "Lumia")
    private String name;
    
    private String Property;

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void say() {
        System.out.println("小狗:汪汪汪汪.....");
    }
    
    @Seven(Property = "水陆两栖战士")
    public void setProperty(String Property) {
        this.Property = Property;
    }

    public void getProperty() {
        System.out.println(this.Property);
    }
}
