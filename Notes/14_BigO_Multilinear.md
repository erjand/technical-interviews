# Big O - Multilinear Time - O(m + n)

## Definition

Multilinear is represented with two or more variables such as O(m + n) to indicate that the algorithm scales linearly but on more than just one unique input.

Multilinear is used when dealing with multiple inputs that all scale linearly but the size and relationship of the inputs to each other is unknown.

---

## Example #1

``` { .cs }
public int SumAll(List<int> numberListOne, List<int> numberListTwo) {
    int sum = 0;
    foreach (int number in numberListOne) {
        sum += number;
    }
    foreach (int number in numberListTwo) {
        sum += number;
    }

    return sum;
}
```

Because we do not know the size of *numberListOne* relative to *numberListTwo* we can't use a single variable, even though we know that both inputs scale linearly.
