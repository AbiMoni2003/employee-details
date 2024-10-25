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
        Here i am created the employee class for creating a table name and fields in my database.
        Here i am created the data fields of employeeId as primaryKey and set the nullable as false.
        The other field are created and set nullable as false.
        The Joining date variable i have declare the data type of Date.
   Package-2(Repository):
        Here i am created the employee Interface class and extends the Jpa repository.
   Package-3(Dto):
   	 Here i am created a two classes name lilke EmployeesRequestDto,EmployeesResponseDto.
     	 In this requestdto i have to set the values of the employee fields.
       	 In this respondedto i have created a message variable as String for sending a message in the postman console.
   Package-4(Servive):
   	Here i am creating two classes one is EmployeeService and other is EmployeeServiceImpl.
    	The employeeservice is a interface class.
   	This is for the creating interface of create employee,getallemployee,getEmployeeById,deleteEmployeeById and updateEmployee.
    	In this ServiceImpl have to implements the interface class and validation are done it and the errors are handled here.
  Package-5(Controller):
  	Here i am using the @requestmaping(employees) for the API end path.
   	Here @Postmapping for create a new employee,@Getmapping for getting all the employees and a specific employee,@Putmapping for update the employee details and @Deletemapping for delete the employee record.

 Steps for Running:
 	STEP - 1:
 		First you should craete a database in mySql.
  		query-> create database employees;
   	STEP - 2:
   		These follwing codes are fill in the application.properties
    		spring.application.name=employee
		spring.datasource.url=jdbc:mysql://localhost:3306/employees
		spring.datasource.username=username
		spring.datasource.password=password
		spring.jpa.hibernate.ddl-auto=update
		spring.jpa.show-sql=true
		server.port=8085
  	STEP - 3:
   		In the postman paste the URL->http://localhost:8085/employees/create to create a new emploee detail and click the POST method.And paste the json format data given below and fill the fields,
     		{
		    "employeeId": "",
		    "name": "",
		    "department": "",
		    "designation": "",
		    "joiningDate": "",
		    "salary": ""
		}
  	STEP - 4:
   		In the postman paste the URL->http://localhost:8085/employees/getall to view the all employee detail and click the GET method.
     	STEP - 5:
      		In the postman paste the URL->http://localhost:8085/employees/get/{employeeId} to get the specific employee detail and click the GET method.
	STEP - 6:
 		In the postman paste the URL->http://localhost:8085/employees/update/{employeeId} to update the specific employee detail and click the PUT method.
   	STEP - 7:
    		In the postman paste the URL->http://localhost:8085/employees/delete/{employeeId} to delete the specific employee record from the database and click the DELETE method.
      
      Check Wheather the data are added to the database table:
      		Query:
			->use employees;
		     	->select * from employee_details;
		You will see the recorded employee details in the table.

  These are all the works i have i done in this task.
  						ThankYou.
      
		   		
  	
    	
       
