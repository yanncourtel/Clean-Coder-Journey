Trip Service Kata
=================

Kata for legacy code hands-on session. The objective is to test and refactor the legacy TripService class.
The end result should be well-crafted code that express the domain.

# Clean tests - the exercise
Clean tests consists of making your test suite the most maintainable for future developments and add a layer of functional specification and business logic in your tests so you understand what your code is supposed to be doing.

## First rule => DO NOT touch the production code until your function is 100% covered by tests

The only exception to the rule is introducing an inheritance level to your service which does not break the code.

## Second rule => Use your IDE automated action first instead of writing code

If you can extract a method, introduce an interface and so on, do so with IDE shortcuts.

## Third rule => You are free to refactor all classes as we consider you've done the callers analysis

Once the public method of your service is covered, you are free to refactor all the objects in your project. We assume you know who's calling your API so you won't introduce a breaking change.


# Proposed solution and live coding video

You can watch the video with my solution. Although quite long, I explain my whole thought process while writting tests, how I break dependencies, the reasons for refactoring and re-desining the code (tests and production code), and why certain steps are important. I also cover how often I commit and why I do it. 

The video is full of tips and tricks that can be used in any language.

https://www.youtube.com/watch?v=_NnElPO5BU0