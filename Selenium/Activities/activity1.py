
from selenium import webdriver
from selenium.webdriver.common.by import By
import time

driver = webdriver.Firefox()

driver.get("https://training-support.net")

print("Home Page Title:", driver.title)
time.sleep(2)

about_us = driver.find_element(By.LINK_TEXT, "About Us")
about_us.click()

time.sleep(2)
print("About Us Page Title:", driver.title)
driver.quit()
