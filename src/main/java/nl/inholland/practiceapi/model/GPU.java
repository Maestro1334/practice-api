package nl.inholland.practiceapi.model;

public class GPU {
    private long id;
    private String model;
    private double clock;
    private double vram;
    private VRAMType vramType;

    public GPU(long id, String model, double clock, double vram, VRAMType vramType) {
        this.id = id;
        this.model = model;
        this.clock = clock;
        this.vram = vram;
        this.vramType = vramType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getClock() {
        return clock;
    }

    public void setClock(double clock) {
        this.clock = clock;
    }

    public double getVram() {
        return vram;
    }

    public void setVram(double vram) {
        this.vram = vram;
    }

    public VRAMType getVramType() {
        return vramType;
    }

    public void setVramType(VRAMType vramType) {
        this.vramType = vramType;
    }
}
