from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/keyboard-events")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    message = "Hello Selenium!"

    
    actions = ActionChains(driver)

    
    actions.send_keys(message).perform()

    
    print("Typed Message:", message)

finally:
    
    driver.quit()