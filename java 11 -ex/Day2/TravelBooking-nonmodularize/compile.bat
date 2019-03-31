dir /S /B src\*.java > src.txt

javac --source-path src -d out @src.txt

