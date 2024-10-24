The given Task is,
        Create an API that manages employee information in an organization. The API should be able to:

	•	Add a new employee (POST).
	•	Retrieve details of a specific employee by ID (GET).
	•	Update employee details (PUT).
	•	Delete an employee record (DELETE).
	•	List all employees (GET).

Data Fields:

	•	Employee ID (Primary Key)
	•	Name
	•	Department
	•	Designation
	•	Salary
	•	Joining Date

Database Tables:

	•	Employees

   I was created a new mevan project name like employee.Extract the file and opened the file in Intellij.Added a five new pakages.

   Package-1(Entity):
       • Here i am created the employee class for creating a table name and fields in my database.
       • Here i am created the data fields of employeeId as primaryKey and set the nullable as false.
       • The other field are created and set nullable as false.
       • The Joining date variable i have declare the data type of Date.
   Package-2(Repository):
       • Here i am created the employee Interface class and extends the Jpa repository.
   Package-3(Dto):
   	• Here i am created a two classes name lilke EmployeesRequestDto,EmployeesResponseDto.
    	
       
