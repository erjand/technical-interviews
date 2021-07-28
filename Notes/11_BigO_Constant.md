# Big O - Constant Time - O(1)

## Definition

Constant time is represented as O(1) and describes algorithms which do not scale with input. Their runtime is constant regardless of the input size.

Common examples and use cases for constant time algorithms include: 
* Arithmetic operations
* Accessing items in an Array or HashSet
* Adding an item to a Stack

## Example #1

``` { .cs }
public bool IsEven(int num) {
    return num % 2 == 0;
}
```

Regardless of the size of *num* this method runs in the same amount of time.

## Example #2

``` { .cs }
public int SumIndices(int[] array, int indexOne, int indexTwo) {
    return array[indexOne] + array[indexTwo];
}
```

Accessing by index in an array is O(1) so this algorithm is constant time regardless of the size of the array.
