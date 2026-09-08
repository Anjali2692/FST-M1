from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/dynamic-controls")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    checkbox = driver.find_element(By.ID, "checkbox")

    
    checkbox.click()
    print("Checkbox is selected:", checkbox.is_selected())

    
    checkbox.click()
    print("Checkbox is selected:", checkbox.is_selected())

finally:
    
    driver.quit()