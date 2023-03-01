# FT File Parser
A simple parser for providing text statistics scraped from the file.

## Supported File Types
- *.pdf
- *.txt (plain text)

## File Statistics
- Word count
- Most words used
- Dot (.) character count

## Build and Run Setup
1. Load the Maven project to your local working directory
   - Download from Github repository 
   - Download and unzip provided Maven project
2. Build the project via Maven
```
mvn clean package -DskipTests
```
3. Run the generated JAR file specifying the directory to process
```
java -jar fileparser-1.0.jar /Users/francistalampas/TEST
```

## How It Works?
1. User specifies a working directory to monitor the files.
2. App loops through all the files and reads all its text.
3. App analyzes the supported file statistics and prints the report in console.

## Important Notes
- ***Javadoc has been supplied to each class specifying their functions***
- ***Monitor Mode: Disabled***
  - Considering to trigger the application using external job schedulers
  - Avoiding long-running file watcher for easier maintenance and better resource management
