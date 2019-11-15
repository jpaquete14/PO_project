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
import m19.exceptions.NoSuchWorkIdException;
import m19.exceptions.NoSuchUserIdException;
import m19.exceptions.NoSuchWorkIdException;

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
    _date += days;
    //FIXME update deadlines
  }
  
  public void registerUser(String name, String email) {
    _userIdCounter++;
    User user = new User(_userIdCounter, name, email);
    _users.put(_userIdCounter, user);
  }

  public String showUser(int id) throws NoSuchUserIdException {
    if(!_users.containsKey(id)) {
      throw new NoSuchUserIdException(id);
    }
    User user = _users.get(id);
    return user.toString();
  }

  public String showUsers() {
    String users = "";
    for(User u: _users.values()) {
      users += u.toString();
    }
    return users;
  }

  public String showWork(int id) throws NoSuchWorkIdException {
    if(!_works.containsKey(id)) {
      throw new NoSuchWorkIdException(id);
    }
    Work work = _works.get(id);
    return work.toString();
  }

  public String showWorks() {
    String works = "";
    for(Work w: _works.values()) {
      works += w.toString();
    }
    return works;
  }

  public void addUser(String name, String email) throws BadEntrySpecificationException {
    if(email.contains(" ")) {
      throw new BadEntrySpecificationException(email);
    }
    _userIdCounter++;
    User user = new User(_userIdCounter, name, email);
    _users.put(_userIdCounter, user);
  }

  public void addDVD(String title, String director, int price, String category, int IGAC, int copiesLeft) {
    _workIdCounter++;
    DVD dvd = new DVD(_workIdCounter, title, director, price, category, IGAC, copiesLeft);
    _works.put(_workIdCounter, dvd);
  }

  public void addBook(String title, String author, int price, String category, int ISBN, int copiesLeft) {
    _workIdCounter++;
    Book book = new Book(_workIdCounter, title, author, price, category, ISBN, copiesLeft);
    _works.put(_workIdCounter, book);
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
      while((s = in.readLine()) != null) {
        line++;
        String[] split = s.split(":");
        if (split[0].equals("USER")) {
          //name, email
          this.addUser(split[1], split[2]);
        }
        else if (split[0].equals("DVD")) {
          //title, director, price, category, IGAC, copiesLeft
          this.addDVD(split[1], split[2], Integer.parseInt(split[3]), split[4], Integer.parseInt(split[5]), Integer.parseInt(split[6]));
        }
        else if (split[1].equals("BOOK")) {
          //title, author, price, category, ISBN, copiesLeft
          this.addBook(split[1], split[2], Integer.parseInt(split[3]), split[4], Integer.parseInt(split[5]), Integer.parseInt(split[6]));
        }
      }
      in.close();
    } catch (BadEntrySpecificationException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + filename + ": " + e);
    } catch (IOException e) {
      System.out.println("IO error: " + filename + ": " + line + ": line " + e);
    }
  }
}
