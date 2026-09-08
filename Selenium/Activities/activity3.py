from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/login-form/")

    
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    driver.find_element(By.ID, "username").send_keys("admin")

    
    driver.find_element(By.ID, "password").send_keys("password")

    
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()

finally:
    
    driver.quit()