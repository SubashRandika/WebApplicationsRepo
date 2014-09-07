==============================================================================
		CingleVue Coding Challenge(48 Hours)
==============================================================================

Introduction-
------------------------------------------------------------------------------

	This is a single page web application(SPA) which capable of displaying 
	short list of school results in tabular form.
	
Used Technologies-
------------------------------------------------------------------------------

	- Java(1.6)
	- Javascript/HTML/CSS
	- JSON (Jackson JSON API)
	- MongoDB (v2.6.4)
	- Apache Maven (v3.1.1)
	- Apache Tomcat AS(v8.0)
	- JAX-RS with Jersy (RESTful)
	- DataTables (jQuery Javascript library) - for UI
	- GIT
	
Execution Instructions-
-------------------------------------------------------------------------------

	1. Install and Setup MongoDB required version.
	2. Go to MongoDB console and login to MongoDB command console.
	3. Create a new database using command 'use YOUR_DB_NAME' -- (Ex: use schooldb)
	4. Create a new collection using command 
	   'db.createCollection("YOUR_COLLECTION_NAME")' -- db.createCollection("school_collection")
	5. To insert sample data into created collection run the command 
	   'db.YOUR_COLLECTION_NAME.insert(YOUR_JSON_SAMPLE_DATA)'

Ex: db.school_collection.insert( [  {
			"school": {
				"schoolName": "St. Aaron College"
				},
				"subject": "numeracy",
				"latestY3": 413.55,
				"latestY5": 494.25,
				"latestY7": 0.0,
				"latestY9": 0.0,
				"rawGainY3Y5": 61.4917,
				"factoredGainY3Y5": 69.81,
				"glgY3Y5": 113.52757826,
				"latestGainInGainY3Y5": -7.0
			},
			{
				"school": {
				"schoolName": "St. Alan College"
				},
				"subject": "numeracy",
				"latestY3": 380.5125,
				"latestY5": 469.9,
				"latestY7": 510.85,
				"latestY9": 558.7125,
				"rawGainY3Y5": 84.6607,
				"factoredGainY3Y5": 90.76,
				"glgY3Y5": 107.20438726,
				"latestGainInGainY3Y5": 0.0
			}]  )
										    
		Note: Sample JSON data can found at 
		'./CingleVueWebApplication/WebContent/WEB-INF/source/schools_numeracy_list.json'
		
	6. Update the property file located at 
	   './CingleVueWebApplication/src/cinglevue.properties' 
	   by giving database name and collection name you previously created.
	7. Go to location where POM is placed through the terminal 
	   and run the Maven command 'mvn clean install'
	8. Deploy the 'war' file created at 
	   './CingleVueWebApplication/target/CingleVueWebApplication-0.0.1-SNAPSHOT.war' 
	   into Apache Tomcat AS.
	9. Now you can access the web application using URL 
	   'http://localhost:8080/CingleVueWebApplication/' using a browser
	
	