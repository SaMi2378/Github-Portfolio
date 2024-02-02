import random, time                                     # to use the random and time commands we have to import the both libraries
n= random.randint(1,9)                                  # first of all we generate a random number betwwen 1 to 9    
exit= False                                             # here the program creates two variables exit and count 
count=0                                                 
print ('Guess Number generated....')                    # this two following lines are to make the program more developed
time.sleep(1)                                           
while exit == False:                                    # to keep running the program we put this condition that exit is False.
    user = input('Guess the number (1-9) --> ')         # here the program asks the user to insert a number to compare and guess.
    if user.isnumeric():
        user=int(user)
        if user < n:                                   # if the number is lower than the random number generated, the program will print LOW
            print('You have guessed LOW')
        
        elif user > n:                                 # if the number is upper than the random number generated, the program will print HIGH
            print('You have guessed HIGH')
        
        elif user == n:                                # if the number inserted is the same as the random number generated, the program will print RIGHT   
            print('You have guessed it!!!')                 # then it wil add the number of numbers guessed in a variable which we created count
            count+=1
            time.sleep(0.5)
            print('Generating new number.... (Type exit to quit)')
            time.sleep(1)
            n= random.randint(1,9)
    elif user == 'exit':
        print('You have guessed',count,'numbers.')
        exit=True
            