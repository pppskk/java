import java.util.Scanner;

    public class Main {
    // Method for calculating the price after applying the discount
    public static double applyDiscount(double totalPrice, int days) {
     double discount = 0;
     if (days > 10) {
         discount = 0.07; // 7% discount
     } else if (days > 7) {
         discount = 0.04; // 4% discount
     } else if (days > 5) {
         discount = 0.03; // 3% discount
     } else if (days >= 3) {
         discount = 0.02; // 2% discount
     }


        double discountedPrice = totalPrice - (totalPrice * discount);
        System.out.println("Discount applied: " + (discount * 100) + "% ");
        return discountedPrice;
    }

    // Method to generate a random license plate number
    public static String generateLicensePlate() {
        String[] provinces = {"ก", "ข", "ค", "ฆ", "ง", "จ", "ฉ", "ช", "ซ", "ญ"};
        String province = provinces[(int) (Math.random() * provinces.length)];
        int number = (int) (Math.random() * 9000) + 1000; // Generate random number between 1000 and 9999
        return province + province + " " + number; // Example: กก 1234
    }

    // Method for printing the receipt
    public static void printReceipt(String carType, int days, double totalPrice, double discountedPrice, String licensePlate, String name, String startDate, String endDate) {
        System.out.println("\n--- Receipt ---");
        System.out.println("Renter Name: " + name);
        System.out.println("Car Type: " + carType);
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Total Rental Days: " + days + " days");
        System.out.println("Total Rental Price (before discount): " + totalPrice + " THB");
        if (totalPrice == discountedPrice) {
            System.out.println("Your discount is " + "0" + " THB");
        } else if ((totalPrice - discountedPrice) < 0) {
            System.out.println("Your pennalty is " + (discountedPrice - totalPrice) + " THB");
        } else {
            System.out.println("Your discount is " + (totalPrice - discountedPrice) + " THB");
        }
        if ((totalPrice - discountedPrice) < 0) {
            System.out.println("Total Rental Price (after pennalty): " + discountedPrice + " THB");
        } else {
            System.out.println("Total Rental Price (after discount): " + discountedPrice + " THB");
        }
        System.out.println("Thank you for using our service!");
    }

    // Method for calculating the total rental price
    public static double rent(String carBrand, String carType, int days) {
        double totalPrice = 0;

        if (carBrand.equalsIgnoreCase("toyota")) {
            switch (carType.toLowerCase()) {
                case "corolla":
                    totalPrice = days * 550;
                    break;
                case "camry":
                    totalPrice = days * 1200;
                    break;
                case "hilux":
                    totalPrice = days * 1500;
                    break;
                default:
                    System.out.println("Invalid model for Toyota.");
                    break;
            }
        } else if (carBrand.equalsIgnoreCase("honda")) {
            switch (carType.toLowerCase()) {
                case "civic":
                    totalPrice = days * 600;
                    break;
                case "accord":
                    totalPrice = days * 1200;
                    break;
                case "hr-v":
                    totalPrice = days * 1300;
                    break;
                default:
                    System.out.println("Invalid model for Honda.");
                    break;
            }
        } else if (carBrand.equalsIgnoreCase("mercedes")) {
            switch (carType.toLowerCase()) {
                case "a-class":
                    totalPrice = days * 600;
                    break;
                case "c-class":
                    totalPrice = days * 1200;
                    break;
                case "e-class":
                    totalPrice = days * 1300;
                    break;
                default:
                    System.out.println("Invalid model for Mercedes.");
                    break;
            }
        } else if (carBrand.equalsIgnoreCase("bmw")) {
            switch (carType.toLowerCase()) {
                case "3 series":
                    totalPrice = days * 600;
                    break;
                case "5 series":
                    totalPrice = days * 1200;
                    break;
                case "x5":
                    totalPrice = days * 1300;
                    break;
                default:
                    System.out.println("Invalid model for BMW.");
                    break;
            }

        } else if (carBrand.equalsIgnoreCase("tesla")) {
            switch (carType.toLowerCase()) {
                case "model 3":
                    totalPrice = days * 600;
                    break;
                case "model s":
                    totalPrice = days * 1200;
                    break;
                case "model x":
                    totalPrice = days * 1300;
                    break;
                default:
                    System.out.println("Invalid model for Tesla.");
                    break;
            }

        }
        return totalPrice;
    }

    // Method for selecting the car model based on brand
    public static String selectCarModel(String brand) {
        Scanner scanner = new Scanner(System.in);
        String selectedCarModel = "";
        boolean isvalid = false;

        while (!isvalid) {
            switch (brand.toLowerCase()) {
                case "toyota":
                    System.out.println("Select the model:");
                    System.out.println("1. Corolla");
                    System.out.println("2. Camry");
                    System.out.println("3. Hilux");
                    break;
                case "honda":
                    System.out.println("Select the model:");
                    System.out.println("1. Civic");
                    System.out.println("2. Accord");
                    System.out.println("3. HR-V");
                    break;
                case "mercedes":
                    System.out.println("Select the model:");
                    System.out.println("1. A-Class");
                    System.out.println("2. C-Class");
                    System.out.println("3. E-Class");
                    break;
                case "bmw":
                    System.out.println("Select the model:");
                    System.out.println("1. 3 Series");
                    System.out.println("2. 5 Series");
                    System.out.println("3. X5");
                    break;
                case "tesla":
                    System.out.println("Select the model:");
                    System.out.println("1. Model 3");
                    System.out.println("2. Model S");
                    System.out.println("3. Model X");
                    break;
                default:
                    System.out.println("Invalid brand selected.");
                    return ""; // Return empty if invalid brand
            }

            System.out.print("Enter the number of the model: ");
            int modelChoice = scanner.nextInt();
            //selectedCarModel = "";

            // Select the car model based on the user's choice
            switch (brand.toLowerCase()) {
                case "toyota":
                    if (modelChoice == 1) selectedCarModel = "Corolla";
                    else if (modelChoice == 2) selectedCarModel = "Camry";
                    else if (modelChoice == 3) selectedCarModel = "Hilux";
                    break;
                case "honda":
                    if (modelChoice == 1) selectedCarModel = "Civic";
                    else if (modelChoice == 2) selectedCarModel = "Accord";
                    else if (modelChoice == 3) selectedCarModel = "HR-V";
                    break;
                case "mercedes":
                    if (modelChoice == 1) selectedCarModel = "A-Class";
                    else if (modelChoice == 2) selectedCarModel = "C-Class";
                    else if (modelChoice == 3) selectedCarModel = "E-Class";
                    break;
                case "bmw":
                    if (modelChoice == 1) selectedCarModel = "3 Series";
                    else if (modelChoice == 2) selectedCarModel = "5 Series";
                    else if (modelChoice == 3) selectedCarModel = "X5";
                    break;
                case "tesla":
                    if (modelChoice == 1) selectedCarModel = "Model 3";
                    else if (modelChoice == 2) selectedCarModel = "Model S";
                    else if (modelChoice == 3) selectedCarModel = "Model X";
                    break;
            }

            if (!selectedCarModel.isEmpty()) {
                isvalid = true;
            } else {
                System.out.println("No valid car model selected.");
            }
        }
        return selectedCarModel;
    }

    // Method to calculate the number of rental days between two dates
    public static int getDaysFromDate(int year, int month, int day, int[] daysInMonth) {
        int totalDays = 0;

        // คำนวณจำนวนวันจากปี
        totalDays += (year - 1900) * 365 + (year - 1900) / 4; // ปีอธิกสุรทิน
        if (year % 4 == 0 && month <= 2) totalDays--; // ปรับปีอธิกสุรทิน (ถ้าเดือนก่อนหรือกุมภาพันธ์)

        // คำนวณจำนวนวันจากเดือน
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }

        // คำนวณจำนวนวันจากวันในเดือน
        totalDays += day;

        return totalDays;
    }

    // Method to calculate a late return penalty
    public static double calculateLatePenalty(int daysLate, double dailyRate) {
        double penaltyRate = 0.15; // 15% of the daily rate for each late day
        double penalty = daysLate * dailyRate * penaltyRate;
        return penalty;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Select the car brand
        String[] carBrands = {"Toyota", "Honda", "Mercedes", "BMW", "Tesla"};
        String selectedCarBrand = "";
        boolean isBrandValid = false;
        while (!isBrandValid) {
            System.out.println("Please select the car brand:");
            for (int i = 0; i < carBrands.length; i++) {
                System.out.println((i + 1) + ". " + carBrands[i]);
            }
            System.out.print("Enter the number: ");
            int brandChoice = scanner.nextInt();
            if (brandChoice >= 1 && brandChoice <= carBrands.length) {
                selectedCarBrand = carBrands[brandChoice - 1];
                isBrandValid = true; // Exit the loop if a valid brand is selected
            } else {
                System.out.println("Invalid brand choice. Please try again.");
            }
        }

        // Select the car model
        String selectedCarModel = selectCarModel(selectedCarBrand);

            // Display the selected model
            if (!selectedCarModel.isEmpty()) {
                System.out.println("You selected: " + selectedCarBrand + " " + selectedCarModel);
            }

            // Get rental start and end dates
            System.out.println("Please enter the start and end dates for the rental:");
            System.out.print("Enter start day: ");
            int startDay = scanner.nextInt();
            System.out.print("Enter start month: ");
            int startMonth = scanner.nextInt();
            System.out.print("Enter start year: ");
            int startYear = scanner.nextInt();

            System.out.print("Enter end day: ");
            int endDay = scanner.nextInt();
            System.out.print("Enter end month: ");
            int endMonth = scanner.nextInt();
            System.out.print("Enter end year: ");
            int endYear = scanner.nextInt();

            int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            String startDate = startDay + "/" + startMonth + "/" + startYear;
            String endDate = endDay + "/" + endMonth + "/" + endYear;

            // Calculate the number of rental days
            int startrent = getDaysFromDate(startYear, startMonth, startDay, daysInMonth);
            int endrent = getDaysFromDate(endYear, endMonth, endDay, daysInMonth);
            int daysBetween = endrent - startrent;
            System.out.println("Total rental days: " + daysBetween);
            // Calculate the rental price
            double totalPrice = rent(selectedCarBrand, selectedCarModel, daysBetween);
            double discountedPrice = applyDiscount(totalPrice, daysBetween);
            // Generate the license plate
            String licensePlate = generateLicensePlate();

            // ถามวันคืนรถจริง
            System.out.print("Enter actual return day: ");
            int actualReturnDay = scanner.nextInt();
            System.out.print("Enter actual return month: ");
            int actualReturnMonth = scanner.nextInt();
            System.out.print("Enter actual return year: ");
            int actualReturnYear = scanner.nextInt();

// คำนวณจำนวนวันตั้งแต่ปี 1900 สำหรับวันคืนรถจริง
            int actualReturnDays = getDaysFromDate(actualReturnYear, actualReturnMonth, actualReturnDay, daysInMonth);

// คำนวณจำนวนวันล่าช้า (ถ้ามี)
            int daysLate = actualReturnDays - endrent;
            if (daysLate > 0) {
                System.out.println("The car was returned late by " + daysLate + " days.");
                // คำนวณค่าปรับ
                double dailyRate = totalPrice / daysBetween; // หาค่า dailyRate จากราคาเช่า
                double latePenalty = calculateLatePenalty(daysLate, dailyRate);
                System.out.println("Late return penalty: " + latePenalty + " THB");
                // อัปเดตราคาสุทธิรวมค่าปรับ
                discountedPrice += latePenalty;
            } else {
                System.out.println("The car was returned on time.");
            }

            // Get personal information
            scanner.nextLine();  // Consume the leftover newline
            System.out.print("Name: ");
            String name = scanner.nextLine();

            // Print the receipt
            printReceipt(selectedCarBrand + " " + selectedCarModel, daysBetween, totalPrice, discountedPrice, licensePlate, name, startDate, endDate);
        }
    }



