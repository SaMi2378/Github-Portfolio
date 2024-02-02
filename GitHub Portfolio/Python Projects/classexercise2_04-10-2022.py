hours = float(input("Insert worked hours: "))
rate = float(input("Insert pay-rate: "))
if hours > 40:
    extra = (hours-40)*1.5*rate
    pay = 40* rate
    pay2 = pay + extra
    print("The total pay is:",pay2)
else:
    pay = hours * rate
    print("The total pay is:",pay)

