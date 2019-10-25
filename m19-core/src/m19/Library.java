package m19;

import java.io.IOException;
import java.io.Serializable;

// FIXME import system types
// FIXME import project (core) types

import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.FailedToOpenFileException;
import m19.exceptions.ImportFileException;
import m19.exceptions.MissingFileAssociationException;

/**
 * Class that represents the library as a whole.
 */
public class Library implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201901101348L;

  // FIXME define attributes

  private int _day = 0;
  
  private Map<Integer, Work> _works = new HashMap<Integer, Work>();

  private Map<Integer, User> _users = new HashMap<Integer, User>();

  private Map<Integer, User> _suspended = new HashMap<Integer, User>();

  private int _userIdCounter = 0;
  private int _workIdCounter = 0;

  // FIXME define contructor(s)

  // FIXME define methods

  /**
   * Read the text input file at the beginning of the program and populates the
   * instances of the various possible types (books, DVDs, users).
   * 
   * @param filename
   *          name of the file to load
   * @throws BadEntrySpecificationException
   * @throws IOException
   */
  void importFile(String filename) throws BadEntrySpecificationException, IOException {
    // FIXME implement method
  }

}
