package m19;

public class ResponsibleUser extends UserState{

    private static final long serialVersionUID = 201911150205L;

    private String _state = "CUMPRIDOR";
    
    public ResponsibleUser(User user){
        super(user);
    }

    public String getState() {
        return _state;
    }
}