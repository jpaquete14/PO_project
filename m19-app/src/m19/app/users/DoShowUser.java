package m19.app.users;

// FIXME import core concepts
import m19.LibraryManager;

// FIXME import ui concepts
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;

/**
 * 4.2.2. Show specific user.
 */
public class DoShowUser extends Command<LibraryManager> {

  // FIXME define input fields
  private Input<Integer> _id;

  /**
   * @param receiver
   */
  public DoShowUser(LibraryManager receiver) {
    super(Label.SHOW_USER, receiver);
    // FIXME initialize input fields
    _id = _form.addIntegerInput(Message.requestUserId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    // FIXME implement command
    try {
      _display.popup(_receiver.showUser());
    } catch (NoSuchUserException e) {
      throw new NoSuchUserException(_id);
    }
  }

}
