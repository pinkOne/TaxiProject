package view;

import model.User;

/**
 * Created by I on 2016-03-04.
 *
 */
public class LoggedInView implements IView {
    User user;

    public LoggedInView(User user) {
        this.user = user;
    }

    @Override
    public String show() {
        return user.toString();
    }
}
