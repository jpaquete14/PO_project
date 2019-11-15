package m19;


public class FaltyUser extends UserState {

    private static final long serialVersionUID = 201911150203L;

    private String _state = "FALTOSO";
    
    public FaltyUser(User user) {
        super(user);
    }

    public String getState() {
        return _state;
    }
}