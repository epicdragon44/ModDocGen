# DOCUMENTATION
(##MainPanel)
## MainPanel
```javascript
class MainPanel extends React.Component 
```

The entire right half of the screen, which can change its display depending on whether we want to show the contents of the course, with all the modules; or the screen that lets us enroll in a course; or the screen that lets us create a course.

Contains: 
[codeToName](#codeToName)
[codeToName](#codeToName)
[VarkProfile](#VarkProfile)
[VarkProfile](#VarkProfile)
[codeToName](#codeToName)
[Select](#Select)
[Select](#Select)
[VarkProfile](#VarkProfile)
[ModuleItem](#ModuleItem)
[ModuleItem](#ModuleItem)
[AddModuleItem](#AddModuleItem)
[ModuleItem](#ModuleItem)
[ModuleItem](#ModuleItem)
[ModuleItem](#ModuleItem)
[VarkProfile](#VarkProfile)
[VarkProfile](#VarkProfile)




(##ModuleItem)
## ModuleItem
```javascript
function ModuleItem(props) 
```

Displays an entire module, including all of its content items.

Contains: 
[ModuleContentItem](#ModuleContentItem)
[RenameModule](#RenameModule)
[DeleteModule](#DeleteModule)
[ModuleContentItem](#ModuleContentItem)




(##Container)
## Container
```javascript
class Container extends React.Component 
```

The main container for everything on the screen, that also stores most global data in its state.

Contains: 
[MainPanel](#MainPanel)
[AddCoursePanel](#AddCoursePanel)
[CreateCoursePanel](#CreateCoursePanel)
[Sidebar](#Sidebar)




(##Sidebar)
## Sidebar
```javascript
class Sidebar extends React.Component 
```

The entire left sidebar

Contains: 
[AddCourseItem](#AddCourseItem)
[CreateCourseItem](#CreateCourseItem)
[CourseListItem](#CourseListItem)




(##ModuleContentItem)
## ModuleContentItem
```javascript
class ModuleContentItem extends React.Component 
```

A course item, that, when clicked, displays one of the course contents.

Contains: 
[MyModal](#MyModal)
[RenameItem](#RenameItem)
[DeleteItem](#DeleteItem)




(##MyModal)
## MyModal
```javascript
class MyModal extends React.Component 
```

Displays a popup dialog

Contains: 
[Select](#Select)
[Select](#Select)




(##CourseListItem)
## CourseListItem
```javascript
function CourseListItem(props) 
```

Displays a single course button in the sidebar that, when clicked, changes the main panel to display that course.

Contains: 
[codeToName](#codeToName)




(##AddCourseItem)
## AddCourseItem
```javascript
function AddCourseItem(props) 
```

Displays a single button in the sidebar, that, when clicked, changes the main panel to allow you to enroll in a course

Contains: 
[currentUserIsAdmin](#currentUserIsAdmin)




(##CreateCourseItem)
## CreateCourseItem
```javascript
function CreateCourseItem(props) 
```

Displays a single button in the sidebar, that, when clicked, changes the main panel to allow you to create a course

Contains: 
[currentUserIsAdmin](#currentUserIsAdmin)




(##AddModuleContentItemItem)
## AddModuleContentItemItem
```javascript
class AddModuleContentItemItem extends React.Component 
```

A button that allows the user (assumedly a teacher) to add an item to the module

Contains: 
[MyModal](#MyModal)




(##CreateCoursePanel)
## CreateCoursePanel
```javascript
function CreateCoursePanel(props) 
```

The mainpanel view that allows you to create a class.

Contains: 
[CreateForm](#CreateForm)




(##AddCoursePanel)
## AddCoursePanel
```javascript
function AddCoursePanel(props) 
```

The mainpanel view that allows you to add a class

Contains: 
[NameForm](#NameForm)




(##Home)
## Home
```javascript
class Home extends React.Component 
```

Renders and returns a Container, and initializes it with proper defaults.

Contains: 
[Container](#Container)




(##codeToName)
## codeToName
```javascript
function codeToName(classcode) 
```

Converts the class code passed into the function into the actual English name of the course

Contains: 




(##currentUserIsAdmin)
## currentUserIsAdmin
```javascript
function currentUserIsAdmin() 
```

Determines whether the current user logged in is an Admin, or Teacher, or a student. Returns true if the former, and false if the latter.

Contains: 




(##isUserBlocked)
## isUserBlocked
```javascript
function isUserBlocked(username, activeCourse) 
```

Determines whether the user is blocked from the activeCourse

Contains: 




(##RenameModule)
## RenameModule
```javascript
class RenameModule extends React.Component 
```

Inline button that, when clicked, allows the user to rename a module.

Contains: 




(##DeleteModule)
## DeleteModule
```javascript
class DeleteModule extends React.Component 
```

Inline button that, when clicked, allows the user to delete a module.

Contains: 




(##RenameItem)
## RenameItem
```javascript
class RenameItem extends React.Component 
```

Inline button that, when clicked, allows the user to rename an item.

Contains: 




(##DeleteItem)
## DeleteItem
```javascript
class DeleteItem extends React.Component 
```

Inline button that, when clicked, allows the user to delete an item.

Contains: 




(##AddModuleItem)
## AddModuleItem
```javascript
class AddModuleItem extends React.Component 
```

A button that allows the user (assumedly a teacher) to add a module to the course

Contains: 




(##VarkProfile)
## VarkProfile
```javascript
function VarkProfile(props) 
```

Displays the entire VARK Profile

Contains: 




(##Select)
## Select
```javascript
class Select extends React.PureComponent 
```

Allows the user to filter which VARK-type of items to display

Contains: 




(##CreateForm)
## CreateForm
```javascript
class CreateForm extends React.Component 
```

The form that allows you to create a class.

Contains: 




(##NameForm)
## NameForm
```javascript
class NameForm extends React.Component 
```

The form that allows you to enroll in a class.

Contains: 




