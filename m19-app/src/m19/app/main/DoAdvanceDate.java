package m19.app.main;



// FIXME import core concepts
import m19.LibraryManager;

// FIXME import ui concepts
import pt.tecnico.po.ui.Command;

/**
 * 4.1.3. Advance the current date.
 */
public class DoAdvanceDate extends Command<LibraryManager> {

  // FIXME define input fields
  private int _days;

  /**
   * @param receiver
   */
  public DoAdvanceDate(LibraryManager receiver) {
    super(Label.ADVANCE_DATE, receiver);
    // FIXME initialize input fields
    _days = _form.addIntegerInput(Message.requestDaysToAdvance());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    // FIXME define method
    _receiver.advanceDate(days);
  }
}
