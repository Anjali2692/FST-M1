from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/alerts")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    driver.find_element(
        By.XPATH,
        "//button[contains(text(),'Simple')]"
    ).click()

    
    alert = driver.switch_to.alert

    
    print("Alert Text:", alert.text)

    
    alert.accept()

    print("Alert accepted successfully.")

finally:
    
    driver.quit()