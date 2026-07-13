def sum_numbers(n):
    if n == 0:
        return 0
    # Recursive case
    return n + sum_numbers(n - 1)

result = sum_numbers(10)
print("Sum from 0 to 10 is:", result)