"""Name= 10.789
print(Name)
print('Ammmu')
print("Hello, World!")

print(0.1+0.2==0.3)

t = (1,2,4,3)
print(t[1:3])"""   #THis is a comment
# print("Hello World!")

"""x=1 
y=2.7
z=1j
print(z)
print(type(x))"""



a="""Amrutha is working in IBM as test specilaist. She is working for project named
BRET"""
print(a)
print(a[0])
print(a[7])
print(a[8:9])   #start and end of the index, 9th index value will not br printed
print(len(a))
print(a.lower())
print(a.upper())
print(a.replace('Amrutha','Kaveri'))
print(a.split('.'))
print('Kaveri' in a) 
print('Amrutha' not in a) 
b='She is working in IBM from 3yrs'
month=3
print(a+b)                    #concatenation (String and number cannot be concatinated)
#String and integers can be concatinated by using format() with placing {} where integer has to be printed
txt= "My DOB contains {}"
print(txt.format(month))
date=2
year=1995
txt2= "My DOB is {} {} {}"
print(txt2.format(date, month, year))
txt3= "My DOB is {1} {0} {2}"
print(txt3.format(date,month,year))

h=2
h **= 4
print(h)

username= input("Enter username: ")
print(username)