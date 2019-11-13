package m19.exceptions;

/**
 * Class for representing a read error.
 */
public class NoSuchWorkIdException extends Exception {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201911132034L;

  private int _id;

  /**
   * Default constructor
   */
  public NoSuchWorkIdException(int id) {
    _id = id;
  }

  public int getId() {
      return _id;
  }

}