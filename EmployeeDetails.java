import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeDetails {
    public static void main(String[] args) {
        // Read the input file
        String inputFile = "employees.csv";
        String line = "";
        String delimiter = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            // Create output files
            FileWriter managerFile = new FileWriter("managers.csv");
            FileWriter singleNameFile = new FileWriter("single_name_employees.csv");
            
            // Read the input file line by line
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(delimiter);
                
                // Check if employee is a manager in R&D division
                if (employee[1].equals("Manager") && employee[2].equals("R&D")) {
                    managerFile.write(line + "\n");
                }
                
                // Check if employee has single name
                String[] name = employee[0].split(" ");
                if (name.length == 1) {
                    singleNameFile.write(line + "\n");
                }
            }
            
            // Close output files
            managerFile.close();
            singleNameFile.close();
            
            System.out.println("Output files generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
