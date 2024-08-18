import java.time.LocalTime;
import java.util.List;

public class Park {
    private String name;
    private List<Attraction> attractions;

    public Park(String name, List<Attraction> attractions) {
        this.name = name;
        this.attractions = attractions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    private class Attraction {
        private String info;
        private LocalTime openingTime;
        private LocalTime closingTime;
        private double price;

        public Attraction(String info, LocalTime openingTime, LocalTime closingTime, double price) {
            this.info = info;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.price = price;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public LocalTime getOpeningTime() {
            return openingTime;
        }

        public void setOpeningTime(LocalTime openingTime) {
            this.openingTime = openingTime;
        }

        public LocalTime getClosingTime() {
            return closingTime;
        }

        public void setClosingTime(LocalTime closingTime) {
            this.closingTime = closingTime;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

}
