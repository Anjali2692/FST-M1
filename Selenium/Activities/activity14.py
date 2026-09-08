from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/tables")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    rows = driver.find_elements(By.XPATH, "//table/tbody/tr")
    print("Number of Rows:", len(rows))

    
    columns = driver.find_elements(By.XPATH, "//table/thead/tr/th")
    print("Number of Columns:", len(columns))

    
    book_before_sort = driver.find_element(
        By.XPATH, "//table/tbody/tr[5]/td[1]"
    )
    print("Book in 5th Row (Before Sorting):", book_before_sort.text)

    
    price_header = driver.find_element(
        By.XPATH, "//table/thead/tr/th[contains(text(),'Price')]"
    )
    price_header.click()

    
    wait = WebDriverWait(driver, 5)
    wait.until(
        EC.presence_of_element_located((By.XPATH, "//table/tbody/tr[5]/td[1]"))
    )

    
    book_after_sort = driver.find_element(
        By.XPATH, "//table/tbody/tr[5]/td[1]"
    )
    print("Book in 5th Row (After Sorting):", book_after_sort.text)

finally:
    
    driver.quit()