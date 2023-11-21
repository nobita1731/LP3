// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract EmployeeDetails {
    // Define the structure for employee details
    struct Employee {
        uint256 id;
        string name;
        uint256 salary;
        uint256 joiningDate;
    }

    // Mapping to store employee details by their ID
    mapping(uint256 => Employee) public employees;

    // Event to log when a new employee is added
    event EmployeeAdded(uint256 indexed id, string name, uint256 salary, uint256 joiningDate);

    // Function to add a new employee
    function addEmployee(uint256 _id, string memory _name, uint256 _salary, uint256 _joiningDate) public {
        Employee memory newEmployee = Employee(_id, _name, _salary, _joiningDate);
        employees[_id] = newEmployee;
        emit EmployeeAdded(_id, _name, _salary, _joiningDate);
    }

    // Function to retrieve employee details by ID
    function getEmployee(uint256 _id) public view returns (uint256, string memory, uint256, uint256) {
        Employee memory employee = employees[_id];
        return (employee.id, employee.name, employee.salary, employee.joiningDate);
    }
}