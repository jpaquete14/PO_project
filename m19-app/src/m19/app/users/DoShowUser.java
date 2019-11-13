package m19.app.users;

// FIXME import core concepts
import m19.LibraryManager;
import m19.exceptions.NoSuchUserIdException;

// FIXME import ui concepts
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;

import m19.app.exceptions.NoSuchUserException;

/**
 * 4.2.2. Show specific user.
 */
public class DoShowUser extends Command<LibraryManager> {

  private Input<Integer> _id;

  /**
   * @param receiver
   */
  public DoShowUser(LibraryManager receiver) {
    super(Label.SHOW_USER, receiver);
    _id = _form.addIntegerInput(Message.requestUserId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    try {
      _display.popup(_receiver.showUser(_id.value()));
    } catch (NoSuchUserIdException e) {
      throw new NoSuchUserException(_id.value());
    }
  }

}
