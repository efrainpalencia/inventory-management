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

### **AddinhousePartController.java**

**Lines 43-46:** Added logic to enforce minimum and maximum values.

### **AddOutsourcedPartController.java**

**Lines 44-47:** Added logic to enforce minimum and maximum values.

## **I. Unit Tests for Maximum and Minimum Fields** 

### **PartTest.java** 

**Lines 171, 184, 196, 208:** Added tests to ensure that minInventory and maxInventory stay within the specified limits. 

### **EnufPartsValidator.java**

**Lines 22,27, 36-45:** Included a constraint to check for parts below the minimum.

### **LowInventoryException.java**

**LInes 1-10:** Created a custom exception handler for below the minimum inventory.

## **J. Unused Validators Removal** 

### **Removed unused class files for cleaner code:**

DeletePartValidator.java 


 
