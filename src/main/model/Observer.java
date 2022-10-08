package src.main.model;

import src.main.view.Observable;

/**
 * @Author Anthony Z.
 * @Date 8/10/2022
 * @Description:
 */
public interface Observer {

    public void refreshData(Observable subject);
}
