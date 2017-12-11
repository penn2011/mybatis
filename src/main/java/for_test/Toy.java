package for_test;


public class Toy {

    private long toyId;
    private String toyName;

    private Pet petMaster;

    public Toy() {
    }

    public long getToyId() {
        return toyId;
    }

    public void setToyId(long toyId) {
        this.toyId = toyId;
    }


    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }


    public Pet getPetMaster() {
        return petMaster;
    }

    public void setPetMaster(Pet petMaster) {
        this.petMaster = petMaster;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "toyId=" + toyId +
                ", toyName='" + toyName + '\'' +
                '}';
    }
}
