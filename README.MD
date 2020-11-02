CS331- Project Assignment
Problem Description

Project 2
Information System for the “Clean-and-Go” Shop

Problem Description

“Clean-and-Go” is a local shop that provides the following services to the community: coin washers and dryers, drop-off services, and dry cleaning. This business has ten full-time employees. They currently rent their building. The company is interested in building a database information system that would enable them to do the following: keep detailed information about daily collections, monthly expenses and revenues; manage employees’ schedules; manage equipment maintenance schedule;
etc.

Database Design

We present the main entity types of this database. For each entity type, we provide some of the corresponding attributes. Use this information in order to: (a) Build an Enhanced E-R diagram; (b) Transform the Enhanced E-R diagram to a relational database. Identify the primary key(s) and the foreign key(s) for each relation. Draw the relational integrality constraints; (c) For each of the relations created, indicate its normal form. If the relation is not in the 3NF, decompose it into 3NF relations.

1.	Cleaning Supplies: The main attributes are name, description of usage, current inventory, safety stock level, etc.
2.	Customer: The main attributes are identification number, name, address, e-mail, telephone number, credit card information, current balance, etc.
3.	Employee: The main attributes are identification number, name, address, gender, date of employment, position hired for, schedule, etc.
4.	Equipment: The main attributes are identification number, brand name, purchase date and purchase price, type, maintenance schedule, etc.
5.	Service: The main attributes are identification number, name, description, rate charged, duration, etc.
6.	Supplier: The main attributes are identification number, name, address, telephone number, current balance, etc.

Note the following: 
(a)	Schedule is multi-value attribute of the entity type Employee. 
(b)	Maintenance schedule is a multi-value attribute of the entity type Equipment. 
(c)	The following items are classified as cleaning supplies: detergents, soaps, hangers, etc. 
(d)	Customers pay for the services they get. When a customer is provided service, the following information is recorded: date, amount charged, description, satisfaction with the service, etc.
(e)	Suppliers offer equipments and cleaning supplies. When equipments or cleaning supplies are purchased, the following information is recorded: transaction identification number and date, quantity purchased, amount due, due date, description, delivery date, etc.
(f)	

Application Development

please note you will not be asked to implement all of the following queries, forms or reports during the Project. These are only to add some details on how the system can be use. During the project implementation you will be assigned a specific set of queries to implement.


The following are some of the queries, forms, and reports one can create in order to increase the functionality of the database and your design needs to account for. 

47
Queries:

1.	The following set of queries will help with the financial analysis of the company:
a.	Create a query that calculates the annual expenses from equipment maintenance.
b.	 Create a query that calculates the annual expenses from cleaning supplies.
c.	Create a query that presents the annual expenses from purchasing new equipment.
d.	Create a query that calculates the annual expenses from salaries and rent.
e.	Create a query that calculates the annual revenues from services provided to customers. Group this information by service type.
f.	Create a query that presents the annual earnings of the company.
2.	The following set of queries helps to analyze the progress of the business:
a.	Create a query that presents the total number of new customers during the current year.
b.	Create a query that presents the total number of service transactions during the current month.
c.	Create a query that presents details about customer satisfaction with the service provided.
d.	Create a query that presents the total number of equipment owned by the company. Group this information by equipment type.
3.	Create a query to present the weekly working schedule of the employees.
4.	Create a query to present the weekly maintenance schedule of the equipment.
5.	The company has regulations about the amount of time (in terms of months) that equipment should be in use. Replacement time differs by equipment type. Create a query that presents the amount of time equipment has been used. Present the number of time period in terms of months.
6.	Create a query that presents the average monthly usage per equipment (busy time/total time).
7.	Create a query that presents details about the cleaning supplies for which the current inventory is below the safety stock level.
8.	Create a query that presents details about the cleaning supply that has been used the most.
9.	Create a query that presents details about the service that has been used the most.
10.	Create a query that prompts for the name of a supplier and returns a list of products they offer.

Forms:

1.	Create a user sign-in form together with a registration form for new users.
2.	Create the following data entry forms that are used for database administrative functions: employees, services, equipment, cleaning supplies, etc. These forms allow the user to add, update, and delete information about employees, services, equipment, cleaning supplies, etc.
3.	Create a form that allows the user to access different financial summary reports (reports 1.a, 1.b, …, 1.d).
4.	Create a form that allows the user to access different reports that provide indicators of business performance.
5.	Create a form that allows the user to choose a particular date from a combo box. Insert a subform that presents details about customer related transactions performed in the selected date. Insert a textbox that presents the total revenues generated from these transactions.
6.	Create a form that allows the user to browse through the information saved in this database about the equipment. Insert a subform that presents details about the maintenance services performed on the selected equipment. Insert a subform that presents details about the maintenances scheduled for the next month. Insert a command button that, when clicked-on, presents details about the activities (for example, if the equipment is a washing machine, present the total number of washing loads) performed on the selected equipment during the current month.
7.	 Create a form that allows the user to choose the name of a particular customer from a list box. Insert a subform that presents details about items the customer has given for dry-cleaning that need to be returned. Insert a textbox that presents the total amount due.
8.	Create a form that allows the user to choose the identification number and name of a supplier from a combo-box. Insert a subform that presents details about the supplier and services/equipments purchased from the selected supplier. Insert a textbox that presents the amount of money due. Insert a command button that, when clicked-on presents details about the orders placed with the suppliers that have not been satisfied yet.

Reports

1.	Create the following financial reports:
a.	Present the annual revenues generated from services provided.
b.	Present the annual expenses from the following: rent, salaries, equipment maintenance, purchasing new equipment, and cleaning supplies.
c.	Present the annual earnings of the company.
d.	Report the total expenses, total revenues, and total earnings during the current month.
2.	Report the average daily usage, for each equipment, during the current year.
3.	Report the maintenance schedule during the current month.
4.	Report the weekly schedule of the employees.
5.	Report the following:
a.	Total number of customers per year during the last five years.
b.	Monthly expenses for cleaning supplies during the last twelve months.
c.	Total number of service transactions per month during the last twelve months.
d.	Monthly expenses for maintenance during the last twelve months.
6.	Report the most requested type of service.











Java Application Development

This database application can be used by the employees, the manager, the database administrator, etc. In the following figure we present a tentative layout of the system. 



















In the welcome screen, the user can choose one of the four options presented. We give details about the forms or set of forms to be included in each option; however, you are encouraged to add other forms you find relevant. We suggest that the queries, forms, and reports already created in the Access Application Development section be included in here. 

Equipment & Cleaning Supplies: This part of the database keeps information about equipment and cleaning supplies. The employees browse the database to learn about the maintenance schedule of particular equipment, the inventory level of cleaning supplies, etc.

Customers & Services: This part of the database carries information about customers and services provided. Statistics, Graphs & Data Analysis: Users browse this part of the database to identify trends in: the annual expenses, the annual revenues, the total number of new customers, etc.

Update: This form allows the user to add/delete/update the information kept in this database about equipment, services, customers, etc.


