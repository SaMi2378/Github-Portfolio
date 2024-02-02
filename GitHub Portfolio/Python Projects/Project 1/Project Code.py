import sqlite3
import bcrypt
import getpass
import prettytable
from termcolor import colored
import time
import maskpass
from prettytable import from_db_cursor


con = sqlite3.connect("swe4207.db")
cur = con.cursor()

def create_user_table():
    """Create table to store accounts"""
    cur.execute ("""CREATE TABLE IF NOT EXISTS user
                    (
                        username        TEXT PRIMARY KEY,
                        password        TEXT NOT NULL
                    ) 
                """)

    con.commit()
    return

def create_user_account():
    """Get details and insert record in database: """
    while True:
        username  = input ("Enter username: ").strip().lower()
    
        hidden_password = maskpass.askpass("Enter user's passwords: ")
        plain_password = hidden_password.strip().encode('utf-8')

        # send plain_password as an argument to function
        # password returned will be hashed
        # .encode('utf-8') is required for bcrypt
        
        
        password = hash_password(plain_password)
        

        #send values to be inserted as a record in database
        insert_user_account(username, password)

        print (f"The following details have been entered",
               f"\nusername    = {username}",
               f"\nuser_password   = {password}")
        
        add_another = input("Would you like to add another user [Y/N] "
                                ).strip().upper()
        while add_another not in ["Y","N"]:
            add_another = input ("Invalid option, choose [Y/N]: ").strip().upper()

        if add_another == "N":
            login_menu()
    return

def hash_password(plain_password:str):
    """Hash and return user_password"""
    salt = bcrypt.gensalt()
    hashed_password = bcrypt.hashpw(plain_password, salt)
    return hashed_password

def insert_user_account (username:str, password:str):
    """accepts user details and stores in sqlite db table"""
    cur.execute("INSERT INTO user VALUES (?, ?)" ,
            (
                username,
                password              

            )  
        )

    con.commit()
    return

def check_password():
    """function uses bcrypt to check if user is in database with matching password"""
    username         = input("Enter username: ").lower().strip()
    hidden_to_check   = maskpass.askpass(f"Enter password for user <{username}>: "
                            )
  

    password_to_check = hidden_to_check.strip().encode('utf-8')
    cur.execute(""" SELECT password FROM user 
                WHERE username = ?""", (username,))

    result = cur.fetchall()
    print(result) # test print for list of tuples returned

    fetched_password    = result[0][0] # assign 1st value from the 1st record returned
    
    if bcrypt.checkpw(password_to_check, fetched_password):
        print(f"Record match found with <{username.upper()}> username.")
        print(colored("LOGIN SUCCESSFUL...","green"))
        main_menu()
    else:
        print(colored("Record not found. Possibly incorrect username or password.","red"))
        login_menu()
    
    return 

# CREATION OF TABLES FUNCTIONS

def create_customer_table():
    """Create table to store customers"""
    cur.execute ("""CREATE TABLE IF NOT EXISTS customer
                    (
                        CustomerID        TEXT PRIMARY KEY AUTOINCREMENT,
                        Forename          TEXT NOT NULl,
                        Surname           TEXT,
                        DOB               TEXT NO NULL
                    ) 
                """)

    con.commit()

    return

def create_address_table():
    """Create table to store address of the customers"""
    cur.execute ("""CREATE TABLE IF NOT EXISTS address
                    (
                        AddressID       INTEGER PRIMARY KEY    AUTOINCREMENT,
                        Streetnumber    TEXT,
                        Firstline       TEXT NOT NULL,
                        Postcode        TEXT,
                        Region          TEXT NOT NULL,
                        Country         TEXT NOT NULL,
                        CustomerID      INTEGER NOT NULL,
                        FOREIGN KEY (CustomerID) REFERENCES customer(CustomerID)
                    )
    
                """)
    con.commit()
    return

def create_account_table():
    """Create table account to store account data"""
    cur.execute("""CREATE TABLE IF NOT EXISTS account
                    (
                        AccountID       INTEGER PRIMARY KEY AUTOINCREMENT,
                        Balance         REAL  NOT NULL,
                        Opendate        TEXT  NOT NULL,
                        Closedate       TEXT,
                        Status          TEXT  NOT NULL DEFAULT "ACTIVE",
                        CustomerID      INTERGER NOT NULL,
                        FOREIGN KEY (CustomerID)    REFERENCES customer(CustomerID)
                    )         
                """)

    con.commit()
    return
def create_transct_table():
    """Create table transct to record transactions"""
    cur.execute("""CREATE TABLE IF NOT EXISTS transct
                    (
                        TransactID      INTEGER PRIMARY KEY AUTOINCREMENT,
                        Amount          REAL NOT NULL,
                        Type            TEXT NOT NULL,
                        Date            TEXT NOT NULL,
                        AccountID       INTEGER NOT NULL,
                        FOREIGN KEY (AccountID) REFERENCES account(AccountID)
                    )
    
                
                
                """)


def login_menu():
    """provides menu options and directs user to relevant functions"""
    print("\n+------------------+\n|     WELCOME!!    |\n+------------------+\n| 1. Login         |\n+------------------+\n| 2. Register      |\n+------------------+\n| 3. Exit          |\n+------------------+")

    choice =input(colored("Enter number for option: ","blue")).strip()

    while choice not in ["1", "2","3"]:
        choice = input(colored("Error! Enter correct number for option: ","blue")).strip()

    if choice == "1":
        check_password()

    elif choice == "2":
        create_user_account()
    
    elif choice == "3":
        print(colored("See you soon, Good BYE!", "yellow"))
        
    return

# CUSTOMER OPTIONS AND MENUS


def customer_option_menu():
    table1 = prettytable.PrettyTable()
    table1.title = "Customers Options"
    table1.field_names = ["No.", "Option"]
    table1.add_row(["1.", "Create Customer Details"])
    table1.add_row(["2.", "View One Customer Details"])
    table1.add_row(["3.", "View All Customer Details"])
    table1.add_row(["4.", "Update One Customer Details"])
    table1.add_row(["5.", "Delete One Customer Details"])
    table1.add_row(["6.", "Return to main menu"])
    table1.add_row(["7.", "Exit"])
    print(table1)
    choice = input(colored("Choose An Option: ", "blue")).strip()
    while choice not in ["1", "2", "3", "4", "5", "6", "7"]:
        choice = input(colored("Wrong Input :(, Choose An Option: ", "red")).strip()
    if choice == "1":
        create_customer_details()
    elif choice == "2":
        view_one_customer()
    elif choice == "3":
        view_all_customer()
    elif choice == "4":
        update_one_customer()
    elif choice == "5":
        delete_one_customer()
    elif choice == "6":
        main_menu()
    elif choice == "7":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    
    return

def create_customer_details():
    customerid = input(colored("Please insert customer id: ", "blue"))
    forename = input(colored("Please insert forename: ", "blue"))
    lastname = input(colored("Please enter your lastname: ", "blue"))
    dob = input(colored("Insert the date of birth: ","blue"))
    cur.execute("INSERT INTO customer VALUES (?,?,?,?)", 
        (
            customerid,
            forename,
            lastname,
            dob
        )
    )
    con.commit()
    
    cur.connection.cursor()
    cur.execute("SELECT * FROM customer")
    c = from_db_cursor(cur)
    print(c)

    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        customer_option_menu()

    return

def view_one_customer():
    customer_id = input(colored("Insert the customer id for details: ", "blue"))
    cur.connection.cursor()
    cur.execute("SELECT * FROM customer WHERE CustomerID = ?" , (customer_id,))
    table1 = from_db_cursor(cur)
    print(table1)
    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        customer_option_menu()

    return

def view_all_customer():
    cur.connection.cursor()
    cur.execute("SELECT * FROM customer")
    table1 = from_db_cursor(cur)
    print(table1)

    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        customer_option_menu()

def update_one_customer():

    cur.connection.cursor()
    cur.execute("SELECT * FROM customer ")
    table01 = from_db_cursor(cur)
    print (table01)

    customer_id = input(colored("Insert the customer id to update: ", "blue"))

    cur.connection.cursor()
    cur.execute("SELECT * FROM customer WHERE CustomerID = ?", (customer_id,))
    table0 = from_db_cursor(cur)
    print (table0)


    customer_firstname = input(colored("Enter new name: ","blue"))
    customer_surname = input(colored("Enter new surname: ","blue"))
    customer_dob = input(colored("Insert Date of Birth updated: ", "blue"))
    
    cur.execute("UPDATE customer SET Forename = ?, Lastname = ?, DOB = ? WHERE CustomerID = ?", (customer_firstname,customer_surname, customer_dob, customer_id))
    con.commit()
    print(colored("Customer has been updated successfully...", "green"))
    time.sleep(1.5)
    
    cur.connection.cursor()
    cur.execute("SELECT * FROM customer WHERE CustomerID = ?", (customer_id,))
    table1 = from_db_cursor(cur)
    print (table1)

    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        customer_option_menu()
   
    return

def delete_one_customer():
    cur.connection.cursor()
    cur.execute("SELECT * FROM customer ")
    table0 = from_db_cursor(cur)
    print (table0)

    customer_id = input(colored("Insert the customer id to Delete: ", "blue"))

    
    cur.execute("DELETE FROM customer WHERE CustomerID = ?", (customer_id,))
    con.commit()
    print(colored("Customer deleted!", "green"))
    time.sleep(1)

    cur.connection.cursor()
    cur.execute("SELECT * FROM customer ")
    table1 = from_db_cursor(cur)
    print (table1)

    time.sleep(0.75)

    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        customer_option_menu()
   
    return

# ----------------------


def address_option_menu():
    table2 = prettytable.PrettyTable()
    table2.title = "Address Options"
    table2.field_names = ["No.", "Option"]
    table2.add_row(["1.", "Create Address Details"])
    table2.add_row(["2.", "View One Address Details"])
    table2.add_row(["3.", "View All Address Details"])
    table2.add_row(["4.", "Update One Address Details"])
    table2.add_row(["5.", "Delete One Address Details"])
    table2.add_row(["6.", "Main Menu"])
    table2.add_row(["7.", "Exit"])
    print(table2)

    choice = input(colored("Choose An Option: ", "blue")).strip()
    while choice not in ["1", "2", "3", "4", "5", "6", "7"]:
        choice = input(colored("Wrong Input :(, Choose An Option: ", "red")).strip()
    if choice == "1":
        create_address_details()
    elif choice == "2":
        view_one_address_details()
    elif choice == "3":
        view_all_address_details()
    elif choice == "4":
        update_one_address()
    elif choice == "5":
        delete_one_address()
    elif choice == "6":
        main_menu()
    elif choice == "7":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()

    return

def create_address_details():
    addressid = input(colored("Please insert address id: ", "blue"))
    streetnum = input(colored("Please insert Street number: ", "blue"))
    firstline = input(colored("Please enter first line of address: ", "blue"))
    postcode = input(colored("Insert postcode: ","blue"))
    region = input(colored("Please enter the region: ","blue"))
    country = input(colored("Please enter country: ","blue"))
    customerid = input(colored("Please enter CustomerID: ","blue"))
    cur.execute("INSERT INTO address VALUES (?,?,?,?,?,?,?)", 
        (
            addressid,
            streetnum,
            firstline,
            postcode,
            region,
            country,
            customerid
        )
    )
    con.commit()
    
    cur.connection.cursor()
    cur.execute("SELECT * FROM address")
    c = from_db_cursor(cur)
    print(c)

    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        address_option_menu()

    return
    
def view_one_address_details():
    
    address_id = input(colored("Insert the address id for details: ", "blue"))
    cur.connection.cursor()
    cur.execute("SELECT * FROM address WHERE AddressID = ?" , (address_id,))
    table1 = from_db_cursor(cur)
    print(table1)
    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        address_option_menu()

    return

def view_all_address_details():

    cur.connection.cursor()
    cur.execute("SELECT * FROM address ")
    table1 = from_db_cursor(cur)
    print(table1)
    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        address_option_menu()

    return

def update_one_address():
    cur.connection.cursor()
    cur.execute("SELECT * FROM address ")
    table01 = from_db_cursor(cur)
    print (table01)    

    address_id = input(colored("Insert the address id for update: ", "blue"))
    cur.connection.cursor()
    cur.execute("SELECT * FROM address WHERE AddressID = ?", (address_id,))
    table0 = from_db_cursor(cur)
    print (table0)
   
    address_streetnum = input(colored("Enter new street number: ","blue"))
    address_firstline = input(colored("Enter new address firstline: ","blue"))
    address_postcode = input(colored("Insert new postcode: ", "blue"))
    address_region = input(colored("Enter new region updated: ", "blue"))
    address_country = input(colored("Enter new countr updated: ", "blue"))
    address_customerID = input(colored("Enter customer ID: ","blue"))

    cur.execute("UPDATE address SET Streetnumber = ?, Firstline = ?, Postcode = ?, Region = ?, Country = ?, CustomerID = ? WHERE AddressID = ?", 
    (address_streetnum, address_firstline, address_postcode, address_region, address_country, address_customerID, address_id))

    con.commit()

    print(colored("Address has been updated successfully...", "green"))

    time.sleep(1.5)
    
    cur.connection.cursor()
    cur.execute("SELECT * FROM address WHERE AddressID = ?", (address_id,))
    table1 = from_db_cursor(cur)
    print (table1)

    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        address_option_menu()
   
    return

def delete_one_address():

    cur.connection.cursor()
    cur.execute("SELECT * FROM address ")
    table01 = from_db_cursor(cur)
    print (table01)    

    address_id = input(colored("Insert the address id to delete: ", "blue"))
    cur.execute("DELETE FROM address WHERE AddressID = ?", (address_id,))
    con.commit()

    print(colored("Address deleted!", "green"))
    time.sleep(1)

    cur.connection.cursor()
    cur.execute("SELECT * FROM address ")
    table1 = from_db_cursor(cur)
    print (table1)

    time.sleep(0.75)

    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        address_option_menu()
   
    return

# ACCOUNT MENUS AND OPTIONS

def account_option_menu():
    table3 = prettytable.PrettyTable()
    table3.title = "Account Options"
    table3.field_names = ["No.", "Option"]
    table3.add_row(["1.", "Create Account"])
    table3.add_row(["2.", "View Account(accountid)"])
    table3.add_row(["3.", "View Account(customerid)"])
    table3.add_row(["4.", "View All Open Accounts"])
    table3.add_row(["5.", "Update one Account"])
    table3.add_row(["6.", "Delete One Account"])
    table3.add_row(["7.", "Main Menu"])
    print(table3)

    choice = input(colored("Choose An Option: ", "blue")).strip()
    while choice not in ["1", "2", "3", "4", "5","6","7"]:
        choice = input(colored("Wrong Input :(, Choose An Option: ", "red")).strip()
    if choice == "1":
        create_account_option()
    elif choice == "2":
        view_one_account()
    elif choice == "4":
        view_all_accounts()
    elif choice == "3":
        view_one_account2()
    elif choice == "5":
        update_one_account()
    elif choice == "6":
        delete_one_account()
    elif choice == "7":
        main_menu()


    return


def create_account_option():
    accountid = input(colored("Please insert account id: ", "blue"))
    balance = input(colored("Please insert Initial balance: ", "blue"))
    opendate = input(colored("Please enter account open date: ", "blue"))
    closedate = input(colored("Insert account close date (or NULL): ","blue"))
    status = input(colored("Please enter account status: ","blue")).upper()
    customerid = input(colored("Please enter CustomerID: ","blue"))
    cur.execute("INSERT INTO account VALUES (?,?,?,?,?,?)", 
        (
            accountid,
            balance,
            opendate,
            closedate,
            status,
            customerid
        )
    )
    con.commit()    
    print(colored("Account created successfully....","green"))
    time.sleep(1)

    cur.connection.cursor()
    cur.execute("SELECT * FROM account")
    table1 = from_db_cursor(cur)
    print(table1)

    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        account_option_menu()

    return


  
def view_one_account():
    cur.connection.cursor()
    cur.execute("SELECT AccountID FROM account")
    table0 = from_db_cursor(cur)
    print (table0)

    account_id = input(colored("Select account id to view account details: ", "blue"))

    cur.connection.cursor()
    cur.execute("SELECT * FROM account WHERE AccountID = ?", (account_id,))
    table1 = from_db_cursor(cur)
    print(table1)

    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        account_option_menu()

    return

def view_one_account2():
    cur.connection.cursor()
    cur.execute("SELECT CustomerID FROM account")
    table0 = from_db_cursor(cur)
    print (table0)

    customer_id = input(colored("Select customer id to view account details: ", "blue"))

    cur.connection.cursor()
    cur.execute("SELECT * FROM account  WHERE CustomerID = ?", (customer_id,))
    table1 = from_db_cursor(cur)
    print(table1)

    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        account_option_menu()

    return


def view_all_accounts():
    #forename = input()
    cur.connection.cursor()
    cur.execute("SELECT * FROM account WHERE Status = ?",("ACTIVE",))
    table1 = from_db_cursor(cur)
    print(table1)
    time.sleep(0.75)
    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        account_option_menu()

    return

def update_one_account():
    cur.connection.cursor()
    cur.execute("SELECT * FROM account ")
    table01 = from_db_cursor(cur)
    print (table01)    

    account_id = input(colored("Insert the account id for update: ", "blue"))
    cur.connection.cursor()
    cur.execute("SELECT * FROM account WHERE AccountID = ?", (account_id,))
    table0 = from_db_cursor(cur)
    print (table0)

    balance = input(colored("Please enter new balance: ", "blue"))
    closedate = input(colored("Insert account close date (or NULL): ","blue"))
    status = input(colored("Please enter new account status: ","blue")).upper()
    customerid = input(colored("Please enter CustomerID: ","blue"))


    cur.execute("UPDATE account SET Balance = ?, Closedate = ?, Status = ?, CustomerID = ? WHERE AccountID = ?", 
    (balance, closedate, status, customerid, account_id))
    con.commit()

    print(colored("Account has been updated...", "green"))
    time.sleep(0.75)

    cur.connection.cursor()
    cur.execute("SELECT * FROM account WHERE AccountID =?", (account_id,))
    table01 = from_db_cursor(cur)
    print (table01) 

    time.sleep(0.75)
    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        account_option_menu()

    return

def delete_one_account():
    cur.connection.cursor()
    cur.execute("SELECT * FROM account ")
    table01 = from_db_cursor(cur)
    print (table01)    

    account_id = input(colored("Insert the account id to close: ", "blue"))
    cur.connection.cursor()
    cur.execute("SELECT * FROM account WHERE AccountID = ?", (account_id,))
    table0 = from_db_cursor(cur)
    print (table0)

    
    closedate = input(colored("Please enter close date: ","blue")).upper()


    cur.execute("UPDATE account SET Balance = 0, Closedate = ?, Status = 'CLOSED' WHERE AccountID = ?", 
    (closedate, account_id))
    con.commit()

    print(colored("Account has been CLOSED...", "red"))
    time.sleep(0.75)

    cur.connection.cursor()
    cur.execute("SELECT * FROM account WHERE AccountID =?", (account_id,))
    table01 = from_db_cursor(cur)
    print (table01) 

    time.sleep(0.75)
    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        account_option_menu()

    return

# TRANSACTIONS OPTIONS
def transact_options_menu():
    table7 = prettytable.PrettyTable()
    table7.title = "Account Options"
    table7.field_names = ["No.", "Option"]
    table7.add_row(["1.", "Create Transactions"])
    table7.add_row(["2.", "Read one account transaction"])
    table7.add_row(["3.", "Read all transacctions"])
    table7.add_row(["4.", "Read all transacctions by date"])
    table7.add_row(["5.", "Update transaction"])
    table7.add_row(["6.", "Delete transaction"])
    table7.add_row(["7.", "Main Menu"])
    table7.add_row(["8.", "Exit"])
    print(table7)

    choice = input(colored("Choose An Option: ", "blue")).strip()
    while choice not in ["1", "2", "3", "4", "5","6","7", "8"]:
        choice = input(colored("Wrong Input :(, Choose An Option: ", "red")).strip()
    if choice == "1":
        create_transactions()
    elif choice == "2":
        read_one_transaction()
    elif choice == "3":
        read_all_transactions()
    elif choice == "4":
        view_transact_date()
    elif choice == "5":
        update_one_transaction_record()
    elif choice == "6":
        delete_one_transaction_record()
    elif choice == "7":
        main_menu()
    elif choice == "8":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()


    return

def create_transactions(): 
   #accepts transaction data as args and inserts into transaction table
    transactionid = input(colored("Insert transaction id: ", "blue"))
    amount = input(colored("Insert amount: ", "blue"))
    type = input(colored("Insert transaction type: ", "blue")).upper()
    date = input(colored("Insert transaction date: ", "blue"))
    accountid = input(colored("Insert account id: ", "blue"))

    

    cur = con.cursor()
    cur.execute("INSERT OR REPLACE INTO transct VALUES (?, ?, ?, ?, ?)", (transactionid, amount, type, date, accountid))
    con.commit()
    print(colored("Transaction created!", "green"))

    time.sleep(0.75)
    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        transact_options_menu()

    return


def read_one_transaction():
    accountid = input(colored("Please enter account id: ","blue"))
    cur.connection.cursor()
    cur.execute("SELECT * FROM account WHERE AccountID = ?", (accountid,))
    table0 = from_db_cursor(cur)
    print(table0)
    time.sleep(0.5)

    date = input ("Insert date of the transaction: ")
    customer_id = input(colored("Please enter customer id: ","blue"))
    cur.connection.cursor()
    cur.execute("SELECT t.TransactID, t.Amount, t.Type, t.Date, t.AccountID FROM transct AS t INNER JOIN account AS a ON a.AccountID = t.AccountID INNER JOIN customer AS c ON c.CustomerID = a.CustomerID WHERE date=? AND c.CustomerID=?" ,(date, customer_id,))
    table5 = from_db_cursor(cur)
    print(table5)

    time.sleep(0.75)
    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        transact_options_menu()

    return

def read_all_transactions():
    #output all transaction records
    cur = con.cursor()
 
    cur.execute("SELECT * FROM transct")
    table7=from_db_cursor(cur)
    print(table7)
    
    time.sleep(0.75)
    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        transact_options_menu()

    
    return





def view_transact_date(): #new
    #output transactions based on date
    cur = con.cursor()
    accountid = input("Enter account ID to print transactions based on a date: ")
    date1 = input("Enter date: ")
    date2 = input("Enter second date: ")
    cur.execute("SELECT * FROM transct WHERE accountid = ? AND date BETWEEN ? AND ?", (accountid, date1, date2))
    table9=from_db_cursor(cur)
    print(table9)
    time.sleep(0.75)
    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        transact_options_menu()
    
    return



def update_one_transaction_record():
    #Change account record
    cur = con.cursor()
 
    cur.execute("SELECT * FROM transct")
    table7=from_db_cursor(cur)
    print(table7)

    transactionid = input("Enter transaction id for update: ")
    amount = input("Enter amount for update: ")
    type = input("Edit type of transaction:  ")
    date = input("Enter transaction date for update: ")
    accountid = input("Enter account id for update: ")
    cur.execute("""UPDATE transct
    SET  Amount = ?, Type = ?, Date = ?, AccountID = ?
    WHERE TransactID = ?""",(amount, type, date, accountid, transactionid))

    print("Transaction updated!!")

    time.sleep(0.75)
    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        transact_options_menu()
    

def delete_one_transaction_record():
    #delete one transaction from database
    
    cur = con.cursor()
 
    cur.execute("SELECT * FROM transct")
    table7=from_db_cursor(cur)
    print(table7)
    
    transactionid = input("Enter transaction to delete: ")
    cur.execute("DELETE from transct WHERE TransactID=?", (transactionid,))
    con.commit()
    print("Transaction deleted!!!")

    cur = con.cursor()
 
    cur.execute("SELECT * FROM transct")
    table7=from_db_cursor(cur)
    print(table7)

    time.sleep(0.75)
    choice = input(colored("Do you want to continue? (Y/N): ", "green")).strip().upper()
    while choice not in ["Y", "N"]:
        choice = input(colored("Wrong input! Try again (Y/N): ", "red")).strip().upper()
    if choice == "N":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    elif choice == "Y":
        transact_options_menu()

    
    


# OTHER OPTIONS

def login_more_options():
    talbe = prettytable.PrettyTable()
    talbe.title = "User options"
    talbe.field_names = ["No.", "Option"]
    talbe.add_row(["1.", "View All users"])
    talbe.add_row(["2.", "Delete User"])
    talbe.add_row(["3.", "Change Password"])
    talbe.add_row(["4.", "Return to menu"])
    talbe.align = "l"
    print(talbe)
    choice = input(colored("Enter corresponding number for option: ","blue")).strip()
    while choice not in ["1", "2", "3","4"]:
        choice = input(colored("Error! Enter corresponding number for option: ","red")).strip()
    if choice == "1":
        
        cur.connection.cursor()
        cur.execute("SELECT username as Username FROM user")
        t = from_db_cursor(cur)
        print(t)
        continue1 = input(colored("Exit? (Y/N): ","green")).upper()
        while continue1 not in ["Y", "N"]:
            continue1 = input(colored("Wrong input! Exit? (Y/N): ","red")).upper()
        if continue1 == "Y":
            print(colored("See you soon, Good BYE!", "yellow"))
            exit()
        elif continue1 == "N":
            login_more_options()

    elif choice == "2":
        username = input("Enter username to delete: ").lower().strip()
        cur.execute ("DELETE FROM user WHERE username = ?", (username,))
        con.commit()
        print(colored("User deleted successfully...", "green")) 

        continue1 = input(colored("Exit? (Y/N): ","green")).upper()
        while continue1 not in ["Y", "N"]:
            continue1 = input(colored("Wrong input! Exit? (Y/N): ","red")).upper()
        if continue1 == "Y":
            print(colored("See you soon, Good BYE!", "yellow"))
            exit()
        elif continue1 == "N":
            login_more_options()
        
    elif choice == "3":
        username1 = input("Enter username to update password: ").lower().strip()
        hidden_password = maskpass.askpass ("Enter new passwords: ")
        plain_password = hidden_password.strip().encode('utf-8')

        password = hash_password(plain_password)
        
        cur.execute ("UPDATE user SET password = ? WHERE username = ?", (password,username1))

        con.commit()
        print(colored("Password updated successfully...", "green"))
        time.sleep(1)
        continue1 = input(colored("Exit? (Y/N): ","green")).upper()
        while continue1 not in ["Y", "N"]:
            continue1 = input(colored("Wrong input! Exit? (Y/N): ","red")).upper()
        if continue1 == "Y":
            print(colored("See you soon, Good BYE!", "yellow"))
            exit()
        elif continue1 == "N":
            login_more_options()

    elif choice == "4":
        main_menu()
    
    return

def main_menu():
    mytable=prettytable.PrettyTable()
    mytable.title = "MAIN MENU"
    mytable.field_names = ["No.", "Option"]
    mytable.add_row(["1.", "Customer options"])
    mytable.add_row(["2.", "Address options"]) 
    mytable.add_row(["3.", "Account options"])
    mytable.add_row(["4.", "Transaction options"])
    mytable.add_row(["5.", "User options"])
    mytable.add_row(["6.", "Exit"])
    print (mytable)
    select = input(colored("Please choose an option: ","blue")).strip()
    while select not in ["1", "2", "3", "4", "5","6"]:
        select = input(colored("Error!!, Please choose one option: ","red")).strip()
    
    if select == "1":
        customer_option_menu()
    elif select == "2":
        address_option_menu()
    elif select == "3":
        account_option_menu()
    elif select == "4":
        transact_options_menu()
    elif select == "5":
        login_more_options()
    
    elif select == "6":
        print(colored("See you soon, Good BYE!", "yellow"))
        exit()
    return


# MAIN PROGRAMM 

create_user_table()
create_customer_table()
create_address_table()
create_account_table()
create_transct_table()


login_menu()



