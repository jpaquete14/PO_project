package m19.app.users;

// FIXME import core concepts
import m19.LibraryManager;
import m19.app.exceptions.UserRegistrationFailedException;
// FIXME import ui concepts
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;

/**
 * 4.2.1. Register new user.
 */
public class DoRegisterUser extends Command<LibraryManager> {

  // FIXME define input fields
  private Input<String> _name;

  private Input<String> _email;
  /**
   * @param receiver
   */
  public DoRegisterUser(LibraryManager receiver) {
    super(Label.REGISTER_USER, receiver);
    // FIXME initialize input fields
    _name = _form.addStringInput(Message.requestUserName());
    _email = _form.addSTringInput(Message.requestUserEMail());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    // FIXME implement command
    try {
      _receiver.registerUser(_name, _email);
    } catch (DuplicateEmailException e) {
      throw new UserRegistrationFailedException(_name, _email);
    }
  }

}
