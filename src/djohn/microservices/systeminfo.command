echo off
mdfind -name SampleMockAgent | xargs -I {} cp -r {} ~/Desktop
cd ~/Desktop/SampleMockAgent
touch freeMemoryFile.txt
touch versionFile.txt
touch ipFile.txt
touch diskFile.txt
touch cpuFile.txt
java -jar sigar-bin/sigar.jar free > freeMemoryFile.txt
java -jar sigar-bin/sigar.jar version > versionFile.txt
java -jar sigar-bin/sigar.jar netinfo > ipFile.txt
java -jar sigar-bin/sigar.jar df > diskFile.txt
java -jar sigar-bin/sigar.jar cpuinfo > cpuFile.txt