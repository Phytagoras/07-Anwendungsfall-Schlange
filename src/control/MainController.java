package control;

import model.Queue;
import model.Tray;

import java.util.ArrayList;

/**
 * Created by Jean-Pierre on 27.10.2016.
 */
public class MainController {

    private Queue<Tray> myQueue; //TODO: 02 - Sobald die Queue implementiert ist, wird der Controller um die Datenstruktur erweitert. D.h. aus einer Referenz auf ein einzelnes Objekt, wird eine Refernz auf ein Objekt der Klasse Queue zur Verwaltung von vielen Tray-Objekten.

    /**
     * Ich bin kein Konstrkutor. Ich steh' hier nur so rum!
     */
    public MainController() {
        myQueue = new Queue<>();
    }

    /**
     * Sobald die Datenstruktur Queue fertig ist, dient diese Methode der darstellerischen Ausgabe der Queue.
     *
     * @return String-Array zu den Informationen, die in der Queue gespeichert sind.
     */
    public String[] showAllTrays() {
        //TODO: 06 - Bei einer Queue ist es unüblich, auf alle Daten innerhalb der Queue zuzugreifen. Gerade das ist hier aber nötig! Hier muss mit einem "Trick" gearbeitet werden, ohne die Klasse Queue zu überarbeiten.
        ArrayList<String> output = new ArrayList<>();
        if (myQueue != null) {
            Queue<Tray> tmpQueue = myQueue;
            while (!tmpQueue.isEmpty()) {
                output.add(tmpQueue.front().getTimeAndInfo());
                tmpQueue.dequeue();
            }
        } else {
            return new String[] {"Nüx da! :O"};
        }
        return output.toArray(String[]::new);
    }

    /**
     * Ein neues Tray-Objekt wird erstellt und der Queue hinzugefügt.
     *
     * @return Informationen zum Objekt.
     */
    public String addNewTray() {
        Tray tmp = new Tray();
        myQueue.enqueue(tmp);
        return tmp.getTimeAndInfo();
    }

    /**
     * Das vorderste Tray-Objekt wird aus der Schlange entfernt.
     *
     * @return Informationen zum Objekt.
     */
    public String releaseTray() {
        //TODO: 05 - Das vorderste Tray-Objekt wird entfernt.
        if (!myQueue.isEmpty()) {
            String tmp = myQueue.front().getTimeAndInfo();
            myQueue.dequeue();
        }
        return "---";
    }

    /**
     * Es wird nur die Speicherinformation des ersten Tray-Objekts aus der Queue dargestellt. Das Objekt wird dabei nicht entfernt.
     * Die Queue bleibt also unberührt.
     *
     * @return Informationen zum vordersten Objekt.
     */
    public String getInfoOfFirst() {
        //TODO: 04 - Ausgabe der Informationen zum vordersten Objekt.
        if (!myQueue.isEmpty()) return myQueue.front().getTimeAndInfo();
        return "---";
    }
}
