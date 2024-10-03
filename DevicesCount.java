import java.util.Scanner;

class DevicesCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int availableHours = scanner.nextInt();
        int totalDevices = scanner.nextInt();
        scanner.close();

        calculateDevicesTested(availableHours, totalDevices);
    }

    public static void calculateDevicesTested(int availableHours, int totalDevices) {
        if (availableHours < 4) {
            System.out.println("Invalid Input");
            return;
        }

        int devicesTested = availableHours / 4;

        if (devicesTested >= totalDevices) {
            System.out.println(totalDevices);
            System.out.println(0);
        } else {
            int remainingDevices = totalDevices - devicesTested;
            System.out.println(devicesTested);
            System.out.println(remainingDevices);
        }
    }
}
                                                                                                                            