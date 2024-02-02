def letter_calculator(line, upper_case, lower_case):
    for i in line:
        if i.isupper():
            upper_case = upper_case + 1

        if i.islower():
            lower_case = lower_case + 1
    print('Calculating.....')
    print('There are',upper_case,'upper letters.')

    print('There are',lower_case,'lower letters.')
    
# MAIN PROGRAM
text = input('Please insert a text line --> ')
upper = 0
lower = 0
letter_calculator(text, upper, lower)


