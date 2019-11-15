package m19;

public class Book extends Work {

    private static final long serialVersionUID = 201911131812L;

    private String _author;

    private int _ISBN;

    public Book(int id,String title, String author, int price, String category, int ISBN, int copiesLeft) {
        super(id, copiesLeft, title, price, category);
        _author = author;
        _ISBN = ISBN;
    }

    public String getAuthor() {
        return _author;
    }

    public int getISBN() {
        return _ISBN;
    }

    @Override
    public String toString() {
        return this.getId() + " - " + this.getCopiesLeft() + " - Livro - " + this.getTitle() + " - " + this.getPrice() + " - " + this.getCategory() + " - " + this.getAuthor() + " - " + this.getISBN() + "\n";
    }

}