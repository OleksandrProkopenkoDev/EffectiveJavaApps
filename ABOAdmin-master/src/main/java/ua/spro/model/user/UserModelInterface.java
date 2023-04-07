package ua.spro.model.user;

import javafx.collections.ObservableList;
import ua.spro.entity.SubUser;
import ua.spro.entity.User;

import java.util.Observable;

public interface UserModelInterface  {

    ObservableList<User> getAllUsers();

    Integer save(User user);

    boolean update(SubUser user);

    UserState getUserState();

    User getCurrentUser();

    void setCurrentUser(User user);

    void changeState(UserState state);

    void changeState();

    boolean checkAccess(User user);

    boolean exit();

    boolean editing();

    boolean createUser(SubUser subUser);
}
