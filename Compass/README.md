# Compass

This library is quick API spun up to host a java web server.
Its implementation mimics that of express for JS or Flask for python

# Compile sources for view in vscode:
     jar cf .\jar\Compass-sources.jar .\src\

# Usage:

To create a new server first create a new instance of App. App 
takes a Generic type. This type is for sessions. Use Session for 
no session data. App also take one to two params, mandatory is 
the port, option is the number of threads allocated.

To add routes, see App.addRoute in the JavaDocs.

To start the server see App.start

