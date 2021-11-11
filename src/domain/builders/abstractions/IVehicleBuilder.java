package domain.builders.abstractions;

public interface IVehicleBuilder {
    void create();
    void setModel(String model);
    void setYear(int year);
    void setPrice(double price);
}
