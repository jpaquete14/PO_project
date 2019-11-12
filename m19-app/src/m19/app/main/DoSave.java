package m19.app.main;


import java.io.IOException;

// FIXME import core concepts
import m19.LibraryManager;

// FIXME import ui concepts
import pt.tecnico.po.ui.Command;

/**
 * 4.1.1. Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<LibraryManager> {
  
  // FIXME define input fields
  private Input<String> _file;

  /**
   * @param receiver
   */
  public DoSave(LibraryManager receiver) {
    super(Label.SAVE, receiver);
    // FIXME initialize input fields
    if (receiver.getFile() == null) {
      _file = _form.addStringInput(Message.newSaveAs());
      }
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    // FIXME implement command
    try {
      if((_receiver.getFile())==null) {
          _form.parse();
          _receiver.save(_file.value());
      }
      else {
          _receiver.save(_receiver.getFile());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
