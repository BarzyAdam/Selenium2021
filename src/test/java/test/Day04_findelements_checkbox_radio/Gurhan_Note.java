package test.Day04_findelements_checkbox_radio;

public class Gurhan_Note {
    /*
    JUN 12, FRIDAY


Absolute xpath:
    -> Starts with : /
    -> Starts from the very beginning of <html>
    -> You can only go from parent to child
Relative xpath:
    -> Starts with: //
    -> Looks through everything in the html code
    -> Returns all matching
    -> You can start from anywhere in the html code
    -> Where ever you use // (relative path) is looking to jump and return all the matching results
        ex : //body//a

Commonly used xpaths
    1- //tagName[@attribute='value']
    2- //tagName[.='text']
        --> looks for matching text value
    //a[.='iPhone']
    //span[.='iPhone']
    . -->  means class in cssSelector. Not in xpath.
-->  Locating the same webElement using this syntax:
    //tagName[@attribute='value']
    //*[@attribute='value']
        -> when we use * instead of tagName, it will not check tagName.
        ->It will only check attributes and values. And return matching one(s).
    #1 -> using class atribute value :
        //a[@class='ac-gn-link ac-gn-link-iphone']
    #2 -> using href attribute value :
        //a[@href='/iphone/']
        (//a[@href='/iphone/'])[1] --> this is returning me two web elements
        If your xpath is returning you more than one web elements and you want to specify which one you get, you surround the xpath with (), and pass the index number in []
    #3 -> //a[@data-analytics-title='iphone']
        (//a[@data-analytics-title='iphone'])[1]
    #4 -> Locating a child and going to parent : We need to use /.. to go to parent
        //span[.='iPhone']/..

    #5 -> Using * instead of tagName
        //*[@class='ac-gn-link ac-gn-link-iphone']

     */
}
