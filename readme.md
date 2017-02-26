#Berlin Clock
This project provides a basic string visualization of [Berlin Clock](http://www.3quarks.com/en/BerlinClock/).  

##Berlin Clock Description: 
    - The top lamp is a pump which is blinking on/off every two seconds. 
      (I have picked Yellow lamp based on the link above)
    - In the topmost line of red lamps every lamp represents 5 hours.
    - In the second line of red lamps every lamp represents 1 hour. 
    - In the third line with tall lamps every lamp represents 5 minutes. 
      There are 11 lamps, the 3rd, 6th, and 9th are red indicating the first quarter, half, and the last quarter of the hour.
    - In the last line with yellow lamps every lamp represents 1 minute.
    
##Execute 
- `mvn clean package`  
- `mvn exec:java` - arguments are set to 0 as default  
  `mvn exec:java -Dhrs=10 -Dmin=10 -Dsec=10`  
  `java -cp ./target/berlinclock-1.0-SNAPSHOT.jar com.hotels.silvievyhnankova.berlinclock.Main 20 20 02` 
        
##Output Example
    input: mvn exec:java -Dhrs=23 -Dmin=59 -Dsec=59
    output: ---23:59:59---
            0
            RRRR
            RRR0
            YYRYYRYYRYY
            YYYY
            -------------



