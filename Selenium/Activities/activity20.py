from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/alerts")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    driver.find_element(By.XPATH, "//button[contains(text(),'Prompt')]").click()

    
    alert = driver.switch_to.alert

    
    print("Alert Text:", alert.text)

    
    alert.send_keys("Awesome!")

    
    alert.accept()

    print("Entered text and clicked OK.")

finally:
    
    driver.quit()