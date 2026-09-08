from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/dynamic-controls")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    wait = WebDriverWait(driver, 10)

    
    checkbox = driver.find_element(By.ID, "checkbox")

    
    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()

    
    wait.until(EC.invisibility_of_element_located((By.ID, "checkbox")))
    print("Checkbox is removed.")

    
    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()

    
    wait.until(EC.visibility_of_element_located((By.ID, "checkbox")))

    
    checkbox = driver.find_element(By.ID, "checkbox")

    
    print("Checkbox is displayed:", checkbox.is_displayed())

finally:
    
    driver.quit()