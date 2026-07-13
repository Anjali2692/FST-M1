import pandas as pd

df = pd.read_csv("users.csv")

print(df["Usernames"])

print(df.loc[1, ["Usernames", "Passwords"]])

print(df.sort_values("Usernames"))

print(df.sort_values("Passwords", ascending=False))