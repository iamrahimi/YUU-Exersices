package com.pluralsight.payrollCalculator;

import javax.xml.xpath.XPath;
import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Payroll Calculator");
        String[] listDir =  listDirectory();

        Employee[] employees = new Employee[20];
        int employeeCount = 0;

        try {
            System.out.println("Please enter the name of the file for employee to process (e.g employee.csv?");
            String FileName = input.nextLine();
            if(FileName != "") {


                FileReader fReader = new FileReader("uploads/"+FileName);
                BufferedReader bReader = new BufferedReader(fReader);

                String line;

                System.out.println("Please enter the name for the payroll (e.g. payroll-sept-2023.csv) ? ");
                String payrollName = input.nextLine();
                String path = "uploads/payrolls/" + payrollName ;
//                String text = "id|name|gross pay\\n";

                FileWriter fWriter = new FileWriter(path);
                BufferedWriter bWriter = new BufferedWriter(fWriter);
                bWriter.write("ID,Name,Gross Pay");
                bWriter.newLine();

                while ((line = bReader.readLine()) != null) {
                    String[] fields = line.split("\\|");

//                    if (isInteger(fields[0])) {
//                        Employee employee = new Employee();
//                        employee.setEmployeeId(Integer.parseInt(fields[0]));
//                        employee.setName(fields[1]);
//                        employee.setHoursWorked(Float.parseFloat(fields[2]));
//                        employee.setPayRate(Double.parseDouble(fields[3]));
//
//                        employees[employeeCount] = employee;
                        employeeCount++;
////
//                    }

                    try {

                        if (isInteger(fields[0])) {
                            String row = fields[0] + "|"
                                    + fields[1] + "|"
                                    + (Double.parseDouble(fields[2]) * Double.parseDouble(fields[3]));

                            bWriter.write(row);
                            bWriter.newLine();
                        }


                    }catch (IOException e) {
                        System.out.println("Error writing to file" + e.getMessage());
                    }


                }
                bWriter.close();
                bReader.close();
            }





//            showPayroll(employees); // VView the payroll record




        }  catch (Exception e) {
            System.out.println("Could not read the file");
            System.out.println(e.getMessage());
        }
    }

    public static void showPayroll (Employee[] employees) {
        System.out.printf("%-6s %-20s %12s %12s %12s%n",
                "ID", "Name", "Hours", "Pay Rate", "Gross Pay");

        System.out.println("----------------------------------------------------------------");


        for (Employee emp: employees ) {
            if(emp != null) {
                double grossPay = emp.getHoursWorked() * emp.getPayRate();
                System.out.printf("%-6d %-20s %12.1f %11.2f $%11.2f $%n",
                        emp.getEmployeeId(),
                        emp.getName(),
                        emp.getHoursWorked(),
                        emp.getPayRate(),
                        grossPay);
            }
        }

    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String[] listDirectory() {
        File folder = new File("uploads");
       String[] dirList = new String[30];
        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("Directory not found or could not be read.");
            return dirList;
        }

        for (File file : files) {
            if (file.isFile() && file.getName().toLowerCase().endsWith(".csv")) {
                dirList = new String[] {file.getName()};
            }
        }

        System.out.println(dirList[0]);
        return dirList;
    }


}