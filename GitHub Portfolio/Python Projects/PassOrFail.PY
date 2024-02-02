print("$$$ Have you Passed? $$$")
x = False


while x == False:
    grade = int(input("Please, input your grade: "))
    
    if grade >= 40: 
        print ("Congratulations, you've passed!!!")
        print("Exit? Yes/No")
        quit = input("")
        if quit == "Yes":
            x = True
        elif quit == "No":
            x = False

    else:
        print("I am sorry, You have failed!!!")
        print("Exit? Yes/No")
        quit = input("")
        if quit == "Yes":
            x = True
        elif quit == "No":
            x = False


