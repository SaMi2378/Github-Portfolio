print("$$$ Simple Calculator $$$")
num1 = float(input("Please, Insert the first number: "))

x = False
while x == False: 
    print("1. For Addition press +")
    print("2. For Subtraction press -")
    print("3. For Multiplication press *")
    print("4. For Division press /")
    operation = input("Please select the operation:  ")
    if operation == "+":
        x = True
    elif operation == "-":
        x = True
    elif operation == "*":
        x = True
    elif operation == "/":
        x = True
    

num2 = float(input("Please, Insert the second number: "))
if operation == "+":
    result = num1 + num2
    print("The result of the addition is: ",result)
elif operation == "-":
    result = num1 - num2
    print("The result of the subtraction is: ",result)
elif operation == "*":
    result = num1 * num2
    print("The result of the multiplication is: ",result)
elif operation == "/":
    result = num1 / num2
    print("The result of the division is: ",result)

