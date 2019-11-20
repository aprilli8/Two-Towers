1. What is the best solution to the 15-block problem?
  * The best solution to the 15-block problem is [4, 5, 6, 10, 11, 12, 13],
    whose height value is 20.23411306140849.

2. How long does it take your program to find the answer to the 20-block
problem? Based on the time taken to solve the 20-block problem, about how long
do you expect it would take to solve the 21-block problem? What is the actual
time? How about the 25-block problem? Do these agree with your expectations,
given the time complexity of the problem? What about the 40- and 50-block
problems? (These will take a very long time. Just estimate based on the run
times of the smaller problems). To answer this question, fill in the table below
(you may wish to edit this file directly on GitHub so that you can view the
table rendered using GitHub's markdown formatting)

| Problem Size  | Estimated time | Actual Time |
| :------------ | :------------: | :---------: |
| 20 blocks     |       --       |  1m31.288s  |
| 21 blocks     |     3 mins     |  3m7.331s   |
| 22 blocks     |     6 mins     |  6m32.902s  |
| 25 blocks     |    52 mins     |  63m22.660s |
| 40 blocks     |  1572864 mins  |     --      |
| 50 blocks     | 1610612736 mins|     --      |

_$ (-.5) The runtime should actually be O(n 2^n). There are 2^n subsets, but for each subset you do O(n) work.
   This is probably why your estimates were a little off._

  * Explain how you arrived at your estimates.
    * The estimates were calculated by multiplying the amount of time it took to
    run the program for n-1 number of blocks by 2, so that since it took 1.5 minutes
    to run the 20 block program, it would take twice that (3 minutes) to run the
    21 block program. Generalized for an n number of blocks more than twenty, the
    amount of time could by estimated by the expression 1.5 * 2^(n-20).
  * Do the actual timings agree with your expectations, given the time complexity of the problem?
    * The actual timings are fairly similar to my expectations for the first few
    block problems after the 20 block problem, but they began to increase at a
    rate faster than the time estimated. While it is still an exponential increase
    of time with each additional block, it is not at a rate of exactly 2 as I had
    used to calculate the estimates.

3. This method of exhaustively checking the subsets of blocks will not work for
very large problems. Consider, for example, the problem with 50 blocks: there
are 2^50 different subsets. One approach is to repeatedly pick and evaluate
random subsets of blocks (e.g., stop the computation after 1 second of elapsed
time, printing the best subset found). How would you implement `randomSubset`, a
new `SubsetIterator` method that returns a random subset? (Describe your
strategy. You do not need to actually implement it.)
  * The randomSubset method could be implemented by creating multiple arrays (of
    size n/2 where n is the number of blocks) of random integers from 0 to n. Each
    would then be a random list where each element corresponds to a particular
    index in the original vector containing all possible values. All of the generated
    arrays would then be compared to each other (with this generation and comparison
    happening for 1 second of elapsed time) and the one that best fits the
    solution to the problem would be returned as the best subset found. By comparing
    only subsets of size n/2, it would narrow down many of the possible subset
    choices, which would make the final return subset more likely to be accurate.
