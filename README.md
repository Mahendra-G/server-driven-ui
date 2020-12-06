# server-driven-ui

# Abstract
  This project is about server driven UI integration with API call, implemented with MVP architecture design. 
  Through supplied dummy options the respective API is called to render the screen by passing selected option id as argument.
  
# Problem Definition
  This project implements Server driven UI implementation with MVP architecture,
  where the first screen will have a dropdown with three options “Option 1, Option 2, Option 3”. 
  Once the option is selected and user proceeds, the API endpoint will be hit with an input parameter called type and its value will be 1, 2, or 3,
  one for each of the options correspondingly. The API response will have the contents and details of the dynamic screen to be rendered after proceeding. 
  This screen will be a form with a title, some inputs and a proceed button. The inputs fields will have their UI Element Type, the placeholders and the validation rules.
  The user will only be able to proceed, if all the validations specified in the API response are satisfactory. 
  If not, the user should be prompted with an understandable error message.
  
  
# User guide with screenshots – Technical explanation
  In the first screen where dummy options are displayed using a spinner/dropdown. 
  Once the user selects the correct option, the option id is passed as an argument or parameter to the API call as selectedId, 
  proper message is displayed to the user on selection of incorrect option/input.
  
  Second screen is rendered on selecting Option 1, where dynamically the views are loaded.
  Proper validation is done on the fields where user input is recorded and messages are displayed accordingly. 
  This method of API calling is done using MVP architecture design pattern. getDeatils() function is used for initializing the API call and rendering views.
  Second screen is re-used to diplay a different UI which is rendered dynamically on selecting Option 2, same method is followed in rendering third UI screen dynamically
  on selecting Option 3.
  
  
# Conclusion
  The project implements end-to-end functionality of rendering Server driven UI on passing the selected option with valid validations of the fields.
