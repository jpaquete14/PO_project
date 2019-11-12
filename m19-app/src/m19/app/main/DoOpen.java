package m19.app.main;

import java.io.IOException;
import m19.app.exceptions.FileOpenFailedException;

// FIXME import core concepts
import m19.LibraryManager;
import m19.exceptions.FailedToOpenFileException;

// FIXME import ui concepts
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;


/**
 * 4.1.1. Open existing document.
 */
public class DoOpen extends Command<LibraryManager> {

  // FIXME define input fields if needed
  private Input<String> _file;

  private int _id;

  /**
   * @param receiver
   */
  public DoOpen(LibraryManager receiver) {
    super(Label.OPEN, receiver);
    // FIXME initialize input fields if needed
    _file = _form.addStringInput(Message.openFile());
    id = receiver.getId();
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      // FIXME implement command
      _display.addLine(_receiver.load(_file.value()));
      _display.display();
    } catch (FailedToOpenFileException fnfe) {
      throw new FileOpenFailedException(fnfe.getName());
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }

}
