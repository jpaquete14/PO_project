package m19.app.main;


import java.io.IOException;

// FIXME import core concepts
import m19.LibraryManager;

// FIXME import ui concepts
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

import m19.exceptions.MissingFileAssociationException;

/**
 * 4.1.1. Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<LibraryManager> {
  
  private Input<String> _file;

  /**
   * @param receiver
   */
  public DoSave(LibraryManager receiver) {
    super(Label.SAVE, receiver);
    if ((_receiver.getFile()) == null) {
      _file = _form.addStringInput(Message.newSaveAs());
      }
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    try {
      if((_receiver.getFile()) == null) {
        _form.parse();
        _receiver.saveAs(_file.value());
      }
      else {
        _receiver.save();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (MissingFileAssociationException e) {
      e.printStackTrace();
    }
  }
}
