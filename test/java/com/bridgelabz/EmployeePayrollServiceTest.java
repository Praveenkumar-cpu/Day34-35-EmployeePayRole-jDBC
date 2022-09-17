package com.bridgelabz;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeePayrollServiceTest {

    @Test
    public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
        EmployeePayrollData[] arrayOfEmp = { new EmployeePayrollData(1, "Praveen", 100000.0),
                new EmployeePayrollData(2, "Ganu", 200000.0),
                new EmployeePayrollData(3, "Vijay", 300000.0) };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmp));
        employeePayrollService.writeEmployeeData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        List<EmployeePayrollData> employeeList = employeePayrollService.readData(EmployeePayrollService.IOService.FILE_IO);
        System.out.println(employeeList);
        assertEquals(3, entries);
    }

    @Test

    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {

        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readData(EmployeePayrollService.IOService.DB_IO);
        assertEquals(3, employeePayrollData.size());
    }

    }


