# GIS
Ex2- ReadMe
Chen Ostrovski 
Ester Reznikov 
This project was done as part of assignment number 2. In this project we will create a complex system that enables the collection of geographic information, the production of insights from this information, and the presentation of information in graphical tools. In this task, we will begin to develop an infrastructure for the representation of geographic information.
Coords:
Package that allows conversion of coordinates. Global coordinates for localization and backwards.
Class MyCoords:  represents a basic coordinate system converter.
Add: computes a new point which is the gps point transformed by a 3D vector (in meters), its goal is to find other point. This function gets a coordinate of point and a vector in meters, the vector is the distance in meter between the given point and other point. In order to find the other point, the function search for the distance in radian by using “Math.asin” function and divide by the earth radius and after that calling the auxiliary function “find_point” function.
Distance3d: computes the 3D distance (in meters) between the two gps points. This function gets two gps point, search the distance between the points first in radian and that convert it to meters. In order to find the distance in meters the function use the auxiliary function “diff_radian” this function finds the distance in radian after that the function using “Math. sin” and multiply it by the earth radius in order to converts the radian into meters, in the end of it use “Math.sqrt” (use the well-known function of finding a distance).
Vector3D: computes the 3D vector (in meters). This function gets two gps point and returns the vector in meters between them. In order to find the vector in meters the function use the auxiliary function “diff_radian” this function finds the distance in radian after that the function using “Math. sin” and multiply it by the earth radius in order to converts the radian into meters. 
Azimuth_elevation_dist: computes the polar representation of the 3D vector be gps0gps1. This function gets two point and return a double array that contains the azimuth, elevation and distance. In order to find the azimuth (the angle created from the north to the target point from the station point clockwise or the angle of the shift from the north to the right), the function take the coordinate and convert it to radian, after that it using the mathematical function that finds the azimuth. In order to find the elevation the function use the “deltaz” (the second z coordinate minus the first z coordinate) and divide it by the distance and in order to find the distance the function use the “Distasnce3d” function.
isValid_GPS_Point: return true if the point is valid lat, lon, alt coordinate : [-180, +180], [-90, +90], [-450, +inf], return false otherwise. This function get a point and checks if all of it coordinate are in the range as written on top.
Find_Point: auxiliary function that help the “add” function to find the point coordinate. The function gets a distance in radian between two points and the type of the wanted parameter (x or y).
Diff_radian: auxiliary function, given two points calculate the radiant distance, calculates the distance between the first point and the second point. 
Algorithms: 
Class MultiCSV:
This class create KML file to every layer and one KML file to the project, it gets path to folder and search recursively inside for CSV files.
FileManipulation: this function creates one KML file to the project, it uses the “multiCSV” function to go recursively on the files and the “finalKML” function to create one KML file. The function Take all the info that found in the “multiCSV” function and put it in one “CSVfolder”, after that it create one KML file.
MultiCSV: auxiliary function that helps to convert a CSV file into KML file, create a KML file to every layer. The function get path to a folder and search recursively inside for CSV files. In the function we create an array the contain all the files within the folder, the function checks if the file is a folder if true call the function again recursively, else check the name of the file and if the file is from the form CSV, if true create a new KML file and add the layer to the project.
FinalKML: auxiliary function that helps to create one KML file to the project, the function gets the info of the KML file. The String “kmlFinal” will contain all the info of the KML file, it will contain the start and end sentences and will create a new KML file. 
File formats:
Class Csv2Kml:
This class converts a CSV file into KML file, it gets a path to file and convert it.
ReadCSV: this function read the information from the CSV file and saves each row in GisElement. The function gets a path of the CSV file and the name that the user wants to give to the KML file. In the function a while loop go over the rows of the CSV file and checks if they aren’t empty and split the cols, the cols separated by ‘,’. The function starts to read the info from line 2 because what lie in behind those lines are titles. The function set each info respectively into the metadata and adds the info of the line into the “GisElement” and to the KML.
writeFileKML: write the KML file of one layer. The function gets an Array List the contain all the info of the layer and the name of the file, it returns a String that contains all the info of the KML file.
GIS:
Class GIS_element:
This class represents every line in the CSV file.
GetGeom: This function returns the point coordinate.
GetData: This function returns the metadata.
Translate: This function take vector and changes the point coordinate in accordance.
Class Layer: 
This class creates a new layer that contains all the information from the CSV file.
get_Meta_data: This function creates Metadata with the time that the project was created. 
Class Project:
This class creates a new project that contains all the information from the CSV files.
Get_Meta_data: This function creates Metadata with the time that the project was created.
Add: This function adds all the elements in the layer.
