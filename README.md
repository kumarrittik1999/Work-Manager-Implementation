## Work Manager
Work Manager is an API introduced by Android Jetpack, which helps to perform tasks that are defferable, asynchronous and expected to run reliably.

We need to extend Worker class in order to make a Worker.
Worker class has two important methods
 -> doWork() : Result //Whatever written inside doWork method executes on the worker thread.
 -> onStopped()
 
To start the Worker from an activity/Fragment, we need to have a WorkManager and a WorkRequest instance.
WorkManager helps in managing the Worker class (starting or stopping the work)
WorkRequest is repsonsible for the properties of the Work.

We need to add the following the following dependency in build.gradle(module level) in order to access Worker related APIs

def work_version = "2.7.1" //Use the latest one here.
implementation "androidx.work:work-runtime-ktx:$work_version"
