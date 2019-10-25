package m19;

public abstract class Work extends Serializable {

    //Class attributes
    private static final long serialVersionUID = 202608231520L;

    private int _id;

    private int _copiesLeft;

    private String _title;

    private int _price;

    private WorkCategory _category;


    public Work(int id, int copiesLeft, String title, int price, WorkCategory category) {
        _id = id;
        _copiesLeft = copiesLeft;
        _title = title;
        _price = price;
        _category = category;
    }

    public int getId() {
        return _id;
    }

    public int getCopiesLeft() {
        return _copiesLeft;
    }

    public void setCopiesLeft(int copiesLeft) {
        _copiesLeft = copiesLeft;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public int getPrice() {
        return _price;
    }

    public void setPrice() {
        _price = price;
    }

    public Category setCategory() {
        return _category;
    }

}