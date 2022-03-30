
API end points



## REQUEST
Auth will be required to access this end point.

_main directory_: `/api/v1/`

| REQUEST TYPE |                              Endpoint                              |        Type         | Description                                                                                                                       |
|-------------:|:------------------------------------------------------------------:|:-------------------:|-----------------------------------------------------------------------------------------------------------------------------------|
|              |                                                                    |                     |                                                                                                                                   |
|      **GET** |     /patient-log?studentId=**{studentId}**&status=**{status}**     |  JSON Object List   | Gets a list of patient log with specified status(`accept`,`reject`,`waiting`) that is owned by a specific `student`               |
|      **GET** | /patient-log?coordinatorId=**{coordinatorId}**&status=**{status}** |  JSON Object List   | Gets a list of patient log with specified status(`accept`,`reject`,`waiting`) that is sent to a specific `coordinator`.           |
|      **GET** |   /patient-log?attendingId=**{attendingId}**&status=**{status}**   |  JSON Object List   | Gets a list of patient log with specified status(`accept`,`reject`,`waiting`)that is sent to a specific `attendingPhysician`.     |
|      **GET** |     /procedures?studentId=**{studentId}**&status=**{status}**      |  JSON Object List   | Gets a list of procedure form with specified status(`accept`,`reject`,`waiting`) that is owned by a specific `student`            |
|      **GET** |   /procedures?coordinatorId=**{studentId}**&status=**{status}**    |  JSON Object List   | Gets a list of procedure form with specified status(`accept`,`reject`,`waiting`) that is sent to a specific `coordinator`.        |
|      **GET** |   /procedures?attendingId=**{attendingId}**&status=**{status}**    |  JSON Object List   | Gets a list of procedure form with specified status(`accept`,`reject`,`waiting`) that is sent to a specific `attendingPhysician`. |
|      **GET** |                     /students/**{studentId}**                      | JSON Object(Single) | Get a specific `students`' information.                                                                                           |
|      **GET** |                              /courses                              |  JSON Object List   | Get all courses                                                                                                                   |
|      **GET** |               /specialities?courseId=**{courseId}**                |  JSON Object List   | Get specialities that are dependent on courseId                                                                                   |
|      **GET** |             /attending?specialityId=**{specialityId}**             |  JSON Object List   | Get attending physicians with specified speciality.                                                                               |
|              |                                                                    |                     |                                                                                                                                   |
|     **POST** |                           /patient-logs                            |     JSON Object     | Insert a new patient log form.                                                                                                    |
|     **POST** |                            /procedures                             |     JSON Object     | Insert a new procedure form.                                                                                                      |
|              |                                                                    |                     |                                                                                                                                   |
|      **PUT** |                       /patient-logs/**{id}**                       |     JSON Object     | Update a patient log                                                                                                              |
|      **PUT** |                        /procedures/**{id}**                        |     JSON Object     | Update a procedure form                                                                                                           |

## RESPONSE

```
 -- .../api/v1/procedures?studentId=2&status=rejected --
 
    {
        "id": 3,
        "student": {
            "id": 2,
            "name": "Spec2",
            "course": {
                "id": 1,
                "name": "Course1"
            },
            "oasisID": 201400663341
        },
        "attending": {
            "id": 3,
            "attendingName": "Attending3",
            "phoneNo": "556864323451",
            "institute": {
                "id": 2,
                "name": "Ins2"
            },
            "speciality": {
                "id": 1,
                "description": "Spec1",
                "course": {
                    "id": 3,
                    "name": "Course3"
                }
            }
        },
        "coordinator": {
            "id": 1,
            "name": "Coor1",
            "oasisId": 20170602012
        },
        "tibbiUygulama": "asd",
        "etkilesimTuru": "etkilesimTuru",
        "gerceklestigiOrtam": "gerceklestigiOrtam",
        "status": "rejected",
        "createdAt": "2022-03-28T01:39:18.883+00:00",
        "updatedAt": "2022-03-28T01:39:18.883+00:00"
    }
    
    
    

```
