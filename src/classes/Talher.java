package classes;

import enums.StatusTalher;
import java.util.concurrent.Semaphore;

public class Talher {

    private StatusTalher statusTalher;
    private Semaphore semaforo;

    public Talher() {
        this.statusTalher = StatusTalher.Livre;
        this.semaforo = new Semaphore(1);
    }

    public StatusTalher getStatusTalher() {
        return statusTalher;
    }

    public void setStatusTalher(StatusTalher statusTalher) {
        this.statusTalher = statusTalher;
    }

    public Semaphore getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(Semaphore semaforo) {
        this.semaforo = semaforo;
    }

}
