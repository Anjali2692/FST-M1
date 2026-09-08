from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/alerts")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    driver.find_element(By.XPATH, "//button[contains(text(),'Confirm')]").click()

    
    alert = driver.switch_to.alert

    
    print("Alert Text (OK):", alert.text)

    
    alert.accept()
    print("Clicked OK")

    
    driver.find_element(By.XPATH, "//button[contains(text(),'Confirm')]").click()

    
    alert = driver.switch_to.alert

    
    print("Alert Text (Cancel):", alert.text)

    
    alert.dismiss()
    print("Clicked Cancel")

finally:
    
    driver.quit()