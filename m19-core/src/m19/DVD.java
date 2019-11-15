package m19;

public class DVD extends Work {

    private static final long serialVersionUID = 201911131810L;

    private String _director;

    private int _IGAC;

    public DVD(int id, String title, String director, int price, String category, int IGAC, int copiesLeft) { 
        super(id, copiesLeft, title, price, category);
        _director = director;
        _IGAC = IGAC;
    }

    public String getDirector() {
        return _director;
    }

    public int getIGAC() {
        return _IGAC;
    }

    @Override
    public String toString() {
        return this.getId() + " - " + this.getCopiesLeft() + " - DVD - " + this.getTitle() + " - " + this.getPrice() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getIGAC() + "\n";
    }

}