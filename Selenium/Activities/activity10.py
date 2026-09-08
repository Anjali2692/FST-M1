from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/mouse-events")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    actions = ActionChains(driver)

    
    cargo_lock = driver.find_element(By.XPATH, "//h1[text()='Cargo.lock']")
    cargo_toml = driver.find_element(By.XPATH, "//h1[text()='Cargo.toml']")

    
    actions.click(cargo_lock) \
           .pause(1) \
           .move_to_element(cargo_toml) \
           .pause(4) \
           .click() \
           .perform()

    
    result1 = driver.find_element(By.ID, "result")
    print("First Action Result:", result1.text)

    
    src = driver.find_element(By.XPATH, "//h1[text()='src']")
    target = driver.find_element(By.XPATH, "//h1[text()='target']")

    
    actions = ActionChains(driver)

    
    actions.double_click(src) \
           .pause(4) \
           .context_click(target) \
           .pause(4) \
           .perform()

    
    open_option = driver.find_element(
        By.XPATH,
        "//div[@id='menu']/div/ul/li[1]"
    )
    open_option.click()

    
    result2 = driver.find_element(By.ID, "result")
    print("Second Action Result:", result2.text)

finally:
    
    driver.quit()