def test(i,j):
    if(i==0):
        return j
    else:
        return test(i-1,i+j)

print(test(5,7))

print(5,7)