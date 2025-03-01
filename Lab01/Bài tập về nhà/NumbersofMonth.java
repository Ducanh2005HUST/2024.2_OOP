import java.util.Scanner;

public class NumbersofMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        String[] monthAbbreviations = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.",
                "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
        String[] monthShortNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        int month = -1;
        int year = -1;

        while (month == -1) {
            System.out.print("Enter a month (e.g., January, Jan., Jan, or 1): ");
            String monthInput = scanner.nextLine().trim();
            
            try {
                int monthNumber = Integer.parseInt(monthInput);
                if (monthNumber >= 1 && monthNumber <= 12) {
                    month = monthNumber; 
                } else {
                    System.out.println("Invalid month. Please try again.");
                }
            } catch (NumberFormatException e) {
                
                for (int i = 0; i < 12; i++) {
                    if (monthInput.equalsIgnoreCase(monthNames[i]) ||
                            monthInput.equalsIgnoreCase(monthAbbreviations[i]) ||
                            monthInput.equalsIgnoreCase(monthShortNames[i])) {
                        month = i + 1; 
                        break;
                    }
                }
                if (month == -1) {
                    System.out.println("Invalid month. Please try again.");
                }
            }
        }

        
        while (year < 0) {
            System.out.print("Enter a year (e.g., 1999): ");
            try {
                year = Integer.parseInt(scanner.nextLine().trim());
                if (year < 0) {
                    System.out.println("Year must be a non-negative number. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please try again.");
            }
        }

        // Check for leap year
        boolean isLeapYear = isLeapYear(year);

        int daysInMonth;
        switch (month){
            case 2: // February
                daysInMonth = isLeapYear ? 29 : 28;
                break;
            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                daysInMonth = 30;
                break;
            default: // All other months
                daysInMonth = 31;
                break;
        }

        // Display the result
        System.out.println("Number of days in " + monthNames[month - 1] + " " + year + ": " + daysInMonth);

        scanner.close();
    }

    // Method to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}