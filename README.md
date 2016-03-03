# TaxiProject
Order{str1='shevchenka 8', str2='fizkultury 28', price=0.0, orderId=0, driver=null, state=New}
Passed		testProcessRequestPlaceOrder userId=0&street1=shevchenka 8&street2=fizkultury 28

0
Passed		testProcessRequestLogIn person=PetroSalo&pass=123

!!! ViewOrder returns null
viewOrder ще не дописаний, вертає null, нехай просто вертає тострінг.
там як раз і знадобиться personId
NOT PASSED	testProcessRequestViewOrder personId=0&orderNumber=0&action=view

Order{str1='shevchenka 8', str2='fizkultury 28', price=0.0, orderId=1, driver=Shef, state=CLOSED}
Passed		testProcessRequestCloseOrder driverId=2&orderNumber=0&action=close

