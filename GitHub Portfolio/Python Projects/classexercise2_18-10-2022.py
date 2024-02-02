def Sqr(n1, n2):
    
    addition = (n1*n1) + (n2*n2)
    return addition


print ( 'Calling with floats')

# call with two floats
float1 = float(input('Please insert the second numebr: '))
float2 = float(input('Please insert the second numebr: '))
result = Sqr(float1, float2)
print(result)

print ( 'Calling with integers')
# call with two integers
int1 = int(input('Please enter a number: '))
int2 = int(input('Please enter a number: '))

result2 = Sqr(int1, int2)
print(result2)

# call with one int and one float
int3 = int(input('Please enter a number: '))
float3 = float(input('Please enter a number: '))

result3 = Sqr(int3, float3)
print(result3)