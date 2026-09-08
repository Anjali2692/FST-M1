from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select


driver = webdriver.Firefox()

try:
    
    driver.get("https://training-support.net/webelements/selects")
    driver.maximize_window()

    
    print("Page Title:", driver.title)

    
    multi_select_element = driver.find_element(By.XPATH, "(//select)[2]")

    
    multi_select = Select(multi_select_element)

    
    if multi_select.is_multiple:

        
        multi_select.select_by_visible_text("HTML")

        
        multi_select.select_by_index(3)
        multi_select.select_by_index(4)
        multi_select.select_by_index(5)

        
        multi_select.select_by_value("nodejs")

        
        multi_select.deselect_by_index(5)

        print("Multi-select operations completed successfully.")

    else:
        print("This dropdown does not support multiple selection.")

    
    print("\nSelected Options:")
    selected_options = multi_select.all_selected_options

    for option in selected_options:
        print(option.text)

finally:
    
    driver.quit()