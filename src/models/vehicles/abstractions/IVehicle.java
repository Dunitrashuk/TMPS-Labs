package models.vehicles.abstractions;

public interface IVehicle {
    String getDetails();
    void setModel(String model);
    void setYear(int year);
    void setPrice(double price);
    double getPrice();
    String getModel();
    int getYear();
}
