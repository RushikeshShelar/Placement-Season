package oops.interfaces;

public class NiceCar {
    private Engine engine;
    private final Media mediaPlayer = new CDplayer();

    public NiceCar() {
        engine = new PowerEngine();
    }

    public NiceCar(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
    }

    public void stop() {
        engine.stop();
    }

    public void startMusic(){
        mediaPlayer.start();
    }

    public void stopMusic(){
        mediaPlayer.stop();
    }

    public void upgrade(){
        this.engine = new ElectricEngine();
    }
}
