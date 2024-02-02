import time                                                            # Here we import the time function to make little stops to make the program more efficient and well developed
largest = None                                                         # We start the program declaring the variables for smallest, largest, num which we are goin to ask the user...
smallest = None
num = None                  
list1 = []                                                             # Define the list which will store the values of the marks inserted by the user.
index_numbers = 0                                                      # this variable will count the number of marks which the user has inserted. All need to be declared empty
x = False                                                              # this variable will allow us to make the decision of quit or continue. It will be False until we select to continue
while x == False:                                                      # this is the condition for it if x=false, continue running the program until it is True.
    while num != "done":                                               # Here we put a condition that until the user types "done", the program will continue asking us to type the marks.
        num = (input('Enter your marks (0-100): '))                    # This line asks the user to input the marks
        if num != "done":                                              # this if makes the program to just save those marks before typing 'done' to finish typing new values.
            index_numbers+=1                                           # while we type the marks, the program is saving how many grades we have inserted and it is adding each number to the list.
            num2 = num
            list1.insert(index_numbers, int(num2))
                                                                       
    for i in list1:                                                    # here we compare each number of the list which has been created if it is larger or not, and we save it in
        if largest is None:                                            # variable largest to have the biggest onee.
            largest = i
        if i > largest: 
            largest = i
    for i in list1:                                                    # here we do the same process but with the smallest number in the list.
        if smallest is None:
            smallest = i
        if i < smallest: 
            smallest = i
    sum = 0                                                            # with this commands the thing we do is add all the numbers of the list and get the average of them.
    for i in list1:
        sum = sum+i

    average = sum / index_numbers


    print ('The list we get after inserting numbers is: ', list1)    # After getting all the things done the program will print the list we get, the largest number, the lowest, and the average of them
    print('The largest Mark is:', largest)
    print('The smallest Mark is:', smallest)
    print('The average we get is:',average)
    time.sleep(2)                                                    # with this command we make the console wait 2 secs
    print()                                                          # here we ask the user if he wants to continue or to quit
    print("Start Again? yes/quit...")
    again=input()
    if again == "quit":                                              # if he types quit, the program will end, but in case he types to continue, all the previous variables will ve reset,
        x=True                                                       # to 0 to start again asking the marks.
    else:                                                            # If we dont reset all the variables, the program will use the previous values already stored.
        x = False                                                    # So it is important to do it.
        num = None
        largest = None
        smallest = None
        num = None
        list1 = []
        index_numbers = 0