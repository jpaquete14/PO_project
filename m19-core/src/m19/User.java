package m19;

import java.io.Serializable;

public class User implements Serializable {

    //Class attributes
    private static final long serialVersionUID = 201608231520L;

    private int _id;

    private String _name;
    
    private String _email;

    private UserState _state = new NormalUser(this);

    //Counters to update the UserState
    private int _onSchedule = 0;
    private int _afterSchedule = 0;


    public User(int id, String name, String email) {
        _id = id;
        _name = name;
        _email = email;
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }
    public void setName(String name) {
        _name = name;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    protected void setState(UserState state) {
        _state = state;
    }
}