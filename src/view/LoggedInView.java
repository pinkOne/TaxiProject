package view;

import model.Person;

/**
 * Created by I on 2016-03-04.
 *
 */
public class LoggedInView implements IView {
    Person user;

    public LoggedInView(Person user) {
        this.user = user;
    }

    @Override
    public String show() {
        return user.toString();
    }
}
