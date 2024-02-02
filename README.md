# **Deckster Skate Shop**

Welcome to Deckster Skate Shop, an online skateboard store application! This README provides a detailed overview of the changes made in response to prompts C to J. 

## **C. Customized HTML User Interface** 

### **mainscreen.html** 

**Line 18:** Modified the h1 tag to display the shop's name. 

## **D. Added an “About” Page** 

### **about.html** 

**Lines 17-21**: Added an "About Deckster" section with a company description. 

**Line 21:** Included a navigation link back to the main screen. 

### **mainscreen.html** 

**Line 19**: Added a navigation link to the About page. 

## **E. Sample Inventory Addition** 

### **BootStrapData.java** 

**Line 23:** Added InhouseRepository for constructor parameter. 

**Lines 35-46:** Implemented a method that checks if product and parts lists are empty, and if so, adds five parts and products to the sample inventory. 

## **F. "Buy Now" Button Addition** 

### **mainscreen.html** 

**Line 85:** Added a "Buy Now!" button. 

### **AddProductController.java** 

**Line 130:** Implemented a method that decrements product inventory by one. 

### **confirmationbuyproduct.html** 

**Line 08:** Added a success message upon purchase. 

## **G. Parts Inventory Tracking Modification** 

### **Part.java** 

**Lines 36-41:** Added minimum and maximum inventory fields. 

### **inhousePartForm.html** 

**Lines 24-28:** Added input fields for minimum and maximum inventory. 

## **H. Validation for Minimum and Maximum Fields** 

### **Part.java** 

**Lines 34-39:** Added validation for minimum and maximum values with appropriate error messages. 

## **I. Unit Tests for Maximum and Minimum Fields** 

### **PartTest.java** 

**Lines 171, 184, 196, 208:** Added tests to ensure that minInventory and maxInventory stay within the specified limits. 

## **J. Unused Validators Removal** 

### **Removed unused class files for cleaner code:** 

AddPartController.java 

MainScreenController.java 

PartRepository.java 

ProductRepository.java 

InhousePartService.java 

InhousePartServiceImpl.java 

OutsourcedPartService.java 

OutsourcedPartServiceImpl.java 

PartService.java 

PartServiceImpl.java 

ProductService.java 

ProductServiceImpl.java 

DeletePartValidator.java 

PriceProductValidator.java 

ProductTest.java 

 
