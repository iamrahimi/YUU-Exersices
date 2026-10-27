package com.pluralsight.payrollCalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {
        System.out.println("Welcome to Payroll Calculator");

        Employee[] employees = new Employee[20];
        int employeeCount = 0;

        try {
            FileReader fReader = new FileReader("uploads/employees.csv");
            BufferedReader bReader = new BufferedReader(fReader);

            String line;

            while ((line = bReader.readLine()) != null) {
                String[] fields = line.split("\\|");

                if (isInteger(fields[0])) {
                    Employee employee = new Employee();
                    employee.setEmployeeId(Integer.parseInt(fields[0]));
                    employee.setName(fields[1]);
                    employee.setHoursWorked(Float.parseFloat(fields[2]));
                    employee.setPayRate(Double.parseDouble(fields[3]));

                    employees[employeeCount] = employee;
                    employeeCount++;

                }
            }

            bReader.close();
            System.out.printf("%-6s %-20s %12s %12s %12s%n",
                    "ID", "Name", "Hours", "Pay Rate", "Gross Pay");

            System.out.println("----------------------------------------------------------------");

            for (int i = 0; i < employeeCount; i++) {
                Employee employee = employees[i];

                double grossPay = employee.getHoursWorked() * employee.getPayRate();

                System.out.printf("%-6d %-20s %12.1f %11.2f $%11.2f $%n",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getHoursWorked(),
                        employee.getPayRate(),
                        grossPay);
            }

        }  catch (Exception e) {
            System.out.println("Could not read the file");
            System.out.println(e.getMessage());
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


}