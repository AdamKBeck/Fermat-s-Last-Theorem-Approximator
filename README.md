# Fermat-s-Last-Theorem-Approximator

This program estimates a solution for Fermat’s last theorem for n = 3 via the squeeze theorem.

https://en.wikipedia.org/wiki/Fermat%27s_Last_Theorem

This program will run continuously and update the Input.txt and Output.txt files. Input.txt contains three numbers, ‘a’ ‘b’ and ‘c’ respectively for Fermat’s last theorem. The Output.txt contains a number representing the ratio: c^3 / (a^3 + b^3).

This ratio cannot be 1 as noted by Fermat’s last theorem.

This ratio approaches 1 the longer this program runs.

This program will run until the end of the precision of the “long” decimal type in Java, and from there, the program will run continuously without updating the Output.txt file.

