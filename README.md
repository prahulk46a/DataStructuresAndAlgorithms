# 📚 Data Structures & Algorithms (DSA) — Complete Reference

> A deeply detailed reference guide covering Data Structures, Algorithms, Complexity Analysis, Patterns, and Interview Preparation — all in one place.

---

## 📋 Table of Contents

1. [About This Document](#about-this-document)
2. [Big-O Complexity Guide](#big-o-complexity-guide)
3. [Data Structures](#data-structures)
    - [Arrays](#1-arrays)
    - [Strings](#2-strings)
    - [Linked Lists](#3-linked-lists)
    - [Stacks](#4-stacks)
    - [Queues](#5-queues)
    - [Hash Tables / Hash Maps](#6-hash-tables--hash-maps)
    - [Trees](#7-trees)
    - [Binary Search Trees (BST)](#8-binary-search-trees-bst)
    - [AVL Trees](#9-avl-trees)
    - [Heaps / Priority Queues](#10-heaps--priority-queues)
    - [Tries](#11-tries)
    - [Graphs](#12-graphs)
    - [Disjoint Set (Union-Find)](#13-disjoint-set-union-find)
    - [Segment Trees](#14-segment-trees)
    - [Fenwick Tree (BIT)](#15-fenwick-tree-binary-indexed-tree)
4. [Algorithms](#algorithms)
    - [Sorting Algorithms](#sorting-algorithms)
    - [Searching Algorithms](#searching-algorithms)
    - [Graph Algorithms](#graph-algorithms)
    - [Dynamic Programming](#dynamic-programming)
    - [Greedy Algorithms](#greedy-algorithms)
    - [Backtracking](#backtracking)
    - [Divide and Conquer](#divide-and-conquer)
    - [Two Pointers & Sliding Window](#two-pointers--sliding-window)
    - [Bit Manipulation](#bit-manipulation)
5. [Problem-Solving Patterns](#problem-solving-patterns)
6. [Interview Cheat Sheet](#interview-cheat-sheet)
7. [Repo Structure](#repo-structure)
8. [Resources](#resources)
9. [Contributing](#contributing)

---

## About This Document

This README is a complete self-contained DSA reference guide. Each section covers:

- **Concept explanation** — what it is and how it works internally
- **When to use** — real-world and competitive scenarios
- **Operations** — all major operations with step-by-step description
- **Time & Space Complexity** — best, average, and worst case
- **Common pitfalls** — mistakes to avoid
- **Key interview problems** — classic problems mapped to each topic

---

## Big-O Complexity Guide

Big-O notation describes the upper bound of an algorithm's growth rate as input size `n` increases. It tells us how runtime or memory scales, ignoring constants.

### Complexity Rankings (from best to worst)

| Notation    | Name          | Example Use Case                         | n = 1000       |
|-------------|---------------|------------------------------------------|----------------|
| O(1)        | Constant      | Hash table lookup, array index           | 1 op           |
| O(log n)    | Logarithmic   | Binary search, balanced BST ops          | ~10 ops        |
| O(n)        | Linear        | Linear scan, single loop                 | 1,000 ops      |
| O(n log n)  | Linearithmic  | Merge sort, heap sort                    | ~10,000 ops    |
| O(n²)       | Quadratic     | Nested loops, bubble sort                | 1,000,000 ops  |
| O(n³)       | Cubic         | Triple nested loops                      | 10⁹ ops        |
| O(2ⁿ)       | Exponential   | Naive recursion, subset enumeration      | Astronomical   |
| O(n!)       | Factorial     | Permutation generation                   | Impossible     |

### Rules for Calculating Big-O

- **Drop constants:** O(2n) → O(n)
- **Drop lower-order terms:** O(n² + n) → O(n²)
- **Different inputs = different variables:** Two separate loops over arrays `a` and `b` = O(a + b), not O(n)
- **Nested loops multiply:** A loop inside a loop = O(n × m) or O(n²) if same size
- **Recursive algorithms:** Use the Master Theorem or recursion tree analysis

### Space Complexity

Space complexity counts memory used relative to input size, including:
- Input space (sometimes excluded)
- Auxiliary/extra space (stack frames, variables, data structures)
- Recursive call stack depth

---

## Data Structures

---

### 1. Arrays

#### What It Is
An array is a contiguous block of memory storing elements of the same type. Elements are indexed starting from 0. It is the most fundamental data structure and the basis for many others.

#### Types
- **Static Array:** Fixed size defined at compile time. Memory is allocated on the stack.
- **Dynamic Array:** Resizable at runtime (e.g., Python lists, Java ArrayList, C++ vector). Internally doubles in size when full — amortized O(1) append.

#### How Dynamic Array Resizing Works
When a dynamic array is full and a new element is inserted:
1. A new array of 2× the current capacity is allocated.
2. All existing elements are copied over — O(n) for this specific insert.
3. The old array is freed.
   Over many insertions, the average cost per insert is O(1) (amortized), because doubling means copying happens rarely.

#### Operations & Complexity

| Operation         | Time Complexity | Notes                                      |
|-------------------|-----------------|--------------------------------------------|
| Access by index   | O(1)            | Direct memory address calculation          |
| Search (unsorted) | O(n)            | Must scan all elements                     |
| Search (sorted)   | O(log n)        | Binary search possible                     |
| Insert at end     | O(1) amortized  | Dynamic array; O(1) if space available     |
| Insert at index   | O(n)            | Must shift elements right                  |
| Delete at end     | O(1)            | Just decrement size                        |
| Delete at index   | O(n)            | Must shift elements left                   |
| Traverse          | O(n)            | Visit every element once                   |

**Space Complexity:** O(n)

#### When to Use
- When you need fast random access by index
- When data size is known or doesn't change often
- As a building block for stacks, queues, heaps

#### Common Pitfalls
- Off-by-one errors in loop bounds (`i < n` vs `i <= n`)
- Array index out of bounds — always validate indices
- Confusing in-place modification with creating a new array
- Not accounting for negative indices (language-dependent)

#### Key Interview Problems
- Two Sum (Hash Map or Two Pointer)
- Best Time to Buy and Sell Stock
- Maximum Subarray (Kadane's Algorithm)
- Rotate Array
- Find the Duplicate Number
- Merge Intervals
- Product of Array Except Self

---

### 2. Strings

#### What It Is
A string is a sequence of characters. In most languages, strings are immutable (Java, Python), meaning operations create new strings rather than modifying in place.

#### Internal Representation
- Stored as an array of characters (char array)
- Terminated by null character `\0` in C/C++
- Python and Java maintain length separately (no null terminator needed)
- Unicode strings may use UTF-8, UTF-16, or UTF-32 encoding

#### Operations & Complexity

| Operation         | Time Complexity | Notes                                          |
|-------------------|-----------------|------------------------------------------------|
| Access char       | O(1)            | By index                                       |
| Concatenation     | O(n + m)        | Creates new string of combined length          |
| Substring         | O(k)            | k = length of substring                        |
| Search (naive)    | O(n × m)        | n = text length, m = pattern length            |
| Search (KMP)      | O(n + m)        | Knuth-Morris-Pratt algorithm                   |
| Reverse           | O(n)            | Character by character                         |
| Compare           | O(min(n, m))    | Stops at first mismatch                        |

**Space Complexity:** O(n)

#### Important String Algorithms
- **KMP (Knuth-Morris-Pratt):** Efficient pattern matching in O(n + m) using a failure function
- **Rabin-Karp:** Rolling hash for pattern matching — O(n + m) average, O(nm) worst
- **Z-Algorithm:** Computes prefix matches at each position in O(n)
- **Manacher's Algorithm:** Finds all palindromic substrings in O(n)

#### Key Interview Problems
- Valid Anagram
- Longest Palindromic Substring
- Longest Substring Without Repeating Characters
- Group Anagrams
- String to Integer (atoi)
- Regular Expression Matching
- Minimum Window Substring

---

### 3. Linked Lists

#### What It Is
A linked list is a linear data structure where each element (node) stores data and a pointer/reference to the next node. Unlike arrays, nodes are not stored contiguously in memory — they are scattered and connected via pointers.

#### Types

**Singly Linked List:**
```
[data | next] --> [data | next] --> [data | null]
  Head                               Tail
```

**Doubly Linked List:**
```
null <-- [prev | data | next] <--> [prev | data | next] --> null
           Head                            Tail
```

**Circular Linked List:**
The tail's next pointer points back to the head, forming a loop.

#### Operations & Complexity

| Operation              | Time Complexity | Notes                                       |
|------------------------|-----------------|---------------------------------------------|
| Access by index        | O(n)            | Must traverse from head                     |
| Search                 | O(n)            | Linear scan required                        |
| Insert at head         | O(1)            | Update head pointer                         |
| Insert at tail         | O(1) / O(n)     | O(1) if tail pointer maintained             |
| Insert at position     | O(n)            | Traverse to position first                  |
| Delete at head         | O(1)            | Move head to next node                      |
| Delete at tail         | O(n)            | Must find second-to-last node               |
| Delete at position     | O(n)            | Traverse to find node                       |

**Space Complexity:** O(n) — plus O(n) pointer overhead

#### Key Techniques
- **Runner Technique (Fast & Slow Pointers):** Use two pointers moving at different speeds. Useful for finding the middle, detecting cycles, and finding the kth element from the end.
- **Sentinel/Dummy Node:** Add a dummy node before the head to simplify edge cases (empty list, single-element list) in insertion/deletion logic.
- **Reversal:** Iteratively reverse by updating `next` pointers in a single pass.

#### Cycle Detection — Floyd's Algorithm
Use fast (2 steps) and slow (1 step) pointers. If they meet, a cycle exists. To find the start of the cycle: reset slow to head, advance both one step at a time — they meet at the cycle start.

#### Key Interview Problems
- Reverse a Linked List
- Detect Cycle in Linked List
- Merge Two Sorted Lists
- Remove Nth Node from End
- Intersection of Two Linked Lists
- Reorder List
- LRU Cache (uses doubly linked list + hash map)

---

### 4. Stacks

#### What It Is
A stack is a Last-In, First-Out (LIFO) linear data structure. Think of a stack of plates — you can only add or remove from the top.

#### Internal Implementation
- **Using Array:** Maintain a top index. Push increments top; pop decrements it.
- **Using Linked List:** Push inserts at head; pop removes from head.

#### Operations & Complexity

| Operation  | Time Complexity | Description                              |
|------------|-----------------|------------------------------------------|
| Push       | O(1)            | Add element to top                       |
| Pop        | O(1)            | Remove and return top element            |
| Peek/Top   | O(1)            | View top element without removing        |
| IsEmpty    | O(1)            | Check if stack has no elements           |
| Search     | O(n)            | Must pop elements to find target         |

**Space Complexity:** O(n)

#### When to Use
- Tracking function call frames (call stack)
- Undo/redo functionality
- Parsing and evaluating expressions
- DFS (Depth-First Search) — can use explicit stack instead of recursion
- Balancing parentheses/brackets
- Monotonic stack problems

#### Monotonic Stack
A special use of a stack that maintains elements in sorted (monotonically increasing or decreasing) order. Used to find:
- Next Greater Element
- Previous Smaller Element
- Largest Rectangle in Histogram

#### Key Interview Problems
- Valid Parentheses
- Min Stack (O(1) min retrieval)
- Evaluate Reverse Polish Notation
- Daily Temperatures (Next Greater Element)
- Largest Rectangle in Histogram
- Decode String
- Implement Queue Using Stacks

---

### 5. Queues

#### What It Is
A queue is a First-In, First-Out (FIFO) linear data structure. Think of a line at a counter — the first person to join is the first to be served.

#### Types
- **Simple Queue:** Basic FIFO
- **Circular Queue:** Rear wraps around to front when array is full — avoids wasted space
- **Deque (Double-Ended Queue):** Can insert/delete from both ends
- **Priority Queue:** Elements dequeued based on priority, not insertion order (implemented using a heap)

#### Operations & Complexity

| Operation   | Time Complexity | Description                              |
|-------------|-----------------|------------------------------------------|
| Enqueue     | O(1)            | Add to the rear                          |
| Dequeue     | O(1)            | Remove from the front                    |
| Peek/Front  | O(1)            | View front element without removing      |
| IsEmpty     | O(1)            | Check if queue is empty                  |
| Search      | O(n)            | Linear scan required                     |

**Space Complexity:** O(n)

#### When to Use
- BFS (Breadth-First Search)
- Task scheduling and job queues
- Level-order tree traversal
- Sliding window problems (Monotonic Deque)
- Producer-consumer problems

#### Monotonic Deque
A deque maintaining elements in sorted order — used in sliding window maximum/minimum problems to achieve O(n) instead of O(n x k).

#### Key Interview Problems
- Implement Stack Using Queues
- Sliding Window Maximum
- BFS Shortest Path
- Design Hit Counter
- Task Scheduler
- Number of Recent Calls

---

### 6. Hash Tables / Hash Maps

#### What It Is
A hash table stores key-value pairs. It uses a hash function to map keys to bucket indices in an underlying array, enabling near-constant time lookups, insertions, and deletions.

#### How It Works Internally
1. A hash function converts a key into an integer index.
2. The index maps to a slot (bucket) in an array.
3. The value is stored at that slot.
4. On lookup, the same hash function recomputes the index — no scanning needed.

#### Collision Handling

**Chaining:** Each bucket holds a linked list. Multiple keys hashing to the same index are stored in the list.
- Lookup: Hash + scan the chain — O(1) average, O(n) worst

**Open Addressing:** On collision, probe for the next empty slot using:
- Linear probing: Check index + 1, + 2, ...
- Quadratic probing: Check index + 1², + 2², ...
- Double hashing: Use a second hash function for step size

#### Operations & Complexity

| Operation | Average | Worst | Notes                                   |
|-----------|---------|-------|-----------------------------------------|
| Insert    | O(1)    | O(n)  | Worst case when many collisions occur   |
| Delete    | O(1)    | O(n)  | Same as insert                          |
| Lookup    | O(1)    | O(n)  | Worst case: all keys in one bucket      |
| Iteration | O(n)    | O(n)  | Must visit all buckets                  |

**Space Complexity:** O(n)

#### Load Factor
`Load Factor = Number of Elements / Number of Buckets`
When load factor exceeds a threshold (typically 0.75), the table is rehashed — buckets doubled and all elements reinserted. This is O(n) but happens rarely.

#### When to Use
- Fast lookup by key (O(1) average)
- Counting frequencies
- Detecting duplicates
- Caching results (memoization)
- Grouping elements by property

#### Common Pitfalls
- Using mutable objects as keys (can break hash consistency)
- Forgetting that worst-case is O(n) — relevant in security contexts (hash flooding)
- Iterating in insertion order is not guaranteed (unless using LinkedHashMap)

#### Key Interview Problems
- Two Sum
- Group Anagrams
- Top K Frequent Elements
- Subarray Sum Equals K
- Longest Consecutive Sequence
- LRU Cache
- Valid Sudoku

---

### 7. Trees

#### What It Is
A tree is a hierarchical, non-linear data structure consisting of nodes connected by edges. It has a root node at the top, and each node can have zero or more child nodes. There are no cycles.

#### Terminology
| Term        | Definition                                              |
|-------------|---------------------------------------------------------|
| Root        | Top-most node with no parent                            |
| Leaf        | Node with no children                                   |
| Height      | Longest path from a node to a leaf                      |
| Depth       | Distance from root to the node                          |
| Subtree     | A node and all its descendants                          |
| Degree      | Number of children a node has                           |
| Level        | Depth + 1 (root is level 1)                             |
| Balanced    | Height difference between left/right subtrees <= 1      |
| Complete    | All levels full except possibly the last (filled left)  |
| Full        | Every node has 0 or 2 children                          |
| Perfect     | All internal nodes have 2 children; all leaves same level|

#### Tree Traversals

**Depth-First Traversals:**
- **Inorder (Left → Root → Right):** Produces sorted output for BSTs
- **Preorder (Root → Left → Right):** Used to serialize/copy trees
- **Postorder (Left → Right → Root):** Used to delete trees, evaluate expressions

**Breadth-First Traversal:**
- **Level-Order:** Visit nodes level by level using a queue

All traversals: O(n) time, O(h) space (h = height) for DFS; O(w) for BFS (w = max width)

#### Key Interview Problems
- Maximum Depth of Binary Tree
- Symmetric Tree
- Path Sum
- Lowest Common Ancestor
- Serialize and Deserialize Binary Tree
- Binary Tree Level Order Traversal
- Diameter of Binary Tree

---

### 8. Binary Search Trees (BST)

#### What It Is
A BST is a binary tree where for every node:
- All values in the **left subtree are smaller**
- All values in the **right subtree are greater**

This property allows for efficient searching — at each node, we eliminate half the remaining tree.

#### Operations & Complexity

| Operation | Average   | Worst  | Notes                           |
|-----------|-----------|--------|---------------------------------|
| Search    | O(log n)  | O(n)   | Worst case: skewed/unbalanced   |
| Insert    | O(log n)  | O(n)   | Same as search                  |
| Delete    | O(log n)  | O(n)   | 3 cases: leaf, one child, two   |
| Min/Max   | O(log n)  | O(n)   | Leftmost / Rightmost node       |
| Inorder   | O(n)      | O(n)   | Gives sorted sequence           |

**Space Complexity:** O(n)

#### Deletion Cases
1. **Node is a leaf:** Simply remove it.
2. **Node has one child:** Replace node with its child.
3. **Node has two children:** Replace node's value with its **inorder successor** (smallest value in right subtree), then delete the successor.

#### Common Pitfalls
- An unbalanced BST degrades to O(n) — use AVL or Red-Black Tree for guaranteed O(log n)
- BST validation requires tracking min/max bounds, not just parent comparison

#### Key Interview Problems
- Validate Binary Search Tree
- Kth Smallest Element in BST
- Convert Sorted Array to BST
- Delete Node in BST
- Inorder Successor in BST
- Recover BST (two nodes swapped)

---

### 9. AVL Trees

#### What It Is
An AVL tree is a self-balancing BST. After every insert or delete, it checks the **balance factor** of each node:

`Balance Factor = Height(Left Subtree) - Height(Right Subtree)`

If balance factor goes outside {-1, 0, 1}, the tree performs **rotations** to rebalance.

#### Rotations
- **Left Rotation:** Fix a right-heavy imbalance
- **Right Rotation:** Fix a left-heavy imbalance
- **Left-Right Rotation:** Left rotate child, then right rotate
- **Right-Left Rotation:** Right rotate child, then left rotate

#### Complexity

| Operation | Time Complexity |
|-----------|-----------------|
| Search    | O(log n)        |
| Insert    | O(log n)        |
| Delete    | O(log n)        |

Guaranteed O(log n) because the height is always O(log n).

---

### 10. Heaps / Priority Queues

#### What It Is
A heap is a complete binary tree satisfying the heap property:
- **Min-Heap:** Parent <= children (root is minimum)
- **Max-Heap:** Parent >= children (root is maximum)

Heaps are stored efficiently in arrays using index arithmetic:
- Parent of index i: `(i - 1) / 2`
- Left child of i: `2i + 1`
- Right child of i: `2i + 2`

#### Operations & Complexity

| Operation        | Time Complexity | Notes                                  |
|------------------|-----------------|----------------------------------------|
| Insert           | O(log n)        | Insert at end, bubble up (sift up)     |
| Extract min/max  | O(log n)        | Remove root, move last element, sift down |
| Peek min/max     | O(1)            | Just read root                         |
| Build heap       | O(n)            | Faster than n insertions               |
| Heapify          | O(log n)        | Restore heap property at a node        |

**Space Complexity:** O(n)

#### When to Use
- Finding kth largest/smallest element
- Sorting (Heap Sort)
- Dijkstra's shortest path algorithm
- Median of a data stream (use two heaps)
- Task scheduling with priorities
- Merging k sorted lists

#### Key Interview Problems
- Kth Largest Element in an Array
- Top K Frequent Elements
- Find Median from Data Stream (two heaps)
- Merge K Sorted Lists
- Task Scheduler
- Sliding Window Median

---

### 11. Tries

#### What It Is
A Trie (prefix tree or digital tree) is a tree-shaped data structure for storing strings where each node represents a character. The path from root to a node spells out a prefix.

#### Structure
- Each node contains an array/map of children (one per possible character)
- A boolean flag `isEndOfWord` marks valid complete words

#### Operations & Complexity

| Operation   | Time Complexity | Notes                          |
|-------------|-----------------|--------------------------------|
| Insert      | O(m)            | m = length of string           |
| Search      | O(m)            | Follow character-by-character  |
| Prefix check| O(m)            | Same as search                 |
| Delete      | O(m)            | Need to clean up unused nodes  |

**Space Complexity:** O(ALPHABET_SIZE x m x n) — can be large

#### When to Use
- Autocomplete / type-ahead suggestions
- Spell checker
- IP routing (longest prefix match)
- Word games (Boggle, Scrabble)
- Dictionary implementation

#### Key Interview Problems
- Implement Trie (Prefix Tree)
- Add and Search Word
- Word Search II
- Replace Words
- Palindrome Pairs

---

### 12. Graphs

#### What It Is
A graph is a collection of **vertices (nodes)** connected by **edges**. Unlike trees, graphs can have cycles, disconnected components, and edges with weights.

#### Types of Graphs
| Type         | Description                                               |
|--------------|-----------------------------------------------------------|
| Directed     | Edges have direction (one-way streets)                    |
| Undirected   | Edges are bidirectional (two-way streets)                 |
| Weighted     | Edges carry a numeric value (cost, distance, time)        |
| Unweighted   | All edges are equal                                       |
| DAG          | Directed Acyclic Graph — no cycles, used in scheduling    |
| Connected    | Every node is reachable from every other node             |
| Bipartite    | Nodes split into two sets with edges only between sets    |

#### Graph Representations

**Adjacency List:**
- Each node stores a list of its neighbors
- Space: O(V + E)
- Best for sparse graphs

**Adjacency Matrix:**
- 2D array where `matrix[i][j] = 1` means edge from i to j
- Space: O(V²)
- Best for dense graphs or when edge existence check is frequent

#### Graph Traversals

**BFS (Breadth-First Search):**
- Uses a queue
- Explores all neighbors at current depth before going deeper
- Finds shortest path in unweighted graphs
- Time: O(V + E) | Space: O(V)

**DFS (Depth-First Search):**
- Uses a stack (or recursion)
- Explores as deep as possible before backtracking
- Used for cycle detection, topological sort, connected components
- Time: O(V + E) | Space: O(V)

#### Key Graph Algorithms
- **Topological Sort:** DFS-based ordering of a DAG — used in build systems, course scheduling
- **Cycle Detection:** DFS with visited states (white/grey/black)
- **Connected Components:** BFS/DFS from each unvisited node
- **Bipartite Check:** 2-color BFS

#### Key Interview Problems
- Number of Islands
- Clone Graph
- Course Schedule (Topological Sort)
- Pacific Atlantic Water Flow
- Word Ladder
- Alien Dictionary
- Network Delay Time

---

### 13. Disjoint Set (Union-Find)

#### What It Is
A data structure that tracks elements partitioned into disjoint (non-overlapping) sets. Supports two operations efficiently:
- **Find:** Which set does this element belong to?
- **Union:** Merge two sets together

#### Optimizations
- **Path Compression:** During Find, flatten the tree by pointing nodes directly to root — amortizes to nearly O(1)
- **Union by Rank:** Always attach smaller tree under larger — keeps tree shallow

#### Complexity (with both optimizations)
| Operation | Time Complexity        |
|-----------|------------------------|
| Find      | O(a(n)) ≈ O(1)         |
| Union     | O(a(n)) ≈ O(1)         |

a(n) is the inverse Ackermann function — practically constant for all realistic n.

#### When to Use
- Detecting cycles in undirected graphs
- Kruskal's MST algorithm
- Grouping connected components
- Percolation problems

#### Key Interview Problems
- Number of Provinces
- Redundant Connection
- Accounts Merge
- Most Stones Removed with Same Row or Column

---

### 14. Segment Trees

#### What It Is
A binary tree used for storing information about intervals or segments of an array. Allows both range queries and point updates in O(log n).

#### Structure
- Leaf nodes store array elements
- Internal nodes store aggregate values (sum, min, max) of their range
- Built in O(n), stored in array of size 4n

#### Operations & Complexity
| Operation    | Time Complexity |
|--------------|-----------------|
| Build        | O(n)            |
| Range Query  | O(log n)        |
| Point Update | O(log n)        |

#### When to Use
- Range sum / range minimum / range maximum queries on mutable arrays
- Count of elements in a range
- More powerful than prefix sums when updates are frequent

---

### 15. Fenwick Tree (Binary Indexed Tree)

#### What It Is
A simpler alternative to Segment Trees for prefix sum queries with point updates. Uses clever bit manipulation to navigate parent-child relationships.

#### Operations & Complexity
| Operation    | Time Complexity |
|--------------|-----------------|
| Build        | O(n log n)      |
| Prefix Query | O(log n)        |
| Point Update | O(log n)        |

**Space Complexity:** O(n) — very memory-efficient

#### When to Use
- Prefix sum with dynamic updates
- Count inversions in an array
- 2D prefix sums

---

## Algorithms

---

### Sorting Algorithms

#### Bubble Sort
Repeatedly swap adjacent elements that are out of order. After each pass, the largest unsorted element bubbles to its correct position.
- **Best:** O(n) with early termination flag
- **Average/Worst:** O(n²)
- **Space:** O(1) | **Stable:** Yes
- **Use When:** Educational purposes only; never in production

#### Selection Sort
Find the minimum element in the unsorted portion and place it at the beginning. Repeat.
- **All Cases:** O(n²)
- **Space:** O(1) | **Stable:** No
- **Use When:** When writes are expensive (minimizes swaps to n)

#### Insertion Sort
Build a sorted portion one element at a time. Take each new element and insert it into the correct position.
- **Best:** O(n) | **Average/Worst:** O(n²)
- **Space:** O(1) | **Stable:** Yes
- **Use When:** Small arrays (n < 20) or nearly sorted data — very fast in practice

#### Merge Sort
Divide the array in half, recursively sort each half, then merge them.
- **All Cases:** O(n log n)
- **Space:** O(n) | **Stable:** Yes
- **Use When:** Linked list sorting, external sorting (data doesn't fit in RAM), when stability is required

#### Quick Sort
Choose a pivot. Partition the array so elements less than pivot are on the left, greater on the right. Recursively sort both partitions.
- **Best/Average:** O(n log n) | **Worst:** O(n²) with bad pivot
- **Space:** O(log n) | **Stable:** No
- **Use When:** General-purpose in-memory sorting — fastest in practice (good cache behavior)
- **Avoid:** When worst case O(n²) is unacceptable; use randomized pivot or 3-way partition

#### Heap Sort
Build a max-heap from the array. Repeatedly extract the maximum to the end.
- **All Cases:** O(n log n)
- **Space:** O(1) | **Stable:** No
- **Use When:** When guaranteed O(n log n) with O(1) space is required

#### Counting Sort
Count occurrences of each value and reconstruct the sorted array.
- **Time:** O(n + k) where k = range of values | **Space:** O(k)
- **Stable:** Yes
- **Use When:** Values are integers in a small, known range

#### Radix Sort
Sort by individual digits/characters from least significant to most significant.
- **Time:** O(d x (n + k)) where d = number of digits | **Space:** O(n + k)
- **Stable:** Yes
- **Use When:** Sorting integers or fixed-length strings with small digit range

### Sorting Comparison Table

| Algorithm      | Best       | Average    | Worst      | Space    | Stable |
|----------------|------------|------------|------------|----------|--------|
| Bubble Sort    | O(n)       | O(n²)      | O(n²)      | O(1)     | Yes    |
| Selection Sort | O(n²)      | O(n²)      | O(n²)      | O(1)     | No     |
| Insertion Sort | O(n)       | O(n²)      | O(n²)      | O(1)     | Yes    |
| Merge Sort     | O(n log n) | O(n log n) | O(n log n) | O(n)     | Yes    |
| Quick Sort     | O(n log n) | O(n log n) | O(n²)      | O(log n) | No     |
| Heap Sort      | O(n log n) | O(n log n) | O(n log n) | O(1)     | No     |
| Counting Sort  | O(n + k)   | O(n + k)   | O(n + k)   | O(k)     | Yes    |
| Radix Sort     | O(nk)      | O(nk)      | O(nk)      | O(n + k) | Yes    |

---

### Searching Algorithms

#### Linear Search
Scan each element until the target is found.
- **Time:** O(n) | **Space:** O(1)
- **Use When:** Unsorted data or very small arrays

#### Binary Search
In a sorted array, repeatedly compare the target with the middle element and eliminate half the search space.
- **Time:** O(log n) | **Space:** O(1) iterative / O(log n) recursive
- **Prerequisite:** Array must be sorted

**Classic Binary Search Template:**
```
left = 0, right = n - 1
while left <= right:
    mid = left + (right - left) / 2   <- avoids overflow
    if arr[mid] == target: return mid
    elif arr[mid] < target: left = mid + 1
    else: right = mid - 1
return -1
```

**Binary Search Variants:**
- **Lower bound:** First position where value >= target
- **Upper bound:** First position where value > target
- **Search on answer:** Binary search on the answer space (e.g., find minimum speed, maximum capacity)

#### Key Interview Problems
- Search in Rotated Sorted Array
- Find Minimum in Rotated Sorted Array
- Koko Eating Bananas (Search on Answer)
- Find Peak Element
- Median of Two Sorted Arrays

---

### Graph Algorithms

#### Dijkstra's Algorithm — Single Source Shortest Path (Non-Negative Weights)
Uses a min-heap to greedily explore the nearest unvisited node. Updates shortest distances to neighbors.
- **Time:** O((V + E) log V) with binary heap | **Space:** O(V)
- **Limitation:** Does not work with negative weight edges

#### Bellman-Ford — Single Source Shortest Path (With Negative Weights)
Relax all edges V-1 times. On the Vth iteration, if any edge can still be relaxed, a negative cycle exists.
- **Time:** O(V x E) | **Space:** O(V)
- **Use When:** Graph may have negative edges; need to detect negative cycles

#### Floyd-Warshall — All-Pairs Shortest Path
Dynamic programming over all intermediate nodes.
- **Time:** O(V³) | **Space:** O(V²)
- **Use When:** Small graph, need shortest path between all pairs

#### Kruskal's Algorithm — Minimum Spanning Tree
Sort all edges by weight. Use Union-Find to add the smallest edge that doesn't form a cycle.
- **Time:** O(E log E) | **Space:** O(V)

#### Prim's Algorithm — Minimum Spanning Tree
Greedily grow MST from a start node by always adding the cheapest edge connecting the MST to a new vertex.
- **Time:** O((V + E) log V) with binary heap | **Space:** O(V)

#### Topological Sort (Kahn's Algorithm — BFS)
Track in-degrees. Enqueue all nodes with in-degree 0. Process node, reduce neighbors' in-degrees; enqueue those that reach 0.
- **Time:** O(V + E) | **Space:** O(V)
- **Use When:** Ordering tasks with dependencies (course schedule, build order)

---

### Dynamic Programming

#### What It Is
DP solves complex problems by breaking them into overlapping subproblems, solving each once, and storing results to avoid recomputation.

#### When to Apply DP
Look for these signals:
1. Problem asks for optimal value (max/min) or count of ways
2. Problem has **overlapping subproblems** (same subproblem computed multiple times in recursion)
3. Problem has **optimal substructure** (optimal solution built from optimal sub-solutions)

#### Approaches

**Top-Down (Memoization):**
- Write recursive solution naturally
- Cache results in a hashmap/array
- Avoids computing the same subproblem twice

**Bottom-Up (Tabulation):**
- Identify base cases
- Fill a table iteratively from smallest subproblems to largest
- Usually more space-efficient and avoids recursion overhead

#### Classic DP Patterns & Problems

| Pattern              | Example Problems                                   |
|----------------------|----------------------------------------------------|
| 1D DP                | Climbing Stairs, House Robber, Fibonacci           |
| 2D Grid DP           | Unique Paths, Minimum Path Sum                     |
| Knapsack             | 0/1 Knapsack, Partition Equal Subset Sum           |
| Unbounded Knapsack   | Coin Change, Rod Cutting                           |
| Longest Common Subseq| LCS, Edit Distance, Longest Palindromic Subsequence|
| Longest Increasing   | LIS, Russian Doll Envelopes                        |
| Interval DP          | Matrix Chain Multiplication, Burst Balloons        |
| String DP            | Wildcard Matching, Regular Expression Matching     |
| State Machine DP     | Best Time to Buy/Sell with Cooldown                |

---

### Greedy Algorithms

#### What It Is
Greedy algorithms make the locally optimal choice at each step, hoping it leads to the globally optimal solution. Unlike DP, greedy does not backtrack.

#### When It Works
Greedy works when the problem has:
- **Greedy Choice Property:** A global optimum can be reached by making locally optimal choices
- **Optimal Substructure:** Optimal solution contains optimal solutions to subproblems

#### Classic Greedy Problems
- Activity Selection (Maximum non-overlapping intervals)
- Fractional Knapsack
- Huffman Encoding (Optimal prefix codes)
- Jump Game
- Gas Station
- Candy (minimum candy distribution)

---

### Backtracking

#### What It Is
Backtracking is a brute-force search with pruning. It builds candidates incrementally and abandons a candidate ("backtracks") as soon as it determines the candidate cannot lead to a valid solution.

#### Template
```
def backtrack(state, choices):
    if is_solution(state):
        record(state)
        return
    for choice in choices:
        if is_valid(state, choice):
            make(choice, state)
            backtrack(state, remaining_choices)
            undo(choice, state)      <- backtrack step
```

#### Classic Backtracking Problems
- Subsets / Power Set
- Permutations
- Combinations
- N-Queens
- Sudoku Solver
- Word Search (DFS on grid)
- Palindrome Partitioning

---

### Divide and Conquer

#### What It Is
Divide the problem into smaller subproblems of the same type, solve them recursively, and combine their solutions.

**Steps:**
1. **Divide:** Break problem into independent subproblems
2. **Conquer:** Solve each subproblem recursively
3. **Combine:** Merge results

#### Classic Examples
- Merge Sort, Quick Sort
- Binary Search
- Maximum Subarray (Kadane's can also be done D&C)
- Count Inversions
- Closest Pair of Points
- Matrix Multiplication (Strassen's)

---

### Two Pointers & Sliding Window

#### Two Pointers
Use two indices that move through the array, typically starting from opposite ends or moving in the same direction at different speeds.

**Use Cases:**
- Sorted array pair sum
- Removing duplicates in-place
- Partitioning (Quick Sort)
- Palindrome checking
- Container With Most Water

#### Sliding Window
Maintain a window (subarray) of variable or fixed size that slides across the array. Expand right pointer to add elements; shrink left pointer to remove.

**Fixed Size Window:** Move both pointers in lockstep.
**Variable Size Window:** Expand right always; shrink left when constraint violated.

**Use Cases:**
- Longest substring with at most K distinct characters
- Minimum size subarray sum
- Maximum sum of subarray of size K
- Permutation in String

---

### Bit Manipulation

#### Essential Operations

| Operation        | Expression        | Effect                              |
|------------------|-------------------|-------------------------------------|
| Check bit i      | `n & (1 << i)`    | Non-zero if bit i is set            |
| Set bit i        | `n OR (1 << i)`   | Sets bit i to 1                     |
| Clear bit i      | `n & ~(1 << i)`   | Sets bit i to 0                     |
| Toggle bit i     | `n ^ (1 << i)`    | Flips bit i                         |
| Clear lowest set | `n & (n - 1)`     | Removes the lowest set bit          |
| Isolate lowest   | `n & (-n)`        | Keeps only the lowest set bit       |
| Count set bits   | Brian Kernighan   | Loop: n = n & (n-1), count steps    |
| XOR trick        | `a ^ a = 0`       | Cancels out duplicates              |
| Power of 2 check | `n & (n-1) == 0`  | True if n is a power of 2           |

#### Key Interview Problems
- Single Number (XOR trick)
- Number of 1 Bits (Hamming Weight)
- Reverse Bits
- Missing Number
- Sum of Two Integers Without +
- Counting Bits

---

## Problem-Solving Patterns

| Pattern               | Trigger Signal                                      | Data Structure / Approach      |
|-----------------------|-----------------------------------------------------|-------------------------------|
| Two Pointers          | Sorted array, pairs, palindromes                    | Two indices                   |
| Sliding Window        | Substring/subarray with constraint                  | Left/right pointers           |
| Fast & Slow Pointers  | Cycle detection, middle of list                     | Linked list / array           |
| Merge Intervals       | Overlapping intervals                               | Sort + greedy merge           |
| Cyclic Sort           | Numbers in range [1, n]                             | In-place placement            |
| Tree BFS              | Level-order, shortest path in tree                  | Queue                         |
| Tree DFS              | Path sum, subtree problems                          | Stack / recursion             |
| Topological Sort      | Dependency ordering, DAG                            | BFS + in-degree               |
| Binary Search         | Sorted structure, monotonic function                | Divide and conquer            |
| Heap / Top-K          | Kth element, streaming data                         | Min/Max heap                  |
| Backtracking          | Enumerate all possibilities                         | Recursion + undo              |
| Dynamic Programming   | Optimal value, count ways, overlapping subproblems  | Memoization / tabulation      |
| Union-Find            | Grouping, cycle detection                           | Disjoint Set                  |
| Monotonic Stack       | Next greater/smaller element                        | Stack maintaining order       |
| Bit Manipulation      | XOR patterns, subsets, powers of 2                  | Bitwise operations            |

---

## Interview Cheat Sheet

### Before You Code
1. Repeat the problem in your own words
2. Clarify constraints (size, value range, sorted?, null?)
3. State your approach and time/space complexity before coding
4. Start with a brute force if unsure; then optimize

### Common Complexity Targets
| Input Size (n)  | Expected Complexity |
|-----------------|---------------------|
| <= 10           | O(n!) or O(2ⁿ)      |
| <= 20           | O(2ⁿ) or O(n².2ⁿ)  |
| <= 500          | O(n³)               |
| <= 5,000        | O(n²)               |
| <= 10⁶          | O(n log n) or O(n)  |
| <= 10⁸          | O(n) or O(log n)    |

### Choosing the Right Data Structure
| Requirement                       | Use                  |
|-----------------------------------|----------------------|
| Fast lookup by key                | Hash Map             |
| Sorted order + fast lookup        | BST / TreeMap        |
| LIFO order                        | Stack                |
| FIFO order                        | Queue                |
| Min/Max in O(1)                   | Heap                 |
| Prefix string match               | Trie                 |
| Range queries on mutable array    | Segment Tree / BIT   |
| Grouping / cycle detection        | Union-Find           |

---

## Repo Structure

```
dsa/
├── README.md                     <- This file
├── arrays/
│   ├── notes.md
│   ├── two_sum.py
│   └── maximum_subarray.py
├── linked-lists/
│   ├── notes.md
│   └── reverse_linked_list.py
├── stacks-queues/
│   ├── notes.md
│   └── valid_parentheses.py
├── trees/
│   ├── notes.md
│   ├── binary_tree_traversals.py
│   └── lowest_common_ancestor.py
├── graphs/
│   ├── notes.md
│   ├── bfs.py
│   ├── dfs.py
│   └── dijkstra.py
├── dynamic-programming/
│   ├── notes.md
│   ├── knapsack.py
│   └── longest_common_subsequence.py
├── sorting/
│   ├── notes.md
│   └── all_sorts.py
└── bit-manipulation/
    ├── notes.md
    └── bit_tricks.py
```

Each topic folder contains:
- `notes.md` — Concept, complexity, and patterns
- Implementation files — Working solutions with comments
- Edge case notes — Boundary conditions and gotchas

---

## Resources

### Books
- *Introduction to Algorithms* (CLRS) — Cormen et al. — The definitive reference
- *Cracking the Coding Interview* — Gayle Laakmann McDowell — Interview-focused
- *Algorithm Design* — Kleinberg & Tardos — Theory with intuition
- *The Algorithm Design Manual* — Skiena — Practical and accessible

### Online Practice
- [LeetCode](https://leetcode.com) — Industry-standard interview prep
- [Codeforces](https://codeforces.com) — Competitive programming
- [GeeksforGeeks](https://www.geeksforgeeks.org) — Explanations and examples
- [NeetCode.io](https://neetcode.io) — Structured roadmap + video explanations
- [CP-Algorithms](https://cp-algorithms.com) — Deep competitive programming reference

### Visualizations
- [Visualgo](https://visualgo.net) — Interactive algorithm visualizations
- [Algorithm Visualizer](https://algorithm-visualizer.org) — Step-by-step code tracing

### Courses
- [MIT 6.006 Algorithms](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/) — Free MIT lectures
- [Princeton Algorithms (Coursera)](https://www.coursera.org/learn/algorithms-part1) — Robert Sedgewick
- [Stanford Algorithms (Coursera)](https://www.coursera.org/specializations/algorithms) — Tim Roughgarden

---

## Contributing

Contributions are welcome and encouraged!

### How to Contribute
1. Fork the repository
2. Create a feature branch: `git checkout -b feature/topic-name`
3. Add notes, implementations, or problem solutions
4. Commit with a meaningful message: `git commit -m "Add: heap sort notes and implementation"`
5. Push your branch and open a Pull Request

### Contribution Guidelines
- Follow the existing folder structure
- Include time and space complexity in all solutions
- Add comments explaining the approach, not just the code
- One file per problem/concept where possible
- Test edge cases before submitting

---

> Made with love for every developer on the DSA journey. Star the repo if it helped you!
