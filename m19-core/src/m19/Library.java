package m19;

import java.io.FileNotFoundException;

// FIXME import system types

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import java.io.BufferedReader;
import java.io.FileReader;

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

  private int _date = 0;
  
  private Map<Integer, Work> _works = new TreeMap<Integer, Work>();

  private Map<Integer, User> _users = new TreeMap<Integer, User>();

  private Map<Integer, User> _suspended = new TreeMap<Integer, User>();

  private int _userIdCounter = 0;
  private int _workIdCounter = 0;

  // FIXME define contructor(s)

  // FIXME define methods
  
  public int getDate() {
    return _date;
  }

  public void advanceDate(int days) {
    _date = _date + days;
    //FIXME update deadlines
  }
  
  public void registerUser(String name, String email) throws DuplicateEmailException {
    if( duplicateEmail(_users, email) ) {
      throw new DuplicateEmailException();
    }
    User user = new User(_userIdCounter, name, email);
    _users.put(_userIdCounter, user);
  }

  public boolean duplicateEmail( Map<Integer, User> users, String email) {
    //FIXME implement
    return false;
  }

  public String showUser(int id) {
    User user = _users.get(id);
  }
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
    int line = 0;
    try {
      BufferedReader in = new BufferedReader(new FileReader(filename));
      String s;
      while((s = in.readline()) != null) {
        line++;
        String[] split = s.split(":");
        if (split[0].equals("USER")) {
          try {
            this.addUser(split[1], split[2]);
          } catch (DuplicateUserException e){
            System.err.println(e);
          }
        }
      }
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + filename + ": " + e);
    } catch (IOException e) {
      System.out.println("IO error: " + filename + ": " + line + ": line " + e);
    }
  }

  public void addUser(String name, String email) {
    _userIdCounter++;
    User user = new User(_userIdCounter, name, email);
    _users.put(_userIdCounter, user);
  }
}
