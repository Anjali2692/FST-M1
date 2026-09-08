from selenium import webdriver
from selenium.webdriver.common.by import By
import time


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/popups")
    driver.maximize_window()

    print("Page Title:", driver.title)

    
    driver.find_element(By.ID, "launcher").click()

    time.sleep(2)

    
    driver.find_element(By.ID, "username").send_keys("admin")
    driver.find_element(By.ID, "password").send_keys("password")

    
    driver.find_element(By.XPATH, "//button[contains(text(),'Submit')]").click()

    
    message = driver.find_element(By.CSS_SELECTOR, "h2.text-center").text
    print("Login message text:", message)

finally:
    
    driver.quit()