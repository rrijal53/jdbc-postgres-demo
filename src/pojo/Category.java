package pojo;

public class Category {
    int id;
    String category;
    String image ;

    public Category() {
    }

    public Category(int id, String category, String image) {
        this.id = id;
        this.category = category;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return this.category;
    }
}
