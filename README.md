## README

This was a project as part of the application process for Sandbox. 
To run this solution, navigate to the RestAPI class, and run the main method.

#### Thought Process:
1. I looked at the task and made an outline of the structure of the data (~10 mins)
![image](https://github.com/sanjana-singhania/flow-in-the-field-challenge/assets/147664492/935749d0-546c-4af9-81f7-6a85399f0dde)
2. I watched [this youtube video](https://youtu.be/9oq7Y8n1t00?si=1FnjwbCDMNDup0Og) for an understanding of how to use GSON. (~20 mins)
3. I watched [this youtube video](https://www.youtube.com/watch?v=5MmlRZZxTqk) for an understanding of how exactly to format GET requests (~10 mins)
4. Created classes to represent participants, sessions, rounds, and the total list of data received from a GET request, and successfully implemented GET request (~40 mins)
5. Challenge I ran into: sorting the list of languages by the totalScore for each language (~40 mins):
I was stuck on this for a while because I thought I couldn't make a totalScore field (since gson needs to parse the class and its fields into a json object). So I was debating creating all my language statistics and recreating them to compare by total score but that seemed highly inefficient. 
    - Solution: You can create a totalScore field, just mark it as transient, which will tell gson when converting it to JSON to ignore this field. 
6. After figuring this out, I spent about (~1 hour) implementing the rest of the methods, and finished all of the implementation, but I had one thing left to do.
7. Next challenge: returning "N/A" if a participant has no rounds/sessions played yet.
    - Solution: I made my double objects into "Objects" so that if there were no rounds or sessions to average, it would return "N/A"

Overall total time spent on this project: ~4 hours
