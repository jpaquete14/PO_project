package m19.app.main;

import java.io.IOException;
import m19.app.exceptions.FileOpenFailedException;

// FIXME import core concepts
import m19.LibraryManager;
import m19.exceptions.FailedToOpenFileException;

// FIXME import ui concepts
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;


/**
 * 4.1.1. Open existing document.
 */
public class DoOpen extends Command<LibraryManager> {

  private Input<String> _file;

  /**
   * @param receiver
   */
  public DoOpen(LibraryManager receiver) {
    super(Label.OPEN, receiver);
    _file = _form.addStringInput(Message.openFile());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      _receiver.load(_file.value());
    } catch (FailedToOpenFileException fnfe) {
      throw new FileOpenFailedException(_file.value());
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }

}
