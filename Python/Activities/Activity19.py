import pandas as pd

data = {
    "FirstName": ["Satvik", "Avinash", "Lahri"],
    "LastName": ["Shah", "Kati", "Rath"],
    "Email": [
        "satshah@example.com",
        "avinashk@example.com",
        "lahri.rath@example.com"
    ],
    "PhoneNumber": [4537829158, 5892184058, 4528727830]
}

df = pd.DataFrame(data)

df.to_excel("users.xlsx", index=False)

print("Excel file created successfully.")