package cse213.refugeecampfinalproject.Volunteer;

public class SupplyReportModel {
    private String item;
    private String note;

    public SupplyReportModel(String item, String note) {
        this.item = item;
        this.note = note;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "SupplyReportModel{" +
                "item='" + item + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
