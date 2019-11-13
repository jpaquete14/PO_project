package m19.exceptions;

/**
 * Class for representing a read error.
 */
public class NoSuchUserIdException extends Exception {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201911132032L;

  private int _id;

  /**
   * Default constructor
   */
  public NoSuchUserIdException(int id) {
    _id = id;
  }

  public int getId() {
      return _id;
  }

}