def check_continue ():
    quit=input('To exit please insert Y/N: ')
    if quit =="Y":
        x=True
        
    elif quit == "N":
        x=False
    
    return x

def check_numeric(n):
    while n.isnumeric()==False:
        n = input()
    if n.isnumeric():
        n = int(n)
        return n 

def computepay(hours,rate):
    if rate == 0:
        rate == 10
 
    if hours <= 40:
        pay = hours * rate
    elif hours > 40:
        pay = (40*rate) + ((hours-40)*1.5*rate)
        
        print(pay)

# MAIN PROGRAM
f=False
while f == False:
    hours = input('Please insert the number of hours worked: ')
    rate = input('Insert the pay rate (Optional): ')
    

    print(computepay(10,rate))
    
    f = check_continue()
 