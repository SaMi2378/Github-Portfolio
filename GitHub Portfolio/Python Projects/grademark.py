import time
x= False
while x == False:
        mark=int(input('Please insert your grade of the module: '))
        if mark < 40:
                print('Calculating.....')
                time.sleep(2)
                print ("Your grade mark is F, I'm sorry... You've failed.")
                time.sleep(1)
                print("Start Again? yes/quit...")
                again=input()
                if again == "quit":
                        x=True
                else: 
                        X = False
        elif mark >= 40 and mark < 50:
                print('Calculating.....')
                time.sleep(2)
                print ("Your grade mark is D, Congratulations :), You've Passed!")
                time.sleep(1)
                print("Start Again? yes/quit...")
                again=input()
                if again == "quit":
                        x=True
                else: 
                        X = False

        elif mark >= 50 and mark < 60:
                print('Calculating.....')
                time.sleep(2)
                print ("Your grade mark is C, Congratulations :), You've Passed!")
                time.sleep(1)
                print("Start Again? yes/quit...")
                again=input()
                if again == "quit":
                        x=True
                else: 
                        X = False

        elif mark >= 60 and mark < 70:
                print('Calculating.....')
                time.sleep(2)
                print ("Your grade mark is B, Congratulations :), You've Passed!")
                time.sleep(1)
                print("Start Again? yes/quit...")
                again=input()
                if again == "quit":
                        x=True
                else: 
                        X = False

        elif mark >= 70 and mark < 101:
                print('Calculating.....')
                time.sleep(2)
                print ("Your grade mark is A, Congratulations :), You've Passed!")
                time.sleep(1)
                print("Start Again? yes/quit...")
                again=input()
                if again == "quit":
                        x=True
                else: 
                        X = False

        else:
                x=False



