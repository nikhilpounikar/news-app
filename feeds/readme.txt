following are the endpoints

Here pageNumber 0 means fetches first 10 records and consecutive numbers such as 1,2,3 to provide offset
1. GET http://localhost:8083/videos?pageNumber=0&pageSize=10
2. GET http://localhost:8083/news?pageNumber=0&pageSize=10
3. GET http://localhost:8083/trending

4. POST http://localhost:8083/videos (Response Body) of model Videos
5. POST http://localhost:8083/news (Response Body) of model News

6. DELETE http://localhost:8083/videos/{id} id of the video to be deleted
7. DELETE http://localhost:8083/news/{id} id of the news to be deleted


Folder Structure

feeds --
		|-->controllers
					 |---->NewsController
					 |---->TrendingController
					 |---->VideoController
		|-->models
				  |---> Videos.java
				  |---> News.java
		|-->repositories
						|--->CustomNewsRepository
						|--->CustomVideoRepository
						|--->NewsRepository
						|--->NewsRepositoryImpl
						|--->VideoRepository
						|--->|--->CustomNewsRepositoryImple
		|-->response
					 |---> TrendingResonse

					 
# Simply unzip the code and import in Eclipse as a mavan project
# let the maven load dependency
# start the project