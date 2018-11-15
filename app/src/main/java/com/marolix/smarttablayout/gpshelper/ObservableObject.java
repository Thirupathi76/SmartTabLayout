package com.marolix.smarttablayout.gpshelper;

import java.util.Observable;

/**
 * Created by techniche-android on 22/11/16.
 */

public class ObservableObject extends Observable {

    private static ObservableObject instance = new ObservableObject();

    public static ObservableObject getInstance() {
        return instance;
    }

    private ObservableObject() {
    }

    public void updateValue(Object data) {
        synchronized (this) {
            setChanged();
            notifyObservers(data);
        }
    }

}
