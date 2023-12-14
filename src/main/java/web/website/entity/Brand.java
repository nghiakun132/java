package web.website.entity;

public class Brand {
    private int id;
    private String name;

    public Brand() {
    }

    public Brand(int id) {
        this.id = id;
    }

    public Brand(String name) {
        this.name = name;
    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand(Brand brand) {
        this.id = brand.id;
        this.name = brand.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
