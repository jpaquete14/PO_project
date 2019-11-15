package m19;

import java.io.Serializable;

abstract class UserState implements Serializable{

    private static final long serialVersionUID = 201911150123L;

    private int _onSchedule = 0;

    private int _offSchedule = 0;
    
    protected User _user;

    public UserState(User user) {
        _user = user;
    }

    abstract public String getState();
}