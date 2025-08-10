package cse213.refugeecampfinalproject.AccountantAndLogistics;

import java.time.LocalDate;
import java.util.ArrayList;

public class DeliveryScheduleModel {
    private String vehicleId;
    private String route;
    private LocalDate deliveryDate;
    private String supplies;

    public static final ArrayList<DeliveryScheduleModel> scheduledDeliveries = new ArrayList<>();

    public DeliveryScheduleModel(String vehicleId, String route, LocalDate deliveryDate, String supplies) {
        this.vehicleId = vehicleId;
        this.route = route;
        this.deliveryDate = deliveryDate;
        this.supplies = supplies;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getSupplies() {
        return supplies;
    }

    public void setSupplies(String supplies) {
        this.supplies = supplies;
    }

    @Override
    public String toString() {
        return "DeliverySheduleModel{" +
                "vehicleId='" + vehicleId + '\'' +
                ", route='" + route + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", supplies='" + supplies + '\'' +
                '}';
    }
    public static boolean hasConflict(String vehicleId, LocalDate date) {
        for (DeliveryScheduleModel delivery : scheduledDeliveries) {
            if (delivery.getVehicleId().equalsIgnoreCase(vehicleId)
                    && delivery.getDeliveryDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a new delivery to the schedule if no conflict exists.
     */
    public static boolean addDelivery(DeliveryScheduleModel delivery) {
        if (!hasConflict(delivery.getVehicleId(), delivery.getDeliveryDate())) {
            scheduledDeliveries.add(delivery);
            // In a real app, this would save to a database
            System.out.println("[LOG] Scheduled delivery: " + delivery);
            return true;
        }
        return false;
    }

    /**
     * Gets all scheduled deliveries (for viewing/debugging).
     */
    public static ArrayList<DeliveryScheduleModel> getScheduledDeliveries() {
        return scheduledDeliveries;
    }
}
