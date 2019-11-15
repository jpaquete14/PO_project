package m19;

public class NormalUser extends UserState {

    private static final long serialVersionUID = 201911150204L;

    private String _state = "NORMAL";

    public NormalUser(User user) {
        super(user);
    }

    public String getState() {
        return _state;
    }
} 