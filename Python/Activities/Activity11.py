fruit_shop = {
    "apple": 50,
    "banana": 100,
    "orange": 30,
    "peaches": 70
}

key_to_check = input("What are you looking for? ").lower()

if(key_to_check in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")