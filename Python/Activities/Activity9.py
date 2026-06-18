# Given lists
listOne = [1, 2, 4, 5, 9]
listTwo = [13, 22, 24, 36, 41]

print("First List ", listOne)
print("Second List ", listTwo)

thirdList = []

for num in listOne:
    if (num % 2 != 0):
        thirdList.append(num)
        
for num in listTwo:
    if (num % 2 == 0):
        thirdList.append(num)

print("result List is:")
print(thirdList)