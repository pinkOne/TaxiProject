package controller;
import model.IModel;

/**
 * Created by I on 2016-03-02.
 *
 */
public interface IController {
    String processRequest(IModel model, Request request);
}
