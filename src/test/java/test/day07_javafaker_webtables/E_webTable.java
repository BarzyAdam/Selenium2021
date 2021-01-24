package test.day07_javafaker_webtables;

public class E_webTable {
    /*
    webtable:
    <table>
          <tr>
              <td></td>
              <td></td>
              <td></td>
          <tr>
    <table>
    by going to that site and login
    http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    you gonna see that there is a table
    if we write //table  ->it returnes me the whole table
    by adding  //table[@class='SampleTable'] it gonna go exact table ,MAYBE WE HAVE MORE THAN ONE TABLE
    - adding  //tbody ->it gonna go the body of table
    - add /tr it gonna go to colloms
    -add /td it gonna check each by each
    -add [.='Paul Brown'] it gonna return exact item that (paul Brown)

    //table[@class='SampleTable']//tbody/tr/td[.='Paul Brown']

    we can do it by //table[@class='SampleTable']//tbody/tr/td[2] but you gonna see there is 8 result
    it means it isnt correct

    //table[@class='SampleTable']//tbody/tr/td[.='Paul Brown']


    --------------------------
    if we add that
    //table[@class='SampleTable']//tbody/tr[2]/td[7]
    it gonna gives me exact "Las vegas"


    Stive johns ->  //table[@class='SampleTable']//tbody/tr[4]/td[.='Steve Johns']
    we can do shorter way ->   //td[.='Steve Johns']

    base on //td[.='Steve Johns'] go to (steve Johns's date)
    what should we do?first way we should go to parent by /.. then we should locate date
    like  ->  //td[.='Steve Johns']/../td[4]

    by another way we can use that   "/following-sibling::"  that gonna go following siblings
    like  -> //td[.='Steve Johns']/following-sibling::td[3]

 in the table from cleare jeffarson go to clare jefferson city
 ->  //td[.='Clare Jefferson']/following-sibling::td[5]

 we can use preceding-sibling:: that use for going back siblings
     */
}
