# GoEuroApi_dev-test
use Go euro api to generate csv by given city name

How to run jar
Download the jar name "GoEuroApi.jat" from Executable jar
from command prompt type

java -jar Path_to_Jar\GoEuroApi.jar Desired_city_Name

successfull execution will generate csv file name "Desired_city_Name_Current_Date_Time.csv" 
in same location where jar file is located.

Get message in case of invalid city name prvided

Source code are provided as well.

Used Api Url: http://api.goeuro.com/api/v2/position/suggest/en/CITY_NAME

used library:

 1. commons.io
 2. commons-lang.
 3. json-lib
 4. commons-beanutils
 5. commons-logging
 6. ezmorph.
 
Credit:
  For json to csv: https://github.com/SEL-Columbia/json-to-csv
