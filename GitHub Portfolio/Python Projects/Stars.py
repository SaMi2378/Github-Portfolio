#Main Program
n = 0                                 # here we set a counter, which we will be incresing with every set of stars. This will allow us to do the set of starts 3 times
while n !=3:                           # here we can decide the number of times we want the set of stars to be drawn.
    for i in range (1,10):             # we put range of 1 to 10 because by default the program is not going to use the number 10 it will do a range from 1 to n-1 in this case 1 to (10-1)
        print("*"*i)
        print()
    n+=1    
