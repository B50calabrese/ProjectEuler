-- This program is meant to find the multiples of 5 or 3 below a certain number.

--------------------------------------------------------------------------------
-- Returns the list of multiples of 3 and 5 up to the number.
--------------------------------------------------------------------------------
getMultipleList:: Int -> [Int]
getMultipleList n =
    [i | i <- [0..(n - 1)], (((mod i 3) == 0) || ((mod i 5) == 0))]

--------------------------------------------------------------------------------
-- Finds the sum of a list of numbers.
--------------------------------------------------------------------------------
sumList:: [Int] -> Int
sumList [] = 0
sumList [x] = x
sumList (x:xs) =
    x + (sumList xs)

--------------------------------------------------------------------------------
-- Main driver rule.
--------------------------------------------------------------------------------
multipleSum:: Int -> Int
multipleSum n =
    sumList (getMultipleList n)