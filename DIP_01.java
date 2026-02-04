package SOLID;

public class DIP_01 {

    /*
     * TASK:
     * The Switch is violating the DIP (Dependency Inversion Principle).
     * Please fix this!
     */
    
    public static class LightBulb implements Switchable {
        private boolean on = false;

        @Override
        public void turnOn() {
            on = true;
            System.out.println("LightBulb: Light is ON!");
        }

        @Override
        public void turnOff() {
            on = false;
            System.out.println("LightBulb: Light is OFF!");
        }

        @Override
        public boolean isOn() {
            return on;
        }
    }

    public static class Fan implements Switchable {
        private boolean on = false;

        @Override
        public void turnOn() {
            on = true;
            System.out.println("Fan: Fan is ON!");
        }

        @Override
        public void turnOff() {
            on = false;
            System.out.println("Fan: Fan is OFF!");
        }

        @Override
        public boolean isOn() {
            return on;
        }
    }

    public static class Switch {
        private Switchable device;

        public Switch(Switchable device) {
            this.device = device;
        }

        public void operate() {
            if (device.isOn()) {
                device.turnOff();
            } else {
                device.turnOn();
            }
        }
    }

    public static void main(String[] args) {
        Switchable lightBulb = new LightBulb();
        Switch lightSwitch = new Switch(lightBulb);

        System.out.println("Operating light switch:");
        lightSwitch.operate();
        lightSwitch.operate();

        System.out.println("\nOperating fan switch:");
        Switchable fan = new Fan();
        Switch fanSwitch = new Switch(fan);
        fanSwitch.operate();
        fanSwitch.operate();
    }
}