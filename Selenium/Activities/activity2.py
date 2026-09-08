from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


driver = webdriver.Firefox()

try:
    driver.get("https://training-support.net/webelements/login-form/")

    print("Page Title:", driver.title)

    wait = WebDriverWait(driver, 10)

    username = wait.until(EC.presence_of_element_located((By.ID, "username")))
    username.send_keys("admin")

    password = driver.find_element(By.ID, "password")
    password.send_keys("password")

    login_btn = wait.until(EC.element_to_be_clickable((By.TAG_NAME, "button")))
    login_btn.click()

finally:
    driver.quit()