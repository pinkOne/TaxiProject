package view;

/**
 * Created by I on 2016-03-04.
 *
 */
public class LogInFailedView implements IView {
    String userName;
    String password;

    public LogInFailedView(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String show() {
        return String.format("Log in failed for user %s" , userName);
    }
}
