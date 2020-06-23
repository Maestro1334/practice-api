package nl.inholland.practiceapi.model;

import javax.persistence.*;

@Entity
@Table
public class GPU {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGen")
    @SequenceGenerator(name = "sequenceGen", initialValue = 1000)
    private long id;

    @Column(unique = true)
    private String model;

    private double clock;
    private double vram;
    private VRAMType vramType;

    public GPU() {
    }

    public GPU(String model, double clock, double vram, VRAMType vramType) {
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GPU{");
        sb.append("id=").append(id);
        sb.append(", model='").append(model).append('\'');
        sb.append(", clock=").append(clock).append("MHz");
        sb.append(", vram=").append(vram).append(vramType);
        sb.append('}');
        return sb.toString();
    }
}
