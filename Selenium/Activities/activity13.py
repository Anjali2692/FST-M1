from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/tables")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    rows = driver.find_elements(By.XPATH, "//table/tbody/tr")
    print("Number of Rows:", len(rows))

    
    columns = driver.find_elements(By.XPATH, "//table/thead/tr/th")
    print("Number of Columns:", len(columns))

    
    print("\nValues in Third Row:")

    third_row_cells = driver.find_elements(By.XPATH, "//table/tbody/tr[3]/td")

    for cell in third_row_cells:
        print(cell.text, end=" ")

    
    cell_value = driver.find_element(By.XPATH, "//table/tbody/tr[2]/td[2]")

    print("\n\nValue at Row 2, Column 2:", cell_value.text)

finally:
    
    driver.quit()