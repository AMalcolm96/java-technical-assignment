# Notes

Please add here any notes, assumptions and design decisions that might help us understand your thought process.

I spent a total of 1:05 on this so far excluding breaks/other activities. I didn't want to run over and it be unfair
based on the time instructions I was given

Thought process:

Based off the description of the task I knew that we would need some sort of Discount Component, something that would be
able to calculate the total discount of all the items in the basket, so we started off with that skeleton

Next was deciding how we wanted to structure the Discount.

Discount:
The easiest way I believed was using an interface, we could then have a class that implements this interface for each
Discount Strategy. This would allow us to calculate the total, but where do we keep that discount total? And who is the
parent of the discount?

For the sake of testing logic and keeping the task simple I elected to change the ItemByUnit, so it made more sense as
in it's former state we were unable to tell how much the total price would be I made the assumption here that the basket
would contain an Item with that Item Object containing the quantity or unit of that item rather than teh basket List
containing several of the same Objects and then adding those occurrences up. This also made testing easier

I think the tests could've been parametrized a bit better, having the same tests with a single change (units) is
slightly inefficient, but I was trying to stick to the testing style already laid out by the project

Unfortunately ran of out time I set myself (1hr). but with the skeleton I have now I think it would be very easy to add
more Discount Strategies

Thank you for reviewing, I hope I'm able to discuss this further with you.

Adrian
