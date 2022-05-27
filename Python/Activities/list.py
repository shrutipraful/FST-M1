list1= ["A","B","C","D","E"]
print(list1)
print(list1[1:4])
print(list1[:3])
print(list1[2:])

for x in list1:
            print(x)

print(len(list1))
print(list1[2])
print(list1[-1])
list1.append("F")
print(list1)
list1.insert(2,"G")
print(list1)
list1.remove("E")
print(list1)
list1.pop()
print(list1)
list2= list1.copy()
print("list2: ", list2)
list3= list1+list2
print(list3)