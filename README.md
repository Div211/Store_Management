
# Store Management

This is a basic console based Java Project On a store management 

For the CRUD Operation we have used Collection Framework to store the product and store details

The project is made for understanding of the MVC architecture 

MVC architecture basically divides the whole project into 3 parts

1.  Model :
    
    Model stores the genric entity of the project that we are working on.

    In our example it's the store and Product entity

    Store entity will collect the details such as Id , name , Address , Contact Number , and Product details 

    Where as in Project entity it stores the data of product such as ProductID , Product Name , Product Price , Product Quantity ,and its availability .

2. Controller :

    In controller we basically write the business Logic that will help us in the operation of the project 

    For Eg : In our case the controller will be handling the control will handle the logic's like.

    a. Getting the store details\
    b. Adding the product (single or multiple times)\
    c.Get the details of Product\
    d.To remove the Product \
    e.To update the Product

3. View :

In View we basically write the code for printing the data that we want to display to the users. 

And also we can provide the extra logic for printing the output in a desired pattern. 

For Example in our project in the view section we have created static block 
\
In this Static block we capture the details of the store and print it on the stre details.

After receiving the details we have created a driver method in which with the help of switch case we are taking the option from the user and taking decission accordingly.

Then after receiving options from the user according to the operation we have created a method to print the output in a synchronised manner 

    
