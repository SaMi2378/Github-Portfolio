import time
x=False
while x == False:
    print
    income= float(input('Please input your income per year: '))
    if income <= 12570:
        tax = 0 
        print('calculating -->')
        time.sleep(0.5)
        print('Tax rate: 0%')
        print('Taxable income:', "£""{:,.2f}".format(0))
        print('Tax:', "£"'{:,.2f}'.format(tax))
        print()
        print("Start Again? yes/quit")
        again= input()
        if again == "yes":
            x=False
        elif again=="quit":
            x= True
        

    elif income >= 12571 and income <= 50270:
        tax = (income - 12570)*0.2
        print('calculating -->')
        time.sleep(0.5)
        print('Tax rate: 20%')
        print('Taxable income:', "£""{:,.2f}".format(income-12570))
        print('Tax:', "£"'{:,.2f}'.format(tax))
        print('You dont have to pay!!! ;)')
        print()
        print("Start Again? yes/quit")
        again= input()
        if again == "yes":
            x=False
        elif again=="quit":
            x= True
    
    elif income >= 50271 and income <= 125140:
        tax = ((50270-12570)*0.2)  +  ((income-50270)*0.4)
        print('calculating -->')
        time.sleep(0.5)
        print('Tax rate: 40%')
        print('Taxable income:', "£""{:,.2f}".format(income-12570))
        print('Tax:', "£"'{:,.2f}'.format(tax))
        print()
        print("Start Again? yes/quit")
        again= input()
        if again == "yes":
            x=False
        elif again=="quit":
            x= True

    elif income >= 125141 and income <= 150000:
        tax = (income-50270)*0.4 + (50270*0.2)
        print('calculating -->')
        time.sleep(0.5)
        print('Tax rate: 40%')
        print('Taxable income:', "£""{:,}".format(income))
        print('Tax:', "£"'{:,.2f}'.format(tax))
        print()
        print("Start Again? yes/quit")
        again= input()
        if again == "yes":
            x=False
        elif again=="quit":
            x= True

    elif income > 150000:
        tax = ((income-150000)*0.45 ) + ((150000-50270)*0.4) + (50270*0.2)
        print('calculating -->')
        time.sleep(0.5)
        print('Tax rate: 40%')
        print('Taxable income:', "£""{:,}".format(income))
        print('Tax:', "£"'{:,.2f}'.format(tax))
        print()
        print("Start Again? yes/quit")
        again= input()
        if again == "yes":
            x=False
        elif again=="quit":
            x= True