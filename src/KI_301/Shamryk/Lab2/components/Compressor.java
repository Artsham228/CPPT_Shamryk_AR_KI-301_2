package KI_301.Shamryk.Lab2.components;


public class Compressor {
    private boolean isActive = false;
    public void start() { this.isActive = true; }
    public void stop() { this.isActive = false; }
    public boolean isActive() { return isActive; }
}