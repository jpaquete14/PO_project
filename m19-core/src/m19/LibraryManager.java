package m19;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
// FIXME import system types
// FIXME import project (core) types

import m19.exceptions.BadEntrySpecificationException;
import m19.exceptions.FailedToOpenFileException;
import m19.exceptions.ImportFileException;
import m19.exceptions.MissingFileAssociationException;
import m19.exceptions.NoSuchUserIdException;
import m19.exceptions.NoSuchWorkIdException;


/**
 * The façade class.
 */
public class LibraryManager {

  private Library _library = new Library();  // FIXME initialize this attribute

  // FIXME define other attributes
  private String _filename;
  
  // FIXME define contructor(s)
  
  // FIXME define methods

  public String getFile() {
    return _filename;
  }

  public int getDate() {
    return _library.getDate();
  }

  public void advanceDate(int days) {
    _library.advanceDate(days);
  }

  public int registerUser(String name, String email) {
    return _library.registerUser(name, email);
  }

  public String showUser(int id) throws NoSuchUserIdException {
    return _library.showUser(id);
  }

  public String showUsers() {
    return _library.showUsers();
  }

  public String showWork (int id) throws NoSuchWorkIdException {
    return _library.showWork(id);
  }

  public String showWorks() {
    return _library.showWorks();
  }

  /**
   * @throws MissingFileAssociationException
   * @throws IOException
   * @throws FileNotFoundException
   */
  public void save() throws MissingFileAssociationException, IOException {
    if(_filename == null) {
      throw new MissingFileAssociationException();
    }
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(_filename)));
    out.writeObject(_library);
    out.close();
  }

  /**
   * @param filename
   * @throws MissingFileAssociationException
   * @throws IOException
   */
  public void saveAs(String filename) throws MissingFileAssociationException, IOException {
    _filename = filename;
    save();
  }

  /**
   * @param filename
   * @throws FailedToOpenFileException
   * @throws IOException
   * @throws ClassNotFoundException
   */
  public void load(String filename) throws FailedToOpenFileException, IOException, ClassNotFoundException {
    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
      _library = (Library) in.readObject();
      in.close();
    } catch (FileNotFoundException fnfe) {
      throw new FailedToOpenFileException(filename);
    }
    _filename = filename;
  }

  /**
   * @param datafile
   * @throws ImportFileException
   */
  public void importFile(String datafile) throws ImportFileException {
    try {
      _library.importFile(datafile);
    } catch (IOException | BadEntrySpecificationException e) {
      throw new ImportFileException(e);
    }
  }
}
