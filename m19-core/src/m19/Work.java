package m19;

import java.io.Serializable;

public abstract class Work implements Serializable {

    //Class attributes
    private static final long serialVersionUID = 202608231520L;

    private int _id;

    private int _copies;

    private int _copiesLeft;

    private String _title;

    private int _price;

    private String _category;


    public Work(int id, int copies, String title, int price, String category) {
        _id = id;
        _copies = copies;
        _copiesLeft = _copies;
        _title = title;
        _price = price;
        _category = category;
    }

    public int getId() {
        return _id;
    }

    public int getCopies() {
        return _copies;
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

    public void setPrice(int price) {
        _price = price;
    }

    public String getCategory() {
        return _category;
    }

}