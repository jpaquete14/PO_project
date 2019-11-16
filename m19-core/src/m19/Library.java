package m19;

import java.io.FileNotFoundException;

// FIXME import system types

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
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
  
  public int registerUser(String name, String email) {
    User user = new User(_userIdCounter, name, email);
    _users.put(_userIdCounter, user);
    _userIdCounter++;
    return user.getId();
  }

  public String showUser(int id) throws NoSuchUserIdException {
    if(!_users.containsKey(id)) {
      throw new NoSuchUserIdException(id);
    }
    User user = _users.get(id);
    return user.toString();
  }

  public String showUsers() {
    int i = 0, j;
    String users = "";
    User[] sortedByNames =  new User[_users.size()];
    for (Map.Entry<Integer, User> entry : _users.entrySet()) {
      sortedByNames[i] = entry.getValue();
      i++;
    }
    for(i = 0; i < _users.size() - 1; ++i) {
      for (j = i + 1; j < _users.size(); ++j) {
         if (sortedByNames[i].getName().compareTo(sortedByNames[j].getName()) > 0) {
            User temp = sortedByNames[i];
            sortedByNames[i] = sortedByNames[j];
            sortedByNames[j] = temp;
         }
      }
    }
    for(User u: sortedByNames) {
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
    User user = new User(_userIdCounter, name, email);
    _users.put(_userIdCounter, user);
    _userIdCounter++;
  }

  public void addDVD(String title, String director, int price, String category, int IGAC, int copies) {
    if(category.compareTo("FICTION") == 0) category = "Ficção";
    else if(category.compareTo("SCITECH") == 0) category = "Técnica e Científica";
    else if(category.compareTo("REFERENCE") == 0) category = "Referência";
    DVD dvd = new DVD(_workIdCounter, title, director, price, category, IGAC, copies);
    _works.put(_workIdCounter, dvd);
    _workIdCounter++;
  }

  public void addBook(String title, String author, int price, String category, int ISBN, int copies) {
    if(category.compareTo("FICTION") == 0) category = "Ficção";
    else if(category.compareTo("SCITECH") == 0) category = "Técnica e Científica";
    else if(category.compareTo("REFERENCE") == 0) category = "Referência";
    Book book = new Book(_workIdCounter, title, author, price, category, ISBN, copies);
    _works.put(_workIdCounter, book);
    _workIdCounter++;
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
          //title, director, price, category, IGAC, copies
          this.addDVD(split[1], split[2], Integer.parseInt(split[3]), split[4], Integer.parseInt(split[5]), Integer.parseInt(split[6]));
        }
        else if (split[0].equals("BOOK")) {
          //title, author, price, category, ISBN, copies
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

  /*public class TreeMapSortByValue {
    private static Map<Integer, User> map;

    public static void main(String args[]) {

      // Declaring a TreeMap of String keys and String values
      TreeMap<String, String> treemap = new TreeMap<String, String>();
      // Add Key-Value pairs to TreeMap
      treemap.put("Key1", "Pear");
      treemap.put("Key2", "Apple");
      treemap.put("Key3", "Orange");
      treemap.put("Key4", "Papaya");
      treemap.put("Key5", "Banana");

      // sort treemap by values
      Map sortedMap = sortByValues(treemap);
      // Get Set of entries
      Set set = sortedMap.entrySet();
      // Get iterator
      Iterator it = set.iterator();
      // Show TreeMap elements
      System.out.println("TreeMap contains: ");
      while (it.hasNext()) {
        Map.Entry pair = (Map.Entry) it.next();
        System.out.print("Key is: " + pair.getKey() + " and ");
        System.out.println("Value is: " + pair.getValue());
      }
    }

    public static <Integer, User extends Comparable<User>> Map<Integer, User> sortByName(final Map<Integer, User> map) {
      TreeMapSortByValue.map = map;
      Comparator<Integer> nameComparator = new Comparator<Integer>() {
      public int compare(int id1, int id2) {
        int compare = map.get(id1.getName()).compareTo(map.get(id2.getName()));
        if (compare == 0) 
          return 1;
        else 
          return compare;
      }
    };
    Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
    sortedByValues.putAll(map);
    return sortedByValues;
    }
  }
}*/
